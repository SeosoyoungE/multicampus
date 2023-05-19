<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>jQuery treeview</title>

<link rel="stylesheet" href="/erp/css/jquery.treeview.css" />
<link rel="stylesheet" href="/erp/css/screen.css" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>

<script src="/erp/js/jquery.cookie.js"></script>
<script src="/erp/js/jquery.treeview.js"></script>
<script type="text/javascript" src="/erp/js/demo.js"></script>

</head>
<body>
	<div id="main">

		<h4>조직도</h4>
		<ul id="browser" class="filetree">
			<li><span class="folder">Folder 1</span>
				<ul>
					<li><span class="file">Item 1.1</span></li>
				</ul></li>
			<li><span class="folder">Folder 2</span>
				<ul>
					<li><span class="folder">Subfolder 2.1</span>
						<ul id="folder21">
							<li><span class="file">File 2.1.1</span></li>
							<li><span class="file">File 2.1.2</span></li>
						</ul></li>
					<li><span class="file">File 2.2</span></li>
				</ul></li>
			<li class="closed"><span class="folder">Folder 3 (closed
					at start)</span>
				<ul>
					<li><span class="file">File 3.1</span></li>
				</ul></li>
			<li><span class="file">File 4</span></li>
		</ul>


	</div>

</body>
</html>