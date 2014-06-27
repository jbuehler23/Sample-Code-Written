import java.util.Random;

class GenFlightThread extends Thread {
	private Random randFlightNo = new Random();
	int randomLanding;

	private Random randWaitTime = new Random();
	public static int waitingTime;
		//Made as a static so I can sleep in each thread
		//for the same time as the "wait time"
		//if the queue isn't empty
		//otherwise, keep deQueueing

	private Random randFlightType = new Random();
	int flightType;

	MyQueue1<Integer> LQ = new Queue1<Integer>();
	MyQueue1<Integer> TQ = new Queue1<Integer>();


	public GenFlightThread(MyQueue1<Integer>TakeQ, MyQueue1<Integer>LandQ) {
			randomLanding = 0;
			flightType = 0;
			waitingTime = 0;
			TQ = TakeQ;
			LQ = LandQ;
	}

	public void run() {
		try {
			for (int i=0; i<200 && !isInterrupted(); i++) {

				randomLanding = randFlightNo.nextInt(10000);
					//random flight id
				waitingTime  = randWaitTime.nextInt(10);
					//random wait time
				flightType = randFlightType.nextInt(2);
					//random flight type

				if (flightType == 0 ) {
					//the flight number belongs in the take off queue
					TQ.enQueue(randomLanding);

					//---DEBUGGING PURPOSES BELOW---
					//System.out.println("Take off " +TQ.front());
				}
				else{
					//the flight belongs in the landing queue
					LQ.enQueue(randomLanding);

					//---DEBUGGING PURPOSES BELOW---
					//System.out.println("added");
					//System.out.println("Landing "+LQ.front());
				}
				//System.out.println("Waiting for " + waitingTime + " ms");

				sleep(waitingTime);

			}
		}
		catch (InterruptedException e) {}
	}
}