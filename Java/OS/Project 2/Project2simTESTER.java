import java.io.*;
import java.util.*;

/********************************************************************************


**********************************************************************************/

public class Project2simTESTER
{
  public static ArrayList<String> memImage = new ArrayList<String>();
  public static ProcessControlBlock[] processTable = new ProcessControlBlock[100];
  public static ProcessControlBlock CPU = new ProcessControlBlock();
  public static ProcessControlBlock readyQfront = new ProcessControlBlock();
  public static ProcessControlBlock readyQrear = new ProcessControlBlock();
  public static ProcessControlBlock tQfront = new ProcessControlBlock();
  public static ProcessControlBlock tQrear = new ProcessControlBlock();
  //public static ProcessControlBlock terminatedQ = new ProcessControlBlock();
  public static ProcessControlBlock PCB = new ProcessControlBlock();
  //public static ProcessControlBlock hold = new ProcessControlBlock();


  //Random Register Generator
  public static String ab = "01234567890ABCDEF";
  public static Random rnd = new Random();
  public static String randomString(int len){
  StringBuilder sb = new StringBuilder(len);
  for(int i = 0; i<len; i++)
  	sb.append(ab.charAt(rnd.nextInt(ab.length()) ) );
  return sb.toString();
  }

  //kill process
  public static void killProcess(int n) {
      processTable[n] = null;
  }
  // add process
  public static void addProcess(int n) {
      processTable[n] = PCB;
  }

  //find an open slot in the process table
  public static int findOpenSlot(int n){

	  int k = 0;
	  int id = 0;

	  for(k = 0; k<100; k++){
		  id = (n + k) % 100;
		  if (processTable[id] == null)
		  	return id;
	  }
	  return -1; //no free process
  }



  public static void main(String[] args)
  {

	  try{
	  	File  f = new File("processes2.txt");
	  	Scanner in = new Scanner(f);
	  	PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
	  	while(in.hasNextLine()){
	  		String line = in.nextLine();
			memImage.add(line);
      	}
      	in.close();

      	readyQfront = null;
  		readyQrear = null;
  		tQfront = null;
  		tQrear = null;

	  	int globalTime = 0;
	  	int newID = 0;

	  	do{
			  for(int k=0; k<memImage.size(); k++){
				  String s = memImage.get(k);
				  StringTokenizer ss = new StringTokenizer(s);

				  ss.nextToken();

				  ss.nextToken();
				  String arrivTime = ss.nextToken();
			 	  int arriv = Integer.parseInt(arrivTime);



			  	  if(arriv == globalTime){

					    //System.out.println("do stuff");
				  	//for(String process : memImage){


						for(int i =0; i<100; i++){

				  			if (processTable[i]==null){


					  			//SETTING PROCESS INFO
					  			String line2 = memImage.get(i);
					  			StringTokenizer st = new StringTokenizer(line2);



					  			//First item is name
								String pname = st.nextToken();
								PCB.setName(pname);

								//Second is process priority
								String priority = st.nextToken();
								//turning string into an int
								int pri = Integer.parseInt(priority);
								PCB.setPriority(pri);
								//Third is Arrival Time
								String arrivalTime = st.nextToken();
								int arrival = Integer.parseInt(arrivalTime);
								PCB.setArrivTime(arrival);
									//CPU Burst Time
								String burst = st.nextToken();
								int bt = Integer.parseInt(burst);
								PCB.setBurstTime(bt);
								//Remaining are Registers
								String xar = st.nextToken();
								String xdi = st.nextToken();
								String xdo = st.nextToken();
								String pc = st.nextToken();
								String ir = st.nextToken();
								String emit = st.nextToken();
								String rr = st.nextToken();
								String psw = st.nextToken();
								String r0 = st.nextToken();
								String r1 = st.nextToken();
								String r2 = st.nextToken();
								String r3 = st.nextToken();
								String r4 = st.nextToken();
								String r5 = st.nextToken();
								String r6 = st.nextToken();
								String r7 = st.nextToken();
								PCB.setValues(xar, xdi, xdo, pc, ir, emit, rr, psw,
											r0, r1, r2, r3, r4, r5, r6, r7);

								//SET PID IN ROUND-ROBIN AND ADD TO PROC TABLE

								for(int j=0; j<100; j++){
									newID = findOpenSlot(j);
									//findOpenSlot(newID);
								}
								PCB.setPid(newID);
								addProcess(newID);

								PCB.setState('r');


								//out.println(processTable[newID]);


								//adjust pointers for ReadyQ
								ProcessControlBlock temp = new ProcessControlBlock();
								temp = PCB;
								readyQfront.next = temp;
								readyQrear = temp;

							}//end if

							else {

								arriv++;
								String newArriv = Integer.toString(arriv);
								arrivTime = newArriv;
								System.out.println("Process delay");

							}

						}




				}//end if arrivtime

			}//for


			int cpuTime = 0;


			if(CPU == null && readyQfront!=null){

				readyQfront = readyQfront.next;
				CPU = readyQfront;
				CPU.setState('e');
			}
			else {
				cpuTime++;
				//generate random reg values
				String xar = randomString(6);
				String xdi = randomString(6);
				String xdo = randomString(6);
				String pc = randomString(6);
				String ir = randomString(6);
				String emit = randomString(6);
				String rr = randomString(6);
				String psw = randomString(6);
				String r0 = randomString(6);
				String r1 = randomString(6);
				String r2 = randomString(6);
				String r3 = randomString(6);
				String r4 = randomString(6);
				String r5 = randomString(6);
				String r6 = randomString(6);
				String r7 = randomString(6);
				PCB.setValues(xar, xdi, xdo, pc, ir, emit, rr, psw,
										r0, r1, r2, r3, r4, r5, r6, r7);


				//adjust pointers for terminatedQ, and remove from process table once done
				if(cpuTime >= CPU.getBurstTime()){
					CPU.setState('t');
					//System.out.println(CPU.getPid());
					ProcessControlBlock temp = new ProcessControlBlock();
					temp = PCB;
					tQfront.next = temp;
					tQrear = temp;
                    //System.out.println(tQrear);
					int id = tQrear.getPid();
					killProcess(id);
				}


			}


			//print contents of readyQ
			if (readyQrear!=null){
				out.println("CONTENTS OF READY QUEUE");

		  		out.println("---------------------------");

		  		out.println("pname: " + readyQrear.getName());
		  		out.println("priority: " + readyQrear.getPriority());
		  		out.println("arrival time: " + readyQrear.getArrivalTime());
		  		out.println("burst time: " + readyQrear.getBurstTime());
		  		out.println("reg values: " + readyQrear.regToString());

			}

			//print contents of terminatedQ
			if (tQrear!=null){
				out.println("CONTENTS OF TERMINATED QUEUE");

		  		out.println("---------------------------");

		  		out.println("pname: " + tQrear.getName());
		  		out.println("priority: " + tQrear.getPriority());
		  		out.println("arrival time: " + tQrear.getArrivalTime());
		  		out.println("burst time: " + tQrear.getBurstTime());
		  		out.println("reg values: " + tQrear.regToString());

			}













		globalTime++;

		}while(processTable[newID] != null);
		System.out.println("Done.");

	   out.close();
	   }
	   catch(IOException e){
	   			System.out.println("There was an error + e");
	   }
	}


}











