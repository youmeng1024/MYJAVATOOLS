package com.fileParse.Dex;

import com.IO.Util.Utils;

import java.util.ArrayList;
import java.util.List;

public class MapList {
    public int size;
    public List<MapItem> map_item = new ArrayList<MapItem>();

    public static MapList parseMapList(byte[] file,int offset){
        MapList mapList = new MapList();
        mapList.size = Utils.byteToInt(Utils.copyBytes(file,offset,4));
        for(int i=0;i<mapList.size;i++) {
            mapList.map_item.add(MapItem.parseMap_item(file,offset+4+i*MapItem.getSize()));
        }
        return mapList;
    }

    @Override
    public String toString() {
        return "MapList{" +
                "size=" + size +
                ", map_item=" + map_item +
                '}';
    }
}

class MapItem{
    public short type;
    public short unuse;
    public int size;
    public int offset;

    public static int getSize(){
        return 2+2+4+4;
    }

    public static MapItem parseMap_item(byte[] file,int offset){
        MapItem mapItem = new MapItem();
        mapItem.type = Utils.byteToShort(Utils.copyBytes(file,offset,2));
        mapItem.unuse = Utils.byteToShort(Utils.copyBytes(file,offset+2,2));
        mapItem.size = Utils.byteToInt(Utils.copyBytes(file,offset+4,4));
        mapItem.offset = Utils.byteToInt(Utils.copyBytes(file,offset+8,4));
        return mapItem;
    }

    @Override
    public String toString() {
        return "MapItem{" +
                "type=" + type +
                ", unuse=" + unuse +
                ", size=" + size +
                ", offset=" + offset +
                '}'+"\n";
    }
}