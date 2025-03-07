package entity;

public class Product {
    private int maVatTu;
    private String tenVatTu;
    private String anhSanPham;
    private double giaBan;
    private int maDanhMuc;

    public Product() {}

    public Product(int maVatTu, String tenVatTu, String anhSanPham, double giaBan, int maDanhMuc) {
        this.maVatTu = maVatTu;
        this.tenVatTu = tenVatTu;
        this.anhSanPham = anhSanPham;
        this.giaBan = giaBan;
        this.maDanhMuc = maDanhMuc;
    }

    public int getMaVatTu() {
        return maVatTu;
    }

    public void setMaVatTu(int maVatTu) {
        this.maVatTu = maVatTu;
    }

    public String getTenVatTu() {
        return tenVatTu;
    }

    public void setTenVatTu(String tenVatTu) {
        this.tenVatTu = tenVatTu;
    }

    public String getAnhSanPham() {
        return anhSanPham;
    }

    public void setAnhSanPham(String anhSanPham) {
        this.anhSanPham = anhSanPham;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(int maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }
}
