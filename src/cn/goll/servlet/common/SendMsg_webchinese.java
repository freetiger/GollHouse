package cn.goll.servlet.common;
import org.apache.commons.httpclient.Header;  
import org.apache.commons.httpclient.HttpClient;  
import org.apache.commons.httpclient.NameValuePair;  
import org.apache.commons.httpclient.methods.PostMethod;  
  
public class SendMsg_webchinese {  
  
    public static void main(String[] args) throws Exception {  
  
        HttpClient client = new HttpClient();  
        PostMethod post = new PostMethod("http://sms.webchinese.cn/web_api/");  
        //PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn"); 
        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码  
        NameValuePair[] data = { new NameValuePair("Uid", "lj88811498"), // 注册的用户名  lj450416064
                new NameValuePair("Key", "e7057875dc7e4b432848"), // 注册成功后,登录网站使用的密钥  445c04ef9320c9610689
                new NameValuePair("smsMob", "18030779229"), // 手机号码  
                new NameValuePair("smsText", "您好，感谢你注册成为Goll租房网的一员，我们因有你而精彩，此次的验证码为：123456,请您尽快到指定的网页进行激活，我们会在1个工作日内给你反馈，谢谢您的合作。") };//设置短信内容       
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
    }  
}