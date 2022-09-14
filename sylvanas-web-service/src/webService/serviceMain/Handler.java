package webService.serviceMain;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Handler extends Thread {

    Socket sock;

    public Handler(Socket sock) {
        this.sock = sock;
    }

    @Override
    public void run() {
        try {
            InputStream input = this.sock.getInputStream();
            Throwable var2 = null;

            try {
                OutputStream output = this.sock.getOutputStream();
                Throwable var4 = null;

                try {
                    this.handle(input, output);
                } catch (Throwable var32) {
                    var4 = var32;
                    throw var32;
                } finally {
                    if (output != null) {
                        if (var4 != null) {
                            try {
                                output.close();
                            } catch (Throwable var31) {
                                var4.addSuppressed(var31);
                            }
                        } else {
                            output.close();
                        }
                    }

                }
            } catch (Throwable var34) {
                var2 = var34;
                throw var34;
            } finally {
                if (input != null) {
                    if (var2 != null) {
                        try {
                            input.close();
                        } catch (Throwable var30) {
                            var2.addSuppressed(var30);
                        }
                    } else {
                        input.close();
                    }
                }

            }
        } catch (Exception var36) {
            try {
                this.sock.close();
            } catch (IOException var29) {
            }

            System.out.println("client disconnected.");
        }

    }

    private void handle(InputStream input, OutputStream output) throws IOException {
        System.out.println("Process new http request...");
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        boolean requestOk = false;
        String first = reader.readLine();
        if (first.startsWith("GET / HTTP/1.")) {
            requestOk = true;
        }

        while(true) {
            String data = reader.readLine();
            if (data.isEmpty()) {
                System.out.println(requestOk ? "Response OK" : "Response Error");
                if (!requestOk) {
                    writer.write("HTTP/1.0 404 Not Found-lzf\r\n");
                    writer.write("Content-Length: 0\r\n");
                    writer.write("\r\n");
                    writer.flush();
                } else {
                    data = "<html><body><h1 style='color:red'>Hello, shijie!</h1></body></html>";
                    int length = data.getBytes(StandardCharsets.UTF_8).length;
                    writer.write("HTTP/1.0 200 OK\r\n");
                    writer.write("Connection: close\r\n");
                    writer.write("Content-Type: text/html\r\n");
                    writer.write("Content-Length: " + length + "\r\n");
                    writer.write("\r\n");
                    writer.write(data);
                    writer.flush();
                }

                return;
            }

            System.out.println(data);
        }
    }
}
