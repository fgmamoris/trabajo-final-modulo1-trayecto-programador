/*
 * 
 */
package com.fullstackjava.trabajofinalseguroautomotor.model;

import java.util.ArrayList;

/**
 *
 * @author Federico Mamoris
 */
public class Vehiculo {

    String marca;
    String modelo;
    String dominio;
    int anio;
    String tipoCobertura;
    ArrayList<String> adicionales;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, String dominio, int anio, String tipoCobertura, ArrayList<String> adicionales) {
        this.marca = marca;
        this.modelo = modelo;
        this.dominio = dominio;
        this.anio = anio;
        this.tipoCobertura = tipoCobertura;
        this.adicionales = adicionales;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTipoCobertura() {
        return tipoCobertura;
    }

    public void setTipoCobertura(String tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }

    public ArrayList<String> getAdicionales() {
        return adicionales;
    }

    public void setAdicionales(ArrayList<String> adicionales) {
        this.adicionales = adicionales;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", dominio=" + dominio + ", año=" + anio + ", tipoCobertura=" + tipoCobertura + ", adicionales=" + adicionales + '}';
    }

}
