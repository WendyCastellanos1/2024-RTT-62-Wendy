<!-- goes at TOP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<!-- a page header -->
<section style="background-color:orange">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Employee:  ${employeeKey.firstName} ${employeeKey.lastName}  </h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="table">
            <div class="row">
                <div class="col-12">
                    <!-- employee detail for one employee -->
                    <table class="table">
                        <tr><td><b>Id</b></td>                  <td>${employeeKey.id}</td></tr>
                        <tr><td><b>Office Id</b></td>           <td>${employeeKey.officeId}</td></tr>
                        <tr><td><b>Last Name</b></td>           <td>${employeeKey.lastName}</td></tr>
                        <tr><td><b>First Name</b></td>          <td>${employeeKey.firstName}</td></tr>
                        <tr><td><b>Extension</b></td>           <td>${employeeKey.extension}</td></tr>
                        <tr><td><b>Email</b></td>               <td>${employeeKey.email}</td></tr>
                        <tr><td><b>Assigned Customers:  ${customersKey.size()} result(s)</b></td>       <td></td></tr>
                         <tr>
                             <section>
                                 <div class="container">

                                     <div class="row">
                                         <div class ="col-12">
                                             <table class="table">
                                                 <tr>
                                                     <th><b>Id</b></th>
                                                     <th><b>Customer Name</b></th>
                                                     <th><b>Contact First Name</b></th>
                                                     <th><b>Contact Last Name</b></th>
                                                     <th><b>Phone</b></th>
                                                     <th><b>Orders</b></th>
                                                 </tr>

                                                 <c:forEach items="${customersKey}" var="customer">
                                                     <tr>
                                                         <td>${customer.id}</td>
                                                         <td><a href="../customer/${customer.id}">${customer.customerName}</a></td>
                                                         <td>${customer.contactFirstName}</td>
                                                         <td>${customer.contactLastName}</td>
                                                         <td>${customer.phone}</td>
                                                         <td><a href="../order/list-by-customer?id=${customer.id}&name=${customer.customerName}">orders</a></td>
                                                     </tr>
                                                 </c:forEach>

                                             </table>
                                         </div>
                                     </div>
                                 </div>
                             </section>
                         </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- count of customers in the list; section>container>one row>one column w/h4; another row w/column headers; x row(s) with employees -->



<!-- links at bottom of page -->
<section>
    <div class="container">
        <div class="table">
            <div class="row">
                <div class="col-12">
                    <table class="table">
                        <tr>
                            <td>
                                <a href="../employee/list">View all employees</a>
                                <br>
                                <a href="../employee/search">Search for employees</a>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>


<jsp:include page="../include/footer.jsp" />