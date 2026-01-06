package DSA;
import java.util.*;
public class ChangeCoins {
    public static Map<Integer, Integer> memo = new HashMap<>();
    public static void main(String[] args) {
        
        int[] coins = {1, 3, 4};
        System.out.println(changeCoins1(coins, 6));
        System.out.println(changeCoins2(coins, 6));
        System.out.println("Testting token");
    }
    public static int changeCoins1(int[] coins, int money) {
        int[] dp = new int[money + 1];
        for (int i = 0; i < dp.length; i++){
            dp[i] = money + 1;
        }

        dp[0] = 0;
        for (int i = 1; i < dp.length ; i++) {
            for (int c : coins) {
                if (i - c >= 0) dp[i] = Math.min(dp[i], 1 + dp[i - c]);
            }
        }
        return (dp[money] != money + 1) ? dp[money] : -1;
    }

    public static int changeCoins2(int[] coins, int money) {
        int res = dfs(coins, money);
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    public static int dfs(int[] coins, int money) {
        if (money == 0) {
            return 0;
        }
        if (memo.containsKey(money)) return memo.get(money);
        int res = Integer.MAX_VALUE;
        for (int c : coins) {
            if (money - c >= 0) {
                int tmp = dfs(coins, money - c);
                if (tmp != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + tmp);
                }
            }
        }

        memo.put(money, res);
        return res;
    }
}
