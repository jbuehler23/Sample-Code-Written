import java.io.*;
import java.util.*;

public class Assignment3 {
	public static void main(String[] args) throws IOException{

		Scanner s = new Scanner(new File("Reuters00.txt"));
		PrintStream out = new PrintStream(new FileOutputStream("Output.txt"));
		String output = out.toString();
		
		while (s.hasNextLine()){
		
		

			MySet <String> s1 = new MySet();
		
		


				char ch = '>';
				int end = output.lastIndexOf(ch);

				while (output.indexOf('<')){
					if (output.substring(0, end) != null){
						String temp = output.substring(1, end);
						int pos = end + 1;
						String[] html;
						if (temp.substring(pos, end) == "/"){
							pos = end +1;
							s1.add(html);
							System.out.println(html);
						}
						if (temp.startsWith("/", pos)){
							pos = 			
							s1.add(html);
							System.out.println(html);
							pos = end +1;
							}

						}

					}
					

						
				}
			
			
		}
            
		
		
		
		
	}
	


