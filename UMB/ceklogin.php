    
<?php

include("config.php");

$nis= $_POST['nis'];
$password= $_POST['password'];


$sql = "SELECT * FROM students WHERE nis='$nis' AND password='$password'";
$result = array();
$query = mysqli_query($db, $sql);
$stat=mysqli_num_rows ( $query ); 

array_push($result, array('status' => $stat));
echo json_encode(array("result" => $result));
?>