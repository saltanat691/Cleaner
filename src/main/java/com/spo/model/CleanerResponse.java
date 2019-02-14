package com.spo.model;

import lombok.Data;

@Data
public class CleanerResponse {

    private int senior;
    private int junior;

    /**
     * In every room it has to be at least one senior.
     * That's why I put it directly into constructor
     */
    public CleanerResponse() {
        this.senior = 0;
        this.junior = 0;
    }

    public void addSenior(int count) {senior += count;}

    public void addJunior(int count) {junior += count;}
}
