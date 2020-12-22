package com.softsquared.template.src.BoxOffice;

import com.softsquared.template.src.BoxOffice.interfaces.BoxOfficeActivityView;
import com.softsquared.template.src.BoxOffice.interfaces.BoxOfifceRetrofitInterface;
import com.softsquared.template.src.BoxOffice.models.BoxOfficeResponse;
import com.softsquared.template.src.main.interfaces.MainActivityView;
import com.softsquared.template.src.main.interfaces.MainRetrofitInterface;
import com.softsquared.template.src.main.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.getRetrofit;

class BoxOfficeService {
    private final BoxOfficeActivityView boxOfficeActivityView;

    BoxOfficeService(final BoxOfficeActivityView boxOfficeActivityView) {
        this.boxOfficeActivityView = boxOfficeActivityView;
    }

    void getBoxOffice() {
        final BoxOfifceRetrofitInterface boxOfifceRetrofitInterface = getRetrofit().create(BoxOfifceRetrofitInterface.class);
        boxOfifceRetrofitInterface.getBoxOffice("1f4f589733d8c51d19feafcf31869a89","20201027").enqueue(new Callback<BoxOfficeResponse>() {




            @Override
            public void onResponse(Call<BoxOfficeResponse> call, Response<BoxOfficeResponse> response) {
                final BoxOfficeResponse boxOfficeResponse = response.body();
                if (boxOfficeResponse == null) {
                    boxOfficeActivityView.validateFailure(null);
                    return;
                }

                boxOfficeActivityView.SuccessBoxOffice(boxOfficeResponse);

                System.out.println("d");

//                boxOfficeActivityView.validateSuccess(boxOfficeResponse.getMessage());
            }

            @Override
            public void onFailure(Call<BoxOfficeResponse> call, Throwable t) {
                boxOfficeActivityView.validateFailure(null);
                System.out.println(t.getMessage());
                System.out.println("");
            }
        });
    }
}
