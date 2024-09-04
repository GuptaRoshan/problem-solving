package neetcode150.binarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TimeBasedKeyValueStore_981 {

    private record Data(String val, int time) { }

    Map<String, List<Data>> map;

    public TimeBasedKeyValueStore_981() {
        map = new ConcurrentHashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        return binarySearch(map.get(key), timestamp);
    }

    // If target found it will give me the target.
    // If the target is not found, it will give me the element which is just smaller than the target.
    private String binarySearch(List<Data> list, int timestamp) {
        int low = 0;
        int high = list.size() - 1;
        int justSmallerOrTarget = -1;
        int justGreaterOrTarget = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid).time <= timestamp) {
                justSmallerOrTarget = mid;
                low = mid + 1;
            } else {
                justGreaterOrTarget = mid;
                high = mid - 1;
            }
        }

        return justSmallerOrTarget != -1 ? list.get(justSmallerOrTarget).val : "";
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore_981 timeMap = new TimeBasedKeyValueStore_981();

        // Set values with timestamps
        timeMap.set("foo", "bar1", 1);
        timeMap.set("foo", "bar2", 2);
        timeMap.set("foo", "bar3", 3);
        timeMap.set("foo", "bar4", 10);

        // Get the values at different timestamps
        System.out.println("Get 'foo' at timestamp 1: " + timeMap.get("foo", 1));
        System.out.println("Get 'foo' at timestamp 2: " + timeMap.get("foo", 2));
        System.out.println("Get 'foo' at timestamp 4: " + timeMap.get("foo", 4));
        System.out.println("Get 'foo' at timestamp 5: " + timeMap.get("foo", 5));
    }


}
