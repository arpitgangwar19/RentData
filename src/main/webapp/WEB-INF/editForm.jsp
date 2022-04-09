<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Rent Project</title>
<style>

.container{
      height: 31%;
    width: 50%;
    margin: auto;
    margin-top: 4%;
    padding: 18px;
}
  	
}
</style>
</head>
<body>
<div class="container">
<form action="/editSave"  method="post" modelAttribute="user">

<h2>Rent Details Form</h2>


<div id="date-picker-example" class="md-form md-outline input-with-post-icon datepicker" inline="true">
  <input placeholder="Select date" type="date" id="example" class="form-control" name="decleration_date" value="${lists.decleration_date}" required >
</div>

<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Id</span>
  </div>
  <input type="text" class="form-control" name="id" value="${lists.id}" aria-label="Username" aria-describedby="basic-addon1" readonly>
</div>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Username</span>
  </div>
  <input type="text" class="form-control" name="employee_username" value="${lists.employee_username}" placeholder="" aria-label="Username" aria-describedby="basic-addon1" readonly>
</div>

<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Name</span>
  </div>
  <input type="text" class="form-control"  name="employee_name" value="${lists.employee_name}" placeholder="" aria-label="Username" aria-describedby="basic-addon1" readonly>
</div>

<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Address</span>
  </div>
  <input type="text" class="form-control" value="${lists.address}" name="address"  aria-label="Username" aria-describedby="basic-addon1">
</div>


<div class="input-group mb-3 ">
 <div class="input-group-append">
    <label class="input-group-text"  for="inputGroupSelect02">Financial Year</label>
  </div>
  <select class="custom-select" id="inputGroupSelect02" name="finanacial_year" >
    <option selected>Choose...</option>
    <option value="1">2020-2021</option>
    <option value="2">2019-2020</option>
    <option value="3">2018-2019</option>
  </select>
 
</div>

<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">City</span>
  </div>
  <input type="text" class="form-control" value="${lists.city}" name="city"  aria-label="Username" aria-describedby="basic-addon1">
</div>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">State</span>
  </div>
  <input type="text" class="form-control" value="${lists.state}" name="state" aria-label="Username" aria-describedby="basic-addon1">
</div>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Pincode</span>
  </div>
  <input type="text" class="form-control" value="${lists.pincode}" name="pincode"  aria-label="Username" aria-describedby="basic-addon1">
</div>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Rent Amount</span>
  </div>
  <input type="text" class="form-control" value="${lists.rent_amount}" name="rent_amount"  aria-label="Username" aria-describedby="basic-addon1">
</div>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Rent Yearly</span>
  </div>
  <input type="text" class="form-control" value="${lists.rent_amount_yearly}" name="rent_amount_yearly" aria-label="Username" aria-describedby="basic-addon1">
</div>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Description</span>
  </div>
  <input type="textarea" class="form-control" value="${lists.description}" name="description" aria-label="Username" aria-describedby="basic-addon1">
</div>


<button type="submit" class="btn btn-primary" value="Draft" name="editFormButton">Save</button>
<button type="submit" class="btn btn-primary" name="editFormButton" value="Submitted">Submit</button>
</form>

</div>
</body>
 <script type="text/javascript">
 $('.datepicker').datepicker({
	 ok: '',
	 clear: 'Clear selection',
	 close: 'Cancel'
	 })
      </script>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</html>