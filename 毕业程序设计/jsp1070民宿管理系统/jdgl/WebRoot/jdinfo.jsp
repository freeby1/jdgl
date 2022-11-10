<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312" %>
<%@ include file="iframe/head.jsp" %>  
<%
	String id=request.getParameter("id"); if(id==null)id=(String)request.getAttribute("id");
	List list=cb.get1Com("select * from jd where id='"+id+"'",7);	 
%>
<div class="main">
 <div class="narea"><div>
	<img height="126" src="<%=basePath %>images/zgm.jpg" width="1020"> 
</div></div>
<div class="cmain">
  <div class="rmain"> 
      <div class="rdetail">
<div class="rdtitle"><span><%=list.get(1).toString() %></span></div>
<div class="rdmark">
客房分类：<%=list.get(2).toString() %>    价格：<%=list.get(3).toString() %>    积分：<%=list.get(6).toString() %> 
 
<a href="<%=basePath %>ComServlet?method=jd&jdid=<%=id%>">预定</a> 
</div>
<div class="rcontent"><center><img src="<%=basePath+list.get(4).toString() %>" border="0" /></center></div>
<div class="rcontent"><%=list.get(5).toString() %></div>

<div class="rlist">  
   <table width="100%" border="0" align="left" cellpadding="4" cellspacing="0" class="rtable">
	  <tbody>
	  <tr class="tr1">
			<td class="rldate daslist">预订用户</td>
			<td class="rldate daslist">预订日期</td>  
         </tr> 
<%    
	List pagelist3 = cb.getCom("select * from dd where jdid='"+id+"' and jz='未结账' order by id desc",13); 
		if(!pagelist3.isEmpty()){
		for(int i=0;i<pagelist3.size();i++){
			List pagelist2 =(ArrayList)pagelist3.get(i);
%>
	     <tr class="tr<%=(i)%2%>"> 
            <td class="rltitle dotlist"><%=pagelist2.get(11).toString() %></td>  
            <td class="rldate daslist"><%=pagelist2.get(12).toString() %></td>  
         </tr> 
<% }} %>        
      </tbody></table> 
</div>
</div> 
</div>
</div>
</div>
<%@ include file="iframe/foot.jsp"%>
