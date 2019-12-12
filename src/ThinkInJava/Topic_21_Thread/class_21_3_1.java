package ThinkInJava.Topic_21_Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Mr_liang on 2017/2/19 using IDEA.
 */
public class class_21_3_1 {
    public static void main(String args[]) {
        AbstractIntGenerator gen = new ChildIntGenerator();
        test(gen, 10, 3);

    }

    public static void test(AbstractIntGenerator gen, int count, int testType) {
        System.out.println("press ctrl+c to stop, testType is "+testType);
        ExecutorService ser = Executors.newCachedThreadPool();
        for(int i=0; i< count; i++) {
               ser.execute(new CheckerThread(gen, i, testType));
        }
        ser.shutdown();
    }
}



abstract class AbstractIntGenerator{
    private volatile boolean cancleFlag = false;
    public abstract int next();
    public void cancle(){
        System.out.println("cancle success, all stop");
        cancleFlag = true;
    }
    public boolean getFlag(){
        return cancleFlag;
    }
}

class ChildIntGenerator extends AbstractIntGenerator{
    private volatile int currentValue = 0;
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private Lock lockObject = new ReentrantLock();
    @Override
    public int next() {
        ++currentValue;
        Thread.yield();
        ++currentValue;
        return currentValue;
    }

    public synchronized int nextUseSyn() {
        ++currentValue;
        Thread.yield();
        ++currentValue;
        return currentValue;
    }

    public int nextUseLockObject() {
        lockObject.lock();
        try{
            ++currentValue;
            Thread.yield();
            ++currentValue;
            return currentValue;
        }finally {
            lockObject.unlock();
        }
    }

    public int nextAtomicInteget() {
        return atomicInteger.addAndGet(2);    //在return前,加2成功后可能被其他任务插入,但不会在奇数状态时被插入
    }
}

class CheckerThread extends Thread{
    private AbstractIntGenerator intGenerator;
    private int id;
    private int testType;
    public CheckerThread(AbstractIntGenerator intGenerator, int id, int testType) {
        this.intGenerator = intGenerator;
        this.id = id;
        this.testType = testType;
        System.out.println("create new CheckerThread_"+id + ", testType is "+testType);
    }

    @Override
    public void run() {
        while(!intGenerator.getFlag()) {
            int value = 0;
            switch(testType) {
                case 0:
//                    System.out.println("case 0");
                    value = intGenerator.next();
                    break;
                case 1:
//                    System.out.println("case 1");
                    value = ((ChildIntGenerator)intGenerator).nextUseSyn();
                    break;
                case 2:
//                    System.out.println("case 2");
                    value = ((ChildIntGenerator)intGenerator).nextUseLockObject();
                    break;
                case 3:
                    value = ((ChildIntGenerator)intGenerator).nextAtomicInteget();
                default:
//                    System.out.println("default");
                    System.out.println("value is " + value);
            }

            System.out.println("CheckerThread_"+id+": value is "+ value);
            if(value%2 != 0){
                System.out.println("CheckerThread_"+id+": error, not 2");
                intGenerator.cancle();
            }
        }
        System.out.println("CheckerThread_"+id+": exit");
    }
}
