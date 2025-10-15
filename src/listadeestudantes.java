import java.util.ArrayList;

public class listadeestudantes {
    String nome;
    int id;
    ArrayList<Estudante> estudantes;

    listadeestudantes (String nome, int id) {
        this.nome = nome;
        this.estudantes = new ArrayList<>();
    }

    public void adicionarEstudantes(Estudante estudante){
            this.estudantes.add(estudante);
        }
    }
    public void removerEstudantesPorId(){

    }
    public void buscarEstudantesPorNome(){

    }
    public void ordenarEstudantesPorNome(){

    }
}