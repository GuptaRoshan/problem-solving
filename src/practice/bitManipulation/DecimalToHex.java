package practice.bitManipulation;

public class DecimalToHex {

    public static String toHex(int num) {
        if (num == 0) return "0";

        StringBuilder hex = new StringBuilder();
        char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        while (num != 0) {
            int rem = num % 16;
            hex.insert(0, hexChars[rem]);
            num = num / 16;
        }

        return hex.toString();
    }

    public static void main(String[] args) {
        int num = 26;
        System.out.println(toHex(num));
    }

}
