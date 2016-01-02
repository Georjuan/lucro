<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
<jsp:directive.page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="false"/>
<jsp:output doctype-root-element="HTML" doctype-system="about:legacy-compat" omit-xml-declaration="true" />

<html lang="en">
<head>
<title>LucroAzul Server</title>

<meta content="text/html;charset=utf-8" http-equiv="Content-Type"/>
    <meta name="viewport" content="user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1, width=device-width, height=device-height" />
    
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
    
    <style>
        .table {
          margin-top: 10px;
          text-align: left;
        }        
        .table tr:nth-child(even) {
          background-color: CornSilk;
        }        
        .table tr:nth-child(odd) {
          background-color: Ivory;
        }        
        .jumbotron {
          text-align: center;
          margin: 20px auto;
          margin-top: 80px;
          padding: 20px;
        }
    </style>

</head>
<body>
	<div class="container" ng-app="lucroApp" ng-controller="versionCtrl">
		<div class="jumbotron">
			<strong>LucroAzul Server/App info</strong>
			<table ng-show="contatos.length > 0" class="table">
	          <tr style="background-color: BurlyWood">
	            <th>Property</th>
	            <th>Value</th>
	          </tr>
	          <tr>
	            <td>App Version</td>
	            <td>${appVersion}</td>
	          </tr>
	          <tr>
	            <td>Time</td>
	            <td>${actualTime}</td>
	          </tr>
	          <tr>
	            <td>Build Hash</td>
	            <td>${buildHash}</td>
	          </tr>
	          <tr>
	            <td>Build By</td>
	            <td>${buildBy}</td>
	          </tr>
	          <tr>
	            <td>Build OS</td>
	            <td>${buildOS}</td>
	          </tr>
	          <tr>
	            <td>Java Version</td>
	            <td>${buildJava}</td>
	          </tr>
	          <tr>
	            <td>JDK Version</td>
	            <td>${buildJdk}</td>
	          </tr>
	        </table>
		</div>
	</div>	
	
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script>
      angular.module('lucroApp', []);
      angular.module('lucroApp').controller('versionCtrl', function($scope) {});
    </script>
	
</body>
</html>
</jsp:root>