package org.apache.jsp.organization;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.liferay.admin.kernel.util.PortalMyAccountApplicationType;
import com.liferay.announcements.kernel.model.AnnouncementsDelivery;
import com.liferay.announcements.kernel.model.AnnouncementsEntryConstants;
import com.liferay.announcements.kernel.service.AnnouncementsDeliveryLocalServiceUtil;
import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.bean.BeanParamUtil;
import com.liferay.portal.kernel.bean.BeanPropertiesUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.AddressCityException;
import com.liferay.portal.kernel.exception.AddressStreetException;
import com.liferay.portal.kernel.exception.AddressZipException;
import com.liferay.portal.kernel.exception.CompanyMaxUsersException;
import com.liferay.portal.kernel.exception.ContactBirthdayException;
import com.liferay.portal.kernel.exception.DuplicateOpenIdException;
import com.liferay.portal.kernel.exception.DuplicateOrganizationException;
import com.liferay.portal.kernel.exception.EmailAddressException;
import com.liferay.portal.kernel.exception.GroupFriendlyURLException;
import com.liferay.portal.kernel.exception.NoSuchCountryException;
import com.liferay.portal.kernel.exception.NoSuchListTypeException;
import com.liferay.portal.kernel.exception.NoSuchOrganizationException;
import com.liferay.portal.kernel.exception.NoSuchRegionException;
import com.liferay.portal.kernel.exception.NoSuchRoleException;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.OrganizationNameException;
import com.liferay.portal.kernel.exception.OrganizationParentException;
import com.liferay.portal.kernel.exception.PhoneNumberException;
import com.liferay.portal.kernel.exception.PhoneNumberExtensionException;
import com.liferay.portal.kernel.exception.RequiredOrganizationException;
import com.liferay.portal.kernel.exception.RequiredUserException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserFieldException;
import com.liferay.portal.kernel.exception.UserIdException;
import com.liferay.portal.kernel.exception.UserLockoutException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.exception.UserScreenNameException;
import com.liferay.portal.kernel.exception.UserSmsException;
import com.liferay.portal.kernel.exception.WebsiteURLException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.language.UnicodeLanguageUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.EmailAddress;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.model.LayoutSetPrototype;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.ListTypeConstants;
import com.liferay.portal.kernel.model.ModelHintsConstants;
import com.liferay.portal.kernel.model.OrgLabor;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.OrganizationConstants;
import com.liferay.portal.kernel.model.PasswordPolicy;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserConstants;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.model.UserGroupGroupRole;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.model.Website;
import com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.security.auth.ScreenNameValidator;
import com.liferay.portal.kernel.security.ldap.LDAPSettingsUtil;
import com.liferay.portal.kernel.security.membershippolicy.OrganizationMembershipPolicyUtil;
import com.liferay.portal.kernel.security.membershippolicy.RoleMembershipPolicyUtil;
import com.liferay.portal.kernel.security.membershippolicy.SiteMembershipPolicyUtil;
import com.liferay.portal.kernel.security.membershippolicy.UserGroupMembershipPolicyUtil;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.AddressServiceUtil;
import com.liferay.portal.kernel.service.EmailAddressServiceUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutSetPrototypeLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutSetPrototypeServiceUtil;
import com.liferay.portal.kernel.service.ListTypeServiceUtil;
import com.liferay.portal.kernel.service.OrgLaborServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationServiceUtil;
import com.liferay.portal.kernel.service.PhoneServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.WebsiteServiceUtil;
import com.liferay.portal.kernel.service.permission.GroupPermissionUtil;
import com.liferay.portal.kernel.service.permission.OrganizationPermissionUtil;
import com.liferay.portal.kernel.service.permission.PortalPermissionUtil;
import com.liferay.portal.kernel.service.permission.UserPermissionUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TextFormatter;
import com.liferay.portal.kernel.util.UnicodeFormatter;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.webserver.WebServerServletTokenUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.impl.OrgLaborImpl;
import com.liferay.portal.security.auth.ScreenNameValidatorFactory;
import com.liferay.portal.util.PrefsPropsUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.portlet.announcements.model.impl.AnnouncementsDeliveryImpl;
import com.liferay.portlet.usersadmin.search.OrganizationSearch;
import com.liferay.roles.admin.kernel.util.RolesAdminUtil;
import com.liferay.taglib.search.ResultRow;
import com.liferay.taglib.search.SearchEntry;
import com.liferay.users.admin.configuration.UserFileUploadsConfiguration;
import com.liferay.users.admin.constants.UserFormConstants;
import com.liferay.users.admin.constants.UsersAdminPortletKeys;
import com.liferay.users.admin.kernel.util.UsersAdmin;
import com.liferay.users.admin.kernel.util.UsersAdminUtil;
import com.liferay.users.admin.user.action.contributor.UserActionContributor;
import com.liferay.users.admin.web.internal.constants.UsersAdminWebKeys;
import com.liferay.users.admin.web.internal.display.context.EditContactInformationDisplayContext;
import com.liferay.users.admin.web.internal.display.context.InitDisplayContext;
import com.liferay.users.admin.web.internal.display.context.OrgLaborDisplay;
import com.liferay.users.admin.web.internal.display.context.OrgLaborFormDisplay;
import com.liferay.users.admin.web.internal.display.context.OrganizationScreenNavigationDisplayContext;
import com.liferay.users.admin.web.internal.display.context.SelectOrganizationManagementToolbarDisplayContext;
import com.liferay.users.admin.web.internal.display.context.SelectOrganizationUsersManagementToolbarDisplayContext;
import com.liferay.users.admin.web.internal.display.context.SelectUserGroupManagementToolbarDisplayContext;
import com.liferay.users.admin.web.internal.display.context.UserActionDisplayContext;
import com.liferay.users.admin.web.internal.display.context.UserDisplayContext;
import com.liferay.users.admin.web.internal.display.context.ViewOrganizationsManagementToolbarDisplayContext;
import com.liferay.users.admin.web.internal.display.context.ViewTreeManagementToolbarDisplayContext;
import com.liferay.users.admin.web.internal.display.context.ViewUsersManagementToolbarDisplayContext;
import com.liferay.users.admin.web.internal.search.OrganizationResultRowSplitter;
import com.liferay.users.admin.web.internal.util.CSSClassNames;
import com.liferay.users.admin.web.internal.util.CustomFieldsUtil;
import com.liferay.users.admin.web.internal.util.UsersAdminPortletURLUtil;
import java.text.Format;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.portlet.ActionRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

public final class organization_005fsite_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/init.jsp");
    _jspx_dependants.add("/init-ext.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_value_type_name_label_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_namespace_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_icon_url_message_label_iconCssClass_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_button_type_href_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_value_type_name_label_helpMessage_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_message_key_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_clay_alert_title_style_message_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_value_type_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_icon_url_target_method_message_label_iconCssClass_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_option_value_label_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_script;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_button_type_primary_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_option_value_selected_label_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1theme_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_value_type_name_inlineField_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_select_name_label;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_aui_input_value_type_name_label_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_namespace_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_icon_url_message_label_iconCssClass_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_button_type_href_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_value_type_name_label_helpMessage_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_message_key_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_clay_alert_title_style_message_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_value_type_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_icon_url_target_method_message_label_iconCssClass_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_option_value_label_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_script = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_button_type_primary_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_option_value_selected_label_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1theme_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_value_type_name_inlineField_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_select_name_label = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_aui_input_value_type_name_label_nobody.release();
    _jspx_tagPool_portlet_namespace_nobody.release();
    _jspx_tagPool_liferay$1ui_icon_url_message_label_iconCssClass_nobody.release();
    _jspx_tagPool_aui_button_type_href_nobody.release();
    _jspx_tagPool_aui_input_value_type_name_label_helpMessage_nobody.release();
    _jspx_tagPool_liferay$1ui_message_key_nobody.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_clay_alert_title_style_message_nobody.release();
    _jspx_tagPool_aui_input_value_type_name_nobody.release();
    _jspx_tagPool_liferay$1ui_icon_url_target_method_message_label_iconCssClass_nobody.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_aui_option_value_label_nobody.release();
    _jspx_tagPool_aui_script.release();
    _jspx_tagPool_portlet_defineObjects_nobody.release();
    _jspx_tagPool_aui_button_type_primary_nobody.release();
    _jspx_tagPool_aui_option_value_selected_label_nobody.release();
    _jspx_tagPool_liferay$1theme_defineObjects_nobody.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_aui_input_value_type_name_inlineField_nobody.release();
    _jspx_tagPool_liferay$1frontend_defineObjects_nobody.release();
    _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.release();
    _jspx_tagPool_aui_select_name_label.release();
    _jspx_tagPool_c_when_test.release();
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

PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);

String myAccountPortletId = PortletProviderUtil.getPortletId(PortalMyAccountApplicationType.MyAccount.CLASS_NAME, PortletProvider.Action.VIEW);

InitDisplayContext initDisplayContext = new InitDisplayContext(request, portletName);

boolean filterManageableOrganizations = initDisplayContext.isFilterManageableOrganizations();
boolean filterManageableUserGroups = initDisplayContext.isFilterManageableUserGroups();

UserDisplayContext userDisplayContext = new UserDisplayContext(request, initDisplayContext);

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');

long organizationId = ParamUtil.getLong(request, "organizationId");

Organization organization = OrganizationServiceUtil.fetchOrganization(organizationId);

List<LayoutSetPrototype> layoutSetPrototypes = LayoutSetPrototypeServiceUtil.search(company.getCompanyId(), Boolean.TRUE, null);

LayoutSet privateLayoutSet = null;
LayoutSetPrototype privateLayoutSetPrototype = null;
boolean privateLayoutSetPrototypeLinkEnabled = true;

LayoutSet publicLayoutSet = null;
LayoutSetPrototype publicLayoutSetPrototype = null;
boolean publicLayoutSetPrototypeLinkEnabled = true;

boolean site = false;

Group organizationGroup = null;

if (organization != null) {
	organizationGroup = organization.getGroup();

	site = organizationGroup.isSite();

	if (site) {
		try {
			LayoutLocalServiceUtil.getLayouts(organizationGroup.getGroupId(), false, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID);

			privateLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(organizationGroup.getGroupId(), true);

			privateLayoutSetPrototypeLinkEnabled = privateLayoutSet.isLayoutSetPrototypeLinkEnabled();

			String layoutSetPrototypeUuid = privateLayoutSet.getLayoutSetPrototypeUuid();

			if (Validator.isNotNull(layoutSetPrototypeUuid)) {
				privateLayoutSetPrototype = LayoutSetPrototypeLocalServiceUtil.getLayoutSetPrototypeByUuidAndCompanyId(layoutSetPrototypeUuid, company.getCompanyId());
			}
		}
		catch (Exception e) {
		}

		try {
			LayoutLocalServiceUtil.getLayouts(organizationGroup.getGroupId(), true, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID);

			publicLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(organizationGroup.getGroupId(), false);

			publicLayoutSetPrototypeLinkEnabled = publicLayoutSet.isLayoutSetPrototypeLinkEnabled();

			String layoutSetPrototypeUuid = publicLayoutSet.getLayoutSetPrototypeUuid();

			if (Validator.isNotNull(layoutSetPrototypeUuid)) {
				publicLayoutSetPrototype = LayoutSetPrototypeLocalServiceUtil.getLayoutSetPrototypeByUuidAndCompanyId(layoutSetPrototypeUuid, company.getCompanyId());
			}
		}
		catch (Exception e) {
		}
	}
}

      out.write('\n');
      out.write('\n');
      //  c:choose
      com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_0 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
      _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
      _jspx_th_c_choose_0.setParent(null);
      int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
      if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write('\n');
        out.write('	');
        //  c:when
        com.liferay.taglib.core.WhenTag _jspx_th_c_when_0 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
        _jspx_th_c_when_0.setPageContext(_jspx_page_context);
        _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
        _jspx_th_c_when_0.setTest( (organizationGroup == null) || GroupPermissionUtil.contains(permissionChecker, organizationGroup, ActionKeys.UPDATE) );
        int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
        if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          out.write("\n\t\t<div class=\"sheet-section\">\n\t\t\t");
          //  c:choose
          com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_1 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
          _jspx_th_c_choose_1.setPageContext(_jspx_page_context);
          _jspx_th_c_choose_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
          int _jspx_eval_c_choose_1 = _jspx_th_c_choose_1.doStartTag();
          if (_jspx_eval_c_choose_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\n\t\t\t\t");
            //  c:when
            com.liferay.taglib.core.WhenTag _jspx_th_c_when_1 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
            _jspx_th_c_when_1.setPageContext(_jspx_page_context);
            _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
            _jspx_th_c_when_1.setTest( (organization == null) || ((publicLayoutSetPrototype == null) && (privateLayoutSetPrototype == null)) );
            int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
            if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              out.write("\n\t\t\t\t\t<p class=\"sheet-text\">");
              if (_jspx_meth_liferay$1ui_message_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_1, _jspx_page_context))
                return;
              out.write("</p>\n\n\t\t\t\t\t");
              //  aui:input
              com.liferay.taglib.aui.InputTag _jspx_th_aui_input_0 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_label_nobody.get(com.liferay.taglib.aui.InputTag.class);
              _jspx_th_aui_input_0.setPageContext(_jspx_page_context);
              _jspx_th_aui_input_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_1);
              _jspx_th_aui_input_0.setLabel("create-site");
              _jspx_th_aui_input_0.setName("site");
              _jspx_th_aui_input_0.setType("toggle-switch");
              _jspx_th_aui_input_0.setValue( site );
              int _jspx_eval_aui_input_0 = _jspx_th_aui_input_0.doStartTag();
              if (_jspx_th_aui_input_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_aui_input_value_type_name_label_nobody.reuse(_jspx_th_aui_input_0);
                return;
              }
              _jspx_tagPool_aui_input_value_type_name_label_nobody.reuse(_jspx_th_aui_input_0);
              out.write("\n\t\t\t\t");
            }
            if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
              return;
            }
            _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
            out.write("\n\t\t\t\t");
            //  c:otherwise
            com.liferay.taglib.core.OtherwiseTag _jspx_th_c_otherwise_0 = (com.liferay.taglib.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(com.liferay.taglib.core.OtherwiseTag.class);
            _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
            _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
            int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
            if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              out.write("\n\t\t\t\t\t");
              //  aui:input
              com.liferay.taglib.aui.InputTag _jspx_th_aui_input_1 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_label_nobody.get(com.liferay.taglib.aui.InputTag.class);
              _jspx_th_aui_input_1.setPageContext(_jspx_page_context);
              _jspx_th_aui_input_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_0);
              _jspx_th_aui_input_1.setLabel("create-site");
              _jspx_th_aui_input_1.setName("site");
              _jspx_th_aui_input_1.setType("hidden");
              _jspx_th_aui_input_1.setValue( site );
              int _jspx_eval_aui_input_1 = _jspx_th_aui_input_1.doStartTag();
              if (_jspx_th_aui_input_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_aui_input_value_type_name_label_nobody.reuse(_jspx_th_aui_input_1);
                return;
              }
              _jspx_tagPool_aui_input_value_type_name_label_nobody.reuse(_jspx_th_aui_input_1);
              out.write("\n\t\t\t\t");
            }
            if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
              return;
            }
            _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
            out.write("\n\t\t\t");
          }
          if (_jspx_th_c_choose_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
            return;
          }
          _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
          out.write("\n\n\t\t\t");
          //  c:if
          com.liferay.taglib.core.IfTag _jspx_th_c_if_0 = (com.liferay.taglib.core.IfTag) _jspx_tagPool_c_if_test.get(com.liferay.taglib.core.IfTag.class);
          _jspx_th_c_if_0.setPageContext(_jspx_page_context);
          _jspx_th_c_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
          _jspx_th_c_if_0.setTest( site );
          int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
          if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\n\n\t\t\t\t");

				PortletURL editOrganizationSiteURL = PortletProviderUtil.getPortletURL(request, organizationGroup, Group.class.getName(), PortletProvider.Action.EDIT);

				editOrganizationSiteURL.setParameter("viewOrganizationsRedirect", currentURL);
				
            out.write("\n\n\t\t\t\t");
            //  aui:input
            com.liferay.taglib.aui.InputTag _jspx_th_aui_input_2 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_inlineField_nobody.get(com.liferay.taglib.aui.InputTag.class);
            _jspx_th_aui_input_2.setPageContext(_jspx_page_context);
            _jspx_th_aui_input_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
            _jspx_th_aui_input_2.setInlineField( true );
            _jspx_th_aui_input_2.setName("siteId");
            _jspx_th_aui_input_2.setType("resource");
            _jspx_th_aui_input_2.setValue( String.valueOf(organizationGroup.getGroupId()) );
            int _jspx_eval_aui_input_2 = _jspx_th_aui_input_2.doStartTag();
            if (_jspx_th_aui_input_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_aui_input_value_type_name_inlineField_nobody.reuse(_jspx_th_aui_input_2);
              return;
            }
            _jspx_tagPool_aui_input_value_type_name_inlineField_nobody.reuse(_jspx_th_aui_input_2);
            out.write("\n\n\t\t\t\t<div class=\"form-group\">\n\t\t\t\t\t");
            //  liferay-ui:icon
            com.liferay.taglib.ui.IconTag _jspx_th_liferay$1ui_icon_0 = (com.liferay.taglib.ui.IconTag) _jspx_tagPool_liferay$1ui_icon_url_message_label_iconCssClass_nobody.get(com.liferay.taglib.ui.IconTag.class);
            _jspx_th_liferay$1ui_icon_0.setPageContext(_jspx_page_context);
            _jspx_th_liferay$1ui_icon_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
            _jspx_th_liferay$1ui_icon_0.setIconCssClass("icon-cog");
            _jspx_th_liferay$1ui_icon_0.setLabel( true );
            _jspx_th_liferay$1ui_icon_0.setMessage("manage-site");
            _jspx_th_liferay$1ui_icon_0.setUrl( editOrganizationSiteURL.toString() );
            int _jspx_eval_liferay$1ui_icon_0 = _jspx_th_liferay$1ui_icon_0.doStartTag();
            if (_jspx_th_liferay$1ui_icon_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_liferay$1ui_icon_url_message_label_iconCssClass_nobody.reuse(_jspx_th_liferay$1ui_icon_0);
              return;
            }
            _jspx_tagPool_liferay$1ui_icon_url_message_label_iconCssClass_nobody.reuse(_jspx_th_liferay$1ui_icon_0);
            out.write("\n\t\t\t\t</div>\n\t\t\t");
          }
          if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
            return;
          }
          _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
          out.write("\n\t\t</div>\n\n\t\t");

		boolean hasUnlinkLayoutSetPrototypePermission = PortalPermissionUtil.contains(permissionChecker, ActionKeys.UNLINK_LAYOUT_SET_PROTOTYPE);
		
          out.write("\n\n\t\t<div id=\"");
          if (_jspx_meth_portlet_namespace_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_0, _jspx_page_context))
            return;
          out.write("siteTemplates\">\n\t\t\t<div class=\"sheet-section\">\n\t\t\t\t<h3 class=\"sheet-subtitle\">");
          if (_jspx_meth_liferay$1ui_message_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_0, _jspx_page_context))
            return;
          out.write("</h3>\n\n\t\t\t\t");
          //  c:choose
          com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_2 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
          _jspx_th_c_choose_2.setPageContext(_jspx_page_context);
          _jspx_th_c_choose_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
          int _jspx_eval_c_choose_2 = _jspx_th_c_choose_2.doStartTag();
          if (_jspx_eval_c_choose_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\n\t\t\t\t\t");
            //  c:when
            com.liferay.taglib.core.WhenTag _jspx_th_c_when_2 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
            _jspx_th_c_when_2.setPageContext(_jspx_page_context);
            _jspx_th_c_when_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_2);
            _jspx_th_c_when_2.setTest( ((organization == null) || ((publicLayoutSetPrototype == null) && (organization.getPublicLayoutsPageCount() == 0))) && !layoutSetPrototypes.isEmpty() );
            int _jspx_eval_c_when_2 = _jspx_th_c_when_2.doStartTag();
            if (_jspx_eval_c_when_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              out.write("\n\t\t\t\t\t\t");
              //  clay:alert
              com.liferay.frontend.taglib.clay.servlet.taglib.soy.AlertTag _jspx_th_clay_alert_0 = (com.liferay.frontend.taglib.clay.servlet.taglib.soy.AlertTag) _jspx_tagPool_clay_alert_title_style_message_nobody.get(com.liferay.frontend.taglib.clay.servlet.taglib.soy.AlertTag.class);
              _jspx_th_clay_alert_0.setPageContext(_jspx_page_context);
              _jspx_th_clay_alert_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_2);
              _jspx_th_clay_alert_0.setMessage( LanguageUtil.get(request, "this-action-cannot-be-undone") );
              _jspx_th_clay_alert_0.setStyle("warning");
              _jspx_th_clay_alert_0.setTitle( LanguageUtil.get(request, "warning") + ":" );
              int _jspx_eval_clay_alert_0 = _jspx_th_clay_alert_0.doStartTag();
              if (_jspx_th_clay_alert_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_clay_alert_title_style_message_nobody.reuse(_jspx_th_clay_alert_0);
                return;
              }
              _jspx_tagPool_clay_alert_title_style_message_nobody.reuse(_jspx_th_clay_alert_0);
              out.write("\n\n\t\t\t\t\t\t");
              //  aui:select
              com.liferay.taglib.aui.SelectTag _jspx_th_aui_select_0 = (com.liferay.taglib.aui.SelectTag) _jspx_tagPool_aui_select_name_label.get(com.liferay.taglib.aui.SelectTag.class);
              _jspx_th_aui_select_0.setPageContext(_jspx_page_context);
              _jspx_th_aui_select_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_2);
              _jspx_th_aui_select_0.setLabel("");
              _jspx_th_aui_select_0.setName("publicLayoutSetPrototypeId");
              int _jspx_eval_aui_select_0 = _jspx_th_aui_select_0.doStartTag();
              if (_jspx_eval_aui_select_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_aui_select_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_aui_select_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_aui_select_0.doInitBody();
                }
                do {
                  out.write("\n\t\t\t\t\t\t\t");
                  //  aui:option
                  com.liferay.taglib.aui.OptionTag _jspx_th_aui_option_0 = (com.liferay.taglib.aui.OptionTag) _jspx_tagPool_aui_option_value_selected_label_nobody.get(com.liferay.taglib.aui.OptionTag.class);
                  _jspx_th_aui_option_0.setPageContext(_jspx_page_context);
                  _jspx_th_aui_option_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_select_0);
                  _jspx_th_aui_option_0.setLabel(new String("none"));
                  _jspx_th_aui_option_0.setSelected( true );
                  _jspx_th_aui_option_0.setValue(new String(""));
                  int _jspx_eval_aui_option_0 = _jspx_th_aui_option_0.doStartTag();
                  if (_jspx_th_aui_option_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_aui_option_value_selected_label_nobody.reuse(_jspx_th_aui_option_0);
                    return;
                  }
                  _jspx_tagPool_aui_option_value_selected_label_nobody.reuse(_jspx_th_aui_option_0);
                  out.write("\n\n\t\t\t\t\t\t\t");

							for (LayoutSetPrototype layoutSetPrototype : layoutSetPrototypes) {
							
                  out.write("\n\n\t\t\t\t\t\t\t\t");
                  //  aui:option
                  com.liferay.taglib.aui.OptionTag _jspx_th_aui_option_1 = (com.liferay.taglib.aui.OptionTag) _jspx_tagPool_aui_option_value_label_nobody.get(com.liferay.taglib.aui.OptionTag.class);
                  _jspx_th_aui_option_1.setPageContext(_jspx_page_context);
                  _jspx_th_aui_option_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_select_0);
                  _jspx_th_aui_option_1.setLabel( HtmlUtil.escape(layoutSetPrototype.getName(locale)) );
                  _jspx_th_aui_option_1.setValue( layoutSetPrototype.getLayoutSetPrototypeId() );
                  int _jspx_eval_aui_option_1 = _jspx_th_aui_option_1.doStartTag();
                  if (_jspx_th_aui_option_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_aui_option_value_label_nobody.reuse(_jspx_th_aui_option_1);
                    return;
                  }
                  _jspx_tagPool_aui_option_value_label_nobody.reuse(_jspx_th_aui_option_1);
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
              //  c:choose
              com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_3 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
              _jspx_th_c_choose_3.setPageContext(_jspx_page_context);
              _jspx_th_c_choose_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_2);
              int _jspx_eval_c_choose_3 = _jspx_th_c_choose_3.doStartTag();
              if (_jspx_eval_c_choose_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                out.write("\n\t\t\t\t\t\t\t");
                //  c:when
                com.liferay.taglib.core.WhenTag _jspx_th_c_when_3 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                _jspx_th_c_when_3.setPageContext(_jspx_page_context);
                _jspx_th_c_when_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_3);
                _jspx_th_c_when_3.setTest( hasUnlinkLayoutSetPrototypePermission );
                int _jspx_eval_c_when_3 = _jspx_th_c_when_3.doStartTag();
                if (_jspx_eval_c_when_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\t\t\t\t\t\t\t\t<div class=\"hide\" id=\"");
                  if (_jspx_meth_portlet_namespace_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_3, _jspx_page_context))
                    return;
                  out.write("publicLayoutSetPrototypeIdOptions\">\n\t\t\t\t\t\t\t\t\t");
                  //  aui:input
                  com.liferay.taglib.aui.InputTag _jspx_th_aui_input_3 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_label_helpMessage_nobody.get(com.liferay.taglib.aui.InputTag.class);
                  _jspx_th_aui_input_3.setPageContext(_jspx_page_context);
                  _jspx_th_aui_input_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_3);
                  _jspx_th_aui_input_3.setHelpMessage("enable-propagation-of-changes-from-the-site-template-help");
                  _jspx_th_aui_input_3.setLabel("enable-propagation-of-changes-from-the-site-template");
                  _jspx_th_aui_input_3.setName("publicLayoutSetPrototypeLinkEnabled");
                  _jspx_th_aui_input_3.setType("checkbox");
                  _jspx_th_aui_input_3.setValue( true );
                  int _jspx_eval_aui_input_3 = _jspx_th_aui_input_3.doStartTag();
                  if (_jspx_th_aui_input_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_aui_input_value_type_name_label_helpMessage_nobody.reuse(_jspx_th_aui_input_3);
                    return;
                  }
                  _jspx_tagPool_aui_input_value_type_name_label_helpMessage_nobody.reuse(_jspx_th_aui_input_3);
                  out.write("\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t");
                }
                if (_jspx_th_c_when_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_3);
                  return;
                }
                _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_3);
                out.write("\n\t\t\t\t\t\t\t");
                //  c:otherwise
                com.liferay.taglib.core.OtherwiseTag _jspx_th_c_otherwise_1 = (com.liferay.taglib.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(com.liferay.taglib.core.OtherwiseTag.class);
                _jspx_th_c_otherwise_1.setPageContext(_jspx_page_context);
                _jspx_th_c_otherwise_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_3);
                int _jspx_eval_c_otherwise_1 = _jspx_th_c_otherwise_1.doStartTag();
                if (_jspx_eval_c_otherwise_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\t\t\t\t\t\t\t\t");
                  //  aui:input
                  com.liferay.taglib.aui.InputTag _jspx_th_aui_input_4 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
                  _jspx_th_aui_input_4.setPageContext(_jspx_page_context);
                  _jspx_th_aui_input_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_1);
                  _jspx_th_aui_input_4.setName("publicLayoutSetPrototypeLinkEnabled");
                  _jspx_th_aui_input_4.setType("hidden");
                  _jspx_th_aui_input_4.setValue( true );
                  int _jspx_eval_aui_input_4 = _jspx_th_aui_input_4.doStartTag();
                  if (_jspx_th_aui_input_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_4);
                    return;
                  }
                  _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_4);
                  out.write("\n\t\t\t\t\t\t\t");
                }
                if (_jspx_th_c_otherwise_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_1);
                  return;
                }
                _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_1);
                out.write("\n\t\t\t\t\t\t");
              }
              if (_jspx_th_c_choose_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_3);
                return;
              }
              _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_3);
              out.write("\n\t\t\t\t\t");
            }
            if (_jspx_th_c_when_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_2);
              return;
            }
            _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_2);
            out.write("\n\t\t\t\t\t");
            //  c:otherwise
            com.liferay.taglib.core.OtherwiseTag _jspx_th_c_otherwise_2 = (com.liferay.taglib.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(com.liferay.taglib.core.OtherwiseTag.class);
            _jspx_th_c_otherwise_2.setPageContext(_jspx_page_context);
            _jspx_th_c_otherwise_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_2);
            int _jspx_eval_c_otherwise_2 = _jspx_th_c_otherwise_2.doStartTag();
            if (_jspx_eval_c_otherwise_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              out.write("\n\t\t\t\t\t\t");
              //  c:choose
              com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_4 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
              _jspx_th_c_choose_4.setPageContext(_jspx_page_context);
              _jspx_th_c_choose_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_2);
              int _jspx_eval_c_choose_4 = _jspx_th_c_choose_4.doStartTag();
              if (_jspx_eval_c_choose_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                out.write("\n\t\t\t\t\t\t\t");
                //  c:when
                com.liferay.taglib.core.WhenTag _jspx_th_c_when_4 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                _jspx_th_c_when_4.setPageContext(_jspx_page_context);
                _jspx_th_c_when_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_4);
                _jspx_th_c_when_4.setTest( organization != null );
                int _jspx_eval_c_when_4 = _jspx_th_c_when_4.doStartTag();
                if (_jspx_eval_c_when_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\t\t\t\t\t\t\t\t<div class=\"form-group\">\n\t\t\t\t\t\t\t\t\t");
                  //  c:choose
                  com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_5 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
                  _jspx_th_c_choose_5.setPageContext(_jspx_page_context);
                  _jspx_th_c_choose_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_4);
                  int _jspx_eval_c_choose_5 = _jspx_th_c_choose_5.doStartTag();
                  if (_jspx_eval_c_choose_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    out.write("\n\t\t\t\t\t\t\t\t\t\t");
                    //  c:when
                    com.liferay.taglib.core.WhenTag _jspx_th_c_when_5 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                    _jspx_th_c_when_5.setPageContext(_jspx_page_context);
                    _jspx_th_c_when_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_5);
                    _jspx_th_c_when_5.setTest( organization.getPublicLayoutsPageCount() > 0 );
                    int _jspx_eval_c_when_5 = _jspx_th_c_when_5.doStartTag();
                    if (_jspx_eval_c_when_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                      out.write("\n\t\t\t\t\t\t\t\t\t\t\t");
                      //  liferay-ui:icon
                      com.liferay.taglib.ui.IconTag _jspx_th_liferay$1ui_icon_1 = (com.liferay.taglib.ui.IconTag) _jspx_tagPool_liferay$1ui_icon_url_target_method_message_label_iconCssClass_nobody.get(com.liferay.taglib.ui.IconTag.class);
                      _jspx_th_liferay$1ui_icon_1.setPageContext(_jspx_page_context);
                      _jspx_th_liferay$1ui_icon_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_5);
                      _jspx_th_liferay$1ui_icon_1.setIconCssClass("icon-search");
                      _jspx_th_liferay$1ui_icon_1.setLabel( true );
                      _jspx_th_liferay$1ui_icon_1.setMessage("open-public-pages");
                      _jspx_th_liferay$1ui_icon_1.setMethod("get");
                      _jspx_th_liferay$1ui_icon_1.setTarget("_blank");
                      _jspx_th_liferay$1ui_icon_1.setUrl( organizationGroup.getDisplayURL(themeDisplay, false) );
                      int _jspx_eval_liferay$1ui_icon_1 = _jspx_th_liferay$1ui_icon_1.doStartTag();
                      if (_jspx_th_liferay$1ui_icon_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_liferay$1ui_icon_url_target_method_message_label_iconCssClass_nobody.reuse(_jspx_th_liferay$1ui_icon_1);
                        return;
                      }
                      _jspx_tagPool_liferay$1ui_icon_url_target_method_message_label_iconCssClass_nobody.reuse(_jspx_th_liferay$1ui_icon_1);
                      out.write("\n\t\t\t\t\t\t\t\t\t\t");
                    }
                    if (_jspx_th_c_when_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_5);
                      return;
                    }
                    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_5);
                    out.write("\n\t\t\t\t\t\t\t\t\t\t");
                    if (_jspx_meth_c_otherwise_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_5, _jspx_page_context))
                      return;
                    out.write("\n\t\t\t\t\t\t\t\t\t");
                  }
                  if (_jspx_th_c_choose_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_5);
                    return;
                  }
                  _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_5);
                  out.write("\n\t\t\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t\t\t<div class=\"form-group\">\n\t\t\t\t\t\t\t\t\t");
                  //  c:choose
                  com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_6 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
                  _jspx_th_c_choose_6.setPageContext(_jspx_page_context);
                  _jspx_th_c_choose_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_4);
                  int _jspx_eval_c_choose_6 = _jspx_th_c_choose_6.doStartTag();
                  if (_jspx_eval_c_choose_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    out.write("\n\t\t\t\t\t\t\t\t\t\t");
                    //  c:when
                    com.liferay.taglib.core.WhenTag _jspx_th_c_when_6 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                    _jspx_th_c_when_6.setPageContext(_jspx_page_context);
                    _jspx_th_c_when_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_6);
                    _jspx_th_c_when_6.setTest( (publicLayoutSetPrototype != null) && !organizationGroup.isStaged() && hasUnlinkLayoutSetPrototypePermission );
                    int _jspx_eval_c_when_6 = _jspx_th_c_when_6.doStartTag();
                    if (_jspx_eval_c_when_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                      out.write("\n\t\t\t\t\t\t\t\t\t\t\t");
                      //  aui:input
                      com.liferay.taglib.aui.InputTag _jspx_th_aui_input_5 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_label_nobody.get(com.liferay.taglib.aui.InputTag.class);
                      _jspx_th_aui_input_5.setPageContext(_jspx_page_context);
                      _jspx_th_aui_input_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_6);
                      _jspx_th_aui_input_5.setLabel( LanguageUtil.format(request, "enable-propagation-of-changes-from-the-site-template-x", HtmlUtil.escape(publicLayoutSetPrototype.getName(locale)), false) );
                      _jspx_th_aui_input_5.setName("publicLayoutSetPrototypeLinkEnabled");
                      _jspx_th_aui_input_5.setType("checkbox");
                      _jspx_th_aui_input_5.setValue( publicLayoutSetPrototypeLinkEnabled );
                      int _jspx_eval_aui_input_5 = _jspx_th_aui_input_5.doStartTag();
                      if (_jspx_th_aui_input_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_aui_input_value_type_name_label_nobody.reuse(_jspx_th_aui_input_5);
                        return;
                      }
                      _jspx_tagPool_aui_input_value_type_name_label_nobody.reuse(_jspx_th_aui_input_5);
                      out.write("\n\t\t\t\t\t\t\t\t\t\t");
                    }
                    if (_jspx_th_c_when_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_6);
                      return;
                    }
                    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_6);
                    out.write("\n\t\t\t\t\t\t\t\t\t\t");
                    //  c:when
                    com.liferay.taglib.core.WhenTag _jspx_th_c_when_7 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                    _jspx_th_c_when_7.setPageContext(_jspx_page_context);
                    _jspx_th_c_when_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_6);
                    _jspx_th_c_when_7.setTest( publicLayoutSetPrototype != null );
                    int _jspx_eval_c_when_7 = _jspx_th_c_when_7.doStartTag();
                    if (_jspx_eval_c_when_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                      out.write("\n\t\t\t\t\t\t\t\t\t\t\t");
                      //  liferay-ui:message
                      com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_3 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
                      _jspx_th_liferay$1ui_message_3.setPageContext(_jspx_page_context);
                      _jspx_th_liferay$1ui_message_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_7);
                      _jspx_th_liferay$1ui_message_3.setArguments( new Object[] {HtmlUtil.escape(publicLayoutSetPrototype.getName(locale))} );
                      _jspx_th_liferay$1ui_message_3.setKey("these-pages-are-linked-to-site-template-x");
                      _jspx_th_liferay$1ui_message_3.setTranslateArguments( false );
                      int _jspx_eval_liferay$1ui_message_3 = _jspx_th_liferay$1ui_message_3.doStartTag();
                      if (_jspx_th_liferay$1ui_message_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_3);
                        return;
                      }
                      _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_3);
                      out.write("\n\n\t\t\t\t\t\t\t\t\t\t\t");
                      //  aui:input
                      com.liferay.taglib.aui.InputTag _jspx_th_aui_input_6 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
                      _jspx_th_aui_input_6.setPageContext(_jspx_page_context);
                      _jspx_th_aui_input_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_7);
                      _jspx_th_aui_input_6.setName("publicLayoutSetPrototypeLinkEnabled");
                      _jspx_th_aui_input_6.setType("hidden");
                      _jspx_th_aui_input_6.setValue( publicLayoutSetPrototypeLinkEnabled );
                      int _jspx_eval_aui_input_6 = _jspx_th_aui_input_6.doStartTag();
                      if (_jspx_th_aui_input_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_6);
                        return;
                      }
                      _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_6);
                      out.write("\n\t\t\t\t\t\t\t\t\t\t");
                    }
                    if (_jspx_th_c_when_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_7);
                      return;
                    }
                    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_7);
                    out.write("\n\t\t\t\t\t\t\t\t\t");
                  }
                  if (_jspx_th_c_choose_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_6);
                    return;
                  }
                  _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_6);
                  out.write("\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t");
                }
                if (_jspx_th_c_when_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_4);
                  return;
                }
                _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_4);
                out.write("\n\t\t\t\t\t\t");
              }
              if (_jspx_th_c_choose_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_4);
                return;
              }
              _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_4);
              out.write("\n\t\t\t\t\t");
            }
            if (_jspx_th_c_otherwise_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_2);
              return;
            }
            _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_2);
            out.write("\n\t\t\t\t");
          }
          if (_jspx_th_c_choose_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_2);
            return;
          }
          _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_2);
          out.write("\n\t\t\t</div>\n\n\t\t\t<div class=\"sheet-section\">\n\t\t\t\t<h3 class=\"sheet-subtitle\">");
          if (_jspx_meth_liferay$1ui_message_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_0, _jspx_page_context))
            return;
          out.write("</h3>\n\n\t\t\t\t");
          //  c:choose
          com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_7 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
          _jspx_th_c_choose_7.setPageContext(_jspx_page_context);
          _jspx_th_c_choose_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
          int _jspx_eval_c_choose_7 = _jspx_th_c_choose_7.doStartTag();
          if (_jspx_eval_c_choose_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\n\t\t\t\t\t");
            //  c:when
            com.liferay.taglib.core.WhenTag _jspx_th_c_when_8 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
            _jspx_th_c_when_8.setPageContext(_jspx_page_context);
            _jspx_th_c_when_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_7);
            _jspx_th_c_when_8.setTest( ((organization == null) || ((privateLayoutSetPrototype == null) && (organization.getPrivateLayoutsPageCount() == 0))) && !layoutSetPrototypes.isEmpty() );
            int _jspx_eval_c_when_8 = _jspx_th_c_when_8.doStartTag();
            if (_jspx_eval_c_when_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              out.write("\n\t\t\t\t\t\t");
              //  clay:alert
              com.liferay.frontend.taglib.clay.servlet.taglib.soy.AlertTag _jspx_th_clay_alert_1 = (com.liferay.frontend.taglib.clay.servlet.taglib.soy.AlertTag) _jspx_tagPool_clay_alert_title_style_message_nobody.get(com.liferay.frontend.taglib.clay.servlet.taglib.soy.AlertTag.class);
              _jspx_th_clay_alert_1.setPageContext(_jspx_page_context);
              _jspx_th_clay_alert_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_8);
              _jspx_th_clay_alert_1.setMessage( LanguageUtil.get(request, "this-action-cannot-be-undone") );
              _jspx_th_clay_alert_1.setStyle("warning");
              _jspx_th_clay_alert_1.setTitle( LanguageUtil.get(request, "warning") + ":" );
              int _jspx_eval_clay_alert_1 = _jspx_th_clay_alert_1.doStartTag();
              if (_jspx_th_clay_alert_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_clay_alert_title_style_message_nobody.reuse(_jspx_th_clay_alert_1);
                return;
              }
              _jspx_tagPool_clay_alert_title_style_message_nobody.reuse(_jspx_th_clay_alert_1);
              out.write("\n\n\t\t\t\t\t\t");
              //  aui:select
              com.liferay.taglib.aui.SelectTag _jspx_th_aui_select_1 = (com.liferay.taglib.aui.SelectTag) _jspx_tagPool_aui_select_name_label.get(com.liferay.taglib.aui.SelectTag.class);
              _jspx_th_aui_select_1.setPageContext(_jspx_page_context);
              _jspx_th_aui_select_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_8);
              _jspx_th_aui_select_1.setLabel("");
              _jspx_th_aui_select_1.setName("privateLayoutSetPrototypeId");
              int _jspx_eval_aui_select_1 = _jspx_th_aui_select_1.doStartTag();
              if (_jspx_eval_aui_select_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_aui_select_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_aui_select_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_aui_select_1.doInitBody();
                }
                do {
                  out.write("\n\t\t\t\t\t\t\t");
                  //  aui:option
                  com.liferay.taglib.aui.OptionTag _jspx_th_aui_option_2 = (com.liferay.taglib.aui.OptionTag) _jspx_tagPool_aui_option_value_selected_label_nobody.get(com.liferay.taglib.aui.OptionTag.class);
                  _jspx_th_aui_option_2.setPageContext(_jspx_page_context);
                  _jspx_th_aui_option_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_select_1);
                  _jspx_th_aui_option_2.setLabel(new String("none"));
                  _jspx_th_aui_option_2.setSelected( true );
                  _jspx_th_aui_option_2.setValue(new String(""));
                  int _jspx_eval_aui_option_2 = _jspx_th_aui_option_2.doStartTag();
                  if (_jspx_th_aui_option_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_aui_option_value_selected_label_nobody.reuse(_jspx_th_aui_option_2);
                    return;
                  }
                  _jspx_tagPool_aui_option_value_selected_label_nobody.reuse(_jspx_th_aui_option_2);
                  out.write("\n\n\t\t\t\t\t\t\t");

							for (LayoutSetPrototype layoutSetPrototype : layoutSetPrototypes) {
							
                  out.write("\n\n\t\t\t\t\t\t\t\t");
                  //  aui:option
                  com.liferay.taglib.aui.OptionTag _jspx_th_aui_option_3 = (com.liferay.taglib.aui.OptionTag) _jspx_tagPool_aui_option_value_label_nobody.get(com.liferay.taglib.aui.OptionTag.class);
                  _jspx_th_aui_option_3.setPageContext(_jspx_page_context);
                  _jspx_th_aui_option_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_select_1);
                  _jspx_th_aui_option_3.setLabel( HtmlUtil.escape(layoutSetPrototype.getName(locale)) );
                  _jspx_th_aui_option_3.setValue( layoutSetPrototype.getLayoutSetPrototypeId() );
                  int _jspx_eval_aui_option_3 = _jspx_th_aui_option_3.doStartTag();
                  if (_jspx_th_aui_option_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_aui_option_value_label_nobody.reuse(_jspx_th_aui_option_3);
                    return;
                  }
                  _jspx_tagPool_aui_option_value_label_nobody.reuse(_jspx_th_aui_option_3);
                  out.write("\n\n\t\t\t\t\t\t\t");

							}
							
                  out.write("\n\n\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_aui_select_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_aui_select_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_aui_select_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_aui_select_name_label.reuse(_jspx_th_aui_select_1);
                return;
              }
              _jspx_tagPool_aui_select_name_label.reuse(_jspx_th_aui_select_1);
              out.write("\n\n\t\t\t\t\t\t");
              //  c:choose
              com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_8 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
              _jspx_th_c_choose_8.setPageContext(_jspx_page_context);
              _jspx_th_c_choose_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_8);
              int _jspx_eval_c_choose_8 = _jspx_th_c_choose_8.doStartTag();
              if (_jspx_eval_c_choose_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                out.write("\n\t\t\t\t\t\t\t");
                //  c:when
                com.liferay.taglib.core.WhenTag _jspx_th_c_when_9 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                _jspx_th_c_when_9.setPageContext(_jspx_page_context);
                _jspx_th_c_when_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_8);
                _jspx_th_c_when_9.setTest( hasUnlinkLayoutSetPrototypePermission );
                int _jspx_eval_c_when_9 = _jspx_th_c_when_9.doStartTag();
                if (_jspx_eval_c_when_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\t\t\t\t\t\t\t\t<div class=\"hide\" id=\"");
                  if (_jspx_meth_portlet_namespace_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_9, _jspx_page_context))
                    return;
                  out.write("privateLayoutSetPrototypeIdOptions\">\n\t\t\t\t\t\t\t\t\t");
                  //  aui:input
                  com.liferay.taglib.aui.InputTag _jspx_th_aui_input_7 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_label_helpMessage_nobody.get(com.liferay.taglib.aui.InputTag.class);
                  _jspx_th_aui_input_7.setPageContext(_jspx_page_context);
                  _jspx_th_aui_input_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_9);
                  _jspx_th_aui_input_7.setHelpMessage("enable-propagation-of-changes-from-the-site-template-help");
                  _jspx_th_aui_input_7.setLabel("enable-propagation-of-changes-from-the-site-template");
                  _jspx_th_aui_input_7.setName("privateLayoutSetPrototypeLinkEnabled");
                  _jspx_th_aui_input_7.setType("checkbox");
                  _jspx_th_aui_input_7.setValue( true );
                  int _jspx_eval_aui_input_7 = _jspx_th_aui_input_7.doStartTag();
                  if (_jspx_th_aui_input_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_aui_input_value_type_name_label_helpMessage_nobody.reuse(_jspx_th_aui_input_7);
                    return;
                  }
                  _jspx_tagPool_aui_input_value_type_name_label_helpMessage_nobody.reuse(_jspx_th_aui_input_7);
                  out.write("\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t");
                }
                if (_jspx_th_c_when_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_9);
                  return;
                }
                _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_9);
                out.write("\n\t\t\t\t\t\t\t");
                //  c:otherwise
                com.liferay.taglib.core.OtherwiseTag _jspx_th_c_otherwise_4 = (com.liferay.taglib.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(com.liferay.taglib.core.OtherwiseTag.class);
                _jspx_th_c_otherwise_4.setPageContext(_jspx_page_context);
                _jspx_th_c_otherwise_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_8);
                int _jspx_eval_c_otherwise_4 = _jspx_th_c_otherwise_4.doStartTag();
                if (_jspx_eval_c_otherwise_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\t\t\t\t\t\t\t\t");
                  //  aui:input
                  com.liferay.taglib.aui.InputTag _jspx_th_aui_input_8 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
                  _jspx_th_aui_input_8.setPageContext(_jspx_page_context);
                  _jspx_th_aui_input_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_4);
                  _jspx_th_aui_input_8.setName("privateLayoutSetPrototypeLinkEnabled");
                  _jspx_th_aui_input_8.setType("hidden");
                  _jspx_th_aui_input_8.setValue( true );
                  int _jspx_eval_aui_input_8 = _jspx_th_aui_input_8.doStartTag();
                  if (_jspx_th_aui_input_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_8);
                    return;
                  }
                  _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_8);
                  out.write("\n\t\t\t\t\t\t\t");
                }
                if (_jspx_th_c_otherwise_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_4);
                  return;
                }
                _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_4);
                out.write("\n\t\t\t\t\t\t");
              }
              if (_jspx_th_c_choose_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_8);
                return;
              }
              _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_8);
              out.write("\n\t\t\t\t\t");
            }
            if (_jspx_th_c_when_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_8);
              return;
            }
            _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_8);
            out.write("\n\t\t\t\t\t");
            //  c:otherwise
            com.liferay.taglib.core.OtherwiseTag _jspx_th_c_otherwise_5 = (com.liferay.taglib.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(com.liferay.taglib.core.OtherwiseTag.class);
            _jspx_th_c_otherwise_5.setPageContext(_jspx_page_context);
            _jspx_th_c_otherwise_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_7);
            int _jspx_eval_c_otherwise_5 = _jspx_th_c_otherwise_5.doStartTag();
            if (_jspx_eval_c_otherwise_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              out.write("\n\t\t\t\t\t\t");
              //  c:choose
              com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_9 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
              _jspx_th_c_choose_9.setPageContext(_jspx_page_context);
              _jspx_th_c_choose_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_5);
              int _jspx_eval_c_choose_9 = _jspx_th_c_choose_9.doStartTag();
              if (_jspx_eval_c_choose_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                out.write("\n\t\t\t\t\t\t\t");
                //  c:when
                com.liferay.taglib.core.WhenTag _jspx_th_c_when_10 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                _jspx_th_c_when_10.setPageContext(_jspx_page_context);
                _jspx_th_c_when_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_9);
                _jspx_th_c_when_10.setTest( organization != null );
                int _jspx_eval_c_when_10 = _jspx_th_c_when_10.doStartTag();
                if (_jspx_eval_c_when_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("\n\t\t\t\t\t\t\t\t<div class=\"form-group\">\n\t\t\t\t\t\t\t\t\t");
                  //  c:choose
                  com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_10 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
                  _jspx_th_c_choose_10.setPageContext(_jspx_page_context);
                  _jspx_th_c_choose_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_10);
                  int _jspx_eval_c_choose_10 = _jspx_th_c_choose_10.doStartTag();
                  if (_jspx_eval_c_choose_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    out.write("\n\t\t\t\t\t\t\t\t\t\t");
                    //  c:when
                    com.liferay.taglib.core.WhenTag _jspx_th_c_when_11 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                    _jspx_th_c_when_11.setPageContext(_jspx_page_context);
                    _jspx_th_c_when_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_10);
                    _jspx_th_c_when_11.setTest( organization.getPrivateLayoutsPageCount() > 0 );
                    int _jspx_eval_c_when_11 = _jspx_th_c_when_11.doStartTag();
                    if (_jspx_eval_c_when_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                      out.write("\n\t\t\t\t\t\t\t\t\t\t\t");
                      //  liferay-ui:icon
                      com.liferay.taglib.ui.IconTag _jspx_th_liferay$1ui_icon_2 = (com.liferay.taglib.ui.IconTag) _jspx_tagPool_liferay$1ui_icon_url_target_method_message_label_iconCssClass_nobody.get(com.liferay.taglib.ui.IconTag.class);
                      _jspx_th_liferay$1ui_icon_2.setPageContext(_jspx_page_context);
                      _jspx_th_liferay$1ui_icon_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_11);
                      _jspx_th_liferay$1ui_icon_2.setIconCssClass("icon-search");
                      _jspx_th_liferay$1ui_icon_2.setLabel( true );
                      _jspx_th_liferay$1ui_icon_2.setMessage("open-private-pages");
                      _jspx_th_liferay$1ui_icon_2.setMethod("get");
                      _jspx_th_liferay$1ui_icon_2.setTarget("_blank");
                      _jspx_th_liferay$1ui_icon_2.setUrl( organizationGroup.getDisplayURL(themeDisplay, true) );
                      int _jspx_eval_liferay$1ui_icon_2 = _jspx_th_liferay$1ui_icon_2.doStartTag();
                      if (_jspx_th_liferay$1ui_icon_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_liferay$1ui_icon_url_target_method_message_label_iconCssClass_nobody.reuse(_jspx_th_liferay$1ui_icon_2);
                        return;
                      }
                      _jspx_tagPool_liferay$1ui_icon_url_target_method_message_label_iconCssClass_nobody.reuse(_jspx_th_liferay$1ui_icon_2);
                      out.write("\n\t\t\t\t\t\t\t\t\t\t");
                    }
                    if (_jspx_th_c_when_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_11);
                      return;
                    }
                    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_11);
                    out.write("\n\t\t\t\t\t\t\t\t\t\t");
                    if (_jspx_meth_c_otherwise_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_10, _jspx_page_context))
                      return;
                    out.write("\n\t\t\t\t\t\t\t\t\t");
                  }
                  if (_jspx_th_c_choose_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_10);
                    return;
                  }
                  _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_10);
                  out.write("\n\t\t\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t\t\t<div class=\"form-group\">\n\t\t\t\t\t\t\t\t\t");
                  //  c:choose
                  com.liferay.taglib.core.ChooseTag _jspx_th_c_choose_11 = (com.liferay.taglib.core.ChooseTag) _jspx_tagPool_c_choose.get(com.liferay.taglib.core.ChooseTag.class);
                  _jspx_th_c_choose_11.setPageContext(_jspx_page_context);
                  _jspx_th_c_choose_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_10);
                  int _jspx_eval_c_choose_11 = _jspx_th_c_choose_11.doStartTag();
                  if (_jspx_eval_c_choose_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    out.write("\n\t\t\t\t\t\t\t\t\t\t");
                    //  c:when
                    com.liferay.taglib.core.WhenTag _jspx_th_c_when_12 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                    _jspx_th_c_when_12.setPageContext(_jspx_page_context);
                    _jspx_th_c_when_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_11);
                    _jspx_th_c_when_12.setTest( (privateLayoutSetPrototype != null) && !organizationGroup.isStaged() && hasUnlinkLayoutSetPrototypePermission );
                    int _jspx_eval_c_when_12 = _jspx_th_c_when_12.doStartTag();
                    if (_jspx_eval_c_when_12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                      out.write("\n\t\t\t\t\t\t\t\t\t\t\t");
                      //  aui:input
                      com.liferay.taglib.aui.InputTag _jspx_th_aui_input_9 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_label_nobody.get(com.liferay.taglib.aui.InputTag.class);
                      _jspx_th_aui_input_9.setPageContext(_jspx_page_context);
                      _jspx_th_aui_input_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_12);
                      _jspx_th_aui_input_9.setLabel( LanguageUtil.format(request, "enable-propagation-of-changes-from-the-site-template-x", HtmlUtil.escape(privateLayoutSetPrototype.getName(locale)), false) );
                      _jspx_th_aui_input_9.setName("privateLayoutSetPrototypeLinkEnabled");
                      _jspx_th_aui_input_9.setType("checkbox");
                      _jspx_th_aui_input_9.setValue( privateLayoutSetPrototypeLinkEnabled );
                      int _jspx_eval_aui_input_9 = _jspx_th_aui_input_9.doStartTag();
                      if (_jspx_th_aui_input_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_aui_input_value_type_name_label_nobody.reuse(_jspx_th_aui_input_9);
                        return;
                      }
                      _jspx_tagPool_aui_input_value_type_name_label_nobody.reuse(_jspx_th_aui_input_9);
                      out.write("\n\t\t\t\t\t\t\t\t\t\t");
                    }
                    if (_jspx_th_c_when_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_12);
                      return;
                    }
                    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_12);
                    out.write("\n\t\t\t\t\t\t\t\t\t\t");
                    //  c:when
                    com.liferay.taglib.core.WhenTag _jspx_th_c_when_13 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
                    _jspx_th_c_when_13.setPageContext(_jspx_page_context);
                    _jspx_th_c_when_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_11);
                    _jspx_th_c_when_13.setTest( privateLayoutSetPrototype != null );
                    int _jspx_eval_c_when_13 = _jspx_th_c_when_13.doStartTag();
                    if (_jspx_eval_c_when_13 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                      out.write("\n\t\t\t\t\t\t\t\t\t\t\t");
                      //  liferay-ui:message
                      com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_6 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
                      _jspx_th_liferay$1ui_message_6.setPageContext(_jspx_page_context);
                      _jspx_th_liferay$1ui_message_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_13);
                      _jspx_th_liferay$1ui_message_6.setArguments( new Object[] {HtmlUtil.escape(privateLayoutSetPrototype.getName(locale))} );
                      _jspx_th_liferay$1ui_message_6.setKey("these-pages-are-linked-to-site-template-x");
                      _jspx_th_liferay$1ui_message_6.setTranslateArguments( false );
                      int _jspx_eval_liferay$1ui_message_6 = _jspx_th_liferay$1ui_message_6.doStartTag();
                      if (_jspx_th_liferay$1ui_message_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_6);
                        return;
                      }
                      _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_6);
                      out.write("\n\n\t\t\t\t\t\t\t\t\t\t\t");
                      //  aui:input
                      com.liferay.taglib.aui.InputTag _jspx_th_aui_input_10 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
                      _jspx_th_aui_input_10.setPageContext(_jspx_page_context);
                      _jspx_th_aui_input_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_13);
                      _jspx_th_aui_input_10.setName("privateLayoutSetPrototypeLinkEnabled");
                      _jspx_th_aui_input_10.setType("hidden");
                      _jspx_th_aui_input_10.setValue( privateLayoutSetPrototypeLinkEnabled );
                      int _jspx_eval_aui_input_10 = _jspx_th_aui_input_10.doStartTag();
                      if (_jspx_th_aui_input_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_10);
                        return;
                      }
                      _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_10);
                      out.write("\n\t\t\t\t\t\t\t\t\t\t");
                    }
                    if (_jspx_th_c_when_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_13);
                      return;
                    }
                    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_13);
                    out.write("\n\t\t\t\t\t\t\t\t\t");
                  }
                  if (_jspx_th_c_choose_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_11);
                    return;
                  }
                  _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_11);
                  out.write("\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t");
                }
                if (_jspx_th_c_when_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_10);
                  return;
                }
                _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_10);
                out.write("\n\t\t\t\t\t\t");
              }
              if (_jspx_th_c_choose_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_9);
                return;
              }
              _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_9);
              out.write("\n\t\t\t\t\t");
            }
            if (_jspx_th_c_otherwise_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_5);
              return;
            }
            _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_5);
            out.write("\n\t\t\t\t");
          }
          if (_jspx_th_c_choose_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_7);
            return;
          }
          _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_7);
          out.write("\n\t\t\t</div>\n\n\t\t\t<div class=\"sheet-footer\">\n\t\t\t\t");
          //  aui:button
          com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_0 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_type_primary_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
          _jspx_th_aui_button_0.setPageContext(_jspx_page_context);
          _jspx_th_aui_button_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
          _jspx_th_aui_button_0.setPrimary( true );
          _jspx_th_aui_button_0.setType("submit");
          int _jspx_eval_aui_button_0 = _jspx_th_aui_button_0.doStartTag();
          if (_jspx_th_aui_button_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_aui_button_type_primary_nobody.reuse(_jspx_th_aui_button_0);
            return;
          }
          _jspx_tagPool_aui_button_type_primary_nobody.reuse(_jspx_th_aui_button_0);
          out.write("\n\n\t\t\t\t");

				OrganizationScreenNavigationDisplayContext organizationScreenNavigationDisplayContext = (OrganizationScreenNavigationDisplayContext)request.getAttribute(UsersAdminWebKeys.ORGANIZATION_SCREEN_NAVIGATION_DISPLAY_CONTEXT);
				
          out.write("\n\n\t\t\t\t");
          //  aui:button
          com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_1 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_type_href_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
          _jspx_th_aui_button_1.setPageContext(_jspx_page_context);
          _jspx_th_aui_button_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
          _jspx_th_aui_button_1.setHref( organizationScreenNavigationDisplayContext.getBackURL() );
          _jspx_th_aui_button_1.setType("cancel");
          int _jspx_eval_aui_button_1 = _jspx_th_aui_button_1.doStartTag();
          if (_jspx_th_aui_button_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_aui_button_type_href_nobody.reuse(_jspx_th_aui_button_1);
            return;
          }
          _jspx_tagPool_aui_button_type_href_nobody.reuse(_jspx_th_aui_button_1);
          out.write("\n\t\t\t</div>\n\t\t</div>\n\n\t\t");

		if ((organization == null) && layoutSetPrototypes.isEmpty()) {
			request.setAttribute(WebKeys.FORM_NAVIGATOR_SECTION_SHOW + "pages", Boolean.FALSE);
		}
		
          out.write("\n\n\t\t");
          //  c:if
          com.liferay.taglib.core.IfTag _jspx_th_c_if_1 = (com.liferay.taglib.core.IfTag) _jspx_tagPool_c_if_test.get(com.liferay.taglib.core.IfTag.class);
          _jspx_th_c_if_1.setPageContext(_jspx_page_context);
          _jspx_th_c_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
          _jspx_th_c_if_1.setTest( !site );
          int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
          if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\n\t\t\t");
            if (_jspx_meth_aui_script_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
              return;
            out.write("\n\t\t");
          }
          if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
            return;
          }
          _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
          out.write('\n');
          out.write('	');
        }
        if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
          return;
        }
        _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
        out.write('\n');
        out.write('	');
        //  c:otherwise
        com.liferay.taglib.core.OtherwiseTag _jspx_th_c_otherwise_7 = (com.liferay.taglib.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(com.liferay.taglib.core.OtherwiseTag.class);
        _jspx_th_c_otherwise_7.setPageContext(_jspx_page_context);
        _jspx_th_c_otherwise_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
        int _jspx_eval_c_otherwise_7 = _jspx_th_c_otherwise_7.doStartTag();
        if (_jspx_eval_c_otherwise_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          out.write("\n\t\t");
          //  aui:input
          com.liferay.taglib.aui.InputTag _jspx_th_aui_input_11 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
          _jspx_th_aui_input_11.setPageContext(_jspx_page_context);
          _jspx_th_aui_input_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_7);
          _jspx_th_aui_input_11.setName("site");
          _jspx_th_aui_input_11.setType("hidden");
          _jspx_th_aui_input_11.setValue( site );
          int _jspx_eval_aui_input_11 = _jspx_th_aui_input_11.doStartTag();
          if (_jspx_th_aui_input_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_11);
            return;
          }
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_11);
          out.write("\n\n\t\t");
          if (_jspx_meth_liferay$1ui_message_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_otherwise_7, _jspx_page_context))
            return;
          out.write('\n');
          out.write('	');
        }
        if (_jspx_th_c_otherwise_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_7);
          return;
        }
        _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_7);
        out.write('\n');
      }
      if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
        return;
      }
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
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

  private boolean _jspx_meth_liferay$1ui_message_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_0 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_0.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_1);
    _jspx_th_liferay$1ui_message_0.setKey("by-clicking-this-toggle-you-could-create-a-public-and-or-private-site-for-your-organization");
    int _jspx_eval_liferay$1ui_message_0 = _jspx_th_liferay$1ui_message_0.doStartTag();
    if (_jspx_th_liferay$1ui_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_0);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_0);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_0 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_0.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
    int _jspx_eval_portlet_namespace_0 = _jspx_th_portlet_namespace_0.doStartTag();
    if (_jspx_th_portlet_namespace_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_0);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_0);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_message_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_1 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_1.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
    _jspx_th_liferay$1ui_message_1.setKey("public-pages");
    int _jspx_eval_liferay$1ui_message_1 = _jspx_th_liferay$1ui_message_1.doStartTag();
    if (_jspx_th_liferay$1ui_message_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_1);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_1);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_1 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_1.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_3);
    int _jspx_eval_portlet_namespace_1 = _jspx_th_portlet_namespace_1.doStartTag();
    if (_jspx_th_portlet_namespace_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_1);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_1);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    com.liferay.taglib.core.OtherwiseTag _jspx_th_c_otherwise_3 = (com.liferay.taglib.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(com.liferay.taglib.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_3.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_5);
    int _jspx_eval_c_otherwise_3 = _jspx_th_c_otherwise_3.doStartTag();
    if (_jspx_eval_c_otherwise_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\n\t\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_liferay$1ui_message_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_otherwise_3, _jspx_page_context))
        return true;
      out.write("\n\t\t\t\t\t\t\t\t\t\t");
    }
    if (_jspx_th_c_otherwise_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_3);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_3);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_message_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_otherwise_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_2 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_2.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_3);
    _jspx_th_liferay$1ui_message_2.setKey("this-organization-does-not-have-any-public-pages");
    int _jspx_eval_liferay$1ui_message_2 = _jspx_th_liferay$1ui_message_2.doStartTag();
    if (_jspx_th_liferay$1ui_message_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_2);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_2);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_message_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_4 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_4.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
    _jspx_th_liferay$1ui_message_4.setKey("private-pages");
    int _jspx_eval_liferay$1ui_message_4 = _jspx_th_liferay$1ui_message_4.doStartTag();
    if (_jspx_th_liferay$1ui_message_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_4);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_4);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_9, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_2 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_2.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_9);
    int _jspx_eval_portlet_namespace_2 = _jspx_th_portlet_namespace_2.doStartTag();
    if (_jspx_th_portlet_namespace_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_2);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_2);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_10, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    com.liferay.taglib.core.OtherwiseTag _jspx_th_c_otherwise_6 = (com.liferay.taglib.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(com.liferay.taglib.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_6.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_10);
    int _jspx_eval_c_otherwise_6 = _jspx_th_c_otherwise_6.doStartTag();
    if (_jspx_eval_c_otherwise_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\n\t\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_liferay$1ui_message_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_otherwise_6, _jspx_page_context))
        return true;
      out.write("\n\t\t\t\t\t\t\t\t\t\t");
    }
    if (_jspx_th_c_otherwise_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_6);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_6);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_message_5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_otherwise_6, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_5 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_5.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_6);
    _jspx_th_liferay$1ui_message_5.setKey("this-organization-does-not-have-any-private-pages");
    int _jspx_eval_liferay$1ui_message_5 = _jspx_th_liferay$1ui_message_5.doStartTag();
    if (_jspx_th_liferay$1ui_message_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_5);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_5);
    return false;
  }

  private boolean _jspx_meth_aui_script_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:script
    com.liferay.taglib.aui.ScriptTag _jspx_th_aui_script_0 = (com.liferay.taglib.aui.ScriptTag) _jspx_tagPool_aui_script.get(com.liferay.taglib.aui.ScriptTag.class);
    _jspx_th_aui_script_0.setPageContext(_jspx_page_context);
    _jspx_th_aui_script_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    int _jspx_eval_aui_script_0 = _jspx_th_aui_script_0.doStartTag();
    if (_jspx_eval_aui_script_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_aui_script_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_aui_script_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_aui_script_0.doInitBody();
      }
      do {
        out.write("\n\t\t\t\tfunction ");
        if (_jspx_meth_portlet_namespace_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_0, _jspx_page_context))
          return true;
        out.write("isVisible(currentValue, value) {\n\t\t\t\t\treturn currentValue != '';\n\t\t\t\t}\n\n\t\t\t\tLiferay.Util.toggleBoxes('");
        if (_jspx_meth_portlet_namespace_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_0, _jspx_page_context))
          return true;
        out.write("site', '");
        if (_jspx_meth_portlet_namespace_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_0, _jspx_page_context))
          return true;
        out.write("siteTemplates');\n\n\t\t\t\tLiferay.Util.toggleSelectBox('");
        if (_jspx_meth_portlet_namespace_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_0, _jspx_page_context))
          return true;
        out.write("publicLayoutSetPrototypeId', ");
        if (_jspx_meth_portlet_namespace_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_0, _jspx_page_context))
          return true;
        out.write("isVisible, '");
        if (_jspx_meth_portlet_namespace_8((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_0, _jspx_page_context))
          return true;
        out.write("publicLayoutSetPrototypeIdOptions');\n\t\t\t\tLiferay.Util.toggleSelectBox('");
        if (_jspx_meth_portlet_namespace_9((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_0, _jspx_page_context))
          return true;
        out.write("privateLayoutSetPrototypeId', ");
        if (_jspx_meth_portlet_namespace_10((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_0, _jspx_page_context))
          return true;
        out.write("isVisible, '");
        if (_jspx_meth_portlet_namespace_11((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_0, _jspx_page_context))
          return true;
        out.write("privateLayoutSetPrototypeIdOptions');\n\t\t\t");
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

  private boolean _jspx_meth_portlet_namespace_3(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_script_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_3 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_3.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_0);
    int _jspx_eval_portlet_namespace_3 = _jspx_th_portlet_namespace_3.doStartTag();
    if (_jspx_th_portlet_namespace_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_3);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_3);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_4(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_script_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_4 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_4.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_0);
    int _jspx_eval_portlet_namespace_4 = _jspx_th_portlet_namespace_4.doStartTag();
    if (_jspx_th_portlet_namespace_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_4);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_4);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_5(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_script_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_5 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_5.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_0);
    int _jspx_eval_portlet_namespace_5 = _jspx_th_portlet_namespace_5.doStartTag();
    if (_jspx_th_portlet_namespace_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_5);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_5);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_6(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_script_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_6 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_6.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_0);
    int _jspx_eval_portlet_namespace_6 = _jspx_th_portlet_namespace_6.doStartTag();
    if (_jspx_th_portlet_namespace_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_6);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_6);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_7(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_script_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_7 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_7.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_0);
    int _jspx_eval_portlet_namespace_7 = _jspx_th_portlet_namespace_7.doStartTag();
    if (_jspx_th_portlet_namespace_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_7);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_7);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_8(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_script_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_8 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_8.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_0);
    int _jspx_eval_portlet_namespace_8 = _jspx_th_portlet_namespace_8.doStartTag();
    if (_jspx_th_portlet_namespace_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_8);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_8);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_9(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_script_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_9 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_9.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_0);
    int _jspx_eval_portlet_namespace_9 = _jspx_th_portlet_namespace_9.doStartTag();
    if (_jspx_th_portlet_namespace_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_9);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_9);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_10(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_script_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_10 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_10.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_0);
    int _jspx_eval_portlet_namespace_10 = _jspx_th_portlet_namespace_10.doStartTag();
    if (_jspx_th_portlet_namespace_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_10);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_10);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_11(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_script_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_11 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_11.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_0);
    int _jspx_eval_portlet_namespace_11 = _jspx_th_portlet_namespace_11.doStartTag();
    if (_jspx_th_portlet_namespace_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_11);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_11);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_message_7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_otherwise_7, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_7 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_7.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_7);
    _jspx_th_liferay$1ui_message_7.setKey("you-do-not-have-the-required-permissions");
    int _jspx_eval_liferay$1ui_message_7 = _jspx_th_liferay$1ui_message_7.doStartTag();
    if (_jspx_th_liferay$1ui_message_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_7);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_7);
    return false;
  }
}
