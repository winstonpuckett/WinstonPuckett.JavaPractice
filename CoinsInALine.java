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
        var playerOneScore = 0;
        var playerTwoScore = 0;
        var isPlayerOnesTurn = true;

        while (coins.length > 0) {
            var tempCoinsArray = new int[coins.length - 1];
            if (isPlayerOnesTurn) {
                if (coins[0] > coins[coins.length - 1]) {
                    playerOneScore += coins[0];
                    System.arraycopy(coins, 1, tempCoinsArray, 0, coins.length - 1);
                    coins = tempCoinsArray;
                } else {
                    playerOneScore += coins[coins.length - 1];
                    System.arraycopy(coins, 0, tempCoinsArray, 0, coins.length - 1);
                    coins = tempCoinsArray;
                }
            } else {
                if (coins[0] > coins[coins.length - 1]) {
                    playerTwoScore += coins[0];
                    System.arraycopy(coins, 1, tempCoinsArray, 0, coins.length - 1);
                    coins = tempCoinsArray;
                } else {
                    playerTwoScore += coins[coins.length - 1];
                    System.arraycopy(coins, 0, tempCoinsArray, 0, coins.length - 1);
                    coins = tempCoinsArray;
                }
            }

            isPlayerOnesTurn = !isPlayerOnesTurn;
        }

        return playerOneScore;
    }
}
