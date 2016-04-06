angular.module('app.services', ['ngResource']).factory('BookService',function($resource){

//	return $resource("http://localhost:8080/book/:id",{},
	return $resource("http://localhost:8080/book/:id",{id:'@id'},
	{
		update:{
			method: "PUT"
		}
	});
});
