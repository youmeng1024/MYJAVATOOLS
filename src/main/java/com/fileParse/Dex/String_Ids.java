package com.fileParse.Dex;

import com.IO.Util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class String_Ids {
    public int count;
    public StringIdsItem[] items;
    public String[] data;

    public String_Ids(int count){
        this.count =count;
        items = new StringIdsItem[count];
        data = new String[count];
    }

    public static String_Ids parseStringIsd(byte[] file,int offset,int count){
        String_Ids string_ids = new String_Ids(count);
        for(int i=0;i<count;i++){
            string_ids.items[i] = new StringIdsItem();
            string_ids.items[i].string_data_off = Utils.byteToInt(Utils.copyBytes(file,offset+i*StringIdsItem.getSize(),StringIdsItem.getSize()));
            string_ids.data[i] = string_ids.items[i].getString(file);
        }



        return string_ids;
    }

    @Override
    public String toString() {
        return "String_Ids{" +
                "count=" + count +
                ", items=" + Arrays.toString(items) +
                ", data=\n" + Arrays.toString(data).replaceAll(",","\nstr:") +
                '}';
    }

    public String getString(int index){
        return data[index];
    }

}

class StringIdsItem{
    public int string_data_off;

    public static int getSize(){
        return 4;
    }

    @Override
    public String toString() {
        return Utils.byteToHexStringReserVer(Utils.intToByte(string_data_off));
    }

    public  String getString(byte[] file){
        byte[] leng = Utils.copyBytes(file,string_data_off,1);
        byte[] d = Utils.copyBytes(file,string_data_off+1,leng[0]);
        return  new String(d);
    }
}

class StringDataItem{
    public List<Byte> utf16_size = new ArrayList<Byte>();
    public byte[] data;
    public String str;

    public static String getString(byte[] file , int  offset){
        byte[] leng = Utils.copyBytes(file,offset,1);
        System.out.println("leng:"+leng[0]);
        byte[] d = Utils.copyBytes(file,offset+1,leng[0]);
        return  new String(d);
    }
}