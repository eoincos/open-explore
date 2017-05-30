package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SpringBootApplication
@RestController
public class UiApplication {

  private String hereAppURI = "https://autocomplete.geocoder.cit.api.here.com/6.2/";
  private String hereAppId = "placeholder";
  private String hereAppCode = "placeholder";

  @RequestMapping("/getSuggestions")
  public List<Suggestion> showSuggestions(@RequestParam("location") String location) {
    RestTemplate restTemplate = new RestTemplate();
    Suggest suggest = new Suggest();
    List<Suggestion>suggestions = null;
    
    if(location.length() > 3)
    {
      String hereResponse = restTemplate.getForObject("{hereAppURI}suggest.json?query={location}&app_id={hereAppId}&app_code={hereAppCode}&language=en",
          String.class, hereAppURI, location, hereAppId, hereAppCode);
      Gson gson = new GsonBuilder().create();
      suggest = gson.fromJson(hereResponse , Suggest.class);
      
      suggestions = suggest.getSuggestion();
      System.out.println(suggestions);
      for(int i = 0; i < suggestions.size(); i++)
      {
        Suggestion currentSuggestion = suggestions.get(i);
        
        if(!"city".equals(currentSuggestion.getMatchLevel()))
        {
          suggestions.remove(i);
        }
      }
    }
    return suggestions;
  }

	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
	}
}
