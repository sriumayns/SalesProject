<%-- 
    Document   : login
    Created on : Nov 7, 2016, 11:57:59 AM
    Author     : Mayu
--%>
<%
    Cookie[] cookies = null;
    cookies = request.getCookies();
//    out.println(cookies.length);
//    if (cookies.length>1){
//        String site = new String("http://localhost:8080/catalog.jsp");
//        response.setStatus(response.SC_MOVED_TEMPORARILY);
//        response.setHeader("Location", site); 
//    } else {
%>

<jsp:include page="views/login-view.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular-sanitize.js"></script>
<h2>Chat Sementara</h2>

        <!-- Trigger/Open The Modal -->
        <a href="#" id="myBtn">Open Chat</a>

        <!-- The Modal -->
        <div id="myModal" class="modal">
            <!-- Modal content -->
            <div class="modal-content" ng-app="chatApp" ng-controller="chatController">
                <div class="chat-header">
                    <span class="close">×</span>
                    <span class="chat-friend">Chatbox</span>
                </div>
                <div class="chat-box" ng-bind-html="chatHistory">
                    
                </div>
                
                <form ng-submit="inputChat = null">
                    <input type="text" name="msg" ng-model="inputChat" id="inputChat">
                    <button class="chat-button" ng-click="appendChat()">Kirim</button>
                </form>
                <script>
                    var chatApp = angular.module('chatApp', ['ngSanitize'])
                    function chatController($scope, $http) {
                        $scope.chatHistory = '';
                        $scope.appendChat = function() {
                            $scope.chatHistory = $scope.chatHistory + '<p class="chat-msg">' + $scope.inputChat +'</p>';
                            
                            //COBA AJAX
                            var data = "body=" + $scope.inputChat;

                            var config = {
                                headers : {
                                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                                }
                            }

                            $http.post('http://localhost:8080/Marketplace_ChatService/chat', data, config)
                            .success(function (data, status, headers, config) {
                                alert(data);
                            })
                            .error(function (data, status, header, config) {
                                alert(data + status + header + config);
                            });
            
                        }
                        //$scope.lalala.$setPristine();
                    }
                </script>
            </div>
        </div>


        <script>
        // Get the modal
        var modal = document.getElementById('myModal');

        // Get the button that opens the modal
        var btn = document.getElementById("myBtn");

        // Get the <span> element that closes the modal
        var span = document.getElementsByClassName("close")[0];

        // When the user clicks the button, open the modal
        btn.onclick = function() {
            modal.style.display = "block";
        }

        // When the user clicks on <span> (x), close the modal
        span.onclick = function() {
            modal.style.display = "none";
        }

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
        </script>

<% //} %>






