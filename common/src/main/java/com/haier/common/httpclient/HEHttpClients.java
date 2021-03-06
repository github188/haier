package com.haier.common.httpclient;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;

import java.util.Map;

/**
 * Created by ehl on 2016/6/5.
 */
public class HEHttpClients extends HEAbstractHttpClient{
    /**
     *
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public static String httpGetExecute(String url,Map<String,Object> params) throws Exception {
        CloseableHttpClient client = getHttpClient();
        HttpGet get = getHttpGet(url,params);
        CloseableHttpResponse response=null;

        try{
            response=client.execute(get);
            checkHeader(response.getStatusLine());
            return toString(response.getEntity());
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            response.close();
        }
    }

    /**
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static String httpGetExecute(String url) throws Exception {
        CloseableHttpClient client = getHttpClient();
        HttpGet get = getHttpGet(url);
        CloseableHttpResponse response=null;

        try{
            response=client.execute(get);
            checkHeader(response.getStatusLine());
            return toString(response.getEntity());
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            response.close();
        }
    }

    /**
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static String httpPostExecute(String url) throws Exception {
        CloseableHttpClient client = getHttpClient();
        HttpPost post = getJsonHttpPost(url);
        CloseableHttpResponse response=null;

        try{
            response=client.execute(post);
            checkHeader(response.getStatusLine());
            return toString(response.getEntity());
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            response.close();
        }
    }
//addHeader("Content-type","application/json; charset=utf-8");
    /**
     *
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public static String httpJsonPostExecute(String url,Map<String,Object> params) throws Exception {
        CloseableHttpClient client = getHttpClient();

        HttpPost post = getJsonHttpPost(url, params);
        CloseableHttpResponse response=null;

        try{
            response=client.execute(post);
            checkHeader(response.getStatusLine());
            return toString(response.getEntity());
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            response.close();
        }
    }

    /**
     *
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public static String httpPostExecute(String url,Map<String,Object> params,Header header) throws Exception {
        CloseableHttpClient client = getHttpClient();
        HttpPost post = getFormHttpPost(url, params);
        post.setHeader(header);
        CloseableHttpResponse response=null;

        try{
            response=client.execute(post);
            checkHeader(response.getStatusLine());
            return toString(response.getEntity());
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            response.close();
        }
    }
    /**
     *
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public static String httpPostExecute(String url,Map<String,Object> params) throws Exception {
        CloseableHttpClient client = getHttpClient();
        HttpPost post = getFormHttpPost(url, params);

        CloseableHttpResponse response=null;

        try{
            response=client.execute(post);
            checkHeader(response.getStatusLine());
            return toString(response.getEntity());
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            response.close();
        }
    }

    public static void main(String[]args) throws Exception {
        String result = httpGetExecute("http://10.150.27.222:8888/es");
        System.out.println(result);
    }
}
