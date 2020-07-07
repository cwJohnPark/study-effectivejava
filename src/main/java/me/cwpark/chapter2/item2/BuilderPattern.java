package me.cwpark.chapter2.item2;

class BuilderPattern {
    public static void main(String[] args) {
        NutritionFactsBuilderPattern cocaCola =
                new NutritionFactsBuilderPattern.Builder(240, 8)
                    .calories(100).sodium(35).carbohydrate(27).build();
    }
}

class NutritionFactsBuilderPattern {
    // Parameters initialized to default values(if any)
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    static class Builder {
        // Required Paraemters
        private final int servingsSize;
        private final int servigns;

        // Optional Paremeters - initialized to default values
        private int calories        = 0;
        private int fat             = 0;
        private int sodium          = 0;
        private int carbohydrate    = 0;

        public Builder(int servingsSize, int servigns) {
            this.servingsSize = servingsSize;
            this.servigns = servigns;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }
        public Builder fat(int val) {
            fat = val;
            return this;
        }
        public Builder sodium(int val) {
            sodium = val;
            return this;
        }
        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }
        public NutritionFactsBuilderPattern build() {
            return new NutritionFactsBuilderPattern(this);
        }

    }

    public NutritionFactsBuilderPattern(Builder builder) {
        this.servingSize = builder.servingsSize;
        this.servings = builder.servigns;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }
}
