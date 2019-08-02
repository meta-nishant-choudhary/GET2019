package Ques3.com.metacube;

import jxl.write.WriteException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class CounselingProcessTest { 

	@Test
	public void test() throws WriteException {

		CounselingProcess counselling = new CounselingProcess();
		String path = "output.xls";
		String studentPrefernce = "students.xls";
		String programCapacity = "programList.xls";
		
		counselling.studentCounceling(programCapacity, studentPrefernce, path);
		
		Map<String, String> result = buildAllotmentList("./Allotment.xls");
		Map<String, String> expected = new HashMap<String, String>();
		expected.put("Anurag", "CIVIL");
		expected.put("Amit", "ECE");
		expected.put("Vijay", "CS");
		expected.put("Akshat", "CS");
		expected.put("Pankaj", "ID");

		assertEquals(expected, result);

	}

	private Map<String, String> buildAllotmentList(String path) {
		Map<String, String> allotmentData = new HashMap<String, String>();
		File file = new File(path);
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);
			for (int i = 1; i < sheet.getRows(); i++) {
				Cell cell = sheet.getCell(0, i);
				CellType type = cell.getType();
				if (type == CellType.LABEL) {
					String studentName = cell.getContents();
					cell = sheet.getCell(1, i);
					String branch = cell.getContents();
					allotmentData.put(studentName, branch);
				}
			}
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		return allotmentData;
	}
}