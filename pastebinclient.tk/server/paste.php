<?php

if (isset($_POST['api_dev_key']) AND isset($_POST['api_paste_code']) AND isset($_POST['api_paste_private']) AND isset($_POST['api_paste_name']) AND isset($_POST['api_paste_expire_date']) AND isset($_POST['api_paste_format']) AND isset($_POST['api_user_key'])) {
  $api_dev_key 			= 'e327e1850a5fab998d4a8043d1898c64'; // your api_developer_key
  $api_paste_code 		= $_POST['api_paste_code']; // your paste text
  $api_paste_private 		= $_POST['api_paste_code']; // 0=public 1=unlisted 2=private
  $api_paste_name			= $_POST['api_paste_name']; // name or title of your paste
  $api_paste_expire_date 		= $_POST['api_paste_expire_date'];
  $api_paste_format 		= $_POST['api_paste_format'];
  $api_user_key 			= $_POST['api_user_key']; // if an invalid or expired api_user_key is used, an error will spawn. If no api_user_key is used, a guest paste will be created
  $api_paste_name			= urlencode($api_paste_name);
  $api_paste_code			= urlencode($api_paste_code);


  $url 				= 'https://pastebin.com/api/api_post.php';
  $ch 				= curl_init($url);

  curl_setopt($ch, CURLOPT_POST, true);
  curl_setopt($ch, CURLOPT_POSTFIELDS, 'api_option=paste&api_user_key='.$api_user_key.'&api_paste_private='.$api_paste_private.'&api_paste_name='.$api_paste_name.'&api_paste_expire_date='.$api_paste_expire_date.'&api_paste_format='.$api_paste_format.'&api_dev_key='.$api_dev_key.'&api_paste_code='.$api_paste_code.'');
  curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
  curl_setopt($ch, CURLOPT_VERBOSE, 1);
  curl_setopt($ch, CURLOPT_NOBODY, 0);

  $response  			= curl_exec($ch);
  echo $response;
} else {
  echo 'Please post ALL parameters!';
}

?>
