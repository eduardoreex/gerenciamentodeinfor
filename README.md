# Sistema de Gerenciamento Escolar

Desenvolvedor:
Eduardo Oliveira dos Santos - 2º Período

 Sobre o Projeto

Sistema feito em Java para gerenciar informações de estudantes, disciplinas e notas. O programa cadastra alunos, registra suas matrículas em disciplinas, calcula médias e gera relatórios.

Funcionalidades:
- Cadastrar e buscar estudantes
- Controlar disciplinas sem repetições
- Registrar notas e calcular médias
- Rankear os melhores alunos
- Identificar alunos aprovados e disciplinas com baixo desempenho
- Gerar arquivo de saída com todos os dados


Por que usei essas coleções?

ArrayList para guardar os estudantes porque preciso acessar eles por posição e ordenar por nome quando necessário. É simples de usar e rápido para o que preciso.

LinkedHashSet para as disciplinas porque não pode ter disciplina repetida e quero manter a ordem que foram cadastradas. O Set já garante que não vai ter duplicata.

HashMap para relacionar cada estudante com suas notas. Uso o ID do estudante como chave e a lista de matrículas como valor. Fica fácil buscar todas as notas de um aluno específico.


Como executar:

1. Compile os arquivos:
javac *.java

2. Execute o programa:
java Main

3. O arquivo output.txt vai ser criado automaticamente com todos os resultados.

Se estiver usando uma IDE tipo IntelliJ ou Eclipse, é só abrir o projeto e rodar o Main.java normalmente.

Desafios:

O maior desafio foi trabalhar com o Optional quando busco as matrículas de um estudante. Tive que aprender a verificar se o valor existe antes de usar, senão dava erro.

Também precisei criar uma forma de escrever os resultados tanto no console quanto no arquivo ao mesmo tempo. Resolvi fazendo métodos auxiliares que recebem o PrintWriter.

Outra coisa foi ordenar os alunos por média em ordem decrescente. Usei lambda expression no Collections.sort() que funcionou bem.


Estrutura dos Arquivos

- Main.java - Programa principal com os testes
- Estudante.java - Classe do estudante
- Disciplina.java - Classe da disciplina
- Matricula.java - Classe que junta disciplina e nota
- ListaDeEstudantes.java - Gerencia estudantes (ArrayList)
- CadastroDisciplinas.java - Gerencia disciplinas (LinkedHashSet)
- HistoricoNotas.java - Gerencia notas (HashMap)
- output.txt - Arquivo gerado com os resultados