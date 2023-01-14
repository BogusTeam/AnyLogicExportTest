package com.pr;

import lombok.Data;

@Data
public class DtoDB {
    private int sim_year;
    private int scenario_number;
    private long cust_served;
    private long cust_refused;
    private int terminals;
}
