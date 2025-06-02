package task1;

/*
01.06.25
Дано массив nums.
Определим текущую сумму (running sum) массива как runningSum[i] = сумма(nums[0]…nums[i]).

Необходимо вернуть текущую сумму для массива nums.

Вход: nums = [1, 2, 3, 4]
Выход: [1, 3, 6, 10]
 */

import java.util.Arrays;

public class Solution {
    public int[] runningSum(int[] nums) {
        int[] newArrayNums = Arrays.copyOf(nums, nums.length);

        for (int i = 1; i < newArrayNums.length; i++) {
            newArrayNums[i] += newArrayNums[i - 1];
        }
        return newArrayNums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.runningSum(new int[]{1, 1, 1, 1})));
    }
}
