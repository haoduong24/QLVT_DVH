package entity;

import java.sql.Timestamp;

public class NguoiDung {
    private int maNguoiDung;
    private String tenDangNhap;
    private String matKhau;
    private String hoTen;
    private String email;
    private String soDienThoai;
    private String vaiTro;
    private Timestamp ngayTao; 

    // Constructor mặc định (cần thiết cho Hibernate hoặc JSP)
    public NguoiDung() {}

    // Constructor đầy đủ tham số
    public NguoiDung(int maNguoiDung, String tenDangNhap, String matKhau, String hoTen, 
                     String email, String soDienThoai, String vaiTro, Timestamp ngayTao) {
        this.maNguoiDung = maNguoiDung;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.vaiTro = (vaiTro != null) ? vaiTro : "nhan_vien"; // Nếu null, mặc định là nhân viên
        this.ngayTao = ngayTao;
    }

    // Constructor không có ngày tạo (nếu không cần)
    public NguoiDung(int maNguoiDung, String tenDangNhap, String matKhau, String hoTen, 
                     String email, String soDienThoai, String vaiTro) {
        this(maNguoiDung, tenDangNhap, matKhau, hoTen, email, soDienThoai, vaiTro, null);
    }

    // Getter & Setter
    public int getMaNguoiDung() { return maNguoiDung; }
    public void setMaNguoiDung(int maNguoiDung) { this.maNguoiDung = maNguoiDung; }

    public String getTenDangNhap() { return tenDangNhap; }
    public void setTenDangNhap(String tenDangNhap) { this.tenDangNhap = tenDangNhap; }

    public String getMatKhau() { return matKhau; }
    public void setMatKhau(String matKhau) { this.matKhau = matKhau; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }

    public String getVaiTro() { return vaiTro; }
    public void setVaiTro(String vaiTro) { 
        this.vaiTro = (vaiTro != null) ? vaiTro : "nhan_vien"; // Đảm bảo không bị null
    }

    public Timestamp getNgayTao() { return ngayTao; }
    public void setNgayTao(Timestamp ngayTao) { this.ngayTao = ngayTao; }

    // Kiểm tra có phải Admin không
    public boolean isAdmin() {
        return "quan_tri".equalsIgnoreCase(this.vaiTro);
    }
}
