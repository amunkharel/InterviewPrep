package General;

import java.util.HashMap;
import java.util.Map;

//Problem to convert Roman numerals into Integer
public class Problem_2 {
    public static void main(String[] args) {
        System.out.println(romanToInteger("MCMXCIV"));
    }

    public static int romanToInteger(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> hm = new HashMap<>();
        hm.put('I', new Integer(1));
        hm.put('V', new Integer(5));
        hm.put('X', new Integer(10));
        hm.put('L', new Integer(50));
        hm.put('C', new Integer(100));
        hm.put('D', new Integer(500));
        hm.put('M', new Integer(1000));

        int result = hm.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2 ; i >= 0; i--) {
            int a = hm.get(s.charAt(i));
            int b = hm.get(s.charAt(i + 1));
            if(b > a) {
                result = result - a;
            }
            else {
                result += a;
            }
        }

        return result;
    }
}
