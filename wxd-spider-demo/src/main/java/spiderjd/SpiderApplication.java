package spiderjd;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import spiderjd.action.SpiderAjax;

@SpringBootApplication
public class SpiderApplication {

	@Autowired
	private SpiderAjax spiderAjax;
	
	public static void main(String[] args) {
		SpringApplication.run(SpiderApplication.class, args);
	}
	
	@PostConstruct
	public void task(){
		spiderAjax.saveJd();
	}
	
}
