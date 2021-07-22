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
        var coins = new int[] { 5, 4, 8, 10 };

        var result = calculateMaxCoins(coins);

        System.out.println(result);
    }

    private static int calculateMaxCoins(int[] coins) {
        var playerOneScore = 0;
        var isPlayerOnesTurn = true;

        while (coins.length > 0) {
            var result = takeTurn(coins);

            if (isPlayerOnesTurn)
                playerOneScore += result.getScore();
            
            coins = result.getCoinsLeft();
            isPlayerOnesTurn = !isPlayerOnesTurn;
        }

        return playerOneScore;
    }

    private static RoundResult takeTurn(int[] coins) {
        if (shouldTakeFromBeginning(coins)) {
            return new RoundResult(removeFirstIndex(coins), coins[0]);
        } else {
            return new RoundResult(removeLastIndex(coins), coins[coins.length - 1]);
        }
    }

    private static boolean shouldTakeFromBeginning(int[] coins) {
        return coins[0] > coins[coins.length - 1];
    }

    private static int[] removeFirstIndex(int[] array) {
        var newArray = new int[array.length - 1];
        System.arraycopy(array, 1, newArray, 0, array.length - 1);
        return newArray;
    }
    private static int[] removeLastIndex(int[] array) {
        var newArray = new int[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, array.length - 1);
        return newArray;
    }

    private static class RoundResult {
        private int[] coinsLeft;
        private int score;

        public RoundResult(int[] coinsLeft, int score) {
            this.coinsLeft = coinsLeft;
            this.score = score;
        }

        public int getScore() {
            return score;
        }
        public int[] getCoinsLeft() {
            return coinsLeft;
        }
    }
}
