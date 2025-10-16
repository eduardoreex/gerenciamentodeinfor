public class Matricula {
    String codigoDisciplina;
    double nota;

    Matricula(String codigoDisciplina, double nota) {
        this.codigoDisciplina = codigoDisciplina;
        this.nota = nota;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public double getNota() {
        return nota;
    }
}