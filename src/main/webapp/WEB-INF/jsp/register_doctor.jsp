<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <style><%@include file="/WEB-INF/css/doctorRegister.css"%></style>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor RegistrationPage</title>
</head>

 

<script>
function myFunction() {
    alert("sucess");
}
</script>


<style>


span{
	color: red;
}


	td{
  	padding-left: 30px;
  	padding-top: 5px;
  	padding-bottom: 5px;
  	}

</style>
<body class="main-bg">
        <div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->
    <h2 class="active"> Sign Up </h2>    
            <form action="/afterRegisterDoctor" method="GET" modelAttribute="registerDoctorModel" onsubmit="required()" name="form1">
        <center><h3 style="color: red;">${error}</h3></center><br>
        <center><table>
        <tr>
        <td>
        
        <label>First Name <span>*</span></label><br>
        <input type="text" name="First_Name" placeholder="First Name" required="required" minlength="0" maxlength="20" /><br><br>
        </td>

 

        <td>
        <label>Last Name</label><br>
        <input type="text" name="Last_Name"  placeholder="lastname" minlength="0" maxlength="20"/><br></br>
        </td>
        </tr>

 

        <tr>
        <td>
        <label>Date of Birth <span>*</span></label><br>
        <input  type="date" name="DOB" required="required" /><br></br>
        </td>
        
        
        <td>
        <div style="float: left;">
        <label>Gender <span>*</span></label><br>
        <input type="radio" name="Gender" value="Male" id="Gender" required="required" />Male
        <input type="radio" name="Gender" value="Female" id="Gender" required="required" />Female
        <input type="radio" name="Gender" value="Other" id="Gender" required="required" />Others    
        </div>
        </td>
        </tr>
        
        <tr>
        <td>
        <label>Contact <span>*</span></label><br>
        <input  type="number" name="Contact_Number"  placeholder="Contact" required="required" pattern="[6-9]{1}[0-9]{9}"/><br>
        </td>

 

        <td>
        <label>Email <span>*</span></label><br>
        <input  type="email" name="Email"  placeholder="Email" required="required" />
        </td>
        </tr>
        
     
        <tr>
        <td>        
        <label>Qualification</label><br>
        <input  type="text" name="Qualification"  placeholder="Qualification" required="required" /><br></br>
        </td>
        
        <td>
        <label>Speciality</label><br>
        <input  type="text" name="Speciality"  placeholder="Speciality" required="required" /><br></br>
        </td>
        </tr>
        
        <tr>
        <td>
        <label>Experience</label><br>
        <input  type="number" name="Experience"  placeholder="Experience" required="required" /><br></br>
        </td>
        
        <td>
        <label>Hospital Name</label><br>
        <input type="text" name="Hospital_Name"  placeholder="Hospital Name" required="required" /><br></br>
        </td>
        </tr>
        
        <tr>
        <td>
        <label>Days Availiable</label><br><br>
        <input type="checkbox" name="DAY" value="Sunday">
          <label for="Sunday"> Sunday </label><br>
        <input type="checkbox" name="DAY" value="Monday">
          <label for="Monday"> Monday </label><br>
          <input type="checkbox" name="DAY" value="Tuesday">
          <label for="Tuesday"> Tuesday </label><br>
          <input type="checkbox" name="DAY" value="Wednesday">
          <label for="Wednesday"> Wednesday </label><br>
          <input type="checkbox" name="DAY" value="Thursday">
          <label for="Thursday"> Thursday </label><br>
          <input type="checkbox" name="DAY" value="Friday">
          <label for="Friday"> Friday </label><br>
          <input type="checkbox" name="DAY" value="Saturday">
          <label for="Saturday"> Saturday </label><br><br>
        </td>
        </tr>
        
   
        
        <tr>
        <td>
        <label>Available From</label><br>
        <input  type="time" name="Available_From"   required="required" /><br></br>
        </td>
        
        <td>
        <label>Available To</label><br>
        <input  type="time" name="Available_To"   required="required" /><br></br>
        </td>
        </tr>
        
        <tr>
        <td>
        
         <label>Security Question <span>*</span></label><br>
         <div class="select">
        <select name="Security_Question" id="Security_Question" style="width: 100%; height: 35px;">
        <option value="In what city were you born?">In what city were you born?</option>
        <option value="What is the name of your favorite pet?">What is the name of your favorite pet?</option>
        <option value="What is the name of your first school?">What is the name of your first school?</option>
          </select>
        </div>
        
       
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
        <center><input type="submit" name="Register"  value="Register"/></center>
        </td>
        </tr>
        
        </table></center>
        </form>

 

        </div>
        
    </div>

 

    
</body>
</html>