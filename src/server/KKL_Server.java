package server;

import common.Setting;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class KKL_Server {

    static final int PORT = Setting.KKL_PORT;

    public static void main(String[] args) {

        try {
            new Server(PORT, "KKL");
            System.out.println("KKL campus service is running...");
        } catch (MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }

        UDPServer udpServer = new UDPServer(Setting.KKL_UDP_SERVER_PORT);

    }
}
