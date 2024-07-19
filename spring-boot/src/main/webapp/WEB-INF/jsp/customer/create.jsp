<!-- goes at TOP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../include/header.jsp" />


<!-- a page header -->
<section style="background-color:orange">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1>
                <c:if test="${empty form.id}">
                    <h1 class="text-center">Create Customer</h1>
                </c:if>
                <c:if test="${not empty form.id}">
                    <h1 class="text-center">Edit Customer</h1>
                </c:if>
            </h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <form action="/customer/createSubmit">
                    <input type="hidden" name="id" value="${form.id}">  <!-- id is the customer id -->

                    <div class="row align-items-center pb-3">

                        <div class="row align-items-center justify-content-center">
                            <div class="col-2">
                                <label for="customerNameId" class="col-form-label">Customer Name</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="customerNameId"
                                       name="customerName"
                                       class="form-control
                                            <c:if test="${bindingResult.hasFieldErrors('customerName')}">is-invalid</c:if>"
                                       value="${form.customerName}">

                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('customerName')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('customerName')}" var="error"  >
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="contactFirstNameId" class="col-form-label">Contact First Name</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="contactFirstNameId"
                                       name="contactFirstName"
                                       class="form-control
                                            <c:if test="${bindingResult.hasFieldErrors('contactFirstName')}">is-invalid</c:if>"
                                       value="${form.contactFirstName}" >
                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('contactFirstName')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('contactFirstName')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="contactLastNameId" class="col-form-label">Contact Last Name</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="contactLastNameId"
                                       name="contactLastName"
                                       class="form-control
                                            <c:if test="${bindingResult.hasFieldErrors('contactLastName')}">is-invalid</c:if>"
                                       value="${form.contactLastName}" >
                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('contactLastName')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('contactLastName')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="phoneId" class="col-form-label">Phone</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="phoneId"
                                       name="phone"
                                       class="form-control
                                             <c:if test="${bindingResult.hasFieldErrors('phone')}">is-invalid</c:if>"
                                                value="${form.phone}">
                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('phone')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('phone')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="addressLine1Id" class="col-form-label">Address Line 1</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="addressLine1Id"
                                       name="addressLine1"
                                       class="form-control
                                            <c:if test="${bindingResult.hasFieldErrors('addressLine1')}">is-invalid</c:if>"
                                       value="${form.addressLine1}">
                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('addressLine1')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('addressLine1')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="addressLine2Id" class="col-form-label">Address Line 2</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="addressLine2Id"
                                       name="addressLine2"
                                       class="form-control
                                            <c:if test="${bindingResult.hasFieldErrors('addressLine2')}">is-invalid</c:if>"
                                       value="${form.addressLine2}">
                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('addressLine2')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('addressLine2')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="cityId" class="col-form-label">City</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="cityId"
                                       name="city"
                                       class="form-control
                                            <c:if test="${bindingResult.hasFieldErrors('city')}">is-invalid</c:if>"
                                       value="${form.city}">
                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('city')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('city')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="stateId" class="col-form-label">State</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="stateId"
                                       name="state"
                                       class="form-control
                                                <c:if test="${bindingResult.hasFieldErrors('state')}">is-invalid</c:if>"
                                       value="${form.state}">
                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('state')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('state')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="postalCodeId" class="col-form-label">Postal Code</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="postalCodeId"
                                       name="postalCode"
                                       class="form-control
                                            <c:if test="${bindingResult.hasFieldErrors('postalCode')}">is-invalid</c:if>"
                                       value="${form.postalCode}">
                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('postalCode')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('postalCode')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="countryId" class="col-form-label">Country</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="countryId"
                                       name="country"
                                       class="form-control
                                            <c:if test="${bindingResult.hasFieldErrors('country')}">is-invalid</c:if>"
                                       value="${form.country}">
                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('country')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('country')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="creditLimitId" class="col-form-label">Credit Limit</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="creditLimitId"
                                       name="creditLimit"
                                       class="form-control
                                            <c:if test="${bindingResult.hasFieldErrors('creditLimit')}">is-invalid</c:if>"
                                       value="${form.creditLimit}">
                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('creditLimit')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('creditLimit')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="salesRepEmployeeIdId" class="col-form-label">Sales Representative</label>
                            </div>

                            <div class="col-4">
                                <select id="salesRepEmployeeIdId" name="salesRepEmployeeId" class="form-control" >
                                    <c:forEach items="${employeesKey}" var="employee">
                                        <option
                                            value="${customer.salesRepEmployeeId}"
                                            <c:if test="${customer.salesRepEmployeeId == form.salesRepEmployeeId}">selected</c:if>
                                            >
                                                ${employee.firstName} ${employee.lastName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

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