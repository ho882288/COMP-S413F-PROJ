<?php
require "conn.php";
$username = $_POST["username"];
$password = $_POST["password"];
$mysql_qry = "UPDATE gameuser SET password = '$password' where username = '$username'";

if($conn->query($mysql_qry)===TRUE){
echo "Update Successful";
}
else {
echo "Update not successful. Error: ". $mysql_qry."<br>".$conn->error;
}
$conn->close();
?>