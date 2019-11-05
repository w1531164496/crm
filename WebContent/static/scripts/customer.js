var path = "http://localhost:8080/crm/";

layui.use(['table', 'form', 'layedit', 'upload'], function () {
    var layedit = layui.layedit;
    var table = layui.table;
    var form = layui.form;
    var upload = layui.upload;
    var $ = layui.jquery;
    var index; 
    var ins1;
    var Exceldata;
   ins1= table.render({
        elem: '#idTest'
        , height: 'full-200'
        , url: path + 'CustomerServlet?action=sel'
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
            ,{field: 'telephone', title: '联系方式', minWidth: 150}
            ,{field: 'status', title: '状态', minWidth: 160}
            ,{field: 'record', title: '沟通记录', width: 120}
            ,{field: 'Region', title: '区域', minWidth: 150}
            ,{field: 'Employeeid', title: '员工编号', minWidth: 160}
            , { fixed: '', width: 178, align: 'center', toolbar: '#barDemo' }
        ]]
   
        });
    //监听
    table.on('tool(tool-event)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('确认删除', function (index) {
                $.ajax({
                    url: path + "CustomerServlet?action=del",
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
        } 
        else if (obj.event === 'edit') {
            layer.open({
                type: 1,
                title: '客户修改',
                shadeClose: false,
                shade: 0.8,
                maxmin: true,
                area: ['75%', '70%'],
                content: $("#update"),
            });
         
           
            
            setFormValue(index, data);
            //form.render('select', 'update');
        }
        /**
         * 显示数据
         */
        function setFormValue(index, data) {
            $('#id').val(data.id);
            $("#name").val(data.name);
            $("#telephone").val(data.telephone);
            $("#status").val(data.status);
            $("#record").val(data.record);
            $("#region").val(data.Region);
            $("#Employeeid").val(data.Employeeid);
      
            
        }
        /**
         * 修改保存
         */
        form.on('submit(save-update)', function () {      
            var id = parseInt( $('#id').val());
            var name = $('#name').val();
            var telephone = $('#telephone').val();
            var status = $('#status').val();
            var record = $('#record').val();
            var region = $('#region').val();
            var Employeeid = parseInt($('#Employeeid').val());
       
            $.ajax({
                url: path + 'CustomerServlet?action=upd',
                type: "POST",//方法类型
                xhrFields: {
                    withCredentials: true
                },
                data: {
                	id: id,
                	name: name,
                	telephone: telephone,
                	status: status,
                	record: record,
                	region: region,
                	Employeeid: Employeeid
                  
                },
                success: function (result) {
                	var res=JSON.parse(result);
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
    });
    /**
     * 搜索框和添加按钮的事件
     */
    //通过class选择元素，为元素添加点击事件
    $('.demoTable  .layui-btn').on('click',function(){
    	var type = $(this).data('type');//获取点击的元素的data-type数据类型
    	  active[type] ? active[type].call(this) : '';        
    });
    /**
     * 搜索框和添加按钮的事件的实现
     */
    var $ = layui.$,active = {
    		increase:function(){
    			layer.open({
    				type:1,
    				title:'客户添加',
    				shadeClose:false,
    				shade:0.7,
    				maxmin:true,
    				area:['75%','70%'],
    				content: $("#add")
    				
    			});
    		},
    		 reload:function(){
    	            var chaxun=$('#condition').val();
    	            var key=$('#key').val();
    	            table.reload('tableReload',{
    	            	
    	        		url:path + 'CustomerServlet?action=selbycon'
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
    	            	
    	            	
    	                
    	            	
    	            	table.exportFile("tableReload",Excaldata, "xls");
    	            }
    	
    };
    /**
     * 添加保存
     */
    form.on('submit(save-add)',function(){
    	var nameadd=$('#nameadd').val();
    	var telephoneadd=$('#telephoneadd').val();
    	var statusadd=$('#statusadd').val();
    	var recordadd=$('#recordadd').val();
    	var regionadd=$('#regionadd').val();
    	var Employeeidadd=parseInt($('#Employeeidadd').val());
    	
    	
    	$.ajax({
    		 url: path + "CustomerServlet?action=ins",
             type: "POST",//方法类型
             xhrFields: {
                 withCredentials: true
             },
             data:{
            	
             	nameadd: nameadd,
             	telephoneadd: telephoneadd,
             	statusadd: statusadd,
             	recordadd: recordadd,
             	regionadd: regionadd,
             	Employeeidadd: Employeeidadd
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

