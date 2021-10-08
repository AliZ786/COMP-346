import java.util.PriorityQueue;

/**
 * Class Monitor
 * To synchronize dining philosophers.
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca
 */
public class Monitor
{
	/*
	 * ------------
	 * Data members
	 * ------------
	 */
	private enum STATE {THINKING, HUNGRY, EATING};
	// number of philosophers
	private int numPhilosophers;
	// array that will hold the states
	private STATE[] states;
	// boolean to check if a philosopher is talking
	private boolean is_talking;

	private PriorityQueue<Integer> hungryList;


	/**
	 * Constructor
	 */
	public Monitor(int piNumberOfPhilosophers)
	{
		// TODO: set appropriate number of chopsticks based on the # of philosophers
		numPhilosophers = piNumberOfPhilosophers;
		states = new STATE[numPhilosophers];

		// initialize all philosophers to thinking
		for(int i = 0; i < numPhilosophers; i++) {
			states[i] = STATE.THINKING;
		}

		/**
		 * Creating a new hungryList for the constructor
		 */
		hungryList = new PriorityQueue<>();

		// initially, no philosopher is talking
		is_talking = false;
	}

	/*
	 * -------------------------------
	 * User-defined monitor procedures
	 * -------------------------------
	 */


	public synchronized void checkActions(int philosopherPos){
		try { 
			while(true){

				/* Here we have the (philosopherPos +1 being your left-handed side and your left-handed side
				being philosopherPos + (numPhilosophers - 1)) % numPhilosophers>. We do % here because we don't have to go overboard
				for the number of philosophers. philosopherPos is you, if you are hungry, and your neighbors (left and right positions) are not eating
				then you are able to eat. Else, you would have to wait() your turn.
				 */

				if(states[(philosopherPos + 1) % numPhilosophers] != STATE.EATING && states[(philosopherPos + (numPhilosophers - 1)) % numPhilosophers] != STATE.EATING
						&& states[philosopherPos] == STATE.HUNGRY){
					states[philosopherPos] = STATE.EATING; // We know here that the philosopher can start eating
					break;
				}
				else {
					wait();
				}
			}
		}

		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Grants request (returns) to eat when both chopsticks/forks are available.
	 * Else forces the philosopher to wait()
	 */
	public synchronized void pickUp(final int piTID)
	{
		int PhilosopherPos = piTID - 1;

		// changing state to hungry
		states[PhilosopherPos] = STATE.HUNGRY;

		// adding the philosopher to the hungry list
		hungryList.add(piTID);

		//test the philosopher
		checkActions(PhilosopherPos);

		// remove the philosopher from the hungry list since they are already eating
		hungryList.remove();
	}

	/**
	 * When a given philosopher's done eating, they put the chopstiks/forks down
	 * and let others know they are available.
	 */
	public synchronized void putDown(final int piTID)
	{
		int philosopherPos = piTID - 1;

		// changing state to thinking
		states[philosopherPos] = STATE.THINKING;

		// Notifies the other threads, so that they may be able to see if they are able to see the actions of their neighbors
		notifyAll();
	}

	/**
	 * Only one philopher at a time is allowed to philosophy
	 * (while she is not eating).
	 */
	public synchronized void requestTalk()
	{
		if(is_talking) {
			try {

				/**
				 * Wait until another philosopher is still talking, when he's done, you request to talk
				 */
				wait();
				requestTalk();
			} 

			catch(InterruptedException e) {
				System.out.println("A philosopher is currently speaking something very useful. Please wait to philosophy");
			}

			// the philosopher is talking
			is_talking = true;
		}
	}

	/**
	 * When one philosopher is done talking stuff, others
	 * can feel free to start talking.
	 */
	public synchronized void endTalk()
	{
		// the philosopher is no longer talking
		is_talking = false;

		// Notify all the other threads that you are the one done talking, and now they have a chance to speak as well.
		notifyAll();
	}
}

// EOF
