//ESTAGIÁRIO
public class Estagiario extends Funcionario implements Trabalhavel {
    private int horasTrabalhadas;
    private String supervisor;

    public Estagiario(String nome, int matricula, int horasTrabalhadas, String supervisor) {
        super(nome, matricula);
        this.horasTrabalhadas = horasTrabalhadas;
        this.supervisor = supervisor;
    }

    @Override
    public double calcularSalario() {
        return horasTrabalhadas * 10;
    }

    @Override
    public String obterDetalhes() {
        return "Estagiário: " + nome + ", Matrícula: " + matricula + ", Salário: " + calcularSalario() + ", Supervisor: " + supervisor;
    }

    @Override
    public void trabalhar() {
        System.out.println("Estagiário " + nome + " está estagiando, e sendo supervisionado por " + supervisor);
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Estagiário " + nome + " está organizando todos os relatórios para o " + supervisor + " ganhar a promoção.");
    }
}
