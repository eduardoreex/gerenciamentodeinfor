import java.util.ArrayList;
public class CadastrodeDisciplinas {
    String nome;
    String codigo;
    ArrayList<Disciplina> disciplinas;
    CadastrodeDisciplinas (String nome, String codigo){
        this.codigo = codigo;
        this.nome = nome;
    }
    public void adicionarDisciplina(Disciplina disciplina){
        this.disciplinas.add(disciplina);
    }
    public void verificarDisciplina(String codigo){

    }
    public void removerDisciplina(String codigo){

    }
    public void obterTodasDisciplinas() {

    }

}
