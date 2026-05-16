package DSA;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class FindIntersection {
    static void main() {
        String[] str = {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};
        FindArrayIntersection(str);
    }
    public static void FindArrayIntersection(String[] strArr) {
        String[] s1 = strArr[0].split(",");
        String[] s2 = strArr[1].split(",");

        Set<String> lset = new LinkedHashSet<>();
        lset.addAll(List.of(s1));
        String[] s3 = new String[s2.length];
        for(int i = 0; i < s2.length; i++) {
            if(lset.contains(s2[i])) {
                s3[i] = s2[i];
            }
        }
        for(int i = 0; i < s3.length; i++) {
            System.out.println("element is = " + s3[i]);
        }
    }
}
