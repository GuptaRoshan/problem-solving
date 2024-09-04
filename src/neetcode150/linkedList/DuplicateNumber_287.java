package neetcode150.linkedList;

public class DuplicateNumber_287 {

    public static int findDuplicate(int[] nums) {
        int sp = nums[0];
        int fp = nums[0];
        do {
            sp = nums[sp];
            fp = nums[nums[fp]];
        } while (sp != fp);

        int ptr = nums[0];
        while (ptr != sp) {
            ptr = nums[ptr];
            sp = nums[sp];
        }

        return ptr;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }
}
