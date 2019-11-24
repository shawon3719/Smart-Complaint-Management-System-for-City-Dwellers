<?php

if(isset($_POST["name"] ) &&isset($_POST["pass"] )){

$name=$_POST["name"] ;
$pass=$_POST["pass"] ;


  
      if ($name!='admin' && pass!='admin') {
         //die ("invalid name and password");
      }
      else{
      header("Location: http://citymanagement.000webhostapp.com/Home.php"); 
      exit;
      }
     
      
      
}   
?>
<html>
<body background="1.jpg">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<div style="margin-top:5%;padding:20px;margin-left:40%;margin-right:40%;background-color:#B2BEB5;">

<h2>Admin Panel</h2>

<form method="post">
  User Name:<br>
  <input class="form-control" type="text" name="name" value="">
  <br>
  Password:<br>
  <input class="form-control" type="password" name="pass" value="">
  <br><br>
  <input class="btn btn-default" type="submit" value="Submit">
</form> 
<?php

if(isset($_POST["name"] ) &&isset($_POST["pass"] )){

$name=$_POST["name"] ;
$pass=$_POST["pass"] ;


  
      if ($name!='admin' && pass!='admin') {
         die ("Invalid name and password");
      }
      
     
      
      
}   
?>

</div>

</body>
</html>
