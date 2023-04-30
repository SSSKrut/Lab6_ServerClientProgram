package server.logMessage;

public class LogMessage {
    public String message;
    public Thread thread;
    LogMessage(Thread thr, String msg){
        this.message = msg;
        this.thread = thr;
    }
    public String getName(){
        return this.thread.getName();
    }
}
