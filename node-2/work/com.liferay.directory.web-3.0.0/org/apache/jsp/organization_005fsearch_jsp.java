package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPNavigationItemList;
import com.liferay.message.boards.util.MBUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.bean.BeanPropertiesUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.exception.NoSuchOrganizationException;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.EmailAddress;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.OrgLabor;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.OrganizationConstants;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.model.Website;
import com.liferay.portal.kernel.service.AddressServiceUtil;
import com.liferay.portal.kernel.service.CountryServiceUtil;
import com.liferay.portal.kernel.service.EmailAddressServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ListTypeServiceUtil;
import com.liferay.portal.kernel.service.OrgLaborServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationServiceUtil;
import com.liferay.portal.kernel.service.PhoneServiceUtil;
import com.liferay.portal.kernel.service.RegionServiceUtil;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.WebsiteServiceUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.webserver.WebServerServletTokenUtil;
import com.liferay.portal.service.persistence.constants.UserGroupFinderConstants;
import com.liferay.portal.util.PropsValues;
import com.liferay.portlet.usergroupsadmin.search.UserGroupDisplayTerms;
import com.liferay.portlet.usergroupsadmin.search.UserGroupSearch;
import com.liferay.portlet.usersadmin.search.OrganizationDisplayTerms;
import com.liferay.portlet.usersadmin.search.OrganizationSearch;
import com.liferay.portlet.usersadmin.search.OrganizationSearchTerms;
import com.liferay.portlet.usersadmin.search.UserDisplayTerms;
import com.liferay.portlet.usersadmin.search.UserSearch;
import com.liferay.portlet.usersadmin.search.UserSearchTerms;
import com.liferay.sites.kernel.util.SitesUtil;
import com.liferay.social.kernel.model.SocialRelationConstants;
import com.liferay.users.admin.kernel.util.UsersAdmin;
import com.liferay.users.admin.kernel.util.UsersAdminUtil;
import java.text.Format;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import javax.portlet.PortletURL;

public final class organization_005fsearch_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/init.jsp");
    _jspx_dependants.add("/init-ext.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_namespace_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_value_type_size_name_label_inlineField_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_message_key_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_select_name_label_inlineField_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_value_type_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1toggle_markupView_id_displayTerms_buttonLabel;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_value_type_size_name_inlineField_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_select_name_inlineField;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_option_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1theme_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_option_selected_label_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_script_use;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_fieldset;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_portlet_namespace_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_value_type_size_name_label_inlineField_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_message_key_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_select_name_label_inlineField_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_value_type_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1toggle_markupView_id_displayTerms_buttonLabel = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_value_type_size_name_inlineField_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_select_name_inlineField = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_option_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1theme_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_option_selected_label_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_script_use = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_fieldset = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_portlet_namespace_nobody.release();
    _jspx_tagPool_aui_input_value_type_size_name_label_inlineField_nobody.release();
    _jspx_tagPool_liferay$1ui_message_key_nobody.release();
    _jspx_tagPool_aui_select_name_label_inlineField_nobody.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_aui_input_value_type_name_nobody.release();
    _jspx_tagPool_liferay$1ui_search$1toggle_markupView_id_displayTerms_buttonLabel.release();
    _jspx_tagPool_aui_input_value_type_size_name_inlineField_nobody.release();
    _jspx_tagPool_aui_select_name_inlineField.release();
    _jspx_tagPool_portlet_defineObjects_nobody.release();
    _jspx_tagPool_aui_option_value_nobody.release();
    _jspx_tagPool_liferay$1theme_defineObjects_nobody.release();
    _jspx_tagPool_aui_option_selected_label_nobody.release();
    _jspx_tagPool_liferay$1frontend_defineObjects_nobody.release();
    _jspx_tagPool_aui_script_use.release();
    _jspx_tagPool_aui_fieldset.release();
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
      out.write("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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

String tabs1 = ParamUtil.getString(request, "tabs1", "users");

Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale);

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');

PortletURL portletURL = (PortletURL)request.getAttribute("view.jsp-portletURL");

long parentOrganizationId = ParamUtil.getLong(request, "parentOrganizationId", OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID);

if (parentOrganizationId > 0) {
	portletURL.setParameter("parentOrganizationId", String.valueOf(parentOrganizationId));
}

OrganizationSearch searchContainer = new OrganizationSearch(renderRequest, portletURL);

OrganizationDisplayTerms displayTerms = (OrganizationDisplayTerms)searchContainer.getDisplayTerms();

String type = displayTerms.getType();

      out.write('\n');
      out.write('\n');
      //  liferay-ui:search-toggle
      com.liferay.taglib.ui.SearchToggleTag _jspx_th_liferay$1ui_search$1toggle_0 = (com.liferay.taglib.ui.SearchToggleTag) _jspx_tagPool_liferay$1ui_search$1toggle_markupView_id_displayTerms_buttonLabel.get(com.liferay.taglib.ui.SearchToggleTag.class);
      _jspx_th_liferay$1ui_search$1toggle_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1ui_search$1toggle_0.setParent(null);
      _jspx_th_liferay$1ui_search$1toggle_0.setButtonLabel("search");
      _jspx_th_liferay$1ui_search$1toggle_0.setDisplayTerms( displayTerms );
      _jspx_th_liferay$1ui_search$1toggle_0.setId("toggle_id_organization_search");
      _jspx_th_liferay$1ui_search$1toggle_0.setMarkupView("lexicon");
      int _jspx_eval_liferay$1ui_search$1toggle_0 = _jspx_th_liferay$1ui_search$1toggle_0.doStartTag();
      if (_jspx_eval_liferay$1ui_search$1toggle_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write('\n');
        out.write('	');
        //  aui:fieldset
        com.liferay.taglib.aui.FieldsetTag _jspx_th_aui_fieldset_0 = (com.liferay.taglib.aui.FieldsetTag) _jspx_tagPool_aui_fieldset.get(com.liferay.taglib.aui.FieldsetTag.class);
        _jspx_th_aui_fieldset_0.setPageContext(_jspx_page_context);
        _jspx_th_aui_fieldset_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1toggle_0);
        int _jspx_eval_aui_fieldset_0 = _jspx_th_aui_fieldset_0.doStartTag();
        if (_jspx_eval_aui_fieldset_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          out.write("\n\t\t");
          //  aui:input
          com.liferay.taglib.aui.InputTag _jspx_th_aui_input_0 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_size_name_inlineField_nobody.get(com.liferay.taglib.aui.InputTag.class);
          _jspx_th_aui_input_0.setPageContext(_jspx_page_context);
          _jspx_th_aui_input_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_fieldset_0);
          _jspx_th_aui_input_0.setInlineField( true );
          _jspx_th_aui_input_0.setName( OrganizationDisplayTerms.NAME );
          _jspx_th_aui_input_0.setDynamicAttribute(null, "size", new String("20"));
          _jspx_th_aui_input_0.setType("text");
          _jspx_th_aui_input_0.setValue( displayTerms.getName() );
          int _jspx_eval_aui_input_0 = _jspx_th_aui_input_0.doStartTag();
          if (_jspx_th_aui_input_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_aui_input_value_type_size_name_inlineField_nobody.reuse(_jspx_th_aui_input_0);
            return;
          }
          _jspx_tagPool_aui_input_value_type_size_name_inlineField_nobody.reuse(_jspx_th_aui_input_0);
          out.write("\n\n\t\t");
          //  aui:select
          com.liferay.taglib.aui.SelectTag _jspx_th_aui_select_0 = (com.liferay.taglib.aui.SelectTag) _jspx_tagPool_aui_select_name_inlineField.get(com.liferay.taglib.aui.SelectTag.class);
          _jspx_th_aui_select_0.setPageContext(_jspx_page_context);
          _jspx_th_aui_select_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_fieldset_0);
          _jspx_th_aui_select_0.setInlineField( true );
          _jspx_th_aui_select_0.setName( OrganizationDisplayTerms.TYPE );
          int _jspx_eval_aui_select_0 = _jspx_th_aui_select_0.doStartTag();
          if (_jspx_eval_aui_select_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_aui_select_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_aui_select_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_aui_select_0.doInitBody();
            }
            do {
              out.write("\n\t\t\t");
              if (_jspx_meth_aui_option_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_select_0, _jspx_page_context))
                return;
              out.write("\n\n\t\t\t");

			for (String curType : OrganizationLocalServiceUtil.getTypes()) {
			
              out.write("\n\n\t\t\t\t");
              //  aui:option
              com.liferay.taglib.aui.OptionTag _jspx_th_aui_option_1 = (com.liferay.taglib.aui.OptionTag) _jspx_tagPool_aui_option_selected_label_nobody.get(com.liferay.taglib.aui.OptionTag.class);
              _jspx_th_aui_option_1.setPageContext(_jspx_page_context);
              _jspx_th_aui_option_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_select_0);
              _jspx_th_aui_option_1.setLabel( curType );
              _jspx_th_aui_option_1.setSelected( type.equals(curType) );
              int _jspx_eval_aui_option_1 = _jspx_th_aui_option_1.doStartTag();
              if (_jspx_th_aui_option_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_aui_option_selected_label_nobody.reuse(_jspx_th_aui_option_1);
                return;
              }
              _jspx_tagPool_aui_option_selected_label_nobody.reuse(_jspx_th_aui_option_1);
              out.write("\n\n\t\t\t");

			}
			
              out.write("\n\n\t\t");
              int evalDoAfterBody = _jspx_th_aui_select_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_aui_select_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_aui_select_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_aui_select_name_inlineField.reuse(_jspx_th_aui_select_0);
            return;
          }
          _jspx_tagPool_aui_select_name_inlineField.reuse(_jspx_th_aui_select_0);
          out.write("\n\n\t\t");
          //  aui:input
          com.liferay.taglib.aui.InputTag _jspx_th_aui_input_1 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_size_name_inlineField_nobody.get(com.liferay.taglib.aui.InputTag.class);
          _jspx_th_aui_input_1.setPageContext(_jspx_page_context);
          _jspx_th_aui_input_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_fieldset_0);
          _jspx_th_aui_input_1.setInlineField( true );
          _jspx_th_aui_input_1.setName( OrganizationDisplayTerms.STREET );
          _jspx_th_aui_input_1.setDynamicAttribute(null, "size", new String("20"));
          _jspx_th_aui_input_1.setType("text");
          _jspx_th_aui_input_1.setValue( displayTerms.getStreet() );
          int _jspx_eval_aui_input_1 = _jspx_th_aui_input_1.doStartTag();
          if (_jspx_th_aui_input_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_aui_input_value_type_size_name_inlineField_nobody.reuse(_jspx_th_aui_input_1);
            return;
          }
          _jspx_tagPool_aui_input_value_type_size_name_inlineField_nobody.reuse(_jspx_th_aui_input_1);
          out.write('\n');
          out.write('	');
        }
        if (_jspx_th_aui_fieldset_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_fieldset.reuse(_jspx_th_aui_fieldset_0);
          return;
        }
        _jspx_tagPool_aui_fieldset.reuse(_jspx_th_aui_fieldset_0);
        out.write("\n\n\t");
        //  aui:fieldset
        com.liferay.taglib.aui.FieldsetTag _jspx_th_aui_fieldset_1 = (com.liferay.taglib.aui.FieldsetTag) _jspx_tagPool_aui_fieldset.get(com.liferay.taglib.aui.FieldsetTag.class);
        _jspx_th_aui_fieldset_1.setPageContext(_jspx_page_context);
        _jspx_th_aui_fieldset_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1toggle_0);
        int _jspx_eval_aui_fieldset_1 = _jspx_th_aui_fieldset_1.doStartTag();
        if (_jspx_eval_aui_fieldset_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          out.write("\n\t\t");
          //  aui:select
          com.liferay.taglib.aui.SelectTag _jspx_th_aui_select_1 = (com.liferay.taglib.aui.SelectTag) _jspx_tagPool_aui_select_name_label_inlineField_nobody.get(com.liferay.taglib.aui.SelectTag.class);
          _jspx_th_aui_select_1.setPageContext(_jspx_page_context);
          _jspx_th_aui_select_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_fieldset_1);
          _jspx_th_aui_select_1.setInlineField( true );
          _jspx_th_aui_select_1.setLabel("country");
          _jspx_th_aui_select_1.setName( OrganizationDisplayTerms.COUNTRY_ID );
          int _jspx_eval_aui_select_1 = _jspx_th_aui_select_1.doStartTag();
          if (_jspx_th_aui_select_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_aui_select_name_label_inlineField_nobody.reuse(_jspx_th_aui_select_1);
            return;
          }
          _jspx_tagPool_aui_select_name_label_inlineField_nobody.reuse(_jspx_th_aui_select_1);
          out.write("\n\n\t\t");
          //  aui:input
          com.liferay.taglib.aui.InputTag _jspx_th_aui_input_2 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_size_name_inlineField_nobody.get(com.liferay.taglib.aui.InputTag.class);
          _jspx_th_aui_input_2.setPageContext(_jspx_page_context);
          _jspx_th_aui_input_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_fieldset_1);
          _jspx_th_aui_input_2.setInlineField( true );
          _jspx_th_aui_input_2.setName( OrganizationDisplayTerms.CITY );
          _jspx_th_aui_input_2.setDynamicAttribute(null, "size", new String("20"));
          _jspx_th_aui_input_2.setType("text");
          _jspx_th_aui_input_2.setValue( displayTerms.getCity() );
          int _jspx_eval_aui_input_2 = _jspx_th_aui_input_2.doStartTag();
          if (_jspx_th_aui_input_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_aui_input_value_type_size_name_inlineField_nobody.reuse(_jspx_th_aui_input_2);
            return;
          }
          _jspx_tagPool_aui_input_value_type_size_name_inlineField_nobody.reuse(_jspx_th_aui_input_2);
          out.write("\n\n\t\t");
          //  aui:select
          com.liferay.taglib.aui.SelectTag _jspx_th_aui_select_2 = (com.liferay.taglib.aui.SelectTag) _jspx_tagPool_aui_select_name_label_inlineField_nobody.get(com.liferay.taglib.aui.SelectTag.class);
          _jspx_th_aui_select_2.setPageContext(_jspx_page_context);
          _jspx_th_aui_select_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_fieldset_1);
          _jspx_th_aui_select_2.setInlineField( true );
          _jspx_th_aui_select_2.setLabel("region");
          _jspx_th_aui_select_2.setName( OrganizationDisplayTerms.REGION_ID );
          int _jspx_eval_aui_select_2 = _jspx_th_aui_select_2.doStartTag();
          if (_jspx_th_aui_select_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_aui_select_name_label_inlineField_nobody.reuse(_jspx_th_aui_select_2);
            return;
          }
          _jspx_tagPool_aui_select_name_label_inlineField_nobody.reuse(_jspx_th_aui_select_2);
          out.write('\n');
          out.write('	');
        }
        if (_jspx_th_aui_fieldset_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_fieldset.reuse(_jspx_th_aui_fieldset_1);
          return;
        }
        _jspx_tagPool_aui_fieldset.reuse(_jspx_th_aui_fieldset_1);
        out.write("\n\n\t");
        //  aui:fieldset
        com.liferay.taglib.aui.FieldsetTag _jspx_th_aui_fieldset_2 = (com.liferay.taglib.aui.FieldsetTag) _jspx_tagPool_aui_fieldset.get(com.liferay.taglib.aui.FieldsetTag.class);
        _jspx_th_aui_fieldset_2.setPageContext(_jspx_page_context);
        _jspx_th_aui_fieldset_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1toggle_0);
        int _jspx_eval_aui_fieldset_2 = _jspx_th_aui_fieldset_2.doStartTag();
        if (_jspx_eval_aui_fieldset_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          out.write("\n\t\t");
          //  aui:input
          com.liferay.taglib.aui.InputTag _jspx_th_aui_input_3 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_size_name_label_inlineField_nobody.get(com.liferay.taglib.aui.InputTag.class);
          _jspx_th_aui_input_3.setPageContext(_jspx_page_context);
          _jspx_th_aui_input_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_fieldset_2);
          _jspx_th_aui_input_3.setInlineField( true );
          _jspx_th_aui_input_3.setLabel("postal-code");
          _jspx_th_aui_input_3.setName( OrganizationDisplayTerms.ZIP );
          _jspx_th_aui_input_3.setDynamicAttribute(null, "size", new String("20"));
          _jspx_th_aui_input_3.setType("text");
          _jspx_th_aui_input_3.setValue( displayTerms.getZip() );
          int _jspx_eval_aui_input_3 = _jspx_th_aui_input_3.doStartTag();
          if (_jspx_th_aui_input_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_aui_input_value_type_size_name_label_inlineField_nobody.reuse(_jspx_th_aui_input_3);
            return;
          }
          _jspx_tagPool_aui_input_value_type_size_name_label_inlineField_nobody.reuse(_jspx_th_aui_input_3);
          out.write('\n');
          out.write('	');
        }
        if (_jspx_th_aui_fieldset_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_fieldset.reuse(_jspx_th_aui_fieldset_2);
          return;
        }
        _jspx_tagPool_aui_fieldset.reuse(_jspx_th_aui_fieldset_2);
        out.write('\n');
      }
      if (_jspx_th_liferay$1ui_search$1toggle_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1ui_search$1toggle_markupView_id_displayTerms_buttonLabel.reuse(_jspx_th_liferay$1ui_search$1toggle_0);
        return;
      }
      _jspx_tagPool_liferay$1ui_search$1toggle_markupView_id_displayTerms_buttonLabel.reuse(_jspx_th_liferay$1ui_search$1toggle_0);
      out.write('\n');
      out.write('\n');

Organization parentOrganization = null;

if (displayTerms.getParentOrganizationId() > 0) {
	parentOrganization = OrganizationLocalServiceUtil.fetchOrganization(displayTerms.getParentOrganizationId());
}

      out.write('\n');
      out.write('\n');
      //  c:if
      com.liferay.taglib.core.IfTag _jspx_th_c_if_0 = (com.liferay.taglib.core.IfTag) _jspx_tagPool_c_if_test.get(com.liferay.taglib.core.IfTag.class);
      _jspx_th_c_if_0.setPageContext(_jspx_page_context);
      _jspx_th_c_if_0.setParent(null);
      _jspx_th_c_if_0.setTest( parentOrganization != null );
      int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
      if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write('\n');
        out.write('	');
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_4 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_4.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
        _jspx_th_aui_input_4.setName( OrganizationDisplayTerms.PARENT_ORGANIZATION_ID );
        _jspx_th_aui_input_4.setType("hidden");
        _jspx_th_aui_input_4.setValue( parentOrganization.getOrganizationId() );
        int _jspx_eval_aui_input_4 = _jspx_th_aui_input_4.doStartTag();
        if (_jspx_th_aui_input_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_4);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_4);
        out.write("\n\n\t<br />\n\n\t");
        if (_jspx_meth_liferay$1ui_message_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return;
        out.write(':');
        out.write(' ');
        out.print( HtmlUtil.escape(parentOrganization.getName()) );
        out.write("<br />\n");
      }
      if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      out.write('\n');
      out.write('\n');
      //  aui:script
      com.liferay.taglib.aui.ScriptTag _jspx_th_aui_script_0 = (com.liferay.taglib.aui.ScriptTag) _jspx_tagPool_aui_script_use.get(com.liferay.taglib.aui.ScriptTag.class);
      _jspx_th_aui_script_0.setPageContext(_jspx_page_context);
      _jspx_th_aui_script_0.setParent(null);
      _jspx_th_aui_script_0.setUse("liferay-address,liferay-dynamic-select");
      int _jspx_eval_aui_script_0 = _jspx_th_aui_script_0.doStartTag();
      if (_jspx_eval_aui_script_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_aui_script_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_aui_script_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_aui_script_0.doInitBody();
        }
        do {
          out.write("\n\tnew Liferay.DynamicSelect(\n\t\t[\n\t\t\t{\n\t\t\t\tselect: '");
          if (_jspx_meth_portlet_namespace_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_0, _jspx_page_context))
            return;
          out.print( OrganizationDisplayTerms.COUNTRY_ID );
          out.write("',\n\t\t\t\tselectData: Liferay.Address.getCountries,\n\t\t\t\tselectDesc: 'nameCurrentValue',\n\t\t\t\tselectId: 'countryId',\n\t\t\t\tselectSort: '");
          out.print( true );
          out.write("',\n\t\t\t\tselectVal: '");
          out.print( displayTerms.getCountryId() );
          out.write("'\n\t\t\t},\n\t\t\t{\n\t\t\t\tselect: '");
          if (_jspx_meth_portlet_namespace_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_0, _jspx_page_context))
            return;
          out.print( OrganizationDisplayTerms.REGION_ID );
          out.write("',\n\t\t\t\tselectData: Liferay.Address.getRegions,\n\t\t\t\tselectDesc: 'name',\n\t\t\t\tselectId: 'regionId',\n\t\t\t\tselectVal: '");
          out.print( displayTerms.getRegionId() );
          out.write("'\n\t\t\t}\n\t\t]\n\t);\n");
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

  private boolean _jspx_meth_aui_option_0(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_select_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:option
    com.liferay.taglib.aui.OptionTag _jspx_th_aui_option_0 = (com.liferay.taglib.aui.OptionTag) _jspx_tagPool_aui_option_value_nobody.get(com.liferay.taglib.aui.OptionTag.class);
    _jspx_th_aui_option_0.setPageContext(_jspx_page_context);
    _jspx_th_aui_option_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_select_0);
    _jspx_th_aui_option_0.setValue(new String(""));
    int _jspx_eval_aui_option_0 = _jspx_th_aui_option_0.doStartTag();
    if (_jspx_th_aui_option_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_option_value_nobody.reuse(_jspx_th_aui_option_0);
      return true;
    }
    _jspx_tagPool_aui_option_value_nobody.reuse(_jspx_th_aui_option_0);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_message_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_0 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_0.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_liferay$1ui_message_0.setKey("filter-by-organization");
    int _jspx_eval_liferay$1ui_message_0 = _jspx_th_liferay$1ui_message_0.doStartTag();
    if (_jspx_th_liferay$1ui_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_0);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_0);
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

  private boolean _jspx_meth_portlet_namespace_1(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_script_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_1 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_1.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_0);
    int _jspx_eval_portlet_namespace_1 = _jspx_th_portlet_namespace_1.doStartTag();
    if (_jspx_th_portlet_namespace_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_1);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_1);
    return false;
  }
}
