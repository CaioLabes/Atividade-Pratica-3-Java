//Sistema para o terminal
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaFuncionarios {
    private ArrayList<Funcionario> funcionarios;
    private Scanner leitor;
    

    public SistemaFuncionarios() {
        funcionarios = new ArrayList<>();
        leitor = new Scanner(System.in);
    }

    public void iniciarSistema() {
        int op;
        do {
            exibirMenu();
            op = leitor.nextInt();
            leitor.nextLine(); 

            switch (op) {
                case 1:
                    adicionarFuncionario();
                    break;
                case 2:
                    deletarFuncionario();
                    break;
                case 3:
                    listarFuncionarios();
                    break;
                case 4:
                    buscarFuncionario();
                    break;
                case 0:
                    System.out.println("\nSaindo... Muito Obrigado!");
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente outra vez.");
            }
        } while (op != 0);
    }

    public void exibirMenu() {
        System.out.println("\n#### MENU ####");
        System.out.println("1. Adicionar Funcionário");
        System.out.println("2. Remover Funcionário");
        System.out.println("3. Listar Funcionários");
        System.out.println("4. Buscar Funcionário");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void adicionarFuncionario() {
        System.out.print("Digite o nome do funcionário: ");
        String nome = leitor.nextLine();
        System.out.print("Digite a matrícula do funcionário: ");
        int matricula = leitor.nextInt();
        leitor.nextLine(); 
    
        System.out.println("Escolha o tipo de funcionário:");
        System.out.println("1. Gerente");
        System.out.println("2. Desenvolvedor");
        System.out.println("3. Estagiário");
        int tipo = leitor.nextInt();
        leitor.nextLine(); 
    
        Funcionario funcionario = null;
    
        switch (tipo) {
            //ADIÇÃO DE QUAL TIPO DE FUNCIONÁRIO O CADASTRO É
            case 1:
                
                System.out.print("\nDigite o bônus anual do gerente: ");
                double bonusAnual = leitor.nextDouble();
                leitor.nextLine(); 
                System.out.print("\nDigite a equipe do gerente: ");
                String equipe = leitor.nextLine();
                funcionario = new Gerente(nome, matricula, bonusAnual, equipe);
                break;
            case 2:
                
                System.out.print("\nDigite as tecnologias que o desenvolvedor domina (separadas por vírgula): ");
                String tecnologiasString = leitor.nextLine();
                String[] tecnologias = tecnologiasString.split(",\\s*");
                funcionario = new Desenvolvedor(nome, matricula, tecnologias);
                break;
            case 3:
                
                System.out.print("\nDigite as horas de trabalho do estagiário: ");
                int horasTrabalho = leitor.nextInt();
                leitor.nextLine(); 
                System.out.print("\nDigite o nome do supervisor do estagiário: ");
                String supervisor = leitor.nextLine();
                funcionario = new Estagiario(nome, matricula, horasTrabalho, supervisor);
                break;
            default:
                System.out.println("\nOpção inválida. Funcionário não adicionado.");
                return;
        }
        funcionarios.add(funcionario);
        System.out.println("\nFuncionário adicionado a lista!");
    }
    //DELETAR
    public void deletarFuncionario() {
        System.out.print("\nDigite a matrícula do funcionário a ser removido: ");
        int matricula = leitor.nextInt();
        leitor.nextLine();

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getMatricula() == matricula) {
                funcionarios.remove(i);
                System.out.println("\nFuncionário removido com sucesso.");
                return;
            }
        }

        System.out.println("\nFuncionário não encontrado.");
    }
    //LISTAGEM
    public void listarFuncionarios() {
        System.out.println("\n--- Lista de Funcionários ---\n");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.obterDetalhes());
        }
        System.out.println("-----------------------------");
    }
    //BUSCA
    public void buscarFuncionario() {
        System.out.print("\nDigite o nome ou matrícula do funcionário: ");
        String busca = leitor.nextLine();
        
        boolean encontrado = false;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(busca) || String.valueOf(funcionario.getMatricula()).equals(busca)) {
                System.out.println("Funcionário encontrado:");
                System.out.println(funcionario.obterDetalhes());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("\nFuncionário não encontrado.");
        }
    }
}