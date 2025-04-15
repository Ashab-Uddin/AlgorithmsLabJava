public class lcsas {

    // Recursive method to find the length of LCS
    public static int findLCS(char[] str1, char[] str2, int len1, int len2) {

        // Base case: if either string is empty, return 0
        if (len1 == 0 || len2 == 0) {
            return 0;
        }

        // If last characters match, add 1 and check remaining parts
        if (str1[len1 - 1] == str2[len2 - 1]) {
            return 1 + findLCS(str1, str2, len1 - 1, len2 - 1);
        } else {
            // If last characters don’t match, return the max of two choices
            return max(
                findLCS(str1, str2, len1, len2 - 1),
                findLCS(str1, str2, len1 - 1, len2)
            );
        }
    }

    // Method to return the larger of two numbers
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        String text1 = "ABCDEFGH";
        String text2 = "abcdefgh";

        // Convert strings to character arrays
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        // Get the lengths of the arrays
        int length1 = chars1.length;
        int length2 = chars2.length;

        // Call the recursive LCS function and display result
        int result = findLCS(chars1, chars2, length1, length2);
        System.out.println("Length of LCS is: " + result);
    }
}
