package com.example.myapplicationiipertemuan9.repository.callback;

import com.example.myapplicationiipertemuan9.models.HomePlaying;
import java.util.*;
public interface OnMovieDetailCallback {
    void onSuccess(HomePlaying homePlaying, String message);

    void onFailure(String message);
}
