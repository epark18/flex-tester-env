package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.liferay.exportimport.kernel.background.task.BackgroundTaskExecutorNames;
import com.liferay.exportimport.kernel.exception.RemoteExportException;
import com.liferay.exportimport.kernel.staging.LayoutStagingUtil;
import com.liferay.exportimport.kernel.staging.StagingUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.exception.LayoutBranchNameException;
import com.liferay.portal.kernel.exception.LayoutSetBranchNameException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutBranch;
import com.liferay.portal.kernel.model.LayoutRevision;
import com.liferay.portal.kernel.model.LayoutRevisionConstants;
import com.liferay.portal.kernel.model.LayoutSetBranch;
import com.liferay.portal.kernel.model.LayoutSetBranchConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.LayoutBranchLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutRevisionLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutSetBranchLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.kernel.service.permission.GroupPermissionUtil;
import com.liferay.portal.kernel.service.permission.LayoutBranchPermissionUtil;
import com.liferay.portal.kernel.service.permission.LayoutPermissionUtil;
import com.liferay.portal.kernel.service.permission.LayoutSetBranchPermissionUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.util.comparator.LayoutRevisionCreateDateComparator;
import com.liferay.portal.kernel.util.comparator.LayoutRevisionIdComparator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.util.PropsValues;
import com.liferay.staging.bar.web.internal.display.context.LayoutBranchDisplayContext;
import com.liferay.staging.bar.web.internal.display.context.LayoutSetBranchDisplayContext;
import com.liferay.staging.constants.StagingProcessesWebKeys;
import java.util.ArrayList;
import java.util.List;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

public final class view_005flayout_005frevisions_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/init.jsp");
    _jspx_dependants.add("/init-ext.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1util_param_value_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_model$1context_model_bean_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1container_total;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_option_value_label_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_script;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_script_sandbox;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_workflow$1status_status_showLabel_showIcon_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1util_include_servletContext_page;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1container$1row_modelVar_keyProperty_escapedModel_className;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_namespace_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1staging_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_message_key_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1iterator_searchContainer_paginate_markupView_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1container$1column$1date_value_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1container$1results_results_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1container$1column$1jsp_path_cssClass_align_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_option_value_selected_localizeLabel_label_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_message_translateArguments_key_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1theme_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_select_name_label_inlineLabel_cssClass;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_workflow$1status_statusMessage_status_showLabel_showIcon_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_liferay$1util_param_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_model$1context_model_bean_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1container_total = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_option_value_label_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_script = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_script_sandbox = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_workflow$1status_status_showLabel_showIcon_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1util_include_servletContext_page = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1container$1row_modelVar_keyProperty_escapedModel_className = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_namespace_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1staging_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_message_key_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1iterator_searchContainer_paginate_markupView_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1container$1column$1date_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1container$1results_results_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1container$1column$1jsp_path_cssClass_align_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_option_value_selected_localizeLabel_label_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_message_translateArguments_key_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1theme_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_select_name_label_inlineLabel_cssClass = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_workflow$1status_statusMessage_status_showLabel_showIcon_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_liferay$1util_param_value_name_nobody.release();
    _jspx_tagPool_aui_model$1context_model_bean_nobody.release();
    _jspx_tagPool_liferay$1ui_search$1container_total.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_aui_option_value_label_nobody.release();
    _jspx_tagPool_aui_script.release();
    _jspx_tagPool_aui_script_sandbox.release();
    _jspx_tagPool_aui_workflow$1status_status_showLabel_showIcon_nobody.release();
    _jspx_tagPool_liferay$1util_include_servletContext_page.release();
    _jspx_tagPool_liferay$1ui_search$1container$1row_modelVar_keyProperty_escapedModel_className.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_liferay$1frontend_defineObjects_nobody.release();
    _jspx_tagPool_c_when_test.release();
    _jspx_tagPool_portlet_namespace_nobody.release();
    _jspx_tagPool_liferay$1staging_defineObjects_nobody.release();
    _jspx_tagPool_liferay$1ui_message_key_nobody.release();
    _jspx_tagPool_liferay$1ui_search$1iterator_searchContainer_paginate_markupView_nobody.release();
    _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name.release();
    _jspx_tagPool_liferay$1ui_search$1container$1column$1date_value_name_nobody.release();
    _jspx_tagPool_liferay$1ui_search$1container$1results_results_nobody.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_portlet_defineObjects_nobody.release();
    _jspx_tagPool_liferay$1ui_search$1container$1column$1jsp_path_cssClass_align_nobody.release();
    _jspx_tagPool_aui_option_value_selected_localizeLabel_label_nobody.release();
    _jspx_tagPool_liferay$1ui_message_translateArguments_key_nobody.release();
    _jspx_tagPool_liferay$1theme_defineObjects_nobody.release();
    _jspx_tagPool_aui_select_name_label_inlineLabel_cssClass.release();
    _jspx_tagPool_aui_workflow$1status_statusMessage_status_showLabel_showIcon_nobody.release();
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
      //  liferay-frontend:defineObjects
      com.liferay.frontend.taglib.servlet.taglib.DefineObjectsTag _jspx_th_liferay$1frontend_defineObjects_0 = (com.liferay.frontend.taglib.servlet.taglib.DefineObjectsTag) _jspx_tagPool_liferay$1frontend_defineObjects_nobody.get(com.liferay.frontend.taglib.servlet.taglib.DefineObjectsTag.class);
      _jspx_th_liferay$1frontend_defineObjects_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1frontend_defineObjects_0.setParent(null);
      int _jspx_eval_liferay$1frontend_defineObjects_0 = _jspx_th_liferay$1frontend_defineObjects_0.doStartTag();
      if (_jspx_th_liferay$1frontend_defineObjects_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1frontend_defineObjects_nobody.reuse(_jspx_th_liferay$1frontend_defineObjects_0);
        return;
      }
      _jspx_tagPool_liferay$1frontend_defineObjects_nobody.reuse(_jspx_th_liferay$1frontend_defineObjects_0);
      java.lang.String currentURL = null;
      javax.portlet.PortletURL currentURLObj = null;
      java.lang.String npmResolvedPackageName = null;
      java.util.ResourceBundle resourceBundle = null;
      javax.portlet.WindowState windowState = null;
      currentURL = (java.lang.String) _jspx_page_context.findAttribute("currentURL");
      currentURLObj = (javax.portlet.PortletURL) _jspx_page_context.findAttribute("currentURLObj");
      npmResolvedPackageName = (java.lang.String) _jspx_page_context.findAttribute("npmResolvedPackageName");
      resourceBundle = (java.util.ResourceBundle) _jspx_page_context.findAttribute("resourceBundle");
      windowState = (javax.portlet.WindowState) _jspx_page_context.findAttribute("windowState");
      out.write('\n');
      out.write('\n');
      //  liferay-staging:defineObjects
      com.liferay.staging.taglib.servlet.taglib.DefineObjectsTag _jspx_th_liferay$1staging_defineObjects_0 = (com.liferay.staging.taglib.servlet.taglib.DefineObjectsTag) _jspx_tagPool_liferay$1staging_defineObjects_nobody.get(com.liferay.staging.taglib.servlet.taglib.DefineObjectsTag.class);
      _jspx_th_liferay$1staging_defineObjects_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1staging_defineObjects_0.setParent(null);
      int _jspx_eval_liferay$1staging_defineObjects_0 = _jspx_th_liferay$1staging_defineObjects_0.doStartTag();
      if (_jspx_th_liferay$1staging_defineObjects_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1staging_defineObjects_nobody.reuse(_jspx_th_liferay$1staging_defineObjects_0);
        return;
      }
      _jspx_tagPool_liferay$1staging_defineObjects_nobody.reuse(_jspx_th_liferay$1staging_defineObjects_0);
      com.liferay.portal.kernel.model.Group group = null;
      java.lang.Long groupId = null;
      com.liferay.portal.kernel.model.Group liveGroup = null;
      java.lang.Long liveGroupId = null;
      java.lang.Boolean privateLayout = null;
      com.liferay.portal.kernel.model.Group scopeGroup = null;
      java.lang.Long scopeGroupId = null;
      com.liferay.portal.kernel.model.Group stagingGroup = null;
      java.lang.Long stagingGroupId = null;
      group = (com.liferay.portal.kernel.model.Group) _jspx_page_context.findAttribute("group");
      groupId = (java.lang.Long) _jspx_page_context.findAttribute("groupId");
      liveGroup = (com.liferay.portal.kernel.model.Group) _jspx_page_context.findAttribute("liveGroup");
      liveGroupId = (java.lang.Long) _jspx_page_context.findAttribute("liveGroupId");
      privateLayout = (java.lang.Boolean) _jspx_page_context.findAttribute("privateLayout");
      scopeGroup = (com.liferay.portal.kernel.model.Group) _jspx_page_context.findAttribute("scopeGroup");
      scopeGroupId = (java.lang.Long) _jspx_page_context.findAttribute("scopeGroupId");
      stagingGroup = (com.liferay.portal.kernel.model.Group) _jspx_page_context.findAttribute("stagingGroup");
      stagingGroupId = (java.lang.Long) _jspx_page_context.findAttribute("stagingGroupId");
      out.write('\n');
      out.write('\n');
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

group = (Group)renderRequest.getAttribute(WebKeys.GROUP);
layout = (Layout)renderRequest.getAttribute(WebKeys.LAYOUT);
privateLayout = (boolean)renderRequest.getAttribute(WebKeys.PRIVATE_LAYOUT);

LayoutBranchDisplayContext layoutBranchDisplayContext = new LayoutBranchDisplayContext(request);
LayoutSetBranchDisplayContext layoutSetBranchDisplayContext = new LayoutSetBranchDisplayContext(request);

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');

long layoutSetBranchId = ParamUtil.getLong(request, "layoutSetBranchId");

LayoutRevision recentLayoutRevision = null;

long currentLayoutRevisionId = StagingUtil.getRecentLayoutRevisionId(request, layoutSetBranchId, plid);

if (currentLayoutRevisionId > 0) {
	recentLayoutRevision = LayoutRevisionLocalServiceUtil.getLayoutRevision(currentLayoutRevisionId);
}
else {
	recentLayoutRevision = LayoutStagingUtil.getLayoutRevision(layout);

	currentLayoutRevisionId = recentLayoutRevision.getLayoutRevisionId();
}

List<LayoutRevision> rootLayoutRevisions = LayoutRevisionLocalServiceUtil.getChildLayoutRevisions(layoutSetBranchId, LayoutRevisionConstants.DEFAULT_PARENT_LAYOUT_REVISION_ID, plid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, new LayoutRevisionIdComparator(true));

      out.write('\n');
      out.write('\n');
      //  liferay-util:include
      com.liferay.taglib.util.IncludeTag _jspx_th_liferay$1util_include_0 = (com.liferay.taglib.util.IncludeTag) _jspx_tagPool_liferay$1util_include_servletContext_page.get(com.liferay.taglib.util.IncludeTag.class);
      _jspx_th_liferay$1util_include_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1util_include_0.setParent(null);
      _jspx_th_liferay$1util_include_0.setPage("/navigation.jsp");
      _jspx_th_liferay$1util_include_0.setServletContext( application );
      int _jspx_eval_liferay$1util_include_0 = _jspx_th_liferay$1util_include_0.doStartTag();
      if (_jspx_eval_liferay$1util_include_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write('\n');
        out.write('	');
        if (_jspx_meth_liferay$1util_param_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1util_include_0, _jspx_page_context))
          return;
        out.write('\n');
      }
      if (_jspx_th_liferay$1util_include_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1util_include_servletContext_page.reuse(_jspx_th_liferay$1util_include_0);
        return;
      }
      _jspx_tagPool_liferay$1util_include_servletContext_page.reuse(_jspx_th_liferay$1util_include_0);
      out.write("\n\n<div class=\"container-fluid-1280\">\n\t");
      //  c:if
      com.liferay.taglib.core.IfTag _jspx_th_c_if_0 = (com.liferay.taglib.core.IfTag) _jspx_tagPool_c_if_test.get(com.liferay.taglib.core.IfTag.class);
      _jspx_th_c_if_0.setPageContext(_jspx_page_context);
      _jspx_th_c_if_0.setParent(null);
      _jspx_th_c_if_0.setTest( !rootLayoutRevisions.isEmpty() );
      int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
      if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\n\t\t");
        //  c:if
        com.liferay.taglib.core.IfTag _jspx_th_c_if_1 = (com.liferay.taglib.core.IfTag) _jspx_tagPool_c_if_test.get(com.liferay.taglib.core.IfTag.class);
        _jspx_th_c_if_1.setPageContext(_jspx_page_context);
        _jspx_th_c_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
        _jspx_th_c_if_1.setTest( rootLayoutRevisions.size() > 1 );
        int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
        if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          out.write("\n\t\t\t");
          //  aui:select
          com.liferay.taglib.aui.SelectTag _jspx_th_aui_select_0 = (com.liferay.taglib.aui.SelectTag) _jspx_tagPool_aui_select_name_label_inlineLabel_cssClass.get(com.liferay.taglib.aui.SelectTag.class);
          _jspx_th_aui_select_0.setPageContext(_jspx_page_context);
          _jspx_th_aui_select_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
          _jspx_th_aui_select_0.setCssClass("variation-selector");
          _jspx_th_aui_select_0.setInlineLabel("left");
          _jspx_th_aui_select_0.setLabel("");
          _jspx_th_aui_select_0.setName("variationsSelector");
          int _jspx_eval_aui_select_0 = _jspx_th_aui_select_0.doStartTag();
          if (_jspx_eval_aui_select_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_aui_select_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_aui_select_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_aui_select_0.doInitBody();
            }
            do {
              out.write("\n\n\t\t\t\t");

				for (LayoutRevision rootLayoutRevision : rootLayoutRevisions) {
					LayoutBranch layoutBranch = rootLayoutRevision.getLayoutBranch();
				
              out.write("\n\n\t\t\t\t\t");
              //  aui:option
              com.liferay.taglib.aui.OptionTag _jspx_th_aui_option_0 = (com.liferay.taglib.aui.OptionTag) _jspx_tagPool_aui_option_value_selected_localizeLabel_label_nobody.get(com.liferay.taglib.aui.OptionTag.class);
              _jspx_th_aui_option_0.setPageContext(_jspx_page_context);
              _jspx_th_aui_option_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_select_0);
              _jspx_th_aui_option_0.setLabel( HtmlUtil.escape(layoutBranchDisplayContext.getLayoutBranchDisplayName(layoutBranch)) );
              _jspx_th_aui_option_0.setLocalizeLabel( false );
              _jspx_th_aui_option_0.setSelected( recentLayoutRevision.getLayoutBranchId() == rootLayoutRevision.getLayoutBranchId() );
              _jspx_th_aui_option_0.setValue( rootLayoutRevision.getLayoutRevisionId() );
              int _jspx_eval_aui_option_0 = _jspx_th_aui_option_0.doStartTag();
              if (_jspx_th_aui_option_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_aui_option_value_selected_localizeLabel_label_nobody.reuse(_jspx_th_aui_option_0);
                return;
              }
              _jspx_tagPool_aui_option_value_selected_localizeLabel_label_nobody.reuse(_jspx_th_aui_option_0);
              out.write("\n\n\t\t\t\t");

				}
				
              out.write("\n\n\t\t\t\t");
              if (_jspx_meth_aui_option_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_select_0, _jspx_page_context))
                return;
              out.write("\n\t\t\t");
              int evalDoAfterBody = _jspx_th_aui_select_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_aui_select_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_aui_select_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_aui_select_name_label_inlineLabel_cssClass.reuse(_jspx_th_aui_select_0);
            return;
          }
          _jspx_tagPool_aui_select_name_label_inlineLabel_cssClass.reuse(_jspx_th_aui_select_0);
          out.write("\n\t\t");
        }
        if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
          return;
        }
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
        out.write("\n\n\t\t<div class=\"layout-revision-container\" id=\"");
        if (_jspx_meth_portlet_namespace_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return;
        out.write("layoutRevisionsContainer\">\n\n\t\t\t");

			for (LayoutRevision rootLayoutRevision : rootLayoutRevisions) {
			
        out.write("\n\n\t\t\t\t<div class=\"layout-variation-container ");
        out.print( (recentLayoutRevision.getLayoutBranchId() == rootLayoutRevision.getLayoutBranchId()) ? StringPool.BLANK : "hide" );
        out.write("\" id=\"");
        if (_jspx_meth_portlet_namespace_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return;
        out.print( rootLayoutRevision.getLayoutRevisionId() );
        out.write("\">\n\t\t\t\t\t");
        //  c:if
        com.liferay.taglib.core.IfTag _jspx_th_c_if_2 = (com.liferay.taglib.core.IfTag) _jspx_tagPool_c_if_test.get(com.liferay.taglib.core.IfTag.class);
        _jspx_th_c_if_2.setPageContext(_jspx_page_context);
        _jspx_th_c_if_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
        _jspx_th_c_if_2.setTest( rootLayoutRevisions.size() > 1 );
        int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
        if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          out.write("\n\n\t\t\t\t\t\t");

						LayoutBranch layoutBranch = rootLayoutRevision.getLayoutBranch();
						
          out.write("\n\n\t\t\t\t\t\t<h3 class=\"layout-variation-name\">");
          //  liferay-ui:message
          com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_0 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_translateArguments_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
          _jspx_th_liferay$1ui_message_0.setPageContext(_jspx_page_context);
          _jspx_th_liferay$1ui_message_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_2);
          _jspx_th_liferay$1ui_message_0.setKey( HtmlUtil.escape(layoutBranchDisplayContext.getLayoutBranchDisplayName(layoutBranch)) );
          _jspx_th_liferay$1ui_message_0.setTranslateArguments( false );
          int _jspx_eval_liferay$1ui_message_0 = _jspx_th_liferay$1ui_message_0.doStartTag();
          if (_jspx_th_liferay$1ui_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_liferay$1ui_message_translateArguments_key_nobody.reuse(_jspx_th_liferay$1ui_message_0);
            return;
          }
          _jspx_tagPool_liferay$1ui_message_translateArguments_key_nobody.reuse(_jspx_th_liferay$1ui_message_0);
          out.write("</h3>\n\t\t\t\t\t");
        }
        if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
          return;
        }
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
        out.write("\n\n\t\t\t\t\t");
        //  liferay-ui:search-container
        com.liferay.taglib.ui.SearchContainerTag _jspx_th_liferay$1ui_search$1container_0 = (com.liferay.taglib.ui.SearchContainerTag) _jspx_tagPool_liferay$1ui_search$1container_total.get(com.liferay.taglib.ui.SearchContainerTag.class);
        _jspx_th_liferay$1ui_search$1container_0.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_search$1container_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
        _jspx_th_liferay$1ui_search$1container_0.setTotal( LayoutRevisionLocalServiceUtil.getLayoutRevisionsCount(rootLayoutRevision.getLayoutSetBranchId(), rootLayoutRevision.getLayoutBranchId(), rootLayoutRevision.getPlid()) );
        int _jspx_eval_liferay$1ui_search$1container_0 = _jspx_th_liferay$1ui_search$1container_0.doStartTag();
        if (_jspx_eval_liferay$1ui_search$1container_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          java.lang.Integer total = null;
          com.liferay.portal.kernel.dao.search.SearchContainer searchContainer = null;
          total = (java.lang.Integer) _jspx_page_context.findAttribute("total");
          searchContainer = (com.liferay.portal.kernel.dao.search.SearchContainer) _jspx_page_context.findAttribute("searchContainer");
          out.write("\n\t\t\t\t\t\t");
          //  liferay-ui:search-container-results
          java.util.List results = null;
          java.lang.Integer deprecatedTotal = null;
          com.liferay.taglib.ui.SearchContainerResultsTag _jspx_th_liferay$1ui_search$1container$1results_0 = (com.liferay.taglib.ui.SearchContainerResultsTag) _jspx_tagPool_liferay$1ui_search$1container$1results_results_nobody.get(com.liferay.taglib.ui.SearchContainerResultsTag.class);
          _jspx_th_liferay$1ui_search$1container$1results_0.setPageContext(_jspx_page_context);
          _jspx_th_liferay$1ui_search$1container$1results_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container_0);
          _jspx_th_liferay$1ui_search$1container$1results_0.setResults( LayoutRevisionLocalServiceUtil.getLayoutRevisions(rootLayoutRevision.getLayoutSetBranchId(), rootLayoutRevision.getLayoutBranchId(), rootLayoutRevision.getPlid(), QueryUtil.ALL_POS, QueryUtil.ALL_POS, new LayoutRevisionIdComparator(false)) );
          int _jspx_eval_liferay$1ui_search$1container$1results_0 = _jspx_th_liferay$1ui_search$1container$1results_0.doStartTag();
          results = (java.util.List) _jspx_page_context.findAttribute("results");
          deprecatedTotal = (java.lang.Integer) _jspx_page_context.findAttribute("deprecatedTotal");
          if (_jspx_th_liferay$1ui_search$1container$1results_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_liferay$1ui_search$1container$1results_results_nobody.reuse(_jspx_th_liferay$1ui_search$1container$1results_0);
            return;
          }
          results = (java.util.List) _jspx_page_context.findAttribute("results");
          deprecatedTotal = (java.lang.Integer) _jspx_page_context.findAttribute("deprecatedTotal");
          _jspx_tagPool_liferay$1ui_search$1container$1results_results_nobody.reuse(_jspx_th_liferay$1ui_search$1container$1results_0);
          out.write("\n\n\t\t\t\t\t\t");
          //  liferay-ui:search-container-row
          com.liferay.taglib.ui.SearchContainerRowTag _jspx_th_liferay$1ui_search$1container$1row_0 = (com.liferay.taglib.ui.SearchContainerRowTag) _jspx_tagPool_liferay$1ui_search$1container$1row_modelVar_keyProperty_escapedModel_className.get(com.liferay.taglib.ui.SearchContainerRowTag.class);
          _jspx_th_liferay$1ui_search$1container$1row_0.setPageContext(_jspx_page_context);
          _jspx_th_liferay$1ui_search$1container$1row_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container_0);
          _jspx_th_liferay$1ui_search$1container$1row_0.setClassName("com.liferay.portal.kernel.model.LayoutRevision");
          _jspx_th_liferay$1ui_search$1container$1row_0.setEscapedModel( true );
          _jspx_th_liferay$1ui_search$1container$1row_0.setKeyProperty("layoutRevisionId");
          _jspx_th_liferay$1ui_search$1container$1row_0.setModelVar("curLayoutRevision");
          int _jspx_eval_liferay$1ui_search$1container$1row_0 = _jspx_th_liferay$1ui_search$1container$1row_0.doStartTag();
          if (_jspx_eval_liferay$1ui_search$1container$1row_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            java.lang.Integer index = null;
            com.liferay.portal.kernel.model.LayoutRevision curLayoutRevision = null;
            com.liferay.portal.kernel.dao.search.ResultRow row = null;
            if (_jspx_eval_liferay$1ui_search$1container$1row_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_liferay$1ui_search$1container$1row_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_liferay$1ui_search$1container$1row_0.doInitBody();
            }
            index = (java.lang.Integer) _jspx_page_context.findAttribute("index");
            curLayoutRevision = (com.liferay.portal.kernel.model.LayoutRevision) _jspx_page_context.findAttribute("curLayoutRevision");
            row = (com.liferay.portal.kernel.dao.search.ResultRow) _jspx_page_context.findAttribute("row");
            do {
              out.write("\n\t\t\t\t\t\t\t");
              //  liferay-ui:search-container-column-date
              com.liferay.taglib.ui.SearchContainerColumnDateTag _jspx_th_liferay$1ui_search$1container$1column$1date_0 = (com.liferay.taglib.ui.SearchContainerColumnDateTag) _jspx_tagPool_liferay$1ui_search$1container$1column$1date_value_name_nobody.get(com.liferay.taglib.ui.SearchContainerColumnDateTag.class);
              _jspx_th_liferay$1ui_search$1container$1column$1date_0.setPageContext(_jspx_page_context);
              _jspx_th_liferay$1ui_search$1container$1column$1date_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container$1row_0);
              _jspx_th_liferay$1ui_search$1container$1column$1date_0.setName("date");
              _jspx_th_liferay$1ui_search$1container$1column$1date_0.setValue( curLayoutRevision.getCreateDate() );
              int _jspx_eval_liferay$1ui_search$1container$1column$1date_0 = _jspx_th_liferay$1ui_search$1container$1column$1date_0.doStartTag();
              if (_jspx_th_liferay$1ui_search$1container$1column$1date_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_liferay$1ui_search$1container$1column$1date_value_name_nobody.reuse(_jspx_th_liferay$1ui_search$1container$1column$1date_0);
                return;
              }
              _jspx_tagPool_liferay$1ui_search$1container$1column$1date_value_name_nobody.reuse(_jspx_th_liferay$1ui_search$1container$1column$1date_0);
              out.write("\n\n\t\t\t\t\t\t\t");
              //  liferay-ui:search-container-column-text
              com.liferay.taglib.ui.SearchContainerColumnTextTag _jspx_th_liferay$1ui_search$1container$1column$1text_0 = (com.liferay.taglib.ui.SearchContainerColumnTextTag) _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name.get(com.liferay.taglib.ui.SearchContainerColumnTextTag.class);
              _jspx_th_liferay$1ui_search$1container$1column$1text_0.setPageContext(_jspx_page_context);
              _jspx_th_liferay$1ui_search$1container$1column$1text_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container$1row_0);
              _jspx_th_liferay$1ui_search$1container$1column$1text_0.setName("status");
              int _jspx_eval_liferay$1ui_search$1container$1column$1text_0 = _jspx_th_liferay$1ui_search$1container$1column$1text_0.doStartTag();
              if (_jspx_eval_liferay$1ui_search$1container$1column$1text_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_liferay$1ui_search$1container$1column$1text_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_liferay$1ui_search$1container$1column$1text_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_liferay$1ui_search$1container$1column$1text_0.doInitBody();
                }
                do {
                  out.write("\n\t\t\t\t\t\t\t\t");
                  //  aui:model-context
                  com.liferay.taglib.aui.ModelContextTag _jspx_th_aui_model$1context_0 = (com.liferay.taglib.aui.ModelContextTag) _jspx_tagPool_aui_model$1context_model_bean_nobody.get(com.liferay.taglib.aui.ModelContextTag.class);
                  _jspx_th_aui_model$1context_0.setPageContext(_jspx_page_context);
                  _jspx_th_aui_model$1context_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container$1column$1text_0);
                  _jspx_th_aui_model$1context_0.setBean( curLayoutRevision );
                  _jspx_th_aui_model$1context_0.setModel( LayoutRevision.class );
                  int _jspx_eval_aui_model$1context_0 = _jspx_th_aui_model$1context_0.doStartTag();
                  if (_jspx_th_aui_model$1context_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_aui_model$1context_model_bean_nobody.reuse(_jspx_th_aui_model$1context_0);
                    return;
                  }
                  _jspx_tagPool_aui_model$1context_model_bean_nobody.reuse(_jspx_th_aui_model$1context_0);
                  out.write("\n\n\t\t\t\t\t\t\t\t");

								int status = curLayoutRevision.getStatus();
								
                  out.write("\n\n\t\t\t\t\t\t\t\t");
                  //  c:choose
                  com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_0 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
                  _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
                  _jspx_th_c_choose_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container$1column$1text_0);
                  int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
                  if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    out.write("\n\t\t\t\t\t\t\t\t\t");
                    //  c:when
                    com.liferay.taglib.core.WhenTag _jspx_th_c_when_0 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
                    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
                    _jspx_th_c_when_0.setTest( curLayoutRevision.isHead() );
                    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
                    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                      out.write("\n\t\t\t\t\t\t\t\t\t\t");
                      //  aui:workflow-status
                      com.liferay.taglib.aui.WorkflowStatusTag _jspx_th_aui_workflow$1status_0 = (com.liferay.taglib.aui.WorkflowStatusTag) _jspx_tagPool_aui_workflow$1status_statusMessage_status_showLabel_showIcon_nobody.get(com.liferay.taglib.aui.WorkflowStatusTag.class);
                      _jspx_th_aui_workflow$1status_0.setPageContext(_jspx_page_context);
                      _jspx_th_aui_workflow$1status_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
                      _jspx_th_aui_workflow$1status_0.setShowIcon( false );
                      _jspx_th_aui_workflow$1status_0.setShowLabel( false );
                      _jspx_th_aui_workflow$1status_0.setStatus( status );
                      _jspx_th_aui_workflow$1status_0.setStatusMessage("ready-for-publication");
                      int _jspx_eval_aui_workflow$1status_0 = _jspx_th_aui_workflow$1status_0.doStartTag();
                      if (_jspx_th_aui_workflow$1status_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_aui_workflow$1status_statusMessage_status_showLabel_showIcon_nobody.reuse(_jspx_th_aui_workflow$1status_0);
                        return;
                      }
                      _jspx_tagPool_aui_workflow$1status_statusMessage_status_showLabel_showIcon_nobody.reuse(_jspx_th_aui_workflow$1status_0);
                      out.write("\n\t\t\t\t\t\t\t\t\t");
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
                      out.write("\n\t\t\t\t\t\t\t\t\t\t");
                      //  aui:workflow-status
                      com.liferay.taglib.aui.WorkflowStatusTag _jspx_th_aui_workflow$1status_1 = (com.liferay.taglib.aui.WorkflowStatusTag) _jspx_tagPool_aui_workflow$1status_status_showLabel_showIcon_nobody.get(com.liferay.taglib.aui.WorkflowStatusTag.class);
                      _jspx_th_aui_workflow$1status_1.setPageContext(_jspx_page_context);
                      _jspx_th_aui_workflow$1status_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_0);
                      _jspx_th_aui_workflow$1status_1.setShowIcon( false );
                      _jspx_th_aui_workflow$1status_1.setShowLabel( false );
                      _jspx_th_aui_workflow$1status_1.setStatus( status );
                      int _jspx_eval_aui_workflow$1status_1 = _jspx_th_aui_workflow$1status_1.doStartTag();
                      if (_jspx_th_aui_workflow$1status_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_aui_workflow$1status_status_showLabel_showIcon_nobody.reuse(_jspx_th_aui_workflow$1status_1);
                        return;
                      }
                      _jspx_tagPool_aui_workflow$1status_status_showLabel_showIcon_nobody.reuse(_jspx_th_aui_workflow$1status_1);
                      out.write("\n\t\t\t\t\t\t\t\t\t");
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
                  out.write("\n\t\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_liferay$1ui_search$1container$1column$1text_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_liferay$1ui_search$1container$1column$1text_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_liferay$1ui_search$1container$1column$1text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name.reuse(_jspx_th_liferay$1ui_search$1container$1column$1text_0);
                return;
              }
              _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name.reuse(_jspx_th_liferay$1ui_search$1container$1column$1text_0);
              out.write("\n\n\t\t\t\t\t\t\t");
              //  liferay-ui:search-container-column-text
              com.liferay.taglib.ui.SearchContainerColumnTextTag _jspx_th_liferay$1ui_search$1container$1column$1text_1 = (com.liferay.taglib.ui.SearchContainerColumnTextTag) _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name.get(com.liferay.taglib.ui.SearchContainerColumnTextTag.class);
              _jspx_th_liferay$1ui_search$1container$1column$1text_1.setPageContext(_jspx_page_context);
              _jspx_th_liferay$1ui_search$1container$1column$1text_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container$1row_0);
              _jspx_th_liferay$1ui_search$1container$1column$1text_1.setName("version");
              int _jspx_eval_liferay$1ui_search$1container$1column$1text_1 = _jspx_th_liferay$1ui_search$1container$1column$1text_1.doStartTag();
              if (_jspx_eval_liferay$1ui_search$1container$1column$1text_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_liferay$1ui_search$1container$1column$1text_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_liferay$1ui_search$1container$1column$1text_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_liferay$1ui_search$1container$1column$1text_1.doInitBody();
                }
                do {
                  out.write("\n\t\t\t\t\t\t\t\t");
                  //  c:choose
                  com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_1 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
                  _jspx_th_c_choose_1.setPageContext(_jspx_page_context);
                  _jspx_th_c_choose_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container$1column$1text_1);
                  int _jspx_eval_c_choose_1 = _jspx_th_c_choose_1.doStartTag();
                  if (_jspx_eval_c_choose_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    out.write("\n\t\t\t\t\t\t\t\t\t");
                    //  c:when
                    com.liferay.taglib.core.WhenTag _jspx_th_c_when_1 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                    _jspx_th_c_when_1.setPageContext(_jspx_page_context);
                    _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
                    _jspx_th_c_when_1.setTest( curLayoutRevision.getLayoutRevisionId() == currentLayoutRevisionId );
                    int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
                    if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                      out.write("\n\t\t\t\t\t\t\t\t\t\t<span class=\"layout-revision-current\">");
                      out.print( curLayoutRevision.getLayoutRevisionId() );
                      out.write("</span>\n\t\t\t\t\t\t\t\t\t\t<span class=\"current-version\">");
                      if (_jspx_meth_liferay$1ui_message_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_1, _jspx_page_context))
                        return;
                      out.write("</span>\n\t\t\t\t\t\t\t\t\t");
                    }
                    if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
                      return;
                    }
                    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
                    out.write("\n\t\t\t\t\t\t\t\t\t");
                    //  c:otherwise
                    com.liferay.taglib.core.OtherwiseTag _jspx_th_c_otherwise_1 = (com.liferay.taglib.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(com.liferay.taglib.core.OtherwiseTag.class);
                    _jspx_th_c_otherwise_1.setPageContext(_jspx_page_context);
                    _jspx_th_c_otherwise_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
                    int _jspx_eval_c_otherwise_1 = _jspx_th_c_otherwise_1.doStartTag();
                    if (_jspx_eval_c_otherwise_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                      out.write("\n\t\t\t\t\t\t\t\t\t\t<a class=\"layout-revision selection-handle\" data-layoutRevisionId=\"");
                      out.print( curLayoutRevision.getLayoutRevisionId() );
                      out.write("\" data-layoutSetBranchId=\"");
                      out.print( curLayoutRevision.getLayoutSetBranchId() );
                      out.write("\" href=\"javascript:;\" onclick=\"");
                      out.print( renderResponse.getNamespace() + "selectRevision(" + curLayoutRevision.getLayoutRevisionId() + ", " + curLayoutRevision.getLayoutSetBranchId() + ");" );
                      out.write("\" title=\"");
                      if (_jspx_meth_liferay$1ui_message_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_otherwise_1, _jspx_page_context))
                        return;
                      out.write("\">\n\t\t\t\t\t\t\t\t\t\t\t");
                      out.print( curLayoutRevision.getLayoutRevisionId() );
                      out.write("\n\t\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t\t");
                    }
                    if (_jspx_th_c_otherwise_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_1);
                      return;
                    }
                    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_1);
                    out.write("\n\t\t\t\t\t\t\t\t");
                  }
                  if (_jspx_th_c_choose_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
                    return;
                  }
                  _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
                  out.write("\n\t\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_liferay$1ui_search$1container$1column$1text_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_liferay$1ui_search$1container$1column$1text_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_liferay$1ui_search$1container$1column$1text_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name.reuse(_jspx_th_liferay$1ui_search$1container$1column$1text_1);
                return;
              }
              _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name.reuse(_jspx_th_liferay$1ui_search$1container$1column$1text_1);
              out.write("\n\n\t\t\t\t\t\t\t");
              //  liferay-ui:search-container-column-text
              com.liferay.taglib.ui.SearchContainerColumnTextTag _jspx_th_liferay$1ui_search$1container$1column$1text_2 = (com.liferay.taglib.ui.SearchContainerColumnTextTag) _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name.get(com.liferay.taglib.ui.SearchContainerColumnTextTag.class);
              _jspx_th_liferay$1ui_search$1container$1column$1text_2.setPageContext(_jspx_page_context);
              _jspx_th_liferay$1ui_search$1container$1column$1text_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container$1row_0);
              _jspx_th_liferay$1ui_search$1container$1column$1text_2.setName("user");
              int _jspx_eval_liferay$1ui_search$1container$1column$1text_2 = _jspx_th_liferay$1ui_search$1container$1column$1text_2.doStartTag();
              if (_jspx_eval_liferay$1ui_search$1container$1column$1text_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_liferay$1ui_search$1container$1column$1text_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_liferay$1ui_search$1container$1column$1text_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_liferay$1ui_search$1container$1column$1text_2.doInitBody();
                }
                do {
                  out.write("\n\n\t\t\t\t\t\t\t\t");

								User curUser = UserLocalServiceUtil.fetchUserById(curLayoutRevision.getUserId());
								
                  out.write("\n\n\t\t\t\t\t\t\t\t");
                  //  c:choose
                  com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_2 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
                  _jspx_th_c_choose_2.setPageContext(_jspx_page_context);
                  _jspx_th_c_choose_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container$1column$1text_2);
                  int _jspx_eval_c_choose_2 = _jspx_th_c_choose_2.doStartTag();
                  if (_jspx_eval_c_choose_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    out.write("\n\t\t\t\t\t\t\t\t\t");
                    //  c:when
                    com.liferay.taglib.core.WhenTag _jspx_th_c_when_2 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                    _jspx_th_c_when_2.setPageContext(_jspx_page_context);
                    _jspx_th_c_when_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_2);
                    _jspx_th_c_when_2.setTest( (curUser != null) && curUser.isActive() );
                    int _jspx_eval_c_when_2 = _jspx_th_c_when_2.doStartTag();
                    if (_jspx_eval_c_when_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                      out.write("\n\t\t\t\t\t\t\t\t\t\t<a class=\"user-handle\" href=\"");
                      out.print( curUser.getDisplayURL(themeDisplay) );
                      out.write("\">\n\t\t\t\t\t\t\t\t\t\t\t");
                      out.print( HtmlUtil.escape(curUser.getFullName()) );
                      out.write("\n\t\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t\t");
                    }
                    if (_jspx_th_c_when_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_2);
                      return;
                    }
                    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_2);
                    out.write("\n\t\t\t\t\t\t\t\t\t");
                    //  c:otherwise
                    com.liferay.taglib.core.OtherwiseTag _jspx_th_c_otherwise_2 = (com.liferay.taglib.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(com.liferay.taglib.core.OtherwiseTag.class);
                    _jspx_th_c_otherwise_2.setPageContext(_jspx_page_context);
                    _jspx_th_c_otherwise_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_2);
                    int _jspx_eval_c_otherwise_2 = _jspx_th_c_otherwise_2.doStartTag();
                    if (_jspx_eval_c_otherwise_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                      out.write("\n\t\t\t\t\t\t\t\t\t\t");
                      out.print( curLayoutRevision.getUserName() );
                      out.write("\n\t\t\t\t\t\t\t\t\t");
                    }
                    if (_jspx_th_c_otherwise_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_2);
                      return;
                    }
                    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_2);
                    out.write("\n\t\t\t\t\t\t\t\t");
                  }
                  if (_jspx_th_c_choose_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_2);
                    return;
                  }
                  _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_2);
                  out.write("\n\t\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_liferay$1ui_search$1container$1column$1text_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_liferay$1ui_search$1container$1column$1text_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_liferay$1ui_search$1container$1column$1text_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name.reuse(_jspx_th_liferay$1ui_search$1container$1column$1text_2);
                return;
              }
              _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name.reuse(_jspx_th_liferay$1ui_search$1container$1column$1text_2);
              out.write("\n\n\t\t\t\t\t\t\t");
              if (_jspx_meth_liferay$1ui_search$1container$1column$1jsp_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1ui_search$1container$1row_0, _jspx_page_context))
                return;
              out.write("\n\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_liferay$1ui_search$1container$1row_0.doAfterBody();
              index = (java.lang.Integer) _jspx_page_context.findAttribute("index");
              curLayoutRevision = (com.liferay.portal.kernel.model.LayoutRevision) _jspx_page_context.findAttribute("curLayoutRevision");
              row = (com.liferay.portal.kernel.dao.search.ResultRow) _jspx_page_context.findAttribute("row");
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_liferay$1ui_search$1container$1row_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_liferay$1ui_search$1container$1row_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_liferay$1ui_search$1container$1row_modelVar_keyProperty_escapedModel_className.reuse(_jspx_th_liferay$1ui_search$1container$1row_0);
            return;
          }
          _jspx_tagPool_liferay$1ui_search$1container$1row_modelVar_keyProperty_escapedModel_className.reuse(_jspx_th_liferay$1ui_search$1container$1row_0);
          out.write("\n\n\t\t\t\t\t\t");
          //  liferay-ui:search-iterator
          com.liferay.taglib.ui.SearchIteratorTag _jspx_th_liferay$1ui_search$1iterator_0 = (com.liferay.taglib.ui.SearchIteratorTag) _jspx_tagPool_liferay$1ui_search$1iterator_searchContainer_paginate_markupView_nobody.get(com.liferay.taglib.ui.SearchIteratorTag.class);
          _jspx_th_liferay$1ui_search$1iterator_0.setPageContext(_jspx_page_context);
          _jspx_th_liferay$1ui_search$1iterator_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container_0);
          _jspx_th_liferay$1ui_search$1iterator_0.setMarkupView("lexicon");
          _jspx_th_liferay$1ui_search$1iterator_0.setPaginate( false );
          _jspx_th_liferay$1ui_search$1iterator_0.setSearchContainer( searchContainer );
          int _jspx_eval_liferay$1ui_search$1iterator_0 = _jspx_th_liferay$1ui_search$1iterator_0.doStartTag();
          if (_jspx_th_liferay$1ui_search$1iterator_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_liferay$1ui_search$1iterator_searchContainer_paginate_markupView_nobody.reuse(_jspx_th_liferay$1ui_search$1iterator_0);
            return;
          }
          _jspx_tagPool_liferay$1ui_search$1iterator_searchContainer_paginate_markupView_nobody.reuse(_jspx_th_liferay$1ui_search$1iterator_0);
          out.write("\n\t\t\t\t\t");
        }
        if (_jspx_th_liferay$1ui_search$1container_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_search$1container_total.reuse(_jspx_th_liferay$1ui_search$1container_0);
          return;
        }
        _jspx_tagPool_liferay$1ui_search$1container_total.reuse(_jspx_th_liferay$1ui_search$1container_0);
        out.write("\n\t\t\t\t</div>\n\n\t\t\t");

			}
			
        out.write("\n\n\t\t</div>\n\t");
      }
      if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      out.write("\n</div>\n\n");
      if (_jspx_meth_aui_script_0(_jspx_page_context))
        return;
      out.write('\n');
      out.write('\n');
      //  aui:script
      com.liferay.taglib.aui.ScriptTag _jspx_th_aui_script_1 = (com.liferay.taglib.aui.ScriptTag) _jspx_tagPool_aui_script_sandbox.get(com.liferay.taglib.aui.ScriptTag.class);
      _jspx_th_aui_script_1.setPageContext(_jspx_page_context);
      _jspx_th_aui_script_1.setParent(null);
      _jspx_th_aui_script_1.setSandbox( true );
      int _jspx_eval_aui_script_1 = _jspx_th_aui_script_1.doStartTag();
      if (_jspx_eval_aui_script_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_aui_script_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_aui_script_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_aui_script_1.doInitBody();
        }
        do {
          out.write("\n\tvar variationsSelector = $('#");
          if (_jspx_meth_portlet_namespace_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_1, _jspx_page_context))
            return;
          out.write("variationsSelector');\n\n\tvar layoutBranchesContainer = $('.layout-variation-container');\n\n\tvariationsSelector.on(\n\t\t'change',\n\t\tfunction() {\n\t\t\tvar variation = variationsSelector.val();\n\n\t\t\tif (variation == 'all') {\n\t\t\t\tlayoutBranchesContainer.removeClass('hide');\n\t\t\t}\n\t\t\telse {\n\t\t\t\tlayoutBranchesContainer.addClass('hide');\n\n\t\t\t\t$('#");
          if (_jspx_meth_portlet_namespace_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_1, _jspx_page_context))
            return;
          out.write("' + variation).removeClass('hide');\n\t\t\t}\n\t\t}\n\t);\n");
          int evalDoAfterBody = _jspx_th_aui_script_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_aui_script_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
      }
      if (_jspx_th_aui_script_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_script_sandbox.reuse(_jspx_th_aui_script_1);
        return;
      }
      _jspx_tagPool_aui_script_sandbox.reuse(_jspx_th_aui_script_1);
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

  private boolean _jspx_meth_liferay$1util_param_0(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1util_include_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-util:param
    com.liferay.taglib.util.ParamTag _jspx_th_liferay$1util_param_0 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_liferay$1util_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_liferay$1util_param_0.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1util_param_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1util_include_0);
    _jspx_th_liferay$1util_param_0.setName("navigationName");
    _jspx_th_liferay$1util_param_0.setValue("history");
    int _jspx_eval_liferay$1util_param_0 = _jspx_th_liferay$1util_param_0.doStartTag();
    if (_jspx_th_liferay$1util_param_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1util_param_value_name_nobody.reuse(_jspx_th_liferay$1util_param_0);
      return true;
    }
    _jspx_tagPool_liferay$1util_param_value_name_nobody.reuse(_jspx_th_liferay$1util_param_0);
    return false;
  }

  private boolean _jspx_meth_aui_option_1(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_select_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:option
    com.liferay.taglib.aui.OptionTag _jspx_th_aui_option_1 = (com.liferay.taglib.aui.OptionTag) _jspx_tagPool_aui_option_value_label_nobody.get(com.liferay.taglib.aui.OptionTag.class);
    _jspx_th_aui_option_1.setPageContext(_jspx_page_context);
    _jspx_th_aui_option_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_select_0);
    _jspx_th_aui_option_1.setLabel(new String("all-page-variations"));
    _jspx_th_aui_option_1.setValue(new String("all"));
    int _jspx_eval_aui_option_1 = _jspx_th_aui_option_1.doStartTag();
    if (_jspx_th_aui_option_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_option_value_label_nobody.reuse(_jspx_th_aui_option_1);
      return true;
    }
    _jspx_tagPool_aui_option_value_label_nobody.reuse(_jspx_th_aui_option_1);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_0 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_0.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    int _jspx_eval_portlet_namespace_0 = _jspx_th_portlet_namespace_0.doStartTag();
    if (_jspx_th_portlet_namespace_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_0);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_0);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_1 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_1.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    int _jspx_eval_portlet_namespace_1 = _jspx_th_portlet_namespace_1.doStartTag();
    if (_jspx_th_portlet_namespace_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_1);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_1);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_message_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_1 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_1.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_1);
    _jspx_th_liferay$1ui_message_1.setKey("current-version");
    int _jspx_eval_liferay$1ui_message_1 = _jspx_th_liferay$1ui_message_1.doStartTag();
    if (_jspx_th_liferay$1ui_message_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_1);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_1);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_message_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_otherwise_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_2 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_2.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_1);
    _jspx_th_liferay$1ui_message_2.setKey("go-to-this-version");
    int _jspx_eval_liferay$1ui_message_2 = _jspx_th_liferay$1ui_message_2.doStartTag();
    if (_jspx_th_liferay$1ui_message_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_2);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_2);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_search$1container$1column$1jsp_0(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1ui_search$1container$1row_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:search-container-column-jsp
    com.liferay.taglib.ui.SearchContainerColumnJSPTag _jspx_th_liferay$1ui_search$1container$1column$1jsp_0 = (com.liferay.taglib.ui.SearchContainerColumnJSPTag) _jspx_tagPool_liferay$1ui_search$1container$1column$1jsp_path_cssClass_align_nobody.get(com.liferay.taglib.ui.SearchContainerColumnJSPTag.class);
    _jspx_th_liferay$1ui_search$1container$1column$1jsp_0.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_search$1container$1column$1jsp_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container$1row_0);
    _jspx_th_liferay$1ui_search$1container$1column$1jsp_0.setAlign("right");
    _jspx_th_liferay$1ui_search$1container$1column$1jsp_0.setCssClass("entry-action");
    _jspx_th_liferay$1ui_search$1container$1column$1jsp_0.setPath("/layout_revision_action.jsp");
    int _jspx_eval_liferay$1ui_search$1container$1column$1jsp_0 = _jspx_th_liferay$1ui_search$1container$1column$1jsp_0.doStartTag();
    if (_jspx_th_liferay$1ui_search$1container$1column$1jsp_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_search$1container$1column$1jsp_path_cssClass_align_nobody.reuse(_jspx_th_liferay$1ui_search$1container$1column$1jsp_0);
      return true;
    }
    _jspx_tagPool_liferay$1ui_search$1container$1column$1jsp_path_cssClass_align_nobody.reuse(_jspx_th_liferay$1ui_search$1container$1column$1jsp_0);
    return false;
  }

  private boolean _jspx_meth_aui_script_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:script
    com.liferay.taglib.aui.ScriptTag _jspx_th_aui_script_0 = (com.liferay.taglib.aui.ScriptTag) _jspx_tagPool_aui_script.get(com.liferay.taglib.aui.ScriptTag.class);
    _jspx_th_aui_script_0.setPageContext(_jspx_page_context);
    _jspx_th_aui_script_0.setParent(null);
    int _jspx_eval_aui_script_0 = _jspx_th_aui_script_0.doStartTag();
    if (_jspx_eval_aui_script_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_aui_script_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_aui_script_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_aui_script_0.doInitBody();
      }
      do {
        out.write("\n\tfunction ");
        if (_jspx_meth_portlet_namespace_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_0, _jspx_page_context))
          return true;
        out.write("selectRevision(layoutRevisionId, layoutSetBranchId) {\n\t\tAUI.$.ajax(\n\t\t\tthemeDisplay.getPathMain() + '/portal/update_layout',\n\t\t\t{\n\t\t\t\tdata: {\n\t\t\t\t\tcmd: 'select_layout_revision',\n\t\t\t\t\tdoAsUserId: themeDisplay.getDoAsUserIdEncoded(),\n\t\t\t\t\tlayoutRevisionId: layoutRevisionId,\n\t\t\t\t\tlayoutSetBranchId: layoutSetBranchId,\n\t\t\t\t\tp_auth: Liferay.authToken,\n\t\t\t\t\tp_l_id: themeDisplay.getPlid(),\n\t\t\t\t\tp_v_l_s_g_id: themeDisplay.getSiteGroupId()\n\t\t\t\t},\n\t\t\t\tsuccess: function(event, id, obj) {\n\t\t\t\t\tvar parentWindow = Liferay.Util.getOpener();\n\n\t\t\t\t\tparentWindow.location.reload();\n\t\t\t\t}\n\t\t\t}\n\t\t);\n\t}\n");
        int evalDoAfterBody = _jspx_th_aui_script_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_aui_script_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_aui_script_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_script.reuse(_jspx_th_aui_script_0);
      return true;
    }
    _jspx_tagPool_aui_script.reuse(_jspx_th_aui_script_0);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_2(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_script_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_2 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_2.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_0);
    int _jspx_eval_portlet_namespace_2 = _jspx_th_portlet_namespace_2.doStartTag();
    if (_jspx_th_portlet_namespace_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_2);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_2);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_3(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_script_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_3 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_3.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_1);
    int _jspx_eval_portlet_namespace_3 = _jspx_th_portlet_namespace_3.doStartTag();
    if (_jspx_th_portlet_namespace_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_3);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_3);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_4(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_script_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_4 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_4.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_1);
    int _jspx_eval_portlet_namespace_4 = _jspx_th_portlet_namespace_4.doStartTag();
    if (_jspx_th_portlet_namespace_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_4);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_4);
    return false;
  }
}
