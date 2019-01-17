package com.angualr.StatisticSaver.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Pages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "page_id")
    private Long id;

    @Column(name = "page_name")
    private String pageName;

    @Column(name = "time_spent")
    private String timeSpent;

    @Column(name = "number_of_usages")
    private Long numberOfUsage;

}
