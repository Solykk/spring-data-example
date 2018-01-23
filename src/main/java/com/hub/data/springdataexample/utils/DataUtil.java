package com.hub.data.springdataexample.utils;

import java.util.Arrays;

/**
 * @author Dmitriy Lyashenko
 */
public class DataUtil {

    public static String getDescription(Object anyClass){
        Class<?> aClass = anyClass.getClass();
        return ("\t\t\t\t\tgetName() -> " + aClass.getName() + "\n") +
                "\t\t\t\t\t\t" + "getCanonicalName() -> " + aClass.getCanonicalName() + "\n" +
                "\t\t\t\t\t\t\t" + "getSimpleName() -> " + aClass.getSimpleName() + "\n" +
                "\t\t\t\t\t\t\t\t" + "getTypeName() -> " + aClass.getTypeName() + "\n" +
                "\t\t\t\t\t\t\t\t\t" + "getAnnotations() -> " + Arrays.toString(aClass.getAnnotations()) + "\n" +
                "\t\t\t\t\t\t\t\t\t\t" + "getAnnotatedSuperclass() -> " + aClass.getAnnotatedSuperclass().getType().getTypeName() + "\n";
    }
}
