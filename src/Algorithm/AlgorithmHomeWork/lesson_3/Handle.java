package Algorithm.AlgorithmHomeWork.lesson_3;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Handle {
	private static int M = Integer.MAX_VALUE - 1000;  //M不能是MAX_VALUE,否则M+1变成负数
	private static int[][] all = {      //整体矩阵，长度为7， 没有第0个顶点， 下标为1-6元素的有效
        {},
        {M,M,2,15,M,M,M},
        {M,20,M,M,M,10,30},
        {M,M,4,M,M,M,10},
        {M,M,M,M,M,M,M},
        {M,M,M,M,15,M,M},
        {M,M,M,M,4,10,M},
	};

	public static void main(String args[]){
		handleQuestion_3();
	}
	
	public static void  handleQuestion_1(){
        getPointLength(1, "./dijkstra－output1.txt");
	}

    public static void handleQuestion_2(){
        for(int i=1; i<all.length; i++) {
            getPointLength(i, "./dijkstra－output2.txt");
        }
    }

    public static void handleQuestion_3(){
        int[][] a = all;
        for(int i=1; i<a.length; i++){
            for(int k=1; k<a.length; k++){
                for(int j=1; j<a.length; j++){
                    if(a[i][j] > a[i][k] + a[k][j] && a[i][k]!=M && a[k][j]!=M) {           //如果a[i][k]和a[k][j]任一个位M,和就会变成负的
                        a[i][j] = a[i][k] + a[k][j];
                    }
                }
            }
        }

        for(int i=1; i<a.length; i++){
            printCountLength(i, a[i], "./floyd－output1.txt");
        }

    }
	
	private static void printCountLength(int begin,int[] a, String fileName){
        FileOutputStream fileOutputStream = null;
        for(int e=1; e<a.length; e++){
            Object len = a[e];
            if((Integer)len == M)    len = "MAX_LENGTH";
            String outPut = "point "+begin+"--> point "+ e +",length is "+len+"\r\n";
            try {
                fileOutputStream = new FileOutputStream(fileName, true);
                fileOutputStream.write(outPut.getBytes());
            }catch (Exception ee){
                ee.printStackTrace();
            }
            System.out.print(outPut);
        }
    }

    //以b为开始点,b到各点的最距离
    private static void getPointLength(int b, String fileName){
        int begin=b,                    //表示求该点到各点的距离
                n=1,usedPointNum=1, min;
        int[] mark = new int[7],        //标记用过的点,用过的意思就是已经找到了begin到某点的最短距离,将该点标记为用过,下次不再计算该点。mark[5]=1表示点5被用过。没有点0,所以mark[0]无实际意义
                countLength = all[begin],     //countLength[n]表示 点begin 到 点n 的距离,当通过贪心算法得到更短的距离时就更新countLength[n]
                usedPoint = new int[7];   //将用过的点放入该集合,usedPoint{1,3}表示点1,3已经被用过

        usedPoint[0] = begin;           //直接将点1放入已用定点中
        mark[begin] = 1;                    //被放入usedPonit的点都会被标记为1
        List<Integer> endPoint = new ArrayList<Integer>();
        List<Integer> midPoint = new ArrayList<Integer>();

        while(n<all.length-1){
            min=M;
            for(int q=0; q<usedPointNum; q++){
                int u = usedPoint[q];

                for(int i=1; i<=all.length-1; i++){
                    if(mark[i]!=1 && all[u][i] <= min &&  all[u][i]!=M){      //if(mark[i]!=1 && all[u][i] < min)min=all[u][i];endPoint = i;midPoint = u;逻辑坑:当usedPoint={1,2,5}时;u[1][3]=15,会先用min记录下u[1][3]的15,当遍历到u=5时,u[5][4]<min不成立,没有在第一时间将点4放入usedPoint,导致点4最后放入,countLength[4]记录的29不是1到4的最短距离
                        //endPoint.add(i);          这里不能直接add,可能之前那个end点是最小值,但现在这里有了路径更短的点,现在应该把之前记录的end点删掉(不能把他加入usedPoint),然后再重新添加end点
                        //midPoint.add(u);
                        if(all[u][i]<min){
                            endPoint.clear();midPoint.clear();endPoint.add(i);midPoint.add(u);
                        }else {
                            endPoint.add(i);midPoint.add(u);
                        }
                        min = all[u][i];
                    }

                }
            }

            if(endPoint.size()>0){
                for(int i=0; i<endPoint.size(); i++){
                    int end = endPoint.get(i),mid = midPoint.get(i);
                    //endPoint.clear(); midPoint.clear();   //用完必须清空,但不是在这里清除
                    if(mid == begin)        {countLength[end] = min;}
                    else if(countLength[mid] + min < countLength[end])      {countLength[end] = countLength[mid] + min;}
                    if(all[end][begin]!=M && all[end][begin] + min < countLength[begin])    countLength[begin] = all[end][begin] + min;//pointt1-> point2->point1就形成了回路
                    usedPoint[usedPointNum++] = end;
                    mark[end] = 1;
                    n++;
                }
                endPoint.clear(); midPoint.clear();         //清除记录的end,进行下一轮最短路径的查找
            }else
                n++;


        }
        printCountLength(begin,countLength,fileName);
    }
	
}
