package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelOperations {
	public static List<String> readInputData(String user) throws Exception{
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\inputData\\InputFile.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(fs);
		HSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int k=-1;
		for (int i=0;i<=rowCount;i++) {
			if(sheet.getRow(i).getCell(0).toString().trim().equalsIgnoreCase(user)) {
				k=i;
				break;
			}
		}
		if(k==-1) {
			workbook.close();
			throw new Exception("Invalid user passed");
		}
		int colCount = sheet.getRow(0).getLastCellNum();
		List<String> list = new ArrayList<String>();
		for(int j=1;j<colCount;j++) {
			list.add(sheet.getRow(k).getCell(j).toString());
		}
		workbook.close();
		fs.close();
		return list;
	}
}
