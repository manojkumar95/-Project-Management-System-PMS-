<!DOCTYPE html>
<html>

   <head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styleform.css">
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

    <script>
        function getAge() {
            var today = new Date();
            var dateString = (document.getElementById('datepicker').value);
            var birthDate = new Date(dateString);
            var age = today.getFullYear() - birthDate.getFullYear();
            var m = today.getMonth() - birthDate.getMonth();
            if(m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
                age--;
            }
            if(age > 18) {
                return true;
            } else {
                alert('Age should be greater than 18');
                return false;
            }
        }
        
        $(function() {
            $("#datepicker").datepicker({
                minDate: -10000,
                maxDate: "+0D"
            });
            $( "#datepicker" ).datepicker({ changeYear: true,
            changeMonth: true});
            $("#datepicker").datepicker("setDate", new Date());
            $("#datepicker").datepicker("option", "dateFormat", "yy-mm-dd");
            $("#datepicker").datepicker('option', {
                minDate: new Date("1900/10/10"),
                maxDate: new Date("1997/10/10")
            });
        });

        function alertName() {
            var Msg = '${errorMessage}';
            if(Msg) {
                alert(Msg);
            }

        }
    </script>
</head>
    <body>   
<%@ include file = "header.jsp"%>
<c:if test ="${sessionScope['username'] == null}">
              <c:redirect url = "Login.jsp"/>
            </c:if> 

        <div class="form-style-5">
        <legend><span class="number">1</span> Employee Info Form</legend> 
   <form action="${pageContext.request.contextPath}/EmployeeController" method="POST">
		<table>
			<tbody>
				<tr>
					<td>
						<label for="id">
							Id
						</label>
					</td>
					<td>
						<br />
						<input title="Id should be a 4 digit number" name="id" pattern="[0-9]{4}" required="" type="text" />
					</td>
				</tr>
				<tr>
					<td>
						<label for="ename">
							First Name
						</label>
					</td>
					<td>
						<br />
						<input name="ename" pattern="[a-zA-Z\s]*" type="text" placeholder="Enter only characters" />
					</td>
				</tr>
				<tr>
					<td>
						<label for="dob">
							DOB(YYYY-MM-DD):
						</label>
					</td>
					<td>
						<br />
						<input name="dob" required="" id="datepicker" type="text" />
					</td>
				</tr>
				<tr>
					<td>
						<label for="designation">
							Designation:
						</label>
					</td>
					<td>
						<br />
						<select name="designation">
							<option value="developer">
								Developer
							</option>
							<option value="trainee">
								Trainee
							</option>
							<option value="human resource">
								HR
							</option>
							<option value="manager">
								Manager
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<label for="email">
							MailId:
						</label>
					</td>
					<td>
						<br />
						<input name="email" required="" type="email" />
					</td>
				</tr>
				<tr>
					<td>
						<label for="Gender">
							Gender
						</label>
					</td>
					<td>
						<br />
						<input checked="checked" name="gender" type="radio" value="male" />
						 Male
						<input name="gender" type="radio" value="female" />
						 Female
						<br />
						<br />
					</td>
				</tr>
				<tr>
					<td>
						<label for="addresstype">
							Address Type
						</label>
					</td>
					<td>
						<br />
						<select name="addresstype" required="">
							<option value="primary">
								Primary
							</option>
							<option value="secondary">
								Secondary
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<label for="doornumber">
							Door Number
						</label>
					</td>
					<td>
						<br />
						<input name="doornumber" required="" type="text" />
					</td>
				</tr>
				<tr>
					<td>
						<label for="street1">
							Apartment/Street1
						</label>
					</td>
					<td>
						<br />
						<input name="street1" required="" type="text" />
					</td>
				</tr>
				<tr>
					<td>
						<label for="street2">
							Street2
						</label>
					</td>
					<td>
						<br />
						<input name="street2" required="" type="text" />
					</td>
				</tr>
				<tr>
					<td>
						<label for="landmark">
							Landmark
						</label>
					</td>
					<td>
						<br />
						<input name="landmark" required="" type="text" />
					</td>
				</tr>
				<tr>
					<td>
						<label for="city">
							City
						</label>
					</td>
					<td>
						<br />
						<input title="Enter only characters" name="city" pattern="[a-zA-Z\s]*" required="" type="text" placeholder="Enter only characters" />
					</td>
				</tr>
				<tr>
					<td>
						<label for="state">
							State
						</label>
					</td>
					<td>
						<br />
						<input title="Enter only characters" name="state" pattern="[a-zA-Z\s]*" required="" type="text" placeholder="Enter only characters" />
					</td>
				</tr>
				<tr>
					<td>
						<label for="zipcode">
							Zipcode
						</label>
					</td>
					<td>
						<br />
						<input title="Zipcode should be only 6 digits" name="id" pattern="[0-9]{6}" required="" type="text" />
					</td>
				</tr>
				<tr>
					<td>
						<label for="country">
							Country
						</label>
					</td>
					<td>
						<br />
						<select name="country" required="">
							<option value="india">
								India
							</option>
							<option value="usa">
								USA
							</option>
						</select>
					</td>
				</tr>
			</tbody>
		</table>
		<button name="action" type="submit" value="addEmployee">
			Add Employee
		</button>
		<input name="reset" type="reset" value="Reset" />
	</form>
    <script type="text/javascript"> window.onload = alertName; </script>
    </div>
    </body>
</html>
