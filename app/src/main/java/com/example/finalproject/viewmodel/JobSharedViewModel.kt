package com.example.finalproject.viewmodel

import androidx.lifecycle.ViewModel
import com.example.finalproject.model.alljobs.AllJobsData

class JobSharedViewModel : ViewModel() {
    var selectedJob: AllJobsData? = null

    fun setJob(job: AllJobsData) {
        selectedJob = job
    }
}
