package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html class=\"ui-page-login\">\n");

	String openId = request.getParameter("openId");
	if(null == openId){
		openId="";
	}


      out.write("\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta charset=\"utf-8\">\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no\" />\n");
      out.write("\t\t<title></title>\n");
      out.write("\t\t<link href=\"css/mui.min.css\" rel=\"stylesheet\" />\n");
      out.write("\t\t<link href=\"css/style.css\" rel=\"stylesheet\" />\n");
      out.write("\t\t<link href=\"css/login.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("\t\t<script src=\"js/mui.min.js\"></script>\n");
      out.write("\t\t<script src=\"js/jquery-1.11.1.min.js\"></script>\n");
      out.write("\t\t<script src=\"js/views/register.js\"></script>\n");
      out.write("\t</head>\n");
      out.write("\n");
      out.write("\t<body>\n");
      out.write("\t\t<header class=\"mui-bar mui-bar-nav\">\n");
      out.write("\t\t\t<a class=\"mui-action-back mui-icon mui-icon-left-nav mui-pull-left\"></a>\n");
      out.write("\t\t\t<h1 class=\"mui-title\">账号注册</h1>\n");
      out.write("\t\t</header>\n");
      out.write("\t\t<div class=\"mui-content\">\n");
      out.write("\t\t\t<div style=\"text-align: center;height: 80px;vertical-align:middle;\"><img src=\"images/logo.png\" style=\"height:40px;top:40px;margin-top: 20px; \" /></div>\n");
      out.write("\t\t\t<form class=\"mui-input-group\" id=\"formRegister\">\t\t\t\t\n");
      out.write("\t\t\t\t<div class=\"mui-input-row\" style=\"height: 86px;line-height:86px;\">\n");
      out.write("\t\t\t\t\t<label style=\"margin-top:13px;\"><img src=\"images/login/phone.png\" style=\"width:40px;height:40px;\"></label>\n");
      out.write("\t\t\t\t\t<input id='phone' name=\"phone\" type=\"number\" class=\"mui-input-clear mui-input\" placeholder=\"请输入手机号\" style=\"margin-top:23px;\">\n");
      out.write("\t\t\t\t</div>             \t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<div class=\"mui-input-row\" style=\"height: 86px;line-height:86px;\">\n");
      out.write("\t\t\t\t\t<label style=\"margin-top:13px;\"><img src=\"images/login/checkcode.png\" style=\"width:40px;height:40px;\"></label>\n");
      out.write("\t\t\t\t\t<input id='checkcode' name=\"checkcode\" type=\"text\" class=\"mui-input-clear mui-input\" placeholder=\"\" style=\"margin-top:23px;width:46%;float: left;border:1px;\">\n");
      out.write("\t\t\t\t\t<div style=\"width:32%;height:40px;float: right;padding:23px 10px 0 0\">\n");
      out.write("\t\t\t\t\t\t<button id=\"getCheckcode\"  type=\"button\" class=\"mui-btn mui-btn-primary check-code nosend\" style=\"width:100%;border:-20\">获取验证码</button>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<div class=\"mui-input-row\" style=\"height: 40px;line-height:40px;\">\n");
      out.write("\t\t\t\t\t<label style=\"margin-top:0px;text-align: right;\"><input type=\"checkbox\" checked=\"checked\" class=\"i-checkbox\" name=\"agree\" id=\"agree\"></label>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<div style=\"width:78%;height:40px;line-height:40px;float: left;font-size:13px;\">我已阅读并同意《海尔服务使用协议》\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t\t<div class=\"mui-content-padded\">\n");
      out.write("\t\t\t\t<button id='sendRegister' class=\"mui-btn mui-btn-block mui-btn-primary\" style=\"width:100%;background-color: #32beff;border:-20\">注册</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"openId\" id=\"openId\" value=\"");
      out.print(openId);
      out.write("\">\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"user_id\" id=\"user_id\" value=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<script src=\"js/mui.min.js\"></script>\n");
      out.write("\t\t<script src=\"js/app.js\"></script>\n");
      out.write("\t\t<script>\n");
      out.write("\t\t\t(function($, doc) {\n");
      out.write("\t\t\t\t$.init();\n");
      out.write("\t\t\t}(mui, document));\n");
      out.write("\t\t</script>\n");
      out.write("\t</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
