angular.module('app.controllers',[]).controller('AppCtrl',function($scope,BookService){
    $scope.rgot = BookService.query();


    $scope.getBook = function() {
        var id = $scope.gbook.id;
        $scope.gbook = BookService.get({id: id},function(){
           //got book

        });
    };

    $scope.updateBook= function(){
        $scope.gbook.$update(function(){
            
           console.log("updated book");
            $scope.rgot = BookService.query();
        });
    }
    
    $scope.delBook = function(){
        var delid = $scope.delID;
        var delBook = BookService.get({id: delid},function(){
           //got book
            delBook.$delete(function(){
                $scope.rgot = BookService.query();
            });

        });
        
    }
    
    $scope.addBook = function()
    {
        var newbook = $scope.abook;
        BookService.save(newbook,function(){                  
            $scope.rgot = BookService.query();
        });
    }

});