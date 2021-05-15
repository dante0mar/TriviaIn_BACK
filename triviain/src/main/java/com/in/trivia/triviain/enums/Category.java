package com.in.trivia.triviain.enums;

public enum Category {
    HISTORY("History"),
    SCIENCE("Science"),
    ENTERTAINMENT("Entertainment"),
    HEALTH("Health"),
    OTHER("Other kind");

    private String name;

    Category(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
