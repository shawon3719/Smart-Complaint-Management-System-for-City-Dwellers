<?php


 
  $con = mysqli_connect("localhost","id4374586_city","lulbabu01","id4374586_city");
 if( isset($_POST['email'])&& isset($_POST['password']) ){

 $email = $_POST['email'];
 $pass=$_POST['password'];
 
 $sql = "select Name from Register where  Email='$email' and Password='$pass'";
 $result=mysqli_query($con,$sql);
 
 $check = mysqli_fetch_array($result);

 if(isset($check)){
 echo "success";
 }
 else{
 echo "Invalid Username or Password";
 }}


 mysqli_close($con);
?>