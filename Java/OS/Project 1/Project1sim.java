import java.io.*;
import java.util.*;

/********************************************************************************

Algorithm:
1) Create a PCB class with all required fields
2) Create an ArrayList Process Table of type ProcessControlBlock
3) Read processes1.txt in, and tokenize the line
3) While there are tokens on line
	A) Set first token to process name
	B) Set next token to process priority
	C) Set next token to arrival time
	D) Set next token to Burst time
	E) Set next token to appropriate Register Value
		- First is XAR, next is XDI, then XDO.
		- (Run through each grouping)
	F) Add the PCB onto the arrayList
4) Print the contents of the Process Table
**********************************************************************************/

public class Project1sim
{
  public static void main(String[] args)
  {
	  try {
		Scanner keyIn = new Scanner(System.in);
		File  f = new File("processes1.txt");
    	Scanner in = new Scanner(f);
    	ArrayList<ProcessControlBlock> processTable = new ArrayList<ProcessControlBlock>();

    	while (in.hasNextLine()) {
			String ln = in.nextLine();
			StringTokenizer st = new StringTokenizer(ln);
			//Breaking up the Line into PCB components
			while(st.hasMoreTokens()) {
				ProcessControlBlock PCB = new ProcessControlBlock();
				//First item is name
				String pname = st.nextToken();
				PCB.setName(pname);

				//Second is process priority
				String priority = st.nextToken();
				//turning string into an int
				int pri = Integer.parseInt(priority);
				PCB.setPriority(pri);

				//Third is Arrival Time
				String arrivTime = st.nextToken();
				int arriv = Integer.parseInt(arrivTime);
				PCB.setArrivTime(arriv);

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

				//Finished reading line. Add the Line to the Process Table.
				processTable.add(PCB);



			}

		  }

		  Iterator itr = processTable.iterator();
		  while(itr.hasNext()){
		  	//Print the contents of the Process Table
		  	for(ProcessControlBlock pcb : processTable){
		  		System.out.println("---------------------------");
		  		System.out.println("pid: " + pcb.id);
		  		System.out.println("pname: " + pcb.getName());
		  		System.out.println("priority: " + pcb.getPriority());
		  		System.out.println("arrival time: " + pcb.getArrivalTime());
		  		System.out.println("burst time: " + pcb.getBurstTime());
		  		System.out.println("reg values: " + pcb.toString());
		  		System.out.println("Press the \"Enter\" key to continue");
		  		keyIn.nextLine();
			}
	      }

	    }catch(IOException e){
			System.out.println("There was an error + e");
		}
	}
}









