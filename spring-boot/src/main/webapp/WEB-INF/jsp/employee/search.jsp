<!-- header include -->
<jsp:include page="../include/header.jsp" />

<!-- page header -->
<section style="background-color:orange">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Employee Search</h1>
        </div>
    </div>
</section>

<!-- search form; section>container>one row>one column>form w/label and input, button -->
<section>
    <div class="container">
        <div class="row justify-content-center pt-5 pb-3">
            <div class="col-8 text-center">
                <form action="/employee/search">
                    <div class="mb-3">
                        <label for="search" class="form-label"><h4>Enter a first name, last name, or job title: </h4></label>
                        <input type="text" value="${searchToken}" class="form-control" id="search" name="search" placeholder="Enter search term"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Search</button>
                </form>
            </div>
        </div>
    </div>
</section>


<!-- count of products in the list; section>container>one row>one column w/h4; another row w/column headers; x row(s) with employees -->
<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <div class="col-12">
                <h4 class="text-center"> ${employeesToken.size()} result(s)</h4>
            </div>
        </div>

        <!-- show the rows of products -->
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

                    <c:forEach items="${employeesToken}" var="employee">
                        <tr>
                            <td><a href="/employee/detail?id=${employee.id}">${employee.id}</a></td>
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