package org.example;

public class GroceryCounter {
    String counter = "0000";
    int max = 9999;
    int min = 0;

    int overflowCounter = 0;

    public GroceryCounter() {
        // Constructor
    }

    public GroceryCounter(String initialValue) {
        if (isValid(initialValue)) {
            this.counter = initialValue;
        } else {
            this.counter = "0000"; // Default value if invalid
        }
    }

    public GroceryCounter(int maxValue) {
        this.max = maxValue;
    }

    boolean isValid(String value) {
        return value.matches("\\d{4}") && Integer.parseInt(value) >= min && Integer.parseInt(value) <= max;
    }

    void tens() {
        int currentValue = Integer.parseInt(counter);
        int newValue = currentValue + 1000;

        if (newValue > max) {
            overflowCounter++;
            currentValue = min;
        } else {
            currentValue = newValue;
        }
        counter = String.format("%04d", currentValue);
    }

    void ones() {
        int currentValue = Integer.parseInt(counter);
        int newValue = currentValue + 100;
        if (newValue > max) {
            newValue = min;
            overflowCounter++;
        }

        counter = String.format("%04d", newValue);
    }

    void tenths() {
        int currentValue = Integer.parseInt(counter);
        int newValue = currentValue + 10;
        if (newValue > max) {
            newValue = min;
            overflowCounter++;
        }

        counter = String.format("%04d", newValue);
    }

    void hundreths() {
        int currentValue = Integer.parseInt(counter);
        int newValue = currentValue + 1;
        if (newValue > max) {
            newValue = min;
            overflowCounter++;
        }

        counter = String.format("%04d", newValue);
    }

    void decrementTens() {
        int currentValue = Integer.parseInt(counter);
        int newValue = currentValue - 1000;
        if (newValue < min) {
            newValue = max;
            overflowCounter++;
        }
        counter = String.format("%04d", newValue);
    }

    void decrementOnes() {
        int currentValue = Integer.parseInt(counter);
        int newValue = currentValue - 100;
        if (newValue < min) {
            newValue = max;
            overflowCounter++;
        }
        counter = String.format("%04d", newValue);
    }

    void decrementTenths() {
        int currentValue = Integer.parseInt(counter);
        int newValue = currentValue - 10;
        if (newValue < min) {
            newValue = max;
            overflowCounter++;
        }
        counter = String.format("%04d", newValue);
    }

    void decrementHundreths() {
        int currentValue = Integer.parseInt(counter);
        int newValue = currentValue - 1;
        if (newValue < min) {
            newValue = max;
            overflowCounter++;
        }
        counter = String.format("%04d", newValue);
    }

    void increment(int amount) {
        int currentValue = Integer.parseInt(counter);
        int newValue = currentValue + amount;

        while (newValue > max) {
            newValue -= (max + 1);
            overflowCounter++;
        }

        counter = String.format("%04d", newValue);
    }

    int overflows() {
        return overflowCounter;
    }

    String total() {
        return "$" + (counter.charAt(0) == '0' ? "" : counter.charAt(0)) + counter.charAt(1) + "." + counter.charAt(2)
                + counter.charAt(3);
    }

    void clear() {
        counter = "0000";
        overflowCounter = 0;
    }
}
