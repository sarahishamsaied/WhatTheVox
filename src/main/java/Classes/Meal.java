package Classes;

import java.io.FileInputStream;

public class Meal {
    String mealTitle;
    String description;
    String category;
    FileInputStream mealImg = null;
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public Meal() {
        this.mealTitle = "";
        this.description = "";
    }

    public void setMealTitle(String mealTitle) {
        this.mealTitle = mealTitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMealTitle() {
        return mealTitle;
    }

    public String getDescription() {
        return description;
    }

    public FileInputStream getMealImg() {
        return mealImg;
    }

    public void setMealImg(FileInputStream mealImg) {
        this.mealImg = mealImg;
    }

    public Meal(String mealTitle, String description, String category, FileInputStream mealImg) {
        this.mealTitle = mealTitle;
        this.description = description;
        this.category = category;
        this.mealImg = mealImg;
    }
}
