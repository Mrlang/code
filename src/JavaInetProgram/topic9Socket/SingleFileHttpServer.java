package JavaInetProgram.topic9Socket;



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.FileNameMap;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * TODO: 客户端命令  telnet localhost 8080   ;    GET / HTTP/1.0
 *
 * @author wangliang01 on 2018/1/13
 */
public class SingleFileHttpServer {
    byte[] content;
    String encoding;
    int port;
    String contentType;
    String header;

    public SingleFileHttpServer(byte[] content, String encoding, int port, String contentType){
        this.content = content;
        this.encoding = encoding;
        this.port = port;
        this.contentType = contentType;
        this.header = "HTTP/1.0 200 OK\r\nServer:OneFile\r\nContext-length:" + this.content.length + "\r\nContext-type:"+ contentType +";charset=" + encoding + "\r\n\r\n";

    }

    public static void main(String args[]){
        int port = 8888;
        String encoding = "UTF-8";
        String fileName = "/Users/Mr_liang/Java/code/src/JavaInetProgram/topic9Socket/test.txt";
        Path path = Paths.get(fileName);
        try {
            byte[] data = Files.readAllBytes(path);
            System.out.println(String.valueOf(data));
            FileNameMap map = URLConnection.getFileNameMap();
            System.out.println("fileNameMap is " + map.toString());
            String contentType = map.getContentTypeFor(fileName);
            System.out.println("type is " + contentType);
            SingleFileHttpServer httpServer = new SingleFileHttpServer(data, encoding, port, contentType);
            httpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        while(true){
            Socket client =  serverSocket.accept();
            System.out.println("client is " + client);
            executorService.submit(new HttpClientHandler(client));
        }
    }

    private class HttpClientHandler implements Callable<Object>{
        Socket client;

        HttpClientHandler(Socket client){
            this.client = client;
            System.out.println("this.client is "+ client);
        }

        @Override
        public Object call() throws Exception {
            System.out.println("begin call");
            BufferedInputStream inputStream = new BufferedInputStream(client.getInputStream());
            BufferedOutputStream outputStream = new BufferedOutputStream(client.getOutputStream());
            StringBuilder sb = new StringBuilder(100);
            while(true){
                int c = inputStream.read();
                if(c == '\r' || c == '\n' || c == -1)
                    break;
                sb.append((char) c);

            }
            System.out.println("request header is " + sb);
            if(sb.toString().indexOf("HTTP/") != -1) {  //请求头第一行开头为HTTP 说明是发起的HTTP协议
                outputStream.write((header).getBytes());
            }
            outputStream.write(content);
            outputStream.flush();
            outputStream.close();
            client.close();
            System.out.println("client closed");
            return null;
        }
    }

}

