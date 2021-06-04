package com.fw.listeners;

import com.fw.constants.Constants;
import com.fw.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestMethodInterceptor implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

        List<Map<String, String>> excelRunList = ExcelUtils.getTestDetails(Constants.getRunSheet());
        List<IMethodInstance> methodsRunList = new ArrayList<>();

        for (IMethodInstance instance : methods) {

            for (Map<String, String> map : excelRunList) {
                if (instance.getMethod().getMethodName().equalsIgnoreCase(map.get("TestName")) &&
                        map.get("execute").equalsIgnoreCase("Yes")) {
                    instance.getMethod().setInvocationCount(Integer.parseInt(map.get("count")));
                    instance.getMethod().setPriority(Integer.parseInt(map.get("priority")));
                    methodsRunList.add(instance);

                }

            }

        }

        return methodsRunList;
    }

}
