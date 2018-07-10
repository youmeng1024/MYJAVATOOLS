package com.fileParse.SO;

import com.IO.Util.Utils;

public class Elf32_phdr {
    public byte[] p_type = new byte[4]; //Elf32_Word __u32
    public byte[] p_offset = new byte[4]; //Elf32_Off __u32
    public byte[] p_vaddr = new byte[4]; //Elf32_Addr __u32
    public byte[] p_paddr = new byte[4]; //Elf32_Addr __u32
    public byte[] p_filesz = new byte[4]; // Elf32_Word __u32
    public byte[] p_memsz = new byte[4]; // Elf32_Word __u32
    public byte[] p_flags = new byte[4]; //Elf32_Word __u32
    public byte[] p_align = new byte[4]; // Elf32_Word __u32

    public static Elf32_phdr parseprogramHeader(byte[] header){
        Elf32_phdr elf32_phdr = new Elf32_phdr();
        elf32_phdr.p_type = Utils.copyBytes(header,0,4);
        elf32_phdr.p_offset = Utils.copyBytes(header,4,4);
        elf32_phdr.p_vaddr = Utils.copyBytes(header,8,4);
        elf32_phdr.p_paddr = Utils.copyBytes(header,12,4);
        elf32_phdr.p_filesz = Utils.copyBytes(header,16,4);
        elf32_phdr.p_memsz = Utils.copyBytes(header,20,4);
        elf32_phdr.p_flags = Utils.copyBytes(header,24,4);
        elf32_phdr.p_align = Utils.copyBytes(header,28,4);
        return elf32_phdr;
    }

    @Override
    public String toString() {
        return "Elf32_phdr{" +
                "p_type=" + Utils.byteToHexStringReserVer(p_type) + "\n" +
                ", p_offset=" + Utils.byteToHexStringReserVer(p_offset) + "\n" +
                ", p_vaddr=" + Utils.byteToHexStringReserVer(p_vaddr) + "\n" +
                ", p_paddr=" + Utils.byteToHexStringReserVer(p_paddr) + "\n" +
                ", p_filesz=" + Utils.byteToHexStringReserVer(p_filesz) + "\n" +
                ", p_memsz=" + Utils.byteToHexStringReserVer(p_memsz) + "\n" +
                ", p_flags=" + Utils.byteToHexStringReserVer(p_flags) + "\n" +
                ", p_align=" + Utils.byteToHexStringReserVer(p_align) + "\n" +
                "}\n";
    }
}