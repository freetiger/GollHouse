package cn.goll.servlet.brokeres;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import cn.goll.common.DoPage;
import cn.goll.entity.Brokers;
import cn.goll.entity.House_Imgs;
import cn.goll.entity.Houses;
import cn.goll.entity.Managers;
import cn.goll.entity.Personals;
import cn.goll.service.IBrokersService;
import cn.goll.service.IHouse_ImgsService;
import cn.goll.service.IHousesService;
import cn.goll.service.IManagersService;
import cn.goll.service.impl.BrokersServiceImpl;
import cn.goll.service.impl.House_ImgsServiceImpl;
import cn.goll.service.impl.HousesServiceImpl;
import cn.goll.service.impl.ManagersServiceImpl;
import cn.goll.service.impl.PersonalsServiceImpl;

public class BrokeresServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String method=request.getParameter("method");
		 if(method.equals("register"))Register(request,response);
		 if(method.equals("check"))Check(request,response);
		 if(method.equals("checklogin"))checkLogin(request,response);
		 if(method.equals("login"))Login(request,response);
		 if(method.equals("query"))Query(request,response);
		 if(method.equals("deleteAll"))DeleteAll(request,response);
		 if(method.equals("delete"))Delete(request,response);
		 if(method.equals("ischeckAll"))IscheckAll(request,response);
		 if(method.equals("ischeck"))Ischeck(request,response);
		 if(method.equals("logout"))LogOut(request,response);
		 if(method.equals("selForFront"))selForFront(request,response);
		 if(method.equals("findPwd"))FindPwd(request,response);
		 if(method.equals("preupdatePwd"))PreUpdatePwd(request,response);
		 if(method.equals("updatePwd"))UpdatePwd(request,response);
		 if(method.equals("update"))Update(request,response);
		 
	}

	private void Register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String b_name = request.getParameter("b_name");
		String b_realname = request.getParameter("b_realname");
		String b_card = request.getParameter("b_card");
		String b_email = request.getParameter("b_email");
		String b_tel = request.getParameter("b_tel");
		String c_id = request.getParameter("c_id");
		String b_infos = request.getParameter("b_infos");
		int pwd = (int) (Math.random() * 1000000);
		Brokers broker = new Brokers();
		broker.setB_name(b_name);
		broker.setB_realname(b_realname);
		broker.setB_card(b_card);
		broker.setB_email(b_email);
		broker.setB_tel(b_tel);
		broker.setC_id(Integer.parseInt(c_id));
		broker.setB_infos(b_infos);
		broker.setB_grade("0");
		broker.setB_level("0");
		broker.setB_ischeck("0");
		String	strpwd="";
		if(String.valueOf(pwd).length()<6)
			strpwd=String.valueOf(pwd)+"0";
		else
			strpwd=String.valueOf(pwd);
		strpwd=DigestUtils.md5Hex((DigestUtils.md5Hex(String.valueOf(strpwd))+b_email));
		broker.setB_pwd(strpwd);
		IBrokersService brokerService = new BrokersServiceImpl();
		PrintWriter out = response.getWriter();
		if (brokerService.insertBrokers(broker)) {
			ServletContext application=this.getServletContext();
			application.setAttribute("Overbroker", (Integer)application.getAttribute("Overbroker")+1);
			application.setAttribute("OverbrokerAll", (Integer)application.getAttribute("OverbrokerAll")+1);
			try{
					Properties props = new Properties();
					props.put("mail.smtp.auth", "true");
					props.put("mail.transport.protocol", "smtp");
					props.put("mail.smtp.port", "25");
					props.put("mail.smtp.host", "smtp.qq.com");
					Session session = Session.getInstance(props,
							new Authenticator() {
								protected PasswordAuthentication getPasswordAuthentication() {
									return new PasswordAuthentication("1743493016@qq.com", "13540154982");
									// 此处填写正确的邮箱账户密码
								}
							}); // 连接邮件服务器  
					Message mimeMessage = new MimeMessage(session); // Message
					mimeMessage.setFrom(new InternetAddress("1743493016@qq.com"));//来自哪个邮箱
					mimeMessage.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(b_email));//收取的邮箱号�?5137049@qq.com 651365883 。。。609357776
					mimeMessage.setSentDate(new Date());
					mimeMessage.setSubject("您好，感谢你注册成为Goll租房网的一员，我们因有你而精彩");
					mimeMessage.setContent("<p align='center'>***************************************************************************** <br/>"+"您好,感谢您注册成为Goll租房网的一员，您已注册成功，但您的账户需要进行首次登陆激活，<br/>登陆密码为："+pwd+". 请到指定的网页进行登陆激活<br/><a href='http://localhost:8080/GollHouse/front/brokeres/web_page/brokerLogin.jsp'>http://localhost:8080/GollHouse/front/brokeres/web_page/brokerLogin.jsp</a>，<br/>我们会在1个工作日内给你反馈，谢谢您的合作。<br/>"+"  ****************************************************************************</p>", "text/html;charset=utf-8");
					Transport.send(mimeMessage);
					//out.print("<script>alert('邮件已发送请注意查收,如果您一直收不到激活邮件，请检查：1. 请确认是否填写正确的邮箱地址："+b_email+" 2.请注意查看您邮箱中的垃圾邮件，可能 oschina 的邮件被误杀了');</script>");

			}catch (Exception e) {
				out.print("发送异常 ，可能网络信号差，无法发送邮件！");
			}
			try{
				 	HttpClient client = new HttpClient();  
			        PostMethod post = new PostMethod("http://sms.webchinese.cn/web_api/");  
			        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码  
			        NameValuePair[] data = { new NameValuePair("Uid", "lj450416064"), // 注册的用户名  
			                new NameValuePair("Key", "445c04ef9320c9610689"), // 注册成功后,登录网站使用的密钥  
			                new NameValuePair("smsMob", b_tel), // 手机号码  
			                new NameValuePair("smsText", "您好，感谢你注册成为Goll租房网的一员，您已注册成功，但您的账户需要进行首次登陆激活，<br/>登陆密码为："+strpwd+",请您尽快到指定的网页进行激活http://localhost:8080/GollHouse/front/brokeres/web_page/brokerLogin.jsp，我们会在1个工作日内给你反馈，谢谢您的合作。") };//设置短信内容       
			        post.setRequestBody(data);  
			        client.executeMethod(post);  
			        Header[] headers = post.getResponseHeaders();  
			        int statusCode = post.getStatusCode();  
			        System.out.println("statusCode:" + statusCode);  
			        for (Header h : headers) {  
			            System.out.println(h.toString());  
			        }  
			        String result = new String(post.getResponseBodyAsString().getBytes("gbk"));  
			        System.out.println(result);  
			        post.releaseConnection(); 
			}catch (Exception e) {
				out.print("短信发送异常，可能是网络不支持，此短信若有延迟，请依据邮箱内密码进行登录");
			}
			response.sendRedirect("front/brokeres/web_page/brokerLogin.jsp");
		} else {
			response.sendRedirect("front/brokeres/web_page/brokerLogin.jsp");
		}

	}
	private void Check(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email=request.getParameter("b_email");
		String name=request.getParameter("b_name");
		IBrokersService brokerService = new BrokersServiceImpl();
		PrintWriter out=response.getWriter();
		if(email.length()>=6||name.length()>=6){
			if(email!=null&&!email.equals("")){
				if(brokerService.queryBrokersByEmail(email)!=null){
					out.print("邮箱已经被注册，请您换个试试");
				}else if(email.contains("@")&&email.indexOf("@")<email.length()-6&&email.contains(".")&&email.indexOf(".")<email.length()-2){
					out.print("邮箱未被注册，可以使用");
				}
			}else if(name!=null){
				if(brokerService.queryBrokersByName(name)!=null){
					out.print("用户名已经被注册，试试  "+name+"123?");
				}else{
					out.print("用户名未被注册，可以使用");
				}
			}
		}
		out.flush();
		out.close();
	}
	private void checkLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String name=request.getParameter("b_name");
		 String pwd=request.getParameter("b_pwd");
		 IBrokersService brokerService=new BrokersServiceImpl();
		 Brokers broker=brokerService.queryBrokersByName(name);
		 PrintWriter out=response.getWriter();
		 if(broker!=null){
			 pwd=DigestUtils.md5Hex((DigestUtils.md5Hex(String.valueOf(pwd))+broker.getB_email()));
			
			 if(!pwd.equals(broker.getB_pwd())){
				 out.print("1");
			 }else{
				 if(broker.getB_isonline()==1){
					 out.print("3");
				 }else if(broker.getB_isonline()!=1){
					 broker.setB_isonline(1);
					 brokerService.updateBrokers(broker);
					 request.getSession(false).setAttribute("broker", broker);
					 out.print("0");
				 }
			 }
		 }else{
			 out.print("2");
		 }
		 out.flush();
		 out.close();
		}
	private void Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext application=this.getServletContext();
		application.setAttribute("online", (Integer)application.getAttribute("online")+1);
		request.getRequestDispatcher("brokerFrame/frame.jsp").forward(request, response);
	}
	
	private void Query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status="";
		if(request.getParameter("status")==null){
			status=(String) request.getSession(false).getAttribute("status");
		}else
			status=request.getParameter("status");
		request.getSession(false).setAttribute("status", status);
		String ischeck=request.getParameter("ischeck");
		request.getSession(false).setAttribute("ischeck", ischeck);
		if(ischeck=="null")
			ischeck=null;
		IBrokersService brokerService=new BrokersServiceImpl();
		List<Brokers> list=brokerService.queryByBrokerAndCompany(ischeck);
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.parseInt(request.getParameter("page")));
		}catch (Exception e) {
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		List<Brokers> brokerList=brokerService.queryByBrokerAndCompany(page,ischeck);
		request.getSession(false).setAttribute("pages", page);
		request.setAttribute("brokerList", brokerList);
		request.getSession(false).setAttribute("jspparam", "Brokeres?method=query&ischeck="+ischeck);
		request.getRequestDispatcher("backstage/brokeres/web_page/brokerList.jsp?").forward(request, response);
	}
	private void DeleteAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] ids=request.getParameterValues("broker");
		IBrokersService brokerService=new BrokersServiceImpl();
		for (int i = 0; i < ids.length; i++) {
			brokerService.deleteBrokers(Integer.valueOf(ids[i]));
		}
		ServletContext application=this.getServletContext();
		//查询未审核的经纪人
		List<Brokers> brokerList1=brokerService.queryAllBrokers("0");
		//查询所有经纪人
		List<Brokers> brokerAllList=brokerService.queryAllBrokers("null");
		application.setAttribute("Overbroker", brokerList1.size());
		application.setAttribute("OverbrokerAll", brokerAllList.size());
		String ischeck=(String) request.getSession(false).getAttribute("ischeck");
		if(ischeck=="null")
			ischeck=null;
		List<Brokers> list=brokerService.queryByBrokerAndCompany(ischeck);
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.parseInt(request.getParameter("page")));
		}catch (Exception e) {
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		List<Brokers> brokerList=brokerService.queryByBrokerAndCompany(page,ischeck);
		request.setAttribute("brokerList", brokerList);
		request.getSession(false).setAttribute("pages", page);
		request.getSession(false).setAttribute("ischeck", ischeck);
		request.getSession(false).setAttribute("jspparam", "Brokeres?method=query&ischeck="+ischeck);
		request.getRequestDispatcher("backstage/brokeres/web_page/brokerList.jsp?status=2").forward(request, response);
	}
	private void IscheckAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] ids=request.getParameterValues("broker");
		String ischeck=(String) request.getSession(false).getAttribute("ischeck");
		if(ischeck=="null")
			ischeck=null;
		IBrokersService brokerService=new BrokersServiceImpl();
		for (int i = 0; i < ids.length; i++) {
			Brokers broker=brokerService.queryBrokersById(Integer.valueOf(ids[i]), "0");
			if(broker!=null){
				broker.setB_ischeck("1");
				brokerService.updateBrokers(broker);
			}
		}
		//查询未审核的经纪人
		List<Brokers> brokerList1=brokerService.queryAllBrokers("0");
		ServletContext application=this.getServletContext();
		application.setAttribute("Overbroker", brokerList1.size());
		List<Brokers> list=brokerService.queryByBrokerAndCompany(ischeck);
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.parseInt(request.getParameter("page")));
		}catch (Exception e) {
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		List<Brokers> brokerList=brokerService.queryByBrokerAndCompany(page,ischeck);
		request.setAttribute("brokerList", brokerList);
		request.getSession(false).setAttribute("pages", page);
		request.getSession(false).setAttribute("ischeck", ischeck);
		request.getSession(false).setAttribute("jspparam", "Brokeres?method=query&ischeck="+ischeck);
		request.getRequestDispatcher("backstage/brokeres/web_page/brokerList.jsp?status=2").forward(request, response);
	}
	private void Delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		IBrokersService brokerService=new BrokersServiceImpl();
		brokerService.deleteBrokers(Integer.valueOf(id));
		ServletContext application=this.getServletContext();
		//查询未审核的经纪人
		List<Brokers> brokerList1=brokerService.queryAllBrokers("0");
		List<Brokers> brokerAllList=brokerService.queryAllBrokers("null");
		application.setAttribute("Overbroker", brokerList1.size());
		application.setAttribute("OverbrokerAll", brokerAllList.size());
		String ischeck=(String) request.getSession(false).getAttribute("ischeck");
		if(ischeck=="null")
			ischeck=null;
		List<Brokers> list=brokerService.queryByBrokerAndCompany(ischeck);
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.parseInt(request.getParameter("page")));
		}catch (Exception e) {
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		List<Brokers> brokerList=brokerService.queryByBrokerAndCompany(page,ischeck);
		request.setAttribute("brokerList", brokerList);
		request.getSession(false).setAttribute("pages", page);
		request.getSession(false).setAttribute("ischeck", ischeck);
		request.getSession(false).setAttribute("jspparam", "Brokeres?method=query&ischeck="+ischeck);
		request.getRequestDispatcher("backstage/brokeres/web_page/brokerList.jsp?status=2").forward(request, response);
		}
	private void Ischeck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		String ischeck=(String) request.getSession(false).getAttribute("ischeck");
		if(ischeck=="null")
			ischeck=null;
		IBrokersService brokerService=new BrokersServiceImpl();
		Brokers broker=brokerService.queryBrokersById(Integer.valueOf(id), "0");
		if(broker!=null){
			broker.setB_ischeck("1");
			brokerService.updateBrokers(broker);
		}
		ServletContext application=this.getServletContext();
		application.setAttribute("Overbroker", (Integer)application.getAttribute("Overbroker")-1);
		List<Brokers> list=brokerService.queryByBrokerAndCompany(ischeck);
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.parseInt(request.getParameter("page")));
		}catch (Exception e) {
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		List<Brokers> brokerList=brokerService.queryByBrokerAndCompany(page,ischeck);
		request.setAttribute("brokerList", brokerList);
		request.getSession(false).setAttribute("pages", page);
		request.getSession(false).setAttribute("ischeck", ischeck);
		request.getSession(false).setAttribute("jspparam", "Brokeres?method=query&ischeck="+ischeck);
		request.getRequestDispatcher("backstage/brokeres/web_page/brokerList.jsp?status=2").forward(request, response);
		}
	private void LogOut(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		Brokers b=(Brokers) session.getAttribute("broker");
		if(b!=null){
			b.setB_isonline(0);
			IBrokersService bs=new BrokersServiceImpl();
			bs.updateBrokers(b);
			session.removeAttribute("broker");
			session.invalidate();
			session=null;
		}
		ServletContext application=this.getServletContext();
		if((Integer)application.getAttribute("online")!=0)
			application.setAttribute("online", (Integer)application.getAttribute("online")-1);
		response.sendRedirect("front/brokeres/web_page/brokerLogin.jsp");
	}
	//前端查询
	private void selForFront(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		DoPage pager=new DoPage();
		IBrokersService brokerService=new BrokersServiceImpl();
		String page=request.getParameter("page");
		pager.setCounts(brokerService.queryAllBrokers("1").size());
		pager.setPageSize(10);
		try{
			pager.setCurrentPage(Integer.parseInt(page));
		}catch(Exception e){
			pager.setCurrentPage(1);
		}
		List<Brokers> blist=brokerService.queryByBrokerAndCompany(pager, "1");//查询经纪人
		
		IHousesService houseservice=new HousesServiceImpl();
		List<Houses> hlist=houseservice.queryHousesByIsup(1);
		IHouse_ImgsService house_img=new House_ImgsServiceImpl();
		List<Houses> houselists=new ArrayList<Houses>();
		if(hlist.size()>=4){
			for (int i = 0; i < 4; i++) {
				int id=hlist.get(i).getH_id();
				Houses house=houseservice.queryHouseById(id);
				//将图片的个数存放在集合中，下标为4
				String h_hi_ids=house.getH_hi_ids();
				String[] imgs=h_hi_ids.split(",");
				List<House_Imgs> imgList=new ArrayList<House_Imgs>();
				for (int j = 0; j < imgs.length; j++) {
					House_Imgs houseImg=house_img.queryHouse_ImgsById(Integer.valueOf(imgs[j]), null);
					imgList.add(houseImg);
					house.getList().add(imgList);
			}
				
				houselists.add(house);
			}			
		}
		if(hlist==null||hlist.size()<4){
			int count=4;
			List<Houses> houselist=houseservice.queryAllHouses("1");
			for (int i = 0; i < hlist.size(); i++) {
				int id=hlist.get(i).getH_id();
				Houses house=houseservice.queryHouseById(id);
				//将图片的个数存放在集合中，下标为4
				String h_hi_ids=house.getH_hi_ids();
				String[] imgs=h_hi_ids.split(",");
				List<House_Imgs> imgList=new ArrayList<House_Imgs>();
				for (int j = 0; j < imgs.length; j++) {
					House_Imgs houseImg=house_img.queryHouse_ImgsById(Integer.valueOf(imgs[j]), null);
					imgList.add(houseImg);
					house.getList().add(imgList);
			}
				
				houselists.add(house);
				count--;
			}
			for (int j = 0; j <=count; j++) {
				int id=houselist.get(j).getH_id();
					Houses house=houseservice.queryHouseById(id);
					//将图片的个数存放在集合中，下标为4
					String h_hi_ids=house.getH_hi_ids();
					String[] imgs=h_hi_ids.split(",");
					List<House_Imgs> imgList=new ArrayList<House_Imgs>();
					for (int i = 0; i < imgs.length; i++) {
						House_Imgs houseImg=house_img.queryHouse_ImgsById(Integer.valueOf(imgs[i]), null);
						imgList.add(houseImg);
						house.getList().add(imgList);
				}
					houselists.add(house);
					count--;
			}
		}		
		//查总房源数、个人房源数
		List<Houses> housel=houseservice.queryAllHouses("1");//总房源
		int numAll=housel.size();
		List<Houses> Phouse=houseservice.queryAllHouses(0);
		int Pnum=Phouse.size();
		List<Personals> ps=new PersonalsServiceImpl().queryAllPersonals("1");		
	
		request.setAttribute("ps", ps.size());
		request.setAttribute("nam", numAll);
		request.setAttribute("Pnum", Pnum);		
		request.setAttribute("houselist", houselists);
		request.setAttribute("pages", pager);
		request.setAttribute("blist", blist);
		request.getRequestDispatcher("front/brokeres/web_page/brokeresList.jsp").forward(request, response);
		
	}
	//找回密码
	private void FindPwd(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String email=request.getParameter("email");
		IBrokersService brokerService=new BrokersServiceImpl();
		Brokers broker=brokerService.queryBrokersByEmail(email);
		PrintWriter out=response.getWriter();
		if(broker!=null){
			int pwd = (int) (Math.random() * 1000000);
			String	strpwd="";
			if(String.valueOf(pwd).length()<6)
				strpwd=String.valueOf(pwd)+"0";
			else
				strpwd=String.valueOf(pwd);
			String password=DigestUtils.md5Hex((DigestUtils.md5Hex(strpwd)+email));
			broker.setB_pwd(password);
			brokerService.updateBrokers(broker);
			try{
				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.transport.protocol", "smtp");
				props.put("mail.smtp.port", "25");
				props.put("mail.smtp.host", "smtp.qq.com");
				Session session = Session.getInstance(props,
						new Authenticator() {
							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication("1743493016@qq.com", "13540154982");
								// 此处填写正确的邮箱账户密码
							}
						}); // 连接邮件服务器  
				Message mimeMessage = new MimeMessage(session); // Message
				mimeMessage.setFrom(new InternetAddress("1743493016@qq.com"));//来自哪个邮箱
				mimeMessage.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(email));//收取的邮箱号�?5137049@qq.com 651365883 。。。609357776
				mimeMessage.setSentDate(new Date());
				mimeMessage.setSubject("您好，您使用的找回密码功能成功");
				mimeMessage.setContent("<p align='center'>***************************************************************************** <br/>"+"您好,感谢您注册成为Goll租房网的一员，您此次使用的找回密码功能已经通过，<br/>登陆密码重置为："+strpwd+". 请到指定的网页进行修改密码<br/><a href='http://localhost:8080/GollHouse/front/brokeres/web_page/brokerLogin.jsp'>http://localhost:8080/GollHouse/front/brokeres/web_page/brokerLogin.jsp</a>，<br/>如需帮助，我们会在1个工作日内给你反馈，谢谢您的合作。<br/>"+"  ****************************************************************************</p>", "text/html;charset=utf-8");
				Transport.send(mimeMessage);
				out.print("邮件已发送请注意查收,如果您一直收不到此邮件，请检查：1. 请确认是否填写正确的邮箱地址："+email+" 2.请注意查看您邮箱中的垃圾邮件，可能 oschina 的邮件被误杀了");
		}catch (Exception e) {
			out.print("发送异常 ，可能网络信号差，无法发送邮件！");
			}
		}else
			out.print("没有此邮箱，请仔细确认后再输入");
	}
	//修改密码前的发送邮件
	private void PreUpdatePwd(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try{
			Brokers broker=(Brokers) request.getSession(false).getAttribute("broker");
			String ip=request.getRemoteAddr();
			int num=(int) (Math.random()*1000000);
			System.out.println("发简单邮件");
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.port", "25");
			props.put("mail.smtp.host", "smtp.qq.com");
			Session session = Session.getInstance(props,
					new Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication("1743493016@qq.com", "13540154982");
							// 此处填写正确的邮箱账户密码
						}
					}); // 连接邮件服务器  
			Message mimeMessage = new MimeMessage(session); // Message
			mimeMessage.setFrom(new InternetAddress("1743493016@qq.com"));//来自哪个邮箱
			mimeMessage.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(broker.getB_email()));//收取的邮箱号�?5137049@qq.com 651365883 。。。609357776
			mimeMessage.setSentDate(new Date());
			mimeMessage.setSubject("您好，感谢你注册成为Goll租房网的一员，我们因有你而精彩");
			mimeMessage.setContent("<p align='center'>***************************************************************************** <br/>"+"您好,感谢您注册成为Goll租房网的一员，您此次申请修改验证成功，<br/>修改验证为："+num+". 请到指定的网页进行登陆激活，我们会在1个工作日内给你反馈，谢谢您的合作。<br/>"+"  ****************************************************************************</p>", "text/html;charset=utf-8");
			Transport.send(mimeMessage);
			Cookie cook=new Cookie(ip, String.valueOf(num));
			cook.setMaxAge(60);//设置cookie60秒
			response.addCookie(cook);
			out.print("邮件已发送请注意查收,如果您一直收不到激活邮件，请检查：1. 请确认是否填写正确的邮箱地址："+broker.getB_email()+" 2.请注意查看您邮箱中的垃圾邮件，可能 oschina 的邮件被误杀了");
		}catch (Exception e) {
			out.print("发送异常 ，可能网络信号差，无法发送邮件！");
		}
	}
	//修改密码
	private void UpdatePwd(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String code=request.getParameter("code");
		String pwd=request.getParameter("oldPwd");
		String newpwd=request.getParameter("newPwd");
		String newpwd2=request.getParameter("newPwd2");
		PrintWriter out=response.getWriter();
		boolean isok=false;
		Cookie[] cooks=request.getCookies();
		if(cooks!=null){
			for (Cookie c : cooks) {
				if(c.getValue().equals(code))
					isok=true;
			}
		}
		if(isok){
			Brokers broker=(Brokers) request.getSession(false).getAttribute("broker");
			pwd=DigestUtils.md5Hex((DigestUtils.md5Hex(String.valueOf(pwd))+broker.getB_email()));
			if(!broker.getB_pwd().equals(pwd)){
				out.print("原密码输入错误");
			}else{
				if((newpwd.trim()).equals(newpwd2.trim())){
					broker.setB_pwd(DigestUtils.md5Hex((DigestUtils.md5Hex(String.valueOf(newpwd))+broker.getB_email())));
					IBrokersService bs=new BrokersServiceImpl();
					bs.updateBrokers(broker);
					out.print("修改成功");
				}
				else if(!(newpwd.trim()).equals(newpwd2.trim())){
					out.print("新密码输入不一致");
				}
			}
		}else{
			out.print("验证码错误");
		}
	}
	//修改个人信息
	private void Update(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String tel=request.getParameter("tel");
		String email=request.getParameter("email");
		String infos=request.getParameter("infos");
		String c_id=request.getParameter("c_id");
		String head_img=request.getParameter("head_img");
		
		Brokers broker=(Brokers)request.getSession(false).getAttribute("broker");
		broker.setB_tel(tel);
		broker.setB_email(email);
		broker.setB_infos(infos);
		broker.setB_head_img(head_img);
		broker.setC_id(Integer.parseInt(c_id));
		IBrokersService brokerService=new BrokersServiceImpl();
		brokerService.updateBrokers(broker);
		request.getRequestDispatcher("brokerFrame/web_page/updateData.jsp").forward(request, response);
	}
}
