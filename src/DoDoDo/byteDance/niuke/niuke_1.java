package DoDoDo.byteDance.niuke;

import java.util.*;

/**
 * Created by wangliang01 on 2020/7/25 using IDEA.
 *
 * 括号字符串的有效性
 *
 * 链接：https://www.nowcoder.com/questionTerminal/769abd985f3849d0b9415b082f94c192
 * 来源：牛客网
 *
 * 输出描述:
 * 输出一行，如果str是整体有效的括号字符串，请输出“YES”，否则输出“NO”。
 * 示例1
 * 输入
 * (())
 * 输出
 * YES
 * 示例2
 * 输入
 * ()a()
 * 输出
 * NO
 * 说明
 * ()a()中包含了 ‘a’，a不是括号字符
 */

//TODO 这个地方必须是public、Main
public class niuke_1 {
    //TODO  main方法的定义记号: static、 args[]
    public static void main(String args[]) {
        //TODO System.in需要传入作为参数
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack();
        for(int i=0; i<str.length(); i++) {
            if(chars[i] != '(' && chars[i] != ')' ) {
                System.out.print("NO");
                return;
            }

            if(stack.isEmpty()) {
                if(chars[i] == ')') {
                    System.out.print("NO");
                    return;
                }else{
                    stack.push(chars[i]);
                }
            }else if(stack.peek().equals(chars[i])) {
                stack.push(chars[i]);
            }else {
                stack.pop();
            }
        }

        if(stack.isEmpty()) {
            System.out.print("YES");
        }else{
            System.out.print("NO");
        }
        return;
    }

    @org.junit.Test
    public void test(){
        char a = '(';
        if(a == '(') {
            System.out.println("123");
        }
    }
}