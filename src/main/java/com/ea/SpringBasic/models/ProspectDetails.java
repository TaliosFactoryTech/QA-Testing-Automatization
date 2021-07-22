package com.ea.SpringBasic.models;

import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
public class ProspectDetails {

    private Prospect prospect;

    public Prospect getProspect(){
        return prospect;
    }

    public void setProspect(Prospect prospect){
        this.prospect = prospect;
    }

}
