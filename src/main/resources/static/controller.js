function Hello($scope, $http) {
    $http.get('localhost:8080/book').
    success(function(data) {
        $scope.greeting = data;
    });
}

angular.module('app.controllers',[]).controller('AppCtrl', function($scope,$http,BookService) {

    //newest
	$scope.bs = BookService;
	$scope.rgot = BookService.query();
	$scope.rBooks = BookService.query();
//	console.log("got1 "+JSON.stringify(BookService.query()));
	//$scope.books = [{name:"hello"},{name:"john"},{name:"doe"}];

//    $http.get('http://localhost:8080/book').
//    success(function(data) {
//		$scope.got = data;
//		$scope.books = data;
//        //console.log("got "+data.books);
//        //console.log("got1 "+JSON.stringify(data));
//    });

	$scope.abook = new BookService();
	$scope.addBook = function(){
		$scope.abook.$save(function(){
			console.log("saved book");
			$scope.rgot = BookService.query();
		});
	};
	
	$scope.delBook = function(){
		
		console.log("del id: "+$scope.delID);
		var item = BookService.remove({id:$scope.delID},function(){
			console.log("deleted ")
			console.log("got1 "+JSON.stringify(item));
			$scope.rgot = BookService.query();
		});
	};
	
	$scope.getBook= function(){
		console.log("Get id: "+$scope.gbook.id);
		$scope.gbook = BookService.get({id:$scope.gbook.id});
	};
	
	$scope.updateBook = function(){
		console.log("update id: "+$scope.gbook.id);
		var book = BookService.get({id:$scope.gbook.id},function(){
			book = $scope.gbook;
			book.$update(function(){
				console.log("updated book id: "+book.id);
				$scope.rgot = BookService.query();
			});
		});
	}
	
	
	

});