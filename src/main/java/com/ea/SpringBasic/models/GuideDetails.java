package com.ea.SpringBasic.models;

import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
public class GuideDetails {

    private Guide guide;

    public Guide getGuide(){ return guide; }

    public void setGuide(Guide guide) {this.guide = guide; }}
