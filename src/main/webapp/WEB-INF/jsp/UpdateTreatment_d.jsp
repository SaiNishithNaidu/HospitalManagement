<%@page import="com.example.Project.Model.ViewAppointmentModel"%>
<%@ include file="Doctor/header.jspf" %>
<%@ include file="Doctor/navigation.jspf" %>
<%@ include file="Doctor/UpdateTreatment.jspf" %>
	<center><h2>Update Treatment</h2></center>
	<table class="table table-bordered table-hover">
			<tr>
				<th>S.No</th>
				<th>Patients ID</th>
				<th>Date</th>
				<th>Time</th>
			</tr>
			
			<%
			List<ViewAppointmentModel> s = (List) request.getAttribute("appointments");
			%>
			<%
			for (int j = 0; j < s.size(); j++) {
				if (s.get(j).getStatus().equals("Approve")) {
			%>
			<tr>
				<td><%=j%></td>
				<td><a
					href="/UpdateTestResultPatient_d?uniqueID=<%=s.get(j).getId()%>">
						<%=s.get(j).getPATID()%></td>
				<td><%=s.get(j).getDate()%></td>
				<td><%=s.get(j).getTime()%></td>
			</tr>
			
			<%
			}
			}
			%>

		</table>
	</div>
	<div class="six">
<%@ include file="Patient/footer.jspf" %>







