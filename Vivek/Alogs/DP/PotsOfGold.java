package Alogs.DP;

import java.util.*;
/* 
Two players X and Y are playing a game in which there are pots of gold arranged in a line, each containing some gold coins. They get alternating turns in which the player can pick a pot from one of the ends of the line. The winner is the player who has a higher number of coins at the end. The objective is to maximize the number of coins collected by X, assuming Y also plays optimally.

Return the maximum coins X could get while playing the game. Initially, X starts the game.


Example 1:

Input:
N = 4
Q[] = {8, 15, 3, 7}
Output: 22
Explanation: Player X starts and picks 7. Player Y 
picks the pot containing 8. Player X picks the pot
containing 15. Player Y picks 3.
Total coins collected by X = 7 + 15 = 22.
Example 2:

Input:
N = 4
A[] = {2, 2, 2, 2}
Output: 4 

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxCoins() which takes an integer N and an array of size N  as input and returns the maximum coins collected by player X.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N2)

 */
public class PotsOfGold {
    public static void main(String[] args) {
        int[] coins = { 8, 15, 3, 7 };
        int n = 4;
        System.out.println(maxCoins(coins, n));
    }

    public static int maxCoins(int[] coins, int n) {
        int l = 0, r = n - 1;
        Map<String, Integer> map = new HashMap<>();
        return maxProfit(coins, l, r, map);
    }

    private static int maxProfit(int[] coins, int l, int r, Map<String, Integer> map) {

        if (l > r)
            return 0;

        String key = l + "|" + r;
        Integer sol = map.get(key);

        if (sol != null)
            return sol;

        int a = coins[l] + Math.min(maxProfit(coins, l + 2, r, map), maxProfit(coins, l + 1, r - 1, map));
        int b = coins[r] + Math.min(maxProfit(coins, l + 1, r - 1, map), maxProfit(coins, l, r - 1, map));

        int profit = Math.max(a, b);
        map.put(key, profit);

        return profit;
    }
}
