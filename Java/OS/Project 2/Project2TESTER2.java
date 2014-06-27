import java.io.*;
import java.util.*;

/********************************************************************************


**********************************************************************************/

public class Project2TESTER2
{
  public static ArrayList<String> memImage = new ArrayList<String>();
  public static ProcessControlBlock[] processTable = new ProcessControlBlock[100];
  public static ProcessControlBlock CPU = new ProcessControlBlock();
  public static ProcessControlBlock readyQ = new ProcessControlBlock();
  public static ProcessControlBlock terminatedQ = new ProcessControlBlock();
  public static ProcessControlBlock PCB = new ProcessControlBlock();

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
  public static int pid(ProcessControlBlock[] ptable){
	  ProcessControlBlock pcb = new ProcessControlBlock();
	  int k = 0;
	  int id = pcb.getPid();
	  for(k = 0; k<100; k++){
		  id = (id + k) % 100;
		  if (processTable[id] == null)
		  	return id;
	  }
	  return -1; //no free process
  }



  public static void main(String[] args)
  {

	  try {
	  	File  f = new File("processes2.txt");
	  	Scanner in = new Scanner(f);
	  	while(in.hasNextLine()){
	  		String line = in.nextLine();
			memImage.add(line);
      	}

	  	readyQ = null;
	  	terminatedQ= null;
	  	int globalTime = 0;
	  do{
	  	for(int i=0; i< memImage.size(); i++){
			String s = memImage.get(i);
			StringTokenizer ss = new StringTokenizer(s);
			ss.nextToken();
			ss.nextToken();
			String arrivTime = ss.nextToken();
			int arriv = Integer.parseInt(arrivTime);
			if(globalTime == arriv){
				int newID = 0;
				for(int j=0; j<100; j++){
					newID = pid(processTable);
				}
				PCB.setPid(newID);

				if(processTable[newID]!=null){
					//SETTING PROCESS INFO
		  			String line2 = memImage.get(i);
		  			StringTokenizer st = new StringTokenizer(line2);
		  			//System.out.println(line2);

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

					ProcessControlBlock PCBnext = new ProcessControlBlock();
					ProcessControlBlock temp = new ProcessControlBlock();
					readyQ = temp.next;

				}
			}
			else {

				arriv++;
				String newArriv = Integer.toString(arriv);
				arrivTime = arrivTime + newArriv;
				System.out.println("Process delay");
			}



		}




			int cpuTime = 0;

			if(CPU == null && readyQ!=null){

				CPU = readyQ;
				readyQ.setState('e');
				readyQ = readyQ.next;
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
					CPU = terminatedQ;
					terminatedQ.setState('t');
					terminatedQ = terminatedQ.next;
					int id = terminatedQ.getPid();
					killProcess(id);
				}


			}

			//print contents of readyQ
			if (readyQ!=null){
				System.out.println("CONTENTS OF READY QUEUE");
				for(ProcessControlBlock pcb : processTable){
		  		System.out.println("---------------------------");
		  		System.out.println("pid: " + pcb.getPid());
		  		System.out.println("pname: " + pcb.getName());
		  		System.out.println("priority: " + pcb.getPriority());
		  		System.out.println("arrival time: " + pcb.getArrivalTime());
		  		System.out.println("burst time: " + pcb.getBurstTime());
		  		System.out.println("reg values: " + pcb.toString());
				}
			}

			//print contents of terminatedQ
			if (terminatedQ!=null){
				System.out.println("CONTENTS OF TERMINATED QUEUE");
				for(ProcessControlBlock pcb : processTable){
		  		System.out.println("---------------------------");
		  		System.out.println("pid: " + pcb.getPid());
		  		System.out.println("pname: " + pcb.getName());
		  		System.out.println("priority: " + pcb.getPriority());
		  		System.out.println("arrival time: " + pcb.getArrivalTime());
		  		System.out.println("burst time: " + pcb.getBurstTime());
		  		System.out.println("reg values: " + pcb.toString());
				}
			}













		globalTime++;
		 } while(globalTime < memImage.size());
	   }catch(IOException e){
	   			System.out.println("There was an error + e");
	   }
	}


}











