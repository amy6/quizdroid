package example.com.quizdroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private ArrayList<Question> mQuestionList;

    QuestionAdapter(Context context, ArrayList<Question> questionList) {
        this.mContext = context;
        this.mQuestionList = questionList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View questionView = LayoutInflater.from(mContext)
                .inflate(R.layout.question_card_layout, parent, false);
        return new QuestionViewHolder(questionView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Question question = mQuestionList.get(position);
        final QuestionViewHolder questionViewHolder = (QuestionViewHolder) holder;
        questionViewHolder.mQuestion.setText(question.getmQuestion());
        questionViewHolder.mRb1.setText(question.getmOption1());
        questionViewHolder.mRb2.setText(question.getmOption2());
        questionViewHolder.mRb3.setText(question.getmOption3());
        questionViewHolder.mRb4.setText(question.getmOption4());

        ArrayList<RadioButton> radioButtons = questionViewHolder.mTableLayout.getChildren();
        for (final RadioButton rb: radioButtons) {
            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    questionViewHolder.mTableLayout.checkAnswer(rb, question.getmAnswer(), mContext);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mQuestionList.size();
    }

    class QuestionViewHolder extends RecyclerView.ViewHolder {

        TextView mQuestion;
        RadioButton mRb1;
        RadioButton mRb2;
        RadioButton mRb3;
        RadioButton mRb4;

        ToggleButtonGroupTableLayout mTableLayout;

        QuestionViewHolder(View itemView) {
            super(itemView);
            mQuestion = itemView.findViewById(R.id.question);

            mRb1 = itemView.findViewById(R.id.rb1);
            mRb2 = itemView.findViewById(R.id.rb2);
            mRb3 = itemView.findViewById(R.id.rb3);
            mRb4 = itemView.findViewById(R.id.rb4);

            mTableLayout = itemView.findViewById(R.id.table_layout);
        }
    }

}
