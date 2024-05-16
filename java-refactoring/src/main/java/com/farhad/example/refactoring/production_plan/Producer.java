package com.farhad.example.refactoring.production_plan;

import com.farhad.example.refactoring.production_plan.Doc.DocProducer;

import lombok.Getter;
import lombok.Setter;

public class Producer {

    @Getter
    private Province province;

    @Setter
    @Getter
    private String name;
    @Getter
    private int cost;
    @Getter
    private int production;

    public Producer(Province province, DocProducer data) {
        this.province = province;
        this.cost = data.getCost();
        this.name = data.getName();
        this.production = data.getProduction() == null ? 0 : data.getProduction();
    }

    public void setCost(String cost) {
        this.cost = Integer.parseInt(cost);
    }

    public void setProduction(String amountStr) {
        int newProduction = 0;
        try {
            int amount = Integer.parseInt(amountStr);
            newProduction = amount;
        } catch (NumberFormatException e) {
            newProduction = 0;
        }

        this.province.setTotalProduction(this.getProvince().getTotalProduction() + (newProduction - this.production));
        this.production = newProduction;
    }

}
