/**
 *  @author Carlos Henrique Pereira Batista. RA: 918110094
 *  @author Daniel de Oliveira Melo Lazarini. RA: 918106235
 *  @author Danilo Rocha. RA: 918121114
 *  @author Davi Braga Lima. RA: 918113163
 *  @author Matheus Andrade Vilela da Silva. RA: 917207162
 *  @author Sabrina Fontes dos Santos. RA: 918109201
 */


package crudmvcintroducao;

import bean.Contato;
import controller.ContatoController;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUDMVCIntroducao {

    /**
     * @param args the command line arguments
     * @since 1.0
     * @throws SQLException - In case of database error.
     */
   
    public static void main(String[] args) throws SQLException {
        
                
        Scanner x = new Scanner(System.in);
        System.out.print(""
                + "1 - Inserir novo contato"
                + "\n2 - Mostrar todos os contatos"
                + "\n3 - Procurar contato"
                + "\n4 - Deletar contato"
                + "\n5 - Atualizar contato"
                + "\nQual opção...? ");
        int opcao = x.nextInt();

        switch (opcao) {
            case 1:
                Contato c = new Contato();
                c.setNome("Zé das Couves");
                c.setEmail("jose@hotmail.com");
                c.setTelefone("119123456");
                c.setCep("061315");
                ContatoController it = new ContatoController();
                it.inserir(c);
                break;

               
            case 2:
                ContatoController lt = new ContatoController();
                lt.listar();
                for (Contato d : lt.listar()) {
                    System.out.println("\nId: " + d.getId());
                    System.out.println("Nome: " + d.getNome());
                    System.out.println("Email: " + d.getEmail());
                    System.out.println("Telefone: " + d.getTelefone());
                    System.out.println("CEP: " + d.getCep());
                    System.out.println("------------------------------");
                }
                break;

            case 3:
                ContatoController pt = new ContatoController();
                Contato p = new Contato();
                System.out.println("Digite o nome para pesquisa: ");
                p.setNome(x.next());
                pt.procurar(p);
                for (Contato d : pt.listar()) {
                    System.out.println("\nId: " + d.getId());
                    System.out.println("Nome: " + d.getNome());
                    System.out.println("Email: " + d.getEmail());
                    System.out.println("Telefone: " + d.getTelefone());
                    System.out.println("CEP: " + d.getCep());
                    System.out.println("------------------------------");
                }
                break;

            case 4:
                ContatoController dt = new ContatoController();
                Contato d = new Contato();
                System.out.println("Qual o ID do contato que deseja DELETAR? ");
                d.setId(x.nextInt());
                dt.deletar(d);

            case 5:
                ContatoController ut = new ContatoController();
                Contato u = new Contato();
                u.setId(1);
                u.setNome("Tipo Patinhas");
                u.setEmail("patinhas@hotmail");
                u.setTelefone("11978945658");
                u.setCep("98765123");
                ut.atualizar(u);
        }
    }
}
