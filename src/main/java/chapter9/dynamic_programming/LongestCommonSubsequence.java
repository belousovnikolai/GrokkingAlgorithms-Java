package chapter9.dynamic_programming;

public class LongestCommonSubsequence {
    public static int[][] longestCommonSubsequence(String word1, String word2) {
        int[][] table = new int[word1.length()][word2.length()];

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    if (i > 0 && j > 0) {
                        table[i][j] = table[i-1][j-1] + 1;
                    } else {
                        table[i][j] = 1;
                    }
                } else {
                    if (i > 0 && j > 0) {
                        table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
                    } else if (i > 0) {
                        table[i][j] = table[i-1][j];
                    } else if (j > 0) {
                        table[i][j] = table[i][j-1];
                    } else {
                        table[i][j] = 0;
                    }
                }
            }
        }
        return table;
    }

    public static int[][] longestCommonSubstring(String word1, String word2) {
        int[][] table = new int[word1.length()][word2.length()];

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    if (i > 0 && j > 0) {
                        table[i][j] = table[i-1][j-1] + 1;
                    } else {
                        table[i][j] = 1;
                    }
                } else {
                    table[i][j] = 0;
                }
            }
        }
        return table;
    }
}
