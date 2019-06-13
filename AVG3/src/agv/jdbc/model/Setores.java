/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agv.jdbc.model;

/**
 *
 * @author barab
 */
public enum Setores {
    EVENTOS("Eventos"),
    DOCUMENTOS("Documentos");

    private final String nomeSetor;

    private Setores(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

}
