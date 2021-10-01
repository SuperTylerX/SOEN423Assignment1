package server;

import common.AdminService;
import common.StudentService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

    public Server(int portNum, String campusCode) throws RemoteException, MalformedURLException {

        String registryURL = "rmi://localhost:" + portNum;
        StudentService studentService = new StudentServiceImpl(campusCode);
        AdminService adminService = new AdminServiceImpl();
        LocateRegistry.createRegistry(portNum);
        Naming.rebind(registryURL + "/StudentService", studentService);
        Naming.rebind(registryURL + "/AdminService", adminService);

        System.out.println("Services contains: ");
        String[] names = Naming.list(registryURL);
        for (String name : names)
            System.out.println(name);

    }


}
