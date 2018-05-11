package example.com.quizdroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import example.com.quizdroid.QuizContract.QuestionsTable;

public class QuizDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "quizzes.db";
    private static final int DB_VERSION = 5;

    public static final String CATEGORY_SPORTS = "sports";
    public static final String CATEGORY_TV = "tv";
    public static final String CATEGORY_MOVIES = "movies";
    public static final String CATEGORY_INDIA = "india";
    public static final String CATEGORY_WORD = "words";
    public static final String CATEGORY_SCIENCE = "science";

    private final String CREATE_TABLE_QUERY = "CREATE TABLE " + QuestionsTable.TABLE_NAME +
            "(" +
            QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            QuestionsTable.COLUMN_QUESTION + " TEXT, " +
            QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
            QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
            QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
            QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
            QuestionsTable.COLUMN_ANSWER + " TEXT, " +
            QuestionsTable.COLUMN_CATEGORY + " TEXT" +
            ")";

    private final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME;

    private SQLiteDatabase db;
    private List<Question> mQuestionList;

    private Bundle categoryIntentBundle;

    public QuizDBHelper(Context context, Bundle bundle) {
        super(context, DB_NAME, null, DB_VERSION);
        this.categoryIntentBundle = bundle;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        db.execSQL(CREATE_TABLE_QUERY);

        setUpQuestions();
        insertQuestions();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_QUERY);
        onCreate(db);
    }

    private void setUpQuestions() {
        mQuestionList = new ArrayList<>();

        //questions for category india
        mQuestionList.add(new Question("What Indian city is the capital of two states?", "Mumbai", "Kolkatta", "Chennai", "Chandigarh", "Chandigarh", CATEGORY_INDIA));
        mQuestionList.add(new Question("Which is the smallest (in area) of the following Union Territories?", "Lakshadweep", "Chandigardh", "Daman & Diu", "Delhi", "Lakshadweep", CATEGORY_INDIA));
        mQuestionList.add(new Question("On which river has the Hirakud dam been built?", "Godavari", "Mahanadi", "Cauvery", "Periyar", "Mahanadi", CATEGORY_INDIA));
        mQuestionList.add(new Question("Which state is irrigated by the Ganga canal?", "Uttar Pradesh", "Bihar", "West Bengal", "Rajasthan", "Rajasthan", CATEGORY_INDIA));
        mQuestionList.add(new Question("The famous Gir forests are located in", "Mysore", "Kashmir", "Gujarat", "Kerala", "Gujarat", CATEGORY_INDIA));

        //questions for category movies
        mQuestionList.add(new Question("What classic film ends with the line \"After all, tomorrow is another day!\"?", "It's a wonderful life", "Gone with the wind", "Singin' in the rain", "The sound of music", "Gone with the wind", CATEGORY_MOVIES));
        mQuestionList.add(new Question("Who starred alongside Will Smith in Men in Black 3?", "Danel Craig", "Tommy Lee Jones", "Tom Selleck", "Val Kilmer", "Tommy Lee Jones", CATEGORY_MOVIES));
        mQuestionList.add(new Question("What color is \"The Incredible Hulk\"?", "Green", "Purple", "Blue", "Grey", "Green", CATEGORY_MOVIES));
        mQuestionList.add(new Question("Who played the role of Ernst Stavro Blofeld in Bond movie Never Say Never Again?", "Robert Shaw", "Christopher Lee", "Julian Gover", "Max Von Sydow", "Max Von Sydow", CATEGORY_MOVIES));
        mQuestionList.add(new Question("Ayelet Zurer played which role in Angels and Demons (2009)?", "Elizabeth Sinskey", "Sienna Brooks", "Vittoria Vettra", "Sophie Neveu", "Vittoria Vettra", CATEGORY_MOVIES));

        //questions for category tv
        mQuestionList.add(new Question("Which famous person does Phoebe believe is her Grandfather?", "Albert Einstein", "Isaac Newton", "Winston Churchill", "Beethoven", "Albert Einstein", CATEGORY_TV));
        mQuestionList.add(new Question("What is the name of the main family in this US TV series - Beverly Hills, 90210", "Keaton", "Walsh", "Tanner", "Crane", "Walsh", CATEGORY_TV));
        mQuestionList.add(new Question("What is Sheldon's middle name?", "Leonard", "John", "Lee", "Brian", "Lee", CATEGORY_TV));
        mQuestionList.add(new Question("What was finally revealed to be Jon Snow's real name in Game of Thrones?", "Aemon Targaryen", "Aegon Targaryen", "Viserys Targeryan", "Rhaegar Targeryan", "Rajasthan", CATEGORY_TV));
        mQuestionList.add(new Question("What is Pied Piper?", "A lossless compression software", "A scary story", "A song", "A bank", "A lossless compression software", CATEGORY_TV));

        //questions for category science
        mQuestionList.add(new Question("What is the first element on the periodic table?", "Uranium", "Helium", "Hydrogen", "Carbon", "Hydrogen", CATEGORY_SCIENCE));
        mQuestionList.add(new Question("What constitutes the biggest part of the human brain?", "Cerebrum", "Cerebellum", "Thalamus", "Medula", "Cerebrum", CATEGORY_SCIENCE));
        mQuestionList.add(new Question("Electric current is measured using what device?", "Anemometer", "Hygrometer", "Spectrometer", "Ammeter", "Ammeter", CATEGORY_SCIENCE));
        mQuestionList.add(new Question("What planet is closest in size to Earth?", "Mercury", "Mars", "Venus", "Jupiter", "Venus", CATEGORY_SCIENCE));
        mQuestionList.add(new Question("Who introduced the idea of natural selection?", "Herbert Spencer", "Charles Darwin", "Charles Dicken", "Karl Marx", "Charles Darwin", CATEGORY_SCIENCE));

        //questions for category word
        mQuestionList.add(new Question("Which is a synonym of vigilant?", "puzzled", "watchful", "unhealthy", "wide", "watchful", CATEGORY_WORD));
        mQuestionList.add(new Question("Which of these is a word for an artistic critique?", "chanteuse", "charrette", "chariot", "charlatan", "charrette", CATEGORY_WORD));
        mQuestionList.add(new Question("Which of these words means \"substitute\"?", "prediction", "period", "proof", "proxy", "proxy", CATEGORY_WORD));
        mQuestionList.add(new Question("Which word means something like \"paradise\"?", "unicorn", "antelope", "utility", "utopia", "utopia", CATEGORY_WORD));
        mQuestionList.add(new Question("Which is a synonym of acute?", "severe", "tired", "long", "open", "severe", CATEGORY_WORD));

        //questions for category sports
        mQuestionList.add(new Question("Which of these footballers retired with fewer than 100 international caps?", "Andrea Pirlo", "Dirk Kuyt", "Francesco Totti", "Philipp Lahm", "Francesco Totti", CATEGORY_SPORTS));
        mQuestionList.add(new Question("Which tennis player made it to three singles grand slam finals in 2017?", "Venus Williams", "Rafael Nadal", "Roger Federer", "Serena Williams", "Rafael Nadal", CATEGORY_SPORTS));
        mQuestionList.add(new Question("Which was the 1st non Test playing country to beat India in an international match?", "Canada", "Sri Lanka", "Zimbabwe", "East Africa", "Sri Lanka", CATEGORY_SPORTS));
        mQuestionList.add(new Question("The term 'Beamer' is associated with", "Football", "Hockey", "Cricket", "Chess", "Cricket", CATEGORY_SPORTS));
        mQuestionList.add(new Question("Jahangir Khan is famous for", "Boxing", "Squash", "Hockey", "Cricket", "Squash", CATEGORY_SPORTS));
    }

    private void insertQuestions() {
        for(Question q : mQuestionList) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(QuestionsTable.COLUMN_QUESTION, q.getmQuestion());
            contentValues.put(QuestionsTable.COLUMN_OPTION1, q.getmOption1());
            contentValues.put(QuestionsTable.COLUMN_OPTION2, q.getmOption2());
            contentValues.put(QuestionsTable.COLUMN_OPTION3, q.getmOption3());
            contentValues.put(QuestionsTable.COLUMN_OPTION4, q.getmOption4());
            contentValues.put(QuestionsTable.COLUMN_ANSWER, q.getmAnswer());
            contentValues.put(QuestionsTable.COLUMN_CATEGORY, q.getmCategory());
            db.insert(QuestionsTable.TABLE_NAME, null, contentValues);
        }
    }

    public ArrayList<Question> getAllQuestions(String categoryID) {
        Log.d("TAG", "Getting all questions for : " + categoryID);
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        String SELECT_TABLE_QUERY = "SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE " + QuestionsTable.COLUMN_CATEGORY + " = \"" + categoryID + "\"";
        Cursor cursor = db.rawQuery(SELECT_TABLE_QUERY, null);
        if(cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setmQuestion(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setmOption1(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setmOption2(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setmOption3(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setmOption4(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setmAnswer(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_ANSWER)));
                questionList.add(question);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return questionList;
    }
}
