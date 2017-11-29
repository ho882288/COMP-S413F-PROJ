 <?php
    require "conn.php";
    //fetch table rows from mysql db
    $sql = "select * from question";
    $result = mysqli_query($conn, $sql) or die("Error in Selecting " . mysqli_error($conn));

    //create an array
    $data = array();
    while($row =mysqli_fetch_assoc($result))
    {
        echo $row["question"]." ".$row["a"]." ".$row["b"]." ".$row["c"]." ".$row["d"]." ";
    }

    //close the db connection
    mysqli_close($conn);
	
	/*
$sql = "select * from question";
$result = mysqli_query($conn, $sql) 
$row=mysqli_fetch_assoc($result);
if ($result->num_rows > 0) {
return array($row["question"],$row["a"],$row["b"],$row["c"],$row["d"]);
}
else {
echo " Error ". $mysql_qry."<br>".$conn->error;
}

$conn->close();
?>
*/
 
?>
 
 
 


