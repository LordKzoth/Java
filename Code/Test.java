class Test {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("hehkk"));
    }

    public static String longestPalindrome(String s) {
        int sLen = s.length();

        boolean[][] dp = new boolean[sLen][sLen];
        for (int i = 0; i < sLen; ++i) {
            for (int j = 0; j < 0; ++j) {
                dp[i][j] = false;
            }
        }

        // Len = 1
        int maxLen = 1, start = 0;

        for (int i = 0; i < sLen; ++i ) {
            dp[i][i] = true;
        }

        // Len = 2
        for (int i = 0; i < sLen-1; ++i) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                maxLen = 2;
                start = i;
            }
        }

        // Len > 2
        for (int k = 3; k <= sLen; ++k) {
            for (int i = 0; i < sLen-k+1; ++i) {
                int j = i + k - 1;

                if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;

                    if (k > maxLen) {
                        maxLen = k;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start+maxLen);
    }
}