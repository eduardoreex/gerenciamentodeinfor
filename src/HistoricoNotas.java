import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class HistoricoNotas {
    HashMap<Integer, ArrayList<Matricula>> historicoCompleto;

    public HistoricoNotas() {
        this.historicoCompleto = new HashMap<>();

    }

    public void adicionarMatricula(int idEstudante, String codigoDisciplina, double nota) {
        Matricula novaMatricula = new Matricula(codigoDisciplina, nota);
        if (historicoCompleto.containsKey(idEstudante)) {
            historicoCompleto.get(idEstudante).add(novaMatricula);
        } else {
            ArrayList<Matricula> novaLista = new ArrayList<>();
            novaLista.add(novaMatricula);
            historicoCompleto.put(idEstudante, novaLista);
        }
    }

    public ArrayList<Matricula> obterMatriculas(int idEstudante) {
        if (historicoCompleto.containsKey(idEstudante)) {
            return historicoCompleto.get(idEstudante);
        } else {
            return new ArrayList<>();
        }
    }

    public double obternotas(int idEstudante, String codigoDisciplina) {
        ArrayList<Matricula> matriculas = historicoCompleto.get(idEstudante);
        if (matriculas == null) {
            return -1;
        }
        for (Matricula ma : matriculas) {
            if (ma.getCodigoDisciplina().equals(codigoDisciplina)) {
                return ma.getNota();
            }
        }
        return -1;
    }

    public Matricula removerMatricula(int idEstudante, String codigoDisciplina) {
        ArrayList<Matricula> matriculaDoEstudante = historicoCompleto.get(idEstudante);
        if (matriculaDoEstudante == null) {
            return null;
        }
        for (Matricula ma : matriculaDoEstudante) {
            if (ma.getCodigoDisciplina().equals(codigoDisciplina)) {
                historicoCompleto.get(idEstudante).remove(ma);
                return ma;
            }
        }
        return null;

    }
    public double MediaDaDisciplina(String CodigoDisciplina) {
        double soma = 0;
        int quantidade = 0;

        for (ArrayList<Matricula> matriculas : historicoCompleto.values()) {
            for (Matricula ma : matriculas) {
                if (ma.getCodigoDisciplina().equals(CodigoDisciplina)) {
                    soma += ma.getNota();
                    quantidade++;
                }
            }
        }

        if (quantidade == 0) {
            return -1;

        }
        return soma / quantidade;

    }

    public double MediaDoestudante(int idEstudante) {
        double soma = 0;
        int quantidade = 0;

        ArrayList<Matricula> matriculas = historicoCompleto.get(idEstudante);

        if (matriculas == null) {
            return -1;

        }
        for (Matricula ma : matriculas) {
            soma += ma.getNota();
            quantidade++;
        }
        if (quantidade == 0) {
            return -1;
        }
        return soma / quantidade;
    }

    private class EstudanteComMedia {
        int idEstudante;
        double media;

        EstudanteComMedia(int idEstudante, double media) {
            this.idEstudante = idEstudante;
            this.media = media;
        }

        @Override
        public String toString() {
            return "Id: " + idEstudante + " - Média: " + String.format("%.2f", media);
        }
    }

    public ArrayList<String> topNEstudantesPorMedia(int N, ListaDeEstudantes lista) {
        ArrayList<EstudanteComMedia> estudanteComMedia = new ArrayList<>();
        for (Integer idEstudante : historicoCompleto.keySet()) {
            double media = MediaDoestudante(idEstudante);
            EstudanteComMedia estudante = new EstudanteComMedia(idEstudante, media);
            estudanteComMedia.add(estudante);
        }

        Collections.sort(estudanteComMedia, new Comparator<EstudanteComMedia>() {
            @Override
            public int compare(EstudanteComMedia e1, EstudanteComMedia e2) {
                return Double.compare(e2.media, e1.media);
            }
        });
        ArrayList<String> resultado = new ArrayList<>();
        for (int i = 0; i < N && i < estudanteComMedia.size(); i++) {
            EstudanteComMedia est = estudanteComMedia.get(i);
            String linha = (i + 1) + ") " + est.toString();
            resultado.add(linha);
        }
        return resultado;
    }
}




