<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HD Vat Tu</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--begin of menu-->
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="home">DVH Vat Tu</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="#">ADMIN Account</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Dang xuat</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Dang nhap</a>
                        </li>
                    </ul>

                    <form action="search" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                        <a class="btn btn-success btn-sm ml-3" href="show">
                            <i class="fa fa-shopping-cart"></i> Gio Hang
                            <span class="badge badge-light">3</span>
                        </a>
                    </form>
                </div>
            </div>
        </nav>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Tu vat lieu chat luong cao</h1>
                <p class="lead text-muted mb-0">Uy tin tao nen thuong hieu voi hon 10 nam cung cap cac san pham tu vat lieu nhap tu Duong Noi</p>
            </div>
        </section>
        <!--end of menu-->
        <div class="container">
            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="Home.jsp">Trang chu</a></li>
                            <li class="breadcrumb-item"><a href="#">Danh muc</a></li>
                            <li class="breadcrumb-item active" aria-current="#">Lien he</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Danh Muc</div>
                        <ul class="list-group category_block">
                            <c:forEach items="${listC}" var="o">
                                <li class="list-group-item text-white"><a href="#">${o.MaDanhMuc}</a></li>
                            </c:forEach>

                        </ul>
                    </div>
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-success text-white text-uppercase">Last product</div>
                        <div class="card-body">
                            <img class="img-fluid" src="${p.AnhSanPham}" />
                            <h5 class="card-title">${p.MaVatTu}</h5>
                            <p class="bloc_left_price">${p.GiaBan} $</p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-9">
                    <div class="row">
                        <c:forEach items="${listP}" var="o">
                            <div class="col-12 col-md-6 col-lg-4">
                                <div class="card">
                                    <img class="card-img-top" src="${o.AnhSanPham}" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="#" title="View Product">${o.TenVatTu}</a></h4>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-danger btn-block">15000000</p>
                                            </div>
                                            <div class="col">
                                                <a href="#" class="btn btn-success btn-block">Them vao gio</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>

            </div>
        </div>

        <!-- Footer -->
        <footer class="text-light">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-lg-4 col-xl-3">
                        <h5>About</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                        <p class="mb-0">
                            Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression.
                        </p>
                    </div>

                    <div class="col-md-2 col-lg-2 col-xl-2 mx-auto">
                        <h5>Informations</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                        <ul class="list-unstyled">
                            <li><a href="">Link 1</a></li>
                            <li><a href="">Link 2</a></li>
                            <li><a href="">Link 3</a></li>
                            <li><a href="">Link 4</a></li>
                        </ul>
                    </div>

                    <div class="col-md-3 col-lg-2 col-xl-2 mx-auto">
                        <h5>Others links</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                        <ul class="list-unstyled">
                            <li><a href="">Link 1</a></li>
                            <li><a href="">Link 2</a></li>
                            <li><a href="">Link 3</a></li>
                            <li><a href="">Link 4</a></li>
                        </ul>
                    </div>

                    <div class="col-md-4 col-lg-3 col-xl-3">
                        <h5>Contact</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                        <ul class="list-unstyled">
                            <li><i class="fa fa-home mr-2"></i> My company</li>
                            <li><i class="fa fa-envelope mr-2"></i> email@example.com</li>
                            <li><i class="fa fa-phone mr-2"></i> +84377004824</li>
                            <li><i class="fa fa-print mr-2"></i> +84345678912</li>
                        </ul>
                    </div>
                    <div class="col-12 copyright mt-3">
                        <p class="float-left">
                            <a href="#">Back to top</a>
                        </p>
                        <p class="text-right text-muted">created with <i class="fa fa-heart"></i> by <a href="https://t-php.fr/43-theme-ecommerce-bootstrap-4.html"><i>t-php</i></a> | <span>v. 1.0</span></p>
                    </div>
                </div>
            </div>
        </footer>
    </body>
</html>

