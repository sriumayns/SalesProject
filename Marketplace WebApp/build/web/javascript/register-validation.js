/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function valRegister() {
   
    var elmt = document.getElementById("fullname");
    if (elmt.value == "" ) {
        alert( "Please provide the fullname!" );
        elmt.focus() ;
        return false;
    }
    
    elmt = document.getElementById("username");
    if (elmt.value == "" ) {
        alert( "Please provide username!" );
        elmt.focus() ;
        return false;
    }
    
    elmt = document.getElementById("email");
    if (elmt.value == "" ) {
        alert( "Please provide email!" );
        elmt.focus() ;
        return false;
    }
    
    elmt = document.getElementById("email");
    if (!validateEmail()) {
        alert( "Wrong email address!" );
        elmt.focus() ;
        return false;
    }
    
    elmt = document.getElementById("password");
    if (elmt.value == "" ) {
        alert( "Password can't be empty!" );
        elmt.focus() ;
        return false;
    }
    
    elmt = document.getElementById("confirmpassword");
    if (elmt.value == "" ) {
        alert( "Please confirm your password!" );
        elmt.focus() ;
        return false;
    }
    
    elmt = document.getElementById("password");
    if (elmt.value != document.getElementById("confirmpassword").value) {
        alert( "Password not confirmed!" );
        elmt.focus() ;
        return false;
    }
    
    elmt = document.getElementById("address");
    if (elmt.value == "") {
        alert( "Please provide address!" );
        elmt.focus() ;
        return false;
    }
    
    elmt = document.getElementById("postalcode");
    if (elmt.value == "" ) {
        alert( "Please provide postal code!" );
        elmt.focus() ;
        return false;
    }

    elmt = document.getElementById("phonenumber");
    if (elmt.value == "" ) {
        alert( "Please provide phonenumber!" );
        elmt.focus() ;
        return false;
    }

    var r = confirm("Do you really want to continue?");
    if (r == true)
        return true;
    else
        return false;
    
}

function validateEmail() {
    var email = document.getElementById("email").value;
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}
