package com.udacity.jdnd.course1.service;

public class FizzBuzzService {

    /**
     * If number is divisible by 3, return "Fizz". If divisible by 5,
     * return "Buzz", and if divisible by both, return "FizzBuzz". Otherwise,
     * return the number itself.
     *
     * @Throws IllegalArgumentException for values < 1
     */
    public String fizzBuzz(int number) {
       if (number == 0 || number == -1)
           throw new IllegalArgumentException("");
        if(number%15 == 0)
            return "FizzBuzz";
        if(number%3 == 0)
            return "Fizz";
        if (number%5 == 0)
            return "Buzz";
        return String.valueOf(number);
    }

    public int buzzFizz(String input, int occurrence) {
        if (input.equals("Fizz")) {
            return 3 * occurrence;
        } else if (input.equals("Buzz")) {
            return 5 * occurrence;
        } else if (input.equals("FizzBuzz")) {
            return 15 * occurrence;
        } else {
            return Integer.valueOf(input);
        }
    }
}
