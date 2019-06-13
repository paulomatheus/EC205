/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agv.jdbc.control;

import agv.exceptions.ErroCadastroException;
import agv.jdbc.dao.ViagemDao;
import agv.jdbc.model.Viagem;
import java.util.ArrayList;

/**
 * Classe que manipula cadastros de viagens usando a classe ViagemDao.
 * @author Bruno Almeida Rabelo
 */
public class ManipuladorViagens {

    private final ViagemDao viagemDao = new ViagemDao();
    private ArrayList<Viagem> listaViagens;

    public ManipuladorViagens() {
        listaViagens = viagemDao.getLista();
    }

    /**
     * Usa a classe ViagemDao para obter uma lista com todos as 
     * viagens cadastradas no sistema.
     * @return Retorna uma ArrayList com todas as viagens cadastradas no
     * sistema ou null, se não houver nenhuma.
     */
    public ArrayList<Viagem> getListaViagens() {
        listaViagens = viagemDao.getLista();
        if (listaViagens.isEmpty()) {
            return null;
        } else {
            return listaViagens;
        }
    }

    /**
     * Cadastra uma viagem no sistema usando a classe ViagemDao.
     * @param viagem
     * @throws ErroCadastroException Retorna esta exceção se já houver uma
     * viagem com o mesmo nome no sistema.
     */
    public void cadastra(Viagem viagem) throws ErroCadastroException {
        listaViagens = viagemDao.getLista();
        for (Viagem viagemNaLista : listaViagens) {
            if (viagemNaLista.getNome().equals(viagem.getNome())) {
                throw new ErroCadastroException("Já existe um viagem com o "
                        + "mesmo nome cadastrada no sistema.");
            }
        }
        viagemDao.adiciona(viagem);
    }

    /**
     * Altera o cadastro de uma viagem usando a classe ViagemDao.
     * @param viagem
     * @throws ErroCadastroException Lança esta exceção, se as alterações 
     * implicarem na existência de duas viagens com o mesmo nome no sistema.
     */
    public void edita(Viagem viagem) throws ErroCadastroException {
        listaViagens = viagemDao.getLista();
        if (listaViagens.isEmpty()) {
            throw new ErroCadastroException("Não há viagens cadastradas no "
                    + "sistema.");
        } else {
            for (Viagem viagemNaLista : listaViagens) {
                if (viagemNaLista.getIdViagem() != viagem.getIdViagem()) {
                    if (viagemNaLista.getNome().equals(viagem.getNome())) {
                        throw new ErroCadastroException("Já existe um viagem "
                                + "com o mesmo nome cadastrada no sistema.");
                    }
                }
            }
            viagemDao.altera(viagem);
        }
    }

    /**
     * Remove uma viagem do sistema usando a classe ViagemDao. Ela não
     * @param viagem
     * @throws ErroCadastroException Lança esta excessão se não houverem 
     * viagens cadastradas no sistema.
     */
    public void remove(Viagem viagem) throws ErroCadastroException {
        listaViagens = viagemDao.getLista();
        boolean viagemExisteNaLista = false;
        if (listaViagens.isEmpty()) {
            throw new ErroCadastroException("Não há viagens cadastradas "
                    + "no sistema.");
        } else {
            for (Viagem viagemNaLista : listaViagens) {
                System.out.println("Viagem.getnome :" + viagem.getNome());
                System.out.println("++++"+ viagemNaLista.getNome());
                if (viagemNaLista.getNome().equals(viagem.getNome())) {
                    viagemDao.remove(viagem);
                    viagemExisteNaLista = true;
                }
            }
            if (!viagemExisteNaLista) {
                throw new ErroCadastroException("Esta viagem não está "
                        + "cadastrada no sistema.");
            }
        }
    }

    /**
     * Busca uma viagem pelo seu nome usando a classe ViagemDao.
     * @param nome
     * @return Retorna uma referência para uma Viagem ou null, se não a 
     * encontrar.
     */
    public Viagem buscaPorNome(String nome) {
        listaViagens = viagemDao.getLista();
        if (listaViagens.isEmpty()) {
            return null; // Lista vazia.
        } else {
            for (Viagem viagemNaLista : listaViagens) {
                if (viagemNaLista.getNome().equals(nome)) {
                    return viagemNaLista; // Encontrada.
                }
            }
            return null; // Não encontrada.
        }
    }
}
