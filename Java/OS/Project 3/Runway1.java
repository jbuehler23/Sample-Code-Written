import java.util.concurrent.locks.*;

class Runway1 {

	private int flightNo;
	private boolean RunwayIsActive = false;

	//private int windDirection;


	private Lock L;
	private Condition C;

	public Runway1() {

		L = new ReentrantLock();
		C = L.newCondition();
	}



	public void land(int flightNo, int windDirection){
		L.lock();
		try{
			System.out.println("/*******Wind Direction = "+windDirection+ " degrees. ********/");
			RunwayIsActive = true;
			//0 to 90 wind direction
			if(windDirection >= 0 && windDirection<=90){
				//Quadrant 1
				System.out.println("Flight Number " + flightNo + " bearing South to North on Runway for landing");
			}
			else if(windDirection >= 91 && windDirection<=270){
				//Quadrants 2 and 3
				System.out.println("Flight Number " + flightNo + " bearing North to South on Runway for landing");
			}
			else {
				//Quadrant 4
				System.out.println("Flight Number " + flightNo + " bearing South to North on Runway for landing");
			}
			System.out.println();
			C.signalAll();
		}
		finally {
			L.unlock();
		}
	}

	public void takeOff(int flightNo, int windDirection) throws InterruptedException {
		L.lock();
		try {

			if(RunwayIsActive){
				System.out.println("----Waiting for runway to clear...----");
				C.await();
				RunwayIsActive = false;
			}

			System.out.println("/*******Wind Direction = "+windDirection+ " degrees. ********/");
			//0 to 90 wind direction
			if(windDirection >= 0 && windDirection<=90){
				//Quadrant 1
				System.out.println("Flight Number " + flightNo + " bearing South to North on Runway for take-off");

			}
			else if(windDirection >= 91 && windDirection<=271){
				//Quadrants 2 and 3
				System.out.println("Flight Number " + flightNo + " bearing North to South on Runway for take-off");

			}
			else{
				//Quadrant 4
				System.out.println("Flight Number " + flightNo + " bearing South to North on Runway for take-off");
			}
			System.out.println();


		}
		finally {

			L.unlock();


		}
	}
}//end runway


