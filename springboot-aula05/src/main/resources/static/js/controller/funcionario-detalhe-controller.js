appCliente.controller("funcionarioDetalheController", function ($scope,$routeParams, $http ){
	
	$scope.funcionario = {};
	
	$http.get("funcionario/"+$routeParams.funcionarioId).then(function (response){
		$scope.funcionario = response.data;
		
	}, function (response){
		console.log(response);
		
	});
	
} );