package com.fileParse.SO;

import com.IO.Util.Utils;

public class Elf64_phdr {
    public byte[] p_type = new byte[4]; //Elf64_Word __u32
    public byte[] p_flags = new byte[4]; //Elf64_Word __u32
    public byte[] p_offset = new byte[8]; //Elf64_Off __u64
    public byte[] p_vaddr = new byte[8]; //Elf64_Addr __u64
    public byte[] p_paddr = new byte[8]; //Elf64_Addr __u64
    public byte[] p_filesz = new byte[8]; // Elf64_Xword __u64
    public byte[] p_memsz = new byte[8]; // Elf64_Xword __u64
    public byte[] p_align = new byte[8]; // Elf64_Xword __u64

    public static Elf64_phdr parseprogramHeader(byte[] header){
        Elf64_phdr elf64_shdr = new Elf64_phdr();
        elf64_shdr.p_type = Utils.copyBytes(header,0,4);
        elf64_shdr.p_flags = Utils.copyBytes(header,4,4);
        elf64_shdr.p_offset = Utils.copyBytes(header,8,8);
        elf64_shdr.p_vaddr = Utils.copyBytes(header,16,8);
        elf64_shdr.p_paddr = Utils.copyBytes(header,24,8);
        elf64_shdr.p_filesz = Utils.copyBytes(header,32,8);
        elf64_shdr.p_memsz = Utils.copyBytes(header,40,8);
        elf64_shdr.p_align = Utils.copyBytes(header,48,8);
        return elf64_shdr;
    }

    @Override
    public String toString() {
        return "Elf64_Shdr{" +
                "p_type=" + Utils.byteToHexStringReserVer(p_type) + "\n" +
                ", p_flags=" + Utils.byteToHexStringReserVer(p_flags) + "\n" +
                ", p_offset=" + Utils.byteToHexStringReserVer(p_offset) + "\n" +
                ", p_vaddr=" + Utils.byteToHexStringReserVer(p_vaddr) + "\n" +
                ", p_paddr=" + Utils.byteToHexStringReserVer(p_paddr) + "\n" +
                ", p_filesz=" + Utils.byteToHexStringReserVer(p_filesz) + "\n" +
                ", p_memsz=" + Utils.byteToHexStringReserVer(p_memsz) + "\n" +
                ", p_align=" + Utils.byteToHexStringReserVer(p_align) + "\n" +
                "}\n";
    }
}

