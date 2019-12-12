package ThinkInJava.Topic_14_Reflect;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr_liang on 2016/11/28.
 */
public class class_14_2_2 {
    @Test
    public void test(){
        Class intClass = int.class;

        if(!int.class.equals(Integer.class)) System.out.println("int not equals Integer");
        Class<Integer> integerClass = int.class;
        integerClass = Integer.class;
        if(intClass.equals(integerClass)) System.out.println("equals");
        if(!int.class.equals(double.class)) System.out.println("int not equals double");
        intClass = double.class;
//        integerClass = double.class;
    }

    @Test
    public void testCounter(){
//        testIdInc();
        FilledList<CountedInteger> newF = new FilledList<CountedInteger>(CountedInteger.class);
        System.out.println(newF.createList(15));
    }
    //测试每new一次 id自动赋值为counter++时的值
    public void testIdInc(){
        CountedInteger c1 = new CountedInteger();
        System.out.println(c1);
        CountedInteger c2 = new CountedInteger();
        System.out.println(c1);
    }

    @Test
    public void testInitial(){
//        Class<CountedInteger> needClass = CountedInteger.class;
//        System.out.println("after create CountedInteger.class ");
//        System.out.println(CountedInteger.counter);

        try{
            Class needClass_2 = Class.forName("CountedInteger");
        }catch (Exception e){
//            System.out.println();
            System.out.println("又是 java.lang.ClassNotFoundException: CountedInteger");
        }
        System.out.println("after Class.forName(\"CountedInteger\") ");
        System.out.println(CountedInteger.counter);

//        Class<CountedInteger> needClass_2 = CountedInteger.class;
//        System.out.println("after create CountedInteger.class ");
//        System.out.println(CountedInteger.counter);
    }

    @Test
    //对象的强制类型转换
    public void ClassCastTest(){
        House house = new House();
        Building building = new Building();
        Class<Building> buildingClass = Building.class;
        Class<House> houseClass = House.class;
//        Building b = buildingClass.cast(house);//相当于  Building b = house;这个算不上强制类型转换
        Building b = (Building) house;
//        b.build();
    }

    @Test
    public void tt() throws ClassNotFoundException {
        Class c = Class.forName("ThinkInJava.Topic_14.House");//必须加完整包名
        Class<House> c1 = (Class<House>)c;
        if(c instanceof Class)
            System.out.println("c instanceof Class");
        if(c1.equals(c))
            System.out.println("c1.equals(c)");
        House house = new House();
        Building building = new Building();
        if(house instanceof Building)
            System.out.println("house instanceof Building");
//        if((new House()) instanceof c)
//            System.out.println();
//        if(new House() instanceof Class<House>)
//            System.out.println();

    }
}

class CountedInteger{
    public static int counter;
    private final int id = counter++;
    static {
        System.out.println("now, load the class");
    }
    CountedInteger(){
        System.out.println("has new a new Instance of CountedInteger");
    }
    public String toString(){
        return "this is CountedInteget Instance - id is "+id+", counter is + "+ counter +"\r\n";
    }
}

class FilledList<T>{
    private Class<T> needClass;

    FilledList(Class<T> c){
        this.needClass = c;
    }

    public List<T> createList(int nElements){
        List<T> result = new ArrayList<T>();

        try {
            for(int i=0; i<nElements; i++){
                T c = needClass.newInstance();
                result.add(c);
                System.out.println(c);
            }
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return result;
    }


}

class Building{
    public String name;
    public void build(){
        System.out.println("build Building");
    }
}

class House extends Building{
    public int height;
    public int length;
    public int width;
    public void build(){
        System.out.println("build House");
    }

}