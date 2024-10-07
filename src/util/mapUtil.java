package util;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class mapUtil {

    public static void main(String[] args) {

        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");

        System.out.println("Floor Key " + map.floorKey(5));

        System.out.println("Ceil Key " + map.ceilingKey(0));
    }

}
