package Algorithm;
import java.util.Scanner;
public class ali_1 {

    private static int process(boxTemplate boxTemplate, Model[] items) {


        return -1;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        boxTemplate boxTemplate= new boxTemplate(2000);

        boxTemplate.length = scanner.nextInt();
        boxTemplate.width = scanner.nextInt();
        boxTemplate.height = scanner.nextInt();
        Model[] items;
        int itemNum = scanner.nextInt();
        items = new Model[itemNum];
        for (int i = 0; i < itemNum; i++) {
            Model item = new Model();
            item.price = scanner.nextInt();
            item.length = scanner.nextInt();
            item.width = scanner.nextInt();
            item.height = scanner.nextInt();
            items[i] = item;
        }
        long startTime = System.currentTimeMillis();
        int boxMinNum = Integer.MAX_VALUE;
        System.out.println(process(boxTemplate, items));




    }
}

class boxTemplate{
    public Integer length;
    public Integer width;
    public Integer height;
    public Integer price;

    public boxTemplate(Integer price) {
        this.price = price;
    }
}

class Model{
    public Integer price;
    public Integer length;
    public Integer width;
    public Integer height;

}