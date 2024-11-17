package com.thealgorithms.others;

import java.util.Arrays;
import java.util.Objects;

public final class Luhn {
    private Luhn() {
    }

    public static boolean luhnCheck(int[] digits) {
        int[] numbers = Arrays.copyOf(digits, digits.length);
        int sum = 0;

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                int temp = numbers[i] * 2;
                if (temp > 9) {
                    temp = temp - 9;
                }
                numbers[i] = temp;
            }
            sum += numbers[i];
        }

        return sum % 10 == 0;
    }

    public static void main(String[] args) {
        System.out.println("Luhn algorithm usage examples:");
        int[] validInput = {4, 5, 6, 1, 2, 6, 1, 2, 1, 2, 3, 4, 5, 4, 6, 7};
        int[] invalidInput = {4, 5, 6, 1, 2, 6, 1, 2, 1, 2, 3, 4, 5, 4, 6, 4}; 
                                                                               
        checkAndPrint(validInput);
        checkAndPrint(invalidInput);

        System.out.println("\nBusiness examples:");
        String validCardNumber = "5265 9251 6151 1412";
        String invalidCardNumber = "4929 3231 3088 1896";
        String illegalCardNumber = "4F15 BC06 3A88 76D5";
        businessExample(validCardNumber);
        businessExample(invalidCardNumber);
        businessExample(illegalCardNumber);
    }

    private static void checkAndPrint(int[] input) {
        String validationResult = Luhn.luhnCheck(input) ? "valid" : "not valid";
        System.out.println("Input " + Arrays.toString(input) + " is " + validationResult);
    }

    private record CreditCard(int[] digits) {
        private static final int DIGITS_COUNT = 16;

        public static CreditCard fromString(String cardNumber) {
            Objects.requireNonNull(cardNumber);
            String trimmedCardNumber = cardNumber.replaceAll(" ", "");
            if (trimmedCardNumber.length() != DIGITS_COUNT || !trimmedCardNumber.matches("\\d+")) {
                throw new IllegalArgumentException("{" + cardNumber + "} - is not a card number");
            }

            int[] cardNumbers = toIntArray(trimmedCardNumber);
            boolean isValid = luhnCheck(cardNumbers);
            if (!isValid) {
                throw new IllegalArgumentException("Credit card number {" + cardNumber + "} - have a typo");
            }

            return new CreditCard(cardNumbers);
        }

        public String number() {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < DIGITS_COUNT; i++) {
                if (i % 4 == 0 && i != 0) {
                    result.append(" ");
                }
                result.append(digits[i]);
            }
            return result.toString();
        }

        @Override
        public String toString() {
            return String.format("%s {%s}", CreditCard.class.getSimpleName(), number());
        }

        private static int[] toIntArray(String string) {
            return string.chars().map(i -> Character.digit(i, 10)).toArray();
        }
    }

    private static void businessExample(String cardNumber) {
        try {
            System.out.println("Trying to create CreditCard object from valid card number: " + cardNumber);
            CreditCard creditCard = CreditCard.fromString(cardNumber);
            System.out.println("And business object is successfully created: " + creditCard + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println("And fail with exception message: " + e.getMessage() + "\n");
        }
    }
}
