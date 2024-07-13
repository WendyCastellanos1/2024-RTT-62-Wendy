<!-- goes at TOP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<!-- page header -->
<section style="background-color:orange">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Order Search</h1>
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
                        <label for="search" class="form-label"><h4>Enter the order ???: </h4></label>
                        <input type="text" value="${searchKey}" class="form-control" id="search" name="search" placeholder="Enter search term"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Search</button>
                </form>
            </div>
        </div>
    </div>
</section>

<!-- count of orders in the list; section>container>one row>one column w/h4; another row w/column headers; x row(s) with employees -->
<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <div class="col-12">
                <h4 class="text-center"> ${ordersKey.size()} result(s)</h4>
            </div>
        </div>

        <!-- show the rows of orders -->
        <div class="row">
            <div class ="col-12">
                <table class="table">
                    <tr>
                        <th><b>Id</b></th>
                        <th><b>Customer Id</b></th>
                        <th><b>Order Date</b></th>
                        <th><b>Shipped Date</b></th>
                        <th><b>Date Required</b></th>
                        <th><b>Status</b></th>
                        <th><b>Comments</b></th>
                        <th><b>Order Details</b></th>
                    </tr>

                    <c:forEach items="${ordersKey}" var="order">
                        <tr>
                            <td>${order.id}</td>
                            <td><a href="../customer/${order.customerId}">${order.customerId}</a></td>
                            <td>${order.orderDate}</td>
                            <td>${order.shippedDate}</td>
                            <td>${order.dateRequired}</td>
                            <td>${order.status}</td>
                            <td>${order.comments}</td>
                            <td><i>order details</i></td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />