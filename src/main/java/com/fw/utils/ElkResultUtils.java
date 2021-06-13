package com.fw.utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.apache.hc.core5.http.HttpStatus;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ElkResultUtils {

	private ElkResultUtils() {}

	private static Map<String, String> resultsMap = new HashMap<>();

	public static synchronized void postDetailsToElk(String testName, String status) {
		resultsMap.put("testName", testName);
		resultsMap.put("status", status);
		resultsMap.put("executionTime", LocalDate.now().toString());

		given().contentType(ContentType.JSON)
		.body(resultsMap)
		.when().post("http://00.0.000.000:9200/suite/result")
		.then().statusCode(HttpStatus.SC_CREATED);

	}

}
