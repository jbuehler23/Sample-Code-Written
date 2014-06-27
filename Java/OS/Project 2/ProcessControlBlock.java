public class ProcessControlBlock {
	public static int staticID = 0;
	public int id;
	private char state;
	private String name = "";
	private int priority;
	private int arrivTime;
	private int burstTime;
	RegisterSet reg = new RegisterSet();
	public static ProcessControlBlock next = new ProcessControlBlock();

	//Constructor
	public ProcessControlBlock() {
		state = 'n';
		next = null;
	}

	//setters
	public void setName(String n){
		name = n;
	}
	public void setPriority(int pri){
		priority = pri;
	}
	public void setState(char s){
		state = s;
	}
	public void setPid(int id){
		id = id;
	}
	public void setArrivTime(int t){
		arrivTime = t;
	}
	public void setBurstTime(int burst){
		burstTime = burst;
	}

	//getters
	public String getName()
       { return name; }
    public int getPriority()
       { return priority; }
    public char getState()
       { return state; }
    public int getPid()
       { return id; }
	public int getArrivalTime()
       { return arrivTime; }
	public int getBurstTime()
       { return burstTime; }

    //Register Set Value

    public void setValues(String XAR, String XDI,
    						String XDO, String PC, String IR,
    						String EMIT, String RR, String PSW,
    						String R0, String R1, String R2,
    						String R3, String R4, String R5, String R6,
    						String R7){
		reg.setXAR(XAR);
		reg.setXDO(XDO);
		reg.setXDI(XDI);
		reg.setPC(PC);
		reg.setIR(IR);
		reg.setEMIT(EMIT);
		reg.setRR(RR);
		reg.setPSW(PSW);
		reg.setR0(R0);
		reg.setR1(R1);
		reg.setR2(R2);
		reg.setR3(R3);
		reg.setR4(R4);
		reg.setR5(R5);
		reg.setR6(R6);
		reg.setR7(R7);
	}

	public RegisterSet getValues(){
		return this.reg;
	}
		public String regToString(){
			String str="\nXAR: "+ reg.getXAR() + "  " +
			 				"\nXDI: " + reg.getXDI() + "  " +
			 				"\nXDO: " + reg.getXDO() + "  " +
			 				"\nPC: " + reg.getPC() + "  " +
			 				"\nIR: " + reg.getIR() + "  " +
			 				"\nEMIT: " + reg.getEMIT() + "  " +
			 				"\nRR: " + reg.getRR() + "  " +
			 				"\nPSW: " + reg.getPSW() + "  " +
			 				"\nR0: " + reg.getR0() + "  " +
			 				"\nR1: " + reg.getR1() + "  " +
			 				"\nR2: " + reg.getR2() + "  " +
			 				"\nR3: " + reg.getR3() + "  " +
			 				"\nR4: " + reg.getR4() + "  " +
			 				"\nR5: " + reg.getR5() + "  " +
			 				"\nR6: " + reg.getR6() + "  " +
			 				"\nR7: " + reg.getR7();
			 return str;
	}


}//end class

