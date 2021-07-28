<%@page import="com.example.Project.Model.ViewAppointmentModel"%>
<%@page import="java.util.List"%>
<%@ include file="Patient/header.jspf" %>
<%@ include file="Patient/navigation.jspf" %>
<%@ include file="Patient/ViewAppointment.jspf"%>



	
	<center><h2>View Appointment</h2></center>
	<table class="table table-bordered table-hover">
		<thead>
			<tr>
			<th>Patient ID</th>
			<th>Time</th>
			<th>Doctor Name/Facility Name</th>
			<th>Date</th>
			<th>Status</th>
			</tr>
			</thead>
			<%
			
			List<ViewAppointmentModel> s = (List) request.getAttribute("appointments");
			%>
			<%
				for(int j=0;j<s.size();j++){
			%>
			<tr>
			<td><%=s.get(j).getPATID()%></td>
			<td><%=s.get(j).getTime()%></td>
			<td><%=s.get(j).getFacility()%></td>
			<td><%=s.get(j).getDate()%></td>
			<td><%=s.get(j).getStatus()%></td>
			</tr>
			<%} %>
	
	
	</table>
	</div>
	<div class="six">


<%@ include file="Patient/footer.jspf" %>