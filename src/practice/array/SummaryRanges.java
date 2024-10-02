package practice.array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    // https://leetcode.com/problems/summary-ranges/description/
    // Group elements from an array using two loops
    // learned, one index forward look up
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums.length == 1) {
            result.add(nums[0] + "");
            return result;
        }

        for (int i = 0; i < nums.length; i++) {

            int startingValue = nums[i];
            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                i++;
            }

            if (startingValue == nums[i]) {
                result.add(nums[i] + "");
            } else {
                result.add(startingValue + "-->" + nums[i]);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums));
    }
}
