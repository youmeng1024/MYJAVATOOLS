package com.IO.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    /***
     * 复制文件流的某段字
     *
     * @param res 文件流
     * @param start 开始下标
     * @param count 长度
     * @return
     */
    public static  byte[] copyBytes(byte[] res,int start ,int count){
        if(res == null)
            return null;
        byte[] save = new byte[count];
        for (int tmp=0;tmp<count;tmp++)
            save[tmp] = res[start+tmp];
        return save;
    }


    /***
     * 传入对齐的地址还有对齐的大小，以此返回下次读取内存的地址。假如对齐地址刚好是对齐大小倍数，那就下次直接从传入地址开始即可，否则就是从下个对齐大小的倍数地址开始。这就是算法核心
     * @param addr 需要进行对齐的地址
     * @param align 对齐的字节数大小
     * @return 下个读取地址，即对齐完毕的地址。
     */
    public static int align(int addr, int align){
        if(align>addr)//一般针对内存刚开始那会儿
            return addr;

        int offset = addr % align;
        return addr + (align - offset);
    }


    /**
     * 正序输出
     * 输出Hex。。注意观察输出是正序还是反序..
     * @param bytes 要转换的字节流
     * @return String的最大长度好象是65535？？可以采取分段byte来调用该函数
     */
    public static String byteToHexString(byte[] bytes){
        StringBuffer result = new StringBuffer();
        for(int tmp=0;tmp<bytes.length;tmp++){
            String hex = Integer.toHexString(bytes[tmp]);
            if(hex.length()<2)
                result.append("0"+hex);
            else
                result.append(hex);
            result.append(" ");
        }
        return result.toString();
    }

    /**
     * 反序输出
     * 输出Hex。。注意观察输出是正序还是反序..
     * @param bytes 要转换的字节流
     * @return String的最大长度好象是65535？？可以采取分段byte来调用该函数
     */
    public static String byteToHexStringReserVer(byte[] bytes){
        StringBuffer result = new StringBuffer();
        for(int tmp=bytes.length-1;tmp>=0;tmp--){
            String hex = Integer.toHexString(bytes[tmp]);
            if(hex.length()<2)
                result.append("0"+hex);
            else
                result.append(hex);
            result.append(" ");
        }
        return result.toString();
    }

    /**
     * 保存文件，包含新建
     * @param fileName 文件路径以及名字
     * @param bytes 写入字节流
     * @return
     */
    public static boolean saveFile(String fileName,byte[] bytes){
        File file = new File(fileName);
        FileOutputStream fos =null;

        try {
            fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.flush();
            return true;
        } catch (IOException e) {
            System.out.println("save file have some error:"+e.toString());
        } finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    System.out.println("Close error"+e.toString());
                }
            }
        }

        return false;
    }

    /**
     * 读取文件的字节流
     * @param filename 文件路径
     * @return
     */
    public static byte[] readFile(String filename){
        File file = new File(filename);
        FileInputStream fis = null;
        ByteArrayOutputStream bos = null;

        try {
            fis = new FileInputStream(file);
            bos = new ByteArrayOutputStream();
            byte[] tmp = new byte[1024];
            int size=0;
            while((size = fis.read(tmp))!=-1){
                bos.write(tmp,0,size);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            System.out.println("file read error"+e.toString());
        } finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println("Close  file error"+e.toString());
                }
            }

            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    System.out.println("Close error"+e.toString());
                }
            }
        }
        return null;
    }


    /**
     * byte转int。。待研究
     * @param res
     * @return
     */
    public static  int byteToInt(byte[] res){
        int targets = (res[0] & 0xff)
                | ((res[1] << 8) & 0xff00)
                | ((res[2] << 24) >>> 8)
                | (res[3] << 24);
        return targets;
    }

    /**
     * byte转long。。。待研究
     * @param b
     * @return
     */
    public static long byteToLong(byte[] b){
        long s = 0;
        long s0 = b[0] & 0xff;// 最低位
        long s1 = b[1] & 0xff;
        long s2 = b[2] & 0xff;
        long s3 = b[3] & 0xff;
        long s4 = b[4] & 0xff;// 最低位
        long s5 = b[5] & 0xff;
        long s6 = b[6] & 0xff;
        long s7 = b[7] & 0xff;
        // s0不变
        s1 <<= 8;
        s2 <<= 16;
        s3 <<= 24;
        s4 <<= 8 * 4;
        s5 <<= 8 * 5;
        s6 <<= 8 * 6;
        s7 <<= 8 * 7;
        s = s0 | s1 | s2 | s3 | s4 | s5 | s6 | s7;
        return s;
    }



    /**
     * 注释：字节数组到short的转换。。待研究
     *
     * @param b
     * @return
     */
    public static short byteToShort(byte[] b) {
        short s = 0;
        short s0 = (short) (b[0] & 0xff);// 最低位
        short s1 = (short) (b[1] & 0xff);
        s1 <<= 8;
        s = (short) (s0 | s1);
        return s;
    }

    /**
     * long转化成byte..待研究
     * @param number
     * @return
     */
    public static byte[] longToByteAry(long number) {
        long temp = number;
        byte[] b = new byte[8];
        for (int i = 0; i < b.length; i++) {
            b[i] = new Long(temp & 0xff).byteValue();// 将最低位保存在最低位
            temp = temp >> 8; // 向右移8位
        }
        return b;
    }

    /**
     * int转化成byte..待研究
     * @param number
     * @return
     */
    public static byte[] intToByte(int number) {
        int temp = number;
        byte[] b = new byte[4];
        for (int i = 0; i < b.length; i++) {
            b[i] = new Integer(temp & 0xff).byteValue();// 将最低位保存在最低位
            temp = temp >> 8; // 向右移8位
        }
        return b;
    }

    /**
     * short转化成byte..待研究
     * @param number
     * @return
     */
    public static byte[] shortToByte(short number) {
        int temp = number;
        byte[] b = new byte[2];
        for (int i = 0; i < b.length; i++) {
            b[i] = new Integer(temp & 0xff).byteValue();//将最低位保存在最低位
            temp = temp >> 8; // 向右移8位
        }
        return b;
    }

    /**
     * 替换rep_index位置的byte[]..待研究
     * @param src
     * @param rep_index
     * @param copyByte
     * @return
     */
    public static byte[] replaceByteAry(byte[] src, int rep_index, byte[] copyByte){
        for(int i=rep_index;i<rep_index+copyByte.length;i++){
            src[i] = copyByte[i-rep_index];
        }
        return src;
    }

    /**
     * 高地位互换...待研究
     */
    public static byte[] reverseBytes(byte[] bytes){
        if(bytes == null || (bytes.length % 2) != 0){
            return bytes;
        }
        int i = 0;
        int offset = bytes.length/2;
        while(i < (bytes.length/2)){
            byte tmp = bytes[i];
            bytes[i] = bytes[offset+i];
            bytes[offset+i] = tmp;
            i++;
        }
        return bytes;
    }

    /**
     * 取出字符串中的空字符串‘00’
     * @param str
     * @return
     */
    public static String filterStringNull(String str){
        if(str == null || str.length() == 0)
            return str;
        byte[] strbyte = str.getBytes();
        ArrayList<Byte> newByte = new ArrayList<Byte>();
        for(int i=0;i<strbyte.length;i++){
            if(strbyte[i] != 0)
                newByte.add(strbyte[i]);
        }
        byte[] newByteAry = new byte[newByte.size()];
        for (int i=0;i<newByteAry.length;i++)
            newByteAry[i] = newByte.get(i);
        return new String(newByteAry);
    }



}
