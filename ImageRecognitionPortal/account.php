<?php
$ftp_server = "ftp.karmaincorporated.com";
$ftp_conn = ftp_connect($ftp_server) or die("Could not connect to $ftp_server");
$ftp_username = "imageRecognitionUpload@karmaincorporated.com";
$ftp_userpass = "!x{tfnV4iH,$";
$login = ftp_login($ftp_conn, $ftp_username, $ftp_userpass);
ftp_pasv($ftp_conn, true);
?>