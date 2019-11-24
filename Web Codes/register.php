<?php


 
 $con = mysqli_connect("localhost","id4374586_city","lulbabu01","id4374586_city");
 if(isset($_POST['name'])&& isset($_POST['email'])&& isset($_POST['password'])&& isset($_POST['NID']) ){
 $name = $_POST['name'];
 $email = $_POST['email'];
 $pass=$_POST['password'];
 $NID=$_POST['NID'];
 

   
   



 
 $sql = "select NID from NID where  NID='$NID' ";
 $result=mysqli_query($con,$sql);
 
 $check = mysqli_fetch_array($result);

 if(isset($check)){
 
 
 
 
  
 $Sql_Query = "insert into Register (Name,Email,Password,NID) values ('$name', '$email','$pass','$NID')";
 
 if(mysqli_query($con,$Sql_Query)){
 
 echo 'Registered Successfully';
 
 }
 else{
 
 echo 'Try Again';
 
 
 }
 
 
 
 
 
 
 
 }
 else{
 echo "Invalid NID";
 }
  
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
 

 
 
 
 mysqli_close($con);}
?>