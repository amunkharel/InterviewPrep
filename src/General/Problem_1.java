package General;

//problem to reverse a number. Please account for the highest possible integer number
import java.lang.Math;
public class Problem_1 {
    public static void main(String[] args) {
        System.out.println(reverse(120));
        System.out.println(reverse2(-3120));
    }

    public  static int reverse (int x) {
        long reverse = 0;

        while (x != 0) {
            reverse = reverse* 10 + x % 10;
            x = x /10;
        }

        if(reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE) {
            return  0;
        }
        else {
            return (int) reverse;
        }
    }

    //Integer.MAX_VALUE = 2147483647
    //Integer.MIN_VALUE = -2147483648
    public static  int reverse2 (int x) {
        int rev = 0;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > 7)) return  0;
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < -8)) return  0;
            rev = rev * 10 + pop;
        }

        return  rev;
    }
}
