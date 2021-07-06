<%@include file="./common/header.jspf" %>
	    <section class="section1" id="sec2">
        <div class="container">
            <h2 class="text-center text-uppercase pt-5">Place Order</h2>
            <div class="row">
                <div class="col-12 col-md-2"></div>
                <div class="col-12 col-md-8">
                    <div class="row demand">
                        <div class="col-12 col-md-6">
                            <img src="../static/cart.png" alt="cart">
                        </div>
                        <div class="col-12 col-md-6 ">
                            <h3>Enter Details</h3>
                            <p>Fill in the required details below.</p>
                            <form action="/pharmacy/getMedicineSupply" method="post"
									onsubmit="return validate();">
                                <div class="form-group">
                                    <label for="med">Medicine</label>
                                    <select id="medicineName" name="medicineName" class="form-control" required>
                                        <option value="Remdesivir">Remdesivir</option>
										<option value="Gaviscon">Gaviscon</option>
										<option value="DoloKind">DoloKind</option>
										<option value="Aspirin">Aspirin</option>
										<option value="Ecosprin">Ecosprin</option>
										<option value="OxyContin">OxyContin</option>
					
                                    </select>
                                </div>
                                <div style="color: red; margin: 20px">
								<c:choose>
									<c:when test="${errorMessage}">
									Value Should be Greater than zero
									</c:when>
								</c:choose>
								</div>
                                <div class="form-group">
                                    <label for="demandCount">Demand Count</label>
                                    <input type="number" id="demandCount" name="demandCount" class="form-control" required placeholder="Enter value">
                                </div>
                                <button type="submit" class="btn">Submit</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-2"></div>
            </div>
        </div>
    </section>
<%@include file="./common/footer.jspf" %>