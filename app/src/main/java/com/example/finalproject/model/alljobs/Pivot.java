
package com.example.finalproject.model.alljobs;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pivot implements Serializable
{

    @SerializedName("job_id")
    @Expose
    private Integer jobId;
    @SerializedName("skill_id")
    @Expose
    private Integer skillId;
    private final static long serialVersionUID = 7128174980365682574L;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

}
