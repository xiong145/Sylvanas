package webService.serviceMain;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xiong
 */
public class WebMain {
    public WebMain() {

    }

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9901);
        System.out.println("server is running...");

        while (true) {
            Socket sock = ss.accept();
            System.out.println("connected from " + sock.getRemoteSocketAddress());
            Thread t = new Handler(sock);
            t.start();
        }
    }
}
