
public class RunwaySim1 {
	public static void main(String args[]) {

		Runway1 r1 = new Runway1();
		MyQueue1<Integer> LandingQ = new Queue1<Integer>();
		MyQueue1<Integer> TakeOffQ = new Queue1<Integer>();

		GenFlightThread G2 = new GenFlightThread(TakeOffQ, LandingQ);
			//start the generation thread

		LandingThread1 L0 = new LandingThread1(r1, LandingQ);
			//start the landing thread

		TakeOffThread1 T1 = new TakeOffThread1(r1, TakeOffQ);
			//start the take off thread

		G2.start();
		L0.start();
		T1.start();

	}

}