package br.com.exame.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context)
    {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
    }

	@Bean(name="exames")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema examesSchema)
    {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("ExamePort");
        definition.setTargetNamespace("http://client.ws.exame.com.br");
        definition.setLocationUri("/ws");
        definition.setSchema(examesSchema);
        return definition;
    }

	@Bean
    public XsdSchema examesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("/xsd/exames.xsd"));
    }
}
