package entity;

public class DanhMuc {
    private int MaDanhMuc;
    private String TenDanhMuc;
    private String MoTa;

    // Constructor không tham số
    public DanhMuc() {
    }

    // Constructor có tham số
    public DanhMuc(int maDanhMuc, String tenDanhMuc, String moTa) {
        this.MaDanhMuc = maDanhMuc;
        this.TenDanhMuc = tenDanhMuc;
        this.MoTa = moTa;
    }

    // Getter và Setter
    public int getMaDanhMuc() {
        return MaDanhMuc;
    }

    public void setMaDanhMuc(int maDanhMuc) {
        this.MaDanhMuc = maDanhMuc;
    }

    public String getTenDanhMuc() {
        return TenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.TenDanhMuc = tenDanhMuc;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        this.MoTa = moTa;
    }

    // Phương thức toString để dễ dàng in ra thông tin
    @Override
    public String toString() {
        return "DanhMuc{" +
                "MaDanhMuc=" + MaDanhMuc +
                ", TenDanhMuc='" + TenDanhMuc + '\'' +
                ", MoTa='" + MoTa + '\'' +
                '}';
    }
}
