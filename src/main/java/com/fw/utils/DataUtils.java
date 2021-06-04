package com.fw.utils;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class DataUtils {

    private static List<Map<String, String>> mapList = new LinkedList<>();

    @DataProvider
    public static Object[] getData(Method method) {
        String methodName = method.getName();
        // Check if mapList is empty, only then read from excel and update
        if (mapList.isEmpty()) {
            mapList = ExcelUtils.getTestDetails("DATA");
        }

        List<Map<String, String>> runList = new ArrayList<>();

        for (Map<String, String> map : mapList) {
            if (map.get("TestName").equalsIgnoreCase(methodName) &&
                    map.get("execute").equalsIgnoreCase("Yes")) {
                runList.add(map);
            }
        }

        mapList.removeAll(runList); // Remove executed data from Map
        return runList.toArray();

    }

}
