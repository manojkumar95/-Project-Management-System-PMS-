function dateCheck()
{
  var StartDate= document.getElementById('startDate').value;
  var EndDate= document.getElementById('endDate').value;
  var eDate = new Date(EndDate);
  var sDate = new Date(StartDate);
  if(StartDate!= '' && StartDate!= '' && sDate> eDate)
    {
    alert("Please ensure that the End Date is greater than or equal to the Start Date.");
    return false;
    }
}

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

function dateValidation() {
var startDate = document.getElementById("datepicker").value;
    var endDate = document.getElementById("datepicker1").value;
 
    if ((Date.parse(startDate) < Date.parse(endDate))) {
        return true;        
        } else {
        alert("End date should be greater than Start date");
        return false;
    }
}

 $(function() {
      $( "#datepicker" ).datepicker({ minDate: -10000, maxDate: "+0D" });
      $("#datepicker").datepicker("setDate",new Date());
      $( "#datepicker" ).datepicker( "option", "dateFormat", "yy-mm-dd");
      $("#datepicker").datepicker('option', {minDate: new Date("2000/10/10")});
    });
     $(function() {
      $( "#datepicker1" ).datepicker({ minDate: -10000, maxDate: "+0D" });
      $("#datepicker1").datepicker("setDate",new Date());
      $( "#datepicker1" ).datepicker( "option", "dateFormat", "yy-mm-dd");
      $("#datepicker1").datepicker('option', {minDate: new Date("2000/10/10")});
    });


