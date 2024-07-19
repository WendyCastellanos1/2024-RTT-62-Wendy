<!-- goes at TOP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../include/header.jsp" />


<!-- a page header -->
<section style="background-color:orange">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1>
                <c:if test="${empty form.id}">
                    <h1 class="text-center">Create Employee</h1>
                </c:if>
                <c:if test="${not empty form.id}">
                    <h1 class="text-center">Edit Employee</h1>
                </c:if>
            </h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5 ">
            <div class="col-12">
                <form action="/employee/createSubmit">
                    <input type="hidden" name="id" value="${form.id}">  <!-- id is the employee id -->

                    <!-- email input -->
                    <div class="row align-items-center justify-content-center">
                        <div class="col-2">
                            <label for="emailId" class="col-form-label">Email</label>
                        </div>
                        <div class="col-4">
                            <input type="text"
                                   id="emailId"
                                   name="email"
                                   class="form-control
                                        <c:if test="${bindingResult.hasFieldErrors('email')}">is-invalid</c:if>"
                                   value="${form.email}" >
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('email')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>

                    <!-- firstName input field -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="firstNameId" class="col-form-label">First Name</label>
                        </div>
                        <div class="col-4">
                            <input type="text"
                                   id="firstNameId"
                                   name="firstName"
                                   class="form-control
                                           <c:if test="${bindingResult.hasFieldErrors('firstName')}">is-invalid</c:if>"
                                   value="${form.firstName} ">
                        </div>
                    </div>

                    <c:if test="${bindingResult.hasFieldErrors('firstName')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div style="color:red">
                                    <c:forEach items="${bindingResult.getFieldErrors('firstName')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>

                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="lastNameId" class="col-form-label">Last Name</label>
                        </div>
                        <div class="col-4">
                            <input type="text"
                                   id="lastNameId"
                                   name="lastName"
                                   class="form-control
                                        <c:if test="${bindingResult.hasFieldErrors('lastName')}">is-invalid</c:if>"
                                   value="${form.lastName} ">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('lastName')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div style="color:red">
                                    <c:forEach items="${bindingResult.getFieldErrors('lastName')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>

                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="reportsTo" class="col-form-label">Reports To</label>
                        </div>
                        <div class="col-4">
                            <select id="reportsTo"
                                    name="reportsTo"
                                    class="form-control">
                                        <c:forEach items ="${employeesKey}" var="employee">
                                            <option
                                                    value="${employee.id}"
                                                    <c:if test="${employee.reportsTo == form.reportsTo}">selected</c:if>
                                            >
                                                    ${employee.firstName} ${employee.lastName}
                                            </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="officeId" class="col-form-label">Office</label>
                        </div>
                        <div class="col-4">
                            <select id="officeId"
                                    name="officeId"
                                    class="form-control">
                                        <c:forEach items="${officesKey}" var="office">
                                            <option
                                                    value="${office.id}"
                                                    <c:if test="${office.id == form.officeId}">selected</c:if>
                                            >
                                                    ${office.city}
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
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>