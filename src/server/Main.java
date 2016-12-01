package server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
	    new Main().run();
    }

    private void run() {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            for(;;) {
                Socket socket = serverSocket.accept();
                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
