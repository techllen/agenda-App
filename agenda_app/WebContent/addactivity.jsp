        <%@include file="./header_footer/header.jsp" %>

        <!-- Contents -->
                <div class="col-sm-10">
                    <div class="content-addactivity">
                        <p>Whats on your mind for today</p>
                        <form action="${pageContext.request.contextPath}/validatedate" method="get">
                        	<label for="tittle">Please enter the name of the activity</label><br>
                            <input style="height: 30px;" id="tittle" name="tittle" maxlength="50" size="50" required><br>
                            <label for="description">Please describe what you are planning to do</label><br>
                            <textarea id="description" name="description" cols="70" required></textarea><br>
                            <label for="startdate">Please enter start date and time</label><br>
                            <input type="date" id="startdate" name="startdate" required><br>
                            <label for="enddate">Please enter end date and time</label><br>
                            <input type="date" id="enddate" name="enddate" required><br><br><br>
                        	<input type="hidden" name="form" value="addactivity"/><br>
                        	<input type="hidden" name="username" value="${user.username}"/><br>
                            <button type="submit">Add</button>
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <%@include file="./header_footer/footer.jsp" %>