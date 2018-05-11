package example.com.quizdroid;

public class CategoryItem {

    private int mBgColor;
    private String mCategoryTitle;
    private String mCategoryID;

    CategoryItem(int imageId, String categoryTitle, String categoryID) {
        this.mBgColor = imageId;
        this.mCategoryTitle = categoryTitle;
        this.mCategoryID = categoryID;
    }

    public int getmBgColor() {
        return mBgColor;
    }

    public String getmCategoryTitle() {
        return mCategoryTitle;
    }

    public String getmCategoryID() {
        return mCategoryID;
    }
}
