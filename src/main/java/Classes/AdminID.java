package Classes;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class AdminID implements IdFactory{
    final String hostName;
    final long creationTimeMillis;

    public AdminID() throws UnknownHostException {
        this.hostName = InetAddress.getLocalHost().getHostName();
        this.creationTimeMillis = System.currentTimeMillis();
    }

    @Override
    public String generateUniqueId() {
        long randomNum = new Random().nextInt();
        String id;
        id = String.format("%s-%d-%d", hostName, creationTimeMillis,randomNum).replace("DESKTOP","AID");
        return id;
    }
}
