package es.merino.pruebas.linkedin;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class RecogerJobsLinkedin implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		
		System.out.println(exchange.getIn().getBody());
		
	}

	

}
