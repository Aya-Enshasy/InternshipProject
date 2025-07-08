
package com.example.finalproject.model.faqs;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Faqs implements Serializable
{

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private Message message;
    @SerializedName("data")
    @Expose
    private List<FaqsData> data;
    private final static long serialVersionUID = 3236413986797438639L;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public List<FaqsData> getData() {
        return data;
    }

    public void setData(List<FaqsData> data) {
        this.data = data;
    }

}
