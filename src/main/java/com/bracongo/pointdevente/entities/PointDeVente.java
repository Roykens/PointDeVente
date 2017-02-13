package com.bracongo.pointdevente.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Entity
@XmlRootElement(name="pointDeVente")
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "pointdevente")
public class PointDeVente implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "ID")
    private Long id;
    
    @Column(unique = true,name = "CODE")
    private String code;
    
    @Column(name = "NOM")
    private String nom;
    
    @Column(name = "BRAND")
    private String brand;
    
    @Column(name = "LATITUDE")
    private Double latitude;
    
    @Column(name = "LONGITUDE")
    private Double longitude;
    
    @Column(name = "CIRCUIT")
    private String circuit;
    
    @Column(name = "PROPRIO")
    private String proprio;
    
    @Column(name = "RATE")
    private int rate;
    
    @Column(name = "ADRESSE")
    private String adresse;
    
    @Column(name = "QUARTIER")
    private String quartier;
    
    @Column(name = "TEL")
    private String tel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getCircuit() {
        return circuit;
    }

    public void setCircuit(String circuit) {
        this.circuit = circuit;
    }

    public String getProprio() {
        return proprio;
    }

    public void setProprio(String proprio) {
        this.proprio = proprio;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "PointDeVente{" + "id=" + id + ", nom=" + nom + ", latitude=" + latitude + ", longitude=" + longitude + ", circuit=" + circuit + ", proprio=" + proprio + ", rate=" + rate + ", adresse=" + adresse + ", quartier=" + quartier + ", tel=" + tel + '}';
    }
    
}
