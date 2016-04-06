/**
 * Created by seb on 2016-04-06.
 */
angular.module('app.services',[]).factory('BookService', ['$resource', function ($resource) {
    //$resource() function returns an object of resource class.
    return $resource(
        'http://localhost:8080/book/:id',
        {id:'@id'},//parameters
        {
            update: {
                method: 'PUT' // To send the HTTP Put request when calling this custom update method.
            }

        }
    );
}]);