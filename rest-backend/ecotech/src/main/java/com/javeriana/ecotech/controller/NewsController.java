package com.javeriana.ecotech.controller;

import java.io.IOException;

import org.bson.Document;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javeriana.ecotech.integration.MongoConnection;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping("news")
public class NewsController {
	private OkHttpClient httpClient = new OkHttpClient();

	// news/ar/health
	@GetMapping(value = "/{country}/{category}", produces = "application/json")
	private String getNews(@PathVariable String country, @PathVariable String category) throws Exception {
		System.out.println("NewsController.getNews()");
		String resp = sendGet(country, category);
		Document doc = Document.parse(resp);

		MongoConnection.insertObject("News", doc);
		return resp;

	}

	private String sendGet(String country, String category) throws Exception {
		String url = "https://newsapi.org/v2/top-headlines?country=" + country + "&category=" + category
				+ "&apiKey=e510d3bfb4be4f198dab60b6e1e5f9ec";
		Request request = new Request.Builder().url(url).build();

		try (Response response = httpClient.newCall(request).execute()) {
			if (!response.isSuccessful())
				throw new IOException("Unexpected code " + response);
			return response.body().string();
		}

	}

}
