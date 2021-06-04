package com.fw.utils;

import com.fw.constants.Constants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtils {

    private ExcelUtils() { }

    private static FileInputStream fileStream;
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static List<Map<String, String>> dataList;


    /* Method to read data from excel to determine which tests to run
    * */
    public static List<Map<String,String>> getTestDetails(String sheetName) {
        try {
            fileStream = new FileInputStream(Constants.getExcelPath());
            workbook = new XSSFWorkbook(fileStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read data from RunManager sheet
        sheet  = workbook.getSheet(sheetName);

        //Creating an hashmap to hold data
        Map<String, String> dataMap;
        dataList = new ArrayList<>();

        int rows = sheet.getLastRowNum(); //Get Row count
        int columns = sheet.getRow(0).getLastCellNum(); //Get column count

        for(int i=1; i<=rows; i++){
            dataMap = new HashMap<>();

            for(int j =0; j <columns; j++)
            {
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                dataMap.put(key, value);

            }

            dataList.add(dataMap);
        }



        return dataList;
    }



}

