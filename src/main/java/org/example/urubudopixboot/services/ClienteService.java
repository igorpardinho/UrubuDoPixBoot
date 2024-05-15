package org.example.urubudopixboot.services;

import org.example.urubudopixboot.orm.Cliente;
import org.example.urubudopixboot.repository.ClienteRepository;
import org.springframework.boot.ssl.DefaultSslBundleRegistry;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class ClienteService {

    private final DefaultSslBundleRegistry sslBundleRegistry;
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository, DefaultSslBundleRegistry sslBundleRegistry) {
        this.clienteRepository = clienteRepository;
        this.sslBundleRegistry = sslBundleRegistry;
    }

    public void menu() {
        boolean isTrue = true;

        while (isTrue) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite 1 - para cadastrar um cliente");
            System.out.println("Digite 2 - para listar os clientes");
            System.out.println("Digite 3 - para deletar um cliente");
            System.out.println("Digite 4 - para depositar na conta do cliente");
            System.out.println("Digite 5 - para sacar na conta do cliente");
            System.out.println("Digite 0 - para voltar ao menu");
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    deletarCliente();
                    break;
                case 4:
                    depositarValorNaConta();
                case 5:
                    sacarValorNaConta();
                    break;
                default:
                    isTrue = false;
                    break;
            }

        }


    }

    private void listarClientes() {
        Iterable<Cliente> clientes = clienteRepository.findAll();
        if (clientes.iterator().hasNext()) {
            clientes.forEach(System.out::println);
        } else {
            System.out.println("Nenhum cliente encontrado!");
        }
    }

    private void cadastrarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do Cliente");
        String nome = sc.nextLine();
        clienteRepository.save(new Cliente(nome));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void deletarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o Id do cliente que deseja deletar");
        Long id = sc.nextLong();
        clienteRepository.deleteById(id);
        System.out.println("Cliente deletado com sucesso!");
    }

    private void depositarValorNaConta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o valor que deseja depositar na conta");
        Double valor = sc.nextDouble();
        System.out.println("Digite o id do cliente que deseja depositar");
        Long id = sc.nextLong();
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            cliente.setSaldo(valor);
        } else {
            System.out.println("cliente nao encontrado!");
        }
    }

    private void sacarValorNaConta() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o valor que deseja sacar da conta");
        Double valor = sc.nextDouble();

        System.out.println("Digite o id do cliente que deseja sacar");
        Long id = sc.nextLong();

        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isPresent() && optionalCliente.get().getSaldo() >= valor) {
            Cliente cliente = optionalCliente.get();
            cliente.setSaldo(valor - cliente.getSaldo());
            System.out.println("Valor sacado com sucesso!");
        } else {
            System.out.println("Valor insuficiente ou cliente nao encontrado!");
        }

    }

}
