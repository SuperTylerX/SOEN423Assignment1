package common;

public class Setting {

    public static int DVL_PORT = 10010;
    public static int KKL_PORT = 10020;
    public static int WST_PORT = 10030;

    public static String DVL_HOSTNAME = "localhost";
    public static String KKL_HOSTNAME = "localhost";
    public static String WST_HOSTNAME = "localhost";

    public static String DVL_RMI_REGISTRY_URL = "rmi://" + DVL_HOSTNAME + ":" + DVL_PORT;
    public static String KKL_RMI_REGISTRY_URL = "rmi://" + KKL_HOSTNAME + ":" + KKL_PORT;
    public static String WST_RMI_REGISTRY_URL = "rmi://" + WST_HOSTNAME + ":" + WST_PORT;

    public static int DVL_UDP_SERVER_PORT = 10040;
    public static int KKL_UDP_SERVER_PORT = 10050;
    public static int WST_UDP_SERVER_PORT = 10060;


}
