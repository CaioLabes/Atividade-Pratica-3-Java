//DESENVOLVEDOR
public class Desenvolvedor extends Funcionario implements Trabalhavel {
    private String[] tecnologias;

    public Desenvolvedor(String nome, int matricula, String[] tecnologias) {
        super(nome, matricula);
        this.tecnologias = tecnologias;
    }

    @Override
    public double calcularSalario() {
        return 4000 + tecnologias.length * 250;
    }

    @Override
    public String obterDetalhes() {
        return "Desenvolvedor: " + nome + ", Matrícula: " + matricula + ", Salário: " + calcularSalario() + ", Tecnologias: " + String.join(", ", tecnologias);
    }

    @Override
    public void trabalhar() {
        System.out.println("Desenvolvedor " + nome + " está trabalhanco em " + tecnologias.length + " tecnologias");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Desenvolvedor " + nome + " está terminando o seu desenvolvimento e não vê a luz do dia a algum tempo");
    }
}
