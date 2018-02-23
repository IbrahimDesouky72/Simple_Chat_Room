/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $("#button").click(function(){
        var name=$("#name").val();
        var message=$("#msg").val();
        
        var JsonMessage={"name":name,"message":message};
        $("#msg").val('');
        $.ajax({
            
            url:"MessageServlet" ,
            dataType: 'json',
            data:JsonMessage,
            success:function (data){
                alert(data);
                
            }
            
        });
    });
});


        setInterval(function(){$.ajax({
            type: 'POST', //servlet request type
            contentType: 'application/json', //For input type //input data
            dataType: 'json',
            url:"MessageServlet",
            success:function(data){
               //var messageArray=JSON.parse(data);
               var div=$("#div");
               var d="<table border='2' align='left' class='customers'><tr><th>name</th><th>message</th></tr>";
               for(var i=0;i<data.length;i++){
                   d+="<tr><td>"+data[i].name+"</td><td>"+data[i].message+"</td></tr>";


               }
               d+="</table>";
              div.html(d);

            }

        });}, 3000);
    
    setInterval(function(){$.ajax({
            type: 'GET', //servlet request type
            contentType: 'application/json', //For input type //input data
            dataType: 'json',
            url:"OnlineServlet",
            success:function(data){
               //var messageArray=JSON.parse(data);
               var div=$("#div2");
               var d="<table border='2' class='customers' align='right' ><tr><th>name</th></tr>";
               for(var i=0;i<data.length;i++){
                   d+="<tr><td>"+data[i].name+"</td></tr>";


               }
               d+="</table>";
              div.html(d);

            }

        });}, 3000);
    
