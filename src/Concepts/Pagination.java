package Concepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pagination {

    static void main() {
        Map<String, ArrayList<Integer>> myMap = new HashMap<>();
        myMap.computeIfAbsent("key", k -> new ArrayList<>()).add(5);
//        myMap.computeIfPresent("key", (k, v) -> v)
    }
}
