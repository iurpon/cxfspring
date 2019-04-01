package ru.trandefil.spring;

import java.util.UUID;

public class UUIDUtil {
    public static String getUniqueString(){
        return UUID.randomUUID().toString();
    }
}
