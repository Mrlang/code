package ThinkInJava.Topic_21_Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by Mr_liang on 2017/3/16 using IDEA.
 */
public class class_21_7_6_Semaphore {
    public static void main(String args[]) {

    }
}

class Pool<T>{
    private int size;
    Semaphore signal;
    List<T> objectList = new ArrayList<T>();
    private volatile boolean[] checkedOut;
    public Pool(Class<T> classObject, int size) throws IllegalAccessException, InstantiationException {
        this.size = size;
        checkedOut = new boolean[size];
        signal = new Semaphore(size, true);
        for(int i=0; i< size; i++) {
            objectList.add(classObject.newInstance());
        }
    }

    public T checkOut() throws InterruptedException {
        signal.acquire();
        return getObject();
    }

    public synchronized T getObject(){
        for(int i=0; i< size; i++) {
            if(!checkedOut[i]) {
                checkedOut[i] = true;
                return objectList.get(i);
            }
        }
        return null;
    }

    public void checkIn(T obj){
        if(checkInObject(obj))
            signal.release();

    }

    public synchronized boolean checkInObject(T obj){
        int index = objectList.indexOf(obj);
        if(index==-1)    return false;
        if(checkedOut[index]){
            checkedOut[index] = false;
            return true;
        }
        return false;
    }
}
