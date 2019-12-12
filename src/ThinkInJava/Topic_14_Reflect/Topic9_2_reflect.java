package ThinkInJava.Topic_14_Reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Created by Mr_liang on 2016/12/5.
 */
public class Topic9_2_reflect {
    @Test
    public void test() throws Exception{
        Class<Student> studentClass = Student.class;
        //使用new 关键字和反射的newInstance方法创建对象,都是调用的类的构造函数
        Constructor<Student> cons = studentClass.getConstructor();
        Student stu = cons.newInstance();
        System.out.println(stu);

        cons = studentClass.getConstructor(String.class, int.class);
        stu = cons.newInstance("wang", 20);
        System.out.println(stu);
    }

    @Test
    //可以通过反射来获取指定对象的私有属性
    public void test1() throws Exception{
        Student stu = new Student("liang", 20);
        Field nameField = stu.getClass().getDeclaredField("name");
        nameField.setAccessible(true);//java.lang.IllegalAccessException: Class Interview.Topic_9_2 can not access a member of class
        String n = (String)nameField.get(stu);
        System.out.println(n);

    }

    @Test
    //通过反射动态返回toString内容显示对象每个属性的信息  主要用于数据对象,如bean,entity
    public void tes3(){
        DataObject db = new DataObject("wang", 20, "liang", "others infomation");
        System.out.println(db);
    }

}

class Student{
    private String name;
    private int age;
    public Student(){}
    public Student(String n,int a){
        this.age = a;
        this.name = n;
    }

    public String toString(){
        return "stu:name is "+name+", age is" +age;
    }
}

class DataObject{
    private String name;
    private int age;
    private String desc;
    private String other;

    public DataObject(String name, int age, String desc, String other) {
        this.name = name;
        this.age = age;
        this.desc = desc;
        this.other = other;
    }

    @Override
    public String toString () {
        StringBuffer sb = new StringBuffer();
        Field[] allField = this.getClass().getDeclaredFields();
        for(Field f : allField){
            try{
                sb.append(f.getName() + " = " + f.get(this));
            }catch(Exception e){
                e.printStackTrace();
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}


