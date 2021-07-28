<%@page import="com.example.Project.Model.ViewAppointmentModel"%>
<%@page import="java.util.List"%>
<%@ include file="Patient/header.jspf" %>
<%@ include file="Patient/navigation.jspf" %>
<%@ include file="Patient/ViewTestResult.jspf"%>
	
	<center><h2>View Test Result</h2></center>
<table class="table table-bordered table-hover">
		<thead>
			<tr>
					<th>Patient Id</th>
					<th>Facility</th>
					<th>Date</th>
					<th>Time</th>
					<th>Result1</th>
					<th>Result2</th>
			</tr>
			</thead>
	
			<%
					List<ViewAppointmentModel> s1 = (List) request.getAttribute("appointments");
			%>
			<%
				for(int j=0;j<s1.size();j++){
					if(s1.get(j).getStatus().equals("Approve")){
			%>
			<tr>
			<td><%=s1.get(j).getPATID()%></td>
			<td><%=s1.get(j).getFacility()%></td>
			<td><%=s1.get(j).getDate()%></td>
			<td><%=s1.get(j).getTime()%></td>
			<td><%=s1.get(j).getResult1()%></td>
			<td><%=s1.get(j).getResult2()%></td>
			</tr>
			<%}
			}%>
	</table>
	</div>
	<div class="six">

<%@ include file="Patient/footer.jspf" %>