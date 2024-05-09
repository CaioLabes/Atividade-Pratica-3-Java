//CLASSE PRINCIPAL
public class Home{
    public static void main(String[] args) {
        //demonstração dos métodos da interface funcionando
        Gerente g1 = new Gerente("Maria", 889, 2000, "Suporte");
        g1.trabalhar();
        g1.relatarProgresso();
        System.out.println("-------------");
        Estagiario e1 = new Estagiario("Jorge", 877, 30, "Fabrício");
        e1.trabalhar();
        e1.relatarProgresso();

        //Sistema de menu para o terminal
        SistemaFuncionarios sistema = new SistemaFuncionarios();

        sistema.iniciarSistema();
    }
}
