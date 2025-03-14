<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Ký</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/dangky.css">
</head>
<body class="d-flex align-items-center justify-content-center" style="height: 100vh; background-color: #f8f9fa;">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card p-4 shadow">
                    <h3 class="text-center">Đăng Ký</h3>

                    <%-- Hiển thị thông báo lỗi --%>
                    <%
                        String error = request.getParameter("error");
                        if ("missing_fields".equals(error)) { %>
                            <div class="alert alert-warning">Vui lòng nhập đầy đủ thông tin!</div>
                    <%  } else if ("exists".equals(error)) { %>
                            <div class="alert alert-danger">Tên đăng nhập đã tồn tại!</div>
                    <%  } 
                    %>

                    <form action="DangKy" method="post">
                        <div class="mb-3">
                            <label for="tenDangNhap" class="form-label">Tên đăng nhập</label>
                            <input type="text" name="tenDangNhap" id="tenDangNhap" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="matKhau" class="form-label">Mật khẩu</label>
                            <input type="password" name="matKhau" id="matKhau" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="hoTen" class="form-label">Họ và tên</label>
                            <input type="text" name="hoTen" id="hoTen" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" name="email" id="email" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="soDienThoai" class="form-label">Số điện thoại</label>
                            <input type="text" name="soDienThoai" id="soDienThoai" class="form-control" required>
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Đăng Ký</button>
                    </form>

                    <p class="mt-3 text-center">
                        Đã có tài khoản? <a href="dangnhap.jsp">Đăng nhập</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
