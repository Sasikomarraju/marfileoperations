package springlearning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.stream.reader.LineReader;

public class CsvFileReader {

	private static final String COMMA_DELIMITER = ",";

	private static final String FILE_HEADER = ",Case_Id,Account_1,Account_2,Dest_Pgm";

	private static String caseid="";
	private static String caseidprev="";
	private static int lineidx; 
	private static String line = "";
	private static String mainline="";
	private static long linecounter;
	
	@SuppressWarnings("unchecked")
	public static void readCsvFile(String fileName1,String fileName2) {
		BufferedReader fileReader = null;
		linecounter = 1;
		try {
			List cases  = new ArrayList();
			
			FileWriter fileWriter = null;
		    fileWriter  = new FileWriter(fileName2);
		    fileWriter.append(FILE_HEADER);
		    fileWriter.append(System.lineSeparator());

			fileReader = new BufferedReader(new FileReader(fileName1));
		
		//read first line which is a header
			fileReader.readLine();
			
			
			
			
			while ((line=fileReader.readLine()) != null) {
				
				String[] tokens = line.split(COMMA_DELIMITER);
				
				if(tokens.length > 0) {
					
 				    
					if (caseidprev == caseid) {	
						lineidx = line.indexOf("Marriott");
					
					if (lineidx != -1) {
						
						try {
							caseid = line.substring(0, lineidx - 2);
//						System.out.println("CaseID : "+ caseid);
						line=line.substring(lineidx+1);
						
						//System.out.println("CaseID : "+ caseid);
						fileWriter.append(COMMA_DELIMITER);
						   fileWriter.append(caseid);
						}
						catch(Exception e)
						{
							System.out.println("Marriott not found in text - Caseid: "+ line);
						//	System.out.println("line#: "+ linecounter);
						}
					}
						else {
							//System.out.println("line#: "+ linecounter);
							
							caseid = "";
					}
					
						      
						   
					}
					CombineCase combineCase = new CombineCase(tokens);
					String tempDescription = combineCase.formatDescription(line);				
					
 				    if (tempDescription != null && !tempDescription.equals("") ) {
 				    	tempDescription =  (tempDescription).replace('"', ' ') ;
 				  
 				    	
				   cases.add(combineCase);
				   
				  
				
				   mainline = mainline + "," + tempDescription;
				   
				   fileWriter.append(mainline);
				   
				   
					   
				   //System.out.println("mainline:" + mainline); 
				   
				   
				   try {			   
				   String tempVar = mainline.substring(1,3);
				   //System.out.println("tempVar:" + tempVar);
				   
				   if("MR".equals(tempVar) || "SP".equals(tempVar)) {
				   	   fileWriter.append(System.lineSeparator());
				   }
				   }
				   catch(StringIndexOutOfBoundsException s) {
					   //System.out.println("CaseId:" + caseid);
					   System.out.println("line:"+ line);
					   //System.out.println("mainline:" + mainline);
				   }
				   
				   //
				   mainline="";
				   caseidprev=caseid;
				   caseid="";
				    
 				    }
 				
				}
				
				
			}
		
			
            fileWriter.flush();
          fileWriter.close();
			}
		
	
		catch(Exception e) {
		   System.out.println("line :"+ line);
			System.out.println("Error in CsvReader!!!");
			e.printStackTrace();
		}
	}
}
