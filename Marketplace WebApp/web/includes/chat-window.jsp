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
        <div id="myModal" class="modal">
            <!-- Modal content -->
            <div class="modal-content">
                <div class="chat-header">
                    <span class="close">×</span>
                    <span class="chatfriend"` id="chatfriend">{{username}}</span>
                </div>
                <div class="chat-box" ng-bind-html="chatHistory">
                    
                </div>
                
                <form ng-submit="inputChat = null">
                    <input type="text" name="msg" ng-model="inputChat" id="inputChat">
                    <button class="chat-button" ng-click="appendChat()">Kirim</button>
                </form>
                <script>
                    var chatApp = angular.module('chatApp', ['ngSanitize'])
                   
                    function chatController($scope, $http, $window) {
                        $scope.chatHistory = '';
                        
                        $scope.appendChat = function() {
                            var to = document.getElementById('chatfriend').innerHTML;
                        
                            if ($scope.inputChat!=null){
                                $scope.chatHistory = $scope.chatHistory + '<p class="sent-msg">' + $scope.inputChat +'</p>';  
                            }
                            var data = "type=msg&msg=" + $scope.inputChat;
                            data += "&to=" + to;
                            console.log(data);
                            var config = {
                                headers : {
                                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                                }
                            }
                            $http.post('http://localhost:8080/Marketplace_ChatService/chat', data, config)
                            .success(function (data, status, headers, config) {
                                console.log('ok',data);
                            })
                            .error(function (data, status, header, config) {
                                alert("err", data + status + header + config);
                            });
                        }
                        appendIncomingChat = function(data) {
                            console.log("incoming chat", data);
                            $scope.chatHistory = $scope.chatHistory + '<p class="recv-msg">' + data +'</p>';
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


        <script>
        // Get the modal
        var modal = document.getElementById('myModal');

        // Get the button that opens the modal
        var btn = document.getElementById("openChat");

        // Get the <span> element that closes the modal
        var span = document.getElementsByClassName("close")[0];

     

        // When the user clicks on <span> (x), close the modal
        span.onclick = function() {
            modal.style.display = "none";
        };

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function(event) {
            if (event.target === modal) {
                modal.style.display = "none";
            }
        };
        </script>
