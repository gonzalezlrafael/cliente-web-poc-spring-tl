package br.com.agendamento.curso.rest;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class AbstractREST {
	
	protected RestTemplate restTemplate;
	protected HttpHeaders httpHeaders= null;
    
	public AbstractREST(){
		
	}
	
    public AbstractREST(List<MediaType> mediaTypeList){
    	
    	restTemplate = new RestTemplate();
    	MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
    	mappingJackson2HttpMessageConverter.setSupportedMediaTypes(mediaTypeList);
    	restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
    	
    	this.httpHeaders = new HttpHeaders();
    	this.httpHeaders.setAccept(mediaTypeList);
    	this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    }

}
