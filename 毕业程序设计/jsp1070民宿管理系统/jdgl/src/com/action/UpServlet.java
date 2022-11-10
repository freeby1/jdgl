package com.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ComBean;
import com.util.Constant;
import com.util.SmartFile;
import com.util.SmartUpload;

public class UpServlet extends HttpServlet {

	private ServletConfig config;
	
	public UpServlet() {
		super();
	}

	final public void init(ServletConfig config) throws ServletException
    {
        this.config = config;  
    }

    final public ServletConfig getServletConfig()
    {
        return config;
    }
	
	public void destroy() {
		super.destroy();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding(Constant.CHARACTERENCODING);
		response.setContentType(Constant.CONTENTTYPE);
		String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		String date2=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		String method = "";;
		ComBean cb = new ComBean(); 
		SmartUpload mySmartUpload = new SmartUpload();//init
		int count = 0;
		HttpSession session = request.getSession();
		try{
			mySmartUpload.initialize(config,request,response);
            mySmartUpload.upload(); 
            method = mySmartUpload.getRequest().getParameter("method").trim();
            if(method.equals("addjd")){// 上传  String mc="";String fl="";String jg=""; String pic="";String nr="";String zt="";
            	String mc = mySmartUpload.getRequest().getParameter("mc");  
            	String fl = mySmartUpload.getRequest().getParameter("fl");  
            	String jg = mySmartUpload.getRequest().getParameter("jg");  
            	String jf = mySmartUpload.getRequest().getParameter("jf");  
            	String nr = mySmartUpload.getRequest().getParameter("content1");   
            	SmartFile file = mySmartUpload.getFiles().getFile(0); 
            	String fileExt=file.getFileExt();	            
            	String path="upfile";
            	count = mySmartUpload.save(path);   
				int flag=cb.comUp("insert into jd(mc,fl,jg,url,nr,jf) values('"+mc+"','"+fl+"','"+jg+"','"+path+"/"+file.getFileName()+"','"+nr+"','"+jf+"' )");
				if(flag == Constant.SUCCESS){ 
					request.setAttribute("message", "操作成功！");
					request.getRequestDispatcher("admin/jd/index.jsp").forward(request, response); 
				}
				else { 
					request.setAttribute("message", "操作失败！");
					request.getRequestDispatcher("admin/jd/index.jsp").forward(request, response); 
				}  
            } 					
            else if(method.equals("upjd")){//修改  
            	String id = mySmartUpload.getRequest().getParameter("id");
            	String mc = mySmartUpload.getRequest().getParameter("mc");  
            	String fl = mySmartUpload.getRequest().getParameter("fl");  
            	String jg = mySmartUpload.getRequest().getParameter("jg");  
            	String jf = mySmartUpload.getRequest().getParameter("jf");  
            	String nr = mySmartUpload.getRequest().getParameter("content1");   
            	SmartFile file = mySmartUpload.getFiles().getFile(0); 
            	String fileExt=file.getFileExt();	            
            	String path="upfile";
            	count = mySmartUpload.save(path); 
            	if(count==0){
            		int flag=cb.comUp("update jd set mc='"+mc+"',fl='"+fl+"',jg='"+jg+"',nr='"+nr+"',jf='"+jf+"' where id='"+id+"'");
    				if(flag == Constant.SUCCESS){ 
    					request.setAttribute("message", "操作成功！");
    					request.getRequestDispatcher("admin/jd/index.jsp").forward(request, response); 
    				}
    				else { 
    					request.setAttribute("message", "操作失败！");
    					request.getRequestDispatcher("admin/jd/index.jsp").forward(request, response); 
    				}
            	}
            	else{ 
            		int flag = cb.comUp("update jd set mc='"+mc+"',fl='"+fl+"',jg='"+jg+"',url='"+path+"/"+file.getFileName()+"',nr='"+nr+"',jf='"+jf+"' where id='"+id+"' ");
            		if(flag == Constant.SUCCESS){ 
    					request.setAttribute("message", "操作成功！");
    					request.getRequestDispatcher("admin/jd/index.jsp").forward(request, response); 
    				}
    				else { 
    					request.setAttribute("message", "操作失败！");
    					request.getRequestDispatcher("admin/jd/index.jsp").forward(request, response); 
    				}
            	}                    
            }
            
            
		}catch(Exception e){
			e.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	
	public void init() throws ServletException {
		
	}

}
