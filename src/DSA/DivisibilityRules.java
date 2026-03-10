package DSA;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DivisibilityRules {
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(3,"Three");
        map.put(7, "Seven");
        map.put(11, "Eleven");
    }
    public static void divisibilityRules(int n, Map<Integer, String> divMap) {
        String finalString = divMap.entrySet().stream()
                .filter(e -> n % e.getKey() == 0)
                .map(e -> e.getValue())
                .reduce("", String::concat);

        System.out.println(finalString);
    }
}
