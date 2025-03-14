<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Nhập</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/dangnhap.css">
</head>
<body class="d-flex align-items-center justify-content-center" style="height: 100vh; background-color: #f8f9fa;">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card p-4 shadow">
                    <h3 class="text-center">Đăng Nhập</h3>

                    <%-- Hiển thị thông báo lỗi --%>
                    <%
                        String success = request.getParameter("success");
                        String error = request.getParameter("error");
                        if ("1".equals(success)) { %>
                            <div class="alert alert-success">Đăng ký thành công! Vui lòng đăng nhập.</div>
                    <%  } else if ("invalid".equals(error)) { %>
                            <div class="alert alert-danger">Sai tên đăng nhập hoặc mật khẩu!</div>
                    <%  } 
                    %>

                    <form action="DangNhap" method="post">
                        <div class="mb-3">
                            <label for="tenDangNhap" class="form-label">Tên đăng nhập</label>
                            <input type="text" name="tenDangNhap" id="tenDangNhap" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="matKhau" class="form-label">Mật khẩu</label>
                            <input type="password" name="matKhau" id="matKhau" class="form-control" required>
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Đăng Nhập</button>
                    </form>

                    <p class="mt-3 text-center">
                        Chưa có tài khoản? <a href="dangky.jsp">Đăng ký</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
