<%@include file="./common/header.jspf" %>
	<section class="section1" id="sec2">
        <h2 class="text-center text-uppercase pt-5">Medicine Demand</h2>
        <div class="container w-50">
            <table class="table table-hover table-bordered">
                <thead>
                    <tr>
                    <th>Medicine</th>
					<th>Demand Count</th>
                    </tr>
                </thead>
                <tbody>
				    <c:forEach items="${medicineDemandList}" var="medicineDemand">
						<tr>
							<td class="col-right">${medicineDemand.medicineName}</td>
							<td class="col-right">${medicineDemand.demandCount}</td>
						</tr>
					</c:forEach>
                </tbody>
            </table>
        </div>
    </section>
<%@include file="./common/footer.jspf" %>