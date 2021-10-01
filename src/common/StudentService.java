package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentService extends Remote {

    String bookRoom(String campusName, String roomNumber, String date, String timeSlot, String studentID) throws RemoteException;

    String getAvailableTimeSlot(String date) throws RemoteException;

    String cancelBooking(String bookingID, String studentID) throws RemoteException;
}
