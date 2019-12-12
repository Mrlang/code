package Algorithm.AlgorithmHomeWork;

/**
 * Created by Mr_liang on 2016/12/1.
 */
public class aa {
        /*
		int begin=1,                    //表示求该点到各点的距离
            n=1,usedPointNum=1, min;
		int[] mark = new int[7],        //标记用过的点,用过的意思就是已经找到了begin到某点的最短距离,将该点标记为用过,下次不再计算该点。mark[5]=1表示点5被用过。没有点0,所以mark[0]无实际意义
              countLength = all[1],     //countLength[n]表示 点begin 到 点n 的距离,当通过贪心算法得到更短的距离时就更新countLength[n]
              usedPoint = new int[7];   //将用过的点放入该集合,usedPoint{1,3}表示点1,3已经被用过

        usedPoint[0] = begin;           //直接将点1放入已用定点中
		mark[1] = 1;                    //被放入usedPonit的点都会被标记为1
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

            for(int i=0; i<endPoint.size(); i++){
                int end = endPoint.get(i),mid = midPoint.get(i);
                //endPoint.clear(); midPoint.clear();   //用完必须清空,但不是在这里清除
                if(mid == begin)        {countLength[end] = min;}
                else if(countLength[mid] + min < countLength[end])      {countLength[end] = countLength[mid] + min;}
                usedPoint[usedPointNum++] = end;
                mark[end] = 1;
                n++;
            }
            endPoint.clear(); midPoint.clear();         //清除记录的end,进行下一轮最短路径的查找

            //System.out.println("point "+begin+"--> point midPoint("+midPoint+"), length is"+ countLength[midPoint] +";point midPoint-->point "+endPoint+",length is "+min);
		}


		for(int e=1; e<countLength.length; e++){
            System.out.println("point "+begin+"--> point "+ e +",length is "+countLength[e]);
        }

		*/
}
