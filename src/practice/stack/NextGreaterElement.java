package practice.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {


    // https://leetcode.com/problems/next-greater-element-i/description/
    // Using monotonic stack
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> greaterElement = new HashMap<>();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[stack.peek()] < nums2[i]) {
                greaterElement.put(nums2[stack.pop()], nums2[i]);
            }

            stack.push(i);
        }


        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {

            if (greaterElement.containsKey(nums1[i])) {
                result[i] = greaterElement.get(nums1[i]);
                continue;
            }

            result[i] = -1;
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(nextGreaterElement(nums1, nums2));
    }
}
