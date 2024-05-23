package org.example.urubudopixboot.services;

import jakarta.transaction.Transactional;
import org.example.urubudopixboot.orm.Banco;
import org.example.urubudopixboot.repository.BancoRepository;
import org.example.urubudopixboot.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.Scanner;

@Transactional
@Service
public class BancoService {


    private ClienteRepository clienteRepository;
    private BancoRepository bancoRepository;

    public BancoService(ClienteRepository clienteRepository, BancoRepository bancoRepository) {
        this.clienteRepository = clienteRepository;
        this.bancoRepository = bancoRepository;
    }

    public void menu() {
        boolean isTrue = true;

        while (isTrue) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite 1 - para cadastrar um banco");
            System.out.println("Digite 2 - para listar os bancos");
            System.out.println("Digite 3 - para deletar um banco");
            System.out.println("Digite 0 - para voltar ao menu");
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarBanco();
                    break;
                case 2:
                    listarBancos();
                    break;
                case 3:
                    deletarBanco();
                    break;
                default:
                    isTrue = false;
                    break;
            }

        }


    }

    private void listarBancos() {
        Iterable<Banco> bancos = bancoRepository.findAll();
        if (bancos.iterator().hasNext()) {
            bancos.forEach(System.out::println);
        } else {
            System.out.println("Nenhum banco encontrado!");
        }
    }

    private void cadastrarBanco() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do Banco");
        Banco banco = new Banco();
        String nome = sc.nextLine();
        banco.setName(nome);
        bancoRepository.save(banco);
        System.out.println("Banco cadastrado com sucesso!");
    }

    private void deletarBanco() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o Id do banco que deseja deletar");
        Long id = sc.nextLong();
        bancoRepository.deleteById(id);
        System.out.println("Banco deletado com sucesso!");
    }


}
