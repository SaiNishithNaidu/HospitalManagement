<%@ include file="Patient/header.jspf" %>
<%@ include file="Patient/navigation.jspf" %>
<%@ include file="Patient/ViewHospital.jspf"%>
		<center><h2>View Hospitals</h2></center>
	<table class="table table-bordered table-hover">
		<thead>
			<tr>
					<th>SNo.</th>
					<th>Hospital Name</th>
					<th>Hospital Address</th>
			</tr>
		</thead>
		<tbody>
			<%
				int i = 1;
				List<String> s = (List) request.getAttribute("hospitalname");
				List<String> s1 = (List) request.getAttribute("hospitaladdress");
				List<String> s2 = (List) request.getAttribute("hospitalid");
			%>
			<%
				for(int j=0;j<s.size();j++){
			%>
			<tr>
			<td><%=i++ %></td>
			<td><a href="/ViewHospital?HospitalID=<%=s2.get(j)%>"><%=s.get(j)%></a></td>
			<td><%=s1.get(j)%></td>
			</tr>
			<%} %>
		</tbody>
	</table></div>
		</div>
<%@ include file="Patient/footer.jspf" %>

