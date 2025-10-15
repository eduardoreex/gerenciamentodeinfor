import java.util.ArrayList;
public class CadastrodeDisciplinas {
    String nome;
    String codigo;
    ArrayList<Disciplina> disciplinas;
    CadastrodeDisciplinas (String nome, String codigo){
        this.codigo = codigo;
        this.nome = nome;
        this.disciplinas = new ArrayList<>();
    }
    public void adicionarDisciplina(Disciplina disciplina){
        if(!verificarDisciplina(disciplina.codigo)) {
            this.disciplinas.add(disciplina);
        }
    }
    public boolean verificarDisciplina(String codigo){
        for (Disciplina disciplina1 : this.disciplinas) {
            if (disciplina1.codigo.toLowerCase().equals(codigo.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    public void removerDisciplina(String codigo){
        for (Disciplina disciplina1 : this.disciplinas) {
            if(disciplina1.equals(codigo)) {
                this.disciplinas.remove(disciplina1);
                break;
              }
            }

    }
    public ArrayList<Disciplina> obterTodasDisciplinas() {
        return this.disciplinas;

    }

}
