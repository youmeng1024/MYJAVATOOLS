package com.fileParse.Dex;

import com.IO.Util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodIds {
    public int count;
    public List<MethodIdsItem> items = new ArrayList<MethodIdsItem>();

    public static MethodIds parseMethodIds(byte[] file,int offset,int count){
        MethodIds methodIds = new MethodIds();
        methodIds.count = count;
        for(int i=0;i<count;i++) {
            MethodIdsItem methodIdsItem = MethodIdsItem.parseMethodIdsItem(file,offset+MethodIdsItem.getSize()*i);
            methodIds.items.add(methodIdsItem);
        }
        return methodIds;
    }

    @Override
    public String toString() {
        return "MethodIds{" +
                "count=" + count +
                ", items=\n" + items +
                '}';
    }
}

class MethodIdsItem{
    public short class_idx;
    public short proto_idx;
    public int name_idx;
    public Map<Integer,String> data = new HashMap<Integer, String>();


    public static int getSize(){
        return 2 + 2+ 4;
    }

    public String getAttr(int index){
        return data.get(index);
    }

    public static MethodIdsItem parseMethodIdsItem(byte[] file, int offset){
        MethodIdsItem methodIdsItem = new MethodIdsItem();
        methodIdsItem.class_idx = Utils.byteToShort(Utils.copyBytes(file,offset,2));
        methodIdsItem.proto_idx = Utils.byteToShort(Utils.copyBytes(file,offset+2,2));
        methodIdsItem.name_idx = Utils.byteToInt(Utils.copyBytes(file,offset+4,4));
        return methodIdsItem;
    }

    @Override
    public String toString() {
        return "\nMethodIdsItem{" +
                "data=" + data +
                '}';
    }
}