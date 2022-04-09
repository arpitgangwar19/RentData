<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.rent.model.Employee"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style type="text/css">

.list{
height: 50%;
    width: 96%;
    margin: auto;}
    
    .tablerow{
padding:2%;
    }
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: #e3f2fd;">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">${user.employee_name}</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Features</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Pricing</a>
        </li>
      </ul>
      <div>
        <a href="http://localhost:8080/signout">Logout</a>
      </div>
      <div class="d-flex"></div>
    </div>
  </div>
</nav>
<div class="list">


<form>

<table  style="margin-top: 2%;
    padding: 11%;
    margin-bottom: 4%;">
<tr>

<td class="tablerow">
<div class="input-group mb-3 ">
  <select class="custom-select" id="inputGroupSelect02" name="financial_year">
    <option selected>Choose...</option>
    <option value="1">2020-2021</option>
    <option value="2">2019-2020</option>
    <option value="3">2018-2019</option>
  </select>
  <div class="input-group-append">
    <label class="input-group-text" for="inputGroupSelect02">Financial Year</label>
  </div>
</div>


</td>
<td class="tablerow">
<div class="input-group mb-3 ">
  <select class="custom-select" id="inputGroupSelect02" name="finanacial_year">
    <option selected>Choose...</option>
    <option value="1">2020-2021</option>
    <option value="2">2019-2020</option>
    <option value="3">2018-2019</option>
  </select>
  <div class="input-group-append">
    <label class="input-group-text" for="inputGroupSelect02">Declaration Status</label>
  </div>
</div>


</td>

</tr>

<tr>
<td class="tablerow">
<div class="input-group mb-3 ">
  <select class="custom-select" id="inputGroupSelect02" name="financial_year">
    <option selected>Choose...</option>
    <option value="2020-2021">2020-2021</option>
    <option value="2019-2020">2019-2020</option>
    <option value="2018-2019">2018-2019</option>
  </select>
  <div class="input-group-append">
    <label class="input-group-text" for="inputGroupSelect02">Employee Name</label>
  </div>
</div>
</td>
<td  class="tablerow">

<div class="input-group mb-3 ">
  <select class="custom-select" id="inputGroupSelect02" name="Employee Id">
    <option selected>Choose...</option>
    <option value="1">2020-2021</option>
    <option value="2">2019-2020</option>
    <option value="3">2018-2019</option>
  </select>
  <div class="input-group-append">
    <label class="input-group-text" for="inputGroupSelect02">Employee Id</label>
  </div>
</div>
</td>

</tr>

</table>



</form>


<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Employee Id</th>
      <th scope="col">Employee Name</th>
      <th scope="col">Financial Year</th>
      <th scope="col">Declaration Status</th>
      <th scope="col">Declaration Date</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${data}" var="lists">
    <tr>
      <th scope="row">1</th>
      <td>${lists.id}</td>
      <td>${lists.employee_name}</td>
      <td>${lists.finanacial_year}</td>
      <td>${lists.decleration_status}</td>
      <td>${lists.decleration_date}</td>
      <td>
      

      
      
      <c:choose>
  <c:when test="${lists.decleration_status == 'Submitted'}">
    
 <a href="">Done</a>
  </c:when>
  <c:otherwise>
 <a href="/edit/${lists.id}" >Edit</a>     

  </c:otherwise>
</c:choose>
      
      
      </td>
      
      
      
    </tr>
</c:forEach>
    
   
  </tbody>
</table>





<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
      
      <form action="/signup" modelAttribute="user" method="post">
	
	 <div class="form-group"  >
    <label for="formGroupExampleInput">Id</label>
    <input type="text" class="form-control" name="" value="${data_row.id}"  readonly id="formGroupExampleInput" placeholder="">
  </div>
  
   <div class="form-group"  >
    <label for="formGroupExampleInput">Name</label>
    <input type="text" class="form-control" name="employee_name" id="formGroupExampleInput" placeholder="">
  </div>
  
  
   <div class="form-group">
    <label for="formGroupExampleInput">Last Name</label>
    <input type="text" class="form-control" name="employee_name" id="formGroupExampleInput" name="employee_lastname" placeholder="Example input">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Username</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="employee_username" aria-describedby="emailHelp" placeholder="Enter email">
    <small id="emailHelp" class="form-text text-muted"></small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1"></label>
    <input type="text" class="form-control" id="exampleInputPassword1" name="employee_password" placeholder="Password">
  </div>
  
  <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

            </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>



</div>   
</div>


</body>

<script>
   function display(item){
	   
	   data_row=item;
	   console.log(data_row.id);
   } 
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</html>