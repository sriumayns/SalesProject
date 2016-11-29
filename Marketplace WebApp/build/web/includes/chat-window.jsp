<%-- 
    Document   : chat-window
    Created on : Nov 26, 2016, 7:59:38 PM
    Author     : Mayu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular-sanitize.js"></script>

        <!-- The Modal -->
        <div id="myModal" class="modal" ng-show="chatBox" >
            <!-- Modal content -->
            <div class="modal-content">
                <div class="chat-header">
                    <span class="close" ng-click="chatBox=false;">×</span>
                    <ul class="chat-friend">
                        <li><span>{{username}}</span></li>
                    </ul>
                </div>
                <div class="chat-box" ng-bind-html="chatHistory">
                    
                </div>
                
                <form ng-submit="inputChat = null">
                    <input type="text" name="msg" ng-model="inputChat" id="inputChat">
                    <button class="chat-button" ng-click="appendChat()">Kirim</button>
                </form>
                <script>
                    var chatApp = angular.module('chatApp', ['ngSanitize'])
                    function chatController($scope) {
                        $scope.chatHistory = '';
                        $scope.username = 'aa';
                        $scope.chatBox = false;
                        $scope.appendChat = function() {
                            if ($scope.inputChat!=null){
                                $scope.chatHistory = $scope.chatHistory + '<p class="sent-msg">' + $scope.inputChat +'</p>';  
                                $scope.chatHistory = $scope.chatHistory + '<p class="recv-msg">' + $scope.inputChat +'</p>';  
                            }
                        }
                        $scope.showChat = function(user) {
                            console.log(user);
                            $scope.chatBox = !$scope.chatBox;
                            console.log($scope.chatBox);
                            $scope.username = user;
                        }
                        appendIncomingChat = function(data) {
                            console.log("incoming chat", data);
                            $scope.chatHistory = $scope.chatHistory + '<p class="chat-msg">' + data +'</p>';
                            console.log($scope.chatHistory);
                            $scope.$apply();
                        }
                        messaging.onMessage(function(payload)
                        {
                                //console.log('test');
                                var data = payload.notification.body;
                                console.log('onmessage',data);
                                appendIncomingChat(data);
                        })
                        //$scope.lalala.$setPristine();
                    }
                    
                    
                    
                </script>
            </div>
        </div>
