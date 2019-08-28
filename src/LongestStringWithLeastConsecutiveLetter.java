public class LongestStringWithLeastConsecutiveLetter {
    // find longest substring with consecutive letter no more than 2
    public static void main(String[] args) {
        String str1 = "abbaabaaabajkjkjkjk";
        String str2 = "aaaabba";

        printResult(str1);
        printResult(str2);
    }

    public static int getLongestSubStringLen(String s) {
        int start = 0, end = 2, maxLen = 2;

        while (end < s.length()) {
            if (s.charAt(end) == s.charAt(end - 1) && s.charAt(end - 1) == s.charAt(end - 2)) {
                maxLen = Math.max(end - start, maxLen);
                start = end - 1;
            }
            end ++;
        }

        return Math.max(maxLen, end - start);

    }

    public static void printResult(String s) {
        System.out.println(s + " -> " + getLongestSubStringLen(s));
    }
}
