package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class servicelist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t\n");
      out.write("\t    <!--App自定义的css-->\n");
      out.write("\t\t<!--<link rel=\"stylesheet\" type=\"text/css\" href=\"css/app.css\" />-->\n");
      out.write("\n");
      out.write("\t    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/mui.picker.min.css\" />\n");
      out.write("\t    <link href=\"css/iconfont.css\" rel=\"stylesheet\"/>\n");
      out.write("\t    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\"/>\n");
      out.write("\t  \t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/service.css\"/>\n");
      out.write("\t    \n");
      out.write("\t    <script src=\"js/mui.min.js\"></script>\n");
      out.write("\t\t<script src=\"js/jquery-1.11.1.min.js\"></script>\n");
      out.write("\t\t<script src=\"js/views/showpage.js\"></script>\n");
      out.write("\t\t<script src=\"js/views/servicelist.js\"></script>\n");
      out.write("    <style> \n");
      out.write("\t\t.mui-control-content {\n");
      out.write("\t\t\tbackground-color: #EEEEEE;\n");
      out.write("\t\t\tmin-height: 500px;\n");
      out.write("\t\t}\n");
      out.write("\t\n");
      out.write("\t</style>\n");
      out.write("\t\t\n");
      out.write("\n");
      out.write("\t</head>\n");
      out.write("\n");
      out.write("\t<body>\n");
      out.write("\t\t<header class=\"mui-bar mui-bar-nav\">\n");
      out.write("\t\t\t<a class=\"mui-action-back mui-icon mui-icon-left-nav mui-pull-left title-back\">返回</a>\n");
      out.write("\t    \t<h1 class=\"mui-title\">我的服务单</h1>\n");
      out.write("\t    </header> \n");
      out.write("\t\t<div class=\"mui-content\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<div id=\"slider\" class=\"mui-slider\">\n");
      out.write("\t\t\t\t<div id=\"sliderSegmentedControl\" class=\"mui-slider-indicator mui-segmented-control mui-segmented-control-inverted\">\n");
      out.write("\t\t\t\t\t<a class=\"mui-control-item \" href=\"#item1mobile\" id=\"service_type_link_0\" attr_type_id=\"0\">\n");
      out.write("\t\t\t\t\t\t服务中\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t<a class=\"mui-control-item mui-active\" href=\"#item2mobile\" id=\"service_type_link_1\" attr_type_id=\"1\">\n");
      out.write("\t\t\t\t\t\t已完成\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div id=\"sliderProgressBar\" class=\"mui-slider-progress-bar mui-col-xs-6\"></div>\n");
      out.write("\t\t\t\t<div class=\"mui-slider-group\">\n");
      out.write("\t\t\t\t\t<div id=\"item1mobile\" class=\"mui-slider-item mui-control-content\">\n");
      out.write("\t\t\t\t\t\t<ul class=\"service-list\" id=\"servicelist_0\"></ul>\n");
      out.write("\t\t\t\t\t\t<div class=\"pagelist\" id=\"pagelist_0\"></div>\t\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div id=\"item2mobile\" class=\"mui-slider-item mui-control-content mui-active\">\n");
      out.write("\t\t\t\t\t\t<ul class=\"service-list\" id=\"servicelist_1\"></ul>\n");
      out.write("\t\t\t\t\t\t<div class=\"pagelist\" id=\"pagelist_1\"></div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<input type=\"hidden\" name=\"openId\" id=\"openId\" value=\"");
      out.print(openId);
      out.write("\">\n");
      out.write("\t\t<input type=\"hidden\" name=\"user_id\" id=\"user_id\" value=\"\">\n");
      out.write("\n");
      out.write("\t\t<script>\n");
      out.write("\t\t\t(function($, doc) {\n");
      out.write("\t\t\t\t$.init({\n");
      out.write("\t\t\t\t\tstatusBarBackground: '#f7f7f7'\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t\tdocument.getElementById('service_type_link_0').addEventListener('tap',function(){\n");
      out.write("\t\t\t\t\tinitList(1, 0);\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t\tdocument.getElementById('service_type_link_1').addEventListener('tap',function(){\n");
      out.write("\t\t\t\t\tinitList(1, 1);\n");
      out.write("\t\t\t\t});\n");
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
