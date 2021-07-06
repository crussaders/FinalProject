<%@include file="./common/header.jspf" %>
	<section class="section1" id="sec2">
        <h2 class="text-center text-uppercase pt-5">Place Order</h2>
        <div class="container">
            <table class="table table-hover table-bordered">
                <thead>
                    <tr>
                    <th>Pharmacy Name</th>
					<th>Medicine Name</th>
					<th>Supply Count</th>
                    </tr>
                </thead>
                <tbody>
				    <c:forEach items="${medicineSupplyList}" var="medicineSupply">
						<tr>
							<td class="col-right">${medicineSupply.pharmacyName}</td>
							<td class="col-right">${medicineSupply.medicineName}</td>
							<td class="col-right">${medicineSupply.supplyCount}</td>
						</tr>
					</c:forEach>
                </tbody>
            </table>
        </div>
    </section>
<%@include file="./common/footer.jspf" %>