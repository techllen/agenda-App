        <%@include file="./header_footer/header.jsp" %>

        <!-- Contents -->
                <div class="col-sm-10">
                    <div class="content-addactivity">
                        <p>Anything changing today in this activity</p>
                        <form action="${pageContext.request.contextPath}/update" method="get">
        <!-- passing the activity id using scriplet -->
        					 <%--
        					                            <%
                            	int id = Integer.parseInt(request.getParameter("id"));
                            %>
                        	<p><%out.print(id);%></p>
        					  --%>
        					<input type="hidden" name="id" value="${activityToDisplay.id}">
        					<label for="tittle">Please enter the name of the activity</label><br>
                            <input style="height: 30px;" id="tittle" name="tittle" maxlength="50" size="50" value="${activityToDisplay.tittle}"><br>
                            <label for="description">Please describe what you are planning to do</label><br>
                            <input style="height: 100px;" id="description" name="description" maxlength="250" size="70" value="${activityToDisplay.description}"><br>
                            <label for="startdate">Please enter start date</label><br>
                            <input type="date" id="startdate" name="startdate" value="${activityToDisplay.startDate}"><br>
                            <label for="enddate">Please enter end date</label><br>
                            <input type="date" id="enddate" name="enddate" value="${activityToDisplay.endDate}"><br>
                            <label for="status">Please select the status of this activity</label><br><br>
                            <select name="status" id="status">
                                <option value="beginning">Beginning</option>
                                <option value="work in progress">Work in progress</option>
                                <option value="halted">Stopped for now</option>
                                <option value="finished">Finished</option>
                            </select><br> <br>
                            <button type="submit"> Update</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
                <%@include file="./header_footer/footer.jsp" %>