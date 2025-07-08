
package com.example.finalproject.model.alljobs;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Certification implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("abbreviation")
    @Expose
    private String abbreviation;
    @SerializedName("name")
    @Expose
    private String name;
    private final static long serialVersionUID = -3008529229343835016L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
