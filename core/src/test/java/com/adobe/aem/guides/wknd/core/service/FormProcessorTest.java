package com.adobe.aem.guides.wknd.core.service;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.extension.ExtendWith;

import com.adobe.aem.guides.wknd.core.exception.APIException;
import com.google.gson.JsonObject;

@ExtendWith({ AemContextExtension.class })
public class FormProcessorTest {

	private final AemContext aemcontext = new AemContext();
	private FormProcessor fakeService;

	@BeforeEach
	public void setup() {
		fakeService = aemcontext.registerInjectActivateService(new FormProcessor());
	}

	@Test
	public void getDatafromAPITest(AemContext context) throws APIException, IOException {

		JsonObject apiResponseMockito = fakeService.getDatafromAPI("ram");

		JsonObject apiResponse = new JsonObject();
		apiResponse.addProperty("name", "ram");
		apiResponse.addProperty("gender", "male");
		apiResponse.addProperty("probability", 0.93);
		apiResponse.addProperty("count", 5003);

		assertNotNull(apiResponseMockito);
		assertEquals(apiResponse, apiResponseMockito);

	}

}
