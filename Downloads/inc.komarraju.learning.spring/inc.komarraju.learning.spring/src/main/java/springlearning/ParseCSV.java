package springlearning;

import java.io.FileReader;

import com.opencsv.CSVReader;

public class ParseCSV {
	  public static void main(String[] args) {
	    try {
	      //csv file containing data
	      String strFile = "C:/Users/skoma814/Desktop/Batch Merge/Account_Merge_Taskforce Cases_test23.csv";
	      CSVReader reader = new CSVReader(new FileReader(strFile));
	      String [] nextLine;
	      int lineNumber = 0;
	      while ((nextLine = reader.readNext()) != null) {
	        
	        //System.out.println("Line # " + lineNumber);
	      //  System.out.print(nextLine[0]);
	        //System.out.print(" ");
	        //System.out.print(nextLine[1]);
	        //System.out.print("\n");

	    	  String[] tokens = nextLine[1].split(",");
	    	  
	    	  CombineCase combineCase = new CombineCase(nextLine);
			    
	    	  
	    	  for (String s:tokens ) {
	    		 System.out.println("token element:" + s);
	    	  }
	    		 String tempDescription = combineCase.formatDescription(nextLine[1]);
			
	    		  //if (tempDescription != null && !tempDescription.equals("") ) {
			    	
	    			  //tempDescription = (tempDescription).replace('"', ' ') + "," ;
	    			  System.out.println("Returned from method:" + tempDescription);	
	    		  //}
			
		//	System.out.println("tempDescription:" + tempDescription);
	        lineNumber++;
	      }
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	  }
	}