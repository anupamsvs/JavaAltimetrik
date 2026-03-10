package DSA;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "loveleetcode";
        System.out.println(firstNonRepeatingChar(str));
    }

    private static int firstNonRepeatingChar(String str) {
        Map<Character, Integer> myMap = new LinkedHashMap<>();
        char[] ch = str.toCharArray();
        for(Character c : ch) {
            if(myMap.containsKey(c)) {
                myMap.put(c, myMap.get(c)+1);
            } else {
                myMap.put(c, 1);
            }
        }
        Character fnr = null;
        for(Map.Entry<Character,Integer> e : myMap.entrySet()) {
            if(e.getValue() == 1) {
                fnr = e.getKey();
                break;
            }
        }
        if(fnr == null) {
            return -1;
        }
        return str.lastIndexOf(fnr);
    }
}
