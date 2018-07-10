package com.fileParse.SO;

import com.IO.Util.Utils;

public class Elf32_shdr {
    public byte[] sh_name = new byte[4]; //Elf32_Word __u32
    public byte[] sh_type = new byte[4]; //Elf32_Word __u32
    public byte[] sh_flags = new byte[4]; // Elf32_Word __u32
    public byte[] sh_addr = new byte[4]; //Elf32_Addr __u32
    public byte[] sh_offset = new byte[4]; //Elf32_Off __u32
    public byte[] sh_size = new byte[4]; // Elf32_Word __u32
    public byte[] sh_link = new byte[4]; //Elf32_Word __u32
    public byte[] sh_info = new byte[4]; //Elf32_Word __u32
    public byte[] sh_addralign = new byte[4]; // Elf32_Word __u32
    public byte[] sh_entsize = new byte[4]; // Elf32_Word __u32

    public static Elf32_shdr parseSectionHeader(byte[] header){
        Elf32_shdr elf32_shdr = new Elf32_shdr();
        elf32_shdr.sh_name = Utils.copyBytes(header,0,4);
        elf32_shdr.sh_type = Utils.copyBytes(header,4,4);
        elf32_shdr.sh_flags = Utils.copyBytes(header,8,4);
        elf32_shdr.sh_addr = Utils.copyBytes(header,12,4);
        elf32_shdr.sh_offset = Utils.copyBytes(header,16,4);
        elf32_shdr.sh_size = Utils.copyBytes(header,20,4);
        elf32_shdr.sh_link = Utils.copyBytes(header,24,4);
        elf32_shdr.sh_info = Utils.copyBytes(header,28,4);
        elf32_shdr.sh_addralign = Utils.copyBytes(header,32,4);
        elf32_shdr.sh_entsize = Utils.copyBytes(header,36,4);


        return elf32_shdr;
    }

    @Override
    public String toString() {
        return "Elf32_shdr{" +
                "sh_name=" + Utils.byteToHexStringReserVer(sh_name) + "\n" +
                ", sh_type=" + Utils.byteToHexStringReserVer(sh_type) + "\n" +
                ", sh_flags=" + Utils.byteToHexStringReserVer(sh_flags) + "\n" +
                ", sh_addr=" + Utils.byteToHexStringReserVer(sh_addr) + "\n" +
                ", sh_offset=" + Utils.byteToHexStringReserVer(sh_offset) + "\n" +
                ", sh_size=" + Utils.byteToHexStringReserVer(sh_size) + "\n" +
                ", sh_link=" + Utils.byteToHexStringReserVer(sh_link) + "\n" +
                ", sh_info=" + Utils.byteToHexStringReserVer(sh_info) + "\n" +
                ", sh_addralign=" + Utils.byteToHexStringReserVer(sh_addralign) + "\n" +
                ", sh_entsize=" + Utils.byteToHexStringReserVer(sh_entsize) + "\n" +
                "}\n";
    }
}