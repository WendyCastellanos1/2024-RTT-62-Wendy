<jsp:include page="../include/header.jsp" />

<!-- a page header -->
<section style="background-color:orange">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Employee:  ${employeeKey.firstName} ${employeeKey.lastName}  </h1>
        </div>
    </div>
</section>

<!-- product detail for one product -->
<table class="table">
    <tr><td><b>Id</b></td>  <td>${employeeKey.id}</td></tr>
    <tr><td><b>Office Id</b></td>  <td>${employeeKey.officeId}</td></tr>
    <tr><td><b>Last Name</b></td>  <td>${employeeKey.lastName}</td></tr>
    <tr><td><b>First Name</b></td>  <td>${employeeKey.firstName}</td></tr>
    <tr><td><b>Extension</b></td>  <td>${employeeKey.extension}</td></tr>
    <tr><td><b>Email</b></td>  <td>${employeeKey.email}</td></tr>
</table>

<div>
    <a href="/employees">View the master employee list</a>
    <br>
    <a href="/search-employees">Search for more employees</a>
</div>

<jsp:include page="../include/footer.jsp" />