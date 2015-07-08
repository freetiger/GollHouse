package cn.goll.junit;

import java.sql.PreparedStatement;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import cn.goll.common.DBUtil;
import cn.goll.entity.Brokers;
import cn.goll.service.IBrokersService;
import cn.goll.service.impl.BrokersServiceImpl;
import junit.framework.TestCase;

public class testBrokers extends TestCase {
	/*public void testinsert() throws Exception {
		IBrokersService bservice = new BrokersServiceImpl();
		Brokers brokers = new Brokers("经纪人名称", "经纪人密码", "经纪人真实姓名", "经纪人邮箱", "经纪人身份证", "经纪人头像 ", "身份证图片", "营业执照", "电话", "房源集", "所在公司部门", "经纪人介绍", "经纪人积分", "积分等级", 1, 1 );
		if(bservice.insertBrokers(brokers))
			System.out.println("成功");
		else
			System.out.println("失败");
	}*/
	public void testinsert2() throws Exception {
		IBrokersService bservice = new BrokersServiceImpl();
		Brokers broker = new Brokers();
		broker.setB_name("test02");
		broker.setB_realname("欧阳锋");
		broker.setB_card("身份证");
		broker.setB_email("123456@qq.com");
		broker.setB_tel("213432422");
		broker.setB_company("安师大公司");
		broker.setB_infos("22222222222");
		broker.setC_id(1);
		broker.setB_level("2");
		broker.setB_ischeck("0");
		String strpwd=DigestUtils.md5Hex((DigestUtils.md5Hex(String.valueOf("test02"))+"123456@qq.com"));
		broker.setB_pwd(strpwd);
		for(int i=0;i<100;i++){
		if(bservice.insertBrokers(broker))
			System.out.println("成功");
		else
			System.out.println("失败");
		}
	}
	
	public void testdelete() throws Exception {
		IBrokersService bservice = new BrokersServiceImpl();
		if(bservice.deleteBrokers(2) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testupdate() throws Exception {
		IBrokersService bservice = new BrokersServiceImpl();
		Brokers brokers = new Brokers("经纪人名称", "经纪人密码", "经纪人真实姓名", "经纪人邮箱", 
				"经纪人身份证", "经纪人头像 ", "身份证图片", "营业执照", "电话", "房源集", "所在公司部门", 
				"经纪人介绍", "经纪人积分", "积分等级", "1", 1,0 );
		brokers.setB_id(1);
		if(bservice.updateBrokers(brokers) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		IBrokersService bservice = new BrokersServiceImpl();
		List<Brokers> brokers = bservice.queryAllBrokers(null);
		for (Brokers broker : brokers) {
			System.out.println(broker.getB_id()+" "+broker.getB_name()+" "+broker.getB_pwd()+
					" "+broker.getB_realname()+" "+broker.getB_email()+" "+broker.getB_card()+" "+broker.getB_head_img()
					+" "+broker.getB_card_img()+" "+broker.getB_business_img()+" "+broker.getB_tel()+" "+broker.getB_h_ids()
					+" "+broker.getB_company()+" "+broker.getB_infos()+" "+broker.getB_grade()+" "+broker.getB_level()
					+" "+broker.getB_ischeck()+" "+broker.getC_id());
		}
	}
	
	
	public void testupdate2() throws Exception {
		DBUtil db=DBUtil.getInstance();
		String sql="update brokers set b_level=? where b_id>0";
		PreparedStatement ps=db.getPrepareStatement(sql);
		ps.setString(1,"1");
		System.out.println(ps.executeUpdate());
	}
	
	
	
}
