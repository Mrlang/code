package Algorithm.RuanJianGongCheng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Mr_liang on 16/9/18.
 */
public class ChuCao {
    public static void main(String args[]){
        handler h = new handler();
        h.run();
    }
}


abstract class handlerApi {
    protected int allCount,delCount,result;
    protected int[] numbers,reNumbers,maxLength,reMaxLength,addArrray;
    protected BufferedReader buf;
    protected Scanner sca;

    public void run() {
        try {
            this.getCount();
            this.getNumbers();
            this.getReNumbers();
            this.getMaxLengthArray(this.numbers, this.maxLength);
            this.getMaxLengthArray(this.reNumbers, this.reMaxLength);
            this.addArrays();
            this.getMaxLength();
            this.getRes();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public abstract void getCount() throws IOException;
    public abstract void getNumbers();
    public abstract void getReNumbers();
    public abstract void addArrays();
    public abstract void getMaxLength();
    public abstract void getMaxLengthArray(int[] num, int[] maxLength);
    public abstract void getRes();
}


class handler extends handlerApi{
    public handler() {
        this.buf = new BufferedReader(new InputStreamReader(System.in));
        this.sca = new Scanner(System.in);
    }

    @Override
    public void getCount() throws IOException {
        System.out.println("请输入数字个数:");
        String str = this.buf.readLine();
        this.allCount = Integer.parseInt(str);
        this.numbers = new int[this.allCount];
        this.reNumbers= new int[this.allCount];
        this.maxLength = new int[this.allCount];
        this.reMaxLength = new int[this.allCount];
        this.addArrray = new int[this.allCount];
        System.out.println(this.allCount);
    }

    @Override
    public void getNumbers() {
        System.out.println("请输入每个数字(以空格隔开),输入一个字母结束:");

//        for (int i = 0; i < this.allCount; i++) {
//            int x = this.sca.nextInt();
//            this.numbers.add(x);
//        }
//        System.out.println("你输入的是:");
//        for(Integer str:this.numbers)
//        {
//            System.out.println(str);
//        }

        int i = 0;
        while (this.sca.hasNextInt()) {
            int x = this.sca.nextInt();
            this.numbers[i] = x;
            i++;
            System.out.println("i is " + i + "number is " + x);
        }

        System.out.println("你输入的是:");
        for (int m = 0; m < this.allCount; m++) {
            System.out.println(this.numbers[m]);
        }

    }

    @Override
    public void getReNumbers() {
        int index = 0;
        for (int i = 0; i < this.allCount; i++) {
            index = this.allCount - 1 -i;
            this.reNumbers[index] = this.numbers[i];
        }
    }

    @Override
    public void addArrays() {
        for (int i = 0; i < this.allCount; i++) {
            this.addArrray[i] = this.maxLength[i] + this.reMaxLength[i] - 1;
        }
    }


    @Override
    public void getMaxLength() {
        int max = 0;
        for (int i = 0; i < this.allCount; i++) {
            max = this.addArrray[i] > max ? this.addArrray[i] : max;
        }
        this.result = this.allCount - max;
    }

    @Override
    public void getRes() {
        System.out.println("del num is : " + this.result);
    }

    @Override
    public void getMaxLengthArray(int[] num, int[] length) {
        int maxLen;
        length[0] = 1;
        for (int i = 1; i < this.allCount; i++) {
            maxLen = 0;
            for (int j = 0; j < i; j++) {
                if(num[i] > num[j] && length[j] > maxLen)
                    maxLen = length[j];
            }
            length[i] = maxLen + 1;
        }
    }

}
