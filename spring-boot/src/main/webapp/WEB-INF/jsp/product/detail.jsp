<jsp:include page="../include/header.jsp" />

    <!-- a page header -->
    <section style="background-color:orange">
        <div class="container">
            <div class="row pt-5 pb-5">
                <h1 class="text-center">Product:  ${productToken.productName}</h1>
            </div>
        </div>
    </section>

    <!-- product detail for one product -->
    <table class="table">
        <tr><td><b>Id</b></td>  <td>${productToken.id}</td></tr>
        <tr><td><b>Code</b></td>  <td>${productToken.productCode}</td></tr>
        <tr><td><b>Name</b></td>  <td>${productToken.productName}</td></tr>
        <tr><td><b>Description</b></td>  <td>${productToken.productDescription}</td></tr>
    </table>

    <div>
        <a href="/products">View the master product list</a>
        <br>
        <a href="/search">Search for more products</a>
    </div>

<jsp:include page="../include/footer.jsp" />