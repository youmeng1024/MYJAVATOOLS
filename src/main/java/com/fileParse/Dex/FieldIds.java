package com.fileParse.Dex;

import com.IO.Util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FieldIds {
    public int count;
    public List<FieldIdsItem> items = new ArrayList<FieldIdsItem>();

    public static FieldIds parseFieldIds(byte[] file,int offset,int count){
        FieldIds fieldIds = new FieldIds();
        fieldIds.count=count;
        for(int i=0;i<count;i++) {
            FieldIdsItem fieldIdsItem = FieldIdsItem.parseFieldIdsItem(file,offset+FieldIdsItem.getSize()*i);
            fieldIds.items.add(fieldIdsItem);
        }
        return fieldIds;
    }

    @Override
    public String toString() {
        return "FieldIds{" +
                "count=" + count +
                ", items=" + items +
                '}';
    }
}

class FieldIdsItem{
    public short class_idx;
    public short type_idx;
    public int name_idx;
    public Map<Integer,String> data = new HashMap<Integer, String>();

    public static int getSize(){
        return 2+2+4;
    }

    public String getAttr(int index){
        return data.get(index);
    }

    public static FieldIdsItem parseFieldIdsItem(byte[] file, int offset){
        FieldIdsItem fieldIdsItem = new FieldIdsItem();
        fieldIdsItem.class_idx = Utils.byteToShort(Utils.copyBytes(file,offset,2));
        fieldIdsItem.type_idx = Utils.byteToShort(Utils.copyBytes(file,offset+2,2));
        fieldIdsItem.name_idx = Utils.byteToInt(Utils.copyBytes(file,offset+4,4));
        return fieldIdsItem;
    }

    @Override
    public String toString() {
        return "FieldIdsItem{" +
                "data=" + data +
                '}';
    }
}