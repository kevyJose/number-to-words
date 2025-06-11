package com.numberwords.test;

import com.numberwords.controller.ConvertController;

public class ConvertControllerTest {

    public static void main(String[] args) {
        ConvertController converter = new ConvertController();

        runTest(converter, "0", "ZERO DOLLARS");
        runTest(converter, "0.00", "ZERO DOLLARS");
        runTest(converter, "1", "ONE DOLLAR");
        runTest(converter, "1.01", "ONE DOLLAR AND ONE CENT");
        runTest(converter, "10.90", "TEN DOLLARS AND NINETY CENTS");
        runTest(converter, "123.45", "ONE HUNDRED AND TWENTY-THREE DOLLARS AND FORTY-FIVE CENTS");
        runTest(converter, "1000", "ONE THOUSAND DOLLARS");
        runTest(converter, "1001", "ONE THOUSAND AND ONE DOLLARS");
        runTest(converter, "999999", "NINE HUNDRED AND NINETY-NINE THOUSAND NINE HUNDRED AND NINETY-NINE DOLLARS");
        runTest(converter, "-1", "INVALID INPUT");
        runTest(converter, "abc", "INVALID INPUT");
        runTest(converter, "1.999", "ONE DOLLAR AND NINETY-NINE CENTS"); // rounding cents
        runTest(converter, "0.99", "NINETY-NINE CENTS");
    }

    private static void runTest(ConvertController converter, String input, String expected) {
        String actual = converter.convertToWords(input);
        if (actual.equals(expected)) {
            System.out.println("PASS: " + input + " -> " + actual);
        } else {
            System.out.println("FAIL: " + input + " -> " + actual + " (Expected: " + expected + ")");
        }
    }
}
