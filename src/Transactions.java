package comp346pa1w2020;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** Transactions class
 *
 * @author Kerly Titus
 */
public class Transactions {
    
    private String accountNumber;       /* Account number */
    private String operationType;       /* Operation type : deposit, withdrawal, query */
    private double transactionAmount;   /* Amount to deposit or withdraw */
    private double transactionBalance;  /* Account balance after transaction */
    private String transactionError;    /* Transaction error : NSF, invalid amount, invalind account, none */
    private String transactionStatus;   /* Current transaction status : pending, sent, received, transferred, done */
    
    /** Constructor method of Transactions class
         * 
         * @return
         * @param
         */
    Transactions()
    {
        accountNumber = " ";
        operationType = " ";
        transactionAmount = 0.00;
        transactionBalance = 0.00;
        transactionError = "none";
        transactionStatus = " ";
    }
    
     /**
      *  Accessor method of Transactions class
     * 
     * @return accountNumber
     * @param
     */
     public String getAccountNumber()
     {
         return accountNumber;
     }
         
    /**
     *  Mutator method of Transactions class
     * 
     * @return 
     * @param accNumber
     */
     public void setAccountNumber(String accNumber)
     { 
         accountNumber = accNumber;
     }
     
    /**
     *  Accessor method of Transactions class
     * 
     * @return operationType
     * @param
     */
     public String getOperationType()
     {
         return operationType;
     }
         
    /**
     *  Mutator method of Transactions class
     * 
     * @return 
     * @param opType
     */
     public void setOperationType(String opType)
     { 
         operationType = opType;
     }
     
    /**
     *  Accessor method of Transactions class
     * 
     * @return transactionAmount
     * @param
     */
     public double getTransactionAmount()
     {
         return transactionAmount;
     }
         
    /**
     *  Mutator method of Transactions class
     * 
     * @return 
     * @param transmount
     */
     public void setTransactionAmount(double transAmount)
     { 
         transactionAmount = transAmount;
     }
     
    /**
     *  Accessor method of Transactions class
     * 
     * @return transactionBalance
     * @param
     */
     public double getTransactionBalance()
     {
         return transactionBalance;
     }
         
    /**
     *  Mutator method of Transactions class
     * 
     * @return 
     * @param transBalance
     */
     public void setTransactionBalance(double transBalance)
     { 
         transactionBalance = transBalance;
     }
     
    /**
     *  Accessor method of Transactions class
     * 
     * @return transactionError
     * @param
     */
     public String getTransactionError()
     {
         return transactionError;
     }
     
    /** 
     * Mutator method of Transactions class
     * 
     * @return 
     * @param transError
     */
     public void setTransactionError(String transError)
     { 
         transactionError = transError;
     }
     
    /**
     *  Accessor method of Transactions class
     * 
     * @return transactionStatus
     * @param
     */
     public String getTransactionStatus()
     {
         return transactionStatus;
     }
     
    /**
     *  Mutator method of Transactions class
     * 
     * @return 
     * @param transStatus
     */
     public void setTransactionStatus(String transStatus)
     { 
         transactionError = transStatus;
     }
     
    /**
     *  Create a String representation based on the Transactions Object
     * 
     * @return String representation
     */
    public String toString() 
    {
    	return ("\n Account number " + getAccountNumber() + " Account Balance " + getTransactionBalance() + " Message " + getTransactionError());
    }

}

