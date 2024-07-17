<!-- goes at TOP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../include/header.jsp" />


<!-- a page header -->
<section style="background-color:orange">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Create Customer</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5 justify-content-center">
            <div class="col-12">
                <form action="/customer/createSubmit">
                    <div class="row align-items-center pb-3">

                        <div class="row align-items-center pb-3">
                            <div class="col-2">
                                <label for="customerNameId" class="col-form-label">Customer Name</label>
                            </div>
                            <div class="col-auto">
                                <input type="text" id="customerNameId" name="customerName" class="form-control">
                            </div>
                        </div>

                        <div class="row align-items-center pb-3">
                            <div class="col-2">
                                <label for="contactFirstNameId" class="col-form-label">Contact First Name</label>
                            </div>
                            <div class="col-auto">
                                <input type="text" id="contactFirstNameId" name="contactFirstName" class="form-control">
                            </div>
                        </div>

                        <div class="row align-items-center pb-3">
                            <div class="col-2">
                                <label for="contactLastNameId" class="col-form-label">Contact Last Name</label>
                            </div>
                            <div class="col-auto">
                                <input type="text" id="contactLastNameId" name="contactLastName" class="form-control">
                            </div>
                        </div>

                        <div class="row align-items-center pb-3">
                            <div class="col-2">
                                <label for="phoneId" class="col-form-label">Phone</label>
                            </div>
                            <div class="col-auto">
                                <input type="text" id="phoneId" name="phone" class="form-control">
                            </div>
                        </div>

                        <div class="row align-items-center pb-3">
                            <div class="col-2">
                                <label for="addressLine1Id" class="col-form-label">Address Line 1</label>
                            </div>
                            <div class="col-auto">
                                <input type="text" id="addressLine1Id" name="addressLine1" class="form-control">
                            </div>
                        </div>

                        <div class="row align-items-center pb-3">
                            <div class="col-2">
                                <label for="addressLine2Id" class="col-form-label">Address Line 2</label>
                            </div>
                            <div class="col-auto">
                                <input type="text" id="addressLine2Id" name="addressLine2" class="form-control">
                            </div>
                        </div>

                        <div class="row align-items-center pb-3">
                            <div class="col-2">
                                <label for="cityId" class="col-form-label">City</label>
                            </div>
                            <div class="col-auto">
                                <input type="text" id="cityId" name="city" class="form-control">
                            </div>
                        </div>

                        <div class="row align-items-center pb-3">
                            <div class="col-2">
                                <label for="stateId" class="col-form-label">State</label>
                            </div>
                            <div class="col-auto">
                                <input type="text" id="stateId" name="state" class="form-control">
                            </div>
                        </div>

                        <div class="row align-items-center pb-3">
                            <div class="col-2">
                                <label for="countryId" class="col-form-label">Country</label>
                            </div>
                            <div class="col-auto">
                                <input type="text" id="countryId" name="country" class="form-control">
                            </div>
                        </div>
                        <div class="row align-items-center pb-3">
                            <div class="col-2">
                                <label for="creditLimitId" class="col-form-label">Credit Limit</label>
                            </div>
                            <div class="col-auto">
                                <input type="text" id="creditLimitId" name="creditLimit" class="form-control">
                            </div>
                        </div>

                        <div class="row align-items-center pb-3">
                            <div class="col-2">
                                <label for="salesRepEmployeeIdId" class="col-form-label">Sales Representative</label>
                            </div>

                            <div class="col-2">
                                <select id="salesRepEmployeeIdId" name="salesRepEmployeeId" class="form-control">
                                    <c:forEach items="${EmployeesKey}" var="employee">
                                        <option value="${employee.id}">${employee.firstName} ${employee.lastName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="row justify-content-center">
                            <div class="col-auto">
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