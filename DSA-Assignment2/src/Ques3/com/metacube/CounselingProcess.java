package Ques3.com.metacube;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Label;

public class CounselingProcess {
	
	public static Queue<String> queue = new LinkedList<String>();
	
	public static Map<String, Integer> programCapacity = new HashMap<String, Integer>();
	
	public static Map<String, ArrayList<String>> studentWithPref = new HashMap<String, ArrayList<String>>();
	
	/**
	 * to read the branch and its capacity
	 * @param programDetails type: string (filename or path)
	 */
	public static void readCapacity(String programDetails) {
		File file = new File(programDetails);
		Workbook workbook;
		
		try {
			workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);
			
			for(int i = 0; i < sheet.getRows(); i++) {
				Cell cell = sheet.getCell(0, i);
				
				CellType cellType = cell.getType();
				if(cellType == CellType.LABEL) {
					String programName = cell.getContents();
					cell = sheet.getCell(1, i);	
					Integer capacity = Integer.parseInt(cell.getContents());
					programCapacity.put(programName, capacity);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * to read the student and it's preferences
	 * @param studentDetails type: String (filename or path)
	 */
	public static void readPreference(String studentDetails) {
		File file = new File(studentDetails);
		Workbook workbook;
		
		try {
			workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);
			
			for(int i=0;i<sheet.getRows();i++) {
				Cell cell = sheet.getCell(0, i);
				CellType cellType = cell.getType();
				
				if(cellType == cellType.LABEL) {
					String studentName = cell.getContents();
					queue.add(studentName);
					cell = sheet.getCell(1, i);
					String preference = cell.getContents();
					StringTokenizer tokens = new StringTokenizer(preference,",");
					ArrayList<String> pref = new ArrayList<String>();
					while(tokens.hasMoreTokens()) {
						pref.add(tokens.nextToken());
					}
					studentWithPref.put(studentName, pref);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * to create a sheet where the allotment of branches to students are done
	 * @param programDetails type: String (filename or path)
	 * @param studentDetails type: String (filename or path)
	 * @param path type: String (filename or path) = where file is write
	 */
	public static void studentCounceling(String programDetails, String studentDetails, String path	) {
		readCapacity(programDetails);
		readPreference(studentDetails);
		
		File file = new File(path);
		WritableWorkbook workbook;
		
		try{
			workbook = Workbook.createWorkbook(file);
			WritableSheet sheet = workbook.createSheet("output", 0 );
			int count = 1;
			sheet.addCell(new Label(0, 0, "Student Name"));
			sheet.addCell(new Label(1, 0, "College Alloted"));
			
			while(!queue.isEmpty()){
				String studentName = queue.remove();
				ArrayList<String> pref = new ArrayList<String>();
				pref = studentWithPref.get(studentName);
				
				boolean assign = false;
				
				for(String subject : pref) {
					
					if(assign){
						break;
					}
					
					Integer capacity = programCapacity.get(subject);
					
					if(capacity > 0){
						Label stName = new Label(0, count, studentName);
						sheet.addCell(stName);
						Label stBranch = new Label(1, count, subject);
						sheet.addCell(stBranch);
						assign = true;
						count++;
						capacity--;
						programCapacity.put(subject, capacity);
						
					}
				}
				
			}
			workbook.write();
			workbook.close();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
