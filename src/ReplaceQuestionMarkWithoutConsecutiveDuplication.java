public class ReplaceQuestionMarkWithoutConsecutiveDuplication {
    public static void main(String[] args) {
        String str1 = "??????";
        String str2 = "a?a?a??";
        String str3 = "a?b??a";
        String str4 = "a????b";
        String str5 = "a?????b";
        String str6 = "a?????c";

        printResult(str1);
        printResult(str2);
        printResult(str3);
        printResult(str4);
        printResult(str5);
        printResult(str6);


    }
    public static String replace(String s) {
        Character head = null;
        Character tail = null;
        StringBuilder result = new StringBuilder(s);

        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '?') {
                if (i == 0) {
                    result.replace(0, 0, "a");
                } else {
                    head = result.charAt(i - 1);
                    int j = i + 1;
                    while (j < result.length() && result.charAt(j) == '?') {
                        j++;
                    }
                    if (j < result.length()) {
                        tail = result.charAt(j);
                    }
                    char candidate_1 = (char)(head + 1);
                    if (tail != null && candidate_1 == tail) {
                        candidate_1 = (char)(candidate_1 + 1);
                    }
                    if (j - i == 1) {
                        result.setCharAt(i, candidate_1);
                    } else {
                        char candidate_2 = (char)(candidate_1 + 1);
                        if (tail != null && candidate_2 == tail) {
                            candidate_2 = (char)(candidate_2 + 1);
                        }

                        for (; i < j; i++ ) {
                            if (i % 2 == 0) {
                                result.setCharAt(i, candidate_1);
                            } else {
                                result.setCharAt(i, candidate_2);
                            }
                        }
                    }

                }
            }
        }

        return result.toString();
    }

    public static void printResult(String s) {
        System.out.println(s + " -> " + replace(s));
    }


}
