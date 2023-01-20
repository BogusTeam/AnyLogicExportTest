package com.pr.anyLogicServer.services;

import com.pr.anyLogicServer.data.AnyLogicSettings;
import com.xj.anylogic.engine.Engine;
import com.xj.anylogic.engine.connectivity.Database;
import modeldb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StartAnyLogicService {
    @Autowired
    private AnyLogicSettings anyLogicSettings;

    public void startAnyLogicService() {
        Random rand = new Random(System.currentTimeMillis());
        CustomExperiment s = new CustomExperiment(null);
        Engine d = s.createEngine();
        d.setDefaultRandomGenerator(rand);
        Main m = new Main(d, null, null);
        m.database = new Database(m, "database", "org.postgresql.Driver", "jdbc:postgresql://192.168.100.35:5432/AnyLogicDB", "postgres", new char[]{'p', 'a', 's', 's'});
        m.setParametersToDefaultValues();
        m.setDefaultRandomGenerator(rand);
        d.start(m);
        Date date = new Date();
        Calendar date2 = Calendar.getInstance();
        date2.setTime(date);
        date2.add(Calendar.DAY_OF_WEEK, 8); // Добавляем 8 Дней
        Date stop_date = date2.getTime();
        d.setTimeUnit(60 * 1000L);
        d.setStartDate(date); //Текущая дата
        d.setStopDate(stop_date); //Текущая дата + 30 лет
        d.setRealTimeMode(false);
        m.Сценарий = anyLogicSettings.getScenarioNumber();
        m.Количество_терминалов = anyLogicSettings.getTerminalQuantity();
        m.Темп_посещения = anyLogicSettings.getPaceOfVisitors();
        while (d.date().before(d.getStopDate())) {
            d.step(); //Запускаем новый поток (пошаговый прогон модели)
        }
        d.stop();
    }

}
