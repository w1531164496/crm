var path = "http://localhost:8080/crm/";
$(function(){
	$('#submit').on('click', function () {  
//
		
		var username=$('#userName').val();
		var password=$('#password').val();
		var code=$('#code').val();
		
		 $.ajax({
	            url: path +  'LoginServlet?action=login',
	            type: "POST",//方法类型
	            xhrFields: {
	                withCredentials: true
	            },
	            data: {
	             
	                username: username,
	                password:password,
	                code:code
	             
	            },
	            success: function (result) {
	            	var res=JSON.parse(result);//把json字符串转化成JSON对象	            	
	                if (res.code== 0) {
	                	
	                 
	                		
	                		window.location.href=path+"static/customer.html";
	                } 
	                else
	                {
	                   alert(res.msg);
	                }
	            }
	        })
	        return false;
	    });
		
		
		
		
		
		
		
		
		
		
		
		
		
	  }); 

