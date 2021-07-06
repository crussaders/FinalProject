<%@include file="./common/header.jspf" %>
	 <section class="section1" id="sec2">
        <h2 class="text-center text-uppercase pt-5">Representatives Schedule</h2>
        <div class="container">
            <table class="table table-hover table-bordered">
                <thead>
                    <tr>
                    <th>Id</th>
                    <th>Representative Name</th>
                    <th>Doctor</th>
                    <th>Treating</th>
                    <th>Medicine</th>
                    <th>Meeting</th>
                    <th>Date Of Meeting</th>
                    <th>Doctor Contact No.</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${repScheduleList}" var="repSchedule">
						<tr>
							<td>${repSchedule.id}</td>
							<td>${repSchedule.representativeName}</td>
							<td>${repSchedule.doctorName}</td>
							<td>${repSchedule.treatingAilment}</td>
							<td>${repSchedule.medicines}</td>
							<td>${repSchedule.meetingSlot}</td>
							<td>${repSchedule.meetingDate}</td>
							<td>${repSchedule.doctorContactNumber}</td>
						</tr>
					</c:forEach>
                </tbody>
            </table>
             <a href="/pharmacy/medicineDemand" class="btn">Place Order</a><br>
        </div>
    </section>
<%@include file="./common/footer.jspf" %>