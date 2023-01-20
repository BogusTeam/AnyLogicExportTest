package com.pr.anyLogicServer.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "data")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnyLogicData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id", nullable = false)
    private long id;

    private int sim_year;
    private int scenario_number;
    private long cust_served;
    private long cust_refused;
    private int terminals;
}
