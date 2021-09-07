<!DOCTYPE html>
<html>
    <head>       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styleform.css">
        <script>
            function alertName(){
                var Msg ='${errorMessage}';
                if (Msg) {
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
       <legend><span class="number">1</span> Client Info Form</legend> 
       <form action="${pageContext.request.contextPath}/ClientController" method="POST">
		<table>
			<tbody>
				<tr>
					<td>
						<label for="id">
							*Id
						</label>
					</td>
					<td>
						<br />
						<input title="Id should be a 4 digit number" name="id" pattern="[0-9]{4}" required="" type="text" placeholder="Enter a 4 digit id" />
					</td>
				</tr>
				<tr>
					<td>
						<label for="name">
							Name
						</label>
					</td>
					<td>
						<br />
						<input name="name" pattern="[a-zA-Z\s]*" required="" type="text" placeholder="Enter only characters" />
					</td>
				</tr>
				<tr>
					<td>
						<label for="emailId">
							*Email Id:
						</label>
					</td>
					<td>
						<br />
						<input name="emailId" required="" type="email" />
					</td>
				</tr>
				<tr>
					<td>
						<label for="designation">
							Organisation:
						</label>
					</td>
					<td>
						<br />
						<select name="designation">
							<option value="ResearchFirm">
								Research Firm
							</option>
							<option value="Health-Firm">
								Health Firm
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<label for="gender">
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
						<input title="zipcode should be only 6 digits" name="zipcode" pattern="[0-9]{6}" required="" type="text" placeholder="Enter a 6 digit zipcode" />
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
		<button name="action" type="submit" value="addClient">
			Add Client
		</button>
		<input name="reset" type="reset" value="Reset" />
	</form>
    </div>
    </body>
</html>
