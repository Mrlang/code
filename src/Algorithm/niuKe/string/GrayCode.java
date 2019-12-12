package Algorithm.niuKe.string;

/**
 * Created by Mr_liang on 2016/11/12.
 */
public class GrayCode {
    public static void main(String args[]) {
        String[] a = getGray(1);

    }

    public static String[] getGray(int n) {
        int length = 1 <<  n;
//                        0     +      1
//                   00     01  +  11    10
//    000  001   011   010      +    110  111  101   100
        String[] nowCode = new String[length];
        if( n==1 ) {
            nowCode[0] = "0";
            nowCode[1] = "1";
            return nowCode;
        }else{
            String preCode[] = getGray(n-1);
            //将noewConde的下标为 0~preCode.length-1 元素赋值
            for(int i=0; i<preCode.length; i++) {
                nowCode[i] = "0"+preCode[i];
            }
            // 将noewCode下标为preCode.length ~ 2*preCode.length-1(即nowCode.length-1)的元素赋值, 剩余的后面1/2的码要将preCode的值+1按倒序插入nowCode
            for(int i=preCode.length-1; i>=0; i--) {
                nowCode[preCode.length + i] = "1"+preCode[i];
            }
//            for(int i=0; i<preCode.length; i++) {
//                nowCode[length-1-i] = "1"+preCode[i];
//            }

            return nowCode;
        }

    }


}
