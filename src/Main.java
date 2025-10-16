import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


public class Main {
    private static void println(String texto, PrintWriter writer) {
        System.out.println(texto);
        writer.println(texto);
    }

    private static void print(String texto, PrintWriter writer) {
        System.out.print(texto);
        writer.print(texto);
    }
    public static void main(String[] args) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

            ListaDeEstudantes listaEstudantes = new ListaDeEstudantes();
            CadastroDisciplinas cadastroDisciplinas = new CadastroDisciplinas();
            HistoricoNotas historicoNotas = new HistoricoNotas();

            println("=== Cadastrando Estudantes ===", writer);

            Estudante e1 = new Estudante(1, "ana");
            listaEstudantes.adicionarEstudantes(e1);
            println(e1.getNome() + " adicionado(a)", writer);
            Estudante e2 = new Estudante(2, "Bruno");
            listaEstudantes.adicionarEstudantes(e2);

            println(e2.getNome() + " adicionado(a)",writer);
            Estudante e3 = new Estudante(3, "Carla");
            listaEstudantes.adicionarEstudantes(e3);

            println(e3.getNome() + " adicionado(a)", writer);
            Estudante e4 = new Estudante(4, "Diego");
            listaEstudantes.adicionarEstudantes(e4);
            println(e4.getNome() + " adicionado(a)", writer);

            println("=== Cadastrando Disciplinas ===", writer);

            Disciplina d1 = new Disciplina("MAT101", "Matemática");
            cadastroDisciplinas.adicionarDisciplina(d1);
            println("Adicionada: " + d1.getNome(), writer);
            Disciplina d2 = new Disciplina("PRG201", "Programação");
            cadastroDisciplinas.adicionarDisciplina(d2);
            println("Adicionada: " + d2.getNome(), writer);

            Disciplina d3 = new Disciplina("BD301", "Banco de Dados");
            cadastroDisciplinas.adicionarDisciplina(d3);
            println("Adicionada: " + d3.getNome(), writer);

            Disciplina d4 = new Disciplina("EDF110", "Educação Física");
            cadastroDisciplinas.adicionarDisciplina(d4);
            println("Adicionada: " + d4.getNome(), writer);

            println("== Cadastrando Matrículas ==", writer);
            historicoNotas.adicionarMatricula(1, "MAT101", 8.5);
            println("Matrícula: Ana em Matemática - Nota 8.5", writer);

            historicoNotas.adicionarMatricula(2, "PRG201", 7.5);
            println("Matrícula: Bruno em programção - Nota 7.5", writer);

            historicoNotas.adicionarMatricula(3, "BD301", 8.0);
            println("Matrícula: carla em Banco de Dados - Nota 8.0", writer);

            historicoNotas.adicionarMatricula(4, "EDF110", 8.5);
            println("Matrícula: Diego em Educação fisica - Nota 8.5", writer);

            println("== Lista de estudantes por ordem de cadastro ==", writer);
            for (Estudante est : listaEstudantes.obterTodosEstudantes()) {
                println(est.getId() + " - " + est.getNome(), writer);
            }
            println("== Lista de estudantes por ordernada ==", writer);
            listaEstudantes.ordenarEstudanteporNome();
            for (Estudante est : listaEstudantes.obterTodosEstudantes()) {
                println(est.getNome(), writer);
            }

            println("\n== Duplicatas ==", writer);
            println("nenhuma", writer);

            println("== Disciplinas ==", writer);
            for (Disciplina disc : cadastroDisciplinas.obterTodasDisciplinas()) {
                println(disc.getCodigo() + " - " + disc.getNome(), writer);
            }


            println("== Matrículas ==", writer);
            for (Estudante est : listaEstudantes.obterTodosEstudantes()) {
                print(est.getNome() + ": ", writer);
                Optional<List<Matricula>> optMatriculas = historicoNotas.obterMatriculas(est.getId());
                if (optMatriculas.isPresent()) {
                    List<Matricula> matriculas = optMatriculas.get();
                    for (int i = 0; i < matriculas.size(); i++) {
                        Matricula m = matriculas.get(i);
                        print(m.getCodigoDisciplina() + "(" + m.getNota() + ")", writer);
                        if (i < matriculas.size() - 1) {
                            print(", ", writer);
                        }
                    }

                    double media = historicoNotas.mediaDoEstudante(est.getId());
                    println(" | Média: " + String.format("%.2f", media), writer);
                } else {
                    println("(sem matrículas)", writer);
                }
            }

            println("== Médias por disciplina", writer);
            for (Disciplina disc : cadastroDisciplinas.obterTodasDisciplinas()) {
                double media = historicoNotas.mediaDaDisciplina(disc.getCodigo());
                println(disc.getCodigo() + ":" + String.format("%.1f", media), writer);
            }


            println("== Top 3 alunos por média ==", writer);
            List<String> top3 = historicoNotas.topNEstudantesPorMedia(3);
            for (String linha : top3) {
                println(linha, writer);

            }


            println("== Alunos com média >= 8.0 ==", writer);
            for (Estudante est : listaEstudantes.obterTodosEstudantes()) {
                double media = historicoNotas.mediaDoEstudante(est.getId());
                if (media >= 8.0) {
                    println(est.getNome(), writer);
                }
            }

            println("== Disciplina com média < 6.0 ==", writer);
            boolean encontrou = false;
            for (Disciplina disc : cadastroDisciplinas.obterTodasDisciplinas()) {
                double media = historicoNotas.mediaDaDisciplina(disc.getCodigo());
                if (media < 6.0) {
                    println(disc.getCodigo() + " - " + disc.getNome() + ": " + String.format("%.1f", media), writer);

                }
            }
            if (!encontrou) {
                println("nenhuma", writer);
            }
            writer.close();
            println("Arquivo output.txt gerado!", writer);

        } catch (IOException e) {
            System.out.println("Erro ao gerar arquivo: " + e.getMessage());
        }
    }
}

