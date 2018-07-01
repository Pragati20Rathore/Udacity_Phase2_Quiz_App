package com.google.udacity.quiz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Quiz {

    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("option")
    @Expose
    private List<String> option;
    @SerializedName("answer")
    @Expose
    private String answer;

    private MultipleItem.ItemType type;

    public MultipleItem.ItemType getType() {
        return type;
    }

    public void setType(MultipleItem.ItemType type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOption() {
        return option;
    }

    public void setOption(List<String> option) {
        this.option = option;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
