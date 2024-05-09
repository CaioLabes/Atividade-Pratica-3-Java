//GERENTE
public class Gerente extends Funcionario implements Trabalhavel {
    private double bonusAnual;
    private String equipe;

    public Gerente(String nome, int matricula, double bonusAnual, String equipe) {
        super(nome, matricula);
        this.bonusAnual = bonusAnual;
        this.equipe = equipe;
    }

    @Override
    public double calcularSalario() {
        return 7300 + (bonusAnual * 0.5) ;
    }

    @Override
    public String obterDetalhes() {
        return "Gerente: " + nome + ", Matrícula: " + matricula + ", Salário: " + calcularSalario() + ", Equipe: " + equipe;
    }

    @Override
    public void trabalhar() {
        System.out.println("Gerente " + nome + " é encarregado de gerir e supervisionar a equipe " + equipe);
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Gerente " + nome + " está relatando que o projeto da equipe " + equipe + " está quase finalizado");
    }
}
