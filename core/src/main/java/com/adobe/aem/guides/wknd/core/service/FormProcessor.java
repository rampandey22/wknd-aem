package com.adobe.aem.guides.wknd.core.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.sling.api.servlets.HttpConstants;
import org.osgi.service.component.annotations.Component;

import com.adobe.aem.guides.wknd.core.constants.CommonConstants;
import com.adobe.aem.guides.wknd.core.exception.APIException;

@Component(service = FormProcessor.class)
public class FormProcessor {

	public String add(String str1) {
		return "ram";
	}

	public JsonObject getDatafromAPI(final String firstname) throws APIException, IOException {

		JsonObject jsonObject = new JsonObject();
		String inline = "";
		JsonParser parser = new JsonParser();

		URL url;

		url = new URL(CommonConstants.URI + firstname);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(HttpConstants.METHOD_GET);
		conn.connect();

		int responsecode = conn.getResponseCode();

		if (responsecode != HttpStatus.SC_OK) {
			throw new APIException(CommonConstants.API_ERROR);
		} else {

			Scanner scanner = new Scanner(url.openStream());

			while (scanner.hasNext()) {
				inline += scanner.nextLine();
			}

			scanner.close();

			jsonObject = (JsonObject) parser.parse(inline);

		}

		return jsonObject;

	}

}
