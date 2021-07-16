//package comp346pa1w2020;
import java.io.FileNotFoundException;
import java.io.PrintStream;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kerly Titus
 */
public class comp346pa1driver {

    /** 
     * main class
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try{
            PrintStream output = new PrintStream("Test3.txt");
            System.setOut(output);

        }catch(FileNotFoundException e){
            System.out.println("FILE NOT FOUND");
            System.exit(0);
        }

    	 /*******************************************************************************************************************************************
    	  * TODO : implement all the operations of main class   																					*
    	  ******************************************************************************************************************************************/
        
    	Network objNetwork = new Network("network");            /* Activate the network */
        objNetwork.start();
        Server objServer = new Server();                        /* Start the server */ 
        objServer.start();
        Client objClient1 = new Client("sending");              /* Start the sending client */
        objClient1.start();
        Client objClient2 = new Client("receiving");            /* Start the receiving client */
        objClient2.start();

    }
}
