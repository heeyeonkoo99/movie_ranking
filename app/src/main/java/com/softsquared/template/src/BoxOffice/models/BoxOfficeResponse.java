package com.softsquared.template.src.BoxOffice.models;

import com.google.gson.annotations.Expose;

public class BoxOfficeResponse {
    @Expose
    private BoxOfficeResult boxOfficeResult;

    public BoxOfficeResult getBoxOfficeResult() {
        return boxOfficeResult;
    }

    public void setBoxOfficeResult(BoxOfficeResult boxOfficeResult) {
        this.boxOfficeResult = boxOfficeResult;
    }

}
