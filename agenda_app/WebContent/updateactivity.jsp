
<%@include file="./header_footer/header.jsp" %>
				<div class="col-sm-10">
					<div class="content-updateactivity">
						<p>Activities to update</p>
						<br> <br>
						<table>
							<thead>
								<tr>
									<th>Activity Name</th>
									<th>Activity Description</th>
									<th>Start Date</th>
									<th>End Date</th>
									<th>State of the activity</th>
									<th>Action</th>

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
										<td class="button-data">
											<!--Getting an ID for a specific activity to allow selection for Update and deletion
											by passing data to from this jsp another JSP
										<a
											href="updateactivitypage.jsp?id=<c:out value="${act.id}"/>">
												<button class="update-button" class="btn btn-success">Update</button>
										</a>/ -->
										<!--Getting an ID for a specific activity to allow selection for Update and deletion
											by passing data from this jsp to a servlet-->
											<a
											href="updateactivitypage?id=<c:out value="${act.id}"/>">
												<button class="update-button" class="btn btn-success">Update</button>
										</a>/ 
										<a
											href="<%=request.getContextPath()%>/delete?id=<c:out value="${act.id}"/>">
												<button class="delete-button" class="btn btn-warning">Delete</button>
										</a>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>

				</div>
			</div>
		</div>
<%@include file="./header_footer/footer.jsp" %>