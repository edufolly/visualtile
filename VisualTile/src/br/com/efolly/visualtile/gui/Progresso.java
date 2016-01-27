package br.com.efolly.visualtile.gui;

/**
 *
 * @author Eduardo Folly
 */
public interface Progresso {

    public void iniciar();

    public void setMaximo(int max);

    public void incrementar();

    public void finalizar();
}
