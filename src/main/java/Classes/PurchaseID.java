package Classes;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class PurchaseID implements IdFactory{
    public final String hostName;
    public final long creationTimeMillis;
    private long lastTimeMillis;


    public PurchaseID() throws UnknownHostException {
        this.hostName = InetAddress.getLocalHost().getHostName();
        System.out.println(hostName+" ");
        this.creationTimeMillis = System.currentTimeMillis();
        System.out.println(creationTimeMillis+" ");
        this.lastTimeMillis = creationTimeMillis;


    }

    @Override
    public String generateUniqueId() {
        Random rand = new Random();
        long randomNum = rand.nextInt(10);
        String id;
        id = String.format("%s-%d-%d", hostName, creationTimeMillis,randomNum).replace("DESKTOP","PID");
        return id;
    }
}
