package com.fw.constants;

import java.io.File;

public final class Constants {

    private Constants() { }

    private static  final String RESOURCES_PATH=  System.getProperty("user.dir") + File.separator + "/src/test/resources/";

    private static final int EXPLICIT_WAIT = 60;

    private static final int PAGELOAD_WAIT = 1;
    private static final int IMPLICIT_WAIT= 15;

    public static final String CONFIG_PATH= RESOURCES_PATH + "com.fw.config/config.properties";

    private static final String EXCEL_PATH = RESOURCES_PATH + "testData/DataSheet.xlsx";



    public static int getExplicitWait() {
        return EXPLICIT_WAIT;
    }

    public static String getExcelPath() {
        return EXCEL_PATH;
    }

    public static int getPageloadWait() {
        return PAGELOAD_WAIT;
    }

    public static int getImplicitWait() {
        return IMPLICIT_WAIT;
    }






}
