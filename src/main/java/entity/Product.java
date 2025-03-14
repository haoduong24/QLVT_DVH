package entity;

public class Product {
    private int maVatTu;
    private String tenVatTu;
    private String anhSanPham;
    private double giaBan;
    private int maDanhMuc;

    // Constructor đầy đủ
    public Product(int maVatTu, String tenVatTu, String anhSanPham, double giaBan, int maDanhMuc) {
        this.maVatTu = maVatTu;
        this.tenVatTu = (tenVatTu != null) ? tenVatTu : "Không có tên"; // Fix lỗi null
        this.anhSanPham = (anhSanPham != null) ? anhSanPham : "default.jpg"; // Fix lỗi ảnh null
        this.giaBan = giaBan;
        this.maDanhMuc = maDanhMuc;
    }

    // Getter & Setter
    public int getMaVatTu() { return maVatTu; }
    public void setMaVatTu(int maVatTu) { this.maVatTu = maVatTu; }

    public String getTenVatTu() { return tenVatTu; }
    public void setTenVatTu(String tenVatTu) { 
        this.tenVatTu = (tenVatTu != null) ? tenVatTu : "Không có tên"; 
    }

    public String getAnhSanPham() { return anhSanPham; }
    public void setAnhSanPham(String anhSanPham) { 
        this.anhSanPham = (anhSanPham != null) ? anhSanPham : "default.jpg"; 
    }

    public double getGiaBan() { return giaBan; }
    public void setGiaBan(double giaBan) { this.giaBan = giaBan; }

    public int getMaDanhMuc() { return maDanhMuc; }
    public void setMaDanhMuc(int maDanhMuc) { this.maDanhMuc = maDanhMuc; }

    // Hiển thị thông tin sản phẩm (Debug)
    @Override
    public String toString() {
        return "Product{" +
                "maVatTu=" + maVatTu +
                ", tenVatTu='" + tenVatTu + '\'' +
                ", anhSanPham='" + anhSanPham + '\'' +
                ", giaBan=" + giaBan +
                ", maDanhMuc=" + maDanhMuc +
                '}';
    }
}
