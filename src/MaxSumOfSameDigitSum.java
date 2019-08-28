import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSumOfSameDigitSum {
    public static void main(String[] args) {
        int [] A = {51, 71, 17, 42};
        solution(A);
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        Map<Integer, List<Integer>> sumToIndexMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int digitSum = getDigitSum(A[i]);
            List<Integer> indexList = sumToIndexMap.getOrDefault(digitSum, new ArrayList<Integer>());

            indexList.add(i);
            sumToIndexMap.put(digitSum, indexList);

        }

        int maxSum = Integer.MIN_VALUE;

        for (int digitSum : sumToIndexMap.keySet()) {
            List<Integer> indexList = sumToIndexMap.get(digitSum);
            if (indexList.size() > 1) {

                for (int i = 0; i < indexList.size(); i++) {
                    for (int j = i + 1; j < indexList.size(); j++) {
                        maxSum = Math.max(maxSum, A[indexList.get(i)] + A[indexList.get(j)]);
                    }
                }

            }
        }
        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;

    }

    public static int getDigitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum = sum + num % 10;
            num = num / 10;
        }

        return sum;
    }


}

