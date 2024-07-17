<!-- goes at TOP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../include/header.jsp" />


<!-- a page header -->
<section style="background-color:orange">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Create Employee</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5 justify-content-center">
            <div class="col-12">
                <form action="/employee/createSubmit">

                    <div class="row align-items-center pb-3">

                        div>
                        <label for="emailId" class="col-form-label">Email</label>
                        <input type="text" id="emailId" name="email"
                               class="form-control <c:if test="${bindingResult.hasFieldErrors('email')}">is-invalid</c:if>"
                               value="${form.email}">
                        <c:if test="${bindingResult.hasFieldErrors('email')}">
                            <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                                <div class="text-danger">${error.defaultMessage}</div>
                            </c:forEach>
                        </c:if>
                    </div>

                        <div class="row align-items-center justify-content-center pb-3">
                            <div class="col-2">
                                <label for="firstNameId" class="col-form-label">First Name</label>
                            </div>
                            <div class="col-auto">
                                <input type="text" id="firstNameId" name="firstName" class="form-control" value="${form.firstName}>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pb-3">
                            <div class="col-2">
                                <label for="lastNameId" class="col-form-label">Last Name</label>
                            </div>
                            <div class="col-auto">
                                <input type="text" id="lastNameId" name="lastName" class="form-control" value="${form.lastName}>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pb-3">
                            <div class="col-2">
                                <label for="extensionId" class="col-form-label">Extension</label>
                            </div>
                            <div class="col-auto">
                                <input type="text" id="extensionId" name="extension" class="form-control">
                            </div>
                        </div>

                        <div class="row align-items-center pb-3">
                            <div class="col-2">
                                <label for="jobTitleId" class="col-form-label">Job Title</label>
                            </div>
                            <div class="col-auto">
                                <input type="text" id="jobTitleId" name="jobTitle" class="form-control">
                            </div>
                        </div>

                        <div class="row align-items-center pb-3">
                            <div class="col-2">
                                <label for="vacationHoursId" class="col-form-label">Vacation Hours</label>
                            </div>
                            <div class="col-auto">
                                <input type="text" id="vacationHoursId" name="vacationHours" class="form-control">
                            </div>
                        </div>

                        <div class="row align-items-center pb-3">
                            <div class="col-2">
                                <label for="profileImageUrlId" class="col-form-label">Profile Image URL</label>
                            </div>
                            <div class="col-auto">
                                <input type="text" id="profileImageUrlId" name="profileImageUrl" class="form-control">
                            </div>
                        </div>

                        <div class="row align-items-center pb-3">
                            <div class="col-2">
                                <label for="reportsToId" class="col-form-label">Reports To</label>
                            </div>

                            <div class="col-4">
                                <select id="reportsToId" name="reportsTo" class="form-control">
                                    <c:forEach items="${reportsToEmployeesKey}" var="employee">
                                        <option
                                                value="${employee.id}"
                                                <c:if test="${employee.id} == form.reportsTo">selected></c:if>>
                                                ${employee.firstName} ${employee.lastName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row align-items-center justify-content-center pb-3>
                            <div class="col-2">
                                <label for="officeId" class="col-form-label">Office</label>
                            </div>
                            <div class="col-4">
                                <select id="officeId" anem="officeId" class = "form-control">
                                    <c:forEach items="${officesKey}" var="office">
                                        <option value="${office.id}"
                                        <c:if test="${office.id == form.officeId}">selected</c:if>
                                        >
                                            ${office.city}
                                        </option>
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