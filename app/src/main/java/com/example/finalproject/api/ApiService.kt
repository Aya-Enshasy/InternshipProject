package com.example.finalproject.api

import com.example.finalproject.model.alljobs.AllJobs;
import com.example.finalproject.model.faqs.Faqs
import com.example.finalproject.model.policies.Policies

import retrofit2.Response;
import retrofit2.http.GET;

interface ApiService {
    @GET("job-seeker/all-jobs")
    suspend fun getAllJobs(): Response<AllJobs>

    @GET("faqs")
    suspend fun getFaqs(): Response<Faqs>

    @GET("policies")
    suspend fun getPolicies(): Response<Policies>

    @GET("job-seeker/all-jobs/{id}")
    suspend fun getJobsDetails(): Response<AllJobs>
}