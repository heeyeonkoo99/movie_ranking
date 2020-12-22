package com.softsquared.template.src.BoxOffice.interfaces;

import com.softsquared.template.src.BoxOffice.models.BoxOfficeResponse;

public interface BoxOfficeActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void SuccessBoxOffice(BoxOfficeResponse boxOfficeResponse);
}
