public class Disciplina {
    String codigo;
    String nome;

    Disciplina(String codigo, String nome) {
        this.codigo =  codigo;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Disciplina outra = (Disciplina) obj;
        return codigo.equals(outra.codigo);
    }
    public int hashCode() {
        return  codigo.hashCode();
    }
    public String toString(){
        return codigo + " - " +  nome;
    }
}

