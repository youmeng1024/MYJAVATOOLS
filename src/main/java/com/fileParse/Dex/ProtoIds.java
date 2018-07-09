package com.fileParse.Dex;

import com.IO.Util.Utils;

import java.util.*;

public class ProtoIds {
    public int count;
    public ProtoIdsItem[] idsItems;

    public ProtoIds(int count){
        this.count=count;
        idsItems = new ProtoIdsItem[count];
    }

    public static ProtoIds parseProIds(byte[] file,int offset,int count){
        ProtoIds protoIds = new ProtoIds(count);
        for(int i=0;i<protoIds.count;i++){
            protoIds.idsItems[i] = ProtoIdsItem.parseProIdsItem(file,offset+ProtoIdsItem.getSize()*i);
        }
        return protoIds;
    }

    @Override
    public String toString() {
        return "ProtoIds:\n---------\n" +
                "idsItems=" + Arrays.toString(idsItems) +
                "\n----------";
    }

    public ProtoIdsItem getProtoIds(int dex){
        return idsItems[dex];
    }

}

class ProtoIdsItem{
    public int shorty_idx;//method的原型
    public int return_type_idx; //method 的返回值类型
    public int parameters_off; //参数列表
    public TypeList parameList = new TypeList();

    public Map<String,String> map=new HashMap<String, String>();

    public static int getSize(){
        return 4+4+4;
    }

    public static ProtoIdsItem parseProIdsItem(byte[] file,int offset){
        ProtoIdsItem protoIdsItem = new ProtoIdsItem();
        protoIdsItem.shorty_idx = Utils.byteToInt(Utils.copyBytes(file,offset,4));
        protoIdsItem.return_type_idx = Utils.byteToInt(Utils.copyBytes(file,offset+4,4));
        protoIdsItem.parameters_off = Utils.byteToInt(Utils.copyBytes(file,offset+8,4));
        if(protoIdsItem.parameters_off!=0)
            protoIdsItem.parameList = TypeList.parseTypeList(file,protoIdsItem.parameters_off);

        return protoIdsItem;
    }

    @Override
    public String toString() {
        return "ProtoIdsItem:"+map.toString()+", paramList:"+ parameList.toString()+"\n";
    }
}


class TypeList{
    public int size;
    public List<Short> type_idex = new ArrayList<Short>();
    public List<String> data = new ArrayList<String>();

    public static TypeList parseTypeList(byte[] file, int offset){
        TypeList typeList = new TypeList();
        typeList.size = Utils.byteToInt(Utils.copyBytes(file,offset,4));
        for(int i=0;i<typeList.size;i++){
            short index =  Utils.byteToShort(Utils.copyBytes(file, offset+4+i*2, 2));
            typeList.type_idex.add(index);
        }

        return typeList;
    }

    @Override
    public String toString() {
        return "TypeList{" +
                "data=" + data +
                '}';
    }
}