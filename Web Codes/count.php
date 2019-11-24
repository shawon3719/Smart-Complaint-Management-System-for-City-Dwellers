<!DOCTYPE html>
<html>
<head>
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
  height: 400px;
  margin: 1rem;
  position: relative;
  width: 710px;
}
</style>
</head>
<body>

<ul>
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
<?php
$servername = "localhost";
$username = "id4374586_city";
$password = "lulbabu01";
$dbname = "id4374586_city";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "select Email, count(*) as c FROM Problems GROUP BY Email";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo "<br> Email ". $row["Email"]. "  Post Number ". $row["c"].  "<br>";
    }
} else {
    echo "0 results";
}

$conn->close();
?> 

</body>
</html>