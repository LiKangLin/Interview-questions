package QuestionTest;

/**
 * Created by L_kanglin on 2017/4/8.
 */

//壹贰叁肆伍陆柒捌玖拾
    //将伍仟肆百八十转化为5480元
public class Test13 {
    static char[] units = { '十', '百', '仟','万','元'};
    static char[] numArray = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };
    static char[] numInt={'0','1','2','3','4','5','6','7','8','9'};
    public static void main(String[] args) {
        String str="伍仟肆百捌十陆元";
        System.out.println("转换前的字符串: " + str);
        for(int i=0;i<str.length();i++){
            for(int j=0;j<units.length;j++)
                //找到了在哪一个位置
                if (str.charAt(i) == units[j]) {
                    //删除字符串的指定位置上的字符
                    //或者用replace
                    str=str.substring(0, i)+str.substring(i+1);
                }
        }
        int num =Convert(str);
        System.out.println("str= " + str + ", 转换结果: " + num);
    }
    public static int Convert(String str){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            for(int j=0;j<numArray.length;j++){
                if (str.charAt(i) == numArray[j]) {
                    sb.append(numInt[j]);
                }
            }
        }
        return Integer.valueOf(sb.toString());
    }
}
