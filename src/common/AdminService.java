package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdminService extends Remote {
    String createRoom(String roomNumber, String date, String timeSlot, String UserID) throws RemoteException;

    String deleteRoom(String roomNumber, String date, String timeSlot, String UserID) throws RemoteException;

}
