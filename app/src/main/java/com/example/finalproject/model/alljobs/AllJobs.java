
package com.example.finalproject.model.alljobs;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllJobs implements Serializable
{

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private Message message;
    @SerializedName("data")
    @Expose
    private List<AllJobsData> data;
    private final static long serialVersionUID = 2420749105326478687L;

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

    public List<AllJobsData> getData() {
        return data;
    }

    public void setData(List<AllJobsData> data) {
        this.data = data;
    }

}
