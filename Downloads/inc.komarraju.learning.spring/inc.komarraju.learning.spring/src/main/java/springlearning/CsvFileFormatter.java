package springlearning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.List;


public class CsvFileFormatter {

	private static final String COMMA_DELIMITER = ",";
	private static final String SYSTEM_MR = "MR";
	
	public static void formatCsvFile(String fileName2,String fileName3) {
	
		BufferedReader fileReader2 = null;
		
		try {
			List newCases  = new ArrayList();
			
			String newline = "";
			
			FileWriter fileWriter3 = null;
		    fileWriter3  = new FileWriter(fileName3);
		  //  fileWriter3.append(COMMA_DELIMITER);
		    fileWriter3.flush();
		    
		    fileReader2 = new BufferedReader(new FileReader(fileName2));
			
			fileReader2.readLine();
			
			while ((newline=fileReader2.readLine()) != null) {
								
				String newToken = newline.substring(1,newline.length());
				//System.out.println("newToken"+ newToken);
		
				String[] tokens = newToken.split(COMMA_DELIMITER);
							
			try {
				if (tokens!=null && !tokens.equals("") && tokens.length > 2) {

					fileWriter3.append(tokens[0].toString());
					fileWriter3.append(COMMA_DELIMITER);
					
					
					if (tokens[3].contains(SYSTEM_MR)) 
					
						{
					//System.out.println("In MR");
							
					fileWriter3.append(tokens[2].toString());
					fileWriter3.append(COMMA_DELIMITER);
					fileWriter3.append(tokens[1].toString());
					fileWriter3.append(System.lineSeparator());
								
						}
					else
						{
					//System.out.println("In SPG");
					fileWriter3.append(tokens[1].toString());
					fileWriter3.append(COMMA_DELIMITER);
					fileWriter3.append(tokens[2].toString());
					fileWriter3.append(System.lineSeparator());
								
						}
					}
				else {	
					System.out.println(newline);
				}
				}
				catch(Exception e) {
					System.out.println("Case Id :"+ tokens[0]);
					//System.out.print(tokens.length + tokens[0] + tokens[1] );
					
				e.printStackTrace();
				}
			

		      
				//if (tokens != null)
				//System.out.println("tokens:" + tokens);
				
//				if(tokens.length > 0) {
//				}
				
				
			}
			
		    
		      fileWriter3.flush();
	          fileWriter3.close();
	    
		

			
		}
		catch(Exception e) {
			
			System.out.println("Error in CsvReader!!!");
			e.printStackTrace();
		}
		
	}
		
}
