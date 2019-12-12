package Algorithm.niuKe.ali;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Mr_liang on 2017/4/26 using IDEA.
 */
public class a {
    public static void main(String[] args) {
//        String str="2 3 4*^5+";
        String str = new Scanner(System.in).nextLine();
        Stack stack=new Stack();
        char c;
        String s="";
        int r=0;
        for(int i=0;i<str.length();i++){
            c=str.charAt(i);
            if(c>47 && c <58) {
                s+=c;
            }else if(c=='+'){
                if(!s.equals("")) {
                    if(stack.size()>=16) {
                        r = -2;
                        break;
                    }
                    stack.push(Integer.parseInt(s));
                    s = "";
                }
                if(stack.size()<2){
                    r=-1;
                    break;
                }
                int a= (int)stack.pop();
                int b=(int)stack.pop();
                if(stack.size()>=16){
                    r=-2;
                    break;
                }
                stack.push(a+b);
            }else if(c=='^'){
                if(!s.equals("")) {
                    if(stack.size()>=16){
                        r=-2;
                        break;
                    }
                    stack.push(Integer.parseInt(s));
                    s = "";
                }
                if(stack.size()<1){
                    r=-1;
                    break;
                }
                int a=(int)stack.pop()+1;
                if(stack.size()>=16){
                    r=-2;
                    break;
                }
                stack.push(a);
            }else if(c=='*'){
                if(!s.equals("")) {
                    if(stack.size()>=16){
                        r=-2;
                        break;
                    }
                    stack.push(Integer.parseInt(s));
                    s = "";
                }
                if(stack.size()<2){
                    r=-1;
                    break;
                }
                int a=(int)stack.pop();
                int b=(int)stack.pop();
                if(stack.size()>=16) {
                    r=-2;
                    break;
                }
                stack.push(a*b);
            }else if(c==' '&& !s.equals("")){
                if(stack.size()>=16) {
                    r=-2;
                    break;
                }
                stack.push(Integer.parseInt(s));
                s="";
            }
        }
        if(r==0)
            r=(int)stack.pop();
        System.out.println(r);
    }
}