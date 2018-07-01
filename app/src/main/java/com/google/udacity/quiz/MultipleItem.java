package com.google.udacity.quiz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MultipleItem {

    public enum ItemType {
        CHECKBOX_TYPE,
        RADIO_TYPE,
        FILL_BLANK_TYPE
    }

    @SerializedName("quiz")
    @Expose
    private List<Quiz> quiz = null;

    public List<Quiz> getQuiz() {
        return quiz;
    }

    public void setQuiz(List<Quiz> quiz) {
        this.quiz = quiz;
    }

}
