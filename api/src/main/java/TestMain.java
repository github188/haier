import com.alibaba.fastjson.JSON;
import com.haier.common.httpclient.HEHttpClients;
import com.haier.domain.ServiceOrder;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestMain {

	private static Map paramMap = new HashMap() {
		{
//			// 绑定驾驶证
			put("getOrderList",
					"{\"user_id\":\"7\",\"status\":\"0\",\"pageNumber\":\"1\",\"pageSize\":\"10\"}");
			put("getOidProductInfo",
					"{\"oidContent\":\"http://oid.haier.com/oid?ewm=D006iM$MFTKA$AM$M$cM$KM$KKM$=$AM$Kv=Y$AM$$K$KA$KKM$FATMAK$FK=$KMKKYKKL4\"}");
		}
	};

	public static void main(String[] args) throws Exception {

		// StringBuffer url = new StringBuffer(
		// "https://sso.ehualu.com:8443/ehualu-appServer/handle.json");

		StringBuffer url = new StringBuffer(
				"http://localhost:9000/api/haier/1.0/order/getOrderList");
//		 StringBuffer url = new StringBuffer(
//		 "http://114.247.102.206:8070/ehualu-appServer/handle.json");

		//String sessionId = "JSESSIONID=2A4D10F0F01DCBF57775284928483A42;";
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		ServiceOrder serviceOrder = new ServiceOrder();
//		serviceOrder.setProduct_id("16");
//		serviceOrder.setUser_id(1);
//        serviceOrder.setService_type("T01");
//        serviceOrder.setRequire_service_date(format.parse("2016-06-14 08:00:00"));
//        serviceOrder.setContact_name("雷晓武");
//        serviceOrder.setMobile_phone("15022086097");
//        serviceOrder.setDistrict("120103");
//        serviceOrder.setAddress("天津市河西区福建路4号");
//        serviceOrder.setRequire_service_desc("安装");
//        serviceOrder.setOrder_time(new Date());
//        serviceOrder.setService_time("2016-06-05 17:00:00-2016-06-05 17:00:00");
//		String param = JSON.toJSONString(serviceOrder);

		String param = (String)paramMap.get("getOrderList");

		String resp = connectHttpUri(url.toString(),JSON.parseObject(param,HashMap.class));

		System.out.print(resp);
	}

	public static String connectHttpsUri(String uri, String param,
			String sessionId) {
		// 这是密钥库
		String sslKeyStorePath = "D:\\keys\\client.p12";

		String sslKeyStorePassword = "123456";

		String sslKeyStoreType = "PKCS12"; // 密钥库类型，有JKS PKCS12等
		// 信任库，这里需要服务端来新人客户端才能调用，因为这个我是配置的https双向验证，不但是要客户端信任服务端，服务端也要信任客户端。

		String sslTrustStore = "D:\\keys\\client.truststore";

		String sslTrustStorePassword = "123456";

		System.setProperty("javax.net.ssl.keyStoreType", sslKeyStoreType);

		System.setProperty("javax.net.ssl.keyStore", sslKeyStorePath);

		System.setProperty("javax.net.ssl.keyStorePassword",

		sslKeyStorePassword);

		// 设置系统参数
		System.setProperty("javax.net.ssl.trustStoreType", "BKS");

		System.setProperty("javax.net.ssl.trustStore", sslTrustStore);

		System.setProperty("javax.net.ssl.trustStorePassword",
				sslTrustStorePassword);

		System.setProperty("java.protocol.handler.pkgs", "sun.net.www.protocol");

		StringBuffer sb = new StringBuffer();
		try {
			URL finalurl = new URL(uri);
			HttpsURLConnection connection = (HttpsURLConnection) finalurl
					.openConnection();
			if (sessionId != null && !"".equals(sessionId)) {
				connection.setRequestProperty("Cookie", sessionId);
			}
			connection.setRequestProperty("user-agent",
					"mozilla/4.0 (compatible; msie 6.0; windows 2000)");
			connection.setConnectTimeout(15000);
			connection.setReadTimeout(30000);
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			//connection.setHostnameVerifier(new TrustAnyHostnameVerifier());
			connection.connect();
			// POST请求
			DataOutputStream out = new DataOutputStream(
					connection.getOutputStream());
			out.write(param.getBytes("utf-8"));
			out.flush();
			out.close();
			String cookieVal = "";
			String key = "";
			for (int i = 1; (key = connection.getHeaderFieldKey(i)) != null; i++) {
				if (key.equalsIgnoreCase("set-cookie")) {
					cookieVal = connection.getHeaderField(i);
					cookieVal = cookieVal.substring(0, cookieVal.indexOf(";"));
					sessionId = sessionId + cookieVal + ";";
				}
			}
			System.out.println(sessionId);
			System.out.println("--debug myurl:" + uri + ",length:"
					+ connection.getContentLength() + ",status:"
					+ connection.getResponseCode());
			if (connection.getResponseCode() == 200) {
				InputStream in = connection.getInputStream();
				BufferedReader breader = new BufferedReader(
						new InputStreamReader(in, "utf-8"));
				String str = breader.readLine();
				while (str != null) {
					sb.append(str);
					str = breader.readLine();
				}
				in.close();
			}
			connection.disconnect();
			connection = null;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("---result:" + sb.toString() + "---------------");
		return sb.toString();
	}

	public static String connectHttpUri(String uri, Map<String,Object> param) throws Exception{
		return HEHttpClients.httpJsonPostExecute(uri,param);
	}

}
