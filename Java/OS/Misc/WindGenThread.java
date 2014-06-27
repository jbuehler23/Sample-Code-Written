import java.util.Random;

class WindGenThread extends Thread {
	private Wind newWind;
	private Random randWind = new Random();
	int randomWind;

	public WindGenThread(Wind wind) {
		randomWind = 0;
		newWind = wind;
	}

	public void run() {
		try {
			for (int i=0; i<100 && !isInterrupted(); i++) {

				randomWind = randWind.nextInt(360) + 1;
				newWind.setWindDir(randomWind);
				sleep(10);

			}
		}
		catch (InterruptedException e) {}
	}
}
