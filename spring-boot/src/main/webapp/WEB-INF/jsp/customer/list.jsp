<!-- goes at TOP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<!-- a page header -->
<section style="background-color:orange">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Customer List</h1>
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
                            <td><i>orders</i></td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </div>
    </div>
</section>


<jsp:include page="../include/footer.jsp" />