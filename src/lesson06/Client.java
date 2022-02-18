package lesson06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final int PORT = 8189;
    private static final String ADDRESS = "localhost";

    public static void main(String[] args) {
        Socket socket = null;
        Scanner consoleClient = new Scanner(System.in);

        try {
            socket = new Socket(ADDRESS, PORT);
            System.out.println("Подключен к серверу: " + socket.getRemoteSocketAddress());

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            Thread threadReader = new Thread(() -> {
                while (true) {
                    try {
                        outputStream.writeUTF(consoleClient.nextLine());
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
                    System.out.println("Сервер закрыт");
                    outputStream.writeUTF("/end");
                    break;
                } else {
                    System.out.println("Server: " + str);
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
