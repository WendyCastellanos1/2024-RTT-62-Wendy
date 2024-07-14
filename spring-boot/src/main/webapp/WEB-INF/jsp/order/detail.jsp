<!-- goes at TOP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<!-- a page header -->
<section style="background-color:orange">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Order:  ${orderKey.orderId}</h1>
        </div>
    </div>
</section>

<!-- order summary for one order -->
<section>
    <div class="container">
        <div class="table">
            <div class="row">
                <div class="col-12">
                    <table class="table">
                        <tr><td><b>Id</b></td>              <td>${orderKey.id}</td>                </tr>
                        <tr><td><b>Customer Id</b></td>     <td>${orderKey.customerId}</td>        </tr>
                        <tr><td><b>Order Date</b></td>      <td>${orderKey.orderDate}</td>         </tr>
                        <tr><td><b>Shipped Date</b></td>    <td>${orderKey.shippedDate}</td>       </tr>
                        <tr><td><b>Date Required</b></td>   <td>${orderKey.dateRequired}</td>      </tr>
                        <tr><td><b>Status</b></td>          <td>${orderKey.status}}</td>           </tr>
                        <tr><td><b>Comments</b></td>        <td>${orderKey.comments}</td>          </tr>
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