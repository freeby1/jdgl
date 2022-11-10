package com.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ComBean;
import com.util.Constant;

public class ComServlet extends HttpServlet {

	
	public ComServlet() {
		super();
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

		response.setContentType(Constant.CONTENTTYPE);
		request.setCharacterEncoding(Constant.CHARACTERENCODING);
		HttpSession session = request.getSession();
		ComBean cBean = new ComBean();
		String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		String method = request.getParameter("method");
		
		
		if(method.equals("addxw")){  //����֪ͨ  
			String bt = request.getParameter("bt"); 
			String fl = request.getParameter("fl");  
			String nr = request.getParameter("content1");    
			int flag = cBean.comUp("insert into xw(bt,fl,nr,sj)  values('"+bt+"','"+fl+"','"+nr+"','"+date+"')");
			if(flag == Constant.SUCCESS){ 
				request.setAttribute("message", "�����ɹ���");
				request.getRequestDispatcher("admin/xw/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "����ʧ�ܣ�");
				request.getRequestDispatcher("admin/xw/index.jsp").forward(request, response);
			} 
		} 
		else if(method.equals("upxw")){ //�޸Ĺ���֪ͨ 
			String id=request.getParameter("id");
			String bt = request.getParameter("bt"); 
			String fl = request.getParameter("fl");  
			String nr = request.getParameter("content1");   
			int flag = cBean.comUp("update xw set bt='"+bt+"',fl='"+fl+"',nr='"+nr+"' where id='"+id+"'");
			if(flag == Constant.SUCCESS){ 
				request.setAttribute("message", "�����ɹ���");
				request.getRequestDispatcher("admin/xw/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "����ʧ�ܣ�");
				request.getRequestDispatcher("admin/xw/index.jsp").forward(request, response);
			}  
		} 
		else if(method.equals("delxw")){//ɾ������֪ͨ
			String id = request.getParameter("id"); 
			int flag = cBean.comUp("delete from xw where id='"+id+"'");
			if(flag == Constant.SUCCESS){ 
				request.setAttribute("message", "�����ɹ���");
				request.getRequestDispatcher("admin/xw/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "����ʧ�ܣ�");
				request.getRequestDispatcher("admin/xw/index.jsp").forward(request, response);
			}
		}  
		
		else if(method.equals("addlx")){  //��Ա����  
			String lx = request.getParameter("lx"); 
			String zk = request.getParameter("zk");
			String str=cBean.getString("select id from lx where lx='"+lx+"'");
			if(str==null){
				int flag = cBean.comUp("insert into lx(lx,zk)  values('"+lx+"','"+zk+"')");
				if(flag == Constant.SUCCESS){ 
					request.setAttribute("message", "�����ɹ���");
					request.getRequestDispatcher("admin/lx/index.jsp").forward(request, response);
				}
				else{
					request.setAttribute("message", "����ʧ�ܣ�");
					request.getRequestDispatcher("admin/lx/index.jsp").forward(request, response);
				} 
			}
			else{
				request.setAttribute("message", "��Ϣ�ظ���");
				request.getRequestDispatcher("admin/lx/index.jsp").forward(request, response);
			} 
		} 
		else if(method.equals("uplx")){ //�޸Ļ�Ա���� 
			String id=request.getParameter("id");
			String lx = request.getParameter("lx"); 
			String zk = request.getParameter("zk"); 
			String str=cBean.getString("select id from lx where lx='"+lx+"' and id!='"+id+"'");
			if(str==null){
				int flag = cBean.comUp("update lx set lx='"+lx+"',zk='"+zk+"' where id='"+id+"'");
				if(flag == Constant.SUCCESS){ 
					request.setAttribute("message", "�����ɹ���");
					request.getRequestDispatcher("admin/lx/index.jsp").forward(request, response);
				}
				else{
					request.setAttribute("message", "����ʧ�ܣ�");
					request.getRequestDispatcher("admin/lx/index.jsp").forward(request, response);
				}  
			}
			else{
				request.setAttribute("message", "��Ϣ�ظ���");
				request.getRequestDispatcher("admin/lx/index.jsp").forward(request, response);
			} 
		} 
		else if(method.equals("dellx")){//ɾ����Ա����
			String id = request.getParameter("id"); 
			int flag = cBean.comUp("delete from lx where id='"+id+"'");
			if(flag == Constant.SUCCESS){ 
				request.setAttribute("message", "�����ɹ���");
				request.getRequestDispatcher("admin/lx/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "����ʧ�ܣ�");
				request.getRequestDispatcher("admin/lx/index.jsp").forward(request, response);
			}
		}  
		else if(method.equals("addfl")){  //��������   ***********����ע��  
			String mc = request.getParameter("mc");  
			String str=cBean.getString("select id from fl where mc='"+mc+"'");
			if(str==null){
				int flag = cBean.comUp("insert into fl(mc)  values('"+mc+"' )");
				if(flag == Constant.SUCCESS){ 
					request.setAttribute("message", "�����ɹ���");
					request.getRequestDispatcher("admin/fl/index.jsp").forward(request, response);
				}
				else{
					request.setAttribute("message", "����ʧ�ܣ�");
					request.getRequestDispatcher("admin/fl/index.jsp").forward(request, response);
				} 
			}
			else{
				request.setAttribute("message", "��Ϣ�ظ�");
				request.getRequestDispatcher("admin/fl/index.jsp").forward(request, response);
			} 
		} 
		else if(method.equals("delfl")){//ɾ����������
			String id = request.getParameter("id"); 
			int flag = cBean.comUp("delete from fl where id='"+id+"'");
			if(flag == Constant.SUCCESS){ 
				request.setAttribute("message", "�����ɹ���");
				request.getRequestDispatcher("admin/fl/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
				request.getRequestDispatcher("admin/fl/index.jsp").forward(request, response);
			}
		} 
		
		
		 
		else if(method.equals("hy")){ //�޸� 
			String id=request.getParameter("id");
			String lx = request.getParameter("lx");  
				int flag = cBean.comUp("update member set lx='"+lx+"' where id='"+id+"'");
				if(flag == Constant.SUCCESS){ 
					request.setAttribute("message", "�����ɹ���");
					request.getRequestDispatcher("admin/member/index.jsp").forward(request, response);
				}
				else{
					request.setAttribute("message", "����ʧ�ܣ�");
					request.getRequestDispatcher("admin/member/index.jsp").forward(request, response);
				}  
		}  
		
		else if(method.equals("deljd")){ //ɾ���ͷ�
			String id = request.getParameter("id"); 
			int flag = cBean.comUp("delete from jd where id='"+id+"'");
			if(flag == Constant.SUCCESS){ 
				request.setAttribute("message", "�����ɹ���");
				request.getRequestDispatcher("admin/jd/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "����ʧ�ܣ�");
				request.getRequestDispatcher("admin/jd/index.jsp").forward(request, response);
			}
		} 
		 
		else if(method.equals("jd")){  //�ͷ�Ԥ��
			String member=(String)session.getAttribute("member");
			String jdid = request.getParameter("jdid"); 
			if(member==null){ 
				request.setAttribute("message", "���ȵ�¼��");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else{ 
				request.setAttribute("jdid", jdid);
				request.getRequestDispatcher("jdyd.jsp").forward(request, response);
			}  
		} 
		else if(method.equals("jd2")){//Ԥ����Ϣ
			String ddh=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
			String jdid = request.getParameter("jdid");
			String dd = request.getParameter("dd");
			String member=(String)session.getAttribute("member");
			String sl = request.getParameter("sl");
			String mc= cBean.getString("select mc from jd where id='"+jdid+"'");
			String fl = cBean.getString("select fl from jd where id='"+jdid+"'"); 
			String jf = cBean.getString("select jf from jd where id='"+jdid+"'"); 
			String jg= cBean.getString("select jg from jd where id='"+jdid+"'");
			float zj=Integer.parseInt(sl)*Float.parseFloat(jg);
			String lx=cBean.getString("select lx from member where username='"+member+"'");
			int zk=cBean.getCount("select zk from lx where lx='"+lx+"'");
			float hyj=zj*zk/100;
			int hyjf=cBean.getCount("select sum(jf) from dd where member='"+member+"'");
			int xfjf=cBean.getCount("select sum(jf) from jf where member='"+member+"'");
			String strr="";
			if((hyjf-xfjf)>=1000){
				strr="ϵͳ�Զ�Ϊ���һ�1000���ֵֿ�5Ԫ";
				hyj=hyj-5;
			}
			String str=cBean.getString("select id from dd where jdid='"+jdid+"' and dd='"+dd+"' and jz='δ����'");
			if(str==null){
				int flag = cBean.comUp("insert into dd(jdid,ddh,mc,fl,jg,sl,zj,lx,hyj,jf,member,dd)  " +
						"values('"+jdid+"','"+ddh+"','"+mc+"','"+fl+"','"+jg+"','"+sl+"','"+zj+"','"+lx+"','"+hyj+"','"+jf+"','"+member+"','"+dd+"')");
				if(flag == Constant.SUCCESS){  
					if((hyjf-xfjf)>=1000){
						cBean.comUp("insert into jf(ddh,member,jf) values('"+ddh+"','"+member+"','1000' )");
					} 
					request.setAttribute("message", "�����ɹ�������"+lx+"������"+zk+"/100�ۿۣ��ۺ�ۣ�"+hyj+strr);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				else{ 
					request.setAttribute("message", "����ʧ�ܣ�");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}  
			}
			else{ 
				request.setAttribute("message", "�������Ѿ���Ԥ����");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}  
		}
		else if(method.equals("qxdd")){ //ȡ��Ԥ��
			String id = request.getParameter("id");  
				int flag = cBean.comUp("update dd set qx='��ȡ��' where id='"+id+"'");
				String ddh=cBean.getString("select ddh from dd where id='"+id+"'");
				if(flag == Constant.SUCCESS){  
					cBean.comUp("delete from jf where ddh='"+ddh+"'");
					request.setAttribute("message", "�����ɹ���");
					request.getRequestDispatcher("member/dd/index.jsp").forward(request, response);
				}
				else{
					request.setAttribute("message", "����ʧ�ܣ�");
					request.getRequestDispatcher("member/dd/index.jsp").forward(request, response);
				} 
		} 
		else if(method.equals("deldd")){  
			String id = request.getParameter("id"); 
			String str=cBean.getString("select sh from dd where id='"+id+"' ");
			if(str.equals("��ͨ��")){
				request.setAttribute("message", "�����ͨ������ȡ��������ϵ�ͷ��˹�����");
				request.getRequestDispatcher("member/dd/index.jsp").forward(request, response);
			}
			else{
				String ddh=cBean.getString("select ddh from dd where id='"+id+"'");
				int flag = cBean.comUp("delete from dd where id='"+id+"'");
				if(flag == Constant.SUCCESS){  
					cBean.comUp("delete from jf where ddh='"+ddh+"'");
					request.setAttribute("message", "�����ɹ���");
					request.getRequestDispatcher("member/dd/index.jsp").forward(request, response);
				}
				else{
					request.setAttribute("message", "����ʧ�ܣ�");
					request.getRequestDispatcher("member/dd/index.jsp").forward(request, response);
				}
			} 
		} 
		else if(method.equals("deldd2")){ //ɾ�ͷ�Ԥ��
			String id = request.getParameter("id");  
			String ddh=cBean.getString("select ddh from dd where id='"+id+"'");
			int flag = cBean.comUp("delete from dd where id='"+id+"'");
			if(flag == Constant.SUCCESS){  
				cBean.comUp("delete from jf where ddh='"+ddh+"'");
				request.setAttribute("message", "�����ɹ���");
				request.getRequestDispatcher("admin/dd/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "����ʧ�ܣ�");
				request.getRequestDispatcher("admin/dd/index.jsp").forward(request, response);
			}
		}   
		
		else if(method.equals("shdd")){ 
			String id=request.getParameter("id");
			String sh = request.getParameter("sh");  
			String tz = request.getParameter("tz");  
			int flag = cBean.comUp("update dd set sh='"+sh+"',tz='"+tz+"' where id='"+id+"'");
			if(flag == Constant.SUCCESS){  
				request.setAttribute("message", "�����ɹ���");
				request.getRequestDispatcher("admin/dd/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "����ʧ�ܣ�");
				request.getRequestDispatcher("admin/dd/index.jsp").forward(request, response);
			}  
		} 
		
		else if(method.equals("rz")){ 
			String id=request.getParameter("id");  
			int flag = cBean.comUp("update dd set rz='����ס' where id='"+id+"'");
			if(flag == Constant.SUCCESS){  
				request.setAttribute("message", "�����ɹ���");
				request.getRequestDispatcher("admin/dd/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "����ʧ�ܣ�");
				request.getRequestDispatcher("admin/dd/index.jsp").forward(request, response);
			}  
		} 
		else if(method.equals("jz")){ 
			String id=request.getParameter("id");  
			int flag = cBean.comUp("update dd set jz='�ѽ���' where id='"+id+"'");
			if(flag == Constant.SUCCESS){  
				request.setAttribute("message", "�����ɹ���");
				request.getRequestDispatcher("admin/dd/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "����ʧ�ܣ�");
				request.getRequestDispatcher("admin/dd/index.jsp").forward(request, response);
			}  
		}  
		
		else if(method.equals("pjdd")){ 
			String id=request.getParameter("id");
			String pf = request.getParameter("pf");  
			String pj = request.getParameter("pj");  
			int flag = cBean.comUp("update dd set pf='"+pf+"',pj='"+pj+"' where id='"+id+"'");
			if(flag == Constant.SUCCESS){  
				request.setAttribute("message", "�����ɹ���");
				request.getRequestDispatcher("member/dd/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "����ʧ�ܣ�");
				request.getRequestDispatcher("member/dd/index.jsp").forward(request, response);
			}  
		} 
	}

	
	public void init() throws ServletException {
		
	}

}
