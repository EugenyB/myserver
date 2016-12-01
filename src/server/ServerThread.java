package server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by eugeny on 03.11.2016.
 */
public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, true);
            Scanner in = new Scanner(socket.getInputStream());
            out.println("Hello from server");
            out.println("Your name:");
            String name = in.nextLine();
            out.println("Hello, " + name);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
