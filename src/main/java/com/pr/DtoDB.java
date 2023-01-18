package com.pr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoDB {
    private int sim_year;
    private int scenario_number;
    private long cust_served;
    private long cust_refused;
    private int terminals;
}
