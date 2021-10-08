package server;

import server.business.RoomManager;
import common.AdminService;
import server.utils.Log;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class AdminServiceImpl extends UnicastRemoteObject implements AdminService {

    RoomManager roomManager = RoomManager.getInstance();
    public String campusCode;

    protected AdminServiceImpl(String campusCode) throws RemoteException {
        super();
        this.campusCode = campusCode;
    }

    @Override
    public String createRoom(String roomNumber, String date, String timeSlot, String userID) throws RemoteException {
        String result;
        if (userID.charAt(3) != 'A') {
            result = "Permission Denied!";
        } else {
            roomManager.createRoom(roomNumber, date, timeSlot);
            result = "Success!";
        }
        Log.addLog(campusCode, "Date: " + new Date().toLocaleString());
        Log.addLog(campusCode, "\r\nRequest Type: Create Room");
        Log.addLog(campusCode, "\r\nParameter: " + roomNumber + ", " + date + ", " + timeSlot + ", " + userID);
        Log.addLog(campusCode, "\r\n" + result + "\r\n\r\n");
        return result;
    }

    @Override
    public String deleteRoom(String roomNumber, String date, String timeSlot, String userID) throws RemoteException {

        String result;
        if (userID.charAt(3) != 'A') {
            result = "Permission Denied!";
        } else {
            result = roomManager.deleteRoom(roomNumber, date, timeSlot);
        }
        Log.addLog(campusCode, "Date: " + new Date().toLocaleString());
        Log.addLog(campusCode, "\r\nRequest Type: Delete Room");
        Log.addLog(campusCode, "\r\nParameter: " + roomNumber + ", " + date + ", " + timeSlot + ", " + userID);
        Log.addLog(campusCode, "\r\n" + result + "\r\n\r\n");
        return result;
    }

}
