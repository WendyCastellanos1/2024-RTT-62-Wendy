<!-- goes at TOP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<!-- a page header -->
<section style="background-color:orange">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Order:  ${orderKey.id}</h1>
        </div>
    </div>
</section>

<!-- order summary for one order -->
<section>
    <div class="container">
        <div class="table">
            <div class="row">
                <div class="col-8">
                    <table class="table">
                        <tr><td><b>Order Id</b></td>              <td>${orderKey.id}</td>                </tr>
                        <tr><td><b>Customer Id</b></td>     <td><a href="../customer/${orderKey.customerId}">${orderKey.customerId}</a></td> </tr>
                        <tr><td><b>Order Date</b></td>      <td>${orderKey.orderDate}</td>         </tr>
                        <tr><td><b>Shipped Date</b></td>    <td>${orderKey.shippedDate}</td>       </tr>
                        <tr><td><b>Required Date</b></td>   <td>${orderKey.requiredDate}</td>      </tr>
                        <tr><td><b>Status</b></td>          <td>${orderKey.status}</td>            </tr>
                        <tr><td><b>Comments</b></td>        <td>${orderKey.comments}</td>          </tr>
                        <tr><td><b>Order Details</b></td>   <td>${orderDetailsKey.size()} result(s)</td>   </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>
<section>
    <div class="container">

        <div class="row">
            <div class ="col-6">
                <table class="table">

                    <!-- header row for order detail list -->
                    <tr>
                        <th><b>Order Line Number</b></th>
                        <th><b>Product Id</b></th>
                        <th><b>Product Name</b></th>
                        <th><b>Quantity Ordered</b></th>
                        <th><b>Price Each</b></th>
                        <th><b>Order Detail Id</b></th>
                    </tr>

                    <!-- loop to print rows in order detail list -->
                    <c:forEach items="${orderDetailsKey}" var="orderDetail">
                        <tr>
                            <td>${orderDetail.orderLineNumber}</td>
                            <td><a href="../product/${orderDetail.productId}">  ${orderDetail.productId}   </a>   </td>
                            <td><a href="../product/${orderDetail.productId}">  ${orderDetail.productName}   </a></td>
                            <td>${orderDetail.quantityOrdered}</td>
                            <td>${orderDetail.priceEach}</td>
                            <td>${orderDetail.id}</td>
                        </tr>
                    </c:forEach>

                </table>
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
                                <a href="../order/list">View all orders</a>
                                <br>
                                <a href="../order/search">Search for orders</a>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>


<jsp:include page="../include/footer.jsp" />