import java.io.IOException;
import java.net.InetAddress;

public class ComputerInfo {
    public static void main(String[] args) throws InterruptedException, IOException {

        String hostname = InetAddress.getLocalHost().getHostName();
        String ip4Addr = InetAddress.getLocalHost().getHostAddress();

        new ProcessBuilder("cmd" , "/c", "cls").inheritIO().start().waitFor();

        System.out.println("My Computer Information:");
        System.out.println("------------------------");
        System.out.println();

        System.out.println(String.format("OS        : %s", System.getProperty("os.name").toUpperCase()));
        System.out.println(String.format("Hostname  : %s", hostname));
        System.out.println(String.format("IP4v Addr : %s", ip4Addr));

        Runtime runtime = Runtime.getRuntime();

        System.out.println(String.format("Java Version            : %s", Runtime.version()));
        System.out.println(String.format("JVM Available Processor : %d", runtime.availableProcessors()));
        System.out.println(String.format("JVM Total Memory (MB)   : %,d", runtime.totalMemory()));
        System.out.println(String.format("JVM Free Memory (MB)    : %,d", runtime.freeMemory()));

    }
}
