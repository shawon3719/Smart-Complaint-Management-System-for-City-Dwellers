<?php

 header('Content-type: bitmap;charset=utf-8');
 
 if(isset($_POST['Image'])&&isset($_POST['Title'] )&&isset($_POST['Description'])&& isset($_POST['Location'])&&isset($_POST['Email'] )   ){

 $Description = $_POST['Description'];
 $Location=$_POST['Location'];
$Title=$_POST['Title'];
$Email=$_POST['Email'];
 	
	$encoded_string = $_POST["Image"];
	$image_name =uniqid().".png";
	
	$decoded_string = base64_decode($encoded_string);
	
	$path = 'Pic/images/'.$image_name;
	
	$file = fopen($path, 'wb');
	
	$is_written = fwrite($file, $decoded_string);
	fclose($file);
	
	if($is_written > 0) {
		
		$connection = mysqli_connect("localhost","id4374586_city","lulbabu01","id4374586_city");
		$query = "INSERT INTO Problems(Email,Title,Description,Location,Image,Pending) values('$Email','$Title','$Description','$Location','$path','Pending');";
		
		$result = mysqli_query($connection, $query) ;
		
		if($result){
			echo "success";
		}else{
			echo "failed";
		}
		
		mysqli_close($connection);
	}
 }
?>
