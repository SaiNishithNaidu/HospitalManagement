<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<style><%@include file="/WEB-INF/css/patientRegister.css"%></style>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient RegistrationPage</title>

 

 
 
</head>

 

<script type="text/javascript">

 


function required(){
    
    
    var empt = document.forms["form1"]["First_Name"].value;
    if (empt == "")
    {
    alert("Please update the highlighted mandatory field(s).");
    return true;
    }
    
    
    
}

 

</script>

 

<body class="main-bg">
<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->
    <h2 class="active"> Sign Up </h2>
    
    
  <style>
  	td{
  	padding-left: 30px;
  	padding-top: 5px;
  	padding-bottom: 5px;
  	}
  
  </style>

 

            <form action="/afterRegisterPatient" method="GET" modelAttribute="registerPatientModel" onsubmit="required()" name="form1">
        
        <center><table>
        <center><h3 style="color: red;">${error}</h3></center><br>
        <tr>
        <td>
        
        <label>First Name*</label><br>
        <input type="text" name="First_Name" placeholder="First Name" required="required" minlength="4" maxlength="50" />
        </td>

 

        <td>
        <label>Last Name</label><br>
        <input type="text" name="Last_Name"  placeholder="Last Name" minlength="0" maxlength="20"/>
        </td>
        </tr>
        
        <tr>
        <td>
        <label>Date of Birth*</label><br>
        <input class="inputs" type="date" name="DOB" required="required" />
        <p style="color: red;">${age }</p>
        </td>
        
        <td>
        <div style="float: left;">
        <label>Gender*</label><br>
        <input type="radio" name="Gender" value="Male" id="Gender" required="required" />Male
        <input type="radio" name="Gender" value="Female" id="Gender" required="required" />Female
        <input type="radio" name="Gender" value="Other" id="Gender" required="required" />Others    
        </div>
        </td>
        </tr>
        
        <tr>
        <td>
        <label>Contact*</label><br>
        <input class="inputs" type="text" name="Contact_Number"  placeholder="Contact" required="required" pattern="[6-9]{1}[0-9]{9}"/><br></br>
        </td>
        
        <td>
        <label>Email*</label><br>
        <input class="inputs" type="email" name="Email"  placeholder="Email" required="required" /><br></br>
        </td>
        </tr>
        
        <tr>
        <td>
        <label>Security Question*</label><br>
        <select name="Security_Question" id="Security_Question" style="width:auto; height: 35px;">
        <option value="In what city were you born?">In what city were you born?</option>
        <option value="What is the name of your favorite pet?">What is the name of your favorite pet?</option>
        <option value="What is the name of your first school?">What is the name of your first school?</option>
          </select>
          </td>
          </tr>
          
          <tr>
          <td>
          <label>Answer*</label><br>
        <input class="inputs" type="text" name="Answer" required="required" placeholder="Answer"/><br><br>
        </td>
        </tr>
        
        <tr>
        <td colspan="2">
        <center><input type="submit" name="Register"  value="Register"/></center>
        </td>
        </tr>
        
        </table></center>
        </form>

 

        </div>
        </div>
        
</body>

 

</html>