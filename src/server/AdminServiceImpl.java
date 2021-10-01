package server;

import business.RoomManager;
import common.AdminService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AdminServiceImpl extends UnicastRemoteObject implements AdminService {

    RoomManager roomManager = RoomManager.getInstance();

    protected AdminServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String createRoom(String roomNumber, String date, String timeSlot, String userID) throws RemoteException {
        if (userID.charAt(3) != 'A') {
            return "Permission Denied!";
        }
        roomManager.createRoom(roomNumber, date, timeSlot);
        return roomManager.roomRecords.toString();
    }

    @Override
    public String deleteRoom(String roomNumber, String date, String timeSlot, String userID) throws RemoteException {
        if (userID.charAt(3) != 'A') {
            return "Permission Denied!";
        }
        roomManager.deleteRoom(roomNumber, date, timeSlot);
        return roomManager.roomRecords.toString();
    }

}
