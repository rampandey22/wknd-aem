package com.adobe.aem.guides.wknd.core.servlets;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;

import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.apache.sling.api.servlets.HttpConstants;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import java.util.ArrayList;

import java.io.PrintWriter;
import java.io.IOException;

import com.adobe.aem.guides.wknd.core.service.FormProcessor;
import com.google.gson.JsonObject;
import com.adobe.aem.guides.wknd.core.constants.CommonConstants;
import com.adobe.aem.guides.wknd.core.exception.APIException;

/**
 
 
 
 */
@Component(service = { Servlet.class }, property = { "sling.servlet.methods=" + HttpConstants.METHOD_GET,
		"sling.servlet.paths=" + CommonConstants.EVENT_REG_SERVLET_PATH })

@ServiceDescription("Servlet to process data from the registration form")
public class EventRegistrationServlet extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = 1L;

	@Reference
	FormProcessor formProcessor;

	@Override
	protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp)
			throws ServletException, IOException {

		JsonObject jsonObject = new JsonObject();
		JsonObject errorObject = new JsonObject();
		PrintWriter out = resp.getWriter();
		ArrayList<String> errorMessageList = new ArrayList<String>();
		String firstname = req.getParameter(CommonConstants.FIRST_NAME);
		String lastname = req.getParameter(CommonConstants.LAST_NAME);
		String email = req.getParameter(CommonConstants.EMAIL);

		String emailFormat = CommonConstants.EMAIL_FORMAT;
		try {

			if (firstname == null || firstname.equals(CommonConstants.EMPTY_STRING)) {

				errorMessageList.add(CommonConstants.FIRST_NAME_ERROR_MESSAGE);
			}

			else if (!(firstname.matches(CommonConstants.NAME_FORMAT)))
				errorMessageList.add(CommonConstants.FIRST_NAME_FORMAT_MESSAGE);

			else {
				firstname = req.getParameter("firstname").toString();

			}
			if (lastname == null || lastname.equals("")) {

				errorMessageList.add(CommonConstants.LAST_NAME_ERROR_MESSAGE);
			}

			else if (lastname.length() < 2)
				errorMessageList.add(CommonConstants.LAST_NAME_FORMAT_MESSAGE);

			else {
				lastname = req.getParameter("lastname").toString();

			}

			if (email == null || email.equals("")) {

				errorMessageList.add(CommonConstants.EMAIL_ERROR_MESSAGE);
			}

			else if (!(email.matches(emailFormat)))
				errorMessageList.add(CommonConstants.EMAIL_FORMAT_MESSAGE);

			else {
				email = req.getParameter("email").toString();

			}

			resp.setContentType(CommonConstants.CONTENT_TYPE);
			resp.setHeader(CommonConstants.CACHE_CONTROL, CommonConstants.NO_CACHE);
			resp.setCharacterEncoding(CommonConstants.UTF_8);

			if (errorMessageList.size() != 0) {
				resp.setStatus(HttpStatus.SC_BAD_REQUEST);
				errorObject.addProperty("errorMessages", errorMessageList.toString());
				out.println(errorObject.toString());
			} else {
				jsonObject = formProcessor.getDatafromAPI(firstname);
				resp.setStatus(HttpStatus.SC_OK);
				out.println(jsonObject.toString());
			}

		} catch (APIException | IOException ex) {

			resp.setStatus(HttpStatus.SC_BAD_GATEWAY);
			errorObject.addProperty("errorMessages", ex.toString());
			out.println(errorObject.toString());

		}

	}

}
