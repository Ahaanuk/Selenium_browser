package datadriventests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExecl {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream("S:\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		// XSSFSheet sheet =workbook.getSheetAt(0);

		int noOfrow = sheet.getLastRowNum();// Return row number
		System.out.println(noOfrow);
		int noOfcol = sheet.getRow(0).getLastCellNum();// Return col number
		System.out.println(noOfcol);
		for (int row = 0; row < noOfrow; row++) {

			XSSFRow currentrow = sheet.getRow(row);
			for (int col = 0; col < noOfcol; col++) {
				String value = currentrow.getCell(col).toString();// read value for
																	// cell//getStringCellValue()/getNumericCellValue()//getBooleanCellValue()
				System.out.print("    " + value);

			}
			System.out.println();
		}

	}

}
