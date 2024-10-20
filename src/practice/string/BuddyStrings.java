package practice.string;

import java.util.HashSet;
import java.util.Set;

public class BuddyStrings {

    public boolean buddyStrings(String s, String goal) {
        int first = -1;
        int second = -1;

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));

            if (s.charAt(i) != goal.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else {
                    second = i;
                }
            }

        }

        if( first != -1 &&  second != -1) {
            return  s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first);
        }

        if(second == -1) return false;

        return set.size() < s.length();
    }

}
