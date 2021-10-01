package server;

import common.Setting;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class DVL_Server {

    static final int PORT = Setting.DVL_PORT;

    public static void main(String[] args) {

        try {
            new Server(PORT, "DVL");
            System.out.println("DVL campus service is running...");
        } catch (MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }

        UDPServer udpServer = new UDPServer(Setting.DVL_UDP_SERVER_PORT);

    }


}
