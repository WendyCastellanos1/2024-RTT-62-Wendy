<!-- goes at TOP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../include/header.jsp" />

    <!-- a page header -->
    <section style="background-color:orange">
        <div class="container">
            <div class="row pt-5 pb-5">
                <h1 class="text-center">Products</h1>
            </div>
        </div>
    </section>

    <!-- count of products in the list -->
    <section>
        <div class="container">
            <div class="row pt-5 pb-5">
                <div class="col-12">
                    <h4 class="text-center">${productsKey.size()} result(s)</h4>
                </div>
            </div>

            <div class="row">
                <div class ="col-12">
                    <table class="table">

                        <!-- header row for product list -->
                        <tr>
                            <th><b>Product Id</b></th>
                            <th><b>Product Code</b></th>
                            <th><b>Product Name</b></th>
                            <th><b>Description</b></th>
                            <th><b>Quantity-In-Stock</b></th>
                            <th><b>Buy Price</b></th>
                            <th><b>MSRP</b></th>
                            <th><b>Vendor</b></th>
                            <th><b>Product Scale</b></th>
                            <th><b>Product Line Id</b></th>
                            <th><b>Action</b></th>
                        </tr>

                        <!-- loop to print rows in product list -->
                        <c:forEach items="${productsKey}" var="product">
                            <tr>
                                <td>${product.id}</td>
                                <td>${product.productCode}</td>
                                <td>  <a href="../product/${product.id}">   ${product.productName}   </a>  </td>
                                <td>${product.productDescription}</td>
                                <td>${product.quantityInStock}</td>
                                <td>${product.buyPrice}</td>
                                <td>${product.msrp}</td>
                                <td>${product.productVendor}</td>
                                <td>${product.productScale}</td>
                                <td>${product.productLineId}</td>
                                <td><a href="../product/edit?id=${product.id}">edit</a></td>
                            </tr>
                        </c:forEach>

                    </table>
                </div>
            </div>
        </div>
    </section>

<jsp:include page="../include/footer.jsp" />