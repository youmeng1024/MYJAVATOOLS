package com.fileParse.Dex;

import com.IO.Util.Utils;

public class DexHeader {
    public byte[] magic = new byte[8];
    public int checksum;
    public byte[] signature = new byte[20];
    public int fileSize;
    public int headerSize;
    public int endianTag;
    public int linkSize;
    public int linkOff;
    public int mapOff;
    public int stringIdsSize;
    public int stringIdsOff;
    public int typeIdsSize;
    public int typeIdsOff;
    public int protoIdsSize;
    public int protoIdsOff;
    public int fieldIdsSize;
    public int fieldIdsOff;
    public int methodIdsSize;
    public int methodIdsOff;
    public int classDefsSize;
    public int classDefsOff;
    public int datasize;
    public int dataOff;

    public static DexHeader parseDexHeader(byte[] file) {
        DexHeader dexHeader = new DexHeader();
        dexHeader.magic = Utils.copyBytes(file, 0, 8);
        dexHeader.checksum = Utils.byteToInt(Utils.copyBytes(file, 8, 4));
        dexHeader.signature = Utils.copyBytes(file, 12, 20);
        dexHeader.fileSize = Utils.byteToInt(Utils.copyBytes(file, 32, 4));
        dexHeader.headerSize = Utils.byteToInt(Utils.copyBytes(file, 36, 4));
        dexHeader.endianTag = Utils.byteToInt(Utils.copyBytes(file, 40, 4));
        dexHeader.linkSize = Utils.byteToInt(Utils.copyBytes(file, 44, 4));
        dexHeader.linkOff = Utils.byteToInt(Utils.copyBytes(file, 48, 4));
        dexHeader.mapOff = Utils.byteToInt(Utils.copyBytes(file, 52, 4));
        dexHeader.stringIdsSize = Utils.byteToInt(Utils.copyBytes(file, 56, 4));
        dexHeader.stringIdsOff = Utils.byteToInt(Utils.copyBytes(file, 60, 4));
        dexHeader.typeIdsSize = Utils.byteToInt(Utils.copyBytes(file, 64, 4));
        dexHeader.typeIdsOff = Utils.byteToInt(Utils.copyBytes(file, 68, 4));
        dexHeader.protoIdsSize = Utils.byteToInt(Utils.copyBytes(file, 72, 4));
        dexHeader.protoIdsOff = Utils.byteToInt(Utils.copyBytes(file, 76, 4));
        dexHeader.fieldIdsSize = Utils.byteToInt(Utils.copyBytes(file, 80, 4));
        dexHeader.fieldIdsOff = Utils.byteToInt(Utils.copyBytes(file, 84, 4));
        dexHeader.methodIdsSize = Utils.byteToInt(Utils.copyBytes(file, 88, 4));
        dexHeader.methodIdsOff = Utils.byteToInt(Utils.copyBytes(file, 92, 4));
        dexHeader.classDefsSize = Utils.byteToInt(Utils.copyBytes(file, 96, 4));
        dexHeader.classDefsOff = Utils.byteToInt(Utils.copyBytes(file, 100, 4));
        dexHeader.datasize = Utils.byteToInt(Utils.copyBytes(file, 104, 4));
        dexHeader.dataOff = Utils.byteToInt(Utils.copyBytes(file, 108, 4));

        return dexHeader;
    }

    @Override
    public String toString() {
        return "DexHeader{" +
                "magic=" + Utils.byteToHexString(magic) +
                "\n, checksum=" + checksum +
                "\n, signature=" + Utils.byteToHexString(signature) +
                "\n, fileSize=" + fileSize +
                ", headerSize=" + headerSize +
                ", endianTag=" + endianTag +
                ", linkSize=" + linkSize +
                ", linkOff=" + linkOff +
                ", mapOff=" + mapOff +
                ", stringIdsSize=" + stringIdsSize +
                ", stringIdsOff=" + stringIdsOff +
                ", typeIdsSize=" + typeIdsSize +
                ", typeIdsOff=" + typeIdsOff +
                ", protoIdsSize=" + protoIdsSize +
                ", protoIdsOff=" + protoIdsOff +
                ", fieldIdsSize=" + fieldIdsSize +
                ", fieldIdsOff=" + fieldIdsOff +
                ", methodIdsSize=" + methodIdsSize +
                ", methodIdsOff=" + methodIdsOff +
                ", classDefsSize=" + classDefsSize +
                ", classDefsOff=" + classDefsOff +
                ", datasize=" + datasize +
                ", dataOff=" + dataOff +
                '}';
    }
}
