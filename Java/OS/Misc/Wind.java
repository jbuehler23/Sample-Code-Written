class Wind {
	private int windDir;
	public Wind() {
		windDir = 0;
	}

	public synchronized void setWindDir(int wind) {
		windDir = wind;
	}

	public synchronized int getWindDir() {
		return windDir;
	}
}

