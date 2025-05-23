/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.DAO;

/**
 *
 * @author Jeremy
 */
public class SanPham {

    private int MaSanPham;
    private String TenSanPham;
    private double Gia;
    private MauSac MauSac;
    private KichThuoc KichThuoc;
    private boolean DaXoa;
    private DanhMuc DanhMuc;
    private String Anh;

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String Anh) {
        this.Anh = Anh;
    }

    public SanPham() {
        DaXoa = false;
    }

    public DanhMuc getDanhMuc() {
        return DanhMuc;
    }

    public void setDanhMuc(DanhMuc DanhMuc) {
        this.DanhMuc = DanhMuc;
    }

    public int getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public MauSac getMauSac() {
        return MauSac;
    }

    public void setMauSac(MauSac MauSac) {
        this.MauSac = MauSac;
    }

    public KichThuoc getKichThuoc() {
        return KichThuoc;
    }

    public void setKichThuoc(KichThuoc KichThuoc) {
        this.KichThuoc = KichThuoc;
    }

    public boolean isDaXoa() {
        return DaXoa;
    }

    public void setDaXoa(boolean DaXoa) {
        this.DaXoa = DaXoa;
    }
}
