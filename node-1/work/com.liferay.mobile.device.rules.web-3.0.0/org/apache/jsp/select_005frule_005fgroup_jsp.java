package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPNavigationItemList;
import com.liferay.mobile.device.rules.action.ActionHandler;
import com.liferay.mobile.device.rules.action.ActionHandlerManagerUtil;
import com.liferay.mobile.device.rules.constants.MDRPortletKeys;
import com.liferay.mobile.device.rules.exception.ActionTypeException;
import com.liferay.mobile.device.rules.exception.NoSuchActionException;
import com.liferay.mobile.device.rules.exception.NoSuchRuleException;
import com.liferay.mobile.device.rules.exception.NoSuchRuleGroupException;
import com.liferay.mobile.device.rules.exception.NoSuchRuleGroupInstanceException;
import com.liferay.mobile.device.rules.model.MDRAction;
import com.liferay.mobile.device.rules.model.MDRRule;
import com.liferay.mobile.device.rules.model.MDRRuleGroup;
import com.liferay.mobile.device.rules.model.MDRRuleGroupInstance;
import com.liferay.mobile.device.rules.rule.RuleGroupProcessorUtil;
import com.liferay.mobile.device.rules.rule.UnknownRuleHandlerException;
import com.liferay.mobile.device.rules.service.MDRActionLocalServiceUtil;
import com.liferay.mobile.device.rules.service.MDRRuleGroupInstanceLocalServiceUtil;
import com.liferay.mobile.device.rules.service.MDRRuleGroupInstanceServiceUtil;
import com.liferay.mobile.device.rules.service.MDRRuleGroupLocalServiceUtil;
import com.liferay.mobile.device.rules.service.MDRRuleLocalServiceUtil;
import com.liferay.mobile.device.rules.util.comparator.RuleCreateDateComparator;
import com.liferay.mobile.device.rules.util.comparator.RuleGroupInstancePriorityComparator;
import com.liferay.mobile.device.rules.web.internal.constants.MDRWebKeys;
import com.liferay.mobile.device.rules.web.internal.display.context.MDRActionDisplayContext;
import com.liferay.mobile.device.rules.web.internal.rule.group.rule.SimpleRuleHandler;
import com.liferay.mobile.device.rules.web.internal.search.RuleGroupChecker;
import com.liferay.mobile.device.rules.web.internal.search.RuleGroupDisplayTerms;
import com.liferay.mobile.device.rules.web.internal.search.RuleGroupSearch;
import com.liferay.mobile.device.rules.web.internal.search.RuleGroupSearchTerms;
import com.liferay.mobile.device.rules.web.internal.security.permission.resource.MDRPermission;
import com.liferay.mobile.device.rules.web.internal.security.permission.resource.MDRRuleGroupInstancePermission;
import com.liferay.mobile.device.rules.web.internal.security.permission.resource.MDRRuleGroupPermission;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.bean.BeanParamUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.language.UnicodeLanguageUtil;
import com.liferay.portal.kernel.mobile.device.DeviceDetectionUtil;
import com.liferay.portal.kernel.mobile.device.VersionableName;
import com.liferay.portal.kernel.model.ColorScheme;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.model.Theme;
import com.liferay.portal.kernel.plugin.PluginPackage;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupServiceUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutServiceUtil;
import com.liferay.portal.kernel.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutTemplateLocalServiceUtil;
import com.liferay.portal.kernel.service.ThemeLocalServiceUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.util.PropsValues;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

public final class select_005frule_005fgroup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/init.jsp");
    _jspx_dependants.add("/init-ext.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1container_searchContainer;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_management$1bar$1navigation_portletURL_navigationKeys_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_input$1search_markupView_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_script;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_form_name_method_cssClass_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1container$1row_modelVar_keyProperty_escapedModel_className;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_clay_navigation$1bar_navigationItems_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1container$1column$1text_value_name_cssClass_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_management$1bar$1filters;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_namespace_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_management$1bar$1display$1buttons_selectedDisplayStyle_portletURL_displayViews_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1container$1column$1icon_icon_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_management$1bar;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1container$1column$1text_colspan;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1iterator_type_markupView_displayStyle_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1theme_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_form_name_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1container$1column$1text;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name_cssClass;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_management$1bar$1buttons;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_a_href_data_cssClass;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_icon$1vertical$1card_title_subtitle_icon_data_cssClass_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_liferay$1ui_search$1container_searchContainer = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_management$1bar$1navigation_portletURL_navigationKeys_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_input$1search_markupView_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_script = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_form_name_method_cssClass_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1container$1row_modelVar_keyProperty_escapedModel_className = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_clay_navigation$1bar_navigationItems_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1container$1column$1text_value_name_cssClass_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_management$1bar$1filters = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_namespace_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_management$1bar$1display$1buttons_selectedDisplayStyle_portletURL_displayViews_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1container$1column$1icon_icon_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_management$1bar = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1container$1column$1text_colspan = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1iterator_type_markupView_displayStyle_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1theme_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_form_name_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1container$1column$1text = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name_cssClass = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_management$1bar$1buttons = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_a_href_data_cssClass = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_icon$1vertical$1card_title_subtitle_icon_data_cssClass_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_liferay$1ui_search$1container_searchContainer.release();
    _jspx_tagPool_liferay$1frontend_management$1bar$1navigation_portletURL_navigationKeys_nobody.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_liferay$1ui_input$1search_markupView_nobody.release();
    _jspx_tagPool_aui_script.release();
    _jspx_tagPool_aui_form_name_method_cssClass_action.release();
    _jspx_tagPool_liferay$1ui_search$1container$1row_modelVar_keyProperty_escapedModel_className.release();
    _jspx_tagPool_clay_navigation$1bar_navigationItems_nobody.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_liferay$1frontend_defineObjects_nobody.release();
    _jspx_tagPool_liferay$1ui_search$1container$1column$1text_value_name_cssClass_nobody.release();
    _jspx_tagPool_liferay$1frontend_management$1bar$1filters.release();
    _jspx_tagPool_c_when_test.release();
    _jspx_tagPool_portlet_namespace_nobody.release();
    _jspx_tagPool_liferay$1frontend_management$1bar$1display$1buttons_selectedDisplayStyle_portletURL_displayViews_nobody.release();
    _jspx_tagPool_liferay$1ui_search$1container$1column$1icon_icon_nobody.release();
    _jspx_tagPool_liferay$1frontend_management$1bar.release();
    _jspx_tagPool_liferay$1ui_search$1container$1column$1text_colspan.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_portlet_defineObjects_nobody.release();
    _jspx_tagPool_liferay$1ui_search$1iterator_type_markupView_displayStyle_nobody.release();
    _jspx_tagPool_liferay$1theme_defineObjects_nobody.release();
    _jspx_tagPool_aui_form_name_action.release();
    _jspx_tagPool_liferay$1ui_search$1container$1column$1text.release();
    _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name_cssClass.release();
    _jspx_tagPool_liferay$1frontend_management$1bar$1buttons.release();
    _jspx_tagPool_aui_a_href_data_cssClass.release();
    _jspx_tagPool_liferay$1frontend_icon$1vertical$1card_title_subtitle_icon_data_cssClass_nobody.release();
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

long groupId = ParamUtil.getLong(request, "groupId", themeDisplay.getSiteGroupId());

portletDisplay.setShowExportImportIcon(false);
portletDisplay.setShowStagingIcon(false);

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');

String className = ParamUtil.getString(request, "className");
long classPK = ParamUtil.getLong(request, "classPK");
String displayStyle = ParamUtil.getString(request, "displayStyle", "list");
String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectRuleGroup");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", "/select_rule_group.jsp");
portletURL.setParameter("groupId", String.valueOf(groupId));
portletURL.setParameter("eventName", eventName);

RuleGroupSearch ruleGroupSearch = new RuleGroupSearch(liferayPortletRequest, portletURL);

RuleGroupDisplayTerms displayTerms = (RuleGroupDisplayTerms)ruleGroupSearch.getDisplayTerms();
RuleGroupSearchTerms searchTerms = (RuleGroupSearchTerms)ruleGroupSearch.getSearchTerms();

if (displayTerms.getGroupId() == 0) {
	displayTerms.setGroupId(groupId);
	searchTerms.setGroupId(groupId);
}

LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();

params.put("includeGlobalScope", Boolean.TRUE);

int mdrRuleGroupsCount = MDRRuleGroupLocalServiceUtil.searchByKeywordsCount(searchTerms.getGroupId(), searchTerms.getKeywords(), params, searchTerms.isAndOperator());

ruleGroupSearch.setTotal(mdrRuleGroupsCount);

List<MDRRuleGroup> mdrRuleGroups = MDRRuleGroupLocalServiceUtil.searchByKeywords(searchTerms.getGroupId(), searchTerms.getKeywords(), params, searchTerms.isAndOperator(), ruleGroupSearch.getStart(), ruleGroupSearch.getEnd());

ruleGroupSearch.setResults(mdrRuleGroups);

      out.write('\n');
      out.write('\n');
      //  clay:navigation-bar
      com.liferay.frontend.taglib.clay.servlet.taglib.soy.NavigationBarTag _jspx_th_clay_navigation$1bar_0 = (com.liferay.frontend.taglib.clay.servlet.taglib.soy.NavigationBarTag) _jspx_tagPool_clay_navigation$1bar_navigationItems_nobody.get(com.liferay.frontend.taglib.clay.servlet.taglib.soy.NavigationBarTag.class);
      _jspx_th_clay_navigation$1bar_0.setPageContext(_jspx_page_context);
      _jspx_th_clay_navigation$1bar_0.setParent(null);
      _jspx_th_clay_navigation$1bar_0.setNavigationItems(
		new JSPNavigationItemList(pageContext) {
			{
				add(
					navigationItem -> {
						navigationItem.setActive(true);
						navigationItem.setHref(StringPool.BLANK);
						navigationItem.setLabel(LanguageUtil.get(request, "device-families"));
					});
			}
		}
	);
      int _jspx_eval_clay_navigation$1bar_0 = _jspx_th_clay_navigation$1bar_0.doStartTag();
      if (_jspx_th_clay_navigation$1bar_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_clay_navigation$1bar_navigationItems_nobody.reuse(_jspx_th_clay_navigation$1bar_0);
        return;
      }
      _jspx_tagPool_clay_navigation$1bar_navigationItems_nobody.reuse(_jspx_th_clay_navigation$1bar_0);
      out.write('\n');
      out.write('\n');
      //  c:if
      com.liferay.taglib.core.IfTag _jspx_th_c_if_0 = (com.liferay.taglib.core.IfTag) _jspx_tagPool_c_if_test.get(com.liferay.taglib.core.IfTag.class);
      _jspx_th_c_if_0.setPageContext(_jspx_page_context);
      _jspx_th_c_if_0.setParent(null);
      _jspx_th_c_if_0.setTest( (mdrRuleGroupsCount > 0) || searchTerms.isSearch() );
      int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
      if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write('\n');
        out.write('	');
        //  liferay-frontend:management-bar
        com.liferay.frontend.taglib.servlet.taglib.ManagementBarTag _jspx_th_liferay$1frontend_management$1bar_0 = (com.liferay.frontend.taglib.servlet.taglib.ManagementBarTag) _jspx_tagPool_liferay$1frontend_management$1bar.get(com.liferay.frontend.taglib.servlet.taglib.ManagementBarTag.class);
        _jspx_th_liferay$1frontend_management$1bar_0.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1frontend_management$1bar_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
        int _jspx_eval_liferay$1frontend_management$1bar_0 = _jspx_th_liferay$1frontend_management$1bar_0.doStartTag();
        if (_jspx_eval_liferay$1frontend_management$1bar_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          if (_jspx_eval_liferay$1frontend_management$1bar_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.pushBody();
            _jspx_th_liferay$1frontend_management$1bar_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
            _jspx_th_liferay$1frontend_management$1bar_0.doInitBody();
          }
          do {
            out.write("\n\t\t");
            //  liferay-frontend:management-bar-buttons
            com.liferay.frontend.taglib.servlet.taglib.ManagementBarButtonsTag _jspx_th_liferay$1frontend_management$1bar$1buttons_0 = (com.liferay.frontend.taglib.servlet.taglib.ManagementBarButtonsTag) _jspx_tagPool_liferay$1frontend_management$1bar$1buttons.get(com.liferay.frontend.taglib.servlet.taglib.ManagementBarButtonsTag.class);
            _jspx_th_liferay$1frontend_management$1bar$1buttons_0.setPageContext(_jspx_page_context);
            _jspx_th_liferay$1frontend_management$1bar$1buttons_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_management$1bar_0);
            int _jspx_eval_liferay$1frontend_management$1bar$1buttons_0 = _jspx_th_liferay$1frontend_management$1bar$1buttons_0.doStartTag();
            if (_jspx_eval_liferay$1frontend_management$1bar$1buttons_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              if (_jspx_eval_liferay$1frontend_management$1bar$1buttons_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                out = _jspx_page_context.pushBody();
                _jspx_th_liferay$1frontend_management$1bar$1buttons_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                _jspx_th_liferay$1frontend_management$1bar$1buttons_0.doInitBody();
              }
              do {
                out.write("\n\t\t\t");
                //  liferay-frontend:management-bar-display-buttons
                com.liferay.frontend.taglib.servlet.taglib.ManagementBarDisplayButtonsTag _jspx_th_liferay$1frontend_management$1bar$1display$1buttons_0 = (com.liferay.frontend.taglib.servlet.taglib.ManagementBarDisplayButtonsTag) _jspx_tagPool_liferay$1frontend_management$1bar$1display$1buttons_selectedDisplayStyle_portletURL_displayViews_nobody.get(com.liferay.frontend.taglib.servlet.taglib.ManagementBarDisplayButtonsTag.class);
                _jspx_th_liferay$1frontend_management$1bar$1display$1buttons_0.setPageContext(_jspx_page_context);
                _jspx_th_liferay$1frontend_management$1bar$1display$1buttons_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_management$1bar$1buttons_0);
                _jspx_th_liferay$1frontend_management$1bar$1display$1buttons_0.setDisplayViews( new String[] {"icon", "descriptive", "list"} );
                _jspx_th_liferay$1frontend_management$1bar$1display$1buttons_0.setPortletURL( PortletURLUtil.clone(portletURL, renderResponse) );
                _jspx_th_liferay$1frontend_management$1bar$1display$1buttons_0.setSelectedDisplayStyle( displayStyle );
                int _jspx_eval_liferay$1frontend_management$1bar$1display$1buttons_0 = _jspx_th_liferay$1frontend_management$1bar$1display$1buttons_0.doStartTag();
                if (_jspx_th_liferay$1frontend_management$1bar$1display$1buttons_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_liferay$1frontend_management$1bar$1display$1buttons_selectedDisplayStyle_portletURL_displayViews_nobody.reuse(_jspx_th_liferay$1frontend_management$1bar$1display$1buttons_0);
                  return;
                }
                _jspx_tagPool_liferay$1frontend_management$1bar$1display$1buttons_selectedDisplayStyle_portletURL_displayViews_nobody.reuse(_jspx_th_liferay$1frontend_management$1bar$1display$1buttons_0);
                out.write("\n\t\t");
                int evalDoAfterBody = _jspx_th_liferay$1frontend_management$1bar$1buttons_0.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
              if (_jspx_eval_liferay$1frontend_management$1bar$1buttons_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                out = _jspx_page_context.popBody();
            }
            if (_jspx_th_liferay$1frontend_management$1bar$1buttons_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_liferay$1frontend_management$1bar$1buttons.reuse(_jspx_th_liferay$1frontend_management$1bar$1buttons_0);
              return;
            }
            _jspx_tagPool_liferay$1frontend_management$1bar$1buttons.reuse(_jspx_th_liferay$1frontend_management$1bar$1buttons_0);
            out.write("\n\n\t\t");
            //  liferay-frontend:management-bar-filters
            com.liferay.frontend.taglib.servlet.taglib.ManagementBarFiltersTag _jspx_th_liferay$1frontend_management$1bar$1filters_0 = (com.liferay.frontend.taglib.servlet.taglib.ManagementBarFiltersTag) _jspx_tagPool_liferay$1frontend_management$1bar$1filters.get(com.liferay.frontend.taglib.servlet.taglib.ManagementBarFiltersTag.class);
            _jspx_th_liferay$1frontend_management$1bar$1filters_0.setPageContext(_jspx_page_context);
            _jspx_th_liferay$1frontend_management$1bar$1filters_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_management$1bar_0);
            int _jspx_eval_liferay$1frontend_management$1bar$1filters_0 = _jspx_th_liferay$1frontend_management$1bar$1filters_0.doStartTag();
            if (_jspx_eval_liferay$1frontend_management$1bar$1filters_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              if (_jspx_eval_liferay$1frontend_management$1bar$1filters_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                out = _jspx_page_context.pushBody();
                _jspx_th_liferay$1frontend_management$1bar$1filters_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                _jspx_th_liferay$1frontend_management$1bar$1filters_0.doInitBody();
              }
              do {
                out.write("\n\t\t\t");
                //  liferay-frontend:management-bar-navigation
                com.liferay.frontend.taglib.servlet.taglib.ManagementBarNavigationTag _jspx_th_liferay$1frontend_management$1bar$1navigation_0 = (com.liferay.frontend.taglib.servlet.taglib.ManagementBarNavigationTag) _jspx_tagPool_liferay$1frontend_management$1bar$1navigation_portletURL_navigationKeys_nobody.get(com.liferay.frontend.taglib.servlet.taglib.ManagementBarNavigationTag.class);
                _jspx_th_liferay$1frontend_management$1bar$1navigation_0.setPageContext(_jspx_page_context);
                _jspx_th_liferay$1frontend_management$1bar$1navigation_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_management$1bar$1filters_0);
                _jspx_th_liferay$1frontend_management$1bar$1navigation_0.setNavigationKeys( new String[] {"all"} );
                _jspx_th_liferay$1frontend_management$1bar$1navigation_0.setPortletURL( PortletURLUtil.clone(portletURL, renderResponse) );
                int _jspx_eval_liferay$1frontend_management$1bar$1navigation_0 = _jspx_th_liferay$1frontend_management$1bar$1navigation_0.doStartTag();
                if (_jspx_th_liferay$1frontend_management$1bar$1navigation_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_liferay$1frontend_management$1bar$1navigation_portletURL_navigationKeys_nobody.reuse(_jspx_th_liferay$1frontend_management$1bar$1navigation_0);
                  return;
                }
                _jspx_tagPool_liferay$1frontend_management$1bar$1navigation_portletURL_navigationKeys_nobody.reuse(_jspx_th_liferay$1frontend_management$1bar$1navigation_0);
                out.write("\n\n\t\t\t<li>\n\t\t\t\t");
                //  aui:form
                com.liferay.taglib.aui.FormTag _jspx_th_aui_form_0 = (com.liferay.taglib.aui.FormTag) _jspx_tagPool_aui_form_name_action.get(com.liferay.taglib.aui.FormTag.class);
                _jspx_th_aui_form_0.setPageContext(_jspx_page_context);
                _jspx_th_aui_form_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_management$1bar$1filters_0);
                _jspx_th_aui_form_0.setAction( portletURL.toString() );
                _jspx_th_aui_form_0.setName("searchFm");
                int _jspx_eval_aui_form_0 = _jspx_th_aui_form_0.doStartTag();
                if (_jspx_eval_aui_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\t\t\t\t\t");
                  if (_jspx_meth_liferay$1ui_input$1search_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
                    return;
                  out.write("\n\t\t\t\t");
                }
                if (_jspx_th_aui_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_aui_form_name_action.reuse(_jspx_th_aui_form_0);
                  return;
                }
                _jspx_tagPool_aui_form_name_action.reuse(_jspx_th_aui_form_0);
                out.write("\n\t\t\t</li>\n\t\t");
                int evalDoAfterBody = _jspx_th_liferay$1frontend_management$1bar$1filters_0.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
              if (_jspx_eval_liferay$1frontend_management$1bar$1filters_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                out = _jspx_page_context.popBody();
            }
            if (_jspx_th_liferay$1frontend_management$1bar$1filters_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_liferay$1frontend_management$1bar$1filters.reuse(_jspx_th_liferay$1frontend_management$1bar$1filters_0);
              return;
            }
            _jspx_tagPool_liferay$1frontend_management$1bar$1filters.reuse(_jspx_th_liferay$1frontend_management$1bar$1filters_0);
            out.write('\n');
            out.write('	');
            int evalDoAfterBody = _jspx_th_liferay$1frontend_management$1bar_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_liferay$1frontend_management$1bar_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
            out = _jspx_page_context.popBody();
        }
        if (_jspx_th_liferay$1frontend_management$1bar_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1frontend_management$1bar.reuse(_jspx_th_liferay$1frontend_management$1bar_0);
          return;
        }
        _jspx_tagPool_liferay$1frontend_management$1bar.reuse(_jspx_th_liferay$1frontend_management$1bar_0);
        out.write('\n');
      }
      if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      out.write('\n');
      out.write('\n');
      //  aui:form
      com.liferay.taglib.aui.FormTag _jspx_th_aui_form_1 = (com.liferay.taglib.aui.FormTag) _jspx_tagPool_aui_form_name_method_cssClass_action.get(com.liferay.taglib.aui.FormTag.class);
      _jspx_th_aui_form_1.setPageContext(_jspx_page_context);
      _jspx_th_aui_form_1.setParent(null);
      _jspx_th_aui_form_1.setAction( portletURL.toString() );
      _jspx_th_aui_form_1.setCssClass("container-fluid-1280");
      _jspx_th_aui_form_1.setMethod("post");
      _jspx_th_aui_form_1.setName("selectRuleGroupFm");
      int _jspx_eval_aui_form_1 = _jspx_th_aui_form_1.doStartTag();
      if (_jspx_eval_aui_form_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write('\n');
        out.write('	');
        //  liferay-ui:search-container
        com.liferay.taglib.ui.SearchContainerTag _jspx_th_liferay$1ui_search$1container_0 = (com.liferay.taglib.ui.SearchContainerTag) _jspx_tagPool_liferay$1ui_search$1container_searchContainer.get(com.liferay.taglib.ui.SearchContainerTag.class);
        _jspx_th_liferay$1ui_search$1container_0.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_search$1container_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_1);
        _jspx_th_liferay$1ui_search$1container_0.setSearchContainer( ruleGroupSearch );
        int _jspx_eval_liferay$1ui_search$1container_0 = _jspx_th_liferay$1ui_search$1container_0.doStartTag();
        if (_jspx_eval_liferay$1ui_search$1container_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          java.lang.Integer total = null;
          com.liferay.portal.kernel.dao.search.SearchContainer searchContainer = null;
          total = (java.lang.Integer) _jspx_page_context.findAttribute("total");
          searchContainer = (com.liferay.portal.kernel.dao.search.SearchContainer) _jspx_page_context.findAttribute("searchContainer");
          out.write("\n\t\t");
          //  liferay-ui:search-container-row
          com.liferay.taglib.ui.SearchContainerRowTag _jspx_th_liferay$1ui_search$1container$1row_0 = (com.liferay.taglib.ui.SearchContainerRowTag) _jspx_tagPool_liferay$1ui_search$1container$1row_modelVar_keyProperty_escapedModel_className.get(com.liferay.taglib.ui.SearchContainerRowTag.class);
          _jspx_th_liferay$1ui_search$1container$1row_0.setPageContext(_jspx_page_context);
          _jspx_th_liferay$1ui_search$1container$1row_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container_0);
          _jspx_th_liferay$1ui_search$1container$1row_0.setClassName("com.liferay.mobile.device.rules.model.MDRRuleGroup");
          _jspx_th_liferay$1ui_search$1container$1row_0.setEscapedModel( true );
          _jspx_th_liferay$1ui_search$1container$1row_0.setKeyProperty("ruleGroupId");
          _jspx_th_liferay$1ui_search$1container$1row_0.setModelVar("ruleGroup");
          int _jspx_eval_liferay$1ui_search$1container$1row_0 = _jspx_th_liferay$1ui_search$1container$1row_0.doStartTag();
          if (_jspx_eval_liferay$1ui_search$1container$1row_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            java.lang.Integer index = null;
            com.liferay.mobile.device.rules.model.MDRRuleGroup ruleGroup = null;
            com.liferay.portal.kernel.dao.search.ResultRow row = null;
            if (_jspx_eval_liferay$1ui_search$1container$1row_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_liferay$1ui_search$1container$1row_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_liferay$1ui_search$1container$1row_0.doInitBody();
            }
            index = (java.lang.Integer) _jspx_page_context.findAttribute("index");
            ruleGroup = (com.liferay.mobile.device.rules.model.MDRRuleGroup) _jspx_page_context.findAttribute("ruleGroup");
            row = (com.liferay.portal.kernel.dao.search.ResultRow) _jspx_page_context.findAttribute("row");
            do {
              out.write("\n\n\t\t\t");

			MDRRuleGroupInstance ruleGroupInstance = MDRRuleGroupInstanceLocalServiceUtil.fetchRuleGroupInstance(className, classPK, ruleGroup.getRuleGroupId());

			Map<String, Object> data = new HashMap<String, Object>();

			data.put("rulegroupid", ruleGroup.getRuleGroupId());
			data.put("rulegroupname", ruleGroup.getName());
			
              out.write("\n\n\t\t\t");
              //  c:choose
              com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_0 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
              _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
              _jspx_th_c_choose_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container$1row_0);
              int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
              if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                out.write("\n\t\t\t\t");
                //  c:when
                com.liferay.taglib.core.WhenTag _jspx_th_c_when_0 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                _jspx_th_c_when_0.setPageContext(_jspx_page_context);
                _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
                _jspx_th_c_when_0.setTest( displayStyle.equals("descriptive") );
                int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
                if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\t\t\t\t\t");
                  if (_jspx_meth_liferay$1ui_search$1container$1column$1icon_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_0, _jspx_page_context))
                    return;
                  out.write("\n\n\t\t\t\t\t");
                  //  liferay-ui:search-container-column-text
                  com.liferay.taglib.ui.SearchContainerColumnTextTag _jspx_th_liferay$1ui_search$1container$1column$1text_0 = (com.liferay.taglib.ui.SearchContainerColumnTextTag) _jspx_tagPool_liferay$1ui_search$1container$1column$1text_colspan.get(com.liferay.taglib.ui.SearchContainerColumnTextTag.class);
                  _jspx_th_liferay$1ui_search$1container$1column$1text_0.setPageContext(_jspx_page_context);
                  _jspx_th_liferay$1ui_search$1container$1column$1text_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
                  _jspx_th_liferay$1ui_search$1container$1column$1text_0.setColspan( 2 );
                  int _jspx_eval_liferay$1ui_search$1container$1column$1text_0 = _jspx_th_liferay$1ui_search$1container$1column$1text_0.doStartTag();
                  if (_jspx_eval_liferay$1ui_search$1container$1column$1text_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    if (_jspx_eval_liferay$1ui_search$1container$1column$1text_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_liferay$1ui_search$1container$1column$1text_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_liferay$1ui_search$1container$1column$1text_0.doInitBody();
                    }
                    do {
                      out.write("\n\t\t\t\t\t\t<h5>\n\t\t\t\t\t\t\t");
                      //  c:choose
                      com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_1 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
                      _jspx_th_c_choose_1.setPageContext(_jspx_page_context);
                      _jspx_th_c_choose_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container$1column$1text_0);
                      int _jspx_eval_c_choose_1 = _jspx_th_c_choose_1.doStartTag();
                      if (_jspx_eval_c_choose_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        out.write("\n\t\t\t\t\t\t\t\t");
                        //  c:when
                        com.liferay.taglib.core.WhenTag _jspx_th_c_when_1 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                        _jspx_th_c_when_1.setPageContext(_jspx_page_context);
                        _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
                        _jspx_th_c_when_1.setTest( ruleGroupInstance == null );
                        int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
                        if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                          out.write("\n\t\t\t\t\t\t\t\t\t");
                          //  aui:a
                          com.liferay.taglib.aui.ATag _jspx_th_aui_a_0 = (com.liferay.taglib.aui.ATag) _jspx_tagPool_aui_a_href_data_cssClass.get(com.liferay.taglib.aui.ATag.class);
                          _jspx_th_aui_a_0.setPageContext(_jspx_page_context);
                          _jspx_th_aui_a_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_1);
                          _jspx_th_aui_a_0.setCssClass("selector-button");
                          _jspx_th_aui_a_0.setData( data );
                          _jspx_th_aui_a_0.setHref("javascript:;");
                          int _jspx_eval_aui_a_0 = _jspx_th_aui_a_0.doStartTag();
                          if (_jspx_eval_aui_a_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                            out.write("\n\t\t\t\t\t\t\t\t\t\t");
                            out.print( ruleGroup.getName(locale) );
                            out.write("\n\t\t\t\t\t\t\t\t\t");
                          }
                          if (_jspx_th_aui_a_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                            _jspx_tagPool_aui_a_href_data_cssClass.reuse(_jspx_th_aui_a_0);
                            return;
                          }
                          _jspx_tagPool_aui_a_href_data_cssClass.reuse(_jspx_th_aui_a_0);
                          out.write("\n\t\t\t\t\t\t\t\t");
                        }
                        if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                          _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
                          return;
                        }
                        _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
                        out.write("\n\t\t\t\t\t\t\t\t");
                        //  c:otherwise
                        com.liferay.taglib.core.OtherwiseTag _jspx_th_c_otherwise_0 = (com.liferay.taglib.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(com.liferay.taglib.core.OtherwiseTag.class);
                        _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
                        _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
                        int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
                        if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                          out.write("\n\t\t\t\t\t\t\t\t\t");
                          out.print( ruleGroup.getName(locale) );
                          out.write("\n\t\t\t\t\t\t\t\t");
                        }
                        if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                          _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
                          return;
                        }
                        _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
                        out.write("\n\t\t\t\t\t\t\t");
                      }
                      if (_jspx_th_c_choose_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
                        return;
                      }
                      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
                      out.write("\n\t\t\t\t\t\t</h5>\n\n\t\t\t\t\t\t<h6 class=\"text-default\">\n\t\t\t\t\t\t\t");
                      out.print( ruleGroup.getDescription(locale) );
                      out.write("\n\t\t\t\t\t\t</h6>\n\t\t\t\t\t");
                      int evalDoAfterBody = _jspx_th_liferay$1ui_search$1container$1column$1text_0.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_liferay$1ui_search$1container$1column$1text_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                      out = _jspx_page_context.popBody();
                  }
                  if (_jspx_th_liferay$1ui_search$1container$1column$1text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_liferay$1ui_search$1container$1column$1text_colspan.reuse(_jspx_th_liferay$1ui_search$1container$1column$1text_0);
                    return;
                  }
                  _jspx_tagPool_liferay$1ui_search$1container$1column$1text_colspan.reuse(_jspx_th_liferay$1ui_search$1container$1column$1text_0);
                  out.write("\n\t\t\t\t");
                }
                if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
                  return;
                }
                _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
                out.write("\n\t\t\t\t");
                //  c:when
                com.liferay.taglib.core.WhenTag _jspx_th_c_when_2 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                _jspx_th_c_when_2.setPageContext(_jspx_page_context);
                _jspx_th_c_when_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
                _jspx_th_c_when_2.setTest( displayStyle.equals("icon") );
                int _jspx_eval_c_when_2 = _jspx_th_c_when_2.doStartTag();
                if (_jspx_eval_c_when_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\n\t\t\t\t\t");

					row.setCssClass("entry-card lfr-asset-item");
					
                  out.write("\n\n\t\t\t\t\t");
                  //  liferay-ui:search-container-column-text
                  com.liferay.taglib.ui.SearchContainerColumnTextTag _jspx_th_liferay$1ui_search$1container$1column$1text_1 = (com.liferay.taglib.ui.SearchContainerColumnTextTag) _jspx_tagPool_liferay$1ui_search$1container$1column$1text.get(com.liferay.taglib.ui.SearchContainerColumnTextTag.class);
                  _jspx_th_liferay$1ui_search$1container$1column$1text_1.setPageContext(_jspx_page_context);
                  _jspx_th_liferay$1ui_search$1container$1column$1text_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_2);
                  int _jspx_eval_liferay$1ui_search$1container$1column$1text_1 = _jspx_th_liferay$1ui_search$1container$1column$1text_1.doStartTag();
                  if (_jspx_eval_liferay$1ui_search$1container$1column$1text_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    if (_jspx_eval_liferay$1ui_search$1container$1column$1text_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_liferay$1ui_search$1container$1column$1text_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_liferay$1ui_search$1container$1column$1text_1.doInitBody();
                    }
                    do {
                      out.write("\n\t\t\t\t\t\t");
                      //  liferay-frontend:icon-vertical-card
                      com.liferay.frontend.taglib.servlet.taglib.IconVerticalCardTag _jspx_th_liferay$1frontend_icon$1vertical$1card_0 = (com.liferay.frontend.taglib.servlet.taglib.IconVerticalCardTag) _jspx_tagPool_liferay$1frontend_icon$1vertical$1card_title_subtitle_icon_data_cssClass_nobody.get(com.liferay.frontend.taglib.servlet.taglib.IconVerticalCardTag.class);
                      _jspx_th_liferay$1frontend_icon$1vertical$1card_0.setPageContext(_jspx_page_context);
                      _jspx_th_liferay$1frontend_icon$1vertical$1card_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container$1column$1text_1);
                      _jspx_th_liferay$1frontend_icon$1vertical$1card_0.setCssClass( (ruleGroupInstance == null) ? "selector-button" : StringPool.BLANK );
                      _jspx_th_liferay$1frontend_icon$1vertical$1card_0.setData( data );
                      _jspx_th_liferay$1frontend_icon$1vertical$1card_0.setIcon("mobile-portrait");
                      _jspx_th_liferay$1frontend_icon$1vertical$1card_0.setSubtitle( ruleGroup.getDescription(locale) );
                      _jspx_th_liferay$1frontend_icon$1vertical$1card_0.setTitle( ruleGroup.getName(locale) );
                      int _jspx_eval_liferay$1frontend_icon$1vertical$1card_0 = _jspx_th_liferay$1frontend_icon$1vertical$1card_0.doStartTag();
                      if (_jspx_th_liferay$1frontend_icon$1vertical$1card_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_liferay$1frontend_icon$1vertical$1card_title_subtitle_icon_data_cssClass_nobody.reuse(_jspx_th_liferay$1frontend_icon$1vertical$1card_0);
                        return;
                      }
                      _jspx_tagPool_liferay$1frontend_icon$1vertical$1card_title_subtitle_icon_data_cssClass_nobody.reuse(_jspx_th_liferay$1frontend_icon$1vertical$1card_0);
                      out.write("\n\t\t\t\t\t");
                      int evalDoAfterBody = _jspx_th_liferay$1ui_search$1container$1column$1text_1.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_liferay$1ui_search$1container$1column$1text_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                      out = _jspx_page_context.popBody();
                  }
                  if (_jspx_th_liferay$1ui_search$1container$1column$1text_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_liferay$1ui_search$1container$1column$1text.reuse(_jspx_th_liferay$1ui_search$1container$1column$1text_1);
                    return;
                  }
                  _jspx_tagPool_liferay$1ui_search$1container$1column$1text.reuse(_jspx_th_liferay$1ui_search$1container$1column$1text_1);
                  out.write("\n\t\t\t\t");
                }
                if (_jspx_th_c_when_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_2);
                  return;
                }
                _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_2);
                out.write("\n\t\t\t\t");
                //  c:when
                com.liferay.taglib.core.WhenTag _jspx_th_c_when_3 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                _jspx_th_c_when_3.setPageContext(_jspx_page_context);
                _jspx_th_c_when_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
                _jspx_th_c_when_3.setTest( displayStyle.equals("list") );
                int _jspx_eval_c_when_3 = _jspx_th_c_when_3.doStartTag();
                if (_jspx_eval_c_when_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\t\t\t\t\t");
                  //  liferay-ui:search-container-column-text
                  com.liferay.taglib.ui.SearchContainerColumnTextTag _jspx_th_liferay$1ui_search$1container$1column$1text_2 = (com.liferay.taglib.ui.SearchContainerColumnTextTag) _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name_cssClass.get(com.liferay.taglib.ui.SearchContainerColumnTextTag.class);
                  _jspx_th_liferay$1ui_search$1container$1column$1text_2.setPageContext(_jspx_page_context);
                  _jspx_th_liferay$1ui_search$1container$1column$1text_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_3);
                  _jspx_th_liferay$1ui_search$1container$1column$1text_2.setCssClass("table-cell-content");
                  _jspx_th_liferay$1ui_search$1container$1column$1text_2.setName("name");
                  int _jspx_eval_liferay$1ui_search$1container$1column$1text_2 = _jspx_th_liferay$1ui_search$1container$1column$1text_2.doStartTag();
                  if (_jspx_eval_liferay$1ui_search$1container$1column$1text_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    if (_jspx_eval_liferay$1ui_search$1container$1column$1text_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_liferay$1ui_search$1container$1column$1text_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_liferay$1ui_search$1container$1column$1text_2.doInitBody();
                    }
                    do {
                      out.write("\n\t\t\t\t\t\t");
                      //  c:choose
                      com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_2 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
                      _jspx_th_c_choose_2.setPageContext(_jspx_page_context);
                      _jspx_th_c_choose_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container$1column$1text_2);
                      int _jspx_eval_c_choose_2 = _jspx_th_c_choose_2.doStartTag();
                      if (_jspx_eval_c_choose_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        out.write("\n\t\t\t\t\t\t\t");
                        //  c:when
                        com.liferay.taglib.core.WhenTag _jspx_th_c_when_4 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                        _jspx_th_c_when_4.setPageContext(_jspx_page_context);
                        _jspx_th_c_when_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_2);
                        _jspx_th_c_when_4.setTest( ruleGroupInstance == null );
                        int _jspx_eval_c_when_4 = _jspx_th_c_when_4.doStartTag();
                        if (_jspx_eval_c_when_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                          out.write("\n\t\t\t\t\t\t\t\t");
                          //  aui:a
                          com.liferay.taglib.aui.ATag _jspx_th_aui_a_1 = (com.liferay.taglib.aui.ATag) _jspx_tagPool_aui_a_href_data_cssClass.get(com.liferay.taglib.aui.ATag.class);
                          _jspx_th_aui_a_1.setPageContext(_jspx_page_context);
                          _jspx_th_aui_a_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_4);
                          _jspx_th_aui_a_1.setCssClass("selector-button");
                          _jspx_th_aui_a_1.setData( data );
                          _jspx_th_aui_a_1.setHref("javascript:;");
                          int _jspx_eval_aui_a_1 = _jspx_th_aui_a_1.doStartTag();
                          if (_jspx_eval_aui_a_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                            out.write("\n\t\t\t\t\t\t\t\t\t");
                            out.print( ruleGroup.getName(locale) );
                            out.write("\n\t\t\t\t\t\t\t\t");
                          }
                          if (_jspx_th_aui_a_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                            _jspx_tagPool_aui_a_href_data_cssClass.reuse(_jspx_th_aui_a_1);
                            return;
                          }
                          _jspx_tagPool_aui_a_href_data_cssClass.reuse(_jspx_th_aui_a_1);
                          out.write("\n\t\t\t\t\t\t\t");
                        }
                        if (_jspx_th_c_when_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                          _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_4);
                          return;
                        }
                        _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_4);
                        out.write("\n\t\t\t\t\t\t\t");
                        //  c:otherwise
                        com.liferay.taglib.core.OtherwiseTag _jspx_th_c_otherwise_1 = (com.liferay.taglib.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(com.liferay.taglib.core.OtherwiseTag.class);
                        _jspx_th_c_otherwise_1.setPageContext(_jspx_page_context);
                        _jspx_th_c_otherwise_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_2);
                        int _jspx_eval_c_otherwise_1 = _jspx_th_c_otherwise_1.doStartTag();
                        if (_jspx_eval_c_otherwise_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                          out.write("\n\t\t\t\t\t\t\t\t");
                          out.print( ruleGroup.getName(locale) );
                          out.write("\n\t\t\t\t\t\t\t");
                        }
                        if (_jspx_th_c_otherwise_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                          _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_1);
                          return;
                        }
                        _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_1);
                        out.write("\n\t\t\t\t\t\t");
                      }
                      if (_jspx_th_c_choose_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_2);
                        return;
                      }
                      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_2);
                      out.write("\n\t\t\t\t\t");
                      int evalDoAfterBody = _jspx_th_liferay$1ui_search$1container$1column$1text_2.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_liferay$1ui_search$1container$1column$1text_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                      out = _jspx_page_context.popBody();
                  }
                  if (_jspx_th_liferay$1ui_search$1container$1column$1text_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name_cssClass.reuse(_jspx_th_liferay$1ui_search$1container$1column$1text_2);
                    return;
                  }
                  _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name_cssClass.reuse(_jspx_th_liferay$1ui_search$1container$1column$1text_2);
                  out.write("\n\n\t\t\t\t\t");
                  //  liferay-ui:search-container-column-text
                  com.liferay.taglib.ui.SearchContainerColumnTextTag _jspx_th_liferay$1ui_search$1container$1column$1text_3 = (com.liferay.taglib.ui.SearchContainerColumnTextTag) _jspx_tagPool_liferay$1ui_search$1container$1column$1text_value_name_cssClass_nobody.get(com.liferay.taglib.ui.SearchContainerColumnTextTag.class);
                  _jspx_th_liferay$1ui_search$1container$1column$1text_3.setPageContext(_jspx_page_context);
                  _jspx_th_liferay$1ui_search$1container$1column$1text_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_3);
                  _jspx_th_liferay$1ui_search$1container$1column$1text_3.setCssClass("table-cell-content");
                  _jspx_th_liferay$1ui_search$1container$1column$1text_3.setName("description");
                  _jspx_th_liferay$1ui_search$1container$1column$1text_3.setValue( ruleGroup.getDescription(locale) );
                  int _jspx_eval_liferay$1ui_search$1container$1column$1text_3 = _jspx_th_liferay$1ui_search$1container$1column$1text_3.doStartTag();
                  if (_jspx_th_liferay$1ui_search$1container$1column$1text_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_liferay$1ui_search$1container$1column$1text_value_name_cssClass_nobody.reuse(_jspx_th_liferay$1ui_search$1container$1column$1text_3);
                    return;
                  }
                  _jspx_tagPool_liferay$1ui_search$1container$1column$1text_value_name_cssClass_nobody.reuse(_jspx_th_liferay$1ui_search$1container$1column$1text_3);
                  out.write("\n\t\t\t\t");
                }
                if (_jspx_th_c_when_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_3);
                  return;
                }
                _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_3);
                out.write("\n\t\t\t");
              }
              if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
                return;
              }
              _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
              out.write("\n\t\t");
              int evalDoAfterBody = _jspx_th_liferay$1ui_search$1container$1row_0.doAfterBody();
              index = (java.lang.Integer) _jspx_page_context.findAttribute("index");
              ruleGroup = (com.liferay.mobile.device.rules.model.MDRRuleGroup) _jspx_page_context.findAttribute("ruleGroup");
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
          out.write("\n\n\t\t");
          //  liferay-ui:search-iterator
          com.liferay.taglib.ui.SearchIteratorTag _jspx_th_liferay$1ui_search$1iterator_0 = (com.liferay.taglib.ui.SearchIteratorTag) _jspx_tagPool_liferay$1ui_search$1iterator_type_markupView_displayStyle_nobody.get(com.liferay.taglib.ui.SearchIteratorTag.class);
          _jspx_th_liferay$1ui_search$1iterator_0.setPageContext(_jspx_page_context);
          _jspx_th_liferay$1ui_search$1iterator_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container_0);
          _jspx_th_liferay$1ui_search$1iterator_0.setDisplayStyle( displayStyle );
          _jspx_th_liferay$1ui_search$1iterator_0.setMarkupView("lexicon");
          _jspx_th_liferay$1ui_search$1iterator_0.setType("more");
          int _jspx_eval_liferay$1ui_search$1iterator_0 = _jspx_th_liferay$1ui_search$1iterator_0.doStartTag();
          if (_jspx_th_liferay$1ui_search$1iterator_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_liferay$1ui_search$1iterator_type_markupView_displayStyle_nobody.reuse(_jspx_th_liferay$1ui_search$1iterator_0);
            return;
          }
          _jspx_tagPool_liferay$1ui_search$1iterator_type_markupView_displayStyle_nobody.reuse(_jspx_th_liferay$1ui_search$1iterator_0);
          out.write('\n');
          out.write('	');
        }
        if (_jspx_th_liferay$1ui_search$1container_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_search$1container_searchContainer.reuse(_jspx_th_liferay$1ui_search$1container_0);
          return;
        }
        _jspx_tagPool_liferay$1ui_search$1container_searchContainer.reuse(_jspx_th_liferay$1ui_search$1container_0);
        out.write('\n');
      }
      if (_jspx_th_aui_form_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_form_name_method_cssClass_action.reuse(_jspx_th_aui_form_1);
        return;
      }
      _jspx_tagPool_aui_form_name_method_cssClass_action.reuse(_jspx_th_aui_form_1);
      out.write('\n');
      out.write('\n');
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
          out.write("\n\tLiferay.Util.selectEntityHandler('#");
          if (_jspx_meth_portlet_namespace_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_0, _jspx_page_context))
            return;
          out.write("selectRuleGroupFm', '");
          out.print( HtmlUtil.escapeJS(eventName) );
          out.write("');\n");
          int evalDoAfterBody = _jspx_th_aui_script_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_aui_script_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
      }
      if (_jspx_th_aui_script_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_script.reuse(_jspx_th_aui_script_0);
        return;
      }
      _jspx_tagPool_aui_script.reuse(_jspx_th_aui_script_0);
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

  private boolean _jspx_meth_liferay$1ui_input$1search_0(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:input-search
    com.liferay.taglib.ui.InputSearchTag _jspx_th_liferay$1ui_input$1search_0 = (com.liferay.taglib.ui.InputSearchTag) _jspx_tagPool_liferay$1ui_input$1search_markupView_nobody.get(com.liferay.taglib.ui.InputSearchTag.class);
    _jspx_th_liferay$1ui_input$1search_0.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_input$1search_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    _jspx_th_liferay$1ui_input$1search_0.setMarkupView("lexicon");
    int _jspx_eval_liferay$1ui_input$1search_0 = _jspx_th_liferay$1ui_input$1search_0.doStartTag();
    if (_jspx_th_liferay$1ui_input$1search_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_input$1search_markupView_nobody.reuse(_jspx_th_liferay$1ui_input$1search_0);
      return true;
    }
    _jspx_tagPool_liferay$1ui_input$1search_markupView_nobody.reuse(_jspx_th_liferay$1ui_input$1search_0);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_search$1container$1column$1icon_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:search-container-column-icon
    com.liferay.taglib.ui.SearchContainerColumnIconTag _jspx_th_liferay$1ui_search$1container$1column$1icon_0 = (com.liferay.taglib.ui.SearchContainerColumnIconTag) _jspx_tagPool_liferay$1ui_search$1container$1column$1icon_icon_nobody.get(com.liferay.taglib.ui.SearchContainerColumnIconTag.class);
    _jspx_th_liferay$1ui_search$1container$1column$1icon_0.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_search$1container$1column$1icon_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
    _jspx_th_liferay$1ui_search$1container$1column$1icon_0.setIcon("mobile-portrait");
    int _jspx_eval_liferay$1ui_search$1container$1column$1icon_0 = _jspx_th_liferay$1ui_search$1container$1column$1icon_0.doStartTag();
    if (_jspx_th_liferay$1ui_search$1container$1column$1icon_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_search$1container$1column$1icon_icon_nobody.reuse(_jspx_th_liferay$1ui_search$1container$1column$1icon_0);
      return true;
    }
    _jspx_tagPool_liferay$1ui_search$1container$1column$1icon_icon_nobody.reuse(_jspx_th_liferay$1ui_search$1container$1column$1icon_0);
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
