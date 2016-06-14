package com.haier.weixin.web.servlet;

import com.haier.common.response.PropertiesLoaderUtils;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by 雷晓武 on 2016/6/14.
 */
public class AbstractServlet extends HttpServlet {
    protected Properties properties;
    @Override
    public void init() throws ServletException {
        try {
            properties= PropertiesLoaderUtils.loadAllProperties("config.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected Header getWXHeader(){
        return new BasicHeader("type","wx");
    }
}
