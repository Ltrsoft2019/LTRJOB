package com.ltrsoft.ltrjob.Classes;

import java.io.Serializable;

public class PlanClass implements Serializable {
    String plan_price,plan_feature,cplan_name;

    public String getPlan_price() {
        return plan_price;
    }

    public void setPlan_price(String plan_price) {
        this.plan_price = plan_price;
    }

    public String getPlan_feature() {
        return plan_feature;
    }

    public void setPlan_feature(String plan_feature) {
        this.plan_feature = plan_feature;
    }

    public String getCplan_name() {
        return cplan_name;
    }

    public void setCplan_name(String cplan_name) {
        this.cplan_name = cplan_name;
    }

    public PlanClass(String plan_price, String plan_feature, String cplan_name) {
        this.plan_price = plan_price;
        this.plan_feature = plan_feature;
        this.cplan_name = cplan_name;
    }
}
