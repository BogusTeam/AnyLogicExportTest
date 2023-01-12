package com.pr;

import com.xj.anylogic.engine.Engine;
import modeldb.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StartService {

    public StartService() throws Exception {
        Random rand = new Random(System.currentTimeMillis());
        CustomExperiment s = new CustomExperiment(null);
        Engine d = s.createEngine();
        d.setDefaultRandomGenerator(rand);
        Main m = new Main(d, null, null);
        m.setParametersToDefaultValues();
        m.setDefaultRandomGenerator(rand);
        d.start(m);
        Date date = new Date();
        Calendar date2 = Calendar.getInstance();
        date2.setTime(date);
        date2.add(Calendar.YEAR, 30); // Добавляем 30 лет
        Date stop_date = date2.getTime();
        d.setStartDate(date); //Текущая дата
        d.setStopDate(stop_date); //Текущая дата + 30 лет
        d.setRealTimeMode(false);
        m.Сценарий = 1;
        m.Количество_терминалов = 200;
        m.Темп_посещения = 150;
        while (d.getTime()< 30) { // d.date().before(d.getStopDate())
            d.step(); //Запускаем новый поток (пошаговый прогон модели)
        }
        d.stop();
    }

}
