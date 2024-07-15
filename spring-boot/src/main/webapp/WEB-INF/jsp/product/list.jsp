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
                            <th><b>Id</b></th>
                            <th><b>Code</b></th>
                            <th><b>Name</b></th>
                            <th><b>Description</b></th>
                        </tr>

                        <!-- loop to print rows in product list -->
                        <c:forEach items="${productsKey}" var="product">
                            <tr>
                                <td>${product.id}</td>
                                <td>${product.productCode}</td>
                                <td>  <a href="../product/${product.id}">   ${product.productName}   </a>  </td>
                                <td>${product.productName}</td>
                                <td>${product.productDescription}</td>
                            </tr>
                        </c:forEach>

                    </table>
                </div>
            </div>
        </div>
    </section>

<jsp:include page="../include/footer.jsp" />