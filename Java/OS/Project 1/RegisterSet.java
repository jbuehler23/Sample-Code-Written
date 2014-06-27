public class RegisterSet {
	public RegisterSet(){
		//empty
	}

	//XAR
	private String XAR;
	public void setXAR(String value)
	 {
	     this.XAR = value;
	 }

	public String getXAR()
	 {
	     return this.XAR;
	 }
	 //XDI
	private String XDI;
	public void setXDI(String value)
	 {
	     this.XDI = value;
	 }

	public String getXDI()
	 {
	     return this.XDI;
	 }
	 //XDO
	private String XDO;
	public void setXDO(String value)
	 {
	     this.XDO = value;
	 }

	public String getXDO()
	 {
	     return this.XDO;
	 }
	 //PC
	private String PC;
	public void setPC(String value)
	 {
	     this.PC = value;
	 }

	public String getPC()
	 {
	     return this.PC;
	 }
	 //IR
	private String IR;
	public void setIR(String value)
	 {
	     this.IR = value;
	 }

	public String getIR()
	 {
	     return this.IR;
	 }
	 //EMIT
	private String EMIT;
	public void setEMIT(String value)
	 {
	     this.EMIT = value;
	 }

	public String getEMIT()
	 {
	     return this.EMIT;
	 }
	 //RR
	private String RR;
	public void setRR(String value)
	 {
	     this.RR = value;
	 }

	public String getRR()
	 {
	     return this.RR;
	 }
	 //PSW
	private String PSW;
	public void setPSW(String value)
	 {
	     this.PSW = value;
	 }

	public String getPSW()
	 {
	     return this.PSW;
	 }
	 //R0
	 private String R0;
	 public void setR0(String value)
	 {
	 	 this.R0 = value;
	 }

	 public String getR0()
	 {
	 	 return this.R0;
	 }
	 //R1
	 private String R1;
	 public void setR1(String value)
	 {
	 	 this.R1 = value;
	 }

	 public String getR1()
	 {
	 	 return this.R1;
	 }
	 //R2
	 private String R2;
	 public void setR2(String value)
	 {
	 	 this.R2 = value;
	 }

	 public String getR2()
	 {
	 	 return this.R2;
	 }
	 //R3
	 private String R3;
	 public void setR3(String value)
	 {
	 	 this.R3 = value;
	 }

	 public String getR3()
	 {
	 	 return this.R3;
	 }
	 //R4
	 private String R4;
	 public void setR4(String value)
	 {
	 	 this.R4 = value;
	 }

	 public String getR4()
	 {
	 	 return this.R4;
	 }
	 //R5
	 private String R5;
	 public void setR5(String value)
	 {
	 	 this.R5 = value;
	 }

	 public String getR5()
	 {
	 	 return this.R5;
	 }
	 //R6
	 private String R6;
	 public void setR6(String value)
	 {
	 	 this.R6 = value;
	 }

	 public String getR6()
	 {
	 	 return this.R6;
	 }
	 //R7
	 private String R7;
	 public void setR7(String value)
	 {
	 	 this.R7 = value;
	 }

	 public String getR7()
	 {
	 	 return this.R7;
	 }
	 //////////////TO STRING//////////////
	 public String ToString(){
		 RegisterSet reg = new RegisterSet();
		 String reg1 ="XAR: "+ reg.getXAR() +
		 				"\nXDI: " + reg.getXDI() +
		 				"\nXDO: " + reg.getXDO() +
		 				"\nPC: " + reg.getPC() +
		 				"\nIR: " + reg.getIR() +
		 				"\nEMIT: " + reg.getEMIT() +
		 				"\nRR: " + reg.getRR() +
		 				"\nPSW: " + reg.getPSW() +
		 				"\nR0: " + reg.getR0() +
		 				"\nR1: " + reg.getR1() +
		 				"\nR2: " + reg.getR2() +
		 				"\nR3: " + reg.getR3() +
		 				"\nR4: " + reg.getR4() +
		 				"\nR5: " + reg.getR5() +
		 				"\nR6: " + reg.getR6() +
		 				"\nR7: " + reg.getR7();
		 return reg1;
	 }

}//end class