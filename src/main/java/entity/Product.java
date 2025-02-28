package entity;

public class Product {
    private int MaVatTu;
    private String TenVatTu;
    private double GiaBan;
    private String AnhSanPham;

    // Constructor không tham số
    public Product() {
    }

    // Constructor đầy đủ tham số
    public Product(int MaVatTu, String TenVatTu, double GiaBan, String AnhSanPham) {
        this.MaVatTu = MaVatTu;
        this.TenVatTu = TenVatTu;
        this.GiaBan = GiaBan;
        this.AnhSanPham = AnhSanPham;
    }

    // Getter & Setter cho MaVatTu
    public int getMaVatTu() {
        return MaVatTu;
    }

    public void setMaVatTu(int maVatTu) {
        this.MaVatTu = maVatTu;
    }

    // Getter & Setter cho TenVatTu
    public String getTenVatTu() {
        return TenVatTu;
    }

    public void setTenVatTu(String tenVatTu) {
        this.TenVatTu = tenVatTu;
    }

    // Getter & Setter cho GiaBan
    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double giaBan) {
        this.GiaBan = giaBan;
    }

    // Getter & Setter cho AnhSanPham
    public String getAnhSanPham() {
        return AnhSanPham;
    }

    public void setAnhSanPham(String anhSanPham) {
        this.AnhSanPham = anhSanPham;
    }
 // Ghi đè phương thức toString()
    @Override
    public String toString() {
        return "Product{" +
                "MaVatTu=" + MaVatTu +
                ", TenVatTu='" + TenVatTu + '\'' +
                ", GiaBan=" + GiaBan +
                ", AnhSanPham='" + AnhSanPham + '\'' +
                '}';
    }
}
