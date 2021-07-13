package comp346pa1w2020;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** Network class
 *
 * @author Kerly Titus
 */
public class Network {
    
    private static int maxNbPackets;                           /* Maximum number of simultaneous transactions handled by the network buffer */
    private static int inputIndexClient, inputIndexServer, outputIndexServer, outputIndexClient;                   /* Network buffer indices for accessing the input buffer (inputIndexClient, outputIndexServer) and output buffer (inputIndexServer, outputIndexClient) */
    private static String clientIP;                            /* IP number of the client application*/
    private static String serverIP;                            /* IP number of the server application */
    private static int portID;                                 /* Port ID of the client application */
    private static String clientConnectionStatus;              /* Client connection status - connected, disconnected, idle */
    private static String serverConnectionStatus;              /* Server connection status - connected, disconnected, idle */
    private static Transactions inComingPacket[];              /* Incoming network buffer */
    private static Transactions outGoingPacket[];              /* Outgoing network buffer */
    private static String inBufferStatus, outBufferStatus;     /* Current status of the network buffers - normal, full, empty */
    private static String networkStatus;                       /* Network status - active, inactive */
      
    /** 
     * Constructor of the Network class
     * 
     * @return 
     * @param
     */
     Network(String context)
      { 
    	 int i;  
        
    	 /* Initialization of the network components */
        if (context.equals("network"))
          {
            System.out.println("\n Activating the network ...");
            clientIP = "192.168.2.0";
            serverIP = "216.120.40.10";
            clientConnectionStatus = "idle";
            serverConnectionStatus = "idle";
            portID = 0;
            maxNbPackets = 10;
            inComingPacket = new Transactions[maxNbPackets];
            outGoingPacket = new Transactions[maxNbPackets];
            for (i=0; i < maxNbPackets; i++)
            {   inComingPacket[i] = new Transactions();
                outGoingPacket[i] = new Transactions();
            }
            inBufferStatus = "empty";
            outBufferStatus = "empty";
            inputIndexClient = 0;
            inputIndexServer = 0;
            outputIndexServer = 0;
            outputIndexClient = 0;
            networkStatus = "active";
        }
        else /* Activate network components for client or server */
            System.out.println("\n Activating network components for " + context + "...");
      }     
         
     /** 
      * Accessor method of Network class
     * 
     * @return clientIP
     * @param
     */
     public String getClientIP()
     {
         return clientIP;
     }
         
    /**
     *  Mutator method of Network class
     * 
     * @return 
     * @param cip
     */
     public void setClientIP(String cip)
     { 
         clientIP = cip;
     }
    
    /**
     *  Accessor method of Network class
     * 
     * @return serverIP
     * @param
     */
     public String getServerIP()
     {
         return serverIP;
     }
                          
    /**
     *  Mutator method of Network class
     * 
     * @return 
     * @param sip
     */
     public void setServerIP(String sip)
     { 
         serverIP = sip;
     }
         
    /**
     *  Accessor method of Network class
     * 
     * @return clientConnectionStatus
     * @param
     */
     public String getClientConnectionStatus()
     {
         return clientConnectionStatus;
     }
                          
    /**
     *  Mutator method of Network class
     * 
     * @return 
     * @param connectStatus
     */
     public void setClientConnectionStatus(String connectStatus)
     { 
         clientConnectionStatus = connectStatus;
     }
         
    /**
     *  Accessor method of Network class
     * 
     * @return serverConnectionStatus
     * @param
     */
     public String getServerConnectionStatus()
     {
         return serverConnectionStatus;
     }
                          
    /**
     *  Mutator method of Network class
     * 
     * @return 
     * @param connectStatus
     */
     public void setServerConnectionStatus(String connectStatus)
     { 
         serverConnectionStatus = connectStatus;
     } 
         
    /**
     *  Accessor method of Network class
     * 
     * @return portID
     * @param
     */
     public int getPortID()
     {
         return portID;
     }
     
    /**
     *  Mutator method of Network class
     * 
     * @return 
     * @param pid
     */
     public void setPortID(int pid)
     { 
         portID = pid;
     }

    /**
     *  Accessor method of Netowrk class
     * 
     * @return inBufferStatus
     * @param
     */
     public String getInBufferStatus()
     {
         return inBufferStatus;
     }
         
    /**
     *  Mutator method of Network class
     * 
     * @return 
     * @param inBufStatus
     */
     public void setInBufferStatus(String inBufStatus)
     { 
         inBufferStatus = inBufStatus;
     }
         
    /**
     *  Accessor method of Netowrk class
     * 
     * @return outBufferStatus
     * @param
     */
     public String getOutBufferStatus()
     {
         return outBufferStatus;
     }
         
    /**
     *  Mutator method of Network class
     * 
     * @return 
     * @param outBufStatus
     */
     public void setOutBufferStatus(String outBufStatus)
     { 
         outBufferStatus = outBufStatus;
     }

    /**
     *  Accessor method of Netowrk class
     * 
     * @return networkStatus
     * @param
     */
     public String getNetworkStatus()
     {
         return networkStatus;
     }
         
    /**
     *  Mutator method of Network class
     * 
     * @return 
     * @param netStatus
     */
     public void setNetworkStatus(String netStatus)
     { 
         networkStatus = netStatus;
     }
         
    /**
     *  Accessor method of Netowrk class
     * 
     * @return inputIndexClient
     * @param
     */
     public int getinputIndexClient()
     {
         return inputIndexClient;
     }
         
    /**
     *  Mutator method of Network class
     * 
     * @return 
     * @param i1
     */
     public void setinputIndexClient(int i1)
     { 
         inputIndexClient = i1;
     }
         
     /**
      *  Accessor method of Netowrk class
     * 
     * @return inputIndexServer
     * @param
     */
     public int getinputIndexServer()
     {
         return inputIndexServer;
     }
         
    /**
     *  Mutator method of Network class
     * 
     * @return 
     * @param i2
     */
     public void setinputIndexServer(int i2)
     { 
         inputIndexServer = i2;
     }     
         
    /**
     *  Accessor method of Netowrk class
     * 
     * @return outputIndexServer
     * @param
     */
     public int getoutputIndexServer()
     {
         return outputIndexServer;
     }
         
    /**
     *  Mutator method of Network class
     * 
     * @return 
     * @param o1
     */
     public void setoutputIndexServer(int o1)
     { 
         outputIndexServer = o1;
     }
         
     /**
      *  Accessor method of Netowrk class
     * 
     * @return outputIndexClient
     * @param
     */
     public int getoutputIndexClient()
     {
         return outputIndexClient;
     }
         
    /**
     *  Mutator method of Network class
     * 
     * @return 
     * @param o2
     */
     public void setoutputIndexClient(int o2)
     { 
         outputIndexClient = o2;
     }

	 /**
	 *  Accessor method of Netowrk class
	 * 
	 * @return maxNbPackets
	 * @param
	 */
	 public int getMaxNbPackets()
	 {
	     return maxNbPackets;
	 }
	 
    /**
     *  Mutator method of Network class
     * 
     * @return 
     * @param maxPackets
     */
     public void setMaxNbPackets(int maxPackets)
     { 
         maxNbPackets = maxPackets;
     }
         
    /**
     *  Transmitting the transactions from the client to the server through the network 
     *  
     * @return
     * @param inPacket transaction transferred from the client
     * 
     */
         public boolean send(Transactions inPacket)
        {
            inComingPacket[inputIndexClient].setAccountNumber(inPacket.getAccountNumber());
            inComingPacket[inputIndexClient].setOperationType(inPacket.getOperationType());
            inComingPacket[inputIndexClient].setTransactionAmount(inPacket.getTransactionAmount());
            inComingPacket[inputIndexClient].setTransactionBalance(inPacket.getTransactionBalance());
            inComingPacket[inputIndexClient].setTransactionError(inPacket.getTransactionError());
            inComingPacket[inputIndexClient].setTransactionStatus("transferred");
            
            System.out.println("\n DEBUG : Network.send() - index inputIndexClient " + inputIndexClient);
            System.out.println("\n DEBUG : Network.send() - account number " + inComingPacket[inputIndexClient].getAccountNumber());
            
            
            setinputIndexClient(((getinputIndexClient( ) + 1) % getMaxNbPackets ()));	/* Increment the input buffer index  for the client */
            /* Check if input buffer is full */
            if (getinputIndexClient() == getoutputIndexServer())
            {	
            	setInBufferStatus("full");
            
            	System.out.println("\n DEBUG : Network.send() - inComingBuffer status " + getInBufferStatus());
            }
            else
            	setInBufferStatus("normal");
            
            return true;
        }   
         
      /** Transmitting the transactions from the server to the client through the network 
     * @return
     * @param outPacket updated transaction received by the client
     * 
     */
         public boolean receive(Transactions outPacket)
        {
            outPacket.setAccountNumber(outGoingPacket[outputIndexClient].getAccountNumber());
            outPacket.setOperationType(outGoingPacket[outputIndexClient].getOperationType());
            outPacket.setTransactionAmount(outGoingPacket[outputIndexClient].getTransactionAmount());
            outPacket.setTransactionBalance(outGoingPacket[outputIndexClient].getTransactionBalance());
            outPacket.setTransactionError(outGoingPacket[outputIndexClient].getTransactionError());
            outPacket.setTransactionStatus("done");
            
            System.out.println("\n DEBUG : Network.receive() - index outputIndexClient " + outputIndexClient);
            System.out.println("\n DEBUG : Network.receive() - account number " + outPacket.getAccountNumber());
            
            setoutputIndexClient(((getoutputIndexClient( ) + 1) % getMaxNbPackets( ))); /* Increment the output buffer index for the client */
            /* Check if output buffer is empty */
            if ( getoutputIndexClient( ) == getinputIndexServer( ))
            {	
            	setOutBufferStatus("empty");
            
            	System.out.println("\n DEBUG : Network.receive() - outGoingBuffer status " + getOutBufferStatus());
            }
            else
            	setOutBufferStatus("normal"); 
            
             return true;
        }   
    
    /**
     *  Transferring the completed transactions from the server to the network buffer
     *  
     * @return
     * @param outPacket updated transaction transferred by the server to the network output buffer
     * 
     */
         public boolean transferOut(Transactions outPacket)
        {
            outGoingPacket[inputIndexServer].setAccountNumber(outPacket.getAccountNumber());
            outGoingPacket[inputIndexServer].setOperationType(outPacket.getOperationType());
            outGoingPacket[inputIndexServer].setTransactionAmount(outPacket.getTransactionAmount());
            outGoingPacket[inputIndexServer].setTransactionBalance(outPacket.getTransactionBalance());
            outGoingPacket[inputIndexServer].setTransactionError(outPacket.getTransactionError());
            outGoingPacket[inputIndexServer].setTransactionStatus("transferred");
            
            System.out.println("\n DEBUG : Network.transferOut() - index inputIndexServer " + inputIndexServer);
            System.out.println("\n DEBUG : Network.transferOut() - account number " + outGoingPacket[inputIndexServer].getAccountNumber());
            
            setinputIndexServer(((getinputIndexServer() + 1) % getMaxNbPackets())); /* Increment the output buffer index for the server */
            /* Check if output buffer is full */
            if ( getinputIndexServer( ) == getoutputIndexClient( ))
            {
                setOutBufferStatus("full");
                
                System.out.println("\n DEBUG : Network.transferOut() - outGoingBuffer status " + getOutBufferStatus());
            }
            else
                setOutBufferStatus("normal");
            
             return true;
        }   
         
    /**
     *  Transferring the transactions from the network buffer to the server
     * @return
     * @param inPacket transaction transferred from the input buffer to the server 
     * 
     */
         public boolean transferIn(Transactions inPacket)
        {
		System.out.println("\n DEBUG : Network.transferIn - account number " + inComingPacket[outputIndexServer].getAccountNumber());
            inPacket.setAccountNumber(inComingPacket[outputIndexServer].getAccountNumber());
            inPacket.setOperationType(inComingPacket[outputIndexServer].getOperationType());
            inPacket.setTransactionAmount(inComingPacket[outputIndexServer].getTransactionAmount());
            inPacket.setTransactionBalance(inComingPacket[outputIndexServer].getTransactionBalance());
            inPacket.setTransactionError(inComingPacket[outputIndexServer].getTransactionError());
            inPacket.setTransactionStatus("received");
           
            System.out.println("\n DEBUG : Network.transferIn() - index outputIndexServer " + outputIndexServer);
            System.out.println("\n DEBUG : Network.transferIn() - account number " + inPacket.getAccountNumber());
            
           setoutputIndexServer(((getoutputIndexServer() + 1) % getMaxNbPackets()));	/* Increment the input buffer index for the server */
           /* Check if input buffer is empty */
            if ( getoutputIndexServer( ) == getinputIndexClient( ))
            {
                setInBufferStatus("empty");
                
                System.out.println("\n DEBUG : Network.transferIn() - inComingBuffer status " + getInBufferStatus());
            }
            else
                setInBufferStatus("normal");
            
             return true;
        }   
         
     /**
      *  Handling of connection requests through the network 
      *  
      * @return valid connection
      * @param IP
      * 
      */
     public boolean connect(String IP)
     {
         if (getNetworkStatus().equals("active"))
         {
             if (getClientIP().equals(IP))
             {
                setClientConnectionStatus("connected");
                setPortID(0);
             }
             else
             if (getServerIP().equals(IP))
             {
                setServerConnectionStatus("connected");
             }
             return true;
         }
         else
             return false;
     }
     
     /**
      *  Handling of disconnection requests through the network 
      * @return valid disconnection
      * @param IP
      * 
      */
     public boolean disconnect(String IP)
     {
          if (getNetworkStatus( ).equals("active"))
         {
             if (getClientIP().equals(IP))
             {
                setClientConnectionStatus("disconnected");
             }
             else
             if (getServerIP().equals(IP))
             {
                setServerConnectionStatus("disconnected");
             }
             return true;
         }
         else
             return false;
     }
         
     /**
      *  Create a String representation based on the Network Object
      * 
      * @return String representation
      */
	    public String toString() 
	    {
	        return ("\n Network status " + getNetworkStatus() + "Input buffer " + getInBufferStatus() + "Output buffer " + getOutBufferStatus());
	    }
    
     /***********************************************************************************************************************************************
      * TODO : implement the method Run() to execute the server thread				 																*
      * *********************************************************************************************************************************************/
	     
    /**
     *  Code for the run method
     * 
     * @return 
     * @param
     */
    public void run()
    {	
    	System.out.println("\n DEBUG : Network.run() - starting network thread");
    	
    	while (true)
    	{
		/* Implement the code for the run method */
    	}    
    }
}
