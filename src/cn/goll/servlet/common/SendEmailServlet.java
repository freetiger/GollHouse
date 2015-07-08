package cn.goll.servlet.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 发送邮件：需在发送方设置 开启（POP3/SMTP服务），流程为：登陆邮箱-设置-账户-POP3/SMTP服务，打上勾
 * @author Administrator
 *
 */
public class SendEmailServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			try {
			/*	Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.qq.com");
				props.put("mail.smtp.port", String.valueOf(25));
				props.put("mail.smtp.auth", "true");
			    Transport transport = null;
				Session session = Session.getDefaultInstance(props, null);
				transport = session.getTransport("smtp");
				transport.connect("smtp.qq.com", "1743493016@qq.com", "13540154982");
				MimeMessage msg = new MimeMessage(session);
				msg.setSentDate(new Date());
				InternetAddress fromAddress = new InternetAddress("1743493016@qq.com","大神","UTF-8");
				msg.setFrom(fromAddress);
				InternetAddress[] toAddress = new InternetAddress[1];
				toAddress[0] = new InternetAddress("450416064@qq.com");
				msg.setRecipients(Message.RecipientType.TO, toAddress);
				msg.setSubject("123", "UTF-8");  
				msg.setText("321", "UTF-8");
				msg.saveChanges();
				transport.sendMessage(msg, msg.getAllRecipients());
				} catch (NoSuchProviderException e) {
				            e.printStackTrace();
			     } catch (MessagingException e) {
			           e.printStackTrace();
			       }
			*/
			System.out.println(request.getRemoteHost());
			System.out.println(request.getRequestURI()); 
			System.out.println(request.getRequestURL()); 
			System.out.println(request.getRemoteAddr());
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			//String userName = request.getParameter("userName");
		//	final String userEmail = request.getParameter("Email");
			//UsersDao userDao = new UsersDao();
			//Users user = userDao.findByName(userName);
			//if (user != null && user.getuEmail().equals(userEmail)) {
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
						InternetAddress.parse("450416064@qq.com"));//收取的邮箱号�?5137049@qq.com 651365883 。。。609357776
				mimeMessage.setSentDate(new Date());
				mimeMessage.setSubject("您好，感谢你注册成为Goll租房网的一员，我们因有你而精彩");
		        //String pwd = user.getuPassWord();
				mimeMessage.setContent("<p align='center'>***************************************************************************** <br/>"+"您好,感谢您注册成为Goll租房网的一员，您已注册成功，但您的账户需要进行首次登陆激活，<br/>登陆密码为：123456. 请到指定的网页进行登陆激活，我们会在1个工作日内给你反馈，谢谢您的合作。<br/>"+"  ****************************************************************************</p>", "text/html;charset=utf-8");
				//mimeMessage.setContent("<p align='center'>***************************************************************************** <br/>"+"之所以跟你发这封邮件是因为你的号码已经被我盗窃，想要取回的号码，明天请我吃饭，谢谢您的合作。<br/>"+"  ****************************************************************************</p>", "text/html;charset=utf-8");
				Transport.send(mimeMessage);
				PrintWriter out=response.getWriter();
				out.print("<script>alert('邮件已发送请注意查收,如果您一直收不到激活邮件，请检查：1. 请确认是否填写正确的邮箱地址：450416064@qq.com 2.请注意查看您邮箱中的垃圾邮件，可能 oschina 的邮件被误杀了');</script>");
				//JOptionPane.showMessageDialog(null, "邮件已发送请注意查收");
				/*	try {
					Cookie cook=new Cookie("ip", "验证码");
					cook.setMaxAge(60);//设置cookie60秒
					response.addCookie(cook);
					Cookie[] cooks=request.getCookies();
					if(cooks!=null){
						for (Cookie c : cooks) {
							String ip=c.getName();
							String code=c.getValue();
							System.out.println(ip+"****"+code);
						}
					}
					request.getSession().setAttribute(request.getRemoteAddr(), "验证码");
					System.out.println(request.getSession().getAttribute(request.getRemoteAddr()));
					Thread.currentThread().sleep(1*1000);
					request.getSession().removeAttribute(request.getRemoteAddr());
					System.out.println("睡醒了");
				} catch (Exception e) {
					e.printStackTrace();
				} */
				
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "异常 ，可能网络信号差，无法发送邮件！");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('发送异常 ，可能网络信号差，无法发送邮件！');</script>");
			e.printStackTrace();
		} 
	}
}
