import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class CadastrodeDisciplinas {

    private LinkedHashSet <Disciplina> disciplinas;
    CadastrodeDisciplinas (String nome, String codigo){
        this.disciplinas = new LinkedHashSet<>();
    }
    public void adicionarDisciplina(Disciplina disciplina){
        if (disciplina != null){
            this.disciplinas.add(disciplina);
        }
    }
    public boolean verificarDisciplina(String codigo){
        for (Disciplina disciplina1 : this.disciplinas) {
            if (disciplina1.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
    public void removerDisciplina(String codigo){
        for (Disciplina disciplina1 : this.disciplinas) {
            if(disciplina1.getCodigo().equals(codigo)) {
                this.disciplinas.remove(disciplina1);
                break;
              }
            }

    }
    public List<Disciplina> obterTodasDisciplinas() {
        return new ArrayList<>(this.disciplinas);
    }

}
