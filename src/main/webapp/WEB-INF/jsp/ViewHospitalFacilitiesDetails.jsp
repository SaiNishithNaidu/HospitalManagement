<%@ include file="Patient/header.jspf" %>
<%@ include file="Patient/navigation.jspf" %>
<%@ include file="Patient/ViewHospital.jspf"%>
	<center><h2>Facilities</h2></center>
 <table class="table table-bordered table-hover">
		<thead>
			<tr>
					<th>SNo.</th>
					<th>Hospital Name</th>
			</tr>
		</thead>
		<tbody>
			<%
				int i = 1;
				List<String> s = (List) request.getAttribute("facilitiesDetails");
			%>
			<%
				for(int j=0;j<s.size();j++){
			%>
			<tr>
			<td><%=i++ %></td>
			<td><%=s.get(j)%></td>
			</tr>
			<%} %>
		</tbody>
	</table>
	
	
	
	</div>

<%@ include file="Patient/footer.jspf" %>