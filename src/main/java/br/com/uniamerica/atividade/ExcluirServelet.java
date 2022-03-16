package br.com.uniamerica.atividade;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExcluirServelet extends HttpServlet {

	public void doPost(
			HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse) 
	
	throws IOException {
	
	int id = Integer.valueOf(httpServletRequest.getParameter("index"));
	  
    AlunoDao ld = new AlunoDao();
    
    ld.excluir(id);
    
	httpServletResponse.sendRedirect("listarAluno.html");	

    
	}
}
