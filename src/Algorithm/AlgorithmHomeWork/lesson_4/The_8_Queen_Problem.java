package Algorithm.AlgorithmHomeWork.lesson_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Mr_liang on 2016/12/13.
 */
public class The_8_Queen_Problem {
    private static int N;                //阶数
    private static int[] position;       //position[i]表示第i个皇后的位置:位于第i行,第posistion[i]列
//    private static int savedNum = 0;     //目前已经为多少个皇后确定了合理位置

    public static void main(String args[]){
        getNum();
        position = new int[N];
        for(int i=0; i<N; i++){
            position[i] = -1;           //初始化数组
        }

        backHandle(0);                  //首先为第0个皇后找位置,然后往下递归
    }


    private static void backHandle(int savedNum){
        if(savedNum>=N)
            printPosition();                        //判断如果n个皇后都已近确定了位置,就打印出来
        else {
            for(int i=0; i<N; i++){
                position[savedNum] = i;             //下标为savedNum的皇后确定位置
                if(check(savedNum))                         //检查确定的位置是否合理
                {
                    backHandle(savedNum+1);
                }
            }

        }

    }

    public static void getNum(){
        System.out.print("please input an Integer:");
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
        try {
            N = Integer.parseInt(reader.readLine());
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("the N is "+ N);

    }

    private static void printPosition(){
        System.out.println("解决方案:----------------------------------");
        for(int i=0; i<N; i++){
            System.out.println("第"+ i +"个皇后位置:("+ i +","+ position[i] +")");
        }
    }

    //检查最新添加的这个皇后的位置是否可行合理
    private static boolean check(int savedNum){
        for(int i=0; i<savedNum; i++)
            //判断如果两个皇后位于同一列,或者位于同一斜线上;说明新确定的这个皇后的位置不合理
            if( position[i]==position[savedNum] || Math.abs(i-savedNum)==Math.abs(position[i]-position[savedNum]))
                return false;
        return true;

    }
}


/*
//运行结果num=4:
please input an Integer:4
the N is 4
解决方案:----------------------------------
第0个皇后位置:(0,1)
第1个皇后位置:(1,3)
第2个皇后位置:(2,0)
第3个皇后位置:(3,2)
解决方案:----------------------------------
第0个皇后位置:(0,2)
第1个皇后位置:(1,0)
第2个皇后位置:(2,3)
第3个皇后位置:(3,1)
Process finished with exit code 0


//运行结果num=5:
please input an Integer:5
the N is 5
解决方案:----------------------------------
第0个皇后位置:(0,0)
第1个皇后位置:(1,2)
第2个皇后位置:(2,4)
第3个皇后位置:(3,1)
第4个皇后位置:(4,3)
解决方案:----------------------------------
第0个皇后位置:(0,0)
第1个皇后位置:(1,3)
第2个皇后位置:(2,1)
第3个皇后位置:(3,4)
第4个皇后位置:(4,2)
解决方案:----------------------------------
第0个皇后位置:(0,1)
第1个皇后位置:(1,3)
第2个皇后位置:(2,0)
第3个皇后位置:(3,2)
第4个皇后位置:(4,4)
解决方案:----------------------------------
第0个皇后位置:(0,1)
第1个皇后位置:(1,4)
第2个皇后位置:(2,2)
第3个皇后位置:(3,0)
第4个皇后位置:(4,3)
解决方案:----------------------------------
第0个皇后位置:(0,2)
第1个皇后位置:(1,0)
第2个皇后位置:(2,3)
第3个皇后位置:(3,1)
第4个皇后位置:(4,4)
解决方案:----------------------------------
第0个皇后位置:(0,2)
第1个皇后位置:(1,4)
第2个皇后位置:(2,1)
第3个皇后位置:(3,3)
第4个皇后位置:(4,0)
解决方案:----------------------------------
第0个皇后位置:(0,3)
第1个皇后位置:(1,0)
第2个皇后位置:(2,2)
第3个皇后位置:(3,4)
第4个皇后位置:(4,1)
解决方案:----------------------------------
第0个皇后位置:(0,3)
第1个皇后位置:(1,1)
第2个皇后位置:(2,4)
第3个皇后位置:(3,2)
第4个皇后位置:(4,0)
解决方案:----------------------------------
第0个皇后位置:(0,4)
第1个皇后位置:(1,1)
第2个皇后位置:(2,3)
第3个皇后位置:(3,0)
第4个皇后位置:(4,2)
解决方案:----------------------------------
第0个皇后位置:(0,4)
第1个皇后位置:(1,2)
第2个皇后位置:(2,0)
第3个皇后位置:(3,3)
第4个皇后位置:(4,1)
Process finished with exit code 0


//运行结果num=6:
please input an Integer:6
the N is 6
解决方案:----------------------------------
第0个皇后位置:(0,1)
第1个皇后位置:(1,3)
第2个皇后位置:(2,5)
第3个皇后位置:(3,0)
第4个皇后位置:(4,2)
第5个皇后位置:(5,4)
解决方案:----------------------------------
第0个皇后位置:(0,2)
第1个皇后位置:(1,5)
第2个皇后位置:(2,1)
第3个皇后位置:(3,4)
第4个皇后位置:(4,0)
第5个皇后位置:(5,3)
解决方案:----------------------------------
第0个皇后位置:(0,3)
第1个皇后位置:(1,0)
第2个皇后位置:(2,4)
第3个皇后位置:(3,1)
第4个皇后位置:(4,5)
第5个皇后位置:(5,2)
解决方案:----------------------------------
第0个皇后位置:(0,4)
第1个皇后位置:(1,2)
第2个皇后位置:(2,0)
第3个皇后位置:(3,5)
第4个皇后位置:(4,3)
第5个皇后位置:(5,1)
Process finished with exit code 0
 */