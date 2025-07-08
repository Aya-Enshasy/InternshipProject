
package com.example.finalproject.model.policies;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message implements Serializable
{

    @SerializedName("message")
    @Expose
    private String message;
    private final static long serialVersionUID = 9076133991500509280L;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
