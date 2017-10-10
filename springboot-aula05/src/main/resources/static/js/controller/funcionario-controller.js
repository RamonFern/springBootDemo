appCliente.controller("funcionarioController", function($scope, $http){
	
	$scope.funcionarios = [];
	$scope.funcionario = {};
	
	carregarFuncionarios= function (){
		$http({method:'GET', url:'http://localhost:8080/funcionario'})
		.then(function (response){
			$scope.funcionarios = response.data;
			
		} , function (response){
			console.log(response.data);
			console.log(response.status);
			
		});
	};
	
	$scope.salvarFuncionario = function (){
			
			$http({method:'POST', url:'http://localhost:8080/funcionario',data:$scope.funcionario})
			.then(function (response){
				
				carregarFuncionarios();
				$scope.cancelarAlteracaoFuncionario();
				
			} , function (response){
				console.log(response.data);
				console.log(response.status);
				
			});
		};
		
	$scope.excluirFuncionario = function(funcionario){
		$http({method:'DELETE', url:'http://localhost:8080/funcionario/'+funcionario.id})
		.then(function (response){
			
			pos = $scope.funcionarios.indexOf(funcionario);
			$scope.funcionarios.splice(pos , 1);
			
		} , function (response){
			console.log(response.data);
			console.log(response.status);
			
		});	
		
	};	
	
	$scope.alterarFuncionario = function (func){
		$scope.funcionario = angular.copy(func);
	};
	
	
	$scope.cancelarAlteracaoFuncionario=function (){
		$scope.funcionario={};
	};
	
	carregarFuncionarios();
	
});