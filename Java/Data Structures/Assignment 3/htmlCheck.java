import java.io.*;
import java.util.*;

public class htmlCheck {
	public static void main(String[] args) throws IOException{

		Scanner s = new Scanner(new File("alice.html"));
		PrintStream out = new PrintStream(new FileOutputStream("Output.txt"));
		String output = out.toString();
		
		while (s.hasNextLine()){
		
		
			int c = 0;
			stack s1 = new stack();
		
		

				c++; //no pun intended
				char ch = '>';
				int end = output.lastIndexOf(ch);

				while (output.indexOf('<')){
					if (output.substring(0, end) != null){
						String temp = output.substring(1, end);
						int pos = end + 1;
						String[] html;
						if (temp.substring(0 , 1) == "!"){    //check for a comment tag
							pos = end +1;
						}
						if (temp.substring(pos, end) == "/"){ //check for a self closing tag
							pos = end +1;
						}
						if (temp.startsWith("/", pos)){       //check to make sure the close tag matches what's on top of stack
							if (s1.front() = temp.substring(1, end)){
								 s1.popFront(html , c);
								 pos = end +1;
							}
							else
								System.out.print("There was an error on line " + c +".");   //error message on counter
						}
						if (temp.substring(pos) == "<"){    //pushes the html tag from current position to white space
							html = temp.split(" ");
							s1.pushFront(html, c);
							pos = end+1;
						}
					}
					
					if (!s1.isEmpty()){
						System.out.print("There was an error on line " + c +".");   //checks that the stack is empty then prints error if not
						
					}
						
				}
			
			
		}
            
		
		
		
		
	}
	

}
