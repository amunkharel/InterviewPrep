package General;


//Problem to find longest common prefix
public class Problem_3 {

    public static void main(String[] args) {
        String arr[] = {"flower","flow","flight"};

        System.out.println(longestCommonPrefix(arr));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null) return  "";

        String prefix = strs[0];

        for(int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    public static String longestCommonPrefixDc(String[] strs) {
        return "abc";
    }
}
