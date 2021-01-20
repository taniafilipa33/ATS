package models.sistema;

import models.encomendas.IEncomendas;
import models.utilizador.GPS;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PedidoLoja implements Serializable {

    /**
     * Variaveis Instancia
     */
    private String codigoPedido;

    private PedidoUtilizador pedidoUtilizador;

    private boolean temMedicamentos;

    //LojaCriou
    private LocalDateTime dataAceitePelaLoja;
    private String loja;
    private GPS gpsLoja;
    private String estadoEsperaLoja;

    /**
     * Construtor Parametrizado de PedidoLoja
     * @param p PedidoUtilizador
     * @param dataAceitePelaLoja LocalDateTime
     * @param loja String
     * @param gpsLoja GPS
     * @param med boolean
     * @param espera String
     */
    public PedidoLoja(PedidoUtilizador p, LocalDateTime dataAceitePelaLoja, String loja, GPS gpsLoja, boolean med, String espera) {

        this.codigoPedido = p.getCodigoPedido();

        this.pedidoUtilizador = p.copyPedidoUtilizador(this.pedidoUtilizador);

        this.temMedicamentos = med;

        this.dataAceitePelaLoja = dataAceitePelaLoja;
        this.loja = loja;
        this.gpsLoja = gpsLoja;
        this.estadoEsperaLoja = espera;
    }

    /**
     * Construtor de c�pia de uma PedidoLoja
     * @param p PedidoLoja
     */
    public PedidoLoja(PedidoLoja p) {

        this.codigoPedido = p.getCodigoPedido();
        this.pedidoUtilizador = p.getPedidoUtilizador();
        this.temMedicamentos = p.isTemMedicamentos();
        this.dataAceitePelaLoja = p.getDataAceitePelaLoja();
        this.loja = p.getLoja();
        this.gpsLoja = p.getGpsLoja();
        this.estadoEsperaLoja = p.getEstadoEsperaLoja();
    }

    public PedidoLoja() {}

    public PedidoLoja copyPedidoLoja (PedidoLoja p) {
        PedidoLoja pe = new PedidoLoja();
        pe.setCodigoPedido(p.getCodigoPedido());
        pe.setPedidoUtilizador(p.getPedidoUtilizador());
        pe.setTemMedicamentos(p.isTemMedicamentos());
        pe.setDataAceitePelaLoja(p.getDataAceitePelaLoja());
        pe.setLoja(p.getLoja());
        pe.setGpsLoja(p.getGpsLoja());
        pe.setEstadoEsperaLoja(p.getEstadoEsperaLoja());
        return pe;
    }

    /**
     * Devove o Pedido do Utilizador
     *
     * @return PedidoUtilizador
     */
    public PedidoUtilizador getPedidoUtilizador() {
        return this.pedidoUtilizador.copyPedidoUtilizador(this.pedidoUtilizador);
    }

    /**
     * Definir novo Pedido Utilizador
     *
     * @param pedidoUtilizador correspodente ao novo Pedido Utilizador
     */
    public void setPedidoUtilizador(PedidoUtilizador pedidoUtilizador) {
        this.pedidoUtilizador = pedidoUtilizador.copyPedidoUtilizador(pedidoUtilizador);
    }

    /**
     * Verifica se tem medicamentos ou nao
     *
     * @return true caso tenha medicamentos
     */
    public boolean isTemMedicamentos() {
        return temMedicamentos;
    }

    /**
     * Definir novo estado de transportar ou nao medicamentos
     *
     * @param temMedicamentos correspondente ao novo estado
     */
    public void setTemMedicamentos(boolean temMedicamentos) {
        this.temMedicamentos = temMedicamentos;
    }

    /**
     * Devolve estado da Fila de Espera na loja
     *
     * @return String correspondente a esse estado
     */
    public String getEstadoEsperaLoja() {
        return estadoEsperaLoja;
    }

    /**
     * Definir novo estado da Fila de Espera na loja
     *
     * @param estadoEsperaLoja ao novo estado da Fila de Espera
     */
    public void setEstadoEsperaLoja(String estadoEsperaLoja) {
        this.estadoEsperaLoja = estadoEsperaLoja;
    }

    /**
     * Devolve codigo do Pedido da Loja
     *
     * @return codigo Pedido
     */
    public String getCodigoPedido() {
        return this.codigoPedido;
    }

    /**
     * Definir novo codigo de Pedido da Loja
     *
     * @param codigoPedido correspondente ao novo codigo pedido
     */
    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    /**
     * Devolve data em que o Pedido Loja foi criado
     *
     * @return data de criacao do pedido Loja
     */
    public LocalDateTime getDataCriacao() {
        return this.pedidoUtilizador.getDataCriacao();
    }

    /**
     * Devolve o Utilizador que fez o Pedido
     *
     * @return codigo do Utilizador que fez Pedido
     */
    public String getUtilizador() {
        return this.pedidoUtilizador.getUtilizador();
    }

    /**
     * Definir novo Utilizador que fez Pedido
     *
     * @param utilizador correspondente ao novo Utilizador
     */
    public void setUtilizador(String utilizador) {
        this.pedidoUtilizador.setUtilizador(utilizador);
    }

    /**
     * Devolve Localizacao do Utilizador que fez Pedido
     *
     * @return localizacao do Utilizador
     */
    public GPS getGpsUtilizador() {
        return this.pedidoUtilizador.getGpsUtilizador().copyGPS(this.pedidoUtilizador.getGpsUtilizador());
    }

    /**
     * Devolve a encomenda do Utilizador
     *
     * @return Encomenda associada ao Pedido
     */
    public IEncomendas getEncomenda() {
        return this.pedidoUtilizador.getEncomenda().copyEncomenda(this.pedidoUtilizador.getEncomenda());
    }

    /**
     * Definir nova encomenda associada ao Pedido
     *
     * @param e correspondente a nova Encomenda
     */
    public void setEncomenda(IEncomendas e) {
        this.pedidoUtilizador.setEncomenda(e.copyEncomenda(e));
    }

    /**
     * Devolve data de aceitacao do Pedido por parte da loja
     *
     * @return data de aceitacao loja
     */
    public LocalDateTime getDataAceitePelaLoja() {
        return this.dataAceitePelaLoja;
    }

    /**
     * Devolve nova data de aceitacao do Pedido
     *
     * @param dataAceitePelaLoja correspondente a nova data
     */
    public void setDataAceitePelaLoja(LocalDateTime dataAceitePelaLoja) {
        this.dataAceitePelaLoja = dataAceitePelaLoja;
    }

    /**
     * Devolve Loja associada ao Pedido
     *
     * @return string da loja
     */
    public String getLoja() {
        return this.loja;
    }

    /**
     * Definir nova loja associada ao Pedido
     *
     * @param loja correspondente a nova Loja
     */
    public void setLoja(String loja) {
        this.loja = loja;
    }

    /**
     * Devolve localizacao da Loja
     *
     * @return localizacao da Loja
     */
    public GPS getGpsLoja() {
        return this.gpsLoja.copyGPS(this.gpsLoja);
    }

    /**
     * Definir nova localizacao da loja
     *
     * @param gpsLoja correspondente a nova localizacao
     */
    public void setGpsLoja(GPS gpsLoja) {
        this.gpsLoja = gpsLoja.copyGPS(this.gpsLoja);
    }

    /**
     * Permite apresentar no ecra as informacoes necessarias
     *
     * @return String com informacao da Classe
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        IEncomendas e = this.pedidoUtilizador.getEncomenda();
        GPS utilizador = this.pedidoUtilizador.getGpsUtilizador();
        sb.append("Codigo : ").append(this.codigoPedido)
          .append("| Peso: ").append(e.getPeso()).append(" kg")
          .append("| Contem Medicamentos: ").append(this.temMedicamentos)
          .append("| Fila de espera: ").append(this.estadoEsperaLoja)
          .append("| Cordenadas Loja: (").append(this.gpsLoja.getX()).append(",").append(this.gpsLoja.getY()).append(")")
          .append("| Cordenadas Utilizador: (").append(utilizador.getX()).append(",").append(utilizador.getY()).append(")");

        return sb.toString();
    }

    /**
     * Verifica se 2 Objects sao iguais
     *
     * @return true se Object for igual ao PedidoLoja
     */
    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;

        PedidoLoja p = (PedidoLoja) o;

        return (this.codigoPedido.equals(p.getCodigoPedido()) &&
                this.pedidoUtilizador.equals(p.getPedidoUtilizador()) &&
                this.dataAceitePelaLoja.equals(p.getDataAceitePelaLoja()) &&
                this.temMedicamentos == p.isTemMedicamentos() &&
                this.loja.equals(p.getLoja()) &&
                this.gpsLoja.equals(p.getGpsLoja()) &&
                this.estadoEsperaLoja.equals(p.getEstadoEsperaLoja()));
    }
    public int hashCode(){
        return super.hashCode();
    }


}
