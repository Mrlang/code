package Algorithm.niuKe.WangYi_Exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 小明走路或者出租车去办公室
 */
public class WangYi_1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int taxiNum = new Integer(sc.nextLine());
        String[] stringX = sc.nextLine().split(" ");
        String[] stringY = sc.nextLine().split(" ");
        int[] taxiX = new int[taxiNum];
        int[] taxiY = new int[taxiNum];
        copyArray(taxiX, stringX);
        copyArray(taxiY, stringY);
        String[] stringOffice = sc.nextLine().split(" ");
        int[] intOffice = new int[]{new Integer(stringOffice[0]), new Integer(stringOffice[1])};
        String[] stringTimes = sc.nextLine().split(" ");
        int[] intTimes = new int[]{new Integer(stringTimes[0]), new Integer(stringTimes[1])};
        int waltTime = walkTime(intOffice, intTimes[0]);
        int taxiTime = taxiTime(intOffice, intTimes[1], intTimes[0], taxiX, taxiY);
        int min = waltTime<taxiTime ? waltTime : taxiTime;
        System.out.println(min);
    }

    public static void copyArray(int[] intArray, String[] stringArray){
        for(int i=0; i<stringArray.length; i++){
            intArray[i] = new Integer(stringArray[i]);
        }
    }

    public static int walkTime(int[] intOffice, int time){
        int all = (Math.abs(intOffice[0]) + Math.abs(intOffice[1])) * time;
        return all;
    }

    public static int taxiTime(int[] intOffice, int taxi, int walk, int[] taxiX, int[] taxiY){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<taxiX.length; i++){
            int walkTime = (Math.abs(taxiX[i]) + Math.abs(taxiY[i])) * walk;
            int taxiTime = (Math.abs(intOffice[0] - taxiX[i]) + Math.abs(intOffice[1] - taxiY[i])) * taxi;
            int total = walkTime + taxiTime;
            min = total<min ? total : min;
        }
        return min;
    }
}

