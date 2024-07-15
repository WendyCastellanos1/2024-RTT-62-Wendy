<!-- goes at TOP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../include/header.jsp" />

<!-- a page header -->
<section style="background-color:orange">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Employees</h1>
        </div>
    </div>
</section>

<!-- count of products in the list; section>container>one row>one column w/h4; another row w/column headers; x row(s) with employees -->
<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <div class="col-12">
                <h4 class="text-center"> ${employeesKey.size()} result(s)</h4>
            </div>
        </div>
        <div class="row">
            <div class ="col-12">
                <table class="table">
                    <tr>
                        <th><b>Id</b></th>
                        <th><b>Office Id</b></th>
                        <th><b>Job Title</b></th>
                        <th><b>Last Name</b></th>
                        <th><b>First Name</b></th>
                        <th><b>Extension</b></th>
                        <th><b>Email</b></th>
                    </tr>

                    <c:forEach items="${employeesKey}" var="employee">
                        <tr>
                            <td><a href="../employee/${employee.id}">${employee.id}</a></td>
                            <td>${employee.officeId}</td>
                            <td>${employee.jobTitle}</td>
                            <td>${employee.lastName}</td>
                            <td>${employee.firstName}</td>
                            <td>${employee.extension}</td>
                            <td>${employee.email}</td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </div>
    </div>
</section>


<jsp:include page="../include/footer.jsp" />