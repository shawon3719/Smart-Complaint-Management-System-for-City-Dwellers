<!DOCTYPE HTML>
<html>  
<body>
<style>
body {
    margin: 0;
    
}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111;
}
form {
    padding:20px;
    background-color:#b2bdb5;
    display: inline-block;
    margin-left:40%;
    margin-Top:10%;
    text-align: center;
}
p
{margin:0;
    display:inline;
}

.card-5 {
  box-shadow: 10px 19px 38px rgba(0,0,0,0.30), 0 15px 12px rgba(0,0,0,0.22);
}

.card {
  background: #fff;
  border-radius: 2px;
  padding-left:10px;
  height: 300px;
  margin: 1rem;
  position: relative;
  width: 710px;
}
</style><ul>
  <li><a class="active" href="http://citymanagement.000webhostapp.com/Home.php">Home</a></li>
  <li><a href="http://citymanagement.000webhostapp.com/admin.php">Problem</a></li>
  <li><a href="http://citymanagement.000webhostapp.com/NID.php">User NID</a></li>
  <li><a href="http://citymanagement.000webhostapp.com/NIDview.php">NID View</a></li>
   <li><a href="http://citymanagement.000webhostapp.com/count.php">Count</a></li>
   <li><a href="http://citymanagement.000webhostapp.com/Status.php">Status</a></li>
  <li><a href="#contact">Contact</a></li>
  <li><a href="#about">About</a></li>
  <li><a href="http://citymanagement.000webhostapp.com/LogInPanel.php">Log Out</a></li>
 
</ul>

<form  action="" method="post">
NID: <input type="text" name="NID"><br>

<input type="submit">
</form>

</body>
</html>


<?php


 $con = mysqli_connect("localhost","id4374586_city","lulbabu01","id4374586_city");
 if(isset($_POST['NID'] )   ){


$NID=$_POST['NID'];
 $Sql_Query = "insert into NID (NID) values ('$NID')";
 
 if(mysqli_query($con,$Sql_Query)){
 
 echo 'Data Submit Successfully';
 
 }
 else{
 
 echo 'Try Again';
 
 }
 mysqli_close($con);}
?>