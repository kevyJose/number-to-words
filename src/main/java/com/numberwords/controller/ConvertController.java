package com.numberwords.controller;

public class ConvertController {

    public String convertToWords(String amountStr) {
        double amount;
        try {
            amount = Double.parseDouble(amountStr);
        } catch (NumberFormatException e) {
            return "INVALID INPUT";
        }
        if (amount < 0) return "Invalid Input! The value must be positive.";
        if (amount >= 1000000) return "Invalid Input! The value is too large.";

        int dollars = (int) amount;
        int cents = (int) Math.round((amount - dollars) * 100);

        StringBuilder result = new StringBuilder();

        if (dollars > 0) {
            result.append(numberToWords(dollars)).append(" DOLLAR");
            if (dollars != 1) result.append("S");
        }

        if (cents > 0) {
            if (cents == 100) {
                result = new StringBuilder();
                dollars += 1;
                result.append(numberToWords(dollars)).append(" DOLLAR");
                if (dollars != 1) result.append("S");
            }
            else {
                if (dollars > 0) result.append(" AND ");
                result.append(numberToWords(cents)).append(" CENT");
                if (cents != 1) result.append("S");
            }
        }

        if (result.isEmpty()) {
            return "ZERO DOLLARS";
        }

        return result.toString().trim().toUpperCase();

    }


    private String numberToWords(int number) {
        if (number == 0) return "ZERO";

        String[] UNIT_WORDS = {
                "", "ONE", "TWO", "THREE", "FOUR", "FIVE",
                "SIX", "SEVEN", "EIGHT", "NINE"
        };
        String[] TEEN_WORDS = {
                "TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN",
                "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN"
        };
        String[] TENS_WORDS = {
                "", "", "TWENTY", "THIRTY", "FORTY", "FIFTY",
                "SIXTY", "SEVENTY", "EIGHTY", "NINETY"
        };

        StringBuilder words = new StringBuilder();

        if (number >= 1000) {
            words.append(numberToWords(number / 1000)).append(" THOUSAND");
            number %= 1000;
            if (number > 0) words.append(" ");
        }

        if (number >= 100) {
            words.append(UNIT_WORDS[number / 100]).append(" HUNDRED");
            number %= 100;
            if (number > 0) words.append(" AND ");
        }

        if (number >= 20) {
            words.append(TENS_WORDS[number / 10]);
            number %= 10;
            if (number > 0) words.append("-").append(UNIT_WORDS[number]);
        } else if (number >= 10) {
            words.append(TEEN_WORDS[number - 10]);
        } else if (number > 0) {
            words.append(UNIT_WORDS[number]);
        }

        return words.toString().trim();
    }

}
