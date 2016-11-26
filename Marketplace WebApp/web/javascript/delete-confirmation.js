/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validateDelete() {
    var result = confirm("Are you sure want to delete this product?");
    if (result) {
        return true;
    } else {
        return false;
    }
}
