package com.fileParse.Dex;

import com.IO.Util.Utils;

import java.util.Arrays;

public class TypeIdsItem {
    public int count;
    public int[] offsetArray;
    public String[] data;

    public static int getSize(){
        return 4;
    }

    public TypeIdsItem(int count){
        this.count = count;
        offsetArray= new int[count];
        data = new String[count];
    }

    public static TypeIdsItem parseTypeIds(byte[] file,int offset,int count){
        TypeIdsItem typeIdsItem = new TypeIdsItem(count);
        for(int i=0;i<typeIdsItem.count;i++){
            typeIdsItem.offsetArray[i] = Utils.byteToInt(Utils.copyBytes(file,offset+4*i,4));
        }

        return typeIdsItem;
    }

    @Override
    public String toString() {
        return "TypeIdsItem{" +
                "count=" + count +
                ", offsetArray=" + Arrays.toString(offsetArray) +
                ", data=\n" + Arrays.toString(data).replaceAll(",","\n") +
                '}';
    }

    public String getType(int index){
        return data[index];
    }
}
