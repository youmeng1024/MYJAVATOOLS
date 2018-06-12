package com.IO.Util;

public class Utils {


    public static  byte[] copyBytes(byte[] res,int start ,int count){
        if(res == null)
            return null;
        byte[] save = new byte[count];
        for (int tmp=0;tmp<count;tmp++)
            save[tmp] = res[start+tmp];
        return save;
    }

//    public static void main(String[] args){
//
//        byte[] by = "123456".getBytes();
//        System.out.println(new String(copyBytes(by,3,2)));
//
//
//    }
}
