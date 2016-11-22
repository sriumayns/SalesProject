/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function valpurchase() {
    var elmt = document.getElementById("fullname");
    if (elmt.value == "" ) {
        alert( "Please provide the reciever's full name!" );
        elmt.focus() ;
        return false;
    }

    elmt = document.getElementById("quantity");
    if (elmt.value == "" ) {
        alert( "Please provide product quantity!" );
        elmt.focus() ;
        return false;
    }
    if (isNaN(elmt.value)) {
        alert( "Product quantity must be an integer!" );
        elmt.focus() ;
        return false;
    }
    if (elmt.value < 1) {
        alert( "Product quantity must be at least 1!" );
        elmt.focus() ;
        return false;
    }

    elmt = document.getElementById("postalcode");
    if (elmt.value == "" ) {
        alert( "Please provide postal code!" );
        elmt.focus() ;
        return false;
    }
    if (isNaN(elmt.value)) {
        alert( "Postal code must be an integer!" );
        elmt.focus() ;
        return false;
    }

    elmt = document.getElementById("phonenumber");
    if (elmt.value == "" ) {
        alert( "Please provide phonenumber!" );
        elmt.focus() ;
        return false;
    }
    if (isNaN(elmt.value)) {
        alert( "Phone number must be an integer!" );
        elmt.focus() ;
        return false;
    }

    elmt = document.getElementById("creditnumber");
    if (elmt.value == "" ) {
        alert( "Please provide credit card number!" );
        elmt.focus() ;
        return false;
    }
    if (isNaN(elmt.value)) {
        alert( "Credit card number must be an integer!" );
        elmt.focus() ;
        return false;
    }
    if (elmt.value.length != 12) {
        alert( "Credit card number must be exactly 12 digits!" );
        elmt.focus() ;
        return false;
    }

    elmt = document.getElementById("creditverify");
    if (elmt.value == "" ) {
        alert( "Please provide credit card verification number!" );
        elmt.focus() ;
        return false;
    }
    if (isNaN(elmt.value)) {
        alert( "Credit card erification number must be an integer!" );
        elmt.focus() ;
        return false;
    }
    if (elmt.value.length != 3) {
        alert( "Credit card verification number must be exactly 3 digits!" );
        elmt.focus() ;
        return false;
    }

    var r = confirm("Apakah data yang anda masukan benar?");
    if (r == true)
        return true;
    else
        return false;
}

function calculatePrice(price)
{
    var qua = parseInt(document.getElementById("quantity").value);
    var elmt = qua*price;
    return elmt;
}

function totalPrice(price)
{
    document.getElementById("total").innerHTML = "Total Price : " + calculatePrice(price); 
}

