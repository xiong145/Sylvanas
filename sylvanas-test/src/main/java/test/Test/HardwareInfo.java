package test.Test;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class HardwareInfo {
    public static void main(String[] args) {
        try {
            InetAddress ipAddress = InetAddress.getLocalHost();

            System.out.println("Host Name: " + ipAddress.getHostName());
            System.out.println("IP Address: " + ipAddress.getHostAddress());

            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(ipAddress);
            byte[] macAddressBytes = networkInterface.getHardwareAddress();

            StringBuilder macAddress = new StringBuilder();
            for (int i = 0; i < macAddressBytes.length; i++) {
                macAddress.append(String.format("%02X%s", macAddressBytes[i], (i < macAddressBytes.length - 1) ? "-" : ""));
            }

            System.out.println("MAC Address: " + macAddress);
        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
        }
    }
}
