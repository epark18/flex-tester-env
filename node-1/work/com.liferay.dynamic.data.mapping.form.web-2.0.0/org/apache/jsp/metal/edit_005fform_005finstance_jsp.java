package org.apache.jsp.metal;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.liferay.dynamic.data.mapping.constants.DDMWebKeys;
import com.liferay.dynamic.data.mapping.exception.FormInstanceNameException;
import com.liferay.dynamic.data.mapping.exception.FormInstanceSettingsRedirectURLException;
import com.liferay.dynamic.data.mapping.exception.StorageException;
import com.liferay.dynamic.data.mapping.exception.StructureDefinitionException;
import com.liferay.dynamic.data.mapping.exception.StructureLayoutException;
import com.liferay.dynamic.data.mapping.exception.StructureNameException;
import com.liferay.dynamic.data.mapping.form.web.FormInstanceFieldSettingsException;
import com.liferay.dynamic.data.mapping.form.web.internal.display.context.DDMFormAdminDisplayContext;
import com.liferay.dynamic.data.mapping.form.web.internal.display.context.DDMFormViewFormInstanceRecordsDisplayContext;
import com.liferay.dynamic.data.mapping.form.web.internal.display.context.util.FieldSetPermissionCheckerHelper;
import com.liferay.dynamic.data.mapping.form.web.internal.display.context.util.FormInstancePermissionCheckerHelper;
import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecordVersion;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.dynamic.data.mapping.validator.DDMFormLayoutValidationException;
import com.liferay.dynamic.data.mapping.validator.DDMFormValidationException;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.bean.BeanParamUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.language.UnicodeLanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.taglib.search.DateSearchEntry;
import com.liferay.taglib.search.ResultRow;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import javax.portlet.PortletURL;

public final class edit_005fform_005finstance_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(4);
    _jspx_dependants.add("/metal/init.jsp");
    _jspx_dependants.add("/admin/init.jsp");
    _jspx_dependants.add("/admin/init-ext.jsp");
    _jspx_dependants.add("/admin/exceptions.jspf");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_namespace_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_actionURL_var_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_param_value_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_message_key_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_error_exception;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_value_type_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1util_html$1top;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_script;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1portlet_resourceURL_var_id_copyCurrentRenderParameters_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_error_message_exception_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_translation$1manager_id_defaultLanguageId_changeableDefaultLanguage_availableLocales_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_form_name_method_enctype_cssClass_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1theme_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_input$1editor_showSource_placeholder_name_editorName_cssClass_contents_autoCreate_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_clay_navigation$1bar_navigationItems_inverted_elementClasses_componentId_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_portlet_namespace_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_actionURL_var_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_param_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_message_key_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_error_exception = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_value_type_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1util_html$1top = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_script = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1portlet_resourceURL_var_id_copyCurrentRenderParameters_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_error_message_exception_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_translation$1manager_id_defaultLanguageId_changeableDefaultLanguage_availableLocales_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_form_name_method_enctype_cssClass_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1theme_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_input$1editor_showSource_placeholder_name_editorName_cssClass_contents_autoCreate_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_clay_navigation$1bar_navigationItems_inverted_elementClasses_componentId_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_portlet_namespace_nobody.release();
    _jspx_tagPool_portlet_actionURL_var_name.release();
    _jspx_tagPool_portlet_param_value_name_nobody.release();
    _jspx_tagPool_liferay$1ui_message_key_nobody.release();
    _jspx_tagPool_liferay$1ui_error_exception.release();
    _jspx_tagPool_aui_input_value_type_name_nobody.release();
    _jspx_tagPool_liferay$1util_html$1top.release();
    _jspx_tagPool_aui_script.release();
    _jspx_tagPool_liferay$1portlet_resourceURL_var_id_copyCurrentRenderParameters_nobody.release();
    _jspx_tagPool_portlet_defineObjects_nobody.release();
    _jspx_tagPool_liferay$1ui_error_message_exception_nobody.release();
    _jspx_tagPool_aui_translation$1manager_id_defaultLanguageId_changeableDefaultLanguage_availableLocales_nobody.release();
    _jspx_tagPool_aui_form_name_method_enctype_cssClass_action.release();
    _jspx_tagPool_liferay$1theme_defineObjects_nobody.release();
    _jspx_tagPool_liferay$1ui_input$1editor_showSource_placeholder_name_editorName_cssClass_contents_autoCreate_nobody.release();
    _jspx_tagPool_liferay$1frontend_defineObjects_nobody.release();
    _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.release();
    _jspx_tagPool_clay_navigation$1bar_navigationItems_inverted_elementClasses_componentId_nobody.release();
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

DDMFormAdminDisplayContext ddmFormAdminDisplayContext = (DDMFormAdminDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');
      if (_jspx_meth_aui_script_0(_jspx_page_context))
        return;
      out.write('\n');
      out.write('\n');

String dataProviderInstanceParameterSettingsURL = ddmFormAdminDisplayContext.getDataProviderInstanceParameterSettingsURL();
String dataProviderInstancesURL = ddmFormAdminDisplayContext.getDataProviderInstancesURL();
String functionsMetadata = ddmFormAdminDisplayContext.getFunctionsMetadata();
String functionsURL = ddmFormAdminDisplayContext.getFunctionsURL();
String mainRequire = ddmFormAdminDisplayContext.getMainRequire();
String rolesURL = ddmFormAdminDisplayContext.getRolesURL();
String serializedDDMFormRules = ddmFormAdminDisplayContext.getSerializedDDMFormRules();
String serializedFormBuilderContext = ddmFormAdminDisplayContext.getSerializedFormBuilderContext();

      out.write('\n');
      out.write('\n');
      //  liferay-util:html-top
      com.liferay.taglib.util.HtmlTopTag _jspx_th_liferay$1util_html$1top_0 = (com.liferay.taglib.util.HtmlTopTag) _jspx_tagPool_liferay$1util_html$1top.get(com.liferay.taglib.util.HtmlTopTag.class);
      _jspx_th_liferay$1util_html$1top_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1util_html$1top_0.setParent(null);
      int _jspx_eval_liferay$1util_html$1top_0 = _jspx_th_liferay$1util_html$1top_0.doStartTag();
      if (_jspx_eval_liferay$1util_html$1top_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_liferay$1util_html$1top_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_liferay$1util_html$1top_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_liferay$1util_html$1top_0.doInitBody();
        }
        do {
          out.write("\n\t<link href=\"");
          out.print( PortalUtil.getStaticResourceURL(request, application.getContextPath() + "/metal/css/main.css") );
          out.write("\" rel=\"stylesheet\" type=\"text/css\" />\n");
          int evalDoAfterBody = _jspx_th_liferay$1util_html$1top_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_liferay$1util_html$1top_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
      }
      if (_jspx_th_liferay$1util_html$1top_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1util_html$1top.reuse(_jspx_th_liferay$1util_html$1top_0);
        return;
      }
      _jspx_tagPool_liferay$1util_html$1top.reuse(_jspx_th_liferay$1util_html$1top_0);
      out.write('\n');
      out.write('\n');

String redirect = ParamUtil.getString(request, "redirect");

DDMFormInstance formInstance = ddmFormAdminDisplayContext.getDDMFormInstance();

long formInstanceId = BeanParamUtil.getLong(formInstance, request, "formInstanceId");
long groupId = BeanParamUtil.getLong(formInstance, request, "groupId", scopeGroupId);
long ddmStructureId = BeanParamUtil.getLong(formInstance, request, "structureId");

String defaultLanguageId = ddmFormAdminDisplayContext.getDefaultLanguageId();

Locale[] availableLocales = ddmFormAdminDisplayContext.getAvailableLocales();

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

renderResponse.setTitle((formInstance == null) ? LanguageUtil.get(request, "new-form") : LanguageUtil.get(request, "edit-form"));

boolean isFormPublished = ddmFormAdminDisplayContext.isFormPublished();
boolean isFormSaved = formInstance != null ? true : false;
String disableCopyBtnClass = "";

if (!isFormPublished && isFormSaved) {
	disableCopyBtnClass = "ddm-btn-disabled";
}

      out.write('\n');
      out.write('\n');
      //  liferay-util:html-top
      com.liferay.taglib.util.HtmlTopTag _jspx_th_liferay$1util_html$1top_1 = (com.liferay.taglib.util.HtmlTopTag) _jspx_tagPool_liferay$1util_html$1top.get(com.liferay.taglib.util.HtmlTopTag.class);
      _jspx_th_liferay$1util_html$1top_1.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1util_html$1top_1.setParent(null);
      int _jspx_eval_liferay$1util_html$1top_1 = _jspx_th_liferay$1util_html$1top_1.doStartTag();
      if (_jspx_eval_liferay$1util_html$1top_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_liferay$1util_html$1top_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_liferay$1util_html$1top_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_liferay$1util_html$1top_1.doInitBody();
        }
        do {
          out.write("\n\t<link href=\"");
          out.print( PortalUtil.getStaticResourceURL(request, "/o/dynamic-data-mapping-form-builder/metal/css/main.css") );
          out.write("\" rel=\"stylesheet\" type=\"text/css\" />\n");
          int evalDoAfterBody = _jspx_th_liferay$1util_html$1top_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_liferay$1util_html$1top_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
      }
      if (_jspx_th_liferay$1util_html$1top_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1util_html$1top.reuse(_jspx_th_liferay$1util_html$1top_1);
        return;
      }
      _jspx_tagPool_liferay$1util_html$1top.reuse(_jspx_th_liferay$1util_html$1top_1);
      out.write('\n');
      out.write('\n');
      //  portlet:actionURL
      com.liferay.taglib.portlet.ActionURLTag _jspx_th_portlet_actionURL_0 = (com.liferay.taglib.portlet.ActionURLTag) _jspx_tagPool_portlet_actionURL_var_name.get(com.liferay.taglib.portlet.ActionURLTag.class);
      _jspx_th_portlet_actionURL_0.setPageContext(_jspx_page_context);
      _jspx_th_portlet_actionURL_0.setParent(null);
      _jspx_th_portlet_actionURL_0.setName("saveFormInstance");
      _jspx_th_portlet_actionURL_0.setVar("saveFormInstanceURL");
      int _jspx_eval_portlet_actionURL_0 = _jspx_th_portlet_actionURL_0.doStartTag();
      if (_jspx_eval_portlet_actionURL_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write('\n');
        out.write('	');
        if (_jspx_meth_portlet_param_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_actionURL_0, _jspx_page_context))
          return;
        out.write('\n');
      }
      if (_jspx_th_portlet_actionURL_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_actionURL_var_name.reuse(_jspx_th_portlet_actionURL_0);
        return;
      }
      _jspx_tagPool_portlet_actionURL_var_name.reuse(_jspx_th_portlet_actionURL_0);
      java.lang.String saveFormInstanceURL = null;
      saveFormInstanceURL = (java.lang.String) _jspx_page_context.findAttribute("saveFormInstanceURL");
      out.write("\n\n<div class=\"lfr-alert-container\">\n\t<div class=\"container-fluid-1280 lfr-alert-wrapper\"></div>\n</div>\n\n<div class=\"portlet-forms\" id=\"");
      if (_jspx_meth_portlet_namespace_1(_jspx_page_context))
        return;
      out.write("formContainer\">\n\t");
      //  clay:navigation-bar
      com.liferay.frontend.taglib.clay.servlet.taglib.soy.NavigationBarTag _jspx_th_clay_navigation$1bar_0 = (com.liferay.frontend.taglib.clay.servlet.taglib.soy.NavigationBarTag) _jspx_tagPool_clay_navigation$1bar_navigationItems_inverted_elementClasses_componentId_nobody.get(com.liferay.frontend.taglib.clay.servlet.taglib.soy.NavigationBarTag.class);
      _jspx_th_clay_navigation$1bar_0.setPageContext(_jspx_page_context);
      _jspx_th_clay_navigation$1bar_0.setParent(null);
      _jspx_th_clay_navigation$1bar_0.setComponentId("formsNavigationBar");
      _jspx_th_clay_navigation$1bar_0.setElementClasses("forms-management-bar");
      _jspx_th_clay_navigation$1bar_0.setInverted( true );
      _jspx_th_clay_navigation$1bar_0.setNavigationItems( ddmFormAdminDisplayContext.getFormBuilderNavigationItems() );
      int _jspx_eval_clay_navigation$1bar_0 = _jspx_th_clay_navigation$1bar_0.doStartTag();
      if (_jspx_th_clay_navigation$1bar_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_clay_navigation$1bar_navigationItems_inverted_elementClasses_componentId_nobody.reuse(_jspx_th_clay_navigation$1bar_0);
        return;
      }
      _jspx_tagPool_clay_navigation$1bar_navigationItems_inverted_elementClasses_componentId_nobody.reuse(_jspx_th_clay_navigation$1bar_0);
      out.write("\n\n\t<nav class=\"management-bar management-bar-light navbar navbar-expand-md toolbar-group-field\">\n\t\t<div class=\"autosave-bar container toolbar\">\n\t\t\t<div class=\"navbar-form navbar-form-autofit navbar-overlay toolbar-group-content\">\n\t\t\t\t<span class=\"autosave-feedback management-bar-text\" id=\"");
      if (_jspx_meth_portlet_namespace_2(_jspx_page_context))
        return;
      out.write("autosaveMessage\"></span>\n\t\t\t</div>\n\n\t\t\t<ul class=\"navbar-nav toolbar-group-field\">\n\t\t\t\t<li class=\"nav-item\">\n\t\t\t\t\t<button class=\"btn btn-secondary lfr-ddm-share-url-button nav-btn nav-btn-monospaced share-form-icon ");
      out.print( disableCopyBtnClass );
      out.write(' ');
      out.print( (!isFormPublished && !isFormSaved) ? "hide" : "" );
      out.write("\" data-original-title=\"");
      if (_jspx_meth_liferay$1ui_message_0(_jspx_page_context))
        return;
      out.write("\" id=\"");
      if (_jspx_meth_portlet_namespace_3(_jspx_page_context))
        return;
      out.write("publishIcon\" title=\"");
      out.print( (disableCopyBtnClass == "") ? LanguageUtil.get(request, "copy-url") : LanguageUtil.get(request, "publish-the-form-to-get-its-shareable-link") );
      out.write("\" type=\"button\">\n\t\t\t\t\t\t<svg class=\"lexicon-icon\">\n\t\t\t\t\t\t\t<use xlink:href=\"");
      out.print( ddmFormAdminDisplayContext.getLexiconIconsPath() );
      out.write("link\" />\n\t\t\t\t\t\t</svg>\n\t\t\t\t\t</button>\n\t\t\t\t</li>\n\t\t\t\t<li class=\"nav-item\">\n\t\t\t\t\t<button class=\"btn btn-primary lfr-ddm-add-field lfr-ddm-plus-button nav-btn nav-btn-monospaced\" id=\"addFieldButton\">\n\t\t\t\t\t\t<svg class=\"lexicon-icon\">\n\t\t\t\t\t\t\t<use xlink:href=\"");
      out.print( ddmFormAdminDisplayContext.getLexiconIconsPath() );
      out.write("plus\" />\n\t\t\t\t\t\t</svg>\n\t\t\t\t\t</button>\n\t\t\t\t</li>\n\t\t\t</ul>\n\t\t</div>\n\t</nav>\n\n\t<div class=\"container-fluid-1280 ddm-translation-manager\">\n\t\t");
      //  aui:translation-manager
      com.liferay.taglib.aui.TranslationManagerTag _jspx_th_aui_translation$1manager_0 = (com.liferay.taglib.aui.TranslationManagerTag) _jspx_tagPool_aui_translation$1manager_id_defaultLanguageId_changeableDefaultLanguage_availableLocales_nobody.get(com.liferay.taglib.aui.TranslationManagerTag.class);
      _jspx_th_aui_translation$1manager_0.setPageContext(_jspx_page_context);
      _jspx_th_aui_translation$1manager_0.setParent(null);
      _jspx_th_aui_translation$1manager_0.setAvailableLocales( availableLocales );
      _jspx_th_aui_translation$1manager_0.setChangeableDefaultLanguage( false );
      _jspx_th_aui_translation$1manager_0.setDefaultLanguageId( defaultLanguageId );
      _jspx_th_aui_translation$1manager_0.setId("translationManager");
      int _jspx_eval_aui_translation$1manager_0 = _jspx_th_aui_translation$1manager_0.doStartTag();
      if (_jspx_th_aui_translation$1manager_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_translation$1manager_id_defaultLanguageId_changeableDefaultLanguage_availableLocales_nobody.reuse(_jspx_th_aui_translation$1manager_0);
        return;
      }
      _jspx_tagPool_aui_translation$1manager_id_defaultLanguageId_changeableDefaultLanguage_availableLocales_nobody.reuse(_jspx_th_aui_translation$1manager_0);
      out.write("\n\t</div>\n\n\t");
      //  aui:form
      com.liferay.taglib.aui.FormTag _jspx_th_aui_form_0 = (com.liferay.taglib.aui.FormTag) _jspx_tagPool_aui_form_name_method_enctype_cssClass_action.get(com.liferay.taglib.aui.FormTag.class);
      _jspx_th_aui_form_0.setPageContext(_jspx_page_context);
      _jspx_th_aui_form_0.setParent(null);
      _jspx_th_aui_form_0.setAction( saveFormInstanceURL );
      _jspx_th_aui_form_0.setCssClass("ddm-form-builder-form");
      _jspx_th_aui_form_0.setDynamicAttribute(null, "enctype", new String("multipart/form-data"));
      _jspx_th_aui_form_0.setMethod("post");
      _jspx_th_aui_form_0.setName("editForm");
      int _jspx_eval_aui_form_0 = _jspx_th_aui_form_0.doStartTag();
      if (_jspx_eval_aui_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\n\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_0 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_0.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_aui_input_0.setName("redirect");
        _jspx_th_aui_input_0.setType("hidden");
        _jspx_th_aui_input_0.setValue( redirect );
        int _jspx_eval_aui_input_0 = _jspx_th_aui_input_0.doStartTag();
        if (_jspx_th_aui_input_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_0);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_0);
        out.write("\n\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_1 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_1.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_aui_input_1.setName("formInstanceId");
        _jspx_th_aui_input_1.setType("hidden");
        _jspx_th_aui_input_1.setValue( formInstanceId );
        int _jspx_eval_aui_input_1 = _jspx_th_aui_input_1.doStartTag();
        if (_jspx_th_aui_input_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_1);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_1);
        out.write("\n\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_2 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_2.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_aui_input_2.setName("groupId");
        _jspx_th_aui_input_2.setType("hidden");
        _jspx_th_aui_input_2.setValue( groupId );
        int _jspx_eval_aui_input_2 = _jspx_th_aui_input_2.doStartTag();
        if (_jspx_th_aui_input_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_2);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_2);
        out.write("\n\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_3 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_3.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_aui_input_3.setName("ddmStructureId");
        _jspx_th_aui_input_3.setType("hidden");
        _jspx_th_aui_input_3.setValue( ddmStructureId );
        int _jspx_eval_aui_input_3 = _jspx_th_aui_input_3.doStartTag();
        if (_jspx_th_aui_input_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_3);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_3);
        out.write("\n\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_4 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_4.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_aui_input_4.setName("name");
        _jspx_th_aui_input_4.setType("hidden");
        _jspx_th_aui_input_4.setValue( ddmFormAdminDisplayContext.getFormLocalizedName() );
        int _jspx_eval_aui_input_4 = _jspx_th_aui_input_4.doStartTag();
        if (_jspx_th_aui_input_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_4);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_4);
        out.write("\n\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_5 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_5.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_aui_input_5.setName("description");
        _jspx_th_aui_input_5.setType("hidden");
        _jspx_th_aui_input_5.setValue( ddmFormAdminDisplayContext.getFormLocalizedDescription() );
        int _jspx_eval_aui_input_5 = _jspx_th_aui_input_5.doStartTag();
        if (_jspx_th_aui_input_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_5);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_5);
        out.write("\n\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_6 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_6.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_aui_input_6.setName("serializedFormBuilderContext");
        _jspx_th_aui_input_6.setType("hidden");
        _jspx_th_aui_input_6.setValue( serializedFormBuilderContext );
        int _jspx_eval_aui_input_6 = _jspx_th_aui_input_6.doStartTag();
        if (_jspx_th_aui_input_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_6);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_6);
        out.write("\n\t\t");
        if (_jspx_meth_aui_input_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
          return;
        out.write("\n\n\t\t");
        out.write('\n');
        out.write('\n');
        //  liferay-ui:error
        com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_0 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_message_exception_nobody.get(com.liferay.taglib.ui.ErrorTag.class);
        _jspx_th_liferay$1ui_error_0.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_error_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_liferay$1ui_error_0.setException( DDMFormLayoutValidationException.class );
        _jspx_th_liferay$1ui_error_0.setMessage("please-enter-a-valid-form-layout");
        int _jspx_eval_liferay$1ui_error_0 = _jspx_th_liferay$1ui_error_0.doStartTag();
        if (_jspx_th_liferay$1ui_error_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_0);
          return;
        }
        _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_0);
        out.write('\n');
        out.write('\n');
        //  liferay-ui:error
        com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_1 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_exception.get(com.liferay.taglib.ui.ErrorTag.class);
        _jspx_th_liferay$1ui_error_1.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_error_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_liferay$1ui_error_1.setException( DDMFormLayoutValidationException.MustNotDuplicateFieldName.class );
        int _jspx_eval_liferay$1ui_error_1 = _jspx_th_liferay$1ui_error_1.doStartTag();
        if (_jspx_eval_liferay$1ui_error_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          java.lang.Object errorException = null;
          if (_jspx_eval_liferay$1ui_error_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.pushBody();
            _jspx_th_liferay$1ui_error_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
            _jspx_th_liferay$1ui_error_1.doInitBody();
          }
          errorException = (java.lang.Object) _jspx_page_context.findAttribute("errorException");
          do {
            out.write("\n\n\t");

	DDMFormLayoutValidationException.MustNotDuplicateFieldName mndfn = (DDMFormLayoutValidationException.MustNotDuplicateFieldName)errorException;
	
            out.write("\n\n\t");
            //  liferay-ui:message
            com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_1 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
            _jspx_th_liferay$1ui_message_1.setPageContext(_jspx_page_context);
            _jspx_th_liferay$1ui_message_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_error_1);
            _jspx_th_liferay$1ui_message_1.setArguments( HtmlUtil.escape(StringUtil.merge(mndfn.getDuplicatedFieldNames(), StringPool.COMMA_AND_SPACE)) );
            _jspx_th_liferay$1ui_message_1.setKey("the-definition-field-name-x-was-defined-more-than-once");
            _jspx_th_liferay$1ui_message_1.setTranslateArguments( false );
            int _jspx_eval_liferay$1ui_message_1 = _jspx_th_liferay$1ui_message_1.doStartTag();
            if (_jspx_th_liferay$1ui_message_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_1);
              return;
            }
            _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_1);
            out.write('\n');
            int evalDoAfterBody = _jspx_th_liferay$1ui_error_1.doAfterBody();
            errorException = (java.lang.Object) _jspx_page_context.findAttribute("errorException");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_liferay$1ui_error_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
            out = _jspx_page_context.popBody();
        }
        if (_jspx_th_liferay$1ui_error_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_error_exception.reuse(_jspx_th_liferay$1ui_error_1);
          return;
        }
        _jspx_tagPool_liferay$1ui_error_exception.reuse(_jspx_th_liferay$1ui_error_1);
        out.write('\n');
        out.write('\n');
        //  liferay-ui:error
        com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_2 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_message_exception_nobody.get(com.liferay.taglib.ui.ErrorTag.class);
        _jspx_th_liferay$1ui_error_2.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_error_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_liferay$1ui_error_2.setException( DDMFormValidationException.class );
        _jspx_th_liferay$1ui_error_2.setMessage("please-enter-a-valid-form-definition");
        int _jspx_eval_liferay$1ui_error_2 = _jspx_th_liferay$1ui_error_2.doStartTag();
        if (_jspx_th_liferay$1ui_error_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_2);
          return;
        }
        _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_2);
        out.write('\n');
        out.write('\n');
        //  liferay-ui:error
        com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_3 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_exception.get(com.liferay.taglib.ui.ErrorTag.class);
        _jspx_th_liferay$1ui_error_3.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_error_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_liferay$1ui_error_3.setException( DDMFormValidationException.MustNotDuplicateFieldName.class );
        int _jspx_eval_liferay$1ui_error_3 = _jspx_th_liferay$1ui_error_3.doStartTag();
        if (_jspx_eval_liferay$1ui_error_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          java.lang.Object errorException = null;
          if (_jspx_eval_liferay$1ui_error_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.pushBody();
            _jspx_th_liferay$1ui_error_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
            _jspx_th_liferay$1ui_error_3.doInitBody();
          }
          errorException = (java.lang.Object) _jspx_page_context.findAttribute("errorException");
          do {
            out.write("\n\n\t");

	DDMFormValidationException.MustNotDuplicateFieldName mndfn = (DDMFormValidationException.MustNotDuplicateFieldName)errorException;
	
            out.write("\n\n\t");
            //  liferay-ui:message
            com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_2 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
            _jspx_th_liferay$1ui_message_2.setPageContext(_jspx_page_context);
            _jspx_th_liferay$1ui_message_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_error_3);
            _jspx_th_liferay$1ui_message_2.setArguments( HtmlUtil.escape(mndfn.getFieldName()) );
            _jspx_th_liferay$1ui_message_2.setKey("the-definition-field-name-x-was-defined-more-than-once");
            _jspx_th_liferay$1ui_message_2.setTranslateArguments( false );
            int _jspx_eval_liferay$1ui_message_2 = _jspx_th_liferay$1ui_message_2.doStartTag();
            if (_jspx_th_liferay$1ui_message_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_2);
              return;
            }
            _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_2);
            out.write('\n');
            int evalDoAfterBody = _jspx_th_liferay$1ui_error_3.doAfterBody();
            errorException = (java.lang.Object) _jspx_page_context.findAttribute("errorException");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_liferay$1ui_error_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
            out = _jspx_page_context.popBody();
        }
        if (_jspx_th_liferay$1ui_error_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_error_exception.reuse(_jspx_th_liferay$1ui_error_3);
          return;
        }
        _jspx_tagPool_liferay$1ui_error_exception.reuse(_jspx_th_liferay$1ui_error_3);
        out.write('\n');
        out.write('\n');
        //  liferay-ui:error
        com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_4 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_message_exception_nobody.get(com.liferay.taglib.ui.ErrorTag.class);
        _jspx_th_liferay$1ui_error_4.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_error_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_liferay$1ui_error_4.setException( DDMFormValidationException.MustSetFieldsForForm.class );
        _jspx_th_liferay$1ui_error_4.setMessage("please-add-at-least-one-field");
        int _jspx_eval_liferay$1ui_error_4 = _jspx_th_liferay$1ui_error_4.doStartTag();
        if (_jspx_th_liferay$1ui_error_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_4);
          return;
        }
        _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_4);
        out.write('\n');
        out.write('\n');
        //  liferay-ui:error
        com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_5 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_exception.get(com.liferay.taglib.ui.ErrorTag.class);
        _jspx_th_liferay$1ui_error_5.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_error_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_liferay$1ui_error_5.setException( DDMFormValidationException.MustSetOptionsForField.class );
        int _jspx_eval_liferay$1ui_error_5 = _jspx_th_liferay$1ui_error_5.doStartTag();
        if (_jspx_eval_liferay$1ui_error_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          java.lang.Object errorException = null;
          if (_jspx_eval_liferay$1ui_error_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.pushBody();
            _jspx_th_liferay$1ui_error_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
            _jspx_th_liferay$1ui_error_5.doInitBody();
          }
          errorException = (java.lang.Object) _jspx_page_context.findAttribute("errorException");
          do {
            out.write("\n\n\t");

	DDMFormValidationException.MustSetOptionsForField msoff = (DDMFormValidationException.MustSetOptionsForField)errorException;
	
            out.write("\n\n\t");
            //  liferay-ui:message
            com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_3 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
            _jspx_th_liferay$1ui_message_3.setPageContext(_jspx_page_context);
            _jspx_th_liferay$1ui_message_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_error_5);
            _jspx_th_liferay$1ui_message_3.setArguments( HtmlUtil.escape(msoff.getFieldName()) );
            _jspx_th_liferay$1ui_message_3.setKey("at-least-one-option-should-be-set-for-field-x");
            _jspx_th_liferay$1ui_message_3.setTranslateArguments( false );
            int _jspx_eval_liferay$1ui_message_3 = _jspx_th_liferay$1ui_message_3.doStartTag();
            if (_jspx_th_liferay$1ui_message_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_3);
              return;
            }
            _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_3);
            out.write('\n');
            int evalDoAfterBody = _jspx_th_liferay$1ui_error_5.doAfterBody();
            errorException = (java.lang.Object) _jspx_page_context.findAttribute("errorException");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_liferay$1ui_error_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
            out = _jspx_page_context.popBody();
        }
        if (_jspx_th_liferay$1ui_error_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_error_exception.reuse(_jspx_th_liferay$1ui_error_5);
          return;
        }
        _jspx_tagPool_liferay$1ui_error_exception.reuse(_jspx_th_liferay$1ui_error_5);
        out.write('\n');
        out.write('\n');
        //  liferay-ui:error
        com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_6 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_exception.get(com.liferay.taglib.ui.ErrorTag.class);
        _jspx_th_liferay$1ui_error_6.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_error_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_liferay$1ui_error_6.setException( DDMFormValidationException.MustSetValidCharactersForFieldName.class );
        int _jspx_eval_liferay$1ui_error_6 = _jspx_th_liferay$1ui_error_6.doStartTag();
        if (_jspx_eval_liferay$1ui_error_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          java.lang.Object errorException = null;
          if (_jspx_eval_liferay$1ui_error_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.pushBody();
            _jspx_th_liferay$1ui_error_6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
            _jspx_th_liferay$1ui_error_6.doInitBody();
          }
          errorException = (java.lang.Object) _jspx_page_context.findAttribute("errorException");
          do {
            out.write("\n\n\t");

	DDMFormValidationException.MustSetValidCharactersForFieldName msvcffn = (DDMFormValidationException.MustSetValidCharactersForFieldName)errorException;
	
            out.write("\n\n\t");
            //  liferay-ui:message
            com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_4 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
            _jspx_th_liferay$1ui_message_4.setPageContext(_jspx_page_context);
            _jspx_th_liferay$1ui_message_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_error_6);
            _jspx_th_liferay$1ui_message_4.setArguments( HtmlUtil.escape(msvcffn.getFieldName()) );
            _jspx_th_liferay$1ui_message_4.setKey("invalid-characters-were-defined-for-field-name-x");
            _jspx_th_liferay$1ui_message_4.setTranslateArguments( false );
            int _jspx_eval_liferay$1ui_message_4 = _jspx_th_liferay$1ui_message_4.doStartTag();
            if (_jspx_th_liferay$1ui_message_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_4);
              return;
            }
            _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_4);
            out.write('\n');
            int evalDoAfterBody = _jspx_th_liferay$1ui_error_6.doAfterBody();
            errorException = (java.lang.Object) _jspx_page_context.findAttribute("errorException");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_liferay$1ui_error_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
            out = _jspx_page_context.popBody();
        }
        if (_jspx_th_liferay$1ui_error_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_error_exception.reuse(_jspx_th_liferay$1ui_error_6);
          return;
        }
        _jspx_tagPool_liferay$1ui_error_exception.reuse(_jspx_th_liferay$1ui_error_6);
        out.write('\n');
        out.write('\n');
        //  liferay-ui:error
        com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_7 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_exception.get(com.liferay.taglib.ui.ErrorTag.class);
        _jspx_th_liferay$1ui_error_7.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_error_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_liferay$1ui_error_7.setException( DDMFormValidationException.MustSetValidValidationExpression.class );
        int _jspx_eval_liferay$1ui_error_7 = _jspx_th_liferay$1ui_error_7.doStartTag();
        if (_jspx_eval_liferay$1ui_error_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          java.lang.Object errorException = null;
          if (_jspx_eval_liferay$1ui_error_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.pushBody();
            _jspx_th_liferay$1ui_error_7.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
            _jspx_th_liferay$1ui_error_7.doInitBody();
          }
          errorException = (java.lang.Object) _jspx_page_context.findAttribute("errorException");
          do {
            out.write("\n\n\t");

	DDMFormValidationException.MustSetValidValidationExpression msvve = (DDMFormValidationException.MustSetValidValidationExpression)errorException;
	
            out.write("\n\n\t");
            //  liferay-ui:message
            com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_5 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
            _jspx_th_liferay$1ui_message_5.setPageContext(_jspx_page_context);
            _jspx_th_liferay$1ui_message_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_error_7);
            _jspx_th_liferay$1ui_message_5.setArguments( new Object[] {StringBundler.concat("<b>", HtmlUtil.escape(msvve.getValidationExpressionArgument()), "</b>"), StringBundler.concat("<b>", HtmlUtil.escape(msvve.getFieldName()), "</b>")} );
            _jspx_th_liferay$1ui_message_5.setKey("the-validation-expression-x-set-for-field-x-is-invalid");
            _jspx_th_liferay$1ui_message_5.setTranslateArguments( false );
            int _jspx_eval_liferay$1ui_message_5 = _jspx_th_liferay$1ui_message_5.doStartTag();
            if (_jspx_th_liferay$1ui_message_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_5);
              return;
            }
            _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_5);
            out.write('\n');
            int evalDoAfterBody = _jspx_th_liferay$1ui_error_7.doAfterBody();
            errorException = (java.lang.Object) _jspx_page_context.findAttribute("errorException");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_liferay$1ui_error_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
            out = _jspx_page_context.popBody();
        }
        if (_jspx_th_liferay$1ui_error_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_error_exception.reuse(_jspx_th_liferay$1ui_error_7);
          return;
        }
        _jspx_tagPool_liferay$1ui_error_exception.reuse(_jspx_th_liferay$1ui_error_7);
        out.write('\n');
        out.write('\n');
        //  liferay-ui:error
        com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_8 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_exception.get(com.liferay.taglib.ui.ErrorTag.class);
        _jspx_th_liferay$1ui_error_8.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_error_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_liferay$1ui_error_8.setException( DDMFormValidationException.MustSetValidVisibilityExpression.class );
        int _jspx_eval_liferay$1ui_error_8 = _jspx_th_liferay$1ui_error_8.doStartTag();
        if (_jspx_eval_liferay$1ui_error_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          java.lang.Object errorException = null;
          if (_jspx_eval_liferay$1ui_error_8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.pushBody();
            _jspx_th_liferay$1ui_error_8.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
            _jspx_th_liferay$1ui_error_8.doInitBody();
          }
          errorException = (java.lang.Object) _jspx_page_context.findAttribute("errorException");
          do {
            out.write("\n\n\t");

	DDMFormValidationException.MustSetValidVisibilityExpression msvve = (DDMFormValidationException.MustSetValidVisibilityExpression)errorException;
	
            out.write("\n\n\t");
            //  liferay-ui:message
            com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_6 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
            _jspx_th_liferay$1ui_message_6.setPageContext(_jspx_page_context);
            _jspx_th_liferay$1ui_message_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_error_8);
            _jspx_th_liferay$1ui_message_6.setArguments( new Object[] {HtmlUtil.escape(msvve.getVisibilityExpression()), HtmlUtil.escape(msvve.getFieldName())} );
            _jspx_th_liferay$1ui_message_6.setKey("the-visibility-expression-x-set-for-field-x-is-invalid");
            _jspx_th_liferay$1ui_message_6.setTranslateArguments( false );
            int _jspx_eval_liferay$1ui_message_6 = _jspx_th_liferay$1ui_message_6.doStartTag();
            if (_jspx_th_liferay$1ui_message_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_6);
              return;
            }
            _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_6);
            out.write('\n');
            int evalDoAfterBody = _jspx_th_liferay$1ui_error_8.doAfterBody();
            errorException = (java.lang.Object) _jspx_page_context.findAttribute("errorException");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_liferay$1ui_error_8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
            out = _jspx_page_context.popBody();
        }
        if (_jspx_th_liferay$1ui_error_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_error_exception.reuse(_jspx_th_liferay$1ui_error_8);
          return;
        }
        _jspx_tagPool_liferay$1ui_error_exception.reuse(_jspx_th_liferay$1ui_error_8);
        out.write('\n');
        out.write('\n');
        //  liferay-ui:error
        com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_9 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_exception.get(com.liferay.taglib.ui.ErrorTag.class);
        _jspx_th_liferay$1ui_error_9.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_error_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_liferay$1ui_error_9.setException( FormInstanceFieldSettingsException.MustSetValidValueForProperties.class );
        int _jspx_eval_liferay$1ui_error_9 = _jspx_th_liferay$1ui_error_9.doStartTag();
        if (_jspx_eval_liferay$1ui_error_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          java.lang.Object errorException = null;
          if (_jspx_eval_liferay$1ui_error_9 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.pushBody();
            _jspx_th_liferay$1ui_error_9.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
            _jspx_th_liferay$1ui_error_9.doInitBody();
          }
          errorException = (java.lang.Object) _jspx_page_context.findAttribute("errorException");
          do {
            out.write("\n\n\t");

	FormInstanceFieldSettingsException.MustSetValidValueForProperties msvvfp = (FormInstanceFieldSettingsException.MustSetValidValueForProperties)errorException;

	Map<String, Set<String>> fieldNamePropertiesMap = msvvfp.getFieldNamePropertiesMap();

	StringBundler sb = new StringBundler(fieldNamePropertiesMap.size());

	for (Entry<String, Set<String>> fieldNameProperties : fieldNamePropertiesMap.entrySet()) {
		Set<String> value = fieldNameProperties.getValue();

		sb.append(LanguageUtil.format(request, (value.size() == 1 ? "the-setting-x-set-for-field-x-is-invalid" :"the-settings-x-set-for-field-x-are-invalid"), new Object[] {HtmlUtil.escape(StringUtil.merge(value, StringPool.COMMA_AND_SPACE)), HtmlUtil.escape(fieldNameProperties.getKey())}, false));

		sb.append(StringPool.SPACE);
	}

	sb.setIndex(sb.index() - 1);
	
            out.write("\n\n\t");
            out.print( sb.toString() );
            out.write('\n');
            int evalDoAfterBody = _jspx_th_liferay$1ui_error_9.doAfterBody();
            errorException = (java.lang.Object) _jspx_page_context.findAttribute("errorException");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_liferay$1ui_error_9 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
            out = _jspx_page_context.popBody();
        }
        if (_jspx_th_liferay$1ui_error_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_error_exception.reuse(_jspx_th_liferay$1ui_error_9);
          return;
        }
        _jspx_tagPool_liferay$1ui_error_exception.reuse(_jspx_th_liferay$1ui_error_9);
        out.write('\n');
        out.write('\n');
        //  liferay-ui:error
        com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_10 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_message_exception_nobody.get(com.liferay.taglib.ui.ErrorTag.class);
        _jspx_th_liferay$1ui_error_10.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_error_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_liferay$1ui_error_10.setException( FormInstanceNameException.class );
        _jspx_th_liferay$1ui_error_10.setMessage("please-enter-a-valid-form-name");
        int _jspx_eval_liferay$1ui_error_10 = _jspx_th_liferay$1ui_error_10.doStartTag();
        if (_jspx_th_liferay$1ui_error_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_10);
          return;
        }
        _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_10);
        out.write('\n');
        //  liferay-ui:error
        com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_11 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_message_exception_nobody.get(com.liferay.taglib.ui.ErrorTag.class);
        _jspx_th_liferay$1ui_error_11.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_error_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_liferay$1ui_error_11.setException( FormInstanceSettingsRedirectURLException.class );
        _jspx_th_liferay$1ui_error_11.setMessage("the-specified-redirect-url-is-not-allowed");
        int _jspx_eval_liferay$1ui_error_11 = _jspx_th_liferay$1ui_error_11.doStartTag();
        if (_jspx_th_liferay$1ui_error_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_11);
          return;
        }
        _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_11);
        out.write('\n');
        //  liferay-ui:error
        com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_12 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_message_exception_nobody.get(com.liferay.taglib.ui.ErrorTag.class);
        _jspx_th_liferay$1ui_error_12.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_error_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_liferay$1ui_error_12.setException( StorageException.class );
        _jspx_th_liferay$1ui_error_12.setMessage("please-enter-a-valid-form-settings");
        int _jspx_eval_liferay$1ui_error_12 = _jspx_th_liferay$1ui_error_12.doStartTag();
        if (_jspx_th_liferay$1ui_error_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_12);
          return;
        }
        _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_12);
        out.write('\n');
        //  liferay-ui:error
        com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_13 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_message_exception_nobody.get(com.liferay.taglib.ui.ErrorTag.class);
        _jspx_th_liferay$1ui_error_13.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_error_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_liferay$1ui_error_13.setException( StructureDefinitionException.class );
        _jspx_th_liferay$1ui_error_13.setMessage("please-enter-a-valid-form-definition");
        int _jspx_eval_liferay$1ui_error_13 = _jspx_th_liferay$1ui_error_13.doStartTag();
        if (_jspx_th_liferay$1ui_error_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_13);
          return;
        }
        _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_13);
        out.write('\n');
        //  liferay-ui:error
        com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_14 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_message_exception_nobody.get(com.liferay.taglib.ui.ErrorTag.class);
        _jspx_th_liferay$1ui_error_14.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_error_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_liferay$1ui_error_14.setException( StructureLayoutException.class );
        _jspx_th_liferay$1ui_error_14.setMessage("please-enter-a-valid-form-layout");
        int _jspx_eval_liferay$1ui_error_14 = _jspx_th_liferay$1ui_error_14.doStartTag();
        if (_jspx_th_liferay$1ui_error_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_14);
          return;
        }
        _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_14);
        out.write('\n');
        //  liferay-ui:error
        com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_15 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_message_exception_nobody.get(com.liferay.taglib.ui.ErrorTag.class);
        _jspx_th_liferay$1ui_error_15.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_error_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_liferay$1ui_error_15.setException( StructureNameException.class );
        _jspx_th_liferay$1ui_error_15.setMessage("please-enter-a-valid-form-name");
        int _jspx_eval_liferay$1ui_error_15 = _jspx_th_liferay$1ui_error_15.doStartTag();
        if (_jspx_th_liferay$1ui_error_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_15);
          return;
        }
        _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_15);
        out.write("\n\n\t\t<div class=\"ddm-form-basic-info\">\n\t\t\t<div class=\"container-fluid-1280\">\n\t\t\t\t<h1>\n\t\t\t\t\t");
        //  liferay-ui:input-editor
        com.liferay.taglib.ui.InputEditorTag _jspx_th_liferay$1ui_input$1editor_0 = (com.liferay.taglib.ui.InputEditorTag) _jspx_tagPool_liferay$1ui_input$1editor_showSource_placeholder_name_editorName_cssClass_contents_autoCreate_nobody.get(com.liferay.taglib.ui.InputEditorTag.class);
        _jspx_th_liferay$1ui_input$1editor_0.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_input$1editor_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_liferay$1ui_input$1editor_0.setAutoCreate( false );
        _jspx_th_liferay$1ui_input$1editor_0.setContents( HtmlUtil.escape(HtmlUtil.unescape(ddmFormAdminDisplayContext.getFormName())) );
        _jspx_th_liferay$1ui_input$1editor_0.setCssClass("ddm-form-name");
        _jspx_th_liferay$1ui_input$1editor_0.setEditorName("alloyeditor");
        _jspx_th_liferay$1ui_input$1editor_0.setName("nameEditor");
        _jspx_th_liferay$1ui_input$1editor_0.setPlaceholder("untitled-form");
        _jspx_th_liferay$1ui_input$1editor_0.setShowSource( false );
        int _jspx_eval_liferay$1ui_input$1editor_0 = _jspx_th_liferay$1ui_input$1editor_0.doStartTag();
        if (_jspx_th_liferay$1ui_input$1editor_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_input$1editor_showSource_placeholder_name_editorName_cssClass_contents_autoCreate_nobody.reuse(_jspx_th_liferay$1ui_input$1editor_0);
          return;
        }
        _jspx_tagPool_liferay$1ui_input$1editor_showSource_placeholder_name_editorName_cssClass_contents_autoCreate_nobody.reuse(_jspx_th_liferay$1ui_input$1editor_0);
        out.write("\n\t\t\t\t</h1>\n\n\t\t\t\t<h5>\n\t\t\t\t\t");
        //  liferay-ui:input-editor
        com.liferay.taglib.ui.InputEditorTag _jspx_th_liferay$1ui_input$1editor_1 = (com.liferay.taglib.ui.InputEditorTag) _jspx_tagPool_liferay$1ui_input$1editor_showSource_placeholder_name_editorName_cssClass_contents_autoCreate_nobody.get(com.liferay.taglib.ui.InputEditorTag.class);
        _jspx_th_liferay$1ui_input$1editor_1.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_input$1editor_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_liferay$1ui_input$1editor_1.setAutoCreate( false );
        _jspx_th_liferay$1ui_input$1editor_1.setContents( HtmlUtil.escape(HtmlUtil.unescape(ddmFormAdminDisplayContext.getFormDescription())) );
        _jspx_th_liferay$1ui_input$1editor_1.setCssClass("ddm-form-description h5");
        _jspx_th_liferay$1ui_input$1editor_1.setEditorName("alloyeditor");
        _jspx_th_liferay$1ui_input$1editor_1.setName("descriptionEditor");
        _jspx_th_liferay$1ui_input$1editor_1.setPlaceholder("add-a-short-description-for-this-form");
        _jspx_th_liferay$1ui_input$1editor_1.setShowSource( false );
        int _jspx_eval_liferay$1ui_input$1editor_1 = _jspx_th_liferay$1ui_input$1editor_1.doStartTag();
        if (_jspx_th_liferay$1ui_input$1editor_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_input$1editor_showSource_placeholder_name_editorName_cssClass_contents_autoCreate_nobody.reuse(_jspx_th_liferay$1ui_input$1editor_1);
          return;
        }
        _jspx_tagPool_liferay$1ui_input$1editor_showSource_placeholder_name_editorName_cssClass_contents_autoCreate_nobody.reuse(_jspx_th_liferay$1ui_input$1editor_1);
        out.write("\n\t\t\t\t</h5>\n\t\t\t</div>\n\t\t</div>\n\n\t\t<div id=\"");
        if (_jspx_meth_portlet_namespace_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
          return;
        out.write("-container\"></div>\n\t");
      }
      if (_jspx_th_aui_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_form_name_method_enctype_cssClass_action.reuse(_jspx_th_aui_form_0);
        return;
      }
      _jspx_tagPool_aui_form_name_method_enctype_cssClass_action.reuse(_jspx_th_aui_form_0);
      out.write("\n\n\t<div class=\"container-fluid-1280 ddm-form-instance-settings hide\" id=\"");
      if (_jspx_meth_portlet_namespace_5(_jspx_page_context))
        return;
      out.write("settings\">\n\t\t");
      out.print( request.getAttribute(DDMWebKeys.DYNAMIC_DATA_MAPPING_FORM_HTML) );
      out.write("\n\t</div>\n</div>\n\n");
      //  liferay-portlet:resourceURL
      com.liferay.taglib.portlet.ResourceURLTag _jspx_th_liferay$1portlet_resourceURL_0 = (com.liferay.taglib.portlet.ResourceURLTag) _jspx_tagPool_liferay$1portlet_resourceURL_var_id_copyCurrentRenderParameters_nobody.get(com.liferay.taglib.portlet.ResourceURLTag.class);
      _jspx_th_liferay$1portlet_resourceURL_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1portlet_resourceURL_0.setParent(null);
      _jspx_th_liferay$1portlet_resourceURL_0.setCopyCurrentRenderParameters( false );
      _jspx_th_liferay$1portlet_resourceURL_0.setId("publishFormInstance");
      _jspx_th_liferay$1portlet_resourceURL_0.setVar("publishFormInstanceURL");
      int _jspx_eval_liferay$1portlet_resourceURL_0 = _jspx_th_liferay$1portlet_resourceURL_0.doStartTag();
      if (_jspx_th_liferay$1portlet_resourceURL_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1portlet_resourceURL_var_id_copyCurrentRenderParameters_nobody.reuse(_jspx_th_liferay$1portlet_resourceURL_0);
        return;
      }
      _jspx_tagPool_liferay$1portlet_resourceURL_var_id_copyCurrentRenderParameters_nobody.reuse(_jspx_th_liferay$1portlet_resourceURL_0);
      java.lang.String publishFormInstanceURL = null;
      publishFormInstanceURL = (java.lang.String) _jspx_page_context.findAttribute("publishFormInstanceURL");
      out.write('\n');
      out.write('\n');
      //  liferay-portlet:resourceURL
      com.liferay.taglib.portlet.ResourceURLTag _jspx_th_liferay$1portlet_resourceURL_1 = (com.liferay.taglib.portlet.ResourceURLTag) _jspx_tagPool_liferay$1portlet_resourceURL_var_id_copyCurrentRenderParameters_nobody.get(com.liferay.taglib.portlet.ResourceURLTag.class);
      _jspx_th_liferay$1portlet_resourceURL_1.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1portlet_resourceURL_1.setParent(null);
      _jspx_th_liferay$1portlet_resourceURL_1.setCopyCurrentRenderParameters( false );
      _jspx_th_liferay$1portlet_resourceURL_1.setId("saveFormInstance");
      _jspx_th_liferay$1portlet_resourceURL_1.setVar("autoSaveFormInstanceURL");
      int _jspx_eval_liferay$1portlet_resourceURL_1 = _jspx_th_liferay$1portlet_resourceURL_1.doStartTag();
      if (_jspx_th_liferay$1portlet_resourceURL_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1portlet_resourceURL_var_id_copyCurrentRenderParameters_nobody.reuse(_jspx_th_liferay$1portlet_resourceURL_1);
        return;
      }
      _jspx_tagPool_liferay$1portlet_resourceURL_var_id_copyCurrentRenderParameters_nobody.reuse(_jspx_th_liferay$1portlet_resourceURL_1);
      java.lang.String autoSaveFormInstanceURL = null;
      autoSaveFormInstanceURL = (java.lang.String) _jspx_page_context.findAttribute("autoSaveFormInstanceURL");
      out.write('\n');
      out.write('\n');
      //  aui:script
      com.liferay.taglib.aui.ScriptTag _jspx_th_aui_script_1 = (com.liferay.taglib.aui.ScriptTag) _jspx_tagPool_aui_script.get(com.liferay.taglib.aui.ScriptTag.class);
      _jspx_th_aui_script_1.setPageContext(_jspx_page_context);
      _jspx_th_aui_script_1.setParent(null);
      int _jspx_eval_aui_script_1 = _jspx_th_aui_script_1.doStartTag();
      if (_jspx_eval_aui_script_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_aui_script_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_aui_script_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_aui_script_1.doInitBody();
        }
        do {
          out.write("\n\tvar rawModuleName = '");
          out.print( mainRequire );
          out.write("'.split(' ')[0];\n\n\tLiferay.namespace('DDM').FormSettings = {\n\t\tautosaveInterval: ");
          out.print( ddmFormAdminDisplayContext.getAutosaveInterval() );
          out.write(",\n\t\tautosaveURL: '");
          out.print( autoSaveFormInstanceURL.toString() );
          out.write("',\n\t\tportletNamespace: '");
          if (_jspx_meth_portlet_namespace_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_1, _jspx_page_context))
            return;
          out.write("',\n\t\tpublishFormInstanceURL: '");
          out.print( publishFormInstanceURL.toString() );
          out.write("',\n\t\trestrictedFormURL: '");
          out.print( ddmFormAdminDisplayContext.getRestrictedFormURL() );
          out.write("',\n\t\tsharedFormURL: '");
          out.print( ddmFormAdminDisplayContext.getSharedFormURL() );
          out.write("',\n\t\tshowPagination: true,\n\t\tspritemap: '");
          out.print( themeDisplay.getPathThemeImages() );
          out.write("/lexicon/icons.svg'\n\t};\n\n\tLiferay.Forms.App = {\n\t\tdispose: function() {\n\t\t\tif (Liferay.Forms.instance) {\n\t\t\t\tLiferay.Forms.instance.dispose();\n\t\t\t\tLiferay.Forms.instance = null;\n\t\t\t}\n\t\t},\n\t\treset: function() {\n\t\t\tvar pages;\n\n\t\t\tif (Liferay.Forms.instance) {\n\t\t\t\tpages = Liferay.Forms.instance.state.pages;\n\t\t\t}\n\n\t\t\tthis.dispose();\n\t\t\tthis.start(pages);\n\t\t},\n\t\tstart: function(initialPages) {\n\t\t\tLiferay.Loader.require(\n\t\t\t\trawModuleName,\n\t\t\t\tfunction(packageName) {\n\t\t\t\t\tvar context = ");
          out.print( serializedFormBuilderContext );
          out.write(";\n\n\t\t\t\t\tif (context.pages.length === 0 && initialPages) {\n\t\t\t\t\t\tcontext.pages = initialPages;\n\t\t\t\t\t}\n\n\t\t\t\t\tLiferay.Forms.instance = new packageName.Form(\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tcontext: context,\n\t\t\t\t\t\t\tdataProviderInstanceParameterSettingsURL: '");
          out.print( dataProviderInstanceParameterSettingsURL );
          out.write("',\n\t\t\t\t\t\t\tdataProviderInstancesURL: '");
          out.print( dataProviderInstancesURL );
          out.write("',\n\t\t\t\t\t\t\tdefaultLanguageId: '");
          out.print( ddmFormAdminDisplayContext.getDefaultLanguageId() );
          out.write("',\n\t\t\t\t\t\t\tfieldTypes: ");
          out.print( ddmFormAdminDisplayContext.getDDMFormFieldTypesJSONArray() );
          out.write(",\n\t\t\t\t\t\t\tformInstanceId: '");
          out.print( formInstanceId );
          out.write("',\n\t\t\t\t\t\t\tfunctionsMetadata: ");
          out.print( functionsMetadata );
          out.write(",\n\t\t\t\t\t\t\tfunctionsURL: '");
          out.print( functionsURL );
          out.write("',\n\t\t\t\t\t\t\tlocalizedDescription: ");
          out.print( ddmFormAdminDisplayContext.getFormLocalizedDescription() );
          out.write(",\n\t\t\t\t\t\t\tlocalizedName: ");
          out.print( ddmFormAdminDisplayContext.getFormLocalizedName() );
          out.write(",\n\t\t\t\t\t\t\tnamespace: '");
          if (_jspx_meth_portlet_namespace_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_1, _jspx_page_context))
            return;
          out.write("',\n\t\t\t\t\t\t\tpublished: !!");
          out.print( ddmFormAdminDisplayContext.isFormPublished() );
          out.write(",\n\t\t\t\t\t\t\trolesURL: '");
          out.print( rolesURL );
          out.write("',\n\t\t\t\t\t\t\trules: ");
          out.print( serializedDDMFormRules );
          out.write(",\n\t\t\t\t\t\t\tsaved: ");
          out.print( formInstance != null );
          out.write(",\n\t\t\t\t\t\t\tspritemap: Liferay.DDM.FormSettings.spritemap,\n\t\t\t\t\t\t\tstrings: Liferay.DDM.FormSettings.strings\n\t\t\t\t\t\t},\n\t\t\t\t\t\t'#");
          if (_jspx_meth_portlet_namespace_8((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_1, _jspx_page_context))
            return;
          out.write("-container'\n\t\t\t\t\t);\n\t\t\t\t},\n\t\t\t\tfunction(error) {\n\t\t\t\t}\n\t\t\t);\n\t\t}\n\t};\n\n\tvar clearPortletHandlers = function(event) {\n\t\tif (event.portletId === '");
          out.print( portletDisplay.getRootPortletId() );
          out.write("') {\n\t\t\tLiferay.Forms.App.dispose();\n\n\t\t\tvar translationManager = Liferay.component('");
          if (_jspx_meth_portlet_namespace_9((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_1, _jspx_page_context))
            return;
          out.write("translationManager');\n\n\t\t\tLiferay.destroyComponents(\n\t\t\t\tfunction(component) {\n\t\t\t\t\tvar destroy = false;\n\n\t\t\t\t\tif (component === translationManager) {\n\t\t\t\t\t\tdestroy = true;\n\t\t\t\t\t}\n\n\t\t\t\t\treturn destroy;\n\t\t\t\t}\n\t\t\t);\n\n\t\t\tLiferay.detach('destroyPortlet', clearPortletHandlers);\n\t\t}\n\t};\n\n\tLiferay.on('destroyPortlet', clearPortletHandlers);\n\n\tif (Liferay.DMMFieldTypesReady) {\n\t\tLiferay.Forms.App.start();\n\t}\n\telse {\n\t\tLiferay.onceAfter(\n\t\t\t'DMMFieldTypesReady',\n\t\t\tfunction() {\n\t\t\t\tLiferay.Forms.App.start();\n\t\t\t}\n\t\t);\n\t}\n");
          int evalDoAfterBody = _jspx_th_aui_script_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_aui_script_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
      }
      if (_jspx_th_aui_script_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_script.reuse(_jspx_th_aui_script_1);
        return;
      }
      _jspx_tagPool_aui_script.reuse(_jspx_th_aui_script_1);
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
        out.write("\n\tLiferay.namespace('Forms').portletNamespace = '");
        if (_jspx_meth_portlet_namespace_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_0, _jspx_page_context))
          return true;
        out.write("';\n");
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

  private boolean _jspx_meth_portlet_param_0(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_actionURL_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_0 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_0.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_actionURL_0);
    _jspx_th_portlet_param_0.setName("mvcRenderCommandName");
    _jspx_th_portlet_param_0.setValue("/admin/edit_form_instance");
    int _jspx_eval_portlet_param_0 = _jspx_th_portlet_param_0.doStartTag();
    if (_jspx_th_portlet_param_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_0);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_0);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_1 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_1.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_1.setParent(null);
    int _jspx_eval_portlet_namespace_1 = _jspx_th_portlet_namespace_1.doStartTag();
    if (_jspx_th_portlet_namespace_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_1);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_1);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_2 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_2.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_2.setParent(null);
    int _jspx_eval_portlet_namespace_2 = _jspx_th_portlet_namespace_2.doStartTag();
    if (_jspx_th_portlet_namespace_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_2);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_2);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_message_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_0 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_0.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_0.setParent(null);
    _jspx_th_liferay$1ui_message_0.setKey("copy-url");
    int _jspx_eval_liferay$1ui_message_0 = _jspx_th_liferay$1ui_message_0.doStartTag();
    if (_jspx_th_liferay$1ui_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_0);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_0);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_3 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_3.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_3.setParent(null);
    int _jspx_eval_portlet_namespace_3 = _jspx_th_portlet_namespace_3.doStartTag();
    if (_jspx_th_portlet_namespace_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_3);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_3);
    return false;
  }

  private boolean _jspx_meth_aui_input_7(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:input
    com.liferay.taglib.aui.InputTag _jspx_th_aui_input_7 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
    _jspx_th_aui_input_7.setPageContext(_jspx_page_context);
    _jspx_th_aui_input_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    _jspx_th_aui_input_7.setName("serializedSettingsContext");
    _jspx_th_aui_input_7.setType("hidden");
    _jspx_th_aui_input_7.setValue(new String(""));
    int _jspx_eval_aui_input_7 = _jspx_th_aui_input_7.doStartTag();
    if (_jspx_th_aui_input_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_7);
      return true;
    }
    _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_7);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_4(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_4 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_4.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    int _jspx_eval_portlet_namespace_4 = _jspx_th_portlet_namespace_4.doStartTag();
    if (_jspx_th_portlet_namespace_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_4);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_4);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_5 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_5.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_5.setParent(null);
    int _jspx_eval_portlet_namespace_5 = _jspx_th_portlet_namespace_5.doStartTag();
    if (_jspx_th_portlet_namespace_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_5);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_5);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_6(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_script_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_6 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_6.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_1);
    int _jspx_eval_portlet_namespace_6 = _jspx_th_portlet_namespace_6.doStartTag();
    if (_jspx_th_portlet_namespace_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_6);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_6);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_7(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_script_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_7 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_7.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_1);
    int _jspx_eval_portlet_namespace_7 = _jspx_th_portlet_namespace_7.doStartTag();
    if (_jspx_th_portlet_namespace_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_7);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_7);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_8(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_script_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_8 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_8.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_1);
    int _jspx_eval_portlet_namespace_8 = _jspx_th_portlet_namespace_8.doStartTag();
    if (_jspx_th_portlet_namespace_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_8);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_8);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_9(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_script_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_9 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_9.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_1);
    int _jspx_eval_portlet_namespace_9 = _jspx_th_portlet_namespace_9.doStartTag();
    if (_jspx_th_portlet_namespace_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_9);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_9);
    return false;
  }
}
