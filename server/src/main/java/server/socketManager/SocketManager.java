package server.socketManager;

import server.conveyor.*;

import java.net.*;
import java.io.*;
public class SocketManager extends Thread{
    Conveyor conveyor;
    SocketManager(Conveyor conv){
        this.conveyor = conv;
    }
    @Override
    public void run(){
        
    }
}
