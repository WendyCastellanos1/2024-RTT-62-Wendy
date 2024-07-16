<!-- goes at TOP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../include/header.jsp" />

<!-- a page header -->
<section style="background-color:orange">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Order Detail(s) for Order: ${orderIdKey}</h1>
        </div>
    </div>
</section>


<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <div class="col-12">
                <!-- count of order detail (rows) in the list -->
                <h4 class="text-center">${orderDetailsKey.size()} result(s)</h4>
            </div>
        </div>

        <div class="row">
            <div class ="col-12">
                <table class="table">

                    <!-- header row for order detail list -->
                    <tr>
                        <th><b>Id</b></th>
                        <th><b>Order Id</b></th>
                        <th><b>Product Id</b></th>
                        <th><b>Quantity Ordered</b></th>
                        <th><b>Price Each</b></th>
                        <th><b>Order Line Number</b></th>
                    </tr>

                    <!-- loop to print rows in order detail list -->
                    <c:forEach items="${orderDetailsKey}" var="orderDetail">
                        <tr>
                            <td>${orderDetail.id}</td>
                            <td><a href="../order/${orderDetail.orderId}">${orderDetail.orderId}</a></td>
                            <td><a href="../product/${orderDetail.productId}">  ${orderDetail.productId}   </a>   </td>
                            <td>${orderDetail.quantityOrdered}</td>
                            <td>${orderDetail.priceEach}</td>
                            <td>${orderDetail.orderLineNumber}</td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />