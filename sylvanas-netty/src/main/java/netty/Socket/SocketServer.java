package netty.Socket;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws Exception {
        // 监听指定的端口
        int port = 8088;
        ServerSocket server = new ServerSocket(port);
        // server将一直等待连接的到来
        while (true){
            Socket socket = server.accept();
            // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                //获取数据进行处理
                String message = new String(bytes, 0, len,"UTF-8");
                System.out.println(message);
            }
        }

        // socket、server，流关闭操作，省略不表
    }

}
