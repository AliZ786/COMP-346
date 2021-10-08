

import java.util.concurrent.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** Network class
 *
 * @author Kerly Titus
 */
public class Network extends Thread {

    private static int maxNbPackets;                           /* Maximum number of simultaneous transactions handled by the network buffer */
    private static int inputIndexClient, inputIndexServer, outputIndexServer, outputIndexClient; /* Network buffer indices for accessing the input buffer (inputIndexClient, outputIndexServer) and output buffer (inputIndexServer, outputIndexClient) */
    private static String clientIP;                            /* IP number of the client application*/
    private static String serverIP;                            /* IP number of the server application */
    private static int portID;                                 /* Port ID of the client application */
    private static String clientConnectionStatus;              /* Client connection status - connected, disconnected, idle */
    private static String serverConnectionStatus;              /* Server connection status - connected, disconnected, idle */
    private static Transactions inComingPacket[];              /* Incoming network buffer */
    private static Transactions outGoingPacket[];              /* Outgoing network buffer */
    private static String inBufferStatus, outBufferStatus;     /* Current status of the network buffers - normal, full, empty */
    private static String networkStatus;                       /* Network status - active, inactive */


//    private static Semaphore outBuffEmpty;
//    private static Semaphore outBuffFull;
//    private static Semaphore inBuffEmpty;
//    private static Semaphore inBuffFull;
//    private static Semaphore mutexOut;
//    private static Semaphore mutexIn;


    /**
     * Constructor of the Network class
     *
     * @param
     * @return
     */
    Network() {
        int i;

        System.out.println("\n Activating the network ...");
        clientIP = "192.168.2.0";
        serverIP = "216.120.40.10";
        clientConnectionStatus = "idle";
        serverConnectionStatus = "idle";
        portID = 0;
        maxNbPackets = 10;
        inComingPacket = new Transactions[maxNbPackets];
        outGoingPacket = new Transactions[maxNbPackets];
        for (i = 0; i < maxNbPackets; i++) {
            inComingPacket[i] = new Transactions();
            outGoingPacket[i] = new Transactions();
        }
        inBufferStatus = "empty";
        outBufferStatus = "empty";
        inputIndexClient = 0;
        inputIndexServer = 0;
        outputIndexServer = 0;
        outputIndexClient = 0;

        networkStatus = "active";

         /*
      Initialisation of the semaphore variables
       */

//        outBuffEmpty = new Semaphore(maxNbPackets);
//        outBuffFull = new Semaphore(0);
//        inBuffEmpty = new Semaphore(maxNbPackets);
//        inBuffFull = new Semaphore(0);
//        mutexOut = new Semaphore(1);
//        mutexIn = new Semaphore(1);
    }


    /**
     * Accessor method of Network class
     *
     * @param
     * @return clientIP
     */
    public static String getClientIP() {
        return clientIP;
    }

    /**
     * Mutator method of Network class
     *
     * @param cip
     * @return
     */
    public static void setClientIP(String cip) {
        clientIP = cip;
    }

    /**
     * Accessor method of Network class
     *
     * @param
     * @return serverIP
     */
    public static String getServerIP() {
        return serverIP;
    }

    /**
     * Mutator method of Network class
     *
     * @param sip
     * @return
     */
    public static void setServerIP(String sip) {
        serverIP = sip;
    }

    /**
     * Accessor method of Network class
     *
     * @param
     * @return clientConnectionStatus
     */
    public static String getClientConnectionStatus() {
        return clientConnectionStatus;
    }

    /**
     * Mutator method of Network class
     *
     * @param connectStatus
     * @return
     */
    public static void setClientConnectionStatus(String connectStatus) {
        clientConnectionStatus = connectStatus;
    }

    /**
     * Accessor method of Network class
     *
     * @param
     * @return serverConnectionStatus
     */
    public static String getServerConnectionStatus() {
        return serverConnectionStatus;
    }

    /**
     * Mutator method of Network class
     *
     * @param connectStatus
     * @return
     */
    public static void setServerConnectionStatus(String connectStatus) {
        serverConnectionStatus = connectStatus;
    }

    /**
     * Accessor method of Network class
     *
     * @param
     * @return portID
     */
    public static int getPortID() {
        return portID;
    }

    /**
     * Mutator method of Network class
     *
     * @param pid
     * @return
     */
    public static void setPortID(int pid) {
        portID = pid;
    }

    /**
     * Accessor method of Netowrk class
     *
     * @param
     * @return inBufferStatus
     */
    public static String getInBufferStatus() {
        return inBufferStatus;
    }

    /**
     * Mutator method of Network class
     *
     * @param inBufStatus
     * @return
     */
    public static void setInBufferStatus(String inBufStatus) {
        inBufferStatus = inBufStatus;
    }

    /**
     * Accessor method of Netowrk class
     *
     * @param
     * @return outBufferStatus
     */
    public static String getOutBufferStatus() {
        return outBufferStatus;
    }

    /**
     * Mutator method of Network class
     *
     * @param outBufStatus
     * @return
     */
    public static void setOutBufferStatus(String outBufStatus) {
        outBufferStatus = outBufStatus;
    }

    /**
     * Accessor method of Netowrk class
     *
     * @param
     * @return networkStatus
     */
    public static String getNetworkStatus() {
        return networkStatus;
    }

    /**
     * Mutator method of Network class
     *
     * @param netStatus
     * @return
     */
    public static void setNetworkStatus(String netStatus) {
        networkStatus = netStatus;
    }

    /**
     * Accessor method of Netowrk class
     *
     * @param
     * @return inputIndexClient
     */
    public static int getinputIndexClient() {
        return inputIndexClient;
    }

    /**
     * Mutator method of Network class
     *
     * @param i1
     * @return
     */
    public static void setinputIndexClient(int i1) {
        inputIndexClient = i1;
    }

    /**
     * Accessor method of Netowrk class
     *
     * @param
     * @return inputIndexServer
     */
    public static int getinputIndexServer() {
        return inputIndexServer;
    }

    /**
     * Mutator method of Network class
     *
     * @param i2
     * @return
     */
    public static void setinputIndexServer(int i2) {
        inputIndexServer = i2;
    }

    /**
     * Accessor method of Netowrk class
     *
     * @param
     * @return outputIndexServer
     */
    public static int getoutputIndexServer() {
        return outputIndexServer;
    }

    /**
     * Mutator method of Network class
     *
     * @param o1
     * @return
     */
    public static void setoutputIndexServer(int o1) {
        outputIndexServer = o1;
    }

    /**
     * Accessor method of Netowrk class
     *
     * @param
     * @return outputIndexClient
     */
    public static int getoutputIndexClient() {
        return outputIndexClient;
    }

    /**
     * Mutator method of Network class
     *
     * @param o2
     * @return
     */
    public static void setoutputIndexClient(int o2) {
        outputIndexClient = o2;
    }

    /**
     * Accessor method of Netowrk class
     *
     * @param
     * @return maxNbPackets
     */
    public static int getMaxNbPackets() {
        return maxNbPackets;
    }

    /**
     * Mutator method of Network class
     *
     * @param maxPackets
     * @return
     */
    public static void setMaxNbPackets(int maxPackets) {
        maxNbPackets = maxPackets;
    }

    /**
     * Transmitting the transactions from the client to the server through the network
     *
     * @param inPacket transaction transferred from the client
     * @return
     */
    public static boolean send(Transactions inPacket) {

            /*
            Try to see if we can acquire the buffer and the mutex
             */

//        try {
//            inBuffEmpty.acquire();
//            mutexIn.acquire();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        inComingPacket[inputIndexClient].setAccountNumber(inPacket.getAccountNumber());
        inComingPacket[inputIndexClient].setOperationType(inPacket.getOperationType());
        inComingPacket[inputIndexClient].setTransactionAmount(inPacket.getTransactionAmount());
        inComingPacket[inputIndexClient].setTransactionBalance(inPacket.getTransactionBalance());
        inComingPacket[inputIndexClient].setTransactionError(inPacket.getTransactionError());
        inComingPacket[inputIndexClient].setTransactionStatus("transferred");

//        System.out.println("\n DEBUG : Network.send() - index inputIndexClient " + inputIndexClient);
//        System.out.println("\n DEBUG : Network.send() - account number " + inComingPacket[inputIndexClient].getAccountNumber());

        setinputIndexClient(((getinputIndexClient() + 1) % getMaxNbPackets()));    /* Increment the input buffer index  for the client */
        /* Check if input buffer is full */
        if (getinputIndexClient() == getoutputIndexServer()) {
            setInBufferStatus("full");

           // System.out.println("\n DEBUG : Network.send() - inComingBuffer status " + getInBufferStatus());
        } else {
            setInBufferStatus("normal");
        }

        		  /*
        		  Gotta release both mutex and buffer before leaving the method
        		   */
//        mutexIn.release();
//        inBuffFull.release();

        return true;
    }

    /**
     * Transmitting the transactions from the server to the client through the network
     *
     * @param outPacket updated transaction received by the client
     * @return
     */
    public static boolean receive(Transactions outPacket) {
//        try {
//            outBuffFull.acquire();
//            mutexOut.acquire();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        outPacket.setAccountNumber(outGoingPacket[outputIndexClient].getAccountNumber());
        outPacket.setOperationType(outGoingPacket[outputIndexClient].getOperationType());
        outPacket.setTransactionAmount(outGoingPacket[outputIndexClient].getTransactionAmount());
        outPacket.setTransactionBalance(outGoingPacket[outputIndexClient].getTransactionBalance());
        outPacket.setTransactionError(outGoingPacket[outputIndexClient].getTransactionError());
        outPacket.setTransactionStatus("done");

//        System.out.println("\n DEBUG : Network.receive() - index outputIndexClient " + outputIndexClient);
//        System.out.println("\n DEBUG : Network.receive() - account number " + outPacket.getAccountNumber());

        setoutputIndexClient(((getoutputIndexClient() + 1) % getMaxNbPackets())); /* Increment the output buffer index for the client */
        /* Check if output buffer is empty */
        if (getoutputIndexClient() == getinputIndexServer()) {
            setOutBufferStatus("empty");

          //  System.out.println("\n DEBUG : Network.receive() - outGoingBuffer status " + getOutBufferStatus());
        } else {
            setOutBufferStatus("normal");
        }

//        mutexOut.release();
//        outBuffEmpty.release();


        return true;
    }


    /**
     * Transferring the completed transactions from the server to the network buffer
     *
     * @param outPacket updated transaction transferred by the server to the network output buffer
     * @return
     */
    public static boolean transferOut(Transactions outPacket) {

//        try {
//            outBuffEmpty.acquire();
//            mutexOut.acquire();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        outGoingPacket[inputIndexServer].setAccountNumber(outPacket.getAccountNumber());
        outGoingPacket[inputIndexServer].setOperationType(outPacket.getOperationType());
        outGoingPacket[inputIndexServer].setTransactionAmount(outPacket.getTransactionAmount());
        outGoingPacket[inputIndexServer].setTransactionBalance(outPacket.getTransactionBalance());
        outGoingPacket[inputIndexServer].setTransactionError(outPacket.getTransactionError());
        outGoingPacket[inputIndexServer].setTransactionStatus("transferred");

//        System.out.println("\n DEBUG : Network.transferOut() - index inputIndexServer " + inputIndexServer);
//        System.out.println("\n DEBUG : Network.transferOut() - account number " + outGoingPacket[inputIndexServer].getAccountNumber());

        setinputIndexServer(((getinputIndexServer() + 1) % getMaxNbPackets())); /* Increment the output buffer index for the server */
        /* Check if output buffer is full */
        if (getinputIndexServer() == getoutputIndexClient()) {
            setOutBufferStatus("full");

           // System.out.println("\n DEBUG : Network.transferOut() - outGoingBuffer status " + getOutBufferStatus());
        } else {
            setOutBufferStatus("normal");
        }

//        mutexOut.release();
//        outBuffFull.release();

        return true;
    }

    /**
     * Transferring the transactions from the network buffer to the server
     *
     * @param inPacket transaction transferred from the input buffer to the server
     * @return
     */
    public static boolean transferIn(Transactions inPacket) {

//        try {
//            inBuffFull.acquire();
//            mutexIn.acquire();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        inPacket.setAccountNumber(inComingPacket[outputIndexServer].getAccountNumber());
        inPacket.setOperationType(inComingPacket[outputIndexServer].getOperationType());
        inPacket.setTransactionAmount(inComingPacket[outputIndexServer].getTransactionAmount());
        inPacket.setTransactionBalance(inComingPacket[outputIndexServer].getTransactionBalance());
        inPacket.setTransactionError(inComingPacket[outputIndexServer].getTransactionError());
        inPacket.setTransactionStatus("received");

//        System.out.println("\n DEBUG : Network.transferIn() - index outputIndexServer " + outputIndexServer);
      //  System.out.println("\n DEBUG : Network.transferIn() - account number " + inPacket.getAccountNumber());

        setoutputIndexServer(((getoutputIndexServer() + 1) % getMaxNbPackets()));    /* Increment the input buffer index for the server */
        /* Check if input buffer is empty */
        if (getoutputIndexServer() == getinputIndexClient()) {
            setInBufferStatus("empty");

//            System.out.println("\n DEBUG : Network.transferIn() - inComingBuffer status " + getInBufferStatus());
        } else {
            setInBufferStatus("normal");
        }
//
//        mutexIn.release();
//        inBuffEmpty.release();

        return true;
    }

    /**
     * Handling of connection requests through the network
     *
     * @param IP
     * @return valid connection
     */
    public static boolean connect(String IP) {
        if (getNetworkStatus().equals("active")) {
            if (getClientIP().equals(IP)) {
                setClientConnectionStatus("connected");
                setPortID(0);
            } else if (getServerIP().equals(IP)) {
                setServerConnectionStatus("connected");
            }
            return true;
        } else
            return false;
    }

    /**
     * Handling of disconnection requests through the network
     *
     * @param IP
     * @return valid disconnection
     */
    public static boolean disconnect(String IP) {
        if (getNetworkStatus().equals("active")) {
            if (getClientIP().equals(IP)) {
                setClientConnectionStatus("disconnected");
            } else if (getServerIP().equals(IP)) {
                setServerConnectionStatus("disconnected");
            }
            return true;
        } else
            return false;
    }

    /**
     * Create a String representation based on the Network Object
     *
     * @return String representation
     */
    public String toString() {
        return ("\n Network status " + getNetworkStatus() + "Input buffer " + getInBufferStatus() + "Output buffer " + getOutBufferStatus());
    }

    /**
     * Code for the run method
     *
     * @param
     * @return
     */
    public void run() {
       // System.out.println("\n DEBUG : Network.run() - starting network thread");
        while (true) {
            /* Implement the code for the run method */
            if (getClientConnectionStatus().equals("disconnected") && getServerConnectionStatus().equals("disconnected")) {
                System.out.println("\n Terminating network thread - Client " + getClientConnectionStatus() + " Server " + getServerConnectionStatus());
                return;
            } else {
                Thread.yield();
            }

        }
    }
}



