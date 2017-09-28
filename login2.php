<?php
require "conn.php";
$user_name = $_POST["user_name"];
$user_pass = $_POST["password"];;
$mysql_qry = "select username from gameuser where USERNAME = '$user_name' and PASSWORD = '$user_pass'";

$result = mysqli_query($conn,$mysql_qry);

if(mysqli_num_rows($result)>0){
echo "Login success";
}
else 
echo "Login not success";

?>