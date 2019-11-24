<?php

/*
 * Following code will list all the emp
 */

// array for JSON response
$response = array();


$con = mysqli_connect("localhost","id4374586_city","lulbabu01","id4374586_city");
 
        // Selecing database
$db = mysqli_select_db($con,"id4374586_city") or die(mysql_error()) or die(mysql_error());

$result = mysqli_query($con,"SELECT ID,Title,Description,Location,Image,Pending  FROM Problems") or die(mysqli_error());



// check for empty result
if (mysqli_num_rows($result) > 0) {
    // looping through all results
    // products node
    $response["Problems"] = array();
    
    while ($row = mysqli_fetch_array($result,MYSQLI_ASSOC)) {
        // temp user array
        $info = array();
$info["ID"] = $row["ID"];
        $info["Title"] = $row["Title"];
        $info["Description"] = $row["Description"];
        $info["Location"] = $row["Location"];
        $info["Image"] = $row["Image"];
         $info["Pending"] = $row["Pending"];
		
	


        // push single product into final response array
        array_push($response["Problems"], $info);
    }
    // success
    $response["success"] = 1;

    // echoing JSON response
    echo json_encode($response);
} else {
    // no products found
    $response["success"] = 0;
    $response["message"] = "No products found";

    // echo no users JSON
    echo json_encode($response);
}
?>

