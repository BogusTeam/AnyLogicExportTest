package com.pr.anyLogicServer.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class AnyLogicSettings {
    private int scenarioNumber = 0;
    private int terminalQuantity = 10;
    private double paceOfVisitors = 0.25;
}
