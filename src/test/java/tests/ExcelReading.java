package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class ExcelReading extends BaseTest {
	
	   // DataProvider to fetch data from the Excel file
    @DataProvider(name = "excelData")
    public Object[][] getExcelData() throws IOException {
        // Provide the path to your Excel file
        String filePath = "C:\\Users\\User\\Downloads\\data.xlsx";
        FileInputStream file = new FileInputStream(new File(filePath));

        // Create a Workbook instance to read the Excel file
        Workbook workbook = new XSSFWorkbook(file);
        
        // Get the first sheet from the workbook
        Sheet sheet = workbook.getSheetAt(0);
        
        // Get the total number of rows and columns
        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

        // Create a 2D array to store the Excel data
        Object[][] data = new Object[rows - 1][cols];
        
        // Loop through rows and columns to fetch data
        for (int i = 1; i < rows; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < cols; j++) {
                Cell cell = row.getCell(j);
                switch (cell.getCellType()) {
                    case STRING:
                        data[i - 1][j] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        data[i - 1][j] = cell.getNumericCellValue();
                        break;
                    case BOOLEAN:
                        data[i - 1][j] = cell.getBooleanCellValue();
                        break;
                    default:
                        data[i - 1][j] = "Unknown";
                }
            }
        }

        // Close the workbook and the file input stream
        workbook.close();
        file.close();

        return data;
    }

    // Test case that uses data from the DataProvider
    @Test(dataProvider = "excelData")
    public void testExcelData(String name, double age, String city) {
        // Print the data fetched from the Excel file
        System.out.println("Name: " + name + ", Age: " + age + ", City: " + city);
        
        // You can add assertions or further processing here
        lp.loginApplication(name, city);
       
    }
}
