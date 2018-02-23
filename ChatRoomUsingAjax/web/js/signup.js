/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    $("#button").click(function(){
        var name=$("#name").val();
        var pass=$("#pass").val();
        
        var JsonUser={"name":name,"pass":pass};
        
        $.ajax({
            
            url:"signUphandling" ,
            dataType: 'text',
            data:JsonUser,
            success:function (result){
                $("#div").innerHTML=result;
                
            }
            
        });
    });
});


