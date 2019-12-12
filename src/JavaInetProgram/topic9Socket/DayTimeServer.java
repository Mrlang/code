package JavaInetProgram.topic9Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 功能说明
 *
 * @author wangliang01 on 2018/1/11getCategoryList
 */
public class DayTimeServer {
    public final static int PORT = 8888;

    public static void main(String args[]){
        try(ServerSocket server = new ServerSocket(PORT)){
            while(true){
                try{
//                    Writer writer = new OutputStreamWriter(client.getOutputStream());
//                    writer.write(new Date().toString() + "\r\n");
                    Socket client = server.accept();
                    BufferedOutputStream writer= new BufferedOutputStream(client.getOutputStream());
                    writer.write((new Date().toString() + "\r\n").getBytes());
                    writer.flush();
//                    writer.close();
                    client.close(); //try-whith-resources会自动将里面声明的closeable对象关闭
                }catch(Exception e) {
                    e.printStackTrace();
                }

            }
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}
