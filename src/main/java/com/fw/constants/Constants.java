package com.fw.constants;

import java.io.File;

public final class Constants {

    private Constants() {

    }
    private static  final String RESOURCES_PATH=  System.getProperty("user.dir") + File.separator + "/src/test/resources/";

    public static final String CONFIG_PATH= RESOURCES_PATH + "com.fw.config/config.properties";




}
