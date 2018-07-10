package com.fileParse.Dex;

import com.IO.Util.Utils;

import java.util.Arrays;

public class DexStruct {
    public String filePath;
    public byte[] fileByteArray;
    public DexHeader dexHeader;
    public MapList mapList;
    public String_Ids string_ids;
    public TypeIdsItem typeIdsItem;
    public ProtoIds protoIds;
    public FieldIds fieldIds;
    public MethodIds methodIds;

    public DexStruct(String path){
        this.filePath = path;
        this.fileByteArray = Utils.readFile(this.filePath);
        dexHeader = DexHeader.parseDexHeader(fileByteArray);
        mapList = MapList.parseMapList(fileByteArray,dexHeader.mapOff);
        string_ids = String_Ids.parseStringIsd(fileByteArray,dexHeader.stringIdsOff,dexHeader.stringIdsSize);
        typeIdsItem = TypeIdsItem.parseTypeIds(fileByteArray,dexHeader.typeIdsOff,dexHeader.typeIdsSize);
        for(int i=0;i<typeIdsItem.count;i++)
            typeIdsItem.data[i] = string_ids.getString(typeIdsItem.offsetArray[i]);
        protoIds = ProtoIds.parseProIds(fileByteArray,dexHeader.protoIdsOff,dexHeader.protoIdsSize);
        for(int i=0;i<protoIds.count;i++) {
            protoIds.idsItems[i].map.put("shorty", string_ids.getString(protoIds.idsItems[i].shorty_idx));
            protoIds.idsItems[i].map.put("returnType", typeIdsItem.getType(protoIds.idsItems[i].return_type_idx));
            for (int j = 0; j < protoIds.idsItems[i].parameList.size; j++) {
                protoIds.idsItems[i].parameList.data.add(typeIdsItem.getType(protoIds.idsItems[i].parameList.type_idex.get(j)));
            }
        }
        fieldIds = FieldIds.parseFieldIds(fileByteArray,dexHeader.fieldIdsOff,dexHeader.fieldIdsSize);
        for(int i=0;i<fieldIds.count;i++){
            fieldIds.items.get(i).data.put((int) fieldIds.items.get(i).class_idx,typeIdsItem.getType(fieldIds.items.get(i).class_idx));
            fieldIds.items.get(i).data.put((int) fieldIds.items.get(i).type_idx,typeIdsItem.getType(fieldIds.items.get(i).type_idx));
            fieldIds.items.get(i).data.put(fieldIds.items.get(i).name_idx,typeIdsItem.getType(fieldIds.items.get(i).name_idx));
        }
        methodIds = MethodIds.parseMethodIds(fileByteArray,dexHeader.methodIdsOff,dexHeader.methodIdsSize);
        for(int i=0;i<methodIds.count;i++){
            methodIds.items.get(i).data.put((int) methodIds.items.get(i).class_idx,typeIdsItem.getType(methodIds.items.get(i).class_idx));
            methodIds.items.get(i).data.put((int) methodIds.items.get(i).proto_idx,protoIds.getProtoIds(methodIds.items.get(i).proto_idx).toString());
            methodIds.items.get(i).data.put(methodIds.items.get(i).name_idx,string_ids.getString(methodIds.items.get(i).name_idx));
        }
    }

    @Override
    public String toString() {
        return "DexStruct{" +
                "\n*******************************\n" +
                ", dexHeader=" + dexHeader +
                "\n                        *******************************\n" +
                ", mapList=" + mapList +
                "\n*******************************\n" +
                ", string_ids=" + string_ids +
                "\n*******************************\n" +
                ", typeIdsItem=" + typeIdsItem +
                "\n*******************************\n" +
                ", protoIds=" + protoIds +
                "\n*******************************\n" +
                ", fieldIds=" + fieldIds +
                "\n*******************************\n" +
                ", methodIds=" + methodIds +
                "\n*******************************\n" +
                '}';
    }


}
