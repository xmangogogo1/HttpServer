package simpleClientSendReqToServer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pangPython
 *  socket通信，服务器端
 */
public class HttpServ {

    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private InputStream inputStream = null;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;

    public HttpServ(int port) throws IOException {
        System.out.println("服务器启动成功！");
        System.out.println("服务器正在监听"+port+"端口");
        //建立服务端socket
        serverSocket = new ServerSocket(port);
        //监听，等待客户机连接
        socket = serverSocket.accept();
        //获取socket的输入流
        inputStream = socket.getInputStream();
        //输入流读取器
        inputStreamReader = new InputStreamReader(inputStream);
        //缓冲读取
        bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        System.out.println("这是客户端发来的信息：");
        //遍历打印
        while ((line = bufferedReader.readLine())!=null) {
            System.out.println(line);
        }
        System.out.println("完成一次交互");

    }

    public static void main(String[] args) {
        try {
            new HttpServ(9090);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}