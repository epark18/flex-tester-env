package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.calendar.configuration.CalendarServiceConfigurationValues;
import com.liferay.calendar.constants.CalendarActionKeys;
import com.liferay.calendar.constants.CalendarConstants;
import com.liferay.calendar.exception.CalendarBookingDurationException;
import com.liferay.calendar.exception.CalendarBookingRecurrenceException;
import com.liferay.calendar.exception.CalendarNameException;
import com.liferay.calendar.exception.CalendarResourceCodeException;
import com.liferay.calendar.exception.CalendarResourceNameException;
import com.liferay.calendar.exception.DuplicateCalendarResourceException;
import com.liferay.calendar.exception.NoSuchResourceException;
import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.model.CalendarNotificationTemplate;
import com.liferay.calendar.model.CalendarNotificationTemplateConstants;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.notification.NotificationField;
import com.liferay.calendar.notification.NotificationTemplateType;
import com.liferay.calendar.notification.NotificationType;
import com.liferay.calendar.notification.NotificationUtil;
import com.liferay.calendar.recurrence.Frequency;
import com.liferay.calendar.recurrence.PositionalWeekday;
import com.liferay.calendar.recurrence.Recurrence;
import com.liferay.calendar.recurrence.Weekday;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.calendar.service.CalendarBookingServiceUtil;
import com.liferay.calendar.service.CalendarNotificationTemplateLocalServiceUtil;
import com.liferay.calendar.service.CalendarServiceUtil;
import com.liferay.calendar.util.JCalendarUtil;
import com.liferay.calendar.util.RecurrenceUtil;
import com.liferay.calendar.util.comparator.CalendarNameComparator;
import com.liferay.calendar.web.internal.constants.CalendarWebKeys;
import com.liferay.calendar.web.internal.display.context.CalendarDisplayContext;
import com.liferay.calendar.web.internal.search.CalendarResourceDisplayTerms;
import com.liferay.calendar.web.internal.search.CalendarResourceSearch;
import com.liferay.calendar.web.internal.security.permission.resource.CalendarPermission;
import com.liferay.calendar.web.internal.security.permission.resource.CalendarPortletPermission;
import com.liferay.calendar.web.internal.security.permission.resource.CalendarResourcePermission;
import com.liferay.calendar.web.internal.util.CalendarResourceUtil;
import com.liferay.calendar.web.internal.util.CalendarUtil;
import com.liferay.calendar.web.internal.util.ColorUtil;
import com.liferay.calendar.workflow.CalendarBookingWorkflowConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.bean.BeanParamUtil;
import com.liferay.portal.kernel.bean.BeanPropertiesUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONSerializer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.FastDateFormatConstants;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.SessionClicks;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.util.comparator.UserScreenNameComparator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.rss.util.RSSUtil;
import com.liferay.taglib.search.ResultRow;
import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import javax.portlet.PortletURL;

public final class view_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/init.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_namespace_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1theme_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_clay_navigation$1bar_navigationItems_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1util_include_servletContext_page_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_portlet_namespace_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1theme_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_clay_navigation$1bar_navigationItems_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1util_include_servletContext_page_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_portlet_namespace_nobody.release();
    _jspx_tagPool_liferay$1theme_defineObjects_nobody.release();
    _jspx_tagPool_clay_navigation$1bar_navigationItems_nobody.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_liferay$1frontend_defineObjects_nobody.release();
    _jspx_tagPool_liferay$1util_include_servletContext_page_nobody.release();
    _jspx_tagPool_portlet_defineObjects_nobody.release();
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

int defaultDuration = GetterUtil.getInteger(portletPreferences.getValue("defaultDuration", null), 60);
String defaultView = portletPreferences.getValue("defaultView", "week");
String timeFormat = GetterUtil.getString(portletPreferences.getValue("timeFormat", "locale"));
String timeZoneId = portletPreferences.getValue("timeZoneId", user.getTimeZoneId());
boolean usePortalTimeZone = GetterUtil.getBoolean(portletPreferences.getValue("usePortalTimeZone", Boolean.TRUE.toString()));
int weekStartsOn = GetterUtil.getInteger(portletPreferences.getValue("weekStartsOn", null));

String sessionClicksDefaultView = SessionClicks.get(request, "com.liferay.calendar.web_defaultView", defaultView);

if (usePortalTimeZone) {
	timeZoneId = user.getTimeZoneId();
}

boolean displaySchedulerHeader = GetterUtil.getBoolean(portletPreferences.getValue("displaySchedulerHeader", null), true);
boolean displaySchedulerOnly = GetterUtil.getBoolean(portletPreferences.getValue("displaySchedulerOnly", null));
boolean showUserEvents = GetterUtil.getBoolean(portletPreferences.getValue("showUserEvents", null), true);

boolean showAgendaView = GetterUtil.getBoolean(portletPreferences.getValue("showAgendaView", null), true);
boolean showDayView = GetterUtil.getBoolean(portletPreferences.getValue("showDayView", null), true);
boolean showMonthView = GetterUtil.getBoolean(portletPreferences.getValue("showMonthView", null), true);
boolean showWeekView = GetterUtil.getBoolean(portletPreferences.getValue("showWeekView", null), true);

int eventsPerPage = GetterUtil.getInteger(portletPreferences.getValue("eventsPerPage", null), 10);
int maxDaysDisplayed = GetterUtil.getInteger(portletPreferences.getValue("maxDaysDisplayed", null), 1);

boolean enableRSS = !PortalUtil.isRSSFeedsEnabled() ? false : GetterUtil.getBoolean(portletPreferences.getValue("enableRss", null), true);
int rssDelta = GetterUtil.getInteger(portletPreferences.getValue("rssDelta", StringPool.BLANK), SearchContainer.DEFAULT_DELTA);
String rssDisplayStyle = portletPreferences.getValue("rssDisplayStyle", RSSUtil.DISPLAY_STYLE_DEFAULT);
String rssFeedType = portletPreferences.getValue("rssFeedType", RSSUtil.FEED_TYPE_DEFAULT);
long rssTimeInterval = GetterUtil.getLong(portletPreferences.getValue("rssTimeInterval", StringPool.BLANK), Time.WEEK);

CalendarBooking calendarBooking = (CalendarBooking)request.getAttribute(CalendarWebKeys.CALENDAR_BOOKING);

CalendarResource groupCalendarResource = CalendarResourceUtil.getScopeGroupCalendarResource(liferayPortletRequest, scopeGroupId);
CalendarResource userCalendarResource = null;

if (showUserEvents || !themeDisplay.isSignedIn()) {
	userCalendarResource = CalendarResourceUtil.getUserCalendarResource(liferayPortletRequest, themeDisplay.getUserId());
}

Calendar userDefaultCalendar = null;

if (userCalendarResource != null) {
	long defaultCalendarId = userCalendarResource.getDefaultCalendarId();

	if (defaultCalendarId > 0) {
		userDefaultCalendar = CalendarServiceUtil.getCalendar(defaultCalendarId);
	}
}

List<Calendar> groupCalendars = Collections.emptyList();

boolean showSiteCalendars = false;

if (groupCalendarResource != null) {
	showSiteCalendars = (userCalendarResource == null) || (groupCalendarResource.getCalendarResourceId() != userCalendarResource.getCalendarResourceId());
}

if (showSiteCalendars) {
	groupCalendars = CalendarServiceUtil.search(themeDisplay.getCompanyId(), null, new long[] {groupCalendarResource.getCalendarResourceId()}, null, true, QueryUtil.ALL_POS, QueryUtil.ALL_POS, (OrderByComparator)null);
}

List<Calendar> userCalendars = Collections.emptyList();

if (userCalendarResource != null) {
	userCalendars = CalendarServiceUtil.search(themeDisplay.getCompanyId(), null, new long[] {userCalendarResource.getCalendarResourceId()}, null, true, QueryUtil.ALL_POS, QueryUtil.ALL_POS, (OrderByComparator)null);
}

List<Calendar> otherCalendars = new ArrayList<Calendar>();

long[] calendarIds = StringUtil.split(SessionClicks.get(request, "com.liferay.calendar.web_otherCalendars", StringPool.BLANK), 0L);

Calendar defaultCalendar = null;

CalendarDisplayContext calendarDisplayContext = (CalendarDisplayContext)renderRequest.getAttribute(CalendarWebKeys.CALENDAR_DISPLAY_CONTEXT);

if (calendarDisplayContext != null) {
	otherCalendars = calendarDisplayContext.getOtherCalendars(user, calendarIds);

	defaultCalendar = calendarDisplayContext.getDefaultCalendar(groupCalendars, userCalendars);
}

TimeZone userTimeZone = null;

if ((calendarBooking != null) && calendarBooking.isAllDay()) {
	userTimeZone = TimeZone.getTimeZone(StringPool.UTC);
}
else {
	userTimeZone = TimeZone.getTimeZone(timeZoneId);
}

TimeZone utcTimeZone = TimeZone.getTimeZone(StringPool.UTC);

Format dateFormatLongDate = FastDateFormatFactoryUtil.getDate(FastDateFormatConstants.LONG, locale, userTimeZone);

Format dateFormatTime = null;

boolean useIsoTimeFormat = timeFormat.equals("24-hour") || (timeFormat.equals("locale") && !DateUtil.isFormatAmPm(locale));

if (useIsoTimeFormat) {
	dateFormatTime = FastDateFormatFactoryUtil.getSimpleDateFormat("HH:mm", locale, userTimeZone);
}
else {
	dateFormatTime = FastDateFormatFactoryUtil.getSimpleDateFormat("hh:mm a", locale, userTimeZone);
}

      out.write('\n');
      out.write('\n');

String tabs1 = ParamUtil.getString(request, "tabs1", "calendar");

      out.write("\n\n<div id=\"");
      if (_jspx_meth_portlet_namespace_0(_jspx_page_context))
        return;
      out.write("alert\"></div>\n\n");
      //  c:if
      com.liferay.taglib.core.IfTag _jspx_th_c_if_0 = (com.liferay.taglib.core.IfTag) _jspx_tagPool_c_if_test.get(com.liferay.taglib.core.IfTag.class);
      _jspx_th_c_if_0.setPageContext(_jspx_page_context);
      _jspx_th_c_if_0.setParent(null);
      _jspx_th_c_if_0.setTest( themeDisplay.isSignedIn() && !displaySchedulerOnly );
      int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
      if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write('\n');
        out.write('	');
        //  clay:navigation-bar
        com.liferay.frontend.taglib.clay.servlet.taglib.soy.NavigationBarTag _jspx_th_clay_navigation$1bar_0 = (com.liferay.frontend.taglib.clay.servlet.taglib.soy.NavigationBarTag) _jspx_tagPool_clay_navigation$1bar_navigationItems_nobody.get(com.liferay.frontend.taglib.clay.servlet.taglib.soy.NavigationBarTag.class);
        _jspx_th_clay_navigation$1bar_0.setPageContext(_jspx_page_context);
        _jspx_th_clay_navigation$1bar_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
        _jspx_th_clay_navigation$1bar_0.setNavigationItems( calendarDisplayContext.getNavigationItems() );
        int _jspx_eval_clay_navigation$1bar_0 = _jspx_th_clay_navigation$1bar_0.doStartTag();
        if (_jspx_th_clay_navigation$1bar_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_clay_navigation$1bar_navigationItems_nobody.reuse(_jspx_th_clay_navigation$1bar_0);
          return;
        }
        _jspx_tagPool_clay_navigation$1bar_navigationItems_nobody.reuse(_jspx_th_clay_navigation$1bar_0);
        out.write('\n');
      }
      if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
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
        _jspx_th_c_when_0.setTest( tabs1.equals("calendar") );
        int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
        if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          out.write("\n\t\t");
          //  liferay-util:include
          com.liferay.taglib.util.IncludeTag _jspx_th_liferay$1util_include_0 = (com.liferay.taglib.util.IncludeTag) _jspx_tagPool_liferay$1util_include_servletContext_page_nobody.get(com.liferay.taglib.util.IncludeTag.class);
          _jspx_th_liferay$1util_include_0.setPageContext(_jspx_page_context);
          _jspx_th_liferay$1util_include_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
          _jspx_th_liferay$1util_include_0.setPage("/view_calendar.jsp");
          _jspx_th_liferay$1util_include_0.setServletContext( application );
          int _jspx_eval_liferay$1util_include_0 = _jspx_th_liferay$1util_include_0.doStartTag();
          if (_jspx_th_liferay$1util_include_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_liferay$1util_include_servletContext_page_nobody.reuse(_jspx_th_liferay$1util_include_0);
            return;
          }
          _jspx_tagPool_liferay$1util_include_servletContext_page_nobody.reuse(_jspx_th_liferay$1util_include_0);
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
        //  c:when
        com.liferay.taglib.core.WhenTag _jspx_th_c_when_1 = (com.liferay.taglib.core.WhenTag) _jspx_tagPool_c_when_test.get(com.liferay.taglib.core.WhenTag.class);
        _jspx_th_c_when_1.setPageContext(_jspx_page_context);
        _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
        _jspx_th_c_when_1.setTest( tabs1.equals("resources") );
        int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
        if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          out.write("\n\t\t");
          //  liferay-util:include
          com.liferay.taglib.util.IncludeTag _jspx_th_liferay$1util_include_1 = (com.liferay.taglib.util.IncludeTag) _jspx_tagPool_liferay$1util_include_servletContext_page_nobody.get(com.liferay.taglib.util.IncludeTag.class);
          _jspx_th_liferay$1util_include_1.setPageContext(_jspx_page_context);
          _jspx_th_liferay$1util_include_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_1);
          _jspx_th_liferay$1util_include_1.setPage("/view_calendar_resources.jsp");
          _jspx_th_liferay$1util_include_1.setServletContext( application );
          int _jspx_eval_liferay$1util_include_1 = _jspx_th_liferay$1util_include_1.doStartTag();
          if (_jspx_th_liferay$1util_include_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_liferay$1util_include_servletContext_page_nobody.reuse(_jspx_th_liferay$1util_include_1);
            return;
          }
          _jspx_tagPool_liferay$1util_include_servletContext_page_nobody.reuse(_jspx_th_liferay$1util_include_1);
          out.write('\n');
          out.write('	');
        }
        if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
          return;
        }
        _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
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

  private boolean _jspx_meth_portlet_namespace_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_0 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_0.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_0.setParent(null);
    int _jspx_eval_portlet_namespace_0 = _jspx_th_portlet_namespace_0.doStartTag();
    if (_jspx_th_portlet_namespace_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_0);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_0);
    return false;
  }
}
