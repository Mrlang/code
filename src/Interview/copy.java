package Interview;

/**
 * Created by Mr_liang on 2017/1/23.
 */
public class copy {
    public static void main(String args[]){
        student stu = new student("wang", 12);
        student stu_copy = null;
        try {
             stu_copy = stu.clone();
        }catch (Exception e){
            e.printStackTrace();
        }
        String a = "aaa";
        String b =a;
        System.out.println(b);
        a = "123";
        System.out.println(b);
        System.out.println(a);
        stu_copy.name = stu.name;
        System.out.println(stu.name +"," + stu.age);
        System.out.println(stu_copy.name +"," + stu_copy.age);
        stu.name= "liang";
        System.out.println(stu.name +"," + stu.age);
        System.out.println(stu_copy.name +"," + stu_copy.age);
    }

}


class student implements Cloneable{
    String name;
    int age;
    student(String  name, int age){
        this.age = age;
        this.name = name;
    }

    @Override
    protected student clone() throws CloneNotSupportedException {
        return (student) super.clone();
    }



}