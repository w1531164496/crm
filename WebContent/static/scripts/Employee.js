// var path = 'http://47.111.0.239:666/'
var path = "http://localhost:8080/crm/";

layui.use(['table', 'form', 'layedit', 'upload'], function () {
    var layedit = layui.layedit;
    var table = layui.table;
    var form = layui.form;
    var upload = layui.upload;
    var $ = layui.jquery;
    var index; 
    var index1;//修改用富文本框
    var ins1;
    var Exceldata;
   ins1= table.render({
        elem: '#idTest'
        , height: 'full-200'
        , url: path + 'EmployeeServlet?action=sel'
        , id: 'tableReload'
       
        , page: true
        , layout: ['prev', 'page', 'next', 'limit', 'refresh', 'skip']
        , limit: 10
        ,parseData: function(res){ //res 即为原始返回的数据        
        	Exceldata=res.data;
            return {
              "code": res.code, //解析接口状态
              "msg": res.msg, //解析提示文本
              "count": res.count, //解析数据长度
              "data": res.data //解析数据列表
            };
        }
        , cols: [[
            {field: 'id', title: 'ID', width: 80, sort: true}
            ,{field: 'name', title: '姓名', width: 120}
            ,{field: 'Schoolid', title: '校区id', minWidth: 150}
            ,{field: 'telephone', title: '联系方式', minWidth: 160}
            ,{field: 'Address', title: '住址', width: 120}
            ,{field: 'Nativeplace', title: '籍贯', width: 120}
            ,{field: 'Password', title: '密码', width: 120}
            ,{field: 'Gender', title: '性别', width: 120}
            ,{field: 'Username', title: '用户名', width: 120}
            ,{field: 'nickname', title: '昵称', width: 120}
            ,{field: 'headportrait', title: '头像', width: 120}
            ,{field: 'Remarks', title: '备注', width: 120}
            ,{field: 'role', title: '角色', width: 120}
            , { fixed: '', width: 178, align: 'center', toolbar: '#barDemo' }
        ]]
        
          
        });
    //监听表格每一行的删除修改按钮
    table.on('tool(demo)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('确认删除', function (index) {
                $.ajax({
                    url: path + "EmployeeServlet?action=del",
                    xhrFields: {
                        withCredentials: true
                    },
                    data: {
                        id: data.id,
                    },
                    success: function (result) {
                        obj.del();
                        layer.close(index);
                        layer.msg('删除成功', { icon: 1 });
                        location.reload();
                    }
                })
            });
        } else if (obj.event === 'edit') {
            layer.open({
                type: 1,
                title: '员工修改',
                shadeClose: false,
                shade: 0.8,
                maxmin: true,
                area: ['75%', '70%'],
                content: $("#update"),
            });
            
            layedit.set({
                uploadImage: {
                    url: 'http://localhost:8080/crm/UploadServlet' //接口url
                    ,type: 'post' //默认post
                }
                });                
              index1=layedit.build('remarks'); //建立编辑器
            setFormValue(index, data);
            //form.render('select', 'updateA');
                }
               
                    });
    
    /**
     * 显示数据
     */
    function setFormValue(index, data) {
        $('#id').val(data.id);
        $("#name").val(data.name);
        $("#telephone").val(data.telephone);
        $("#address").val(data.Address);
        $("#password").val(data.Password);
        $("#gender").val(data.Gender);
        $("#username").val(data.Username);
        $("#nickname").val(data.nickname);
        $("#remarks").val(data.Remarks);
        $("#headportrait").val(data.headportrait);
        $("#Schoolid").val(data.Schoolid);
        $("#nativeplace").val(data.Nativeplace);
        $("#role").val(data.role);
               
    }
    /**
     * 按钮“提交”
     */
    form.on('submit(demo1)', function () {  
        var id = parseInt( $('#id').val());
        var name = $('#name').val();
        var telephone = $('#telephone').val();
        var address = $('#address').val();
        var password = $('#password').val();
        var gender =$('#gender').val();
        var nativeplace=$('#nativeplace').val();
        var username = $('#username').val();
        var nickname = $('#nickname').val();
        var remarks = layedit.getContent(index1); 
        var headportrait = $('#headportrait').val();
        var Schoolid = parseInt($('#Schoolid').val());
        var role=$('#role').val();
        

        
        
        $.ajax({
            url: path + "EmployeeServlet?action=upd",
            type: "POST",//方法类型
            xhrFields: {
                withCredentials: true
            },
            data: {
                id: id,
                nativeplace:nativeplace,
                name: name,
                telephone: telephone,
                address: address,
                password: password,
                gender: gender,
                username: username,
                nickname: nickname,
                remarks: remarks,
                headportrait: headportrait,
                Schoolid: Schoolid,
                role:role
             
            },
            success: function (result) {
            	var res=JSON.parse(result);//把json字符串转化成JSON对象
                if (res.code== 0) {
                    layer.msg(res.msg, function(){
                    	window.parent.location.reload();
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);                        	
                    	}); 
                    
                } else {
                    layer.msg('修改失败');
                }
            },
        })
        return false;
    });
    /**
     * 搜索框和添加按钮的事件
     */
    $('.demoTable .layui-btn').on('click', function () {    	
        var type = $(this).data('type'); //获取点击的元素的 data-type属性值 data-type="reload"
        active[type] ? active[type].call(this) : '';        
      }); 

    /**
     * 搜索框和添加按钮的事件实现
     */

    var $ = layui.$, active = {
    		increase: function () {
                layer.open({
                    type: 1,    //此处是1的话，content可以接受一个div作为内容,  是2的话，需要一个独立网页
                    title: '员工添加',
                    shadeClose: false,
                    shade: 0.7,
                    maxmin: true,
                    area: ['75%', '70%'],
                    content: $("#add")
                    //content: 'commodityListAdd2.html' //如果是2的话，需要单独的页面
                });
                
                
                
                layedit.set({
                uploadImage: {
                    url: 'http://localhost:8080/crm/UploadServlet' //接口url
                    ,type: 'post' //默认post
                }
                });                
              index=layedit.build('remarksadd'); //建立编辑器
              
                
                
                
                
                
                
                
            } ,
            reload:function(){
            var chaxun=$('#condition').val();
            var key=$('#key').val();
            table.reload('tableReload',{
            	//EmployeeServlet?action=upd
        		url:path + 'EmployeeServlet?action=selbycon'
        		,page:{
        			 curr: 1
        		}
        		,where:{
        			
        			chaxun:chaxun,
        			key:key
        		}
        		
        	});
            },
            daochu:function(){
            	
            	
            
            	
            	table.exportFile("tableReload",Exceldata, "xls");
            }
            
         
        };
    /**
     * 添加保存
     */
    form.on('submit(save-add)', function () {     
        var nameadd = $('#nameadd').val();
        var telephoneadd = $('#telephoneadd').val();
        var addressadd = $('#addressadd').val();            
        var passwordadd = $('#passwordadd').val();
        var genderadd = $('#genderadd').val();
        var usernameadd = $('#usernameadd').val();
        var nicknameadd = $('#nicknameadd').val();
        var remarksadd = layedit.getContent(index); 
        var headportraitadd = $('#headportraitadd').val();
        var Schoolidadd = parseInt($('#Schoolidadd').val());
      var nativeplaceadd = $('#nativeplaceadd').val();
      var roleadd=$('#roleadd').val();
        $.ajax({
            url: path + "EmployeeServlet?action=ins",
            type: "POST",//方法类型
            xhrFields: {
                withCredentials: true
            },
            data: {                
            	nameadd: nameadd,
            	telephoneadd: telephoneadd,
            	addressadd: addressadd,    
            	passwordadd: passwordadd, 
            	genderadd: genderadd, 
            	usernameadd: usernameadd, 
            	nativeplaceadd:nativeplaceadd,
            	nicknameadd: nicknameadd, 
            	remarksadd: remarksadd, 
            	headportraitadd: headportraitadd, 
            	Schoolidadd: Schoolidadd,
            	roleadd:roleadd
            },
            success: function (result) {
            	var res=JSON.parse(result);//把json字符串转化成JSON对象
                if (res.code== 0) {
                    
                    layer.msg(res.msg, function(){
                    	window.parent.location.reload();
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);                        	
                    	}); 
                    
                } else {
                    layer.msg('添加失败');
                }
            },
        })
        return false;
    });
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
               
            });


        