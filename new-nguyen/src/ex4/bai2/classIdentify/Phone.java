package ex4.bai2.classIdentify;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Phone {
    private static ArrayList<Phone> list = new ArrayList<>();
    private String sdt;
    private long soDuTaiKhoan;
    private LocalDateTime lanCuoiSuaDoi;

    public Phone(String sdt, long soDuTaiKhoan, LocalDateTime lanCuoiSuaDoi)
    {
        this.sdt = sdt;
        this.soDuTaiKhoan = soDuTaiKhoan;
        this.lanCuoiSuaDoi = lanCuoiSuaDoi;
    }

    public static ArrayList<Phone> getList()
    {
        return list;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public long getSoDuTaiKhoan() {
        return soDuTaiKhoan;
    }

    public void setSoDuTaiKhoan(long soDuTaiKhoan) {
        this.soDuTaiKhoan = soDuTaiKhoan;
    }

    public LocalDateTime getLanCuoiSuaDoi() {
        return lanCuoiSuaDoi;
    }

    public void setLanCuoiSuaDoi(LocalDateTime lanCuoiSuaDoi) {
        this.lanCuoiSuaDoi = lanCuoiSuaDoi;
    }

    public boolean isValid()
    {
        if(this.sdt.length() != 11 ||
        this.lanCuoiSuaDoi.compareTo(LocalDateTime.now()) > 0 ||
        this.soDuTaiKhoan < 0) return false;
        return true;
    }

    public static void addToList(Phone temp)
    {
        list.add(temp);
    }

    public boolean inList()
    {
        for(Phone i: getList())
        {
            if(i.sdt.contains(this.sdt)) return true;
        }
        return false;
    }

    public void addTransaction(Command command)
    {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.soDuTaiKhoan += command.getSoTienChuyen();
        String strLanCuoiSuaDoi = LocalDateTime.now().format(dt);
        this.lanCuoiSuaDoi = LocalDateTime.parse(strLanCuoiSuaDoi, dt);
    }

    public void minusTransaction(Command command)
    {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String strLanCuoiSuaDoi = LocalDateTime.now().format(dt);
        if(this.soDuTaiKhoan - command.getSoTienChuyen() > 0)
        {
            this.soDuTaiKhoan -= command.getSoTienChuyen();
            this.lanCuoiSuaDoi = LocalDateTime.parse(strLanCuoiSuaDoi, dt);
            command.setSuccess(true);
        }else
        {
            command.setSuccess(false);
        }
    }

    public static Phone getPhoneNumberObject(String target)
    {
        for(Phone i: list)
        {
            if(i.getSdt().contains(target)) return i;
        }
        return new Phone(null,0,LocalDateTime.now());
    }
}
