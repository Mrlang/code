package ThinkInJava.Topic_14_Reflect;

/**
 * Created by Mr_liang on 2016/12/4.
 */
public class class_14_8_1 {

}

class Person{
    public final String first;
    public final String last;
    public final String address;

    Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    public String toString(){
        return("Person :"+first + " " + last + " " + address);
    }

    public static class NullPerson extends Person implements  Null{
        private NullPerson(){
            super("None", "None", "None");
        }
    }

    public static final Person NULL= new NullPerson();

   public static void main(String a[]){
        Person n = Person.NULL;
    }
}

interface Null{}
