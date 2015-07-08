package cn.goll.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.goll.entity.Brokers;
import cn.goll.entity.Historys;
import cn.goll.entity.Managers;
import cn.goll.service.IHistorysService;
import cn.goll.service.impl.HistorysServiceImpl;

/**
 * 编码过滤器and历史记录‘监视’器
 * @author LJ
 *
 */
public class charsetFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
			HttpServletRequest request=(HttpServletRequest) servletRequest;
			HttpServletResponse response=(HttpServletResponse) servletResponse;
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			String[] action={"SendEmail","SendToPhone","Brokeres","Areas","SmallAreas","Companys","Managers","Houses","Menus","Powers","Systems","upload","download","Html","relevance","Historys","SmallAreaImgs","SeekRent","FrontHouses"};
			String[] actionName={"发送邮件","发送短信","经纪人","区域","小区","中介公司","用户","房源","菜单","权限","系统设置","上传","下载","静态网页","系统管理","历史记录","小区图片","求租信息","前台房源"};
			String[] event={"updatePwd","query","remove","check","register","login","delete","ischeck","del","datchDel","logout","sel","add","update","insert","queryTime","isup","prepAdd","findPwd","preupdatePwd","updatePwd"};
			String[] eventName={"修改密码","查询","删除","审核","注册","登陆","删除","审核","删除","删除","退出","查询","添加","修改","添加","查询上次登录","房源置顶","准备添加","找回密码","进入修改密码","修改密码"};
		
			//System.out.println("---"+request.getHeader("Referer")); 地址栏url
			String evt=request.getQueryString();
			String act=request.getRequestURI();
			try{
				Managers manager=(Managers) request.getSession(false).getAttribute("manager");
				Brokers broker=(Brokers)request.getSession(false).getAttribute("broker");
				IHistorysService historyService=new HistorysServiceImpl();
				Historys his=new Historys();
				boolean isok=false;
				boolean isinsert=false;
				int num=0;
				if(manager!=null){//如果是管理员操作
					isok=true;
					his.setHis_manager_id(manager.getId());
					his.setHis_do_name(manager.getUname());
				}else if(broker!=null){//如果是经纪人操作
					isok=true;
					his.setHis_b_id(broker.getB_id());
					his.setHis_do_name(broker.getB_name());
				}
				if(isok){
					for(int i=0;i<action.length;i++){
						if(act.contains(action[i])){
							his.setHis_do_actions(actionName[i]);
							num=1;
						}
					}
					if(evt.contains("&"))
						evt=evt.substring(0, evt.indexOf("&"));
					for(int j=0;j<event.length;j++){
						if(evt!=null&&evt.contains(event[j])){
							his.setHis_do_event(eventName[j]);
							if(num==1)
								isinsert=true;
						}
					}
					if(isinsert){
						String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
						his.setHis_date(time);
						historyService.insertHistorys(his);//添加历史记录
					}
				}
			}catch (Exception e) {
			}
			chain.doFilter(request, response);
	}
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
