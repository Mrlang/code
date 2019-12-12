package Algorithm;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;

/**
 * 熊吃糖
 * Created by Mr_liang on 2017/9/2 using IDEA.
 */
public class pingDuoDuo {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int bearNum = sc.nextInt();
        int foodNum = sc.nextInt();
        List<Bear> bears = new ArrayList<Bear>();
        //TODO
        List<Bear> saveBears  = new ArrayList<Bear>(bears.size());

        int[] foodInfo = new int[0];
        if(foodNum!=0)
            foodInfo = new int[foodNum];
        for(int i=0; i<foodNum; i++) {
            foodInfo[i] = sc.nextInt();
        }
        Arrays.sort(foodInfo);

        for(int i=0; i<bearNum; i++) {
            Bear a = new Bear(sc.nextInt(), sc.nextInt());
            bears.add(a);
            saveBears.add(a);
        }
        Collections.sort(bears);
        int currentIndex;
        //TODO
        int[] foodFlag = new int[foodNum];
        for(int i=0; i<foodNum; i++) {
            foodFlag[i] = 1;
        }
        for( Bear bear: bears) {
            currentIndex = foodNum - 1;
            while( currentIndex>=0 ) {
                if( bear.remain >= foodInfo[currentIndex] && foodFlag[currentIndex] == 1){
                    bear.remain = bear.remain - foodInfo[currentIndex];
                    foodFlag[currentIndex] = 0;
                    currentIndex--;
                }else {
                    currentIndex--;
                    continue;
                }
            }
        }

        for( Bear bear: saveBears) {
            System.out.println(bear.remain);
        }
    }
}

class Bear implements Comparable<Bear>{
    public int fight;
    public int remain;

    public Bear(int fight, int remain) {
        this.fight = fight;
        this.remain = remain;
    }

    @Override
    public int compareTo(Bear o) {
        if(o.fight == this.fight)
            return 0;
        if(o.fight > this.fight)
            return  1;
        if(o.fight < this.fight)
            return -1;
        return 0;
    }


}
