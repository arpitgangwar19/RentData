<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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




<h2 style="margin-left: 28%;">Login Form </h2>
<form action="authenticate" modelAttribute="user" method="post">
	
  
  <div class="form-group">
    <label for="exampleInputEmail1">Username</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="employee_username" aria-describedby="emailHelp" placeholder="Enter email">
    <small id="emailHelp" class="form-text text-muted"></small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" name="employee_password" placeholder="Password">
  </div>
  
  
  <button type="submit" class="btn btn-primary">Login</button>
</form>









</div>
</body>

<script type="text/javascript"></script>
</html>
