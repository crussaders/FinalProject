<%@include file="./common/header.jspf" %>
	<section class="section1" id="sec2">
        <h2 class="text-center text-uppercase pt-5">Medical Representatives Schedule</h2>
        <div class="row">
            <div class="col-12 col-md-4"></div>
            <div class="col-12 col-md-4">
                <div class="card w-100 m-2">
                    <img src="../static/calender.jpg" alt="calender" class="card-img-top">
                    <div class="card-body">
                        <h4 class="card-title">Select Date</h4>
                        <p class="card-text">To view the schedule of the representatives</p>
                        
				<form action="/pharmacy/createSchedule" method="post">
						<div style="color: red; margin: 20px">
							<c:choose>
								<c:when test="${errorMessage}">
								Please Enter today's / upcoming date
								</c:when>
							</c:choose>
						</div>
                            <div class="form-group">
                                <label for="date">Date of meeting</label>
                                <input type="date" name="scheduleStartDate" class="form-control" required>
                            </div>
                            <button accesskey="s" type="submit" class="btn btn-block">View <u>S</u>chedule</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-4"></div>
        </div>
    </section>
<%@include file="./common/footer.jspf" %>