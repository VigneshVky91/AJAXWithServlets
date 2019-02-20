<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
           function test()
           {
              var xhr = new XMLHttpRequest();            
              xhr.onreadystatechange = function()
              {
                if(this.readyState==4 && this.status ==200 )
                {
                    document.getElementById("content").innerText=this.responseText;
                }
              };
              xhr.open('POST','AjaxServ',true);
              xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
              xhr.send("name="+document.getElementById("user").value);
           }
        </script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <input type="text" id="user" onkeyup="test()"/>
        <div id="content"></div>
    </body>
</html>
