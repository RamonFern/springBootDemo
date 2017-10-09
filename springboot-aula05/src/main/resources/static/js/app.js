//Criacao do modulo principal da aplicacao
var appCliente = angular.module("appCliente", [ 'ngRoute' ]);

appCliente.config(function($routeProvider, $locationProvider) {

	$routeProvider
	.when("/clientes", {
		templateUrl : 'view/cliente.html',
		controller : 'clienteController'
	}).when("/clientes/:clienteId", {
		templateUrl : 'view/cliente-detalhe.html',
		controller : 'clienteDetalheController'
	}).when("/funcionario", {
		templateUrl : 'view/funcionario.html',
		controller : 'funcionarioController'
	}).when("/estados", {
		templateUrl : 'view/estado.html',
		controller : 'estadoController'
	}).otherwise({
		rediretTo : '/'
	});
	
	$locationProvider.html5Mode(true);
	
});
