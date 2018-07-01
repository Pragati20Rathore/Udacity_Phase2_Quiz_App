package com.google.udacity.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IRecyclerListener {

    private RecyclerView recyclerView;
    private quizAdapter quizAdapter;
    private TextView final_score;
    private Button submit_btn;
    private int finalScore;
    private ArrayList<Quiz> listQuiz = new ArrayList<Quiz>();
    private ArrayList<String> listOptnCheckBox1 = new ArrayList<String>();
    private ArrayList<String> listOptnCheckBox2 = new ArrayList<String>();
    private ArrayList<String> listOptnCheckBox3 = new ArrayList<String>();
    private ArrayList<String> listOptnCheckBox4 = new ArrayList<String>();

    private ArrayList<String> listOptnRadioBtn1 = new ArrayList<String>();
    private ArrayList<String> listOptnRadioBtn2 = new ArrayList<String>();
    private ArrayList<String> listOptnRadioBtn3 = new ArrayList<String>();

    private ArrayList<String> correctAnswers = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.quiz_list);
        submit_btn = findViewById(R.id.submit_btn);
        final_score = findViewById(R.id.final_score);
        submit_btn.setEnabled(false);

        setDummyData();

        quizAdapter = new quizAdapter(getApplicationContext(), listQuiz, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(quizAdapter);
    }

    private void setDummyData() {
        listOptnCheckBox1.add("Google");
        listOptnCheckBox1.add("Microsoft");
        listOptnCheckBox1.add("Apple");
        listOptnCheckBox1.add("Android Inc.");

        listOptnCheckBox2.add("Open Source Web Kit");
        listOptnCheckBox2.add("Chrome");
        listOptnCheckBox2.add("Firefox");
        listOptnCheckBox2.add("Opera");

        listOptnCheckBox3.add("Apple");
        listOptnCheckBox3.add("Google");
        listOptnCheckBox3.add("No Company");
        listOptnCheckBox3.add("Nokia");

        listOptnCheckBox4.add("Linux Kernel");
        listOptnCheckBox4.add("Hybrid Kernel");
        listOptnCheckBox4.add("Windows Kernel");
        listOptnCheckBox4.add("None of the above");

        listOptnRadioBtn1.add("Yes");
        listOptnRadioBtn1.add("No");

        listOptnRadioBtn2.add("Yes");
        listOptnRadioBtn2.add("No");

        listOptnRadioBtn3.add("Yes");
        listOptnRadioBtn3.add("No");

        Quiz quizQueFirst = new Quiz();
        quizQueFirst.setType(MultipleItem.ItemType.CHECKBOX_TYPE);
        quizQueFirst.setOption(listOptnCheckBox1);
        quizQueFirst.setQuestion("1. Which company developed android? ");
        quizQueFirst.setAnswer("Google,Android Inc.");   //dummy ans only not correct
        correctAnswers.add(quizQueFirst.getAnswer());

        Quiz quizQueSec = new Quiz();
        quizQueSec.setQuestion("2. An Android SDK is required to develop the application for Android?");
        quizQueSec.setType(MultipleItem.ItemType.RADIO_TYPE);
        quizQueSec.setOption(listOptnRadioBtn1);
        quizQueSec.setAnswer("Yes");
        correctAnswers.add(quizQueSec.getAnswer());

        Quiz quizQueThird = new Quiz();
        quizQueThird.setQuestion("3. Android provides a few standard themes, listed in");
        quizQueThird.setType(MultipleItem.ItemType.FILL_BLANK_TYPE);
        quizQueThird.setOption(null);
        quizQueThird.setAnswer("R.style");
        correctAnswers.add(quizQueThird.getAnswer());

        Quiz quizQueForth = new Quiz();
        quizQueForth.setQuestion("4. What is mean by ANR");
        quizQueForth.setType(MultipleItem.ItemType.FILL_BLANK_TYPE);
        quizQueForth.setOption(null);
        quizQueForth.setAnswer("Application not Responding");
        correctAnswers.add(quizQueForth.getAnswer());

        Quiz quizQueFifth = new Quiz();
        quizQueFifth.setQuestion("5. Web browser available in android is based on?");
        quizQueFifth.setType(MultipleItem.ItemType.CHECKBOX_TYPE);
        quizQueFifth.setOption(listOptnCheckBox2);
        quizQueFifth.setAnswer("Open Source Web Kit");
        correctAnswers.add(quizQueFifth.getAnswer());

        Quiz quizQueSixth = new Quiz();
        quizQueSixth.setQuestion("6. Which company bought android? ");
        quizQueSixth.setType(MultipleItem.ItemType.CHECKBOX_TYPE);
        quizQueSixth.setOption(listOptnCheckBox3);
        quizQueSixth.setAnswer("Google");
        correctAnswers.add(quizQueSixth.getAnswer());

        Quiz quizQueSeventh = new Quiz();
        quizQueSeventh.setQuestion("7. Is Android hack proof? ");
        quizQueSeventh.setType(MultipleItem.ItemType.RADIO_TYPE);
        quizQueSeventh.setOption(listOptnRadioBtn2);
        quizQueSeventh.setAnswer("No");
        correctAnswers.add(quizQueSeventh.getAnswer());

        Quiz quizQueEighth = new Quiz();
        quizQueEighth.setQuestion("8. Is Android available in ROM? ");
        quizQueEighth.setType(MultipleItem.ItemType.RADIO_TYPE);
        quizQueEighth.setOption(listOptnRadioBtn3);
        quizQueEighth.setAnswer("No");
        correctAnswers.add(quizQueEighth.getAnswer());

        Quiz quizQueNinth = new Quiz();
        quizQueNinth.setQuestion("9. Android is based on which kernel? ");
        quizQueNinth.setType(MultipleItem.ItemType.CHECKBOX_TYPE);
        quizQueNinth.setOption(listOptnCheckBox4);
        quizQueNinth.setAnswer("Linux Kernel");
        correctAnswers.add(quizQueNinth.getAnswer());

        Quiz quizQueTenth = new Quiz();
        quizQueTenth.setQuestion("10. ADB stands for");
        quizQueTenth.setType(MultipleItem.ItemType.FILL_BLANK_TYPE);
        quizQueTenth.setOption(null);
        quizQueTenth.setAnswer("Android Debug Bridge");
        correctAnswers.add(quizQueTenth.getAnswer());

        listQuiz.add(quizQueFirst);
        listQuiz.add(quizQueSec);
        listQuiz.add(quizQueThird);
        listQuiz.add(quizQueForth);
        listQuiz.add(quizQueFifth);
        listQuiz.add(quizQueSixth);
        listQuiz.add(quizQueSeventh);
        listQuiz.add(quizQueEighth);
        listQuiz.add(quizQueNinth);
        listQuiz.add(quizQueTenth);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finalScore >= 7) {
                    final_score.setTextColor(getResources().getColor(R.color.colorGreen));
                } else {
                    final_score.setTextColor(getResources().getColor(R.color.colorRed));
                }
                final_score.setText(getResources().getString(R.string.final_score) + finalScore);
                final_score.setVisibility(View.VISIBLE);
            }
        });
    }


    @Override
    public void enableSubmitBtn(Boolean isBtnEnable) {
        Toast.makeText(getApplicationContext(), "It should call here", Toast.LENGTH_SHORT).show();
        submit_btn.setEnabled(isBtnEnable);
        submit_btn.setTextColor(getResources().getColor(R.color.colorWhite));
        submit_btn.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
    }
}
