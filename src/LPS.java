public class LPS {
    public static void main(String[] args) {

        System.out.println(longestPalindromeSubseq("bbbab"));
    }

    public static int longestPalindromeSubseq(String s) {
        int size = s.length();
        int[][] dp = new int[size][size];

        // i starts from len - 1, from big to small, because to calcule the dp[i][j], we need the value dp[i+1][j-1], so we need to reverse the order.
        for (int i = size - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < size; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][size - 1];
    }



}
