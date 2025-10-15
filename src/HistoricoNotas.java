import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class HistoricoNotas {
     HashMap <Integer , ArrayList<Matricula>> historicoCompleto;

    public HistoricoNotas(){
        this.historicoCompleto = new HashMap<>();

    }
    public void adicionarMatricula (int idEstudante, String codigoDisciplina, double nota) {
        Matricula novaMatricula = new Matricula(codigoDisciplina, nota);
        if (historicoCompleto.containsKey(idEstudante)) {
            historicoCompleto.get(idEstudante).add(novaMatricula);
        } else {
            ArrayList<Matricula> novaLista = new ArrayList<>();
            novaLista.add(novaMatricula);
            historicoCompleto.put(idEstudante, novaLista);
        }
    }

    public ArrayList<Matricula> obterMatriculas (int idEstudante){
            if (historicoCompleto.containsKey(idEstudante)) {
                return historicoCompleto.get(idEstudante);
            } else {
                return new ArrayList<>();
            }
        }

    public ArrayList<HistoricoNotas> obternotas (int idEstudante, String codigoDisciplina) {

        }

    public Matricula RemoverMatricula (int idEstudante, String codigoDisciplina, double nota) {
            if(historicoCompleto.containsKey(idEstudante)) {
                historicoCompleto.get(idEstudante).remove(Matricula);
            } else {
                System.out.println("n tem essa matricula");
            }

    public void MediaDoEstudante(int id){
    // soma das notas / numero de notas = media das notas

    }
    public void MediaDaDisciplina(String codigoDisciplina){

    }
    public void topNEstudantesPOrMedia(int N){

    }


