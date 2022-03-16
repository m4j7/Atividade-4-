package br.com.uniamerica.atividade;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListarAlunoServlet extends HttpServlet {
	
	private static final long serialVersionUIN = 1L; 
	
	public void doPost(
			HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse) 
	
	throws IOException {
		
		    PrintWriter printWriter = httpServletResponse.getWriter();
		    printWriter.println(corpoTable(AlunoDao.alunos));
		
	}
	
	public String corpoTable (List<Aluno> alunos) {
		
	   String html = ""; 
	   
	   html += "<div style = 'heigth: 100%; justify-content: center; display: flex;'>";
	   html += "<div style = 'width: 800px;'>";
	   html += "<h1 style = 'text-aling: center; color: white;' > Lista </h1>";
	   
	   html += "<a href= 'cadastrarAluno.html'"
	   		+ "style= 'float: rigth; "
	   		+ "background: #88eaff; "
	   		+ "color: black; "
	   		+ "font-size: 24px; "
	   		+ "text aling; center;"
	   		+ "text-decoration: auto; "
	   		+ "border-radius: 100px 100px 100px 100px;"
	   		+ "margin-top: -60px;'>"
	   		+"Cadastrar Alunos"
	   		+ "</a>";
	   
      html +="<hr>"; 
      html += "<table border = '1'  style= 'width: 100%'>";
      html += "<tr style= 'background: #88eaff; color: black;'>";
      html += "<th></th>";
      html += "<th>NOME</th>";
      html += "<th>MATERIA</th>";
      html += "<th>OPCAO</th>";	 
      html += campos(alunos);	
      
      html +=" </tables>";
      html +=" </div>";
      html +=" </div>";
      
      return html;
	}

	
	public String campos (List<Aluno> alunos) {
		
		String html  = ""; 
		
	    for (int i = 0; i < alunos.size(); i++) {
	    	
	    	 html +="<tr style = 'color:black;'>"; 
		     html +=" <th>" + i + "</th>";
		     html +=" <th>" +alunos.get(i).getNome() + "</th>"; 
		     html +=" <th>" + alunos.get(i).getTurma() + "</th>";
		     html +=" <th style= 'width: 150px '>"; 
		     
		     html +=" <form action= 'editarAluno' method='post'style= 'hidth:50%; float:left; margin-top:14px;'>";
	    	 html +=" <input type= 'hidden' name='index' value='" + i +"'>";
	    	 html +=" <input type= 'submit' value = 'Editar' style: background:#88eaff; color: black;'>";
	    	 html += " </form>";
	    	 
	    	 html +=" <form action= 'exluirAluno' method='post' style= 'hidth:50%; float:rigth; margin-top:14px;'>";
	    	 html +=" <input type= 'hidden' name='index' value='" + i +"'>";
	    	 html +=" <input type= 'submit' value = 'Excluir' style: background:#88eaff; color: black;'>";
	    	 html += " </form>";
	    	 
	    	 html +="</th>";
	         html += "</tr>";
	          
	    }
	    return html; 	
	
	}
	
	

}
