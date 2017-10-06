<?php
if(isset($_POST['api_dev_key']) AND isset($_POST['api_user_name']) AND isset($_POST['api_user_password'])) {$api_dev_key 		= 'e327e1850a5fab998d4a8043d1898c64';
    $api_dev_key 		= 'e327e1850a5fab998d4a8043d1898c64';
    $api_user_name 		= $_POST['api_user_name'];
    $api_user_password 	= $_POST['api_user_password'];
    $api_user_name 		= urlencode($api_user_name);
    $api_user_password 	= urlencode($api_user_password);
    $url			= 'https://pastebin.com/api/api_login.php';
    $ch			= curl_init($url);

    curl_setopt($ch, CURLOPT_POST, true);
    curl_setopt($ch, CURLOPT_POSTFIELDS, 'api_dev_key='.$api_dev_key.'&api_user_name='.$api_user_name.'&api_user_password='.$api_user_password.'');
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
    curl_setopt($ch, CURLOPT_VERBOSE, 1);
    curl_setopt($ch, CURLOPT_NOBODY, 0);

    $response 		= curl_exec($ch);
    echo $response;
} else {
    echo 'Please post ALL parameters!';
}
?>

