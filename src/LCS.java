import java.util.Arrays;

public class LCS {

    public static void main(String[] args) {

        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()][text2.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }

        for (int i = 0; i < text1.length(); i++) {
            char c1 = text1.charAt(i);
            for (int j = 0; j < text2.length(); j++) {
                char c2 = text2.charAt(j);
                if (c1 == c2) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

                }
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }
}
