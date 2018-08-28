package br.com.agendamento.curso.managedbean;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.http.MediaType;

import br.com.agendamento.curso.model.Curso;
import br.com.agendamento.curso.rest.CursoREST;


@ManagedBean
@ViewScoped
public class CursoBean {
	
	/*
	 * Altera e carregar essa constante das propriedades do servidor
	 */
    private static final String HTTP_REST_CURSOS = "http://10.1.50.18:7001/rest/cursos";
    private Integer id;
    private Curso curso;
    private List<MediaType> mediaTypeList;
    private List<Curso> cursoList;
    private CursoREST cursoREST;

    
    @PostConstruct
    public void init() {
    	insertMediaTypeList();
    	cursoREST = new CursoREST(mediaTypeList,HTTP_REST_CURSOS);
    	cursoList = cursoREST.listar();
    }

    public void initDetalhes() {
        if(this.id != null) {
            this.curso = cursoREST.obter(id);
        } else {
            this.curso = new Curso();
        }
    }

    public String remover(Integer id) {
        cursoREST.remover(id);
        this.cursoList = cursoREST.listar();

        return "index";
    }

    public String editar() {
        if(this.id != null) {
            cursoREST.atualizar(this.curso);
        } else {
            cursoREST.inserir(this.curso);
        }
        this.cursoList = cursoREST.listar();
        return "index";
    }


	private void insertMediaTypeList() {
		mediaTypeList = new LinkedList<MediaType>();
    	mediaTypeList.add(MediaType.APPLICATION_JSON);
	}

    public String exibir(Curso curso) {
        this.curso = curso;
        return "detalhes";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getCursos() {
        return cursoList;
    }

}
