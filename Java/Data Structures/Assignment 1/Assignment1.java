import java.io.*;
import java.util.*;

public class Assignment1 {
	public interface stringStack<String>{
		public readFile (String alice.html){
		fFile = new File(alice.html);
		}
		public void readLine () throws FileNotFoundException {
			Scanner s = new Scanner(new FileReader(fFile));
			//trying to use the scanner class to read in the file line by line
			//haven't done this in java before that I can remember
			while (s.hasNextLine()) {
				processLine(s.nextLine());
				String S = s.nextLine();
				if (S.equals("<")){
					S = S + s.next();
					if (S.equals(S + "/>")){
						processLine(s.nextLine());
					}
					else{
						public void push(String S);
						processLine(s.nextLine());
					}
				}
				else if (!S.equals("</" + S)){
					public String pop();
					System.out.println("There was an error in html code.");
					processLine(s.nextLine());
				}
				else if (S.equals("<!")){
					processLine(s.nextLine());
			    }
			}
			System.out.println("Completed Successfully.");
		}
	}
}



