<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <style><%@include file="/WEB-INF/css/hospitaladminRegister.css"%></style>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hospital Admin RegistrationPage</title>
</head>

 

<script>
function myFunction() {
    alert("sucess");
}
</script>

  <style>

  	td{
  	padding-left: 30px;
  	padding-top: 5px;
  	padding-bottom: 5px;
  	}
  	span{
  	color: red;
  	}
  
  </style>

<body class="main-bg">
        <div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->
    <h2 class="active"> Sign Up </h2>            
    <center><h3 style="color: red;">${error}</h3></center><br>
            <form action="/afterRegisterHospitalAdmin" method="GET" modelAttribute="registerHospitalAdminModel" onsubmit="required()" name="form1">
        <center><table>
        <tr>
        <td>
        
        <label>Hospital Name</label><br>
        <input  type="text" name="Hospital_Name"  placeholder="Hospital Name" required="required" /><br></br>
        </td>
        <td>        
        <label>Address Lane 1</label><br>
        <input  type="text" name="Address_Lane1"  placeholder="enter address" required="required" /><br></br>
        </td>
        </tr>
        
        <tr>
        <td>
        <label>Address Lane 2</label><br>
        <input  type="text" name="Address_Lane2"  placeholder="enter address" required="required" /><br></br>
        </td>
        
        <td>
        <label>Address Lane 3</label><br>
        <input  type="text" name="Address_Lane3"  placeholder="enter address" required="required" /><br></br>
        </td>
        </tr>
    
        <tr>
        <td>
        <label>City <span>*</span></label><br>
        <input  type="text" name="City"  placeholder="enter city" required="required" /><br></br>
        </td>
        <td>
        <label>State <span>*</span></label><br>
        <input  type="text" name="State"  placeholder="enter state" required="required" /><br></br>
        </td>
        </tr>
        
        <tr>
        <td>
        <label>Zip <span>*</span></label><br>
        <input  type="number" name="Zip"  placeholder="enter zip code" required="required" /><br></br>
        </td>
        <td>
        <label>Hospital Mobile Number</label><br>
        <input  type="text" name="Hospital_Contact_Number"  placeholder="enter hospital mobile number " required="required" pattern="[6-9]{1}[0-9]{9}" /><br></br>
        </td>
        </tr>
        
        <tr>
        <td>
        <label>Hospital Fax Number</label><br>
        <input  type="number" name="Hospital_Fax_Number"  placeholder="enter hospital fax number " required="required" /><br></br>
        </td>
        <td>
        <label>Hospital Website URL</label><br>
        <input  type="text" name="Hospital_Website"  placeholder="enterwWebsite url " required="required" /><br></br>
        </td>
        </tr>
        
        <tr>
        <td>
        <label>Security Question <span>*</span></label><br>
        <select name="Security_Question" id="Security_Question" style="width: 100%; height: 35px;">
        <option value="In what city were you born?">In what city were you born?</option>
        <option value="What is the name of your favorite pet?">What is the name of your favorite pet?</option>
        <option value="What is the name of your first school?">What is the name of your first school?</option>
          </select><br><br>
          </td>
          </tr>
          
          <tr>
          <td>
          <label>Answer <span>*</span></label><br>
        <input  type="text" name="Answer" required="required" placeholder="Answer"/><br><br>
        
        </td>
        </tr>
        <tr>
        <td colspan="2">
         <center><input type="submit" name="Register" value="Register"/></center>
        </td>
        </tr>
        </table></center>
        </form>

 

        </div>
    </div>

 

    <script src="webjars/jquery/3.5.0/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
</body>
</html>

 