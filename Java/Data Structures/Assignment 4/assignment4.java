import java.io.*;
import java.util.*;


//You really need to work on the algorithm.
//The problem here is with the plan that you are using.  Maybe we can
//talk about the algorithm if you come in for some extra help.

//Grade: 6/10
public class assignment4 {
	public static void main(String[] args) throws IOException{

		Scanner s = new Scanner(new File("Reuters00.txt"));
		PrintStream out = new PrintStream(new FileOutputStream("Output.txt"));
		String output = out.toString();

		while (s.hasNextLine()){



			MyListMap <String> s1 = new MyListMap();  //you do not need a new map for every line.
			MySet <Int> i1 = new MySet;               //you do not need a new set for every line.


				String words = output.toLowerCase();

				int end = output.lastIndexOf(words);


				while (output.indexOf(words)){
					if (output.substring(0, end) != null){
						String temp = output.substring(1, end);
						int pos = end + 1;
						int number;
						int id = output.indexOf(number);
						if (temp.substring(pos, end) == " "){
							pos = end +1;
							s1.put(words);
							i1.add(id);
							System.out.print(s1.get() + i1.get());
						}




					}



				}


		}









