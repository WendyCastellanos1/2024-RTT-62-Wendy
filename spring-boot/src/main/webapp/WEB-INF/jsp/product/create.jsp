<!-- goes at TOP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../include/header.jsp" />


<!-- a page header -->
<section style="background-color:orange">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1>
                <c:if test="${empty form.id}">
                    <h1 class="text-center">Create Product</h1>
                </c:if>
                <c:if test="${not empty form.id}">
                    <h1 class="text-center">Edit Product</h1>
                </c:if>
            </h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <form action="/product/createSubmit">
                    <input type="hidden" name="id" value="${form.id}">  <!-- id is the product id -->

                    <div class="row align-items-center pb-3">

                        <div class="row align-items-center justify-content-center">
                            <div class="col-2">
                                <label for="productNameId" class="col-form-label">Product Name</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="productNameId"
                                       name="productName"
                                       class="form-control
                                            <c:if test="${bindingResult.hasFieldErrors('productName')}">is-invalid</c:if>"
                                       value="${form.productName}">
                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('productName')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('productName')}" var="error"  >
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="productCodeId" class="col-form-label">Product Code</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="productCodeId"
                                       name="productCode"
                                       class="form-control
                                            <c:if test="${bindingResult.hasFieldErrors('productCode')}">is-invalid</c:if>"
                                       value="${form.productCode}">
                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('productCode')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('productCode')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="productDescriptionId" class="col-form-label">Product Description</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="productDescriptionId"
                                       name="productDescription"
                                       class="form-control
                                            <c:if test="${bindingResult.hasFieldErrors('productDescription')}">is-invalid</c:if>"
                                       value="${form.productDescription}">
                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('productDescription')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('productDescription')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="productLineIdId" class="col-form-label">Product Line Id</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="productLineIdId"
                                       name="productLineId"
                                       class="form-control
                                             <c:if test="${bindingResult.hasFieldErrors('productLineId')}">is-invalid</c:if>"
                                       value="${form.productLineId}">
                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('productLineId')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('productLineId')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="productVendorId" class="col-form-label">Product Vendor</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="productVendorId"
                                       name="productVendor"
                                       class="form-control
                                            <c:if test="${bindingResult.hasFieldErrors('productVendor')}">is-invalid</c:if>"
                                       value="${form.productVendor}">
                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('productVendor')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('productVendor')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="productScaleId" class="col-form-label">Product Scale</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="productScaleId"
                                       name="productScale"
                                       class="form-control
                                            <c:if test="${bindingResult.hasFieldErrors('productScale')}">is-invalid</c:if>"
                                       value="${form.productScale}">
                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('productScale')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('productScale')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="quantityInStockId" class="col-form-label">Quantity-in-Stock</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="quantityInStockId"
                                       name="quantityInStock"
                                       class="form-control
                                            <c:if test="${bindingResult.hasFieldErrors('quantityInStock')}">is-invalid</c:if>"
                                       value="${form.quantityInStock}">
                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('quantityInStock')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('quantityInStock')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="buyPriceId" class="col-form-label">Buy Price</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="buyPriceId"
                                       name="buyPrice"
                                       class="form-control
                                                <c:if test="${bindingResult.hasFieldErrors('buyPrice')}">is-invalid</c:if>"
                                       value="${form.buyPrice}">
                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('buyPrice')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('buyPrice')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="msrpId" class="col-form-label">MSRP</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="msrpId"
                                       name="msrp"
                                       class="form-control
                                            <c:if test="${bindingResult.hasFieldErrors('msrp')}">is-invalid</c:if>"
                                       value="${form.msrp}">
                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('msrp')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('msrp')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>


                        <div class="row justify-content-center pt-3 ">
                            <div class="col-auto text-center">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </div>

                    </div>
                </form>
            </div>
        </div>
    </div>
</section>


<jsp:include page="../include/footer.jsp" />