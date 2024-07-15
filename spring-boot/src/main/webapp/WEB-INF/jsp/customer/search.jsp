<!-- goes at TOP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<!-- page header -->
<section style="background-color:orange">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Customer Search</h1>
        </div>
    </div>
</section>

<!-- search form; section>container>one row>one column>form w/label and input, button -->
<section>
    <div class="container">
        <div class="row justify-content-center pt-5 pb-3">
            <div class="col-8 text-center">
                <form action="../customer/search">
                    <div class="mb-3">
                        <label for="search" class="form-label"><h4>Enter the customer name: </h4></label>
                        <input type="text" value="${searchKey}" class="form-control" id="search" name="search" placeholder="Enter search term"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Search</button>
                </form>
            </div>
        </div>
    </div>
</section>

<!-- count of customers in the list; section>container>one row>one column w/h4; another row w/column headers; x row(s) with employees -->
<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <div class="col-12">
                <h4 class="text-center"> ${customersKey.size()} result(s)</h4>
            </div>
        </div>

        <!-- show the rows of customers -->
        <div class="row">
            <div class ="col-12">
                <table class="table">
                    <tr>
                        <th><b>Id</b></th>
                        <th><b>Customer Name</b></th>
                        <th><b>Contact First Name</b></th>
                        <th><b>Contact Last Name</b></th>
                        <th><b>Phone</b></th>
                        <th><b>Sales Rep Employee Id</b></th>
                        <th><b>Orders</b></th>
                    </tr>

                    <c:forEach items="${customersKey}" var="customer">
                        <tr>
                            <td>${customer.id}</td>
                            <td><a href="../customer/${customer.id}">${customer.customerName}</a></td>
                            <td>${customer.contactFirstName}</td>
                            <td>${customer.contactLastName}</td>
                            <td>${customer.phone}</td>
                            <td><a href="../employee/${customer.salesRepEmployeeId}">${customer.salesRepEmployeeId}</a></td>
                            <td><a href="../order/list-by-customer?id=${customer.id}&name=${customer.customerName}">orders</a></td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />