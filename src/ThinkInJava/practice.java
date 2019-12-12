package ThinkInJava;

import com.sun.org.apache.xalan.internal.utils.XMLSecurityManager;
import org.junit.Test;
import org.omg.CORBA.INTERNAL;
import sun.invoke.empty.Empty;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Mr_liang on 2017/2/28 using IDEA.
 */
public class practice {
    static int deleteNum = 0;
    static String str;

    @Test
    public void a(){
        System.out.println(new t1().hashCode());
        System.out.println(new t1().hashCode());
        AtomicStampedReference a = new AtomicStampedReference<Integer>(100,1);
    }

    @Test
    public void test() throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition con = lock.newCondition();


        new Thread(new ta(lock,con)).start();
        Thread.sleep(3000);
        lock.lock();
        try{
            con.signal();
            Thread.yield();
            System.out.println("end sign");
        }catch(Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public static void main(String args[]) throws IOException {
        //yaoanijinali
//        str = read();
//        str = chuquliangbian(str);
//        System.out.println(str);


/*
       HashMap<String,String> s = new HashMap<String,String>();
        s.put(null,"first");
        s.put("asf",null);
        for( String str : s.keySet()) {
            System.out.println(str);
            System.out.println("--"+s.get(str));
        }
        System.out.println(s.size());

 */
        HashSet<String> set = new HashSet<>();
        set.add("first");
        set.add("second");
        Iterator<String> i = set.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }


    static String  chuquliangbian(String a){
        boolean flag = true;
        while(flag){
            flag = false;
            if(!a.substring(1).contains(a.substring(0,1))){
                flag= true;
                a = a.substring(1);
            }

            if(!a.substring(0,a.length()-1).contains(a.substring(a.length()-1,a.length()))){
                flag= true;
                a = a.substring(0, a.length()-1);
            }

        }
        return a;

    }

    static String read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(System.in)));
        String str = null;
        while((str = reader.readLine()) != null) {
            return str;
        }
        return null;
    }

    static boolean resolve(int[] A) {
        HashMap<Integer,List<Integer>> hashMap = new HashMap<>();
        int beginSum = A[0],    beginIndex=0;
        int endSum = A[A.length-1],     endIndex = A.length-1;
        for(int i=0; i <= A.length/2; i++){
            if(beginSum > endSum)
                endSum += A[--endIndex];
            else if(beginSum < endSum)
                beginSum += A[++beginIndex];
            else{
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(beginIndex);
                l.add(endIndex);
                hashMap.put(beginSum, l);

            }
        }

        return true;
    }
}

class MyData extends Date{
    @Override
    protected void finalize() throws Throwable {
        System.out.println("obj [MyData: "+this.getTime()+"] is gc !");
    }

    @Override
    public String toString() {
        return "MyData: "+getTime();
    }
}
class t1{

}
class ta implements Runnable{
    Lock lock;
    Condition con;
    public ta(Lock lock, Condition c) {
        this.lock = lock;
        this.con = c;
    }

    @Override
    public void run() {
        System.out.println("try to lock");
        lock.lock();
        System.out.println("get lock");
        try{
            System.out.println("try to await");
            con.await();
            System.out.println("end await");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }

    }
}


