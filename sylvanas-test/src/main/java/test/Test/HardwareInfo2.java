package test.Test;

import oshi.SystemInfo;
import oshi.hardware.*;

import java.util.List;

public class HardwareInfo2 {
    public static void main(String[] args) {
        SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hardware = systemInfo.getHardware();

        // 获取计算机系统信息
        ComputerSystem computerSystem = hardware.getComputerSystem();
        String manufacturer = computerSystem.getManufacturer();
        String model = computerSystem.getModel();
        String serialNumber = computerSystem.getSerialNumber();

        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Model: " + model);
        System.out.println("Serial Number: " + serialNumber);

        // 获取处理器信息
        CentralProcessor processor = hardware.getProcessor();
        String processorName = processor.getProcessorIdentifier().getName();
        String processorIdentifier = processor.getProcessorIdentifier().getIdentifier();
        int processorCores = processor.getPhysicalProcessorCount();
        int processorThreads = processor.getLogicalProcessorCount();

        System.out.println("Processor Name: " + processorName);
        System.out.println("Processor Identifier: " + processorIdentifier);
        System.out.println("Processor Cores: " + processorCores);
        System.out.println("Processor Threads: " + processorThreads);

        // 获取内存信息
        GlobalMemory memory = hardware.getMemory();
        long totalMemory = memory.getTotal();
        long availableMemory = memory.getAvailable();

        System.out.println("Total Memory: " + totalMemory + " bytes");
        System.out.println("Available Memory: " + availableMemory + " bytes");

        // 获取磁盘信息

        List<HWDiskStore> disks = hardware.getDiskStores();
//        HWDiskStore[] disks = hardware.getDiskStores();
        for (HWDiskStore disk : disks) {
            String diskModel = disk.getModel();
            long diskSize = disk.getSize();

            System.out.println("Disk Model: " + diskModel);
            System.out.println("Disk Size: " + diskSize + " bytes");
        }

        // 获取网络接口信息

        List<oshi.hardware.NetworkIF> networkInterfaces = hardware.getNetworkIFs();
//        NetworkIF[] networkInterfaces = hardware.getNetworkIFs();
        for (NetworkIF net : networkInterfaces) {
            String interfaceName = net.getName();
            String macAddress = net.getMacaddr();
            long bytesSent = net.getBytesSent();
            long bytesReceived = net.getBytesRecv();

            System.out.println("Interface Name: " + interfaceName);
            System.out.println("MAC Address: " + macAddress);
            System.out.println("Bytes Sent: " + bytesSent);
            System.out.println("Bytes Received: " + bytesReceived);
        }
    }
}
