package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

public class ExcelUtilities {

	static FileInputStream f;// DATA BITE READ

	static XSSFWorkbook wb;

	static XSSFSheet th;

	public static String getStringData(int row, int col, String sheet) throws IOException {
		// f = new
		// FileInputStream("C:\\Users\\ANISH\\eclipse-workspace\\GroceryApplicationProject\\src\\test\\resources\\TestData.xlsx");
		f = new FileInputStream(Constant.EXCELDATA);
		wb = new XSSFWorkbook(f);
		th = wb.getSheet(sheet);

		XSSFRow r = th.getRow(row);

		XSSFCell c = r.getCell(col);

		return c.getStringCellValue();

	}

	public static String getIntegerData(int row, int col, String sheet) throws IOException {
		// f = new
		// FileInputStream("C:\\Users\\ANISH\\eclipse-workspace\\GroceryApplicationProject\\src\\test\\resources\\TestData.xlsx");
		f = new FileInputStream(Constant.EXCELDATA);
		wb = new XSSFWorkbook(f);
		th = wb.getSheet(sheet);
		XSSFRow r = th.getRow(row);
		XSSFCell c = r.getCell(col);
		int val = (int) c.getNumericCellValue();// DEFAULT VALUE IS DOUBLE.TO CONVERT INT IS USED.
		return String.valueOf(val);

	}
}
