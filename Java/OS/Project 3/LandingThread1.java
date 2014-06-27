import java.util.Random;

//Couldn't get my Wind class and WindGenThread to work properly,
//so I am going to just generate the wind randomly in the thread.

class LandingThread1 extends Thread {
	MyQueue1<Integer> LQ = new Queue1<Integer>();
	private Runway1 newFlight;
	private int flightid;
	Random randWind = new Random();
	private int randomWind;



	public LandingThread1(Runway1 flight, MyQueue1<Integer> LandQ) {
		newFlight = flight;
		LQ = LandQ;
	}

	public void run() {
		try {
			for (int i=0; i<200 && !isInterrupted(); i++) {

				randomWind = randWind.nextInt(360) + 1;
				if(!LQ.isEmpty()){

					flightid = LQ.deQueue();
					newFlight.land(flightid, randomWind);

				}
				//---DEBUGGING PURPOSES BELOW---
				//System.out.println("nothing in queue");



				sleep(GenFlightThread.waitingTime);



			}
		}
		catch (InterruptedException e) {}
	}
}//end class

