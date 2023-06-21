package ex4.bai2.classIdentify;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Command{
    private String lenh;
    private Phone sdtGoc;
    private int soTienChuyen;
    private Phone sdtChuyenDen;
    private boolean success;

    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Command(String lenh, Phone sdtGoc, int soTienChuyen, Phone sdtChuyenDen, boolean success)
    {
        this.lenh = lenh;
        this.sdtGoc = sdtGoc;
        this.soTienChuyen = soTienChuyen;
        this.sdtChuyenDen = sdtChuyenDen;
        this.success = success;
    }

    public String getLenh() {
        return lenh;
    }

    public void setLenh(String lenh) {
        this.lenh = lenh;
    }

    public Phone getSdtGoc() {
        return sdtGoc;
    }

    public void setSdtGoc(Phone sdtGoc) {
        this.sdtGoc = sdtGoc;
    }

    public int getSoTienChuyen() {
        return soTienChuyen;
    }

    public void setSoTienChuyen(int soTienChuyen) {
        this.soTienChuyen = soTienChuyen;
    }

    public Phone getSdtChuyenDen() {
        return sdtChuyenDen;
    }

    public void setSdtChuyenDen(Phone sdtChuyenDen) {
        this.sdtChuyenDen = sdtChuyenDen;
    }

    public boolean inList(ArrayList<Phone> listPhone)
    {
        for(Phone i: listPhone)
        {
            if(this.lenh.contains("add") || this.lenh.contains("minus"))
            {
                if(i.getSdt().contains(this.sdtGoc.getSdt())) return true;
            }else if(this.lenh.contains("transfer"))
            {
                if(listPhone.indexOf(this.getSdtGoc()) != -1 && listPhone.indexOf(this.getSdtChuyenDen()) != -1) return true;
            }
        }
        return false;
    }

    public boolean isValid()
    {
        if(this.lenh.contains("add") || this.lenh.contains("minus"))
        {
            if(this.sdtGoc.getSdt().length() != 11 || this.soTienChuyen == 0) return false;
            else return true;
        }else if(this.lenh.contains("transfer"))
        {
            if(this.sdtGoc.getSdt().length() != 11 || this.sdtChuyenDen.getSdt().length() != 11 || this.soTienChuyen == 0) return false;
            else return true;
        }else return false;
    }
}
