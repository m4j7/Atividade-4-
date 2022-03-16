package br.com.uniamerica.atividade;

import java.util.ArrayList;
import java.util.List;

public class AlunoDao {

	
  public static ArrayList<Aluno> alunos = new ArrayList <Aluno> ();
  
  public AlunoDao() {
	  
  }
  
  public void cadastrar (Aluno aluno) {
	  alunos.add(aluno);
  }
  
  public List <Aluno> mostrar() {
	  return alunos;
  }
  
  
  public void atualizar (int index, Aluno aluno) {
      alunos.set(index, aluno); 
  }
  
  public void excluir (int index) {
	  this.alunos.remove(index);
  }
  
  public Aluno findByIndex(int index) {
	  return alunos.get(index);
  }
	
 
  public boolean validacao(String nome, String turma) {
	
	if(nome.isEmpty() == false && turma.isEmpty() == false) {
		return true;
	}
	
	return false;}
	
}
