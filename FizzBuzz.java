/*
    Ideally this would be in a couple classes, but I'm trying to keep it in one class per practice.
    No source information as I've been thinking about this problem for a long time.
    It's definitely one of my favorite.
*/

import java.util.List;
import java.util.stream.IntStream;

class FizzBuzz {
    public static void main(String[] args) {
        List<String> messages = getFizzbuzzMessages(16);

        var formattedMessages = String.join(", ", messages); 

        System.out.println(formattedMessages);
    }

    private static List<String> getFizzbuzzMessages(int toPlaces) {
        return IntStream
            .range(1, makeInclusive(toPlaces))
            .mapToObj(i -> getNextFizzBuzzMessage(i))
            .toList();
    }

    private static int makeInclusive(int exclusiveNumber) {
        return exclusiveNumber + 1;
    }

    private static String getNextFizzBuzzMessage(int i) {
        return getFizzString(i)
                + getBuzzString(i)
                + getRawNumberString(i);
    }

    private static String getFizzString(int i) {
        return shouldPrintFizz(i) 
            ? "Fizz" 
            : "";
    }
    
    private static String getBuzzString(int i) {
        return shouldPrintBuzz(i)
            ? "Buzz"
            : "";
    }

    private static String getRawNumberString(int i) {
        return (!shouldPrintBuzz(i)  && !shouldPrintFizz(i))
            ? String.valueOf(i)
            : "";
    }

    private static boolean shouldPrintBuzz(int i) {
        return i % 5 == 0;
    }

    private static boolean shouldPrintFizz(int i) {
        return i % 3 == 0;
    }   
}
