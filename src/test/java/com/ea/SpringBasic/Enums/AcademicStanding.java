package com.ea.SpringBasic.Enums;

public enum AcademicStanding {
    FirstYearStudent("First-Year Student"),
    Sophomore("Sophomore"),
    Junior("Junior"),
    Senior("Senior"),
    GradStudent("Grad Student");

    private String name;

    private AcademicStanding(String s){
        name = s;
    }

    public String getName(){
        return this.name();
    }

}
