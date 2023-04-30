package server;

import server.socketManager.*;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    static public void main(String[] args) {
        System.out.print("Server has started working on port: ");
        ServerSocket serv_socket = null;
        try {
            serv_socket = new ServerSocket(0);
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println(serv_socket.getLocalPort());
        SocketManager socketManager = new SocketManager();
    }
}