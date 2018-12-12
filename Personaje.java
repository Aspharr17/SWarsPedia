package com.example.aspha.swarspedia.Models;

public class Personaje {
    private String name;
    private String birth_year;
    private String gender;

    public Personaje(String name, String birth_year, String gender){
        this.setName(name);
        this.setBirth_year(birth_year);
        this.setGender(gender);


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

