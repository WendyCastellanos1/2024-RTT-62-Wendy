<!-- goes at TOP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

    <!-- a page header -->
    <section style="background-color:orange">
        <div class="container">
            <div class="row pt-5 pb-5">
                <h1 class="text-center">Product:  ${productKey.productName}</h1>
            </div>
        </div>
    </section>

    <!-- product detail for one product -->
    <table class="table">
        <tr><td><b>Id</b></td>  <td>${productKey.id}</td></tr>
        <tr><td><b>Code</b></td>  <td>${productKey.productCode}</td></tr>
        <tr><td><b>Name</b></td>  <td>${productKey.productName}</td></tr>
        <tr><td><b>Description</b></td>  <td>${productKey.productDescription}</td></tr>
    </table>

    <!-- links at bottom of page -->
    <div>
        <a href="../product/list">View all products</a>
        <br>
        <a href="../product/search">Search for products</a>
    </div>

<jsp:include page="../include/footer.jsp" />