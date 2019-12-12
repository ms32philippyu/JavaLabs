package server;

public class ServerMain {
    public static void main(String[] args) throws Exception {
        Server s = new Server(5000);
        s.start();
    }
}
