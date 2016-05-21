<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>

</head>
<body>
	<h1>hello! this is a test page</h1>
	<a href="http://www.baidu.com" onmouseover="on()"  onmouseout="out()">试试吧</a>
	<span id="show" class="color:green;font-size:5" hidden="true">哈哈，，我出来啦</span>
</body>

<script lang="javascript">
	function on() {
		var test = document.getElementById("show");
		test.hidden = false;
		console.log(test.hidden);
	}

	function out() {
		var test = document.getElementById("show");
		test.hidden = true;
		console.log(test.hidden);
	}
</script>
</html>
