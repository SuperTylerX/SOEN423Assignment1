package client;

import common.Setting;
import common.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.NotBoundException;

public class StudentClient {
    public static void main(String[] args) {
        try {

            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            System.out.println("Please enter your student ID:");
            String studentID = br.readLine();

            String RMI_URL = null;
            if (studentID.startsWith("DVL")) {
                RMI_URL = Setting.DVL_RMI_REGISTRY_URL + "/StudentService";
            } else if (studentID.startsWith("KKL")) {
                RMI_URL = Setting.KKL_RMI_REGISTRY_URL + "/StudentService";
            } else if (studentID.startsWith("WST")) {
                RMI_URL = Setting.WST_RMI_REGISTRY_URL + "/StudentService";
            } else {
                System.out.println("Your ID is not valid!");
                System.exit(0);
            }
            StudentService studentService = (StudentService) Naming.lookup(RMI_URL);

            System.out.println("Welcome! " + studentID);

            label:
            while (true) {
                System.out.println("Please choose the following options:");
                System.out.println("1. Book a Room");
                System.out.println("2. Get Available Time Slot");
                System.out.println("3. Cancel a Booking");
                System.out.println("4. Quit");

                String choice = br.readLine();
                switch (choice) {
                    case "1": {
                        System.out.println("Please enter the campus code:");
                        String campus = br.readLine();
                        System.out.println("Please enter the date(YYYY-MM-DD):");
                        String date = br.readLine();
                        System.out.println("Please enter the room number:");
                        String roomNumber = br.readLine();
                        System.out.println("Please enter the timeslot(HH:mm-HH:mm):");
                        String timeslot = br.readLine();
                        String result = studentService.bookRoom(campus, roomNumber, date, timeslot, studentID);
                        Log.addLog(studentID, "[Request] Book a room, " + campus + ", " + roomNumber + ", " + date + ", " + timeslot + "\r\n");
                        Log.addLog(studentID, "[Response] " + result + "\r\n\r\n");
                        System.out.println(result);
                        break;
                    }
                    case "2": {
                        System.out.println("Please enter the date(YYYY-MM-DD):");
                        String date = br.readLine();
                        String result = studentService.getAvailableTimeSlot(date);
                        System.out.println(result);
                        break;
                    }
                    case "3": {
                        System.out.println("Please enter the booking ID:");
                        String bookingID = br.readLine();
                        String result = studentService.cancelBooking(bookingID, studentID);
                        Log.addLog(studentID, "[Request] Cancel a booking, " + bookingID + "\r\n");
                        Log.addLog(studentID, "[Response] " + result + "\r\n\r\n");
                        System.out.println(result);
                        break;
                    }
                    case "4":
                        break label;
                    default:
                        System.out.println("Invalid Input");
                        break;
                }
            }
        } catch (NotBoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
