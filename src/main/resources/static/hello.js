/**
 * Created by sebadmin on 2016-04-04.
 */


function Hello($scope, $http) {
    $http.get('localhost:8080/book').
    success(function(data) {
        $scope.greeting = data;
    });
}

angular.module("app", []).
controller('Hello', function($scope,$http) {
   $scope.greeting= {
       "id":123,
       "name":"hello world"
   };

    $http.get('http://localhost:8080/book').
    success(function(data) {
        $scope.greeting = data.books[0];
        console.log("got "+data.books);
        console.log("got1 "+JSON.stringify(data));
    });


});