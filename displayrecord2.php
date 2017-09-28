<?php
    require "conn.php";
    $username = $_POST["username"]; 
    //fetch table rows from mysql db
    $sql = "select score from gameuser where USERNAME = '$username'";
    $result = mysqli_query($conn, $sql) or die("Error in Selecting " . mysqli_error($conn));

    //create an array
    $emparray = array();
    while($row =mysqli_fetch_assoc($result))
    {
        $emparray[] = $row;
    }
    echo json_encode($emparray);

    //close the db connection
    mysqli_close($conn);
?>