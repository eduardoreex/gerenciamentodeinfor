import java.util.ArrayList;
import java.util.List;

public class  ListaDeEstudantes {
    private ArrayList<Estudante> estudantes;

    ListaDeEstudantes(String nome, int id) {
        this.estudantes = new ArrayList<>();
    }

    public void adicionarEstudantes(Estudante estudante){
        if (estudante != null)
            this.estudantes.add(estudante);
    }
    public void removerEstudantesPorId(Estudante id){
        this.estudantes.remove(id);
    }
    public Estudante obterEstudantePorIndice(int indice){
       return this.estudantes.get(indice);
    }

    public List<Estudante> buscarEstudantesPorNome(String subestring) {
        ArrayList<Estudante> resultado = new ArrayList<>();
        for (Estudante estudante1 : this.estudantes) {
            if (estudante1.nome.toLowerCase().contains(subestring.toLowerCase())) {
                resultado.add(estudante1);
            }
        }
        return resultado;
    }
    public void ordenarEstudanteporNome(){
    this.estudantes.sort((estudante1, estudante2) -> estudante1.nome.compareTo(estudante2.nome));
    }
    public List<Estudante> obterTodosEstudantes() {
        return new ArrayList<>(this.estudantes);
    }
}