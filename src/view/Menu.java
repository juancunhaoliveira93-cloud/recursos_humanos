package view;

import java.util.Scanner;
import controller.Departamento_controller;
import controller.Funcionario_controller;
import model.Funcionario;

public class Menu {
	// Instanciamos os controllers uma única vez para usar no sistema todo
    private Departamento_controller deptCtrl;
    private Funcionario_controller funcCtrl;
    private Scanner entrada;

    public Menu() {
        this.deptCtrl = new Departamento_controller();
        this.funcCtrl = new Funcionario_controller();
        this.entrada = new Scanner(System.in);
    }

    // --- TELA DE APRESENTAÇÃO ---
    public void exibirCapa() {
        System.out.println("=========================================");
        System.out.println("      Recursos Humanos      ");
        System.out.println("=========================================");
        System.out.println("DISCIPLINA: Laboratório de Programação 2");
        System.out.println("PROFESSORA: Renata");
        System.out.println("TURMA:      2025-2 2DC");
        System.out.println("\nINTEGRANTES DO GRUPO:");
        System.out.println("1. Carine ");
        System.out.println("2. Juan ");
        System.out.println("3. Matheus");
        System.out.println("=========================================\n");
        System.out.println("Pressione ENTER para iniciar...");
        entrada.nextLine();
    }

    // --- MENU PRINCIPAL ---
    public void iniciarMenuPrincipal() {
        int opcao = 0;
        do {
            System.out.println("\n=== MENU GERAL ===");
            System.out.println("1. Gestão de Departamentos");
            System.out.println("2. Gestão de Funcionários");
            System.out.println("3. Sair");
            System.out.print("Escolha: ");
            
            try {
                opcao = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    menuDepartamentos();
                    break;
                case 2:
                    menuFuncionarios();
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }

    // --- SUB-MENU DEPARTAMENTOS ---
    private void menuDepartamentos() {
        int opcao = 0;
        do {
            System.out.println("\n--- GESTÃO DE DEPARTAMENTOS ---");
            System.out.println("1. Inserir Departamento");
            System.out.println("2. Consultar Geral");
            System.out.println("3. Voltar");
            System.out.print("Escolha: ");
            
            try {
                opcao = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    telaInserirDepartamento();
                    break;
                case 2:
                    System.out.println(deptCtrl.consultarGeralDepartamento());
                    break;
                case 3:
                    return; // Volta para o menu anterior
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }

    // --- SUB-MENU FUNCIONÁRIOS ---
    private void menuFuncionarios() {
        int opcao = 0;
        do {
            System.out.println("\n--- GESTÃO DE FUNCIONÁRIOS ---");
            System.out.println("1. Inserir Funcionário");
            System.out.println("2. Alterar Funcionário");
            System.out.println("3. Excluir Funcionário");
            System.out.println("4. Consultar Geral");
            System.out.println("5. Consultar por Departamento");
            System.out.println("6. Voltar");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    telaInserirFuncionario();
                    break;
                case 2:
                    telaAlterarFuncionario();
                    break;
                case 3:
                    telaExcluirFuncionario();
                    break;
                case 4:
                    System.out.println(funcCtrl.consultarGeralFuncionario());
                    break;
                case 5:
                    telaConsultaPorDepto();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
    }

    // --- TELAS DE INTERAÇÃO (Perguntas) ---

    private void telaInserirDepartamento() {
        try {
            System.out.println("\n[Novo Departamento]");
            System.out.print("ID: ");
            int id = Integer.parseInt(entrada.nextLine());
            
            System.out.print("Descrição: ");
            String desc = entrada.nextLine();

            // Chama o Controller
            if (deptCtrl.inserirDadosDepartamento(id, desc)) {
                System.out.println("Sucesso: Departamento cadastrado!");
            } else {
                System.out.println("Erro: ID já existe ou falha na gravação.");
            }
        } catch (Exception e) {
            System.out.println("Erro nos dados digitados.");
        }
    }

    private void telaInserirFuncionario() {
        try {
            System.out.println("\n[Novo Funcionário]");
            System.out.print("ID: ");
            int id = Integer.parseInt(entrada.nextLine());

            System.out.print("Nome: ");
            String nome = entrada.nextLine();

            System.out.print("Data Nascimento: ");
            String data = entrada.nextLine();

            System.out.println("--- Departamentos Disponíveis ---");
            System.out.println(deptCtrl.consultarGeralDepartamento());
            System.out.print("ID do Departamento: ");
            int idDep = Integer.parseInt(entrada.nextLine());

            Funcionario f = new Funcionario(id, nome, data, idDep);

            if (funcCtrl.inserirDadosFuncionario(f)) {
                System.out.println("Sucesso: Funcionário cadastrado!");
            } else {
                System.out.println("Erro: ID duplicado ou Departamento inexistente.");
            }
        } catch (Exception e) {
            System.out.println("Erro nos dados digitados.");
        }
    }

    private void telaAlterarFuncionario() {
        try {
            System.out.println("\n[Alterar Funcionário]");
            System.out.print("Digite o ID do funcionário a alterar: ");
            int id = Integer.parseInt(entrada.nextLine());

            // Verifica se existe antes de pedir os dados novos
            if (funcCtrl.buscarIdFuncionario(id) == null) {
                System.out.println("Funcionário não encontrado.");
                return;
            }

            System.out.print("Novo Nome: ");
            String nome = entrada.nextLine();
            System.out.print("Nova Data Nascimento: ");
            String data = entrada.nextLine();
            
            System.out.println(deptCtrl.consultarGeralDepartamento());
            System.out.print("Novo ID Departamento: ");
            int idDep = Integer.parseInt(entrada.nextLine());

            Funcionario fEditado = new Funcionario(id, nome, data, idDep);

            if (funcCtrl.alterarFuncionario(fEditado)) {
                System.out.println("Sucesso: Dados atualizados.");
            } else {
                System.out.println("Erro ao atualizar.");
            }
        } catch (Exception e) {
            System.out.println("Erro nos dados.");
        }
    }

    private void telaExcluirFuncionario() {
        try {
            System.out.println("\n[Excluir Funcionário]");
            System.out.print("Digite o ID para excluir: ");
            int id = Integer.parseInt(entrada.nextLine());

            System.out.print("Tem certeza? (S/N): ");
            String resp = entrada.nextLine();

            if (resp.equalsIgnoreCase("S")) {
                if (funcCtrl.excluirFuncionario(id)) {
                    System.out.println("Sucesso: Registro excluído.");
                } else {
                    System.out.println("Erro: ID não encontrado.");
                }
            } else {
                System.out.println("Operação cancelada.");
            }
        } catch (Exception e) {
            System.out.println("Erro nos dados.");
        }
    }

    private void telaConsultaPorDepto() {
        try {
            System.out.println("\n[Consulta por Departamento]");
            System.out.println(deptCtrl.consultarGeralDepartamento());
            System.out.print("Digite o ID do Departamento: ");
            int id = Integer.parseInt(entrada.nextLine());

            System.out.println(funcCtrl.consultarFuncionariosPorDepartamento(id));
        } catch (Exception e) {
            System.out.println("Erro nos dados.");
        }
    }
}
