<jsp:include page="../include/header.jsp" />

<!-- a page header -->
<section style="background-color:orange">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Employee:  ${employeeToken.firstName} ${employeeToken.lastName}  </h1>
        </div>
    </div>
</section>

<!-- product detail for one product -->
<table class="table">
    <tr><td><b>Id</b></td>  <td>${employeeToken.id}</td></tr>
    <tr><td><b>Office Id</b></td>  <td>${employeeToken.officeId}</td></tr>
    <tr><td><b>Last Name</b></td>  <td>${employeeToken.lastName}</td></tr>
    <tr><td><b>First Name</b></td>  <td>${employeeToken.firstName}</td></tr>
    <tr><td><b>Extension</b></td>  <td>${employeeToken.extension}</td></tr>
    <tr><td><b>Email</b></td>  <td>${employeeToken.email}</td></tr>
</table>

<div>
    <a href="/employee/list">View the employee list</a>
    <br>
    <a href="/employee/search">Search for employees</a>
</div>

<jsp:include page="../include/footer.jsp" />