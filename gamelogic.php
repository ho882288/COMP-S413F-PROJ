<?php
require "conn.php";
$username = $_POST["username"];
$question_num = $_POST["question_num"];
$status = $_POST["status"];

$sql = "select status from gameuser where USERNAME = '$username'";
$result = mysqli_query($conn, $sql) or die("Error in Selecting " . mysqli_error($conn));
$row=mysqli_fetch_assoc($result);


if($row["status"]===TRUE){
$sql = "select question,a,b,c,d from question where question_num = '$question_num' and question_set= 1 ";
$result = mysqli_query($conn, $sql) 
$row=mysqli_fetch_assoc($result);

return array($row["question"],$row["a"],$row["b"],$row["c"],$row["d"]);
}
else {
$sql = "select question,a,b,c,d from question where question_num = '$question_num' and question_set= 2 ";
$result = mysqli_query($conn, $sql) 
$row=mysqli_fetch_assoc($result);
return array($row["question"],$row["a"],$row["b"],$row["c"],$row["d"]);
}
else {
echo " Error ". $mysql_qry."<br>".$conn->error;
}

$conn->close();
?>