<%@include file="./header_footer/header.jsp" %>
				<div class="col-sm-10">
					<div class="content-viewactivity">
						<p>List of Agendas</p>
						<br> <br>
						<table>
							<thead>
								<tr>
									<th>Activity Name</th>
									<th>Activity Description</th>
									<th>Start Date</th>
									<th>End Date</th>
									<th>State of the activity</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="act" items="${listedactivities}">
									<tr>
										<td><c:out value="${act.tittle}" /></td>
										<td><c:out value="${act.description}" /></td>
										<td><c:out value="${act.startDate}" /></td>
										<td><c:out value="${act.endDate}" /></td>
										<td><c:out value="${act.status}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
<%@include file="./header_footer/footer.jsp" %>