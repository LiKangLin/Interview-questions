package QuestionTest;

/**
 * Created by L_kanglin on 2017/4/16.
 */
public class Test19 {
    public static void main(String[] args){

    }
    public int coins1(int[] arr,int aim){
        if(arr==null||arr.length==0||aim<0){
            return 0;
        }
        return process1(arr,1,aim);
    }

    private int process1(int[] arr, int index, int aim) {
        int res=0;
        if(index==arr.length){
            res=aim==0?1:0;
        }else{
            for(int i=0;arr[index]*i<=aim;i++){
                res+=process1(arr,index+1,aim-arr[index]*i);
            }
        }
        return res;
    }
}
