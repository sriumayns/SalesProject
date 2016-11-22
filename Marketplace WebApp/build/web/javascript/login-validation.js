/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validateLogin() {
    var redirect = true;
    var elmt = document.getElementById("username");
    if (elmt.value.equals("") ) {
        alert( "Username can't be empty!" );
        elmt.focus() ;
        return false;
    }
    
    elmt = document.getElementById("password");
    if (elmt.value.equals("") ) {
        alert( "Password can't be empty!" );
        elmt.focus() ;
        return false;
    }

    return redirect;
}

