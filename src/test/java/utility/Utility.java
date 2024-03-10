package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility {

	public static void selectOptionFromDropdown(String option, WebElement dropdownelm)
	{
		Select select=new Select(dropdownelm);
		select.selectByVisibleText(option);

	}

	public static ArrayList<String> readExcel() throws IOException
	{ 
		ArrayList <String>arraylist =new ArrayList<String>();
		File file= new File("src/test/resources/myregisistrationdetails.xlsx");
		FileInputStream fileinputstream= new FileInputStream(file);
		XSSFWorkbook xssfworkbook=new XSSFWorkbook(fileinputstream);
		XSSFSheet xssfsheet=xssfworkbook.getSheet("data");
		int lastRowNum= xssfsheet.getLastRowNum();

		for(int i=1;i<=lastRowNum;i++)
		{
			XSSFRow xssfrow=xssfsheet.getRow(i);
			int lastcellNum=xssfrow.getLastCellNum();
			for(int j=0;j<lastcellNum;j++)
			{ 
				XSSFCell cell= xssfrow.getCell(j);

				arraylist.add((cell.getStringCellValue()));


			}
		}
		xssfworkbook.close();
		return arraylist;
	}

}
