/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Jeremy
 */
public class PhieuMuaHang {

    private int MaPhieuMuaHang;
    private TaiKhoan KhachHang;
    private Date NgayMua;
    private List<ChiTietPhieuMuaHang> DanhSachHang = new ArrayList<>();

    public List<ChiTietPhieuMuaHang> getDanhSachHang() {
        return DanhSachHang;
    }

    public void setDanhSachHang(List<ChiTietPhieuMuaHang> DanhSachHang) {
        this.DanhSachHang = DanhSachHang;
    }

    public int getMaPhieuMuaHang() {
        return MaPhieuMuaHang;
    }

    public void setMaPhieuMuaHang(int MaPhieuMuaHang) {
        this.MaPhieuMuaHang = MaPhieuMuaHang;
    }

    public TaiKhoan getKhachHang() {
        return KhachHang;
    }

    public void setKhachHang(TaiKhoan KhachHang) {
        this.KhachHang = KhachHang;
    }

    public Date getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(Date NgayMua) {
        this.NgayMua = NgayMua;
    }
}
