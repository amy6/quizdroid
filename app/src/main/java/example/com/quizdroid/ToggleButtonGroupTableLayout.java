package example.com.quizdroid;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;

public class ToggleButtonGroupTableLayout extends TableLayout  {

    private RadioButton mActiveRadioButton;

    public ToggleButtonGroupTableLayout(Context context) {
        super(context);
    }

    public ToggleButtonGroupTableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public ArrayList<RadioButton> getChildren() {
        ArrayList<RadioButton> radioButtons = new ArrayList<>();
        int childCount = this.getChildCount();
        for(int i=0; i<childCount; i++) {
            TableRow tableRow = (TableRow) this.getChildAt(i);
            int rowChildCount = tableRow.getChildCount();
            for(int j=0 ;j<rowChildCount; j++) {
                View v = tableRow.getChildAt(j);
                if(v instanceof RadioButton) {
                    radioButtons.add((RadioButton) v);
                }
            }
        }
        return radioButtons;
    }

    public void checkAnswer(final RadioButton rb, String answer) {
        if(mActiveRadioButton != null) {
            mActiveRadioButton.setChecked(false);
        }
        int id = -1;
        rb.setChecked(true);
        if(rb.getText().equals(answer)) {
            rb.getBackground().setColorFilter(Color.parseColor("#7700ff00"), PorterDuff.Mode.MULTIPLY);
        } else {
            rb.getBackground().setColorFilter(Color.parseColor("#77ff0000"), PorterDuff.Mode.MULTIPLY);
            for(RadioButton radioButton:getChildren()) {
                if(radioButton.getText().equals(answer)) {
                    radioButton.getBackground().setColorFilter(Color.parseColor("#7700ff00"), PorterDuff.Mode.MULTIPLY);
                    id = radioButton.getId();
                }
            }
        }
        mActiveRadioButton = rb;
        for(RadioButton radioButton:getChildren()) {
            radioButton.setClickable(false);
            if(radioButton.getId() != rb.getId() && radioButton.getId() != id){
                radioButton.getBackground().setColorFilter(Color.parseColor("#77cccccc"), PorterDuff.Mode.MULTIPLY);
                radioButton.setTextColor(Color.parseColor("#55000000"));
            }
        }

    }
}
