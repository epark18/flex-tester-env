package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFileVersion;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.petra.log4j.Levels;
import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.convert.ConvertProcess;
import com.liferay.portal.convert.ConvertProcessUtil;
import com.liferay.portal.convert.documentlibrary.FileSystemStoreRootDirException;
import com.liferay.portal.kernel.configuration.Filter;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.image.ImageMagickUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.*;
import com.liferay.portal.kernel.model.impl.*;
import com.liferay.portal.kernel.patcher.PatcherUtil;
import com.liferay.portal.kernel.scripting.ScriptingUtil;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OSDetector;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.ReleaseInfo;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TextFormatter;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.xuggler.XugglerInstallException;
import com.liferay.portal.kernel.xuggler.XugglerUtil;
import com.liferay.portal.model.impl.*;
import com.liferay.portal.util.PrefsPropsUtil;
import com.liferay.portal.util.PropsUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.util.ShutdownUtil;
import com.liferay.server.admin.web.internal.display.context.ServerDisplayContext;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public final class external_005fservices_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


private static final String[] _IMAGEMAGICK_RESOURCE_LIMIT_LABELS = {"area", "disk", "file", "map", "memory", "thread", "time"};

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/init.jsp");
    _jspx_dependants.add("/init-ext.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_value_type_name_label_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_error_targetNode_exception;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_message_key_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_option_value_label_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_panel$1container_persistState_id_extended;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_option_value_selected_label_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1theme_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_button_value_data$1cmd_cssClass_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_panel_title_persistState_markupView_id_extended_collapsible;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_value_type_name_label_cssClass_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_fieldset;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_select_name_label;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_button_value_name_data$1cmd_cssClass_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_fieldset_label;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_button$1row;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_aui_input_value_type_name_label_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_error_targetNode_exception = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_message_key_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_option_value_label_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_panel$1container_persistState_id_extended = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_option_value_selected_label_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1theme_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_button_value_data$1cmd_cssClass_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_panel_title_persistState_markupView_id_extended_collapsible = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_value_type_name_label_cssClass_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_fieldset = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_select_name_label = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_button_value_name_data$1cmd_cssClass_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_fieldset_label = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_button$1row = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_aui_input_value_type_name_label_nobody.release();
    _jspx_tagPool_liferay$1ui_error_targetNode_exception.release();
    _jspx_tagPool_liferay$1ui_message_key_nobody.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_aui_option_value_label_nobody.release();
    _jspx_tagPool_portlet_defineObjects_nobody.release();
    _jspx_tagPool_liferay$1ui_panel$1container_persistState_id_extended.release();
    _jspx_tagPool_aui_option_value_selected_label_nobody.release();
    _jspx_tagPool_liferay$1theme_defineObjects_nobody.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_aui_button_value_data$1cmd_cssClass_nobody.release();
    _jspx_tagPool_liferay$1frontend_defineObjects_nobody.release();
    _jspx_tagPool_liferay$1ui_panel_title_persistState_markupView_id_extended_collapsible.release();
    _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.release();
    _jspx_tagPool_aui_input_value_type_name_label_cssClass_nobody.release();
    _jspx_tagPool_aui_fieldset.release();
    _jspx_tagPool_aui_select_name_label.release();
    _jspx_tagPool_aui_button_value_name_data$1cmd_cssClass_nobody.release();
    _jspx_tagPool_aui_fieldset_label.release();
    _jspx_tagPool_c_when_test.release();
    _jspx_tagPool_aui_button$1row.release();
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
      out.write("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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

PortletMode portletMode = liferayPortletRequest.getPortletMode();

      out.write('\n');
      out.write('\n');

String tabs1 = ParamUtil.getString(request, "tabs1", "resources");
String tabs2 = ParamUtil.getString(request, "tabs2");

      out.write('\n');
      out.write('\n');
      out.write("\n\n<div class=\"server-admin-tabs\">\n\t");
      //  aui:fieldset
      com.liferay.taglib.aui.FieldsetTag _jspx_th_aui_fieldset_0 = (com.liferay.taglib.aui.FieldsetTag) _jspx_tagPool_aui_fieldset.get(com.liferay.taglib.aui.FieldsetTag.class);
      _jspx_th_aui_fieldset_0.setPageContext(_jspx_page_context);
      _jspx_th_aui_fieldset_0.setParent(null);
      int _jspx_eval_aui_fieldset_0 = _jspx_th_aui_fieldset_0.doStartTag();
      if (_jspx_eval_aui_fieldset_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\n\t\t");
        //  liferay-ui:panel-container
        com.liferay.taglib.ui.PanelContainerTag _jspx_th_liferay$1ui_panel$1container_0 = (com.liferay.taglib.ui.PanelContainerTag) _jspx_tagPool_liferay$1ui_panel$1container_persistState_id_extended.get(com.liferay.taglib.ui.PanelContainerTag.class);
        _jspx_th_liferay$1ui_panel$1container_0.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_panel$1container_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_fieldset_0);
        _jspx_th_liferay$1ui_panel$1container_0.setExtended( true );
        _jspx_th_liferay$1ui_panel$1container_0.setId("adminExternalServicesPanelContainer");
        _jspx_th_liferay$1ui_panel$1container_0.setPersistState( true );
        int _jspx_eval_liferay$1ui_panel$1container_0 = _jspx_th_liferay$1ui_panel$1container_0.doStartTag();
        if (_jspx_eval_liferay$1ui_panel$1container_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          if (_jspx_eval_liferay$1ui_panel$1container_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.pushBody();
            _jspx_th_liferay$1ui_panel$1container_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
            _jspx_th_liferay$1ui_panel$1container_0.doInitBody();
          }
          do {
            out.write("\n\t\t\t");
            //  liferay-ui:panel
            com.liferay.taglib.ui.PanelTag _jspx_th_liferay$1ui_panel_0 = (com.liferay.taglib.ui.PanelTag) _jspx_tagPool_liferay$1ui_panel_title_persistState_markupView_id_extended_collapsible.get(com.liferay.taglib.ui.PanelTag.class);
            _jspx_th_liferay$1ui_panel_0.setPageContext(_jspx_page_context);
            _jspx_th_liferay$1ui_panel_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_panel$1container_0);
            _jspx_th_liferay$1ui_panel_0.setCollapsible( true );
            _jspx_th_liferay$1ui_panel_0.setExtended( true );
            _jspx_th_liferay$1ui_panel_0.setId("adminImageMagickConversionPanel");
            _jspx_th_liferay$1ui_panel_0.setMarkupView("lexicon");
            _jspx_th_liferay$1ui_panel_0.setPersistState( true );
            _jspx_th_liferay$1ui_panel_0.setTitle("enabling-imagemagick-provides-document-preview-functionality");
            int _jspx_eval_liferay$1ui_panel_0 = _jspx_th_liferay$1ui_panel_0.doStartTag();
            if (_jspx_eval_liferay$1ui_panel_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              out.write("\n\t\t\t\t");
              //  aui:input
              com.liferay.taglib.aui.InputTag _jspx_th_aui_input_0 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_label_nobody.get(com.liferay.taglib.aui.InputTag.class);
              _jspx_th_aui_input_0.setPageContext(_jspx_page_context);
              _jspx_th_aui_input_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_panel_0);
              _jspx_th_aui_input_0.setLabel("enabled");
              _jspx_th_aui_input_0.setName("imageMagickEnabled");
              _jspx_th_aui_input_0.setType("checkbox");
              _jspx_th_aui_input_0.setValue( ImageMagickUtil.isEnabled() );
              int _jspx_eval_aui_input_0 = _jspx_th_aui_input_0.doStartTag();
              if (_jspx_th_aui_input_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_aui_input_value_type_name_label_nobody.reuse(_jspx_th_aui_input_0);
                return;
              }
              _jspx_tagPool_aui_input_value_type_name_label_nobody.reuse(_jspx_th_aui_input_0);
              out.write("\n\n\t\t\t\t");
              //  aui:input
              com.liferay.taglib.aui.InputTag _jspx_th_aui_input_1 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_label_cssClass_nobody.get(com.liferay.taglib.aui.InputTag.class);
              _jspx_th_aui_input_1.setPageContext(_jspx_page_context);
              _jspx_th_aui_input_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_panel_0);
              _jspx_th_aui_input_1.setCssClass("lfr-input-text-container");
              _jspx_th_aui_input_1.setLabel("path");
              _jspx_th_aui_input_1.setName("imageMagickPath");
              _jspx_th_aui_input_1.setType("text");
              _jspx_th_aui_input_1.setValue( ImageMagickUtil.getGlobalSearchPath() );
              int _jspx_eval_aui_input_1 = _jspx_th_aui_input_1.doStartTag();
              if (_jspx_th_aui_input_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_aui_input_value_type_name_label_cssClass_nobody.reuse(_jspx_th_aui_input_1);
                return;
              }
              _jspx_tagPool_aui_input_value_type_name_label_cssClass_nobody.reuse(_jspx_th_aui_input_1);
              out.write("\n\n\t\t\t\t");
              //  aui:fieldset
              com.liferay.taglib.aui.FieldsetTag _jspx_th_aui_fieldset_1 = (com.liferay.taglib.aui.FieldsetTag) _jspx_tagPool_aui_fieldset_label.get(com.liferay.taglib.aui.FieldsetTag.class);
              _jspx_th_aui_fieldset_1.setPageContext(_jspx_page_context);
              _jspx_th_aui_fieldset_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_panel_0);
              _jspx_th_aui_fieldset_1.setLabel("resource-limits");
              int _jspx_eval_aui_fieldset_1 = _jspx_th_aui_fieldset_1.doStartTag();
              if (_jspx_eval_aui_fieldset_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                out.write("\n\n\t\t\t\t\t");

					Properties resourceLimitsProperties = ImageMagickUtil.getResourceLimitsProperties();

					for (String label : _IMAGEMAGICK_RESOURCE_LIMIT_LABELS) {
						String name = "imageMagickLimit" + StringUtil.upperCaseFirstLetter(label);
					
                out.write("\n\n\t\t\t\t\t\t");
                //  aui:input
                com.liferay.taglib.aui.InputTag _jspx_th_aui_input_2 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_label_cssClass_nobody.get(com.liferay.taglib.aui.InputTag.class);
                _jspx_th_aui_input_2.setPageContext(_jspx_page_context);
                _jspx_th_aui_input_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_fieldset_1);
                _jspx_th_aui_input_2.setCssClass("lfr-input-text-container");
                _jspx_th_aui_input_2.setLabel( label );
                _jspx_th_aui_input_2.setName( name );
                _jspx_th_aui_input_2.setType("text");
                _jspx_th_aui_input_2.setValue( resourceLimitsProperties.getProperty(label) );
                int _jspx_eval_aui_input_2 = _jspx_th_aui_input_2.doStartTag();
                if (_jspx_th_aui_input_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_aui_input_value_type_name_label_cssClass_nobody.reuse(_jspx_th_aui_input_2);
                  return;
                }
                _jspx_tagPool_aui_input_value_type_name_label_cssClass_nobody.reuse(_jspx_th_aui_input_2);
                out.write("\n\n\t\t\t\t\t");

					}
					
                out.write("\n\n\t\t\t\t");
              }
              if (_jspx_th_aui_fieldset_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_aui_fieldset_label.reuse(_jspx_th_aui_fieldset_1);
                return;
              }
              _jspx_tagPool_aui_fieldset_label.reuse(_jspx_th_aui_fieldset_1);
              out.write("\n\t\t\t");
            }
            if (_jspx_th_liferay$1ui_panel_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_liferay$1ui_panel_title_persistState_markupView_id_extended_collapsible.reuse(_jspx_th_liferay$1ui_panel_0);
              return;
            }
            _jspx_tagPool_liferay$1ui_panel_title_persistState_markupView_id_extended_collapsible.reuse(_jspx_th_liferay$1ui_panel_0);
            out.write("\n\n\t\t\t");
            //  liferay-ui:panel
            com.liferay.taglib.ui.PanelTag _jspx_th_liferay$1ui_panel_1 = (com.liferay.taglib.ui.PanelTag) _jspx_tagPool_liferay$1ui_panel_title_persistState_markupView_id_extended_collapsible.get(com.liferay.taglib.ui.PanelTag.class);
            _jspx_th_liferay$1ui_panel_1.setPageContext(_jspx_page_context);
            _jspx_th_liferay$1ui_panel_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_panel$1container_0);
            _jspx_th_liferay$1ui_panel_1.setCollapsible( true );
            _jspx_th_liferay$1ui_panel_1.setExtended( true );
            _jspx_th_liferay$1ui_panel_1.setId("adminXugglerPanel");
            _jspx_th_liferay$1ui_panel_1.setMarkupView("lexicon");
            _jspx_th_liferay$1ui_panel_1.setPersistState( true );
            _jspx_th_liferay$1ui_panel_1.setTitle("enabling-xuggler-provides-video-conversion-functionality");
            int _jspx_eval_liferay$1ui_panel_1 = _jspx_th_liferay$1ui_panel_1.doStartTag();
            if (_jspx_eval_liferay$1ui_panel_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              out.write("\n\t\t\t\t");
              //  liferay-ui:error
              com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_0 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_targetNode_exception.get(com.liferay.taglib.ui.ErrorTag.class);
              _jspx_th_liferay$1ui_error_0.setPageContext(_jspx_page_context);
              _jspx_th_liferay$1ui_error_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_panel_1);
              _jspx_th_liferay$1ui_error_0.setException( XugglerInstallException.class );
              _jspx_th_liferay$1ui_error_0.setTargetNode("#controlMenuAlertsContainer");
              int _jspx_eval_liferay$1ui_error_0 = _jspx_th_liferay$1ui_error_0.doStartTag();
              if (_jspx_eval_liferay$1ui_error_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                java.lang.Object errorException = null;
                if (_jspx_eval_liferay$1ui_error_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_liferay$1ui_error_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_liferay$1ui_error_0.doInitBody();
                }
                errorException = (java.lang.Object) _jspx_page_context.findAttribute("errorException");
                do {
                  out.write("\n\n\t\t\t\t\t");

					XugglerInstallException xie = (XugglerInstallException)errorException;
					
                  out.write("\n\n\t\t\t\t\t");
                  //  liferay-ui:message
                  com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_0 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
                  _jspx_th_liferay$1ui_message_0.setPageContext(_jspx_page_context);
                  _jspx_th_liferay$1ui_message_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_error_0);
                  _jspx_th_liferay$1ui_message_0.setArguments( xie.getMessage() );
                  _jspx_th_liferay$1ui_message_0.setKey("an-unexpected-error-occurred-while-installing-xuggler-x");
                  _jspx_th_liferay$1ui_message_0.setTranslateArguments( false );
                  int _jspx_eval_liferay$1ui_message_0 = _jspx_th_liferay$1ui_message_0.doStartTag();
                  if (_jspx_th_liferay$1ui_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_0);
                    return;
                  }
                  _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_0);
                  out.write("\n\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_liferay$1ui_error_0.doAfterBody();
                  errorException = (java.lang.Object) _jspx_page_context.findAttribute("errorException");
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_liferay$1ui_error_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_liferay$1ui_error_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_liferay$1ui_error_targetNode_exception.reuse(_jspx_th_liferay$1ui_error_0);
                return;
              }
              _jspx_tagPool_liferay$1ui_error_targetNode_exception.reuse(_jspx_th_liferay$1ui_error_0);
              out.write("\n\n\t\t\t\t");
              //  c:choose
              com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_0 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
              _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
              _jspx_th_c_choose_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_panel_1);
              int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
              if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                out.write("\n\t\t\t\t\t");
                //  c:when
                com.liferay.taglib.core.WhenTag _jspx_th_c_when_0 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                _jspx_th_c_when_0.setPageContext(_jspx_page_context);
                _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
                _jspx_th_c_when_0.setTest( XugglerUtil.isNativeLibraryInstalled() );
                int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
                if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\t\t\t\t\t\t<div class=\"alert alert-info\">\n\t\t\t\t\t\t\t");
                  if (_jspx_meth_liferay$1ui_message_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_0, _jspx_page_context))
                    return;
                  out.write("\n\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t");
                  //  aui:input
                  com.liferay.taglib.aui.InputTag _jspx_th_aui_input_3 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_label_nobody.get(com.liferay.taglib.aui.InputTag.class);
                  _jspx_th_aui_input_3.setPageContext(_jspx_page_context);
                  _jspx_th_aui_input_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
                  _jspx_th_aui_input_3.setLabel("enabled");
                  _jspx_th_aui_input_3.setName("xugglerEnabled");
                  _jspx_th_aui_input_3.setType("checkbox");
                  _jspx_th_aui_input_3.setValue( XugglerUtil.isEnabled() );
                  int _jspx_eval_aui_input_3 = _jspx_th_aui_input_3.doStartTag();
                  if (_jspx_th_aui_input_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_aui_input_value_type_name_label_nobody.reuse(_jspx_th_aui_input_3);
                    return;
                  }
                  _jspx_tagPool_aui_input_value_type_name_label_nobody.reuse(_jspx_th_aui_input_3);
                  out.write("\n\t\t\t\t\t");
                }
                if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
                  return;
                }
                _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
                out.write("\n\t\t\t\t\t");
                //  c:when
                com.liferay.taglib.core.WhenTag _jspx_th_c_when_1 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                _jspx_th_c_when_1.setPageContext(_jspx_page_context);
                _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
                _jspx_th_c_when_1.setTest( XugglerUtil.isNativeLibraryCopied() );
                int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
                if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\t\t\t\t\t\t<div class=\"alert alert-info\">\n\t\t\t\t\t\t\t");
                  if (_jspx_meth_liferay$1ui_message_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_1, _jspx_page_context))
                    return;
                  out.write("\n\t\t\t\t\t\t</div>\n\t\t\t\t\t");
                }
                if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
                  return;
                }
                _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
                out.write("\n\t\t\t\t\t");
                //  c:otherwise
                com.liferay.taglib.core.OtherwiseTag _jspx_th_c_otherwise_0 = (com.liferay.taglib.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(com.liferay.taglib.core.OtherwiseTag.class);
                _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
                _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
                int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
                if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\n\t\t\t\t\t\t");

						String xugglerHelp = LanguageUtil.format(request, "xuggler-help", "http://www.xuggle.com/xuggler/downloads", false);

						String[] xugglerOptions = PropsUtil.getArray(PropsKeys.XUGGLER_JAR_OPTIONS);

						String bitmode = OSDetector.getBitmode();

						String guess = StringPool.BLANK;

						if (Validator.isNotNull(bitmode) && (bitmode.equals("32") || bitmode.equals("64"))) {
							if (OSDetector.isApple()) {
								guess = bitmode + "-mac";
							}
							else if (OSDetector.isLinux()) {
								guess = bitmode + "-linux";
							}
							else if (OSDetector.isWindows()) {
								guess = bitmode + "-win";
							}

							if (Validator.isNotNull(guess)) {
								boolean found = false;

								for (String xugglerOption : xugglerOptions) {
									if (xugglerOption.equals(guess)) {
										found = true;

										break;
									}
								}

								if (!found) {
									guess = StringPool.BLANK;
								}
							}
						}
						
                  out.write("\n\n\t\t\t\t\t\t<div class=\"alert alert-info\">\n\t\t\t\t\t\t\t");
                  //  liferay-ui:message
                  com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_3 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
                  _jspx_th_liferay$1ui_message_3.setPageContext(_jspx_page_context);
                  _jspx_th_liferay$1ui_message_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_0);
                  _jspx_th_liferay$1ui_message_3.setKey( xugglerHelp );
                  int _jspx_eval_liferay$1ui_message_3 = _jspx_th_liferay$1ui_message_3.doStartTag();
                  if (_jspx_th_liferay$1ui_message_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_3);
                    return;
                  }
                  _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_3);
                  out.write("\n\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t");
                  //  aui:select
                  com.liferay.taglib.aui.SelectTag _jspx_th_aui_select_0 = (com.liferay.taglib.aui.SelectTag) _jspx_tagPool_aui_select_name_label.get(com.liferay.taglib.aui.SelectTag.class);
                  _jspx_th_aui_select_0.setPageContext(_jspx_page_context);
                  _jspx_th_aui_select_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_0);
                  _jspx_th_aui_select_0.setLabel("jar-file");
                  _jspx_th_aui_select_0.setName("jarName");
                  int _jspx_eval_aui_select_0 = _jspx_th_aui_select_0.doStartTag();
                  if (_jspx_eval_aui_select_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    if (_jspx_eval_aui_select_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_aui_select_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_aui_select_0.doInitBody();
                    }
                    do {
                      out.write("\n\n\t\t\t\t\t\t\t");

							if (Validator.isNull(guess)) {
							
                      out.write("\n\n\t\t\t\t\t\t\t\t");
                      if (_jspx_meth_aui_option_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_select_0, _jspx_page_context))
                        return;
                      out.write("\n\n\t\t\t\t\t\t\t");

							}

							for (String xugglerOption : xugglerOptions) {
								String jarFile = PropsUtil.get(PropsKeys.XUGGLER_JAR_FILE, new Filter(xugglerOption));
								String jarName = PropsUtil.get(PropsKeys.XUGGLER_JAR_NAME, new Filter(xugglerOption));
							
                      out.write("\n\n\t\t\t\t\t\t\t\t");
                      //  aui:option
                      com.liferay.taglib.aui.OptionTag _jspx_th_aui_option_1 = (com.liferay.taglib.aui.OptionTag) _jspx_tagPool_aui_option_value_selected_label_nobody.get(com.liferay.taglib.aui.OptionTag.class);
                      _jspx_th_aui_option_1.setPageContext(_jspx_page_context);
                      _jspx_th_aui_option_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_select_0);
                      _jspx_th_aui_option_1.setLabel( jarName + " (" + jarFile + ")" );
                      _jspx_th_aui_option_1.setSelected( xugglerOption.equals(guess) );
                      _jspx_th_aui_option_1.setValue( jarFile );
                      int _jspx_eval_aui_option_1 = _jspx_th_aui_option_1.doStartTag();
                      if (_jspx_th_aui_option_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_aui_option_value_selected_label_nobody.reuse(_jspx_th_aui_option_1);
                        return;
                      }
                      _jspx_tagPool_aui_option_value_selected_label_nobody.reuse(_jspx_th_aui_option_1);
                      out.write("\n\n\t\t\t\t\t\t\t");

							}
							
                      out.write("\n\n\t\t\t\t\t\t");
                      int evalDoAfterBody = _jspx_th_aui_select_0.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_aui_select_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                      out = _jspx_page_context.popBody();
                  }
                  if (_jspx_th_aui_select_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_aui_select_name_label.reuse(_jspx_th_aui_select_0);
                    return;
                  }
                  _jspx_tagPool_aui_select_name_label.reuse(_jspx_th_aui_select_0);
                  out.write("\n\n\t\t\t\t\t\t");
                  if (_jspx_meth_aui_button$1row_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_otherwise_0, _jspx_page_context))
                    return;
                  out.write("\n\t\t\t\t\t");
                }
                if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
                  return;
                }
                _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
                out.write("\n\t\t\t\t");
              }
              if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
                return;
              }
              _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
              out.write("\n\t\t\t");
            }
            if (_jspx_th_liferay$1ui_panel_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_liferay$1ui_panel_title_persistState_markupView_id_extended_collapsible.reuse(_jspx_th_liferay$1ui_panel_1);
              return;
            }
            _jspx_tagPool_liferay$1ui_panel_title_persistState_markupView_id_extended_collapsible.reuse(_jspx_th_liferay$1ui_panel_1);
            out.write("\n\t\t");
            int evalDoAfterBody = _jspx_th_liferay$1ui_panel$1container_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_liferay$1ui_panel$1container_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
            out = _jspx_page_context.popBody();
        }
        if (_jspx_th_liferay$1ui_panel$1container_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_panel$1container_persistState_id_extended.reuse(_jspx_th_liferay$1ui_panel$1container_0);
          return;
        }
        _jspx_tagPool_liferay$1ui_panel$1container_persistState_id_extended.reuse(_jspx_th_liferay$1ui_panel$1container_0);
        out.write('\n');
        out.write('	');
      }
      if (_jspx_th_aui_fieldset_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_fieldset.reuse(_jspx_th_aui_fieldset_0);
        return;
      }
      _jspx_tagPool_aui_fieldset.reuse(_jspx_th_aui_fieldset_0);
      out.write("\n</div>\n\n");
      if (_jspx_meth_aui_button$1row_1(_jspx_page_context))
        return;
      out.write('\n');
      out.write('\n');
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

  private boolean _jspx_meth_liferay$1ui_message_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_1 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_1.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
    _jspx_th_liferay$1ui_message_1.setKey("xuggler-installed");
    int _jspx_eval_liferay$1ui_message_1 = _jspx_th_liferay$1ui_message_1.doStartTag();
    if (_jspx_th_liferay$1ui_message_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_1);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_1);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_message_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_2 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_2.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_1);
    _jspx_th_liferay$1ui_message_2.setKey("xuggler-has-been-installed-you-need-to-reboot-your-server-to-apply-changes");
    int _jspx_eval_liferay$1ui_message_2 = _jspx_th_liferay$1ui_message_2.doStartTag();
    if (_jspx_th_liferay$1ui_message_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_2);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_2);
    return false;
  }

  private boolean _jspx_meth_aui_option_0(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_select_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:option
    com.liferay.taglib.aui.OptionTag _jspx_th_aui_option_0 = (com.liferay.taglib.aui.OptionTag) _jspx_tagPool_aui_option_value_label_nobody.get(com.liferay.taglib.aui.OptionTag.class);
    _jspx_th_aui_option_0.setPageContext(_jspx_page_context);
    _jspx_th_aui_option_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_select_0);
    _jspx_th_aui_option_0.setLabel(new String("unknown"));
    _jspx_th_aui_option_0.setValue(new String(""));
    int _jspx_eval_aui_option_0 = _jspx_th_aui_option_0.doStartTag();
    if (_jspx_th_aui_option_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_option_value_label_nobody.reuse(_jspx_th_aui_option_0);
      return true;
    }
    _jspx_tagPool_aui_option_value_label_nobody.reuse(_jspx_th_aui_option_0);
    return false;
  }

  private boolean _jspx_meth_aui_button$1row_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_otherwise_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:button-row
    com.liferay.taglib.aui.ButtonRowTag _jspx_th_aui_button$1row_0 = (com.liferay.taglib.aui.ButtonRowTag) _jspx_tagPool_aui_button$1row.get(com.liferay.taglib.aui.ButtonRowTag.class);
    _jspx_th_aui_button$1row_0.setPageContext(_jspx_page_context);
    _jspx_th_aui_button$1row_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_0);
    int _jspx_eval_aui_button$1row_0 = _jspx_th_aui_button$1row_0.doStartTag();
    if (_jspx_eval_aui_button$1row_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\n\t\t\t\t\t\t\t");
      if (_jspx_meth_aui_button_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_button$1row_0, _jspx_page_context))
        return true;
      out.write("\n\t\t\t\t\t\t");
    }
    if (_jspx_th_aui_button$1row_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_button$1row.reuse(_jspx_th_aui_button$1row_0);
      return true;
    }
    _jspx_tagPool_aui_button$1row.reuse(_jspx_th_aui_button$1row_0);
    return false;
  }

  private boolean _jspx_meth_aui_button_0(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_button$1row_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:button
    com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_0 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_value_name_data$1cmd_cssClass_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
    _jspx_th_aui_button_0.setPageContext(_jspx_page_context);
    _jspx_th_aui_button_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_button$1row_0);
    _jspx_th_aui_button_0.setCssClass("save-server-button");
    _jspx_th_aui_button_0.setDynamicAttribute(null, "data-cmd", new String("installXuggler"));
    _jspx_th_aui_button_0.setName("installXugglerButton");
    _jspx_th_aui_button_0.setValue("install");
    int _jspx_eval_aui_button_0 = _jspx_th_aui_button_0.doStartTag();
    if (_jspx_th_aui_button_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_button_value_name_data$1cmd_cssClass_nobody.reuse(_jspx_th_aui_button_0);
      return true;
    }
    _jspx_tagPool_aui_button_value_name_data$1cmd_cssClass_nobody.reuse(_jspx_th_aui_button_0);
    return false;
  }

  private boolean _jspx_meth_aui_button$1row_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:button-row
    com.liferay.taglib.aui.ButtonRowTag _jspx_th_aui_button$1row_1 = (com.liferay.taglib.aui.ButtonRowTag) _jspx_tagPool_aui_button$1row.get(com.liferay.taglib.aui.ButtonRowTag.class);
    _jspx_th_aui_button$1row_1.setPageContext(_jspx_page_context);
    _jspx_th_aui_button$1row_1.setParent(null);
    int _jspx_eval_aui_button$1row_1 = _jspx_th_aui_button$1row_1.doStartTag();
    if (_jspx_eval_aui_button$1row_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write('\n');
      out.write('	');
      if (_jspx_meth_aui_button_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_button$1row_1, _jspx_page_context))
        return true;
      out.write('\n');
    }
    if (_jspx_th_aui_button$1row_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_button$1row.reuse(_jspx_th_aui_button$1row_1);
      return true;
    }
    _jspx_tagPool_aui_button$1row.reuse(_jspx_th_aui_button$1row_1);
    return false;
  }

  private boolean _jspx_meth_aui_button_1(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_button$1row_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:button
    com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_1 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_value_data$1cmd_cssClass_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
    _jspx_th_aui_button_1.setPageContext(_jspx_page_context);
    _jspx_th_aui_button_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_button$1row_1);
    _jspx_th_aui_button_1.setCssClass("save-server-button");
    _jspx_th_aui_button_1.setDynamicAttribute(null, "data-cmd", new String("updateExternalServices"));
    _jspx_th_aui_button_1.setValue("save");
    int _jspx_eval_aui_button_1 = _jspx_th_aui_button_1.doStartTag();
    if (_jspx_th_aui_button_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_button_value_data$1cmd_cssClass_nobody.reuse(_jspx_th_aui_button_1);
      return true;
    }
    _jspx_tagPool_aui_button_value_data$1cmd_cssClass_nobody.reuse(_jspx_th_aui_button_1);
    return false;
  }
}