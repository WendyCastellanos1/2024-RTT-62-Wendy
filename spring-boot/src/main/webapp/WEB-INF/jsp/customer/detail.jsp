<!-- goes at TOP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<!-- a page header -->
<section style="background-color:orange">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Customer:  ${customerKey.customerName}</h1>
        </div>
    </div>
</section>

<!-- customer detail for one customer -->
<section>
    <div class="container">
        <div class="table">
            <div class="row">
                <div class="col-12">
                    <table class="table">
                        <tr><td><b>Id</b></td>                       <td>${customerKey.id}</td>                </tr>
                        <tr><td><b>Name</b></td>                     <td>${customerKey.customerName}</td>      </tr>
                        <tr><td><b>Contact First Name</b></td>       <td>${customerKey.contactFirstName}</td>  </tr>
                        <tr><td><b>Contact Last Name</b></td>        <td>${customerKey.contactLastName}</td>  </tr>
                        <tr><td><b>Phone</b></td>                    <td>${customerKey.phone}</td>               </tr>
                        <tr><td><b>Sales Rep Employee ID</b></td>    <td><a href="../employee/${customerKey.salesRepEmployeeId}">${customerKey.salesRepEmployeeId}</a></td> </tr>
                        <tr><td><b>Customer's Orders</b></td>        <td><a href="../order/list-by-customer?id=${customerKey.id}">orders</a></td></tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- links at bottom of page -->
<section>
    <div class="container">
        <div class="table">
            <div class="row">
                <div class="col-12">
                    <table class="table">
                        <tr>
                            <td>
                                <a href="../customer/list">View all customers</a>
                                <br>
                                <a href="../customer/search">Search for customers</a>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>



<jsp:include page="../include/footer.jsp" />