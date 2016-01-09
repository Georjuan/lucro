<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html SYSTEM "about:legacy-compat">
<html>
<head>
	<meta content="text/html;charset=utf-8" http-equiv="Content-Type" />
	<meta name="viewport" content="user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1, width=device-width, height=device-height" />
	
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    
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

	<title>LucroAzul Server</title>
</head>

<body ng-app="lucroApp">

	<div class="container" ng-controller="versionCtrl">
		<div class="jumbotron">
			<strong>LucroAzul Server/App info</strong>
			<table class="table">
	          <tr style="background-color: BurlyWood">
	            <th>Property</th>
	            <th>Value</th>
	          </tr>
	          <tr ng-repeat="property in parameters">
	            <td><strong>{{property.name}}</strong></td>
	            <td>{{property.value}}</td>
	          </tr>
	        </table>
		</div>
	</div>	
	
    <script>
      angular.module('lucroApp', []);
      angular.module('lucroApp').controller('versionCtrl', function($scope) {
    	  $scope.parameters = [
                       {name: 'App Version', value: '${appVersion}'},
                       {name: 'Server Time', value: '${serverTime}'},
                       {name: 'DB Time', value: '${dbTime}'},
                       {name: 'Build Hash', value: '${buildHash}'},
                       {name: 'Build By', value: '${buildBy}'},
                       {name: 'Build OS', value: '${buildOS}'},
                       {name: 'Java Version', value: '${buildJava}'},
                       {name: 'JDK Version', value: '${buildJdk}'}
                 ];
      });
    </script>
	
</body>
</html>