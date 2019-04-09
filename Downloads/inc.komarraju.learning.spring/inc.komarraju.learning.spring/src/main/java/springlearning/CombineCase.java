package springlearning;

public class CombineCase {

	
	private String description=null;
	private long caseId;

	
	//public CombineCase(long combineCaseId, String description) {
		public CombineCase(String[] tokens) {
		super();
	}
	
	
	
	@Override
	public String toString() {
		return ("CombineCase: " + "caseId=" + caseId + " Description=" + description) ;
	}
   
	
	
	
	public String formatDescription(String line) {
    	
     //System.out.println("Inside //formatDescription method: " );
    	String finalString=null;
    	//System.out.println("line before:" + line);    	    	
    	line = line.replaceAll("\\s","");
    	
    	//System.out.println("line after:" + line);
    	
    	int startPosMember = line.lastIndexOf("MemberNumber:");
    	//System.out.println("startPosMember:"+ startPosMember);
    	int startPosDest   = line.lastIndexOf("DestinationAccount:");
    	 	//int endPos = lineDescription.lastIndexOf("Email");
    	int endPos = 15;
    	//System.out.println("startPosDest:"+ startPosDest);
    	if (startPosMember != -1 ) {
    	
    			  //formattedDescriptionNum =line.substring(startPosMember + 15);
    		finalString = 	  line.substring(startPosMember + 13);
    		    		  	
    	}
    	
    	if (startPosDest != -1) {
    		  //formattedDescription = line.substring(startPosDest + 21);
    		  finalString= line.substring(startPosDest + 19);
    		      	}
    	
    	
    	//System.out.println("finalString:" + finalString);
    	
    	
    	return finalString;	
	}
	
	
}
