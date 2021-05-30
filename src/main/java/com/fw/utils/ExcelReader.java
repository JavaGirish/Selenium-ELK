package com.fw.utils;

import com.fw.constants.Constants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {

    private static FileInputStream fileStream;
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;

    @DataProvider
    private static Object[] readData() {
        try {
            fileStream = new FileInputStream(Constants.getExcelPath());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            workbook = new XSSFWorkbook(fileStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet  = workbook.getSheet("Sheet1");

        int rows = sheet.getLastRowNum(); //Get Row count
        int columns = sheet.getRow(0).getLastCellNum(); //Get column count

        Object ob[] = new Object[rows];
        Map<String,String> map;

        for(int i=1; i<= rows; i++){
            map = new HashMap<>();

            for(int j = 0; j<columns; j++){
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();

                map.put(key,value);
                ob[i-1] = map;
            }

        }

        return ob;


    }





    

}
