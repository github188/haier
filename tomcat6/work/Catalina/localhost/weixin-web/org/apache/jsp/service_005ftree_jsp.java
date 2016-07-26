package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URLDecoder;

public final class service_005ftree_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html class=\"ui-page-login\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no\" />\r\n");
      out.write("    <title></title>\r\n");
      out.write("    <link href=\"css/mui.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("    <!--App自定义的css-->\r\n");
      out.write("    <!--<link rel=\"stylesheet\" type=\"text/css\" href=\"css/app.css\" />-->\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/mui.picker.min.css\" />\r\n");
      out.write("    <link href=\"css/iconfont.css\" rel=\"stylesheet\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/service.css\"/>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"js/mui.min.js\"></script>\r\n");
      out.write("    <script src=\"js/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("    <script src=\"js/views/formPingjia.js\"></script>\r\n");
      out.write("    <style>\r\n");
      out.write("        .mui-control-content {\r\n");
      out.write("            background-color: white;\r\n");
      out.write("            min-height: 500px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");

    String product_name = URLDecoder.decode(request.getParameter("product_name"),"UTF-8");
    String type_name = URLDecoder.decode(request.getParameter("type_name"),"UTF-8");
    String service_type_name = URLDecoder.decode(request.getParameter("service_type_name"),"UTF-8");
    String statusDesc =  URLDecoder.decode(request.getParameter("statusDesc"),"UTF-8");

      out.write("\r\n");
      out.write("<header class=\"mui-bar mui-bar-nav\">\r\n");
      out.write("    <a class=\"mui-action-back mui-icon mui-icon-left-nav mui-pull-left title-back\">返回</a>\r\n");
      out.write("    <h1 class=\"mui-title\">服务单可视</h1>\r\n");
      out.write("</header>\r\n");
      out.write("<div class=\"mui-content\">\r\n");
      out.write("        <ul class=\"service-list\">\r\n");
      out.write("            <li style=\"height:120px;\">\r\n");
      out.write("                <div class=\"service-content clearfix\">\r\n");
      out.write("                    <div class=\"service-item clearfix\">\r\n");
      out.write("                        <div class=\"service-content-pic\"><img src=\"images/service/product.png\" style=\"width:80px;\"></div>\r\n");
      out.write("                        <div class=\"service-content-text\">\r\n");
      out.write("                            <div class=\"name\">");
      out.print(product_name);
      out.write(" &nbsp;&nbsp;");
      out.print(type_name);
      out.write("</div>\r\n");
      out.write("                            <div class=\"company\">服务类型：");
      out.print(service_type_name);
      out.write("</div>\r\n");
      out.write("                            <div class=\"company\">状态：");
      out.print(statusDesc);
      out.write("</div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <ul class=\"service-tree\" id=\"serviceTract\">\r\n");
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("\r\n");
      out.write("        <form class=\"mui-input-group\" id=\"formLogin\">\r\n");
      out.write("            <div class=\"mui-content-padded\">\r\n");
      out.write("                <button id='pingjiaBtn' class=\"mui-btn mui-btn-block mui-btn-primary\" style=\"width:100%;background-color: #32beff;border:-20\">评价</button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <input type=\"hidden\" id=\"dianzan-hidden\" value=\"0\">\r\n");
      out.write("        </form>\r\n");
      out.write("</div>\r\n");
      out.write("<input type=\"hidden\" name=\"orderCode\" id=\"orderCode\" value=\"BXK4160613661402\">\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    (function($, doc) {\r\n");
      out.write("        $.init({\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("    }(mui, document));\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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
