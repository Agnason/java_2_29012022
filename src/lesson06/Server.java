package lesson06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int PORT = 8189;

    public static void main(String[] args) {
        Socket socket = null;
        Scanner console = new Scanner(System.in);

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запущен");
            socket = serverSocket.accept();
            System.out.println("Клиент подключен: " + socket.getRemoteSocketAddress());

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            Thread threadReader = new Thread(() -> {
                while (true) {
                    try {
                        outputStream.writeUTF(console.nextLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            threadReader.setDaemon(true);
            threadReader.start();

            while (true) {
                String str = inputStream.readUTF();
                if (str.equals("/end")) {
                    System.out.println("Клиент отключился");
                    outputStream.writeUTF("/end");
                    break;
                }else {
                    System.out.println("Client: " + str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
