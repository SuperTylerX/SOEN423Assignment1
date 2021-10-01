package client;

import common.AdminService;
import common.Setting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.NotBoundException;

public class AdminClient {
    public static void main(String[] args) {
        try {

            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            System.out.println("Please enter your Admin ID:");
            String adminID = br.readLine();

            String RMI_URL = null;
            if (adminID.startsWith("DVL")) {
                RMI_URL = Setting.DVL_RMI_REGISTRY_URL + "/AdminService";
            } else if (adminID.startsWith("KKL")) {
                RMI_URL = Setting.KKL_RMI_REGISTRY_URL + "/AdminService";
            } else if (adminID.startsWith("WST")) {
                RMI_URL = Setting.WST_RMI_REGISTRY_URL + "/AdminService";
            } else {
                System.out.println("Your ID is not valid!");
                System.exit(0);
            }
            AdminService adminService = (AdminService) Naming.lookup(RMI_URL);

            System.out.println("Welcome! " + adminID);

            label:
            while (true) {
                System.out.println("Please choose the following options:");
                System.out.println("1. Create Room");
                System.out.println("2. Remove Room");
                System.out.println("3. Quit");

                String choice = br.readLine();
                switch (choice) {
                    case "1": {
                        System.out.println("Please enter the room:");
                        String room = br.readLine();
                        System.out.println("Please enter the date(YYYY-MM-DD):");
                        String date = br.readLine();
                        System.out.println("Please enter the timeslot(HH:mm-HH:mm):");
                        String timeslot = br.readLine();
                        String result = adminService.createRoom(room, date, timeslot, adminID);
                        System.out.println(result);
                        break;
                    }
                    case "2": {
                        System.out.println("Please enter the room:");
                        String room = br.readLine();
                        System.out.println("Please enter the date(YYYY-MM-DD):");
                        String date = br.readLine();
                        System.out.println("Please enter the timeslot(HH:mm-HH:mm):");
                        String timeslot = br.readLine();
                        String result = adminService.deleteRoom(room, date, timeslot, adminID);
                        System.out.println(result);
                        break;
                    }
                    case "3":
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
