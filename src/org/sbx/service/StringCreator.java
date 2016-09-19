package org.sbx.service;

import java.util.Random;

/**
 * Created by aloginov on 13.09.16.
 */
public class StringCreator {

    private String string;
    private byte[] bytes;
    private Random random;

    public StringCreator(){
        string = new String("");
    }

    public StringCreator(int num){

        bytes = new byte[num];
        random = new Random();

        for (int i = 0; i < bytes.length; i++){
            bytes[i] = (byte) (32 + random.nextInt(95));
        }

        string = new String(bytes);
    }

    public String getString(){
        return string;
    }
}
