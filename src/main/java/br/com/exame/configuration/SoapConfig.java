package br.com.exame.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import br.com.exame.service.ExameService;

@Configuration
public class SoapConfig
{
	@Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(new String[] { "br.com.exame.ws.client" });
        return marshaller;
    }

	@Bean
    public ExameService exameClient(Jaxb2Marshaller marshaller) {
        ExameService client = new ExameService();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}