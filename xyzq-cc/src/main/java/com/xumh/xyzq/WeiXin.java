package com.xumh.xyzq;

import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/weixin")
public class WeiXin {
	
	public static final String TOKEN = "weixin";

	public static final String RESPONSE_TXT = "<xml><ToUserName><![CDATA[%s]]></ToUserName><FromUserName><![CDATA[%s]]></FromUserName><CreateTime>%s</CreateTime><MsgType><![CDATA[%s]]></MsgType><Content><![CDATA[%s]]></Content><FuncFlag>0</FuncFlag></xml>";
	
	@RequestMapping(value="/cc",method=RequestMethod.GET)
	public @ResponseBody String getMessage(String signature,String timestamp,String nonce,String echostr){
		if(checkSignature(signature,timestamp,nonce)){
			return echostr;
		}
		return "";
	}
	
	@RequestMapping(value="/cc",method=RequestMethod.POST)
	public void message(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		Document doc = null;
		SAXReader reader = new SAXReader();
		InputStream in = request.getInputStream();
		try {
			doc = reader.read(in);
            Element root = doc.getRootElement();
            String toUserName = root.element("ToUserName").getTextTrim();
            String fromUserName = root.element("FromUserName").getTextTrim();
            String content = root.element("Content").getTextTrim();
			// root.element("MsgType")可以获取消息类型
			// 这里只回复简单文本信息
            out.printf(RESPONSE_TXT, fromUserName,toUserName,System.currentTimeMillis(),"text","您发送的内容是:"+content);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		in.close();
		out.close();
	}
	
	
	private static boolean checkSignature(String signature,String timestamp,String nonce){
		String[] arr = new String[]{TOKEN,timestamp,nonce};
		Arrays.sort(arr);
		StringBuilder content = new StringBuilder();
		for(int i=0;i<arr.length;i++){
			content.append(arr[i]);
		}
		MessageDigest md = null;
		String tmpStr = null;
		
        try {
			md = MessageDigest.getInstance("SHA-1");
	        byte[] digest = md.digest(content.toString().getBytes());
	        tmpStr = byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        
		content = null;
		return tmpStr!=null?tmpStr.equals(signature.toUpperCase()):false;
	}
	
    // 将字节转换为十六进制字符串
    private static String byteToHexStr(byte ib) {
        char[] Digit = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
                'D', 'E', 'F'
            };
        char[] ob = new char[2];
        ob[0] = Digit[(ib >>> 4) & 0X0F];
        ob[1] = Digit[ib & 0X0F];

        String s = new String(ob);
        return s;
    }
	
    // 将字节数组转换为十六进制字符串
    private static String byteToStr(byte[] bytearray) {
        String strDigest = "";
        for (int i = 0; i < bytearray.length; i++) {
            strDigest += byteToHexStr(bytearray[i]);
        }
        return strDigest;
    }
}
