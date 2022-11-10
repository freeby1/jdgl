<%@ page language="java" import="java.util.*" contentType="text/html;charset=gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="<%=basePath %>images/css/bootstrap.css" />
<link rel="stylesheet" href="<%=basePath %>images/css/css.css" />
<script type="text/javascript" src="<%=basePath %>images/js/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="<%=basePath %>images/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>images/js/sdmenu.js"></script>
<script type="text/javascript" src="<%=basePath %>images/js/laydate/laydate.js"></script>
</HEAD>
<%
	String username=(String)session.getAttribute("user"); 
	if(username==null){
		response.sendRedirect(path+"index.jsp");
	}
	else{ 
%>
<body>
<div class="left">
     
<script type="text/javascript">
var myMenu;
window.onload = function() {
	myMenu = new SDMenu("my_menu");
	myMenu.init();
};
</script>

<div id="my_menu" class="sdmenu">

	<div class="collapsed">
		<span>密码信息管理</span>
		<a href="<%=basePath %>admin/system/editpwd.jsp" target="MainFrame">密码信息管理</a> 
	</div>
	<div class="collapsed">
		<span>景点信息管理</span>
		 <a href="<%=basePath %>admin/xw/index.jsp" target="MainFrame">景点信息管理</a> 
		 <a href="<%=basePath %>admin/xw/add.jsp?method=addxw" target="MainFrame">增加景点信息</a>  
		 <a href="<%=basePath %>admin/xw/s.jsp" target="MainFrame">景点信息查询</a> 
	</div> 
	

	<div class="collapsed">
		<span>会员类型管理</span>
		<a href="<%=basePath %>admin/lx/index.jsp" target="MainFrame">会员类型管理</a> 
		<a href="<%=basePath %>admin/lx/add.jsp?method=addlx" target="MainFrame">增加会员类型</a> 
	</div>
	<div class="collapsed">
		<span>注册用户管理</span>
		<a href="<%=basePath %>admin/member/index.jsp" target="MainFrame">注册用户管理</a> 
		<a href="<%=basePath %>admin/member/s.jsp" target="MainFrame">注册用户查询</a> 
	</div> 
	 
	 
	<div class="collapsed">
		<span>房间类型管理</span>
		<a href="<%=basePath %>admin/fl/index.jsp" target="MainFrame">房间类型管理</a> 
		<a href="<%=basePath %>admin/fl/add.jsp?method=addfl" target="MainFrame">增加房间类型</a> 
	</div>
	<div class="collapsed">
		<span>客房信息管理</span>
		 <a href="<%=basePath %>admin/jd/index.jsp" target="MainFrame">客房信息管理</a> 
		 <a href="<%=basePath %>admin/jd/add.jsp?method=addjd" target="MainFrame">增加客房信息</a>  
		 <a href="<%=basePath %>admin/jd/s.jsp" target="MainFrame">客房信息查询</a> 
	</div>
	 
	 
	<div class="collapsed">
		<span>客房预定管理</span>
		<a href="<%=basePath %>admin/dd/index.jsp" target="MainFrame">客房预定管理</a>  
		 <a href="<%=basePath %>admin/dd/s.jsp" target="MainFrame">客房预定查询</a>   
	</div> 
	
	 
	<div class="collapsed">
		<span>信息统计报表</span>
		<a href="<%=basePath %>admin/dd/t.jsp" target="MainFrame">信息统计报表</a>   
	</div> 
	 
 	<div class="collapsed">
		<span>注销退出系统</span>
		<a onclick="if (confirm('确定要退出吗？')) return true; else return false;" href="<%=basePath %>AdminServlet?method=adminexit" target="_top" >注销退出系统</a>
	</div> 
</div>
     </div>
     <div class="Switch"></div>
     <script type="text/javascript">
	$(document).ready(function(e) {
    $(".Switch").click(function(){
	$(".left").toggle();
	 
		});
});
</script> 
</body>
<%} %>

</html>
