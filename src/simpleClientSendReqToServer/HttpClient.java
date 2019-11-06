package simpleClientSendReqToServer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author pangPython
 *  socket通信客户端
 */
public class HttpClient {

    private Socket socket = null;
    private OutputStream outputStream = null;
    private PrintWriter printWriter;

    public HttpClient(String host,int port) throws UnknownHostException, IOException {
        //进行socket连接
        socket = new Socket(host, port);
        //获取输出流
        outputStream = socket.getOutputStream();
        //输出流打印器
        printWriter = new PrintWriter(outputStream);
        //写出要发送的信息
        printWriter.write("本消息是客户端发来的信息...");
        //将信息刷入socket
        printWriter.flush();
        //关闭释放资源
        System.out.print("sending request to server...");

        printWriter.close();
        outputStream.close();
        socket.close();
    }

    public static void main(String[] args) {
        try {
            new HttpClient("127.0.0.1", 9090);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}