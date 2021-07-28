<%@ include file="Patient/header.jspf" %>
<%@ include file="Patient/navigation.jspf" %>
<%@ include file="Patient/ViewHospital.jspf"%>
	<center><h2>Facilities</h2></center>
 <table class="table table-bordered table table-hover">
		<thead>
			<tr>
					<th>SNo.</th>
					<th>Facilities</th>
			</tr>
		</thead>
		<tbody>
			<%
				int i = 1;
				List<String> s = (List) request.getAttribute("facilities");
			%>
			<%
				for(int j=0;j<s.size();j++){
			%>
			<tr>
			<td><%=i++ %></td>
			<td><a href="/ViewHospitalFacilitiesNames?FacilityName=<%=s.get(j)%>&HospitalName=${HospitalName}"><%=s.get(j)%></a></td>
			</tr>
			<%} %>
		</tbody>
	</table>
	
	
	
	</div>
<%@ include file="Patient/footer.jspf" %>