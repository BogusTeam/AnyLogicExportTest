package com.pr.anyLogicServer.controllers;

import com.pr.anyLogicServer.data.AnyLogicSettings;
import com.pr.anyLogicServer.models.AnyLogicData;
import com.pr.anyLogicServer.services.FrontService;
import com.pr.anyLogicServer.services.StartAnyLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class FrontController {
    @Autowired
    private FrontService frontService;

    @Autowired
    private StartAnyLogicService startAnyLogicService;

    @PostMapping(value = "/start")
    public String setTerminals(@RequestBody MultiValueMap<String, String> formData
//            @RequestPart("terminals") int terminals,
//            @RequestPart("visitors") double visitors,
//            @RequestPart("scenario") int scenario
    ) {
        frontService.setTerminals(Integer.parseInt(formData.get("terminals").get(0)));
        frontService.setVisitors(Double.parseDouble(formData.get("visitors").get(0)));
        frontService.setScenario(Integer.parseInt(formData.get("scenario").get(0)));
        startAnyLogicService.startAnyLogicService();
        return "Ok";
    }

    @GetMapping("/settings")
    public AnyLogicSettings getSettings(){
        return frontService.getSettings();
    }

    @PostMapping(value = "/terminal/{quantity}")
    public String setTerminals(@PathVariable("quantity") int quantity) {
        frontService.setTerminals(quantity);
        return "Ok";
    }

    @PostMapping(value = "/visitor/{quantity}")
    public String setPaceOfVisitors(@PathVariable("quantity") double quantity) {
        frontService.setVisitors(quantity);
        return "Ok";
    }

    @GetMapping("/scenarios")
    public List<Integer> getScenarios(){
        return frontService.getAllScenarios().stream().sorted().collect(Collectors.toList());
    }

    @GetMapping("/getResults/{scenario}")
    public List<AnyLogicData> getData(@PathVariable("scenario") int scenario){
        return frontService.getDataByScenario(scenario);
    }
}
