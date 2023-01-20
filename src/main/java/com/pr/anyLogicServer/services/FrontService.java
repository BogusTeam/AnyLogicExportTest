package com.pr.anyLogicServer.services;

import com.pr.anyLogicServer.data.AnyLogicSettings;
import com.pr.anyLogicServer.models.AnyLogicData;
import com.pr.anyLogicServer.repositories.AnyLogicDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrontService {
    @Autowired
    private AnyLogicDataRepository anyLogicDataRepository;

    @Autowired
    private AnyLogicSettings anyLogicSettings;

    public AnyLogicSettings getSettings() {
        return anyLogicSettings;
    }

    public void setScenario(int scenario) {
        anyLogicSettings.setScenarioNumber(scenario);
    }

    public void setTerminals(int quantity) {
        anyLogicSettings.setTerminalQuantity(quantity);
    }

    public void setVisitors(double quantity) {
        anyLogicSettings.setPaceOfVisitors(quantity);
    }

    public List<AnyLogicData> getDataByScenario(int scenario) {
        return anyLogicDataRepository.findByScenario_number(scenario);
    }

    public List<Integer> getAllScenarios() {
        return anyLogicDataRepository.selectAllScenarioNumbers();
    }
}
