package web.models;

import javax.persistence.Entity;

public enum Sex {
    MALE("male"), FEMALE("female");
    String sex;

    Sex(String s) {
        this.sex = s;
    }
}
