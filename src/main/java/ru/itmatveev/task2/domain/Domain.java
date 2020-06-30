package ru.itmatveev.task2.domain;

import lombok.Data;

@Data
public class Domain {
    private String id;
    private String charCode;
    private String name;
    private String value;

    public Domain(String id, String charCode, String name, String value) {
        this.id = id;
        this.charCode = charCode;
        this.name = name;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
