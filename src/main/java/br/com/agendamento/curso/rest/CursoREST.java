package br.com.agendamento.curso.rest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import br.com.agendamento.curso.model.Curso;

public class CursoREST extends AbstractREST {

	
	String cursosResourceUrl = null;
	
	public CursoREST(List<MediaType> mediaTypeList, String cursosResourceUrl){
		super(mediaTypeList);
		this.cursosResourceUrl = cursosResourceUrl;
	}
	
	
	
    public List<Curso> listar() {
    	HttpEntity<Curso[]> entity = new HttpEntity<Curso[]>(httpHeaders);
    	ResponseEntity<Curso[]> responseEntity = this.restTemplate.exchange(this.cursosResourceUrl,
																			HttpMethod.GET,
																			entity,
																			Curso[].class);
    	return Arrays.asList(responseEntity.getBody()); 
    }

    public Curso obter(Integer id) {
    	String urlCall = cursosResourceUrl + "/" + id.toString();
    	ResponseEntity<Curso> response= (ResponseEntity<Curso>) restTemplate.getForEntity(urlCall, Curso.class);
    	return response.getBody();
    }

    public void atualizar(Curso nota) {
//        webResource.path("Notes").path(nota.getId().toString()).put(ClientResponse.class,nota );
    }

    public void remover(Integer id) {
//        webResource.path("Notes").path(id.toString()).delete();
    }

    public void inserir(Curso nota) {
//        webResource.path("Notes").post(new GenericType<Nota>(){}, nota);
    }

    public static void main(String...args) {
    	LinkedList<MediaType> mediaTypeList = new LinkedList<MediaType>();
    	mediaTypeList.add(MediaType.APPLICATION_JSON);
    	CursoREST cursoREST = new CursoREST(mediaTypeList,"http://10.1.50.18:7001/rest/cursos");
    	List<Curso> cursoList = cursoREST.listar();
    	cursoList.forEach(i -> System.out.println(i.toString()));
    	  
    }
	
	
}
