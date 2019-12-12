package ThinkInJava.Topic_14_Reflect;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

/**
 * Created by Mr_liang on 2016/12/14.
 */
public class class_14_7_2 {
    @Test
    public void tst(){
        GoodSutdent goodSutdent = new GoodSutdent();
        IStudent student = (IStudent)Proxy.newProxyInstance(IStudent.class.getClassLoader(),
                IStudent.class.getInterfaces(),
                new invocationHandlerImpl(goodSutdent));
        student.study();
        student.talk();
    }

    public static void main(String args[]){
        //对真正的对象调用方法
        realObj r = new realObj();
        test(r);

        //对代理调用方法,是代理调用真正对象的方法
        //实力化一个动态代理实例对象,这个对象也是接口的子类,通过给Proxy.newProxyInstance()传参:第一个参数the class loader to define the proxy class,第二个参数the list of interfaces for the proxy class to implement,第三个参数the instance implaments inerface InvocationHandle to dispatch method invocations to
        Inter proxy = (Inter)Proxy.newProxyInstance(Inter.class.getClassLoader(), new Class[]{ Inter.class }, new DynamicProxyObj(r));
        test(proxy);
    }

    public static void test(Inter i) {
        i.doFirst();
        i.doSecond("22");
    }

    //第二个动态代理类的自己实现
    @Test
    public void test(){
        CommonChildClass c = new CommonChildClass();
        TotalParent pro = (TotalParent)Proxy.newProxyInstance(TotalParent.class.getClassLoader(),new Class[]{ TotalParent.class }, new DynamicProxy(c));
        pro.say();
    }


}


class DynamicProxyObj implements InvocationHandler{
    private Inter realObj;

    public DynamicProxyObj(Inter realObj) {
        this.realObj = realObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("------proxy:"+ proxy.getClass() + " , method " + method + " , args "+ args);
        if(args!=null)
            for(Object arg : args) {System.out.println("   "+arg);}
        return method.invoke(realObj, args);
    }
}

//第二个例子,动态代理类
interface  TotalParent {
    void say();

    void eat();

    void learn();
}

class CommonChildClass implements TotalParent{
    @Override
    public void say() {
        System.out.println("CommonChildClass is saying!~~~~");
    }

    @Override
    public void eat() {
        System.out.println("CommonChildClass is eating!~~~~");
    }

    @Override
    public void learn() {
        System.out.println("CommonChildClass is learning!~~~~");
    }
}

//静态代理,组合进一个代理实例,代理类和代理实例属于并列关系,都是父类的子类。静态代理类需要一个个覆写父类方法,分别在每个父类方法中调用代理对象的方法,父类有多少个方法,就要覆写多少个方法。
class StaticProxy implements TotalParent{
    protected TotalParent obj;
    public void FilterClass(TotalParent obj){
        this.obj = obj;
    }

    @Override
    public void say() {
        System.out.print("this is FilterChildClass say(): ");
        obj.say();
    }

    @Override
    public void eat() {
        System.out.print("this is FilterChildClass eat(): ");
        obj.eat();
    }

    @Override
    public void learn() {
        System.out.print("this is FilterChildClass learn(): ");
        obj.learn();
    }
}

//动态代理,并不继承自父类,组合进一个代理对象。使用方法映射,不需要一个个覆写父类的方法,只需要一个invoke方法,便可将动态代理对象被调用的方法通过映射,调用到代理对象的相应方法。
class DynamicProxy implements InvocationHandler{
    TotalParent obj;
    public DynamicProxy(TotalParent obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print("this is DynamicProxy'invoke() : ");
        return method.invoke(obj,args);
    }
}

interface IStudent{
    void study();
    void talk();
}

class invocationHandlerImpl implements InvocationHandler{
    private IStudent proxyObj;
    invocationHandlerImpl(IStudent proxyObj){
        proxyObj = proxyObj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Exception{
        System.out.println("this is before method invoke");
        return method.invoke(proxyObj, args);
    }
}

class GoodSutdent implements IStudent{
    public GoodSutdent() {

    }

    @Override
    public void study() {
        System.out.println("this is good student studying");
    }

    @Override
    public void talk() {
        System.out.println("this is good student talking");
    }
}


class test{

}