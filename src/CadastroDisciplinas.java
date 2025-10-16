import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class CadastroDisciplinas {

    private LinkedHashSet<Disciplina> disciplinas;

    public CadastroDisciplinas() {
        this.disciplinas = new LinkedHashSet<>();
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        if (disciplina != null) {
            this.disciplinas.add(disciplina);
        }
    }

    public boolean verificarDisciplina(String codigo) {
        for (Disciplina disciplina1 : this.disciplinas) {
            if (disciplina1.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public void removerDisciplina(String codigo) {
        this.disciplinas.removeIf(disciplina -> disciplina.getCodigo().equals(codigo));
    }

    public List<Disciplina> obterTodasDisciplinas() {
        return new ArrayList<Disciplina>(this.disciplinas);
    }
}


