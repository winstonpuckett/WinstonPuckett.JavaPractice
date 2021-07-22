/*
    Source: https://www.interviewbit.com/problems/coins-in-a-line/
    Description:
    There are A coins (Assume A is even) in a line.
    Two players take turns to take a coin from one of the ends of the line until there are no more coins left.
    The player with the larger amount of money wins, Assume that you go first.
    Return the maximum amount of money you can win.

*/

public class CoinsInALine {
    public static void main(String[] args) {
        var coins = new int[] { 1, 2, 3, 4 };

        var result = calculateMaxCoins(coins);

        System.out.println(result);
    }

    private static int calculateMaxCoins(int[] coins) {
        return 0;
    }
}
