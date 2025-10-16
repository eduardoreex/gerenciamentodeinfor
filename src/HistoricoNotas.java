import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Comparator;
import java.util.Collections;

public class HistoricoNotas {
    private HashMap<Integer, ArrayList<Matricula>> historicoCompleto;

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

    public List<Matricula> obterMatriculas(int idEstudante) {
        if (historicoCompleto.containsKey(idEstudante)) {
            return historicoCompleto.get(idEstudante);
        } else {
            return new ArrayList<>();
        }
    }

    public Optional<Double> obternotas(int idEstudante, String codigoDisciplina) {
        ArrayList<Matricula> matriculas = historicoCompleto.get(idEstudante);
        if (matriculas == null) {
            return Optional.empty();
        }
        for (Matricula ma : matriculas) {
            if (ma.getCodigoDisciplina().equals(codigoDisciplina)) {
                return Optional.of(ma.getNota());
            }
        }
        return Optional.empty();
    }

    public void removerMatricula(int idEstudante, String codigoDisciplina) {
        ArrayList<Matricula> matriculas = historicoCompleto.get(idEstudante);
        if (matriculas == null) {
            matriculas.removeIf(m -> m.getCodigoDisciplina().equals(codigoDisciplina));
        }
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
            return 0.0;

        }
        return soma / quantidade;

    }

    public double MediaDoestudante(int idEstudante) {
        ArrayList<Matricula> matriculas = historicoCompleto.get(idEstudante);

        if (matriculas == null || matriculas.isEmpty()) {
            return 0.0;
        }

        double soma = 0;
        for (Matricula ma : matriculas) {
            soma += ma.getNota();
        }
        return soma / matriculas.size();
    }

    public List<String> topNEstudantesPorMedia(int N) {
        class EstudanteComMedia {
            int idEstudante;
            double media;

            EstudanteComMedia(int idEstudante, double media) {
                this.idEstudante = idEstudante;
                this.media = media;
            }
        }
        ArrayList<EstudanteComMedia> estudantesComMedia = new ArrayList<>();
        for (Integer idEstudante : historicoCompleto.keySet()) {
            double media = MediaDoestudante(idEstudante);
            estudantesComMedia.add(new EstudanteComMedia(idEstudante, media));
        }

        // Ordena por média decrescente
        Collections.sort(estudantesComMedia, (e1, e2) ->
                Double.compare(e2.media, e1.media)
        );

        // Monta o resultado
        ArrayList<String> resultado = new ArrayList<>();
        for (int i = 0; i < N && i < estudantesComMedia.size(); i++) {
            EstudanteComMedia est = estudantesComMedia.get(i);
            String linha = (i + 1) + ") ID: " + est.idEstudante +
                    " - Média: " + String.format("%.2f", est.media);
            resultado.add(linha);
        }
        return resultado;
    }
}