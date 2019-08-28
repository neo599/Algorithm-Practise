class Reduce3ConsecutivesTo2 {
    public static void main(String[] args) {
        String str1 = "baaabbabbb";
        String str2 = "aaaa";

        printResult(str1);
        printResult(str2);
    }

    public static String reduceConsecutiveLetters(String s) {
        if (s == null || s.length() <= 2) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        result.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                result.append(s.charAt(i));

                int j = i + 1;
                while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                    j++;
                }

                i = j - 1;

            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    public static int getLengthWithout3Consecutive(String s) {
        if (s.length() <= 2) {
            return s.length();
        }
        int len = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                int j = i + 1;

                while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                    j ++;
                }
                i = j - 1;
            }
            len ++;

        }
        return len;
    }

    public static void printResult(String s) {
        System.out.println(s + " -> " + reduceConsecutiveLetters(s) + " " + getLengthWithout3Consecutive(s) + (reduceConsecutiveLetters(s).length() == getLengthWithout3Consecutive(s)));
    }
}