<jsp:include page = "include/header.jsp" />

    <!-- a page header -->
    <section style="background-color:orange">
        <div class="container">
            <div class="row pt-5 pb-5">
                <h1 class="text-center">Home</h1>
            </div>
        </div>
    </section>
    <br>

    <div>"
        <h2 class="text-center">${message}</h2>
    </div>
    <br>
    <div>
        <h4 class="text-center"><a href="/product/search">Search for products</a></h4>
        <br>
        <h4 class="text-center"><a href="/product/list">View all products</a></h4>
        <br>
        <h4 class="text-center"><a href="/employee/search">Search for an employee</a></h4>
    </div>


<jsp:include page = "include/footer.jsp" />