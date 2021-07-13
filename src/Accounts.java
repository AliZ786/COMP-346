package comp346pa1w2020;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** Accounts class
 *
 * @author Kerly Titus
 */
public class Accounts {
    
    private String accountNumber;       /* Unique account number */
    private String accountType;         /* chequing, saving, credit */
    private String firstName;           /* First name of account holder */
    private String lastName;            /* Last name of account holder */
    private double balance;             /* Account balance */
     
   /** 
    * Constructor method of Accounts class
    * 
    * @return
    * @param
    */
    Accounts()
    {
        accountNumber = " ";
        accountType = " ";
        firstName = " ";
        lastName = " ";
        balance = 0.0;
    }
    
    /** 
     * Accessor method of Accounts class
     * 
     * @return accountNumber
     * @param
     */
     public String getAccountNumber()
     {
         return accountNumber;
     }
         
    /** 
     * Mutator method of Accounts class
     * 
     * @return 
     * @param accNumber
     */
     public void setAccountNumber(String accNumber)
     { 
         accountNumber = accNumber;
     }  

    /** 
     * Accessor method of Accounts class
     * 
     * @return accountType
     * @param
     */
     public String getAccountType()
     {
         return accountType;
     }
         
    /** 
     * Mutator method of Accounts class
     * 
     * @return 
     * @param accType
     */
     public void setAccountType(String accType)
     { 
         accountType = accType;
     }  
       
    /** 
     * Accessor method of Accounts class
     * 
     * @return firstName
     * @param
     */
     public String getFirstName()
     {
         return firstName;
     }
         
    /**
     *  Mutator method of Accounts class
     * 
     * @return 
     * @param fName
     */
     public void setFirstName(String fName)
     { 
         firstName = fName;
     }  
        
    /** 
     * Accessor method of Accounts class
     * 
     * @return lastName
     * @param
     */
     public String getLastName()
     {
         return lastName;
     }
         
    /** 
     * Mutator method of Accounts class
     * 
     * @return 
     * @param lName
     */
     public void setLastName(String lName)
     { 
         lastName = lName;
     }           
      
    /** 
     * Accessor method of Accounts class
     * 
     * @return balance
     * @param
     */
     public double getBalance()
     {
         return balance;
     }
         
    /** 
     * Mutator method of Accounts class
     * 
     * @return 
     * @param bal
     */
     public void setBalance(double bal)
     { 
         balance = bal;
     }           
         
   /** 
    * Create a String representation based on the Accounts Object
	* 
	* @return String representation
	*/
	public String toString() 
	{
		return ("\n Account number " + getAccountNumber() + "Account type " + getAccountType() + "First name " + getFirstName() + "Last Name " + getLastName() + "Balance " + getBalance());
	}
    
}
