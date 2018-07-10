package com.fileParse.SO;

import com.IO.Util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElfParse {
    public String filePath;
    public short kind;//32elf或者64elf(2为64 3为32)
    public byte[] fileByteArray;
    public Object elfHeader;
    public List<Object> phList = new ArrayList<Object>();
    public List<Object> shList = new ArrayList<Object>();

    public ElfParse(String filePath) {
        this.filePath = filePath;
        this.fileByteArray = Utils.readFile(filePath);
        this.kind = Utils.byteToShort(Utils.copyBytes(fileByteArray, 16, 2));
        if (kind == 2) {//64解析
            elfHeader = Elf64_hdr.parseheader(fileByteArray);
            Elf64_hdr e = (Elf64_hdr) elfHeader;
            short phSize = Utils.byteToShort(e.e_phnum);
            int proStart = Utils.byteToInt(e.e_phoff);
            int proSize = Utils.byteToShort(e.e_phentsize);
            for(int i=0;i<phSize;i++)
                phList.add(Elf64_phdr.parseprogramHeader(Utils.copyBytes(fileByteArray,proStart+i*proSize,proSize)));

            short shSize = Utils.byteToShort(e.e_shnum);
            int secStart = Utils.byteToInt(e.e_shoff);
            int secSize = Utils.byteToShort(e.e_shenntsize);
            for(int i=0;i<shSize;i++)
                shList.add(Elf64_shdr.parseSectionHeader(Utils.copyBytes(fileByteArray,secStart+i*secSize,secSize)));


        }else if(kind == 3 ){//32解析
            elfHeader = Elf32_hdr.parseheader(fileByteArray);
            Elf32_hdr e = (Elf32_hdr) elfHeader;
            short phSize = Utils.byteToShort(e.e_phnum);
            int proStart = Utils.byteToInt(e.e_phoff);
            int proSize = Utils.byteToShort(e.e_phentsize);
            for(int i=0;i<phSize;i++)
                phList.add(Elf32_phdr.parseprogramHeader(Utils.copyBytes(fileByteArray,proStart+i*proSize,proSize)));

            short shSize = Utils.byteToShort(e.e_shnum);
            int secStart = Utils.byteToInt(e.e_shoff);
            int secSize = Utils.byteToShort(e.e_shenntsize);
            for(int i=0;i<shSize;i++)
                shList.add(Elf32_shdr.parseSectionHeader(Utils.copyBytes(fileByteArray,secStart+i*secSize,secSize)));


        }else{
            System.out.println("好象不是so格式吧。。。。。。。。");
        }
    }

    public static void main(String[] args){
        ElfParse elfParse = new ElfParse("/home/youmeng/桌面/elftest/libsec.so");
        System.out.println(elfParse);
    }


    @Override
    public String toString() {
        return "ElfParse{\n" +
                "filePath='" + filePath + '\'' +
                ", kind=" + kind +
                ", elfHeader=" + elfHeader +
                ", phList=" + phList +
                ", shList=" + shList +
                '}';
    }
}
