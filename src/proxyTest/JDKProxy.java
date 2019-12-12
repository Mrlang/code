package proxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Mr_liang on 2017/3/8 using IDEA.
 */
public class JDKProxy {
    public static void main(String args[]) throws ClassNotFoundException {
        child target = new child();
        inter p =  (inter) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new myHandler(target));
        System.out.println("proxy instance is " + p + ", proxy's type  is " + p.getClass().getName());
        System.out.println("invocation type  is " + new myHandler().getClass().getName());
        System.out.println("call HelloWord.sayHello");
        p.sayHello("param1");
    }
    public void sayHello(String arg){
        System.out.println("hello world !"+ arg);
    }


}

interface  inter{
    void sayHello(String arg);
}

class child implements inter{
    @Override
    public void sayHello(String arg) {
        System.out.println("child exec method: say hello");
    }
}

class myHandler implements InvocationHandler{
    private inter target;

    public myHandler() {

    }

    public myHandler(inter target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("sayHello")){
            System.out.println("原方法执行前。。");
            System.out.println("target is " + target);
            System.out.print("原方法执行:");
            method.invoke(target, args);
//            method.invoke(proxy, args);//死循环调用
            System.out.println("原方法执行后。。");
        }

        return null;
    }
}
