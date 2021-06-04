package com.fw.listeners;

import com.fw.utils.DataUtils;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        annotation.setDataProvider("getData");
        annotation.setDataProviderClass(DataUtils.class);
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }

}
