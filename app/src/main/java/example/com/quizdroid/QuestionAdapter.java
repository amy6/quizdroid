package example.com.quizdroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
        Question question = mQuestionList.get(position);
        final QuestionViewHolder questionViewHolder = (QuestionViewHolder) holder;
        questionViewHolder.mQuestion.setText(question.getmQuestion());
        questionViewHolder.mOption1.setText(question.getmOption1());
        questionViewHolder.mOption2.setText(question.getmOption2());
        questionViewHolder.mOption3.setText(question.getmOption3());
        questionViewHolder.mOption4.setText(question.getmOption4());
    }

    @Override
    public int getItemCount() {
        return mQuestionList.size();
    }

    class QuestionViewHolder extends RecyclerView.ViewHolder {

        TextView mQuestion;
        Button mOption1;
        Button mOption2;
        Button mOption3;
        Button mOption4;

        QuestionViewHolder(View itemView) {
            super(itemView);
            mQuestion = itemView.findViewById(R.id.question);
            mOption1 = itemView.findViewById(R.id.option1);
            mOption2 = itemView.findViewById(R.id.option2);
            mOption3 = itemView.findViewById(R.id.option3);
            mOption4 = itemView.findViewById(R.id.option4);
        }
    }

}
