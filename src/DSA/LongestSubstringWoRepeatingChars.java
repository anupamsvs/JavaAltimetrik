package DSA;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestSubstringWoRepeatingChars {
    static void main() {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> lhset = new HashSet<>();
        int count = 0;
        int maxSize = 0;
        int i = 0;
        char[] ch = s.toCharArray();
        while(i < s.length()) {
            if(lhset.contains(ch[i])) {
                lhset.clear();
                count = 0;
                lhset.add(ch[i]);
            } else {
                lhset.add(ch[i]);
            }
            count++;
            if(maxSize < count) {
                maxSize = count;
            }
            i++;
        }
        System.out.println("Set = "+ lhset);
        return maxSize;
    }
}
