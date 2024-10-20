package leetcode.string;

public class MinDeletionSize {

    public static int minDeletionSize(String[] strs) {
        int rowLength = strs.length;
        int columnLength = strs[0].length();

        int count = 0;

        for (int i = 0; i < columnLength; i++) {
            for (int j = 0; j < rowLength - 1; j++) {
                System.out.println(strs[j].charAt(i) + "-->" + strs[j + 1].charAt(i));

                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String[] strs = {"zyx","wvu","tsr"};
        System.out.println(minDeletionSize(strs));
    }
}
