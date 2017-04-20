package QuestionTest;

/**
 * Created by L_kanglin on 2017/4/16.
 */
public class Test16 {
    public static void main(String[] args){
        int[] arr={2,1,5,3,6,4,8,9,7};
        int[] result=lis1(arr);
        for(int i :result){
            System.out.print(i+" ");
        }

    }
    //dp中表示的是所有递增子序列的长度
    public static int[] getdp1(int[] arr){
        int[] dp=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    //因为dp[0]=1,注意是dp[i]和dp[j]+1进行比较，取得最大值
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp;
    }
    //接下来说明如何根据求出的dp数组得到最长递增子序列
    public static int[] generateLIS(int[] arr,int[] dp){
        int len=0;
        int index=0;
        //找出dp中的最大值len，记录它的位置index
        for(int i=0;i<dp.length;i++){
            if(dp[i]>len){
                len=dp[i];
                index=i;
            }
        }
        //选定了最长的路径，开始找子序列
        int[] lis = new int[len];
        lis[--len]=arr[index];
        for(int i=index;i>=0;i--){
            if(arr[i]<arr[index]&&dp[i]==dp[index]-1){
                lis[--len]=arr[i];
                index=i;
            }
        }
        return lis;
    }
    //整个过程的主方法
    public static int[] lis1(int[] arr){
        if(arr==null || arr.length==0){
            return null;
        }
        int[] dp=getdp1(arr);
        return generateLIS(arr,dp);
    }
}
