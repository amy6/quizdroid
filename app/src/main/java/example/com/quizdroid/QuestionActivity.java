package example.com.quizdroid;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.constraint.ConstraintLayout;

import java.util.ArrayList;

import static example.com.quizdroid.CategoryAdapter.CATEGORY_COLOR;
import static example.com.quizdroid.CategoryAdapter.CATEGORY_ID;

public class QuestionActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private QuestionAdapter mAdapter;
    private ArrayList<Question> mQuestionList;
    private QuizDBHelper dbHelper;

    private ConstraintLayout parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Bundle categoryBundle = null;
        if (getIntent() != null) {
            categoryBundle = getIntent().getExtras();
        }

        parentLayout = findViewById(R.id.question_layout);
        if (categoryBundle != null) {
            String hexColor = String.format("#%06X", (0xFFFFFF & categoryBundle.getInt(CATEGORY_COLOR)));
            hexColor = "#44"+hexColor.substring(1);
            parentLayout.setBackgroundColor(Color.parseColor(hexColor));
        }

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setHasFixedSize(true);

        dbHelper = new QuizDBHelper(this, categoryBundle);
        if (categoryBundle != null) {
            mQuestionList = dbHelper.getAllQuestions(categoryBundle.getString(CATEGORY_ID));
        }
        mAdapter = new QuestionAdapter(this, mQuestionList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    public void checkAnswer(View view) {
        Log.d("TAG", String.valueOf(view.getId()));
    }
}
