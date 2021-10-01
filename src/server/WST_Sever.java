package server;

import common.Setting;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class WST_Sever {

    static final int PORT = Setting.WST_PORT;

    public static void main(String[] args) {

        try {
            new Server(PORT, "WST");
            System.out.println("WST campus service is running...");
        } catch (MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }

        UDPServer udpServer = new UDPServer(Setting.WST_UDP_SERVER_PORT);

    }
}
