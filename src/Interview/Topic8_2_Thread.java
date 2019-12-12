package Interview;

import org.junit.Test;

/**
 * Created by Mr_liang on 2016/12/5.
 */

// https://my.oschina.net/xubohui/blog/87721
public class Topic8_2_Thread {
    @Test
    public void testThread(){
//        allThreadIsOne();
//        System.out.println("==========================");
        allThreadUseDifferetVariable();
        System.out.println("Thread类实际上无法达到资源共享的目的。");
    }

    @Test
    public void saveThreadProblem(){
        SaveHandle s = new SaveHandle();
        s.getInstance().start();
        s.getInstance().start();
        s.getInstance().start();
        s.getInstance().start();
    }

    @Test
    //不知道这个对不对
    /*看来是错误的,不同步
    Thread-1   10
    Thread-1   9
    Thread-1   8
    Thread-1   7
    Thread-1   6
    Thread-1   5
    Thread-1   4
    Thread-1   3
    Thread-1   2
    Thread-1   1
    Thread-0   10
    */
    public void sava2(){
        new SavaHandle2().start();
        new SavaHandle2().start();
        new SavaHandle2().start();
        new SavaHandle2().start();
    }

    @Test
    public void testRunnable(){
        Runnable r = new RunnableTest();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        System.out.println("所有线程合作轮流减值count");
    }

    //所有的t是同一个线程,后面的n-1个 t.start()没用。
    public void allThreadIsOne(){
        ThreadTest t = new ThreadTest();
        t.start();
        t.start();
        t.start();
        t.start();
    }

    //4个线程竟然是各自操作各自的count,这样售票漏洞
    public void allThreadUseDifferetVariable(){
        new ThreadTest().start();
        new ThreadTest().start();
        new ThreadTest().start();
        new ThreadTest().start();
    }


}

class ThreadTest extends Thread
{
    private int count=10;
    public void run()
    {
        while(count>0)
        {
            System.out.println(Thread.currentThread().getName() + "   " + count--);
        }
    }
}

class AA{
    public static final String s = "sd";
}

class RunnableTest implements Runnable
{
    private int count=10;
    public void run()
    {
        while(count>0)
        {
            synchronized (AA.s) {
                System.out.println(Thread.currentThread().getName() + "   " + count--);
            }
        }
    }
}

class SaveHandle{
    private int count=10;
    private class InnerThreadClass extends Thread{
        public void run(){
            while(count>0)
            {
//            synchronized (AA.s) {
                System.out.println(Thread.currentThread().getName() + "   " + count--);
//            }
            }
        }
    }

    public  Thread getInstance(){
        return new InnerThreadClass();
    }
}

class SavaHandle2 extends Thread{
    public static int count=10;
    public void run(){
        while (count>0){
            System.out.println(Thread.currentThread().getName() + "   " + count--);
        }
    }

}