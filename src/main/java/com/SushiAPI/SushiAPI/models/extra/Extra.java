package com.SushiAPI.SushiAPI.models.extra;

public class Extra{
    private String name;

    public Extra( String name) {

        this.name = name.toLowerCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    // to String
    @Override
    public String toString() {
        return "Extra{" +
                "name='" + name + '\'' +
                '}';
    }
}
