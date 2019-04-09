package springlearning;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class GetDataFromDB2 {
	
	
	//public static void main(String[] args) {
	//	
	//	String oldSpgId = "00021232904";
	//	String newSpgId=null;
	//	
	 //   newSpgId = getNewSpgId(oldSpgId);
	 //   System.out.println("newSpgId:" + newSpgId);
	 //   
//	}

	public  String getNewSpgId(String oldSpgId) {
		String newSpgIdlocal=null;
		
		
		try {
	            Class.forName("COM.ibm.db2.jcc.DB2Driver");
	        }
	       catch (ClassNotFoundException e) {
	    //      System.out.println("Please include Classpath  Where your DB2 Driver is located");
	     //    e.printStackTrace();
	            //return;
	      }
	        //System.out.println("DB2 driver is loaded successfully");
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rset=null;
	        boolean found=false;
	        try {
	            conn = DriverManager.getConnection("jdbc:db2://159.166.51.35:1421/USMARRDSNP","skoma81","SASIb02#");
	            if (conn != null)
	            {
	          //      System.out.println("DB2 Database Connected");
	            }
	            else
	            {
	                System.out.println("Db2 connection Failed ");
	            }
	            pstmt=conn.prepareStatement("SELECT NEW_SPG_ID FROM HXP001.HXTXREFMEMBERID WHERE LEGACY_SPG_ID = ? ");
	            
	            pstmt.setString(1, oldSpgId);
	            rset=pstmt.executeQuery();
	            if(rset!=null)
	            {

	                while(rset.next())
	                {
	                    found=true;
	                    newSpgIdlocal=rset.getString("NEW_SPG_ID");
	               //     System.out.println("New SPG ID is :" + rset.getString("NEW_SPG_ID") );
	                    
	                }
	            }
	            if (found ==false)
	            {
	             //   System.out.println("No Information Found");
	            }
	        } catch (SQLException e) {
	            System.out.println("DB2 Database connection Failed");
	            e.printStackTrace();
	           // return;
	        }
	       // System.out.println("From DB2:" + newSpgIdlocal);
	        return newSpgIdlocal;
	    }

	}

	