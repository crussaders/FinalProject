<%@include file="./common/header.jspf" %>
	<section class="section1" id="sec2">
        <h2 class="text-center text-uppercase pt-5">Medicine Stock</h2>
        <div class="container">
            <table class="table table-hover table-bordered">
                <thead>
                    <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Chemical Composition</th>
                    <th>Target Ailment</th>
                    <th>Pharmacy Name</th>
                    <th>Date Of Expiry</th>
                    <th>Stock</th>
                    </tr>
                </thead>
                <tbody>
		            <c:forEach items="${medicineStockList}" var="medicineStock">
						<tr>
							<td>${medicineStock.id}</td>
							<td>${medicineStock.name}</td>
							<td>${medicineStock.chemicalComposition}</td>
							<td>${medicineStock.targetAilment}</td>
							<td>${medicineStock.pharmacyName}</td>
							<td>${medicineStock.dateOfExpiry}</td>
							<td class="text-center">${medicineStock.numberOfTabletsInStock}</td>
						</tr>
					</c:forEach>
                </tbody>
            </table>
        </div>
    </section>
<%@include file="./common/footer.jspf" %>