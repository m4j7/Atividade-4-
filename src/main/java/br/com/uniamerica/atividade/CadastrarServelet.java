package br.com.uniamerica.atividade;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CadastrarServelet extends HttpServlet {

	
	public void doPost(
			HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse) 
	
	throws IOException {
		
		
		 Aluno aluno = new Aluno(); 
		 
		 
		 int id = -1;
		 
		 
		if(httpServletRequest.getParameter("index") != null) {
			
			id = Integer.valueOf(httpServletRequest.getParameter("index"));
		}
		
		AlunoDao alunoDao = new AlunoDao();
		
		
		if(alunoDao.validacao(httpServletRequest.getParameter("nome"),httpServletRequest.getParameter("turma")) == true) {
			
		aluno.setNome(httpServletRequest.getParameter("nome")); 
		aluno.setTurma(httpServletRequest.getParameter("turma"));
		
		if ( id >= 0) {
			alunoDao.atualizar(id, aluno);
		}else {
			
			alunoDao.cadastrar(aluno);
			
			
		}} else {
			
			System.out.println("Inputs não preenchidos");
			
		}
		
		httpServletResponse.sendRedirect("listarAluno.html");		

		
	} }
	
