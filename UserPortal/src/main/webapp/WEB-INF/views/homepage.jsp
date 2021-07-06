<%@include file="./common/header.jspf" %>
    <section class="section1">
        <h2 class="text-center text-uppercase pt-3">HomePage</h2>
        <div class="row">
            <div class="col-12 col-md-2"></div>
            <div class="col-12 col-md-8">
                <div class="row">
                    <div class="col-12 d-flex justify-content-center">
                        <div class="homepart">
                            <div class="card w-50 m-2">
                                <img src="../static/calender.jpg" alt="calender" class="card-img-top">
                                <div class="card-body">
                                    <h4 class="card-title">Medical Representatives</h4>
                                    <p class="card-text">Click here to view medical representatives schedule for doctors visit.</p>
                                    <a accesskey="r" href="/pharmacy/schedule" class="btn btn-block">Medical <u>R</u>epresentative</a>
                                </div>
                            </div>
                            <div class="card w-50 m-2">
                                <img src="../static/warehouse.jpg" alt="warehouse" class="card-img-top">
                                <div class="card-body">
                                    <h4 class="card-title">Medicine Stock</h4>
                                    <p class="card-text">Click here to view detailed list of medicines present in stock</p>
                                    <a accesskey="s" href="/pharmacy/medicineStock" class="btn btn-block">Medicine <u>S</u>tock</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-2"></div>
        </div>
    </section>
<%@include file="./common/footer.jspf" %>