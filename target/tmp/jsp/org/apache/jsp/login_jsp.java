package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\n");
      out.write("<head><link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"/> </head>\n");
      out.write("<body>\n");
      out.write("<!--img src=\"img/creator-pro-i-1-nobg-web.jpg\"/-->\n");
      out.write("<div class=\"login\">\n");
      out.write("    <form name=\"loginform\" action=\"\" method=\"post\">\n");
      out.write("        <table>\n");
      out.write("            <tr><td>Username: <input type=\"text\" name=\"username\" /></td></tr>\n");
      out.write("            <tr><td>Password: <input type=\"password\" name=\"password\"/></td></tr>\n");
      out.write("            <tr><td width=\"10%\">Remember me?<input type=\"checkbox\" name=\"rememberMe\"/></td>\n");
      out.write("            <td width=\"90%\"><input type=\"submit\" value=\"Login\" /></td></tr>\n");
      out.write("        </table>\n");
      out.write("    </form>\n");
      out.write("</div>\n");

    String errorDescription = (String) request.getAttribute("shiroLoginFailure");
    if (errorDescription!=null) {

      out.write("\n");
      out.write("Login attempt was unsuccessful: ");
      out.print(errorDescription);
      out.write('\n');

    }

      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
