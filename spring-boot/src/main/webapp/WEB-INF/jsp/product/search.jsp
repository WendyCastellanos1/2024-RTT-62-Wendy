<jsp:include page="../include/header.jsp" />

<!-- page header -->
<section style="background-color:orange">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Product Search</h1>
        </div>
    </div>
</section>

<!-- search form -->
<section>
    <div class="container">
        <div class="row justify-content-center pt-5 pb-3">
            <div class="col-8 text-center">
                <form action="../product/search">
                    <div class="mb-3">
                        <label for="search" class="form-label"><h4>Product Search</h4></label>
                        <input type="text" value="${searchToken}" class="form-control" id="search" name="search" placeholder="Enter search term"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Search</button>
                </form>
            </div>
        </div>
    </div>
</section>

<!-- show product count in the list -->
<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <div class="col-12">
                <h4 class="text-center"> ${productsToken.size()} result(s)</h4>
            </div>
        </div>

        <!-- show the rows of products -->
        <div class="row">
            <div class ="col-12">
                <table class="table">
                    <tr>
                        <th><b>Id</b></th>
                        <th><b>Code</b></th>
                        <th><b>Name</b></th>
                        <th><b>Description</b></th>
                    </tr>

                    <c:forEach items="${productsToken}" var="product">
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.productCode}</td>

                            <td>  <a href="/product/${product.id}">   ${product.productName}   </a>  </td>
                            <td>${product.productDescription}</td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />