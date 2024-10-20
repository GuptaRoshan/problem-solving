package leetcode.string;


public class RotateString {

    public static boolean rotateString(String s, String goal) {

        /**

         if (s.length() != goal.length()) return false;

         int sIndex = 0;
         int gIndex = goal.indexOf(s.charAt(sIndex));

         while (sIndex < s.length()) {
         gIndex = gIndex % goal.length();

         if (s.charAt(sIndex) != goal.charAt(gIndex)) return false;

         sIndex++;
         gIndex++;
         }

         return true;

         **/

        return s.length() == goal.length() && (s + s).contains(goal);


    }

    public static void main(String[] args){
        //System.out.println(rotateString("abcde", "cdeab"));
    }


}
