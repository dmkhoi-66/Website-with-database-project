/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.DAO;

import java.io.Serializable;

/**
 *
 * @author Jeremy
 */
public class ChiTietPhieuMuaHang implements Serializable {

    private int MaPhieuMuaHang;
    private int MaSanPham;
    private double Gia;
    private int SoLuong;



    public ChiTietPhieuMuaHang() {
    }

    public int getMaPhieuMuaHang() {
        return MaPhieuMuaHang;
    }

    public void setMaPhieuMuaHang(int MaPhieuMuaHang) {
        this.MaPhieuMuaHang = MaPhieuMuaHang;
    }

    public int getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }


    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
}
