package models.sistema;

import models.encomendas.IEncomendas;

import java.time.LocalDateTime;

public interface IPedidosTransportadores {

    /**
     * Devolve codigo do Pedido
     *
     * @return codigo Pedido
     */
    String getCodigoPedido();

    /**
     * Devolve utilizador que fez Pedido
     *
     * @return utilizador
     */
    String getUtilizador();

    /**
     * Devolve loja que tratou o pedido
     *
     * @return loja
     */
    String getLoja();

    /**
     * Devolve nome da Transportadora
     *
     * @return nome Transportadora
     */
    String getNome();

    /**
     * Devolve codigo do Transportador que transporta pedido
     *
     * @return codigo Transportadora
     */
    String getCodigoTransportador();

    /**
     * Devolve preco associado ao transporte pedido
     *
     * @return preco Transporte sugerido
     */
    double getPreco();

    /**
     * Devolve Kms percorridos pela Transportadora
     *
     * @return valor correspondente ao numero Kms
     */
    double getKMPercorridos();

    /**
     * Devolve encomenda associada ao Pedido
     *
     * @return encomenda associada ao Pedido Transportadora
     */
    IEncomendas getEncomenda();

    /**
     * Devolve data de aceitacao do Pedido
     *
     * @return data de aceitacao
     */
    LocalDateTime getDataAceite();

    int hashCode();


    /**
     * Permite apresentar no ecra as informacoes necessarias
     *
     * @return String com informacao da Classe
     */
    String toString();

    /**
     * Permite apresentar no ecra as informacoes necessarias a uma loja
     *
     * @return String com informacao da Classe a apresentar a uma loja
     */
    String toStringLoja();

}

