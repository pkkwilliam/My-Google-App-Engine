<!doctype html>
<html>
	<head>
		<title>Upload Portal</title>
	</head>
	<center>
		<body>
			<form method="POST" enctype="multipart/form-data">
				Image<input type = "file" name="main_image" accept="image/*"/><br/>
				<input type="submit" name="submit"/>
			</form>
		</body>
		<?php
			if(isset($_POST['submit'])){
				include 'account.php';
				function input($ftp_conn,$contentName,$contentPath){
					// connect and login to FTP server

					if (ftp_put($ftp_conn, $contentName, $contentPath, FTP_BINARY))
					  {
						//echo "Successfully uploaded $contentName.<br/>";
					  }
					else
					  {
						echo "Error uploading $contentName.<br/>";
					  }
					}

				$main_image_name = $_FILES['main_image']['name'];
				$main_image_temp_name = $_FILES['main_image']['tmp_name'];

				input($ftp_conn,$main_image_name,$main_image_temp_name);

				ftp_close($ftp_conn);
				$address = "http://imagerecognitionalphatesting.appspot.com/demo?id=http://karmaincorporated.com/imageRecognitionUpload/$main_image_name";
				//echo($address);

				// create a new cURL resource
				$ch = curl_init();

				// set URL and other appropriate options
				curl_setopt($ch, CURLOPT_URL, $address);
				curl_setopt($ch, CURLOPT_HEADER, 0);
				
				// grab URL and pass it to the browser
				$json = json_decode(curl_exec($ch),false);
				echo($json);
				

				// close cURL resource, and free up system resources
				curl_close($ch);
			}
			?>
	</center>
</html>