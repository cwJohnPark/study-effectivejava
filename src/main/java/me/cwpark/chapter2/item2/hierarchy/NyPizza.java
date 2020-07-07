package me.cwpark.chapter2.item2.hierarchy;

import java.util.Objects;

// Standard New-York-style pizza requires size parameters
public class NyPizza extends Pizza {

    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(Size.SMALL) // The size is Required
                .addTopping(Topping.SAUSAGE).addTopping(Topping.ONION).build();
    }

    public enum Size { SMALL, MEDIUM, LARGE }
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size; // Required

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    // cannot be created outside
    private NyPizza(Builder builder) {
        super(builder);
        this.size = builder.size;
    }
}

