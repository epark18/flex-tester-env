package org.apache.jsp.dynamic_005finclude;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.liferay.document.library.analytics.internal.constants.DocumentLibraryAnalyticsConstants;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

public final class top_005fhead_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/dynamic_include/init.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_script_sandbox_require;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_aui_script_sandbox_require = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_aui_script_sandbox_require.release();
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

      out.write('\n');
      out.write('\n');
      out.write("\n\n\n\n");
      out.write("\n\n<script data-senna-track=\"temporary\" type=\"text/javascript\">\n\tif (window.Analytics) {\n\t\twindow.");
      out.print( DocumentLibraryAnalyticsConstants.JS_PREFIX );
      out.write("isViewFileEntry = false;\n\t}\n</script>\n\n");
      //  aui:script
      com.liferay.taglib.aui.ScriptTag _jspx_th_aui_script_0 = (com.liferay.taglib.aui.ScriptTag) _jspx_tagPool_aui_script_sandbox_require.get(com.liferay.taglib.aui.ScriptTag.class);
      _jspx_th_aui_script_0.setPageContext(_jspx_page_context);
      _jspx_th_aui_script_0.setParent(null);
      _jspx_th_aui_script_0.setRequire("metal-dom/src/all/dom as dom,metal-uri/src/Uri");
      _jspx_th_aui_script_0.setSandbox( true );
      int _jspx_eval_aui_script_0 = _jspx_th_aui_script_0.doStartTag();
      if (_jspx_eval_aui_script_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_aui_script_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_aui_script_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_aui_script_0.doInitBody();
        }
        do {
          out.write("\n\tvar Uri = metalUriSrcUri.default;\n\tvar pathnameRegexp = /\\/documents\\/(\\d+)\\/(\\d+)\\/(.+?)\\/([^&]+)/;\n\n\tvar downloadClickHandler = dom.delegate(\n\t\tdocument.body,\n\t\t'click',\n\t\t'a',\n\t\tfunction(event) {\n\t\t\tif (window.Analytics) {\n\t\t\t\tvar anchor = event.delegateTarget;\n\t\t\t\tvar uri = new Uri(anchor.href);\n\n\t\t\t\tvar match = pathnameRegexp.exec(uri.getPathname());\n\n\t\t\t\tif (match) {\n\t\t\t\t\tvar groupId = match[1];\n\t\t\t\t\tvar fileEntryUUID = match[4];\n\n\t\t\t\t\tfetch(\n\t\t\t\t\t\t'");
          out.print( PortalUtil.getPortalURL(request) );
          out.print( Portal.PATH_MODULE );
          out.print( DocumentLibraryAnalyticsConstants.PATH_RESOLVE_FILE_ENTRY );
          out.write("?groupId=' + encodeURIComponent(groupId) + '&uuid=' + encodeURIComponent(fileEntryUUID),\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tcredentials: 'include',\n\t\t\t\t\t\t\tmethod: 'GET'\n\t\t\t\t\t\t}\n\t\t\t\t\t).then(function(response) {\n\t\t\t\t\t\treturn response.json();\n\t\t\t\t\t}).then(function(response) {\n\t\t\t\t\t\tAnalytics.send(\n\t\t\t\t\t\t\t'documentDownloaded',\n\t\t\t\t\t\t\t'Document',\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tgroupId: groupId,\n\t\t\t\t\t\t\t\tfileEntryId: response.fileEntryId,\n\t\t\t\t\t\t\t\tpreview: !!window.");
          out.print( DocumentLibraryAnalyticsConstants.JS_PREFIX );
          out.write("isViewFileEntry,\n\t\t\t\t\t\t\t\ttitle: decodeURIComponent(match[3].replace(/\\+/ig, ' ')),\n\t\t\t\t\t\t\t\tversion: uri.getParameterValue('version')\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t);\n\t\t\t\t\t}).catch(function() {\n\t\t\t\t\t\treturn;\n\t\t\t\t\t});\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t);\n\n\tvar onDestroyPortlet = function() {\n\t\tdownloadClickHandler.removeListener()\n\t\tLiferay.detach('destroyPortlet', onDestroyPortlet);\n\t}\n\n\tLiferay.on('destroyPortlet', onDestroyPortlet);\n");
          int evalDoAfterBody = _jspx_th_aui_script_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_aui_script_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
      }
      if (_jspx_th_aui_script_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_script_sandbox_require.reuse(_jspx_th_aui_script_0);
        return;
      }
      _jspx_tagPool_aui_script_sandbox_require.reuse(_jspx_th_aui_script_0);
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
