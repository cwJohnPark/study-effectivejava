package me.cwpark.chapter2.item2.hierarchy;

// Should sauce be inside or out?
public class Calzone extends Pizza {
    public static void main(String[] args) {
        Calzone calzone = new Calzone.Builder()
                .addTopping(Topping.HAM).sauceInside().build();
    }
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {

        private boolean sauceInside = false; // Optional, Default

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        public Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
    private Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }
}
