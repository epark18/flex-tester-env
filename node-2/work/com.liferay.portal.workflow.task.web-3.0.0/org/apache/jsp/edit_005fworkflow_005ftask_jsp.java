package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskDueDateException;
import com.liferay.portal.workflow.task.web.internal.dao.search.WorkflowTaskResultRowSplitter;
import com.liferay.portal.workflow.task.web.internal.display.context.WorkflowTaskDisplayContext;
import com.liferay.taglib.search.DateSearchEntry;
import java.util.List;
import javax.portlet.PortletURL;

public final class edit_005fworkflow_005ftask_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/init.jsp");
    _jspx_dependants.add("/init-ext.jsp");
    _jspx_dependants.add("/workflow_logs.jspf");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_panel_title_markupView_extended;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_message_key_arguments_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_param_value_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1comment_discussion_userId_redirect_ratingsEnabled_formName_classPK_className_assetEntryVisible_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1asset_asset$1display_template_assetRenderer_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_panel$1container_extended_cssClass;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_col_width;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_fieldset$1group_markupView;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_script_use;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_col_cssClass;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_user$1portrait_userId_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1util_include_servletContext_page_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_fieldset;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_icon$1list;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_namespace_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_col;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_panel_title_markupView;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_message_key_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_field$1wrapper_label;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_renderURL_var;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_language_languageIds_languageId_formAction_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_error_message_exception_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_icon_message_markupView_label_icon_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1theme_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_icon_url_message_iconCssClass_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_management$1bar$1button_label_icon_href_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_liferay$1ui_panel_title_markupView_extended = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_message_key_arguments_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_param_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1comment_discussion_userId_redirect_ratingsEnabled_formName_classPK_className_assetEntryVisible_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1asset_asset$1display_template_assetRenderer_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_panel$1container_extended_cssClass = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_col_width = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_fieldset$1group_markupView = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_script_use = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_col_cssClass = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_user$1portrait_userId_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1util_include_servletContext_page_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_fieldset = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_icon$1list = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_namespace_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_col = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_panel_title_markupView = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_message_key_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_field$1wrapper_label = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_renderURL_var = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_language_languageIds_languageId_formAction_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_error_message_exception_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_icon_message_markupView_label_icon_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1theme_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_icon_url_message_iconCssClass_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_management$1bar$1button_label_icon_href_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_liferay$1ui_panel_title_markupView_extended.release();
    _jspx_tagPool_liferay$1ui_message_key_arguments_nobody.release();
    _jspx_tagPool_portlet_param_value_name_nobody.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_liferay$1comment_discussion_userId_redirect_ratingsEnabled_formName_classPK_className_assetEntryVisible_nobody.release();
    _jspx_tagPool_liferay$1asset_asset$1display_template_assetRenderer_nobody.release();
    _jspx_tagPool_liferay$1ui_panel$1container_extended_cssClass.release();
    _jspx_tagPool_aui_col_width.release();
    _jspx_tagPool_aui_fieldset$1group_markupView.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_aui_script_use.release();
    _jspx_tagPool_aui_col_cssClass.release();
    _jspx_tagPool_liferay$1ui_user$1portrait_userId_nobody.release();
    _jspx_tagPool_liferay$1util_include_servletContext_page_nobody.release();
    _jspx_tagPool_aui_fieldset.release();
    _jspx_tagPool_c_when_test.release();
    _jspx_tagPool_liferay$1ui_icon$1list.release();
    _jspx_tagPool_portlet_namespace_nobody.release();
    _jspx_tagPool_aui_col.release();
    _jspx_tagPool_liferay$1ui_panel_title_markupView.release();
    _jspx_tagPool_liferay$1ui_message_key_nobody.release();
    _jspx_tagPool_aui_field$1wrapper_label.release();
    _jspx_tagPool_portlet_renderURL_var.release();
    _jspx_tagPool_liferay$1ui_language_languageIds_languageId_formAction_nobody.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_portlet_defineObjects_nobody.release();
    _jspx_tagPool_liferay$1ui_error_message_exception_nobody.release();
    _jspx_tagPool_liferay$1ui_icon_message_markupView_label_icon_nobody.release();
    _jspx_tagPool_liferay$1theme_defineObjects_nobody.release();
    _jspx_tagPool_liferay$1ui_icon_url_message_iconCssClass_nobody.release();
    _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.release();
    _jspx_tagPool_liferay$1frontend_management$1bar$1button_label_icon_href_nobody.release();
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
      out.write("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
      //  liferay-theme:defineObjects
      com.liferay.taglib.theme.DefineObjectsTag _jspx_th_liferay$1theme_defineObjects_0 = (com.liferay.taglib.theme.DefineObjectsTag) _jspx_tagPool_liferay$1theme_defineObjects_nobody.get(com.liferay.taglib.theme.DefineObjectsTag.class);
      _jspx_th_liferay$1theme_defineObjects_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1theme_defineObjects_0.setParent(null);
      int _jspx_eval_liferay$1theme_defineObjects_0 = _jspx_th_liferay$1theme_defineObjects_0.doStartTag();
      if (_jspx_th_liferay$1theme_defineObjects_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1theme_defineObjects_nobody.reuse(_jspx_th_liferay$1theme_defineObjects_0);
        return;
      }
      _jspx_tagPool_liferay$1theme_defineObjects_nobody.reuse(_jspx_th_liferay$1theme_defineObjects_0);
      com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay = null;
      com.liferay.portal.kernel.model.Company company = null;
      com.liferay.portal.kernel.model.Account account = null;
      com.liferay.portal.kernel.model.User user = null;
      com.liferay.portal.kernel.model.User realUser = null;
      com.liferay.portal.kernel.model.Contact contact = null;
      com.liferay.portal.kernel.model.Layout layout = null;
      java.util.List layouts = null;
      java.lang.Long plid = null;
      com.liferay.portal.kernel.model.LayoutTypePortlet layoutTypePortlet = null;
      java.lang.Long scopeGroupId = null;
      com.liferay.portal.kernel.security.permission.PermissionChecker permissionChecker = null;
      java.util.Locale locale = null;
      java.util.TimeZone timeZone = null;
      com.liferay.portal.kernel.model.Theme theme = null;
      com.liferay.portal.kernel.model.ColorScheme colorScheme = null;
      com.liferay.portal.kernel.theme.PortletDisplay portletDisplay = null;
      java.lang.Long portletGroupId = null;
      themeDisplay = (com.liferay.portal.kernel.theme.ThemeDisplay) _jspx_page_context.findAttribute("themeDisplay");
      company = (com.liferay.portal.kernel.model.Company) _jspx_page_context.findAttribute("company");
      account = (com.liferay.portal.kernel.model.Account) _jspx_page_context.findAttribute("account");
      user = (com.liferay.portal.kernel.model.User) _jspx_page_context.findAttribute("user");
      realUser = (com.liferay.portal.kernel.model.User) _jspx_page_context.findAttribute("realUser");
      contact = (com.liferay.portal.kernel.model.Contact) _jspx_page_context.findAttribute("contact");
      layout = (com.liferay.portal.kernel.model.Layout) _jspx_page_context.findAttribute("layout");
      layouts = (java.util.List) _jspx_page_context.findAttribute("layouts");
      plid = (java.lang.Long) _jspx_page_context.findAttribute("plid");
      layoutTypePortlet = (com.liferay.portal.kernel.model.LayoutTypePortlet) _jspx_page_context.findAttribute("layoutTypePortlet");
      scopeGroupId = (java.lang.Long) _jspx_page_context.findAttribute("scopeGroupId");
      permissionChecker = (com.liferay.portal.kernel.security.permission.PermissionChecker) _jspx_page_context.findAttribute("permissionChecker");
      locale = (java.util.Locale) _jspx_page_context.findAttribute("locale");
      timeZone = (java.util.TimeZone) _jspx_page_context.findAttribute("timeZone");
      theme = (com.liferay.portal.kernel.model.Theme) _jspx_page_context.findAttribute("theme");
      colorScheme = (com.liferay.portal.kernel.model.ColorScheme) _jspx_page_context.findAttribute("colorScheme");
      portletDisplay = (com.liferay.portal.kernel.theme.PortletDisplay) _jspx_page_context.findAttribute("portletDisplay");
      portletGroupId = (java.lang.Long) _jspx_page_context.findAttribute("portletGroupId");
      out.write('\n');
      out.write('\n');
      //  portlet:defineObjects
      com.liferay.taglib.portlet.DefineObjectsTag _jspx_th_portlet_defineObjects_0 = (com.liferay.taglib.portlet.DefineObjectsTag) _jspx_tagPool_portlet_defineObjects_nobody.get(com.liferay.taglib.portlet.DefineObjectsTag.class);
      _jspx_th_portlet_defineObjects_0.setPageContext(_jspx_page_context);
      _jspx_th_portlet_defineObjects_0.setParent(null);
      int _jspx_eval_portlet_defineObjects_0 = _jspx_th_portlet_defineObjects_0.doStartTag();
      if (_jspx_th_portlet_defineObjects_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_0);
        return;
      }
      _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_0);
      javax.portlet.ActionRequest actionRequest = null;
      javax.portlet.ActionResponse actionResponse = null;
      javax.portlet.EventRequest eventRequest = null;
      javax.portlet.EventResponse eventResponse = null;
      com.liferay.portal.kernel.portlet.LiferayPortletRequest liferayPortletRequest = null;
      com.liferay.portal.kernel.portlet.LiferayPortletResponse liferayPortletResponse = null;
      javax.portlet.PortletConfig portletConfig = null;
      java.lang.String portletName = null;
      javax.portlet.PortletPreferences portletPreferences = null;
      java.util.Map portletPreferencesValues = null;
      javax.portlet.PortletSession portletSession = null;
      java.util.Map portletSessionScope = null;
      javax.portlet.RenderRequest renderRequest = null;
      javax.portlet.RenderResponse renderResponse = null;
      javax.portlet.ResourceRequest resourceRequest = null;
      javax.portlet.ResourceResponse resourceResponse = null;
      actionRequest = (javax.portlet.ActionRequest) _jspx_page_context.findAttribute("actionRequest");
      actionResponse = (javax.portlet.ActionResponse) _jspx_page_context.findAttribute("actionResponse");
      eventRequest = (javax.portlet.EventRequest) _jspx_page_context.findAttribute("eventRequest");
      eventResponse = (javax.portlet.EventResponse) _jspx_page_context.findAttribute("eventResponse");
      liferayPortletRequest = (com.liferay.portal.kernel.portlet.LiferayPortletRequest) _jspx_page_context.findAttribute("liferayPortletRequest");
      liferayPortletResponse = (com.liferay.portal.kernel.portlet.LiferayPortletResponse) _jspx_page_context.findAttribute("liferayPortletResponse");
      portletConfig = (javax.portlet.PortletConfig) _jspx_page_context.findAttribute("portletConfig");
      portletName = (java.lang.String) _jspx_page_context.findAttribute("portletName");
      portletPreferences = (javax.portlet.PortletPreferences) _jspx_page_context.findAttribute("portletPreferences");
      portletPreferencesValues = (java.util.Map) _jspx_page_context.findAttribute("portletPreferencesValues");
      portletSession = (javax.portlet.PortletSession) _jspx_page_context.findAttribute("portletSession");
      portletSessionScope = (java.util.Map) _jspx_page_context.findAttribute("portletSessionScope");
      renderRequest = (javax.portlet.RenderRequest) _jspx_page_context.findAttribute("renderRequest");
      renderResponse = (javax.portlet.RenderResponse) _jspx_page_context.findAttribute("renderResponse");
      resourceRequest = (javax.portlet.ResourceRequest) _jspx_page_context.findAttribute("resourceRequest");
      resourceResponse = (javax.portlet.ResourceResponse) _jspx_page_context.findAttribute("resourceResponse");
      out.write('\n');
      out.write('\n');

WorkflowTaskDisplayContext workflowTaskDisplayContext = new WorkflowTaskDisplayContext(liferayPortletRequest, liferayPortletResponse);

String currentURL = workflowTaskDisplayContext.getCurrentURL();

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');

String randomId = StringUtil.randomId();

String redirect = ParamUtil.getString(request, "redirect");

String backURL = ParamUtil.getString(request, "backURL", redirect);

if (Validator.isNull(backURL)) {
	PortletURL renderURL = renderResponse.createRenderURL();

	backURL = renderURL.toString();
}

WorkflowTask workflowTask = workflowTaskDisplayContext.getWorkflowTask();

long classPK = workflowTaskDisplayContext.getWorkflowContextEntryClassPK(workflowTask);

WorkflowHandler<?> workflowHandler = workflowTaskDisplayContext.getWorkflowHandler(workflowTask);

AssetRenderer<?> assetRenderer = workflowHandler.getAssetRenderer(classPK);

AssetRendererFactory<?> assetRendererFactory = assetRenderer.getAssetRendererFactory();

AssetEntry assetEntry = assetRendererFactory.getAssetEntry(workflowHandler.getClassName(), assetRenderer.getClassPK());

String languageId = ParamUtil.getString(request, "languageId", assetRenderer.getDefaultLanguageId());

String[] availableLanguageIds = assetRenderer.getAvailableLanguageIds();

String headerTitle = workflowTaskDisplayContext.getHeaderTitle(workflowTask);

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(backURL);

renderResponse.setTitle(headerTitle);

      out.write("\n\n<div class=\"container-fluid-1280\">\n\t");
      //  aui:col
      com.liferay.taglib.aui.ColTag _jspx_th_aui_col_0 = (com.liferay.taglib.aui.ColTag) _jspx_tagPool_aui_col_cssClass.get(com.liferay.taglib.aui.ColTag.class);
      _jspx_th_aui_col_0.setPageContext(_jspx_page_context);
      _jspx_th_aui_col_0.setParent(null);
      _jspx_th_aui_col_0.setCssClass("lfr-asset-column lfr-asset-column-details");
      int _jspx_eval_aui_col_0 = _jspx_th_aui_col_0.doStartTag();
      if (_jspx_eval_aui_col_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\n\t\t");
        //  liferay-ui:error
        com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_0 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_message_exception_nobody.get(com.liferay.taglib.ui.ErrorTag.class);
        _jspx_th_liferay$1ui_error_0.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_error_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_col_0);
        _jspx_th_liferay$1ui_error_0.setException( WorkflowTaskDueDateException.class );
        _jspx_th_liferay$1ui_error_0.setMessage("please-enter-a-valid-due-date");
        int _jspx_eval_liferay$1ui_error_0 = _jspx_th_liferay$1ui_error_0.doStartTag();
        if (_jspx_th_liferay$1ui_error_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_0);
          return;
        }
        _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_0);
        out.write("\n\n\t\t");
        //  aui:fieldset-group
        com.liferay.taglib.aui.FieldsetGroupTag _jspx_th_aui_fieldset$1group_0 = (com.liferay.taglib.aui.FieldsetGroupTag) _jspx_tagPool_aui_fieldset$1group_markupView.get(com.liferay.taglib.aui.FieldsetGroupTag.class);
        _jspx_th_aui_fieldset$1group_0.setPageContext(_jspx_page_context);
        _jspx_th_aui_fieldset$1group_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_col_0);
        _jspx_th_aui_fieldset$1group_0.setMarkupView("lexicon");
        int _jspx_eval_aui_fieldset$1group_0 = _jspx_th_aui_fieldset$1group_0.doStartTag();
        if (_jspx_eval_aui_fieldset$1group_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          out.write("\n\t\t\t");
          //  aui:fieldset
          com.liferay.taglib.aui.FieldsetTag _jspx_th_aui_fieldset_0 = (com.liferay.taglib.aui.FieldsetTag) _jspx_tagPool_aui_fieldset.get(com.liferay.taglib.aui.FieldsetTag.class);
          _jspx_th_aui_fieldset_0.setPageContext(_jspx_page_context);
          _jspx_th_aui_fieldset_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_fieldset$1group_0);
          int _jspx_eval_aui_fieldset_0 = _jspx_th_aui_fieldset_0.doStartTag();
          if (_jspx_eval_aui_fieldset_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\n\n\t\t\t\t");

				request.removeAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
				
            out.write("\n\n\t\t\t\t");
            //  liferay-util:include
            com.liferay.taglib.util.IncludeTag _jspx_th_liferay$1util_include_0 = (com.liferay.taglib.util.IncludeTag) _jspx_tagPool_liferay$1util_include_servletContext_page_nobody.get(com.liferay.taglib.util.IncludeTag.class);
            _jspx_th_liferay$1util_include_0.setPageContext(_jspx_page_context);
            _jspx_th_liferay$1util_include_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_fieldset_0);
            _jspx_th_liferay$1util_include_0.setPage("/workflow_task_action.jsp");
            _jspx_th_liferay$1util_include_0.setServletContext( application );
            int _jspx_eval_liferay$1util_include_0 = _jspx_th_liferay$1util_include_0.doStartTag();
            if (_jspx_th_liferay$1util_include_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_liferay$1util_include_servletContext_page_nobody.reuse(_jspx_th_liferay$1util_include_0);
              return;
            }
            _jspx_tagPool_liferay$1util_include_servletContext_page_nobody.reuse(_jspx_th_liferay$1util_include_0);
            out.write("\n\n\t\t\t\t");
            //  aui:col
            com.liferay.taglib.aui.ColTag _jspx_th_aui_col_1 = (com.liferay.taglib.aui.ColTag) _jspx_tagPool_aui_col_width.get(com.liferay.taglib.aui.ColTag.class);
            _jspx_th_aui_col_1.setPageContext(_jspx_page_context);
            _jspx_th_aui_col_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_fieldset_0);
            _jspx_th_aui_col_1.setWidth( 50 );
            int _jspx_eval_aui_col_1 = _jspx_th_aui_col_1.doStartTag();
            if (_jspx_eval_aui_col_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              out.write("\n\t\t\t\t\t");
              //  aui:field-wrapper
              com.liferay.taglib.aui.FieldWrapperTag _jspx_th_aui_field$1wrapper_0 = (com.liferay.taglib.aui.FieldWrapperTag) _jspx_tagPool_aui_field$1wrapper_label.get(com.liferay.taglib.aui.FieldWrapperTag.class);
              _jspx_th_aui_field$1wrapper_0.setPageContext(_jspx_page_context);
              _jspx_th_aui_field$1wrapper_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_col_1);
              _jspx_th_aui_field$1wrapper_0.setLabel("assigned-to");
              int _jspx_eval_aui_field$1wrapper_0 = _jspx_th_aui_field$1wrapper_0.doStartTag();
              if (_jspx_eval_aui_field$1wrapper_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                out.write("\n\t\t\t\t\t\t");
                //  aui:fieldset
                com.liferay.taglib.aui.FieldsetTag _jspx_th_aui_fieldset_1 = (com.liferay.taglib.aui.FieldsetTag) _jspx_tagPool_aui_fieldset.get(com.liferay.taglib.aui.FieldsetTag.class);
                _jspx_th_aui_fieldset_1.setPageContext(_jspx_page_context);
                _jspx_th_aui_fieldset_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_field$1wrapper_0);
                int _jspx_eval_aui_fieldset_1 = _jspx_th_aui_fieldset_1.doStartTag();
                if (_jspx_eval_aui_fieldset_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\t\t\t\t\t\t\t<div class=\"card-row\">\n\t\t\t\t\t\t\t\t");
                  //  c:choose
                  com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_0 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
                  _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
                  _jspx_th_c_choose_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_fieldset_1);
                  int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
                  if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    out.write("\n\t\t\t\t\t\t\t\t\t");
                    //  c:when
                    com.liferay.taglib.core.WhenTag _jspx_th_c_when_0 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
                    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
                    _jspx_th_c_when_0.setTest( workflowTask.isAssignedToSingleUser() );
                    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
                    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                      out.write("\n\t\t\t\t\t\t\t\t\t\t<div class=\"card-col-field\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"list-group-card-icon\">\n\t\t\t\t\t\t\t\t\t\t\t\t");
                      //  liferay-ui:user-portrait
                      com.liferay.taglib.ui.UserPortraitTag _jspx_th_liferay$1ui_user$1portrait_0 = (com.liferay.taglib.ui.UserPortraitTag) _jspx_tagPool_liferay$1ui_user$1portrait_userId_nobody.get(com.liferay.taglib.ui.UserPortraitTag.class);
                      _jspx_th_liferay$1ui_user$1portrait_0.setPageContext(_jspx_page_context);
                      _jspx_th_liferay$1ui_user$1portrait_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
                      _jspx_th_liferay$1ui_user$1portrait_0.setUserId( workflowTask.getAssigneeUserId() );
                      int _jspx_eval_liferay$1ui_user$1portrait_0 = _jspx_th_liferay$1ui_user$1portrait_0.doStartTag();
                      if (_jspx_th_liferay$1ui_user$1portrait_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_liferay$1ui_user$1portrait_userId_nobody.reuse(_jspx_th_liferay$1ui_user$1portrait_0);
                        return;
                      }
                      _jspx_tagPool_liferay$1ui_user$1portrait_userId_nobody.reuse(_jspx_th_liferay$1ui_user$1portrait_0);
                      out.write("\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t\t\t\t\t<div class=\"card-col-content card-col-gutters\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"lfr-asset-assigned\">\n\t\t\t\t\t\t\t\t\t\t\t\t");
                      out.print( HtmlUtil.escape(workflowTaskDisplayContext.getWorkflowTaskAssigneeUserName(workflowTask)) );
                      out.write("\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t");
                    }
                    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
                      return;
                    }
                    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
                    out.write("\n\t\t\t\t\t\t\t\t\t");
                    //  c:otherwise
                    com.liferay.taglib.core.OtherwiseTag _jspx_th_c_otherwise_0 = (com.liferay.taglib.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(com.liferay.taglib.core.OtherwiseTag.class);
                    _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
                    _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
                    int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
                    if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                      out.write("\n\t\t\t\t\t\t\t\t\t\t<div class=\"card-col-content card-col-gutters lfr-asset-assigned\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"lfr-asset-assigned\">\n\t\t\t\t\t\t\t\t\t\t\t\t");
                      out.print( workflowTaskDisplayContext.getWorkflowTaskUnassignedUserName() );
                      out.write("\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t");
                    }
                    if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
                      return;
                    }
                    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
                    out.write("\n\t\t\t\t\t\t\t\t");
                  }
                  if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
                    return;
                  }
                  _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
                  out.write("\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t");
                }
                if (_jspx_th_aui_fieldset_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_aui_fieldset.reuse(_jspx_th_aui_fieldset_1);
                  return;
                }
                _jspx_tagPool_aui_fieldset.reuse(_jspx_th_aui_fieldset_1);
                out.write("\n\t\t\t\t\t");
              }
              if (_jspx_th_aui_field$1wrapper_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_aui_field$1wrapper_label.reuse(_jspx_th_aui_field$1wrapper_0);
                return;
              }
              _jspx_tagPool_aui_field$1wrapper_label.reuse(_jspx_th_aui_field$1wrapper_0);
              out.write("\n\n\t\t\t\t\t");
              //  aui:field-wrapper
              com.liferay.taglib.aui.FieldWrapperTag _jspx_th_aui_field$1wrapper_1 = (com.liferay.taglib.aui.FieldWrapperTag) _jspx_tagPool_aui_field$1wrapper_label.get(com.liferay.taglib.aui.FieldWrapperTag.class);
              _jspx_th_aui_field$1wrapper_1.setPageContext(_jspx_page_context);
              _jspx_th_aui_field$1wrapper_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_col_1);
              _jspx_th_aui_field$1wrapper_1.setLabel("state");
              int _jspx_eval_aui_field$1wrapper_1 = _jspx_th_aui_field$1wrapper_1.doStartTag();
              if (_jspx_eval_aui_field$1wrapper_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                out.write("\n\t\t\t\t\t\t");
                //  aui:fieldset
                com.liferay.taglib.aui.FieldsetTag _jspx_th_aui_fieldset_2 = (com.liferay.taglib.aui.FieldsetTag) _jspx_tagPool_aui_fieldset.get(com.liferay.taglib.aui.FieldsetTag.class);
                _jspx_th_aui_fieldset_2.setPageContext(_jspx_page_context);
                _jspx_th_aui_fieldset_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_field$1wrapper_1);
                int _jspx_eval_aui_fieldset_2 = _jspx_th_aui_fieldset_2.doStartTag();
                if (_jspx_eval_aui_fieldset_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\t\t\t\t\t\t\t");
                  out.print( workflowTaskDisplayContext.getState(workflowTask) );
                  out.write("\n\t\t\t\t\t\t");
                }
                if (_jspx_th_aui_fieldset_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_aui_fieldset.reuse(_jspx_th_aui_fieldset_2);
                  return;
                }
                _jspx_tagPool_aui_fieldset.reuse(_jspx_th_aui_fieldset_2);
                out.write("\n\t\t\t\t\t");
              }
              if (_jspx_th_aui_field$1wrapper_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_aui_field$1wrapper_label.reuse(_jspx_th_aui_field$1wrapper_1);
                return;
              }
              _jspx_tagPool_aui_field$1wrapper_label.reuse(_jspx_th_aui_field$1wrapper_1);
              out.write("\n\t\t\t\t");
            }
            if (_jspx_th_aui_col_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_aui_col_width.reuse(_jspx_th_aui_col_1);
              return;
            }
            _jspx_tagPool_aui_col_width.reuse(_jspx_th_aui_col_1);
            out.write("\n\n\t\t\t\t");
            //  aui:col
            com.liferay.taglib.aui.ColTag _jspx_th_aui_col_2 = (com.liferay.taglib.aui.ColTag) _jspx_tagPool_aui_col_width.get(com.liferay.taglib.aui.ColTag.class);
            _jspx_th_aui_col_2.setPageContext(_jspx_page_context);
            _jspx_th_aui_col_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_fieldset_0);
            _jspx_th_aui_col_2.setWidth( 50 );
            int _jspx_eval_aui_col_2 = _jspx_th_aui_col_2.doStartTag();
            if (_jspx_eval_aui_col_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              out.write("\n\t\t\t\t\t");
              //  aui:field-wrapper
              com.liferay.taglib.aui.FieldWrapperTag _jspx_th_aui_field$1wrapper_2 = (com.liferay.taglib.aui.FieldWrapperTag) _jspx_tagPool_aui_field$1wrapper_label.get(com.liferay.taglib.aui.FieldWrapperTag.class);
              _jspx_th_aui_field$1wrapper_2.setPageContext(_jspx_page_context);
              _jspx_th_aui_field$1wrapper_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_col_2);
              _jspx_th_aui_field$1wrapper_2.setLabel("create-date");
              int _jspx_eval_aui_field$1wrapper_2 = _jspx_th_aui_field$1wrapper_2.doStartTag();
              if (_jspx_eval_aui_field$1wrapper_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                out.write("\n\t\t\t\t\t\t");
                //  aui:fieldset
                com.liferay.taglib.aui.FieldsetTag _jspx_th_aui_fieldset_3 = (com.liferay.taglib.aui.FieldsetTag) _jspx_tagPool_aui_fieldset.get(com.liferay.taglib.aui.FieldsetTag.class);
                _jspx_th_aui_fieldset_3.setPageContext(_jspx_page_context);
                _jspx_th_aui_fieldset_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_field$1wrapper_2);
                int _jspx_eval_aui_fieldset_3 = _jspx_th_aui_fieldset_3.doStartTag();
                if (_jspx_eval_aui_fieldset_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\t\t\t\t\t\t\t");
                  out.print( workflowTaskDisplayContext.getCreateDate(workflowTask) );
                  out.write("\n\t\t\t\t\t\t");
                }
                if (_jspx_th_aui_fieldset_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_aui_fieldset.reuse(_jspx_th_aui_fieldset_3);
                  return;
                }
                _jspx_tagPool_aui_fieldset.reuse(_jspx_th_aui_fieldset_3);
                out.write("\n\t\t\t\t\t");
              }
              if (_jspx_th_aui_field$1wrapper_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_aui_field$1wrapper_label.reuse(_jspx_th_aui_field$1wrapper_2);
                return;
              }
              _jspx_tagPool_aui_field$1wrapper_label.reuse(_jspx_th_aui_field$1wrapper_2);
              out.write("\n\n\t\t\t\t\t");
              //  aui:field-wrapper
              com.liferay.taglib.aui.FieldWrapperTag _jspx_th_aui_field$1wrapper_3 = (com.liferay.taglib.aui.FieldWrapperTag) _jspx_tagPool_aui_field$1wrapper_label.get(com.liferay.taglib.aui.FieldWrapperTag.class);
              _jspx_th_aui_field$1wrapper_3.setPageContext(_jspx_page_context);
              _jspx_th_aui_field$1wrapper_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_col_2);
              _jspx_th_aui_field$1wrapper_3.setLabel("due-date");
              int _jspx_eval_aui_field$1wrapper_3 = _jspx_th_aui_field$1wrapper_3.doStartTag();
              if (_jspx_eval_aui_field$1wrapper_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                out.write("\n\t\t\t\t\t\t");
                //  aui:fieldset
                com.liferay.taglib.aui.FieldsetTag _jspx_th_aui_fieldset_4 = (com.liferay.taglib.aui.FieldsetTag) _jspx_tagPool_aui_fieldset.get(com.liferay.taglib.aui.FieldsetTag.class);
                _jspx_th_aui_fieldset_4.setPageContext(_jspx_page_context);
                _jspx_th_aui_fieldset_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_field$1wrapper_3);
                int _jspx_eval_aui_fieldset_4 = _jspx_th_aui_fieldset_4.doStartTag();
                if (_jspx_eval_aui_fieldset_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\t\t\t\t\t\t\t");
                  out.print( workflowTaskDisplayContext.getDueDateString(workflowTask) );
                  out.write("\n\t\t\t\t\t\t");
                }
                if (_jspx_th_aui_fieldset_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_aui_fieldset.reuse(_jspx_th_aui_fieldset_4);
                  return;
                }
                _jspx_tagPool_aui_fieldset.reuse(_jspx_th_aui_fieldset_4);
                out.write("\n\t\t\t\t\t");
              }
              if (_jspx_th_aui_field$1wrapper_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_aui_field$1wrapper_label.reuse(_jspx_th_aui_field$1wrapper_3);
                return;
              }
              _jspx_tagPool_aui_field$1wrapper_label.reuse(_jspx_th_aui_field$1wrapper_3);
              out.write("\n\t\t\t\t");
            }
            if (_jspx_th_aui_col_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_aui_col_width.reuse(_jspx_th_aui_col_2);
              return;
            }
            _jspx_tagPool_aui_col_width.reuse(_jspx_th_aui_col_2);
            out.write("\n\n\t\t\t\t");
            //  c:if
            com.liferay.taglib.core.IfTag _jspx_th_c_if_0 = (com.liferay.taglib.core.IfTag) _jspx_tagPool_c_if_test.get(com.liferay.taglib.core.IfTag.class);
            _jspx_th_c_if_0.setPageContext(_jspx_page_context);
            _jspx_th_c_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_fieldset_0);
            _jspx_th_c_if_0.setTest( Validator.isNotNull(workflowTask.getDescription()) );
            int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
            if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              out.write("\n\t\t\t\t\t");
              //  aui:col
              com.liferay.taglib.aui.ColTag _jspx_th_aui_col_3 = (com.liferay.taglib.aui.ColTag) _jspx_tagPool_aui_col.get(com.liferay.taglib.aui.ColTag.class);
              _jspx_th_aui_col_3.setPageContext(_jspx_page_context);
              _jspx_th_aui_col_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
              int _jspx_eval_aui_col_3 = _jspx_th_aui_col_3.doStartTag();
              if (_jspx_eval_aui_col_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                out.write("\n\t\t\t\t\t\t");
                //  aui:field-wrapper
                com.liferay.taglib.aui.FieldWrapperTag _jspx_th_aui_field$1wrapper_4 = (com.liferay.taglib.aui.FieldWrapperTag) _jspx_tagPool_aui_field$1wrapper_label.get(com.liferay.taglib.aui.FieldWrapperTag.class);
                _jspx_th_aui_field$1wrapper_4.setPageContext(_jspx_page_context);
                _jspx_th_aui_field$1wrapper_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_col_3);
                _jspx_th_aui_field$1wrapper_4.setLabel("description");
                int _jspx_eval_aui_field$1wrapper_4 = _jspx_th_aui_field$1wrapper_4.doStartTag();
                if (_jspx_eval_aui_field$1wrapper_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\t\t\t\t\t\t\t");
                  //  aui:fieldset
                  com.liferay.taglib.aui.FieldsetTag _jspx_th_aui_fieldset_5 = (com.liferay.taglib.aui.FieldsetTag) _jspx_tagPool_aui_fieldset.get(com.liferay.taglib.aui.FieldsetTag.class);
                  _jspx_th_aui_fieldset_5.setPageContext(_jspx_page_context);
                  _jspx_th_aui_fieldset_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_field$1wrapper_4);
                  int _jspx_eval_aui_fieldset_5 = _jspx_th_aui_fieldset_5.doStartTag();
                  if (_jspx_eval_aui_fieldset_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    out.write("\n\t\t\t\t\t\t\t\t");
                    out.print( workflowTaskDisplayContext.getDescription(workflowTask) );
                    out.write("\n\t\t\t\t\t\t\t");
                  }
                  if (_jspx_th_aui_fieldset_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_aui_fieldset.reuse(_jspx_th_aui_fieldset_5);
                    return;
                  }
                  _jspx_tagPool_aui_fieldset.reuse(_jspx_th_aui_fieldset_5);
                  out.write("\n\t\t\t\t\t\t");
                }
                if (_jspx_th_aui_field$1wrapper_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_aui_field$1wrapper_label.reuse(_jspx_th_aui_field$1wrapper_4);
                  return;
                }
                _jspx_tagPool_aui_field$1wrapper_label.reuse(_jspx_th_aui_field$1wrapper_4);
                out.write("\n\t\t\t\t\t");
              }
              if (_jspx_th_aui_col_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_aui_col.reuse(_jspx_th_aui_col_3);
                return;
              }
              _jspx_tagPool_aui_col.reuse(_jspx_th_aui_col_3);
              out.write("\n\t\t\t\t");
            }
            if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
              return;
            }
            _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
            out.write("\n\t\t\t");
          }
          if (_jspx_th_aui_fieldset_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_aui_fieldset.reuse(_jspx_th_aui_fieldset_0);
            return;
          }
          _jspx_tagPool_aui_fieldset.reuse(_jspx_th_aui_fieldset_0);
          out.write("\n\n\t\t\t");
          //  liferay-ui:panel-container
          com.liferay.taglib.ui.PanelContainerTag _jspx_th_liferay$1ui_panel$1container_0 = (com.liferay.taglib.ui.PanelContainerTag) _jspx_tagPool_liferay$1ui_panel$1container_extended_cssClass.get(com.liferay.taglib.ui.PanelContainerTag.class);
          _jspx_th_liferay$1ui_panel$1container_0.setPageContext(_jspx_page_context);
          _jspx_th_liferay$1ui_panel$1container_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_fieldset$1group_0);
          _jspx_th_liferay$1ui_panel$1container_0.setCssClass("task-panel-container");
          _jspx_th_liferay$1ui_panel$1container_0.setExtended( false );
          int _jspx_eval_liferay$1ui_panel$1container_0 = _jspx_th_liferay$1ui_panel$1container_0.doStartTag();
          if (_jspx_eval_liferay$1ui_panel$1container_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_liferay$1ui_panel$1container_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_liferay$1ui_panel$1container_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_liferay$1ui_panel$1container_0.doInitBody();
            }
            do {
              out.write("\n\t\t\t\t");
              //  c:if
              com.liferay.taglib.core.IfTag _jspx_th_c_if_1 = (com.liferay.taglib.core.IfTag) _jspx_tagPool_c_if_test.get(com.liferay.taglib.core.IfTag.class);
              _jspx_th_c_if_1.setPageContext(_jspx_page_context);
              _jspx_th_c_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_panel$1container_0);
              _jspx_th_c_if_1.setTest( assetRenderer != null );
              int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
              if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                out.write("\n\t\t\t\t\t");
                //  liferay-ui:panel
                com.liferay.taglib.ui.PanelTag _jspx_th_liferay$1ui_panel_0 = (com.liferay.taglib.ui.PanelTag) _jspx_tagPool_liferay$1ui_panel_title_markupView_extended.get(com.liferay.taglib.ui.PanelTag.class);
                _jspx_th_liferay$1ui_panel_0.setPageContext(_jspx_page_context);
                _jspx_th_liferay$1ui_panel_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
                _jspx_th_liferay$1ui_panel_0.setExtended( true );
                _jspx_th_liferay$1ui_panel_0.setMarkupView("lexicon");
                _jspx_th_liferay$1ui_panel_0.setTitle( workflowTaskDisplayContext.getPreviewOfTitle(workflowTask) );
                int _jspx_eval_liferay$1ui_panel_0 = _jspx_th_liferay$1ui_panel_0.doStartTag();
                if (_jspx_eval_liferay$1ui_panel_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\t\t\t\t\t\t<div class=\"locale-actions\">\n\t\t\t\t\t\t\t");
                  //  liferay-ui:language
                  com.liferay.taglib.ui.LanguageTag _jspx_th_liferay$1ui_language_0 = (com.liferay.taglib.ui.LanguageTag) _jspx_tagPool_liferay$1ui_language_languageIds_languageId_formAction_nobody.get(com.liferay.taglib.ui.LanguageTag.class);
                  _jspx_th_liferay$1ui_language_0.setPageContext(_jspx_page_context);
                  _jspx_th_liferay$1ui_language_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_panel_0);
                  _jspx_th_liferay$1ui_language_0.setFormAction( currentURL );
                  _jspx_th_liferay$1ui_language_0.setLanguageId( languageId );
                  _jspx_th_liferay$1ui_language_0.setLanguageIds( availableLanguageIds );
                  int _jspx_eval_liferay$1ui_language_0 = _jspx_th_liferay$1ui_language_0.doStartTag();
                  if (_jspx_th_liferay$1ui_language_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_liferay$1ui_language_languageIds_languageId_formAction_nobody.reuse(_jspx_th_liferay$1ui_language_0);
                    return;
                  }
                  _jspx_tagPool_liferay$1ui_language_languageIds_languageId_formAction_nobody.reuse(_jspx_th_liferay$1ui_language_0);
                  out.write("\n\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t<div class=\"task-content-actions\">\n\t\t\t\t\t\t\t");
                  //  liferay-ui:icon-list
                  com.liferay.taglib.ui.IconListTag _jspx_th_liferay$1ui_icon$1list_0 = (com.liferay.taglib.ui.IconListTag) _jspx_tagPool_liferay$1ui_icon$1list.get(com.liferay.taglib.ui.IconListTag.class);
                  _jspx_th_liferay$1ui_icon$1list_0.setPageContext(_jspx_page_context);
                  _jspx_th_liferay$1ui_icon$1list_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_panel_0);
                  int _jspx_eval_liferay$1ui_icon$1list_0 = _jspx_th_liferay$1ui_icon$1list_0.doStartTag();
                  if (_jspx_eval_liferay$1ui_icon$1list_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    if (_jspx_eval_liferay$1ui_icon$1list_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_liferay$1ui_icon$1list_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_liferay$1ui_icon$1list_0.doInitBody();
                    }
                    do {
                      out.write("\n\t\t\t\t\t\t\t\t");
                      //  c:if
                      com.liferay.taglib.core.IfTag _jspx_th_c_if_2 = (com.liferay.taglib.core.IfTag) _jspx_tagPool_c_if_test.get(com.liferay.taglib.core.IfTag.class);
                      _jspx_th_c_if_2.setPageContext(_jspx_page_context);
                      _jspx_th_c_if_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_icon$1list_0);
                      _jspx_th_c_if_2.setTest( assetRenderer.hasViewPermission(permissionChecker) );
                      int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
                      if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        out.write("\n\t\t\t\t\t\t\t\t\t");
                        //  portlet:renderURL
                        com.liferay.taglib.portlet.RenderURLTag _jspx_th_portlet_renderURL_0 = (com.liferay.taglib.portlet.RenderURLTag) _jspx_tagPool_portlet_renderURL_var.get(com.liferay.taglib.portlet.RenderURLTag.class);
                        _jspx_th_portlet_renderURL_0.setPageContext(_jspx_page_context);
                        _jspx_th_portlet_renderURL_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_2);
                        _jspx_th_portlet_renderURL_0.setVar("viewFullContentURL");
                        int _jspx_eval_portlet_renderURL_0 = _jspx_th_portlet_renderURL_0.doStartTag();
                        if (_jspx_eval_portlet_renderURL_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                          out.write("\n\t\t\t\t\t\t\t\t\t\t");
                          if (_jspx_meth_portlet_param_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_renderURL_0, _jspx_page_context))
                            return;
                          out.write("\n\t\t\t\t\t\t\t\t\t\t");
                          //  portlet:param
                          com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_1 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
                          _jspx_th_portlet_param_1.setPageContext(_jspx_page_context);
                          _jspx_th_portlet_param_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_0);
                          _jspx_th_portlet_param_1.setName("redirect");
                          _jspx_th_portlet_param_1.setValue( currentURL );
                          int _jspx_eval_portlet_param_1 = _jspx_th_portlet_param_1.doStartTag();
                          if (_jspx_th_portlet_param_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                            _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_1);
                            return;
                          }
                          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_1);
                          out.write("\n\t\t\t\t\t\t\t\t\t\t");
                          //  portlet:param
                          com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_2 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
                          _jspx_th_portlet_param_2.setPageContext(_jspx_page_context);
                          _jspx_th_portlet_param_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_0);
                          _jspx_th_portlet_param_2.setName("languageId");
                          _jspx_th_portlet_param_2.setValue( languageId );
                          int _jspx_eval_portlet_param_2 = _jspx_th_portlet_param_2.doStartTag();
                          if (_jspx_th_portlet_param_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                            _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_2);
                            return;
                          }
                          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_2);
                          out.write("\n\n\t\t\t\t\t\t\t\t\t\t");
                          //  c:if
                          com.liferay.taglib.core.IfTag _jspx_th_c_if_3 = (com.liferay.taglib.core.IfTag) _jspx_tagPool_c_if_test.get(com.liferay.taglib.core.IfTag.class);
                          _jspx_th_c_if_3.setPageContext(_jspx_page_context);
                          _jspx_th_c_if_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_0);
                          _jspx_th_c_if_3.setTest( assetEntry != null );
                          int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
                          if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                            out.write("\n\t\t\t\t\t\t\t\t\t\t\t");
                            //  portlet:param
                            com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_3 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
                            _jspx_th_portlet_param_3.setPageContext(_jspx_page_context);
                            _jspx_th_portlet_param_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_3);
                            _jspx_th_portlet_param_3.setName("assetEntryId");
                            _jspx_th_portlet_param_3.setValue( String.valueOf(assetEntry.getEntryId()) );
                            int _jspx_eval_portlet_param_3 = _jspx_th_portlet_param_3.doStartTag();
                            if (_jspx_th_portlet_param_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                              _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_3);
                              return;
                            }
                            _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_3);
                            out.write("\n\t\t\t\t\t\t\t\t\t\t\t");
                            //  portlet:param
                            com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_4 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
                            _jspx_th_portlet_param_4.setPageContext(_jspx_page_context);
                            _jspx_th_portlet_param_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_3);
                            _jspx_th_portlet_param_4.setName("assetEntryClassPK");
                            _jspx_th_portlet_param_4.setValue( String.valueOf(assetEntry.getClassPK()) );
                            int _jspx_eval_portlet_param_4 = _jspx_th_portlet_param_4.doStartTag();
                            if (_jspx_th_portlet_param_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                              _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_4);
                              return;
                            }
                            _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_4);
                            out.write("\n\t\t\t\t\t\t\t\t\t\t");
                          }
                          if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                            _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
                            return;
                          }
                          _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
                          out.write("\n\n\t\t\t\t\t\t\t\t\t\t");
                          //  portlet:param
                          com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_5 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
                          _jspx_th_portlet_param_5.setPageContext(_jspx_page_context);
                          _jspx_th_portlet_param_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_0);
                          _jspx_th_portlet_param_5.setName("type");
                          _jspx_th_portlet_param_5.setValue( assetRendererFactory.getType() );
                          int _jspx_eval_portlet_param_5 = _jspx_th_portlet_param_5.doStartTag();
                          if (_jspx_th_portlet_param_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                            _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_5);
                            return;
                          }
                          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_5);
                          out.write("\n\t\t\t\t\t\t\t\t\t\t");
                          //  portlet:param
                          com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_6 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
                          _jspx_th_portlet_param_6.setPageContext(_jspx_page_context);
                          _jspx_th_portlet_param_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_0);
                          _jspx_th_portlet_param_6.setName("showEditURL");
                          _jspx_th_portlet_param_6.setValue( String.valueOf(workflowTaskDisplayContext.isShowEditURL(workflowTask)) );
                          int _jspx_eval_portlet_param_6 = _jspx_th_portlet_param_6.doStartTag();
                          if (_jspx_th_portlet_param_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                            _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_6);
                            return;
                          }
                          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_6);
                          out.write("\n\t\t\t\t\t\t\t\t\t\t");
                          //  portlet:param
                          com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_7 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
                          _jspx_th_portlet_param_7.setPageContext(_jspx_page_context);
                          _jspx_th_portlet_param_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_0);
                          _jspx_th_portlet_param_7.setName("workflowTaskId");
                          _jspx_th_portlet_param_7.setValue( String.valueOf(workflowTask.getWorkflowTaskId()) );
                          int _jspx_eval_portlet_param_7 = _jspx_th_portlet_param_7.doStartTag();
                          if (_jspx_th_portlet_param_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                            _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_7);
                            return;
                          }
                          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_7);
                          out.write("\n\t\t\t\t\t\t\t\t\t");
                        }
                        if (_jspx_th_portlet_renderURL_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                          _jspx_tagPool_portlet_renderURL_var.reuse(_jspx_th_portlet_renderURL_0);
                          return;
                        }
                        _jspx_tagPool_portlet_renderURL_var.reuse(_jspx_th_portlet_renderURL_0);
                        java.lang.String viewFullContentURL = null;
                        viewFullContentURL = (java.lang.String) _jspx_page_context.findAttribute("viewFullContentURL");
                        out.write("\n\n\t\t\t\t\t\t\t\t\t");
                        //  liferay-frontend:management-bar-button
                        com.liferay.frontend.taglib.servlet.taglib.ManagementBarButtonTag _jspx_th_liferay$1frontend_management$1bar$1button_0 = (com.liferay.frontend.taglib.servlet.taglib.ManagementBarButtonTag) _jspx_tagPool_liferay$1frontend_management$1bar$1button_label_icon_href_nobody.get(com.liferay.frontend.taglib.servlet.taglib.ManagementBarButtonTag.class);
                        _jspx_th_liferay$1frontend_management$1bar$1button_0.setPageContext(_jspx_page_context);
                        _jspx_th_liferay$1frontend_management$1bar$1button_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_2);
                        _jspx_th_liferay$1frontend_management$1bar$1button_0.setHref( assetRenderer.isPreviewInContext() ? assetRenderer.getURLViewInContext(liferayPortletRequest, liferayPortletResponse, null) : viewFullContentURL.toString() );
                        _jspx_th_liferay$1frontend_management$1bar$1button_0.setIcon("view");
                        _jspx_th_liferay$1frontend_management$1bar$1button_0.setLabel("view[action]");
                        int _jspx_eval_liferay$1frontend_management$1bar$1button_0 = _jspx_th_liferay$1frontend_management$1bar$1button_0.doStartTag();
                        if (_jspx_th_liferay$1frontend_management$1bar$1button_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                          _jspx_tagPool_liferay$1frontend_management$1bar$1button_label_icon_href_nobody.reuse(_jspx_th_liferay$1frontend_management$1bar$1button_0);
                          return;
                        }
                        _jspx_tagPool_liferay$1frontend_management$1bar$1button_label_icon_href_nobody.reuse(_jspx_th_liferay$1frontend_management$1bar$1button_0);
                        out.write("\n\n\t\t\t\t\t\t\t\t\t");
                        //  c:if
                        com.liferay.taglib.core.IfTag _jspx_th_c_if_4 = (com.liferay.taglib.core.IfTag) _jspx_tagPool_c_if_test.get(com.liferay.taglib.core.IfTag.class);
                        _jspx_th_c_if_4.setPageContext(_jspx_page_context);
                        _jspx_th_c_if_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_2);
                        _jspx_th_c_if_4.setTest( workflowTaskDisplayContext.hasViewDiffsPortletURL(workflowTask) );
                        int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
                        if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                          out.write("\n\t\t\t\t\t\t\t\t\t\t");
                          //  liferay-ui:icon
                          com.liferay.taglib.ui.IconTag _jspx_th_liferay$1ui_icon_0 = (com.liferay.taglib.ui.IconTag) _jspx_tagPool_liferay$1ui_icon_url_message_iconCssClass_nobody.get(com.liferay.taglib.ui.IconTag.class);
                          _jspx_th_liferay$1ui_icon_0.setPageContext(_jspx_page_context);
                          _jspx_th_liferay$1ui_icon_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_4);
                          _jspx_th_liferay$1ui_icon_0.setIconCssClass("icon-copy");
                          _jspx_th_liferay$1ui_icon_0.setMessage("diffs");
                          _jspx_th_liferay$1ui_icon_0.setUrl( workflowTaskDisplayContext.getTaglibViewDiffsURL(workflowTask) );
                          int _jspx_eval_liferay$1ui_icon_0 = _jspx_th_liferay$1ui_icon_0.doStartTag();
                          if (_jspx_th_liferay$1ui_icon_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                            _jspx_tagPool_liferay$1ui_icon_url_message_iconCssClass_nobody.reuse(_jspx_th_liferay$1ui_icon_0);
                            return;
                          }
                          _jspx_tagPool_liferay$1ui_icon_url_message_iconCssClass_nobody.reuse(_jspx_th_liferay$1ui_icon_0);
                          out.write("\n\t\t\t\t\t\t\t\t\t");
                        }
                        if (_jspx_th_c_if_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                          _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
                          return;
                        }
                        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
                        out.write("\n\t\t\t\t\t\t\t\t");
                      }
                      if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
                        return;
                      }
                      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
                      out.write("\n\n\t\t\t\t\t\t\t\t");
                      //  c:if
                      com.liferay.taglib.core.IfTag _jspx_th_c_if_5 = (com.liferay.taglib.core.IfTag) _jspx_tagPool_c_if_test.get(com.liferay.taglib.core.IfTag.class);
                      _jspx_th_c_if_5.setPageContext(_jspx_page_context);
                      _jspx_th_c_if_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_icon$1list_0);
                      _jspx_th_c_if_5.setTest( workflowTaskDisplayContext.hasEditPortletURL(workflowTask) );
                      int _jspx_eval_c_if_5 = _jspx_th_c_if_5.doStartTag();
                      if (_jspx_eval_c_if_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        out.write("\n\t\t\t\t\t\t\t\t\t");
                        //  c:choose
                        com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_1 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
                        _jspx_th_c_choose_1.setPageContext(_jspx_page_context);
                        _jspx_th_c_choose_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_5);
                        int _jspx_eval_c_choose_1 = _jspx_th_c_choose_1.doStartTag();
                        if (_jspx_eval_c_choose_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                          out.write("\n\t\t\t\t\t\t\t\t\t\t");
                          //  c:when
                          com.liferay.taglib.core.WhenTag _jspx_th_c_when_1 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                          _jspx_th_c_when_1.setPageContext(_jspx_page_context);
                          _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
                          _jspx_th_c_when_1.setTest( assetRenderer.hasEditPermission(permissionChecker) && workflowTaskDisplayContext.isShowEditURL(workflowTask) );
                          int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
                          if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                            out.write("\n\t\t\t\t\t\t\t\t\t\t\t");
                            //  liferay-frontend:management-bar-button
                            com.liferay.frontend.taglib.servlet.taglib.ManagementBarButtonTag _jspx_th_liferay$1frontend_management$1bar$1button_1 = (com.liferay.frontend.taglib.servlet.taglib.ManagementBarButtonTag) _jspx_tagPool_liferay$1frontend_management$1bar$1button_label_icon_href_nobody.get(com.liferay.frontend.taglib.servlet.taglib.ManagementBarButtonTag.class);
                            _jspx_th_liferay$1frontend_management$1bar$1button_1.setPageContext(_jspx_page_context);
                            _jspx_th_liferay$1frontend_management$1bar$1button_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_1);
                            _jspx_th_liferay$1frontend_management$1bar$1button_1.setHref( workflowTaskDisplayContext.getTaglibEditURL(workflowTask) );
                            _jspx_th_liferay$1frontend_management$1bar$1button_1.setIcon("pencil");
                            _jspx_th_liferay$1frontend_management$1bar$1button_1.setLabel("edit");
                            int _jspx_eval_liferay$1frontend_management$1bar$1button_1 = _jspx_th_liferay$1frontend_management$1bar$1button_1.doStartTag();
                            if (_jspx_th_liferay$1frontend_management$1bar$1button_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                              _jspx_tagPool_liferay$1frontend_management$1bar$1button_label_icon_href_nobody.reuse(_jspx_th_liferay$1frontend_management$1bar$1button_1);
                              return;
                            }
                            _jspx_tagPool_liferay$1frontend_management$1bar$1button_label_icon_href_nobody.reuse(_jspx_th_liferay$1frontend_management$1bar$1button_1);
                            out.write("\n\t\t\t\t\t\t\t\t\t\t");
                          }
                          if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                            _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
                            return;
                          }
                          _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
                          out.write("\n\t\t\t\t\t\t\t\t\t\t");
                          //  c:when
                          com.liferay.taglib.core.WhenTag _jspx_th_c_when_2 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                          _jspx_th_c_when_2.setPageContext(_jspx_page_context);
                          _jspx_th_c_when_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
                          _jspx_th_c_when_2.setTest( assetRenderer.hasEditPermission(permissionChecker) && !workflowTaskDisplayContext.isShowEditURL(workflowTask) && !workflowTask.isCompleted() );
                          int _jspx_eval_c_when_2 = _jspx_th_c_when_2.doStartTag();
                          if (_jspx_eval_c_when_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                            out.write("\n\t\t\t\t\t\t\t\t\t\t\t");
                            if (_jspx_meth_liferay$1frontend_management$1bar$1button_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_2, _jspx_page_context))
                              return;
                            out.write("\n\t\t\t\t\t\t\t\t\t\t");
                          }
                          if (_jspx_th_c_when_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                            _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_2);
                            return;
                          }
                          _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_2);
                          out.write("\n\t\t\t\t\t\t\t\t\t");
                        }
                        if (_jspx_th_c_choose_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                          _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
                          return;
                        }
                        _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
                        out.write("\n\t\t\t\t\t\t\t\t");
                      }
                      if (_jspx_th_c_if_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
                        return;
                      }
                      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
                      out.write("\n\t\t\t\t\t\t\t");
                      int evalDoAfterBody = _jspx_th_liferay$1ui_icon$1list_0.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_liferay$1ui_icon$1list_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                      out = _jspx_page_context.popBody();
                  }
                  if (_jspx_th_liferay$1ui_icon$1list_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_liferay$1ui_icon$1list.reuse(_jspx_th_liferay$1ui_icon$1list_0);
                    return;
                  }
                  _jspx_tagPool_liferay$1ui_icon$1list.reuse(_jspx_th_liferay$1ui_icon$1list_0);
                  out.write("\n\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t<h3 class=\"task-content-title\">\n\t\t\t\t\t\t\t");
                  //  liferay-ui:icon
                  com.liferay.taglib.ui.IconTag _jspx_th_liferay$1ui_icon_1 = (com.liferay.taglib.ui.IconTag) _jspx_tagPool_liferay$1ui_icon_message_markupView_label_icon_nobody.get(com.liferay.taglib.ui.IconTag.class);
                  _jspx_th_liferay$1ui_icon_1.setPageContext(_jspx_page_context);
                  _jspx_th_liferay$1ui_icon_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_panel_0);
                  _jspx_th_liferay$1ui_icon_1.setIcon( workflowHandler.getIconCssClass() );
                  _jspx_th_liferay$1ui_icon_1.setLabel( true );
                  _jspx_th_liferay$1ui_icon_1.setMarkupView("lexicon");
                  _jspx_th_liferay$1ui_icon_1.setMessage( workflowTaskDisplayContext.getTaskContentTitle(workflowTask) );
                  int _jspx_eval_liferay$1ui_icon_1 = _jspx_th_liferay$1ui_icon_1.doStartTag();
                  if (_jspx_th_liferay$1ui_icon_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_liferay$1ui_icon_message_markupView_label_icon_nobody.reuse(_jspx_th_liferay$1ui_icon_1);
                    return;
                  }
                  _jspx_tagPool_liferay$1ui_icon_message_markupView_label_icon_nobody.reuse(_jspx_th_liferay$1ui_icon_1);
                  out.write("\n\t\t\t\t\t\t</h3>\n\n\t\t\t\t\t\t");
                  //  liferay-asset:asset-display
                  com.liferay.asset.taglib.servlet.taglib.AssetDisplayTag _jspx_th_liferay$1asset_asset$1display_0 = (com.liferay.asset.taglib.servlet.taglib.AssetDisplayTag) _jspx_tagPool_liferay$1asset_asset$1display_template_assetRenderer_nobody.get(com.liferay.asset.taglib.servlet.taglib.AssetDisplayTag.class);
                  _jspx_th_liferay$1asset_asset$1display_0.setPageContext(_jspx_page_context);
                  _jspx_th_liferay$1asset_asset$1display_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_panel_0);
                  _jspx_th_liferay$1asset_asset$1display_0.setAssetRenderer( assetRenderer );
                  _jspx_th_liferay$1asset_asset$1display_0.setTemplate( AssetRenderer.TEMPLATE_ABSTRACT );
                  int _jspx_eval_liferay$1asset_asset$1display_0 = _jspx_th_liferay$1asset_asset$1display_0.doStartTag();
                  if (_jspx_th_liferay$1asset_asset$1display_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_liferay$1asset_asset$1display_template_assetRenderer_nobody.reuse(_jspx_th_liferay$1asset_asset$1display_0);
                    return;
                  }
                  _jspx_tagPool_liferay$1asset_asset$1display_template_assetRenderer_nobody.reuse(_jspx_th_liferay$1asset_asset$1display_0);
                  out.write("\n\t\t\t\t\t");
                }
                if (_jspx_th_liferay$1ui_panel_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_liferay$1ui_panel_title_markupView_extended.reuse(_jspx_th_liferay$1ui_panel_0);
                  return;
                }
                _jspx_tagPool_liferay$1ui_panel_title_markupView_extended.reuse(_jspx_th_liferay$1ui_panel_0);
                out.write("\n\n\t\t\t\t\t");
                //  liferay-ui:panel
                com.liferay.taglib.ui.PanelTag _jspx_th_liferay$1ui_panel_1 = (com.liferay.taglib.ui.PanelTag) _jspx_tagPool_liferay$1ui_panel_title_markupView_extended.get(com.liferay.taglib.ui.PanelTag.class);
                _jspx_th_liferay$1ui_panel_1.setPageContext(_jspx_page_context);
                _jspx_th_liferay$1ui_panel_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
                _jspx_th_liferay$1ui_panel_1.setExtended( true );
                _jspx_th_liferay$1ui_panel_1.setMarkupView("lexicon");
                _jspx_th_liferay$1ui_panel_1.setTitle("comments");
                int _jspx_eval_liferay$1ui_panel_1 = _jspx_th_liferay$1ui_panel_1.doStartTag();
                if (_jspx_eval_liferay$1ui_panel_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\t\t\t\t\t\t");
                  //  liferay-comment:discussion
                  com.liferay.comment.taglib.servlet.taglib.DiscussionTag _jspx_th_liferay$1comment_discussion_0 = (com.liferay.comment.taglib.servlet.taglib.DiscussionTag) _jspx_tagPool_liferay$1comment_discussion_userId_redirect_ratingsEnabled_formName_classPK_className_assetEntryVisible_nobody.get(com.liferay.comment.taglib.servlet.taglib.DiscussionTag.class);
                  _jspx_th_liferay$1comment_discussion_0.setPageContext(_jspx_page_context);
                  _jspx_th_liferay$1comment_discussion_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_panel_1);
                  _jspx_th_liferay$1comment_discussion_0.setAssetEntryVisible( false );
                  _jspx_th_liferay$1comment_discussion_0.setClassName( assetRenderer.getClassName() );
                  _jspx_th_liferay$1comment_discussion_0.setClassPK( assetRenderer.getClassPK() );
                  _jspx_th_liferay$1comment_discussion_0.setFormName( "fm" + assetRenderer.getClassPK() );
                  _jspx_th_liferay$1comment_discussion_0.setRatingsEnabled( false );
                  _jspx_th_liferay$1comment_discussion_0.setRedirect( currentURL );
                  _jspx_th_liferay$1comment_discussion_0.setUserId( user.getUserId() );
                  int _jspx_eval_liferay$1comment_discussion_0 = _jspx_th_liferay$1comment_discussion_0.doStartTag();
                  if (_jspx_th_liferay$1comment_discussion_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_liferay$1comment_discussion_userId_redirect_ratingsEnabled_formName_classPK_className_assetEntryVisible_nobody.reuse(_jspx_th_liferay$1comment_discussion_0);
                    return;
                  }
                  _jspx_tagPool_liferay$1comment_discussion_userId_redirect_ratingsEnabled_formName_classPK_className_assetEntryVisible_nobody.reuse(_jspx_th_liferay$1comment_discussion_0);
                  out.write("\n\t\t\t\t\t");
                }
                if (_jspx_th_liferay$1ui_panel_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_liferay$1ui_panel_title_markupView_extended.reuse(_jspx_th_liferay$1ui_panel_1);
                  return;
                }
                _jspx_tagPool_liferay$1ui_panel_title_markupView_extended.reuse(_jspx_th_liferay$1ui_panel_1);
                out.write("\n\t\t\t\t");
              }
              if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
                return;
              }
              _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
              out.write("\n\n\t\t\t\t");
              //  liferay-ui:panel
              com.liferay.taglib.ui.PanelTag _jspx_th_liferay$1ui_panel_2 = (com.liferay.taglib.ui.PanelTag) _jspx_tagPool_liferay$1ui_panel_title_markupView.get(com.liferay.taglib.ui.PanelTag.class);
              _jspx_th_liferay$1ui_panel_2.setPageContext(_jspx_page_context);
              _jspx_th_liferay$1ui_panel_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_panel$1container_0);
              _jspx_th_liferay$1ui_panel_2.setMarkupView("lexicon");
              _jspx_th_liferay$1ui_panel_2.setTitle("activities");
              int _jspx_eval_liferay$1ui_panel_2 = _jspx_th_liferay$1ui_panel_2.doStartTag();
              if (_jspx_eval_liferay$1ui_panel_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                out.write("\n\n\t\t\t\t\t");

					List<WorkflowLog> workflowLogs = workflowTaskDisplayContext.getWorkflowLogs(workflowTask);
					
                out.write("\n\n\t\t\t\t\t");
                out.write("\n\n<div class=\"task-activity\">\n\t<table class=\"table table-responsive\">\n\t\t<thead>\n\t\t\t<tr>\n\t\t\t\t<th>\n\t\t\t\t\t");
                if (_jspx_meth_liferay$1ui_message_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1ui_panel_2, _jspx_page_context))
                  return;
                out.write("\n\t\t\t\t</th>\n\t\t\t\t<th>\n\t\t\t\t\t");
                if (_jspx_meth_liferay$1ui_message_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1ui_panel_2, _jspx_page_context))
                  return;
                out.write("\n\t\t\t\t</th>\n\t\t\t</tr>\n\t\t</thead>\n\n\t\t<tbody>\n\n\t\t\t");

			for (WorkflowLog workflowLog : workflowLogs) {
			
                out.write("\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<div>\n\t\t\t\t\t\t\t");
                //  c:choose
                com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_2 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
                _jspx_th_c_choose_2.setPageContext(_jspx_page_context);
                _jspx_th_c_choose_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_panel_2);
                int _jspx_eval_c_choose_2 = _jspx_th_c_choose_2.doStartTag();
                if (_jspx_eval_c_choose_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\t\t\t\t\t\t\t\t");
                  //  c:when
                  com.liferay.taglib.core.WhenTag _jspx_th_c_when_3 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                  _jspx_th_c_when_3.setPageContext(_jspx_page_context);
                  _jspx_th_c_when_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_2);
                  _jspx_th_c_when_3.setTest( workflowLog.getType() == WorkflowLog.TASK_COMPLETION );
                  int _jspx_eval_c_when_3 = _jspx_th_c_when_3.doStartTag();
                  if (_jspx_eval_c_when_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    out.write("\n\t\t\t\t\t\t\t\t\t");
                    //  liferay-ui:message
                    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_2 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
                    _jspx_th_liferay$1ui_message_2.setPageContext(_jspx_page_context);
                    _jspx_th_liferay$1ui_message_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_3);
                    _jspx_th_liferay$1ui_message_2.setArguments( workflowTaskDisplayContext.getTaskCompletionMessageArguments(workflowLog) );
                    _jspx_th_liferay$1ui_message_2.setKey("x-completed-the-task-x");
                    _jspx_th_liferay$1ui_message_2.setTranslateArguments( false );
                    int _jspx_eval_liferay$1ui_message_2 = _jspx_th_liferay$1ui_message_2.doStartTag();
                    if (_jspx_th_liferay$1ui_message_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_2);
                      return;
                    }
                    _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_2);
                    out.write("\n\t\t\t\t\t\t\t\t");
                  }
                  if (_jspx_th_c_when_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_3);
                    return;
                  }
                  _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_3);
                  out.write("\n\t\t\t\t\t\t\t\t");
                  //  c:when
                  com.liferay.taglib.core.WhenTag _jspx_th_c_when_4 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                  _jspx_th_c_when_4.setPageContext(_jspx_page_context);
                  _jspx_th_c_when_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_2);
                  _jspx_th_c_when_4.setTest( workflowLog.getType() == WorkflowLog.TASK_UPDATE );
                  int _jspx_eval_c_when_4 = _jspx_th_c_when_4.doStartTag();
                  if (_jspx_eval_c_when_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    out.write("\n\t\t\t\t\t\t\t\t\t");
                    //  liferay-ui:message
                    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_3 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
                    _jspx_th_liferay$1ui_message_3.setPageContext(_jspx_page_context);
                    _jspx_th_liferay$1ui_message_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_4);
                    _jspx_th_liferay$1ui_message_3.setArguments( workflowTaskDisplayContext.getTaskUpdateMessageArguments(workflowLog) );
                    _jspx_th_liferay$1ui_message_3.setKey("x-updated-the-due-date");
                    int _jspx_eval_liferay$1ui_message_3 = _jspx_th_liferay$1ui_message_3.doStartTag();
                    if (_jspx_th_liferay$1ui_message_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_liferay$1ui_message_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_3);
                      return;
                    }
                    _jspx_tagPool_liferay$1ui_message_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_3);
                    out.write("\n\t\t\t\t\t\t\t\t");
                  }
                  if (_jspx_th_c_when_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_4);
                    return;
                  }
                  _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_4);
                  out.write("\n\t\t\t\t\t\t\t\t");
                  //  c:when
                  com.liferay.taglib.core.WhenTag _jspx_th_c_when_5 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                  _jspx_th_c_when_5.setPageContext(_jspx_page_context);
                  _jspx_th_c_when_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_2);
                  _jspx_th_c_when_5.setTest( workflowLog.getType() == WorkflowLog.TRANSITION );
                  int _jspx_eval_c_when_5 = _jspx_th_c_when_5.doStartTag();
                  if (_jspx_eval_c_when_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    out.write("\n\t\t\t\t\t\t\t\t\t");
                    //  liferay-ui:message
                    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_4 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
                    _jspx_th_liferay$1ui_message_4.setPageContext(_jspx_page_context);
                    _jspx_th_liferay$1ui_message_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_5);
                    _jspx_th_liferay$1ui_message_4.setArguments( workflowTaskDisplayContext.getTransitionMessageArguments(workflowLog) );
                    _jspx_th_liferay$1ui_message_4.setKey("x-changed-the-state-from-x-to-x");
                    _jspx_th_liferay$1ui_message_4.setTranslateArguments( false );
                    int _jspx_eval_liferay$1ui_message_4 = _jspx_th_liferay$1ui_message_4.doStartTag();
                    if (_jspx_th_liferay$1ui_message_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_4);
                      return;
                    }
                    _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_4);
                    out.write("\n\t\t\t\t\t\t\t\t");
                  }
                  if (_jspx_th_c_when_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_5);
                    return;
                  }
                  _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_5);
                  out.write("\n\t\t\t\t\t\t\t\t");
                  //  c:when
                  com.liferay.taglib.core.WhenTag _jspx_th_c_when_6 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                  _jspx_th_c_when_6.setPageContext(_jspx_page_context);
                  _jspx_th_c_when_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_2);
                  _jspx_th_c_when_6.setTest( workflowTaskDisplayContext.isAuditUser(workflowLog) );
                  int _jspx_eval_c_when_6 = _jspx_th_c_when_6.doStartTag();
                  if (_jspx_eval_c_when_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    out.write("\n\t\t\t\t\t\t\t\t\t");
                    //  liferay-ui:message
                    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_5 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
                    _jspx_th_liferay$1ui_message_5.setPageContext(_jspx_page_context);
                    _jspx_th_liferay$1ui_message_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_6);
                    _jspx_th_liferay$1ui_message_5.setArguments( workflowTaskDisplayContext.getUserFullName(workflowLog) );
                    _jspx_th_liferay$1ui_message_5.setKey( workflowTaskDisplayContext.getAssignedTheTaskMessageKey(workflowLog) );
                    _jspx_th_liferay$1ui_message_5.setTranslateArguments( false );
                    int _jspx_eval_liferay$1ui_message_5 = _jspx_th_liferay$1ui_message_5.doStartTag();
                    if (_jspx_th_liferay$1ui_message_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_5);
                      return;
                    }
                    _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_5);
                    out.write("\n\t\t\t\t\t\t\t\t");
                  }
                  if (_jspx_th_c_when_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_6);
                    return;
                  }
                  _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_6);
                  out.write("\n\t\t\t\t\t\t\t\t");
                  //  c:when
                  com.liferay.taglib.core.WhenTag _jspx_th_c_when_7 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                  _jspx_th_c_when_7.setPageContext(_jspx_page_context);
                  _jspx_th_c_when_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_2);
                  _jspx_th_c_when_7.setTest( workflowLog.getRoleId() == 0 );
                  int _jspx_eval_c_when_7 = _jspx_th_c_when_7.doStartTag();
                  if (_jspx_eval_c_when_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    out.write("\n\t\t\t\t\t\t\t\t\t");
                    //  liferay-ui:message
                    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_6 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
                    _jspx_th_liferay$1ui_message_6.setPageContext(_jspx_page_context);
                    _jspx_th_liferay$1ui_message_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_7);
                    _jspx_th_liferay$1ui_message_6.setArguments( workflowTaskDisplayContext.getAssignedTheTaskToMessageArguments(workflowLog) );
                    _jspx_th_liferay$1ui_message_6.setKey("x-assigned-the-task-to-x");
                    _jspx_th_liferay$1ui_message_6.setTranslateArguments( false );
                    int _jspx_eval_liferay$1ui_message_6 = _jspx_th_liferay$1ui_message_6.doStartTag();
                    if (_jspx_th_liferay$1ui_message_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_6);
                      return;
                    }
                    _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_6);
                    out.write("\n\n\t\t\t\t\t\t\t\t\t");
                    //  c:if
                    com.liferay.taglib.core.IfTag _jspx_th_c_if_6 = (com.liferay.taglib.core.IfTag) _jspx_tagPool_c_if_test.get(com.liferay.taglib.core.IfTag.class);
                    _jspx_th_c_if_6.setPageContext(_jspx_page_context);
                    _jspx_th_c_if_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_7);
                    _jspx_th_c_if_6.setTest( workflowLog.getPreviousUserId() != 0 );
                    int _jspx_eval_c_if_6 = _jspx_th_c_if_6.doStartTag();
                    if (_jspx_eval_c_if_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                      out.write("\n\t\t\t\t\t\t\t\t\t\t");
                      //  liferay-ui:message
                      com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_7 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
                      _jspx_th_liferay$1ui_message_7.setPageContext(_jspx_page_context);
                      _jspx_th_liferay$1ui_message_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_6);
                      _jspx_th_liferay$1ui_message_7.setArguments( workflowTaskDisplayContext.getPreviousAssigneeMessageArguments(workflowLog) );
                      _jspx_th_liferay$1ui_message_7.setKey("previous-assignee-was-x");
                      _jspx_th_liferay$1ui_message_7.setTranslateArguments( false );
                      int _jspx_eval_liferay$1ui_message_7 = _jspx_th_liferay$1ui_message_7.doStartTag();
                      if (_jspx_th_liferay$1ui_message_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_7);
                        return;
                      }
                      _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_7);
                      out.write("\n\t\t\t\t\t\t\t\t\t");
                    }
                    if (_jspx_th_c_if_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_6);
                      return;
                    }
                    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_6);
                    out.write("\n\t\t\t\t\t\t\t\t");
                  }
                  if (_jspx_th_c_when_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_7);
                    return;
                  }
                  _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_7);
                  out.write("\n\t\t\t\t\t\t\t\t");
                  //  c:otherwise
                  com.liferay.taglib.core.OtherwiseTag _jspx_th_c_otherwise_1 = (com.liferay.taglib.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(com.liferay.taglib.core.OtherwiseTag.class);
                  _jspx_th_c_otherwise_1.setPageContext(_jspx_page_context);
                  _jspx_th_c_otherwise_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_2);
                  int _jspx_eval_c_otherwise_1 = _jspx_th_c_otherwise_1.doStartTag();
                  if (_jspx_eval_c_otherwise_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    out.write("\n\t\t\t\t\t\t\t\t\t");
                    //  liferay-ui:message
                    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_8 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
                    _jspx_th_liferay$1ui_message_8.setPageContext(_jspx_page_context);
                    _jspx_th_liferay$1ui_message_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_1);
                    _jspx_th_liferay$1ui_message_8.setArguments( workflowTaskDisplayContext.getTaskInitiallyAssignedMessageArguments(workflowLog) );
                    _jspx_th_liferay$1ui_message_8.setKey("task-initially-assigned-to-the-x-role");
                    _jspx_th_liferay$1ui_message_8.setTranslateArguments( false );
                    int _jspx_eval_liferay$1ui_message_8 = _jspx_th_liferay$1ui_message_8.doStartTag();
                    if (_jspx_th_liferay$1ui_message_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_8);
                      return;
                    }
                    _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_8);
                    out.write("\n\t\t\t\t\t\t\t\t");
                  }
                  if (_jspx_th_c_otherwise_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_1);
                    return;
                  }
                  _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_1);
                  out.write("\n\t\t\t\t\t\t\t");
                }
                if (_jspx_th_c_choose_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_2);
                  return;
                }
                _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_2);
                out.write("\n\t\t\t\t\t\t\t");
                out.print( HtmlUtil.escape(workflowLog.getComment()) );
                out.write("\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<div>\n\t\t\t\t\t\t\t");
                out.print( workflowTaskDisplayContext.getCreateDate(workflowLog) );
                out.write("\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\n\t\t\t");

			}
			
                out.write("\n\n\t\t</tbody>\n\t</table>\n</div>");
                out.write("\n\t\t\t\t");
              }
              if (_jspx_th_liferay$1ui_panel_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_liferay$1ui_panel_title_markupView.reuse(_jspx_th_liferay$1ui_panel_2);
                return;
              }
              _jspx_tagPool_liferay$1ui_panel_title_markupView.reuse(_jspx_th_liferay$1ui_panel_2);
              out.write("\n\t\t\t");
              int evalDoAfterBody = _jspx_th_liferay$1ui_panel$1container_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_liferay$1ui_panel$1container_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_liferay$1ui_panel$1container_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_liferay$1ui_panel$1container_extended_cssClass.reuse(_jspx_th_liferay$1ui_panel$1container_0);
            return;
          }
          _jspx_tagPool_liferay$1ui_panel$1container_extended_cssClass.reuse(_jspx_th_liferay$1ui_panel$1container_0);
          out.write("\n\t\t");
        }
        if (_jspx_th_aui_fieldset$1group_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_fieldset$1group_markupView.reuse(_jspx_th_aui_fieldset$1group_0);
          return;
        }
        _jspx_tagPool_aui_fieldset$1group_markupView.reuse(_jspx_th_aui_fieldset$1group_0);
        out.write('\n');
        out.write('	');
      }
      if (_jspx_th_aui_col_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_col_cssClass.reuse(_jspx_th_aui_col_0);
        return;
      }
      _jspx_tagPool_aui_col_cssClass.reuse(_jspx_th_aui_col_0);
      out.write("\n</div>\n\n");
      //  aui:script
      com.liferay.taglib.aui.ScriptTag _jspx_th_aui_script_0 = (com.liferay.taglib.aui.ScriptTag) _jspx_tagPool_aui_script_use.get(com.liferay.taglib.aui.ScriptTag.class);
      _jspx_th_aui_script_0.setPageContext(_jspx_page_context);
      _jspx_th_aui_script_0.setParent(null);
      _jspx_th_aui_script_0.setUse("liferay-workflow-tasks");
      int _jspx_eval_aui_script_0 = _jspx_th_aui_script_0.doStartTag();
      if (_jspx_eval_aui_script_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_aui_script_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_aui_script_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_aui_script_0.doInitBody();
        }
        do {
          out.write("\n\tvar onTaskClickFn = A.rbind('onTaskClick', Liferay.WorkflowTasks, '');\n\n\tLiferay.delegateClick('");
          if (_jspx_meth_portlet_namespace_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_0, _jspx_page_context))
            return;
          out.print( randomId );
          out.write("taskAssignLink', onTaskClickFn);\n");
          int evalDoAfterBody = _jspx_th_aui_script_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_aui_script_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
      }
      if (_jspx_th_aui_script_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_script_use.reuse(_jspx_th_aui_script_0);
        return;
      }
      _jspx_tagPool_aui_script_use.reuse(_jspx_th_aui_script_0);
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

  private boolean _jspx_meth_portlet_param_0(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_renderURL_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_0 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_0.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_0);
    _jspx_th_portlet_param_0.setName("mvcPath");
    _jspx_th_portlet_param_0.setValue("/view_content.jsp");
    int _jspx_eval_portlet_param_0 = _jspx_th_portlet_param_0.doStartTag();
    if (_jspx_th_portlet_param_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_0);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_0);
    return false;
  }

  private boolean _jspx_meth_liferay$1frontend_management$1bar$1button_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-frontend:management-bar-button
    com.liferay.frontend.taglib.servlet.taglib.ManagementBarButtonTag _jspx_th_liferay$1frontend_management$1bar$1button_2 = (com.liferay.frontend.taglib.servlet.taglib.ManagementBarButtonTag) _jspx_tagPool_liferay$1frontend_management$1bar$1button_label_icon_href_nobody.get(com.liferay.frontend.taglib.servlet.taglib.ManagementBarButtonTag.class);
    _jspx_th_liferay$1frontend_management$1bar$1button_2.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1frontend_management$1bar$1button_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_2);
    _jspx_th_liferay$1frontend_management$1bar$1button_2.setHref("");
    _jspx_th_liferay$1frontend_management$1bar$1button_2.setIcon("question-circle-full");
    _jspx_th_liferay$1frontend_management$1bar$1button_2.setLabel("please-assign-the-task-to-yourself-to-be-able-to-edit-the-content");
    int _jspx_eval_liferay$1frontend_management$1bar$1button_2 = _jspx_th_liferay$1frontend_management$1bar$1button_2.doStartTag();
    if (_jspx_th_liferay$1frontend_management$1bar$1button_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1frontend_management$1bar$1button_label_icon_href_nobody.reuse(_jspx_th_liferay$1frontend_management$1bar$1button_2);
      return true;
    }
    _jspx_tagPool_liferay$1frontend_management$1bar$1button_label_icon_href_nobody.reuse(_jspx_th_liferay$1frontend_management$1bar$1button_2);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_message_0(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1ui_panel_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_0 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_0.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_panel_2);
    _jspx_th_liferay$1ui_message_0.setKey("activity-description");
    int _jspx_eval_liferay$1ui_message_0 = _jspx_th_liferay$1ui_message_0.doStartTag();
    if (_jspx_th_liferay$1ui_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_0);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_0);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_message_1(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1ui_panel_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_1 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_1.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_panel_2);
    _jspx_th_liferay$1ui_message_1.setKey("date");
    int _jspx_eval_liferay$1ui_message_1 = _jspx_th_liferay$1ui_message_1.doStartTag();
    if (_jspx_th_liferay$1ui_message_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_1);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_1);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_0(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_script_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_0 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_0.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_0);
    int _jspx_eval_portlet_namespace_0 = _jspx_th_portlet_namespace_0.doStartTag();
    if (_jspx_th_portlet_namespace_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_0);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_0);
    return false;
  }
}
