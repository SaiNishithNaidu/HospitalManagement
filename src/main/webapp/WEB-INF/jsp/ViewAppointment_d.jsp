<%@page import="com.example.Project.Model.ViewAppointmentModel"%>
<%@page import="java.util.List"%>
<%@ include file="Doctor/header.jspf" %>
<%@ include file="Doctor/navigation.jspf" %>
<%@ include file="Doctor/ViewAppointment.jspf" %>




	<center><h2>View Appointment</h2></center>
 <table class="table table-bordered table-hover">
	<tr>
	<th>Patient ID</th>
	<th>Time</th>
	<th>Facility</th>
	<th>Date</th>
	<th>Approve/Reject</th>
	</tr>
			<%
			int i = 1;
						List<ViewAppointmentModel> s = (List) request.getAttribute("appointments");
			%>
			<%
				for(int j=0;j<s.size();j++){
					if(s.get(j).getStatus().equals("pending")){
			%>
			<tr>
			<td><%=s.get(j).getPATID()%></td>
			<td><%=s.get(j).getTime()%></td>
			<td><%=s.get(j).getFacility()%></td>
			<td><%=s.get(j).getDate()%></td>
			<td><a href="/ViewAppointmentAccept_d?accept=<%=s.get(j).getId()%>"><button  class="btn btn-success">Approve</button></a>
			<a href="/ViewAppointmentReject_d?reject=<%=s.get(j).getId()%>"><button class= "btn btn-danger">Reject</button></a></td>
			</tr>
			<%} 
			}%>
	
	
	</table>
	</div>
<%@ include file="Patient/footer.jspf" %>