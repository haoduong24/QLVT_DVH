package entity;

public class CartItem {
    private int maVatTu;
    private String tenVatTu;
    private String anhSanPham;
    private double giaBan;
    private int soLuong;

    // Constructor đầy đủ tham số
    public CartItem(int maVatTu, String tenVatTu, String anhSanPham, double giaBan, int soLuong) {
        this.maVatTu = maVatTu;
        this.tenVatTu = tenVatTu;
        this.anhSanPham = anhSanPham;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    // Getter & Setter
    public int getMaVatTu() { return maVatTu; }
    public String getTenVatTu() { return tenVatTu; }
    public String getAnhSanPham() { return anhSanPham; }
    public double getGiaBan() { return giaBan; }
    
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { 
        if (soLuong > 0) {
            this.soLuong = soLuong; 
        }
    }

    // Alias methods (cho tương thích với getQuantity/setQuantity)
    public int getQuantity() { return getSoLuong(); }
    public void setQuantity(int soLuong) { setSoLuong(soLuong); }

    // Hiển thị thông tin CartItem (Debug dễ hơn)
    @Override
    public String toString() {
        return "CartItem{" +
                "maVatTu=" + maVatTu +
                ", tenVatTu='" + tenVatTu + '\'' +
                ", anhSanPham='" + anhSanPham + '\'' +
                ", giaBan=" + giaBan +
                ", soLuong=" + soLuong +
                '}';
    }
}
