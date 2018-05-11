package example.com.quizdroid;

public class Question {

    private String mQuestion;
    private String mOption1;
    private String mOption2;
    private String mOption3;
    private String mOption4;
    private String mAnswer;
    private String mCategory;


    public Question() {
    }

    public Question(String mQuestion, String option1, String option2, String option3, String option4, String answer, String category) {
        this.mQuestion = mQuestion;
        this.mOption1 = option1;
        this.mOption2 = option2;
        this.mOption3 = option3;
        this.mOption4 = option4;
        this.mAnswer = answer;
        this.mCategory = category;
    }

    public String getmQuestion() {
        return mQuestion;
    }

    public String getmOption1() {
        return mOption1;
    }

    public String getmOption2() {
        return mOption2;
    }

    public String getmOption3() {
        return mOption3;
    }

    public String getmOption4() {
        return mOption4;
    }

    public String getmAnswer() {
        return mAnswer;
    }

    public String getmCategory() {
        return mCategory;
    }

    public void setmQuestion(String mQuestion) {
        this.mQuestion = mQuestion;
    }

    public void setmOption1(String mOption1) {
        this.mOption1 = mOption1;
    }

    public void setmOption2(String mOption2) {
        this.mOption2 = mOption2;
    }

    public void setmOption3(String mOption3) {
        this.mOption3 = mOption3;
    }

    public void setmOption4(String mOption4) {
        this.mOption4 = mOption4;
    }

    public void setmAnswer(String mAnswer) {
        this.mAnswer = mAnswer;
    }

    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }
}
