package com.example.stat1kdevvk.rest.api;

import com.example.stat1kdevvk.rest.model.response.BaseItemResponse;
import com.example.stat1kdevvk.rest.model.response.Full;
import com.example.stat1kdevvk.rest.model.response.GetWallResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface WallApi {

    @GET(ApiMethods.WALL_GET)
    Call<GetWallResponse> get(@QueryMap Map<String, String> map);
}
