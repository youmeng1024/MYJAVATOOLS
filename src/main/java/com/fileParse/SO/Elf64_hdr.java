package com.fileParse.SO;

import com.IO.Util.Utils;

public class Elf64_hdr{
    public byte[] e_ident=new byte[16]; //#define EI_NINDENT 16
    public byte[] e_type=new byte[2]; // Elf64_Half __u16
    public byte[] e_machine=new byte[2]; // Elf64_Half __u16
    public byte[] e_version=new byte[4]; //Elf64_Word __u32
    public byte[] e_entry=new byte[8]; //Elf64_Addr __u64
    public byte[] e_phoff=new byte[8]; //Elf64_Off __u64
    public byte[] e_shoff=new byte[8]; //Elf64_Off __u64
    public byte[] e_flags=new byte[4]; //Elf64_Word __u32
    public byte[] e_ehsize=new byte[2]; // Elf64_Half __u16
    public byte[] e_phentsize=new byte[2]; // Elf64_Half __u16
    public byte[] e_phnum=new byte[2]; // Elf64_Half __u16
    public byte[] e_shenntsize=new byte[2]; // Elf64_Half __u16
    public byte[] e_shnum=new byte[2]; // Elf64_Half __u16
    public byte[] e_shstrndx=new byte[2]; // Elf64_Half __u16

    public static Elf64_hdr parseheader(byte[] header){//解析每个section header
        Elf64_hdr elf64_hdr = new Elf64_hdr();
        elf64_hdr.e_ident= Utils.copyBytes(header,0,16);
        elf64_hdr.e_type= Utils.copyBytes(header,16,2);
        elf64_hdr.e_machine= Utils.copyBytes(header,18,2);
        elf64_hdr.e_version= Utils.copyBytes(header,20,4);
        elf64_hdr.e_entry= Utils.copyBytes(header,24,8);
        elf64_hdr.e_phoff= Utils.copyBytes(header,32,8);
        elf64_hdr.e_shoff= Utils.copyBytes(header,40,8);
        elf64_hdr.e_flags= Utils.copyBytes(header,48,4);
        elf64_hdr.e_ehsize= Utils.copyBytes(header,52,2);
        elf64_hdr.e_phentsize= Utils.copyBytes(header,54,2);
        elf64_hdr.e_phnum= Utils.copyBytes(header,56,2);
        elf64_hdr.e_shenntsize= Utils.copyBytes(header,58,2);
        elf64_hdr.e_shnum= Utils.copyBytes(header,60,2);
        elf64_hdr.e_shstrndx= Utils.copyBytes(header,62,2);
        return elf64_hdr;
    }

    @Override
    public String toString() {
        return "Elf64_hdr{" +
                "e_ident=" + Utils.byteToHexStringReserVer(e_ident) + "\n"+
                ", e_type=" + Utils.byteToHexStringReserVer(e_type) + "\n"+
                ", e_machine=" + Utils.byteToHexStringReserVer(e_machine) + "\n"+
                ", e_version=" + Utils.byteToHexStringReserVer(e_version) + "\n"+
                ", e_entry=" + Utils.byteToHexStringReserVer(e_entry) + "\n"+
                ", e_phoff=" + Utils.byteToHexStringReserVer(e_phoff) + "\n"+
                ", e_shoff=" + Utils.byteToHexStringReserVer(e_shoff) + "\n"+
                ", e_flags=" + Utils.byteToHexStringReserVer(e_flags) + "\n"+
                ", e_ehsize=" + Utils.byteToHexStringReserVer(e_ehsize) + "\n"+
                ", e_phentsize=" + Utils.byteToHexStringReserVer(e_phentsize) + "\n"+
                ", e_phnum=" + Utils.byteToHexStringReserVer(e_phnum) + "\n"+
                ", e_shenntsize=" + Utils.byteToHexStringReserVer(e_shenntsize) + "\n"+
                ", e_shnum=" + Utils.byteToHexStringReserVer(e_shnum) + "\n"+
                ", e_shstrndx=" + Utils.byteToHexStringReserVer(e_shstrndx) + "\n"+
                '}';
    }
}