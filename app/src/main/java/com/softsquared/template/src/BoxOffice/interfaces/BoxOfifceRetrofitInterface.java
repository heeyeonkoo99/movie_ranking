package com.softsquared.template.src.BoxOffice.interfaces;

import com.softsquared.template.src.BoxOffice.models.BoxOfficeResponse;
import com.softsquared.template.src.main.models.DefaultResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BoxOfifceRetrofitInterface {

    @GET("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    @Headers("Content-Type: application/json")
    Call<BoxOfficeResponse> getBoxOffice(@Query("key")String key,@Query("targetDt")String targetDt);


}
