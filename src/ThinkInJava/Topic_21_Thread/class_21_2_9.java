package ThinkInJava.Topic_21_Thread;

/**
 * Created by Mr_liang on 2017/2/18.
 */
public class class_21_2_9 {
    public static void main(String args[]){
        new thread1("thread1Name");
        new outer1().begin("thread2Name");
        new outer2("thread3Name");
        new outer3().begin("thread4Name");
        new run1("run1Name");
        new outer4().begin("run2Name");
        new outer5("run3Name");
        new outer6().begin("run4Name");
    }


}

class thread1 extends Thread {
    thread1(String name) {
        super(name);
        start();
    }

    @Override
    public void run() {
        System.out.println("this is thread1");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class outer1 {
    public void begin(String name){
        new thread2(name);
    }
    public class thread2 extends Thread {
        thread2(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            System.out.println("this is thread2 ");
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}

class outer2 {
    public outer2(String name) {
        Thread t = new Thread(name) {
            @Override
            public void run() {
                System.out.println("this is thread3");
            }

            @Override
            public String toString() {
                return super.toString();
            }
        };
        t.start();
    }

}

class outer3{
    private Thread t;
    public void begin(String name){
        if(t==null) {
            t = new Thread(name) {
                @Override
                public void run() {
                    System.out.println("this is thread4");
                }

                @Override
                public String toString() {
                    return super.toString();
                }
            };
        }
        t.start();
    }
}

class run1 implements Runnable{
    run1(String name){
        new Thread(this,name).start();
    }

    @Override
    public void run() {
        System.out.println("this is run1 " + Thread.currentThread().getName());
    }
}

class outer4 {
    public void begin(String name){
        new run2(name);
    }

    private class run2 implements Runnable{
        public run2(String name){
            new Thread(this,name).start();
        }

        @Override
        public void run() {
            System.out.println("this is run2 "+ Thread.currentThread().getName());
        }
    }
}


class outer5{
    public outer5(String name) {
        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("this is run3 " +Thread.currentThread().getName());
            }
        },name);
        t.start();
    }
}

class outer6{
    private Thread run4;
    public void begin(String name){
        if(run4==null){
            run4 = new Thread(new Runnable() {
                @Override
                public void run() {
                   System.out.println("this is run4 " + Thread.currentThread().getName());
                }
            }, name);
        }
        run4.start();
    }
}