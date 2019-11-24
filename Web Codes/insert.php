<?php


 $con = mysqli_connect("localhost","id4374586_city","lulbabu01","id4374586_city");
 if(isset($_POST['Title'] )&&isset($_POST['Description'])&& isset($_POST['Location'])   ){

 $Description = $_POST['Description'];
 $Location=$_POST['Location'];
$Title=$_POST['Title'];
 $Sql_Query = "insert into Problems (Title,Description,Location) values ('$Title', '$Description','$Location')";
 
 if(mysqli_query($con,$Sql_Query)){
 
 echo 'Data Submit Successfully';
 
 }
 else{
 
 echo 'Try Again';
 
 }
 mysqli_close($con);}
?>