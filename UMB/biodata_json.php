<?php

include("config.php");

$sql = "SELECT * FROM students";
$result = array();
$query = mysqli_query($db, $sql);
 
while($row = mysqli_fetch_array($query)){
    array_push($result, array(
    'nis' => $row['nis'],
    'Nama' => $row['nama'],
    'minat1' => $row['minat1'],
    'minat2' => $row['minat2']
));
}
echo json_encode(array("result" => $result));
?>



