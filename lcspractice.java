public class lcspractice {

    // Function to compute LCS length and fill memo table
    public static int lcsprac(char[] X, char[] Y, int m, int n, int[][] memo) {
        if (m == 0 || n == 0)
            return 0;

        if (memo[m][n] != -1)
            return memo[m][n];

        if (X[m - 1] == Y[n - 1])
            memo[m][n] = 1 + lcsprac(X, Y, m - 1, n - 1, memo);
        else
            memo[m][n] = Math.max(lcsprac(X, Y, m, n - 1, memo), lcsprac(X, Y, m - 1, n, memo));

        return memo[m][n];
    }

    // Function to build the LCS from memo table
    public static String buildLCS(char[] X, char[] Y, int m, int n, int[][] memo) {
        StringBuilder lcs = new StringBuilder();

        while (m > 0 && n > 0) {
            if (X[m - 1] == Y[n - 1]) {
                lcs.append(X[m - 1]);
                m--;
                n--;
            } else if (memo[m - 1][n] > memo[m][n - 1]) {
                m--;
            } else {
                n--;
            }
        }

        return lcs.reverse().toString();
    }

    public static void main(String[] args) {
        String X = "ABCDEF";
        String Y = "ACDGH";

        char[] arr1 = X.toCharArray();
        char[] arr2 = Y.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;

        int[][] memo = new int[len1 + 1][len2 + 1];

        // Initialize memo with -1
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                memo[i][j] = -1;
            }
        }

        int length = lcsprac(arr1, arr2, len1, len2, memo);
        String lcs = buildLCS(arr1, arr2, len1, len2, memo);

        System.out.println("Length of LCS is: " + length);
        System.out.println("LCS is: " + lcs);
    }
}
