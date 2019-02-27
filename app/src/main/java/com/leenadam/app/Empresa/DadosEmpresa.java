package com.leenadam.app.Empresa;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class DadosEmpresa {


    private String nomeEmpresa;
    private String idAneelAgente;

    private String nomeRepresentante;
    private String emailRepresentante;
    private String telefoneRepresentante;

    private String reponsavelTecnico;
    private String emailReponsavelTecnico;
    private String emailResponsavelTecnico;
    private String telefoneResponsavelTecnico;

    private String enderecoEmpresa;
    private String municipio;
    private String estado;
    private String codPostal;

    private @ServerTimestamp Date dataCriacao;

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getIdAneelAgente() {
        return idAneelAgente;
    }

    public void setIdAneelAgente(String idAneelAgente) {
        this.idAneelAgente = idAneelAgente;
    }

    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }

    public String getEmailRepresentante() {
        return emailRepresentante;
    }

    public void setEmailRepresentante(String emailRepresentante) {
        this.emailRepresentante = emailRepresentante;
    }

    public String getTelefoneRepresentante() {
        return telefoneRepresentante;
    }

    public void setTelefoneRepresentante(String telefoneRepresentante) {
        this.telefoneRepresentante = telefoneRepresentante;
    }

    public String getReponsavelTecnico() {
        return reponsavelTecnico;
    }

    public void setReponsavelTecnico(String reponsavelTecnico) {
        this.reponsavelTecnico = reponsavelTecnico;
    }

    public String getEmailReponsavelTecnico() {
        return emailReponsavelTecnico;
    }

    public void setEmailReponsavelTecnico(String emailReponsavelTecnico) {
        this.emailReponsavelTecnico = emailReponsavelTecnico;
    }

    public String getEmailResponsavelTecnico() {
        return emailResponsavelTecnico;
    }

    public void setEmailResponsavelTecnico(String emailResponsavelTecnico) {
        this.emailResponsavelTecnico = emailResponsavelTecnico;
    }

    public String getTelefoneResponsavelTecnico() {
        return telefoneResponsavelTecnico;
    }

    public void setTelefoneResponsavelTecnico(String telefoneResponsavelTecnico) {
        this.telefoneResponsavelTecnico = telefoneResponsavelTecnico;
    }

    public String getEnderecoEmpresa() {
        return enderecoEmpresa;
    }

    public void setEnderecoEmpresa(String enderecoEmpresa) {
        this.enderecoEmpresa = enderecoEmpresa;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }
}
