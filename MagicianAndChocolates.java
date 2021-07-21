import java.io.NotActiveException;

/*
    Source: https://www.interviewbit.com/problems/magician-and-chocolates/
    Description: 
    Given N bags, each bag contains Bi chocolates. There is a kid and a magician. 
    In one unit of time, kid chooses a random bag i, eats Bi chocolates, then the magician 
    fills the ith bag with floor(Bi/2) chocolates.

    Find the maximum number of chocolates that kid can eat in A units of time.

    NOTE: 
    floor() function returns the largest integer less than or equal to a given number.
    Return your answer modulo 109+7

    Input Format
    First argument is an integer A.
    Second argument is an integer array B of size N.

    Output Format
    Return an integer denoting the maximum number of chocolates that kid can eat in A units of time.

    Example Input
    Input 1:
    A = 3
    B = [6, 5]
    
    Input 2:
    A = 5
    b = [2, 4, 6, 8, 10]


    Example Output
    Output 1:
    14
    Output 2:
    33


    Example Explanation
    Explanation 1:

    At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates. 
    At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates. 
    At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate. 
    so, total number of chocolates eaten are 6 + 5 + 3 = 14
*/

public class MagicianAndChocolates {
    public static void main(String[] args) {
        int maxCholates = calculateMaxChocolatesEaten(5, new int[] { 2, 4, 6, 8, 10 });
        System.out.println(maxCholates);
    }

    private static int calculateMaxChocolatesEaten(int timeUnits, int[] chocolateBags) {
        int chocolatesEaten = 0;

        for (int i = 0; i < timeUnits; i++) {
            var largestBag = getIndexForLargestBag(chocolateBags);
            chocolatesEaten += largestBag.getChocolateCount();
            chocolateBags[largestBag.getIndex()] = (int)Math.floor(largestBag.chocolateCount / 2);
        }

        return chocolatesEaten;
    }

    private static ChocolateBagInformation getIndexForLargestBag(int[] chocolateBags) {
        var largestBag = new ChocolateBagInformation();
        
        for (int i = 0; i < chocolateBags.length; i++) {
            var currentChocolateCount = chocolateBags[i];

            if (largestBag.getChocolateCount() < chocolateBags[i]) {
                largestBag.setIndex(i);
                largestBag.setChocolateCount(currentChocolateCount);
            }
        }

        return largestBag;
    }

    // Note: Static is a terrible idea here. Ideally this would be a POJO, but I'm having trouble
    // doing that in one file.
    private static class ChocolateBagInformation {
        private int index = 0;
        private int chocolateCount = 0;

        public int getIndex() {
            return index;
        }
        public void setIndex(int newIndex) {
            index = newIndex;
        }

        public int getChocolateCount() {
            return chocolateCount;
        }
        public void setChocolateCount(int newCount) {
            chocolateCount = newCount;
        }
    }
}
