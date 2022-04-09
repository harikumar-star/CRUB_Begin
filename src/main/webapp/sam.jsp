<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


Enter your name:
<%


%>

<input hidden ="text" id="op" value="hari">
<button onclick="callJqueryAjax()">Submit</button>
<h3 id="result"></h3>




<script type="text/javascript">
function callJqueryAjax(){
	var name = $('#op').val();
	
	$.ajax({
	url     : 'A',
	method     : 'POST',
	data     : {name : name},
	success    : function(resultText){
	$('#result').html(resultText);
	},
	error : function(jqXHR, exception){
	console.log('Error occured!!');
	}
	});
	}

</script>


</body>
</html>