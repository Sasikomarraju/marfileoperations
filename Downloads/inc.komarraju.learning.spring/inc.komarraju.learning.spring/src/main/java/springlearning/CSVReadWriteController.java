package springlearning;

public class CSVReadWriteController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String fileName = System.getProperty("C:/Users/skoma814/Desktop/Batch Merge/")
		String fileName1 = System.getProperty("user.home")
						+ "/Desktop/Batch Merge"
						//+ "/Account_Merge_Taskforce Cases_test.csv";
						+ "/AM_TF_C_D0408_C500.csv";
		String fileName2 = System.getProperty("user.home")
				+ "/Desktop/Batch Merge"
				+ "/Account_Merge_Taskforce Cases_D0408_out.txt";
		String fileName3 = System.getProperty("user.home")
				+ "/Desktop/Batch Merge"
				+ "/Account_Merge_Taskforce Cases_final_D0408.csv";

		
		CsvFileReader.readCsvFile(fileName1,fileName2);
		
		
		CsvFileFormatter.formatCsvFile(fileName2,fileName3);
	}

}
