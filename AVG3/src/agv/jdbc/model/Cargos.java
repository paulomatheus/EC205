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
public enum Cargos {
    COORDENADOR("Coordenador"),
    ASSESSOR("Assessor");

    private final String nomeCargo;

    private Cargos(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

}
