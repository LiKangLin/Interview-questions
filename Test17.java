package QuestionTest;

import java.util.*;

/**
 * Created by L_kanglin on 2017/4/16.
 * 题目要求：找到一个字符串中的一个连续子串，这个子串内不能有任何两个字符是相同的，
 并且这个子串是符合要求的最长的。
 例如：abcdeab，这个字符串有很多不重复子串，比如：abcde, bcdea, cdeab都是不重复子串，
 而且都是最长的。
 最长不重复子串
 */
public class Test17 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _str;
        try {
            _str = in.nextLine();
        } catch (Exception e) {
            _str = null;
        }

        res = calDuplicateString(_str);
        System.out.println(res);
    }

    /*public String max(String str){
        if(str==null||str.equals("")){
             return null;
        }
        StringBuilder maxSub=new StringBuilder("");
        char[] strCharArr=str.toCharArray();
        int[] charsIndex=new int[256];
        for(int index=0;index<256;index++){
            charsIndex[index]=-1
        }

    }*/
    public static String calDuplicateString(String str){
        if(str == null)	return null;
        StringBuilder maxString = new StringBuilder("");
        char [] strCharArr = str.toCharArray();
        HashMap<Character, Integer> charsIndex = new HashMap<Character, Integer>();
        int startIndex = -1, FStartIndex = startIndex, maxLen = 0;
        for(int index = 0; index < strCharArr.length; index++) {
            if(charsIndex.containsKey(strCharArr[index])) {
                int FIndex = charsIndex.get(strCharArr[index]);
                if(FIndex > startIndex){
                    startIndex = FIndex;
                }
            }
            if(index - startIndex > maxLen) {
                maxLen = index - startIndex;
                FStartIndex = startIndex;
            }
            charsIndex.put(strCharArr[index], index);
        }
        for(int index =  FStartIndex + 1; index < FStartIndex + maxLen + 1; index++) {
            maxString.append(strCharArr[index]);
        }
        return maxString.toString();

}
}
