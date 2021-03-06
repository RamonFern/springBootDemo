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
	}).when("/funcionario/:funcionarioId", {
		templateUrl : 'view/funcionario-detalhe.html',
		controller : 'funcionarioDetalheController'
	}).when("/estados", {
		templateUrl : 'view/estado.html',
		controller : 'estadoController'
	}).when("/login", {
		templateUrl : 'view/login.html',
		controller : 'loginController'
	}).otherwise({
		rediretTo : '/'
	});
	
	$locationProvider.html5Mode(true);
	
});

appCliente.config(function ($httpProvider){
	$httpProvider.interceptors.push("tokenInterceptor");
});
