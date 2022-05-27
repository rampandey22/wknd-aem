package com.adobe.aem.guides.wknd.core.constants;

public class CommonConstants {

	/** The Constant Servlet Path. */
	public static final String EVENT_REG_SERVLET_PATH = "/bin/eventregistrationform";
	public static final String EMAIL_FORMAT = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	public static final String EMPTY_STRING = "";
	public static final String FIRST_NAME = "firstname";
	public static final String LAST_NAME = "lastname";
	public static final String EMAIL = "email";
	public static final String FIRST_NAME_ERROR_MESSAGE = "Please provide first name";
	public static final String LAST_NAME_ERROR_MESSAGE = "Please provide last name";
	public static final String EMAIL_ERROR_MESSAGE = "Please provide email address";
	public static final String FIRST_NAME_FORMAT_MESSAGE = "First name should be atleat three characters and can't have numbers";
	public static final String LAST_NAME_FORMAT_MESSAGE = "Last name should be atleat three characters";
	public static final String EMAIL_FORMAT_MESSAGE = "Please fix the format of email address";
	public static final String CONTENT_TYPE = "application/json";
	public static final String UTF_8 = "utf-8";
	public static final String CACHE_CONTROL = "Cache-Control";
	public static final String NO_CACHE = "nocache";
	public static final String URI = "https://api.genderize.io/?name=";
	public static final String API_ERROR = "Error calling external API";
	public static final String NAME_FORMAT = "\\w+\\s{1}\\w+\\s{1}\\w+";

}
