package br.com.uniamerica.atividade;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditarAlunoServelet extends HttpServlet {

	
	public void doPost(
			HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse) 
	
	throws IOException {
		
		    int id = Integer.valueOf(httpServletRequest.getParameter("index"));
		  
		    AlunoDao ld = new AlunoDao();
		    Aluno aluno = ld.findByIndex(id);
		    
		    String html  = ""; 
		   
		    html +=" <form action='CadastrarAluno' method= 'post'> ";
		    html +=" <input type='hidden' name='index' value='"+id+"'>";

		    
		    html += "<hr> <br/>";
		    html +="<label style='color: #88eaff '>Nome:</label> <br/>";
		    html += "<input type= \"text\" value= '"+aluno.getNome()+"' name= \"nome\" style= \"width: 100%\">";
		    html += "<label style=\"color: #88eaff\">Turma:</label> <br/>";
		    html += "<input type= \'text\' value= '"+aluno.getTurma()+"' name = \"materia\" style= \"width: 100%\">";
		    
		    html += "<br /><br /><br />";
		   
		    
		    html += "<div style = \"width: 50%; float:lef;";
		    html += "background: #88eaff; ";
		    html += "color: black;";
		    html += "width: 100%; padding:10px 10px 10px 10px ;\">";
		    
		    html += "<a href = 'listarAluno.html'>";
		    html += "Listar Alunos";
		    html += "</a>";
		    
		    html += "<input type='submit' value = 'Editar'";
		    html +=	"style= 'background: #88eaff; font-size:16px; color: black; width: 100%;  text-align: center; padding:10px 10px 10px 10px; \">";
		    
		    
		    html += "</div>";
		    html += "<div style = 'width: 50%; float:lef;>";
		    html += "</div>";
	
		    html += "</form>";
		    
		    
		   httpServletResponse.setContentType("text/html");
		    
		   PrintWriter printWriter = httpServletResponse.getWriter();
		   printWriter.println(html);
		     
		    	   
			
		
	}
}
