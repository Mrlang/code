package proxyTest.CGLib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Mr_liang on 2017/3/14 using IDEA.
 */
public class CGLib_test{
    public static void main(String args[]){
        new proxyFactory().getProxy().execute();
    }

}

class A{
    public void execute(){
        System.out.println("A's execute method");
    }
}

class myInterceptor implements MethodInterceptor{
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //过滤不需要该业务的方法
        if("execute".equals(method.getName())){
            //调用前验证权限(动态添加其他要执行业务)
            System.out.println("proxy is doing check");
            //调用目标对象的方法(执行A对象即被代理对象的execute方法)
            Object obj = methodProxy.invokeSuper(o,objects);
            //记录日志数据(动态添加其他要执行业务)
            System.out.println("proxy is doing log");
            return obj;
        }else if("delete".equals(method.getName())){
            //切向方法加强
        }

        //如果不需要增强直接执行原方法
        return methodProxy.invokeSuper(o,objects);

    }
}

class proxyFactory{
    public A getProxy(){
        // 1.声明增强类实例,用于生产代理类
        Enhancer en = new Enhancer();
        // 2.设置父类，CGLIB根据父类字节码生成子类
        en.setSuperclass(A.class);
        // 3.设置回调函数，即一个方法拦截
        en.setCallback(new myInterceptor());
        // 4.创建代理:
        return (A)en.create();
    }
}


