# Rationale for Implementation Approach: Number-to-Words Conversion

## Overview  
The core objective of this project was to implement a custom algorithm that accurately converts a currency amount (e.g., 123.45) into its English words representation (e.g., "ONE HUNDRED AND TWENTY-THREE DOLLARS AND FORTY-FIVE CENTS"). I developed the solution entirely from scratch without using any external libraries or packages, in alignment with the project constraints.

## Initial Approach: Character-Based Mapping
At the outset, I attempted to solve the problem using multiple HashMap structures that mapped individual characters or digits ('1', '2', etc.) to their corresponding word forms ("ONE", "TWO", etc.). The idea was to iterate through the input string character by character and build the final result by piecing together the mapped values.

While conceptually straightforward, this approach quickly proved to be impractical:

* ack of Flexibility: It did not handle the structure of numbers beyond individual digits, such as tens (20, 30), teens (13, 15), or hundreds (100, 300) effectively.

* Poor Readability and Scalability: The logic became convoluted as more conditions and rules were added to handle special number patterns.

* Difficult to Handle Complex Cases: Edge cases like leading zeros, negative numbers, and decimals were error-prone and required excessive condition checking.

## Final Approach: Structured Numeric Parsing
Recognizing the limitations of the character-based method, I revised the approach entirely. Instead of treating the input as a series of characters, I did the following:

* Parsed the input as a numeric value, using Double.parseDouble to handle both dollars and cents.

* Separated the value into whole (dollars) and fractional (cents) parts using standard mathematical operations instead of relying on character positions.

* Implemented a recursive, rule-based number-to-words conversion algorithm, which divides the number into thousands, hundreds, tens, and units. This structure provided much greater control and clarity.

This new approach yielded several advantages:

* Accuracy and Readability: Logic flows in a way that mirrors the grammatical structure of English numeric phrases.

* Scalability: The same logic can handle a wide range of inputs, from single digits to large numbers like 999,999.

* Robust Handling of Edge Cases: Input validation ensures that invalid or negative inputs are caught and handled gracefully.

## Conclusion
By moving away from a character-by-character and hashmap-heavy approach, and toward a numeric, component-based conversion strategy, I was able to produce a more versatile, maintainable, and correct implementation. This solution demonstrates sound design choices and strong alignment with the principles of clean, reliable software development.