/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DungLe
 */
public class ThongKe {
    int XepHang ;
    String CaSi , BaiHat,LuotXem ;

    public ThongKe(int XepHang, String CaSi, String BaiHat, String LuotXem) {
        this.XepHang = XepHang;
        this.CaSi = CaSi;
        this.BaiHat = BaiHat;
        this.LuotXem = LuotXem;
    }

    public ThongKe() {
    }

    public ThongKe(String CaSi, String BaiHat, String LuotXem) {
        this.CaSi = CaSi;
        this.BaiHat = BaiHat;
        this.LuotXem = LuotXem;
    }

    public int getXepHang() {
        return XepHang;
    }

    public void setXepHang(int XepHang) {
        this.XepHang = XepHang;
    }

    public String getCaSi() {
        return CaSi;
    }

    public void setCaSi(String CaSi) {
        this.CaSi = CaSi;
    }

    public String getBaiHat() {
        return BaiHat;
    }

    public void setBaiHat(String BaiHat) {
        this.BaiHat = BaiHat;
    }

    public String getLuotXem() {
        return LuotXem;
    }

    public void setLuotXem(String LuotXem) {
        this.LuotXem = LuotXem;
    }

}