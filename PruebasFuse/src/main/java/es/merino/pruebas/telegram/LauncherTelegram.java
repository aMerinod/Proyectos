package es.merino.pruebas.telegram;

import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LauncherTelegram {

	
	 public static void main(String... args) throws Exception {
		 
		 @SuppressWarnings("resource")
			ApplicationContext context = new ClassPathXmlApplicationContext("C:\\Users\\amerino\\privateGit\\Proyectos\\PruebasFuse\\src\\main\\resources\\META-INF\\spring\\camel-context.xml");

	    	/** CAMEL-CONTEX EXISTENTES*/
	    	SpringCamelContext contextCamel = (SpringCamelContext) context.getBean("camelContextTelegram");
	    	contextCamel.start();
	    	
	    	
	    	Thread.sleep(1000000);
	 }
}
