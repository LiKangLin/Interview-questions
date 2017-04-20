package QuestionTest;

/**
 * Created by L_kanglin on 2017/4/8.
 * 将数字转化为相应的中文
 */
public class Test12 {
    static String[] units = { "", "十", "百", "千", "万", "十万", "百万", "千万", "亿",
            "十亿", "百亿", "千亿", "万亿" };
    static char[] numArray = { '零', '一', '二', '三', '四', '五', '六', '七', '八', '九' };

    public static void main(String[] args) {
        int num = 233200040;
        String numStr = foematInteger(num);
        System.out.println("num= " + num + ", 转换结果: " + numStr);
    }
    private static String foematInteger(int num) {
        //
       // 调用String.valueOf(num).toCharArray()将num转成String类型再转成一个char数组
        char[] val = String.valueOf(num).toCharArray();
        //定义一个StringBuffer对象sb，获取char数组的长度length
        int len = val.length;
        System.out.println("该数字的长度为：" + len);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            String m = val[i] + "";
            int n = Integer.valueOf(m);
         //   boolean isZero = n == 0;
            boolean isZero = n == 0;
            //len是数字的长度
            String unit = units[(len - 1) - i];
            if (isZero) {
                if ('0' == val[i - 1]) {
                    //当前val[i]的下一个值val[i-1]为0则不输出零
                    continue;
                } else {
                    //只有当当前val[i]的下一个值val[i-1]不为0才输出零
                    sb.append(numArray[n]);
                }
            } else {
                sb.append(numArray[n]);
                sb.append(unit);
            }
        }
        return sb.toString();
    }
}
