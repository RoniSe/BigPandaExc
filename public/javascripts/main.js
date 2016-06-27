var app = angular.module('feedApp', []);
app.controller('feedCtrl' ,['$scope', '$http', function ($scope, $http) {
    var date = new Date();
    $scope.email ='';
    $scope.message ='';
    $scope.allMessages =[];
    $scope.filterTxt ='';
    $scope.loadMessages = function(){
        $http.get("/getAllMessages").success(function(data){
            $scope.allMessages = data;
        });
    }
    
    $scope.sendMsg = function(){
        var newMsg = {
            "email": $scope.email,
            "content": $scope.message,
            "timeStamp": date.getTime()
        };
        $scope.allMessages.push(newMsg);
         $http.post("/saveMsg", newMsg).success(function(data, status) {
            console.log(data);
        })
    }
    
    
}]);