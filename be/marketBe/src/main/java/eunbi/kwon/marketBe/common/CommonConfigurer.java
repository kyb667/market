package eunbi.kwon.marketBe.common;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class CommonConfigurer {

	private RestTemplate restClient;

	@PostConstruct
	private void init() {
		restClient = new RestTemplate();
		restClient.getInterceptors().add(new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(
				HttpRequest request, byte[] body, ClientHttpRequestExecution execution
			) throws IOException {
				// log.info("Sending {} Request to {}", request.getMethod(), request.getURI());
				ClientHttpResponse response = execution.execute(request, body);
				// log.info("Response {} {}", response.getRawStatusCode(), response.getStatusText());
				return response;
			}
		});
	}

	@Bean
	public RestTemplate restTemplate() {
		return restClient;
	}
}
