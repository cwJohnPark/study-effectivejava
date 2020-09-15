package me.cwpark.chapter2.item2;

class TelescopingPattern {
    public static void main(String[] args) {
        // Require many parameters that you don't want to set
        NutritionFactsTelescopingPattern cocaCola = new NutritionFactsTelescopingPattern(240, 8, 100, 0, 35, 27);
    }
}
// Telescoping constructor pattern - does not scale well !
class NutritionFactsTelescopingPattern {
    private final int servingSize;  // (mL)            required
    private final int servings;     // (per container) required
    private final int calories;     // (per serving)   optional
    private final int fat;          // (g/serving)     optional
    private final int sodium;       // (mg/serving)    optional
    private final int carbohydrate; // (g/serving)     optional

    public NutritionFactsTelescopingPattern(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFactsTelescopingPattern(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFactsTelescopingPattern(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFactsTelescopingPattern(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    // what if the number of parameters increases?
    public NutritionFactsTelescopingPattern(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}
