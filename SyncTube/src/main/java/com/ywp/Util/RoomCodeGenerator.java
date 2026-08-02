package com.ywp.Util;



import java.util.UUID;

public class RoomCodeGenerator {

    public static String generate(){

        return UUID.randomUUID()
                .toString()
                .substring(0,6)
                .toUpperCase();

    }

}
