package com.ssh.sustain.api.service;

import retrofit2.Call;
import retrofit2.http.POST;

public interface SampleAPI {

    @POST(value = "sample")
    Call<String> sample();

}
