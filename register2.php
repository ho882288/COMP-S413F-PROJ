<?php
require "conn.php";
$username = $_POST["username"];
$password = $_POST["password"];
$mysql_qry = "insert into gameuser(USERNAME,PASSWORD) values('$username','$password')";
if($conn->query($mysql_qry)===TRUE){
echo "Insert Successful";
}
else {
echo "Insert not successful. Error: ". $mysql_qry."<br>".$conn->error;
}
$conn->close();
?>