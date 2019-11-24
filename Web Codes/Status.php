<html><body>
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
   <li><a href="http://citymanagement.000webhostapp.com/Status.php">Status</a></li>
  <li><a href="#contact">Contact</a></li>
  <li><a href="#about">About</a></li>
  <li><a href="http://citymanagement.000webhostapp.com/LogInPanel.php">Log Out</a></li>
 
</ul>


<?php

  $con = mysqli_connect("localhost","id4374586_city","lulbabu01");
   $sdb = mysqli_select_db($con,"id4374586_city") or die(mysql_error()) or die(mysql_error());
   if(isset($_POST['Done'])){
       
       
      
      $update="update Problems SET Pending='Done' where Id='$_POST[PID]' ";
      mysqli_query($con,$update);
      
      
      
  }
  if(isset($_POST['Pending'])){
       
       
      
      $update="update Problems SET Pending='Pending' where Id='$_POST[PID]' ";
      mysqli_query($con,$update);
      
      
      
  }


?>


<form  action="" method="post">
    <h3>Update Status</h3>
Problem ID: <input type="text" name="PID"><br>

<input type="submit" name="Done" value="Done">
<input type="submit" name="Pending" value="Pending">
</form>












</body></html>