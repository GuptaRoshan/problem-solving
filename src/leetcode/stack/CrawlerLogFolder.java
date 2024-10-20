package leetcode.stack;

public class CrawlerLogFolder {

    public static int minOperations(String[] logs) {
        int counter = 0;

        for (String op : logs) {
            if (op.equals("./")) {
            } else if (op.equals("../")) {

                if (counter > 0) {
                    counter--;
                }

            } else {
                counter++;
            }
        }

        return Math.max(counter, 0);
    }


    public static void main(String[] args) {
        String[] logs = {"./", "wz4/", "../", "mj2/", "../", "../", "ik0/", "il7/"};
        System.out.println(minOperations(logs));
    }
}
