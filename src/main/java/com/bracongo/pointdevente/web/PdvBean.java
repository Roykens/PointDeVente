package com.bracongo.pointdevente.web;

import com.bracongo.pointdevente.entities.PointDeVente;
import com.bracongo.pointdevente.service.IPdvService;
import com.bracongo.pointdevente.service.ServiceException;
import com.bracongo.pointdevente.service.util.ImportationResult;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Named(value = "pdvBean")
@SessionScoped
public class PdvBean implements Serializable {

    @EJB
    private IPdvService pdvService;

    private String code;

    private String brand;

    private String circuit;

    private String zozo;

    private static final long serialVersionUID = 1L;
    
    private UploadedFile file;

    /**
     * Creates a new instance of PdvBean
     */
    public PdvBean() {
        
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    

    public IPdvService getPdvService() {
        return pdvService;
    }

    public void setPdvService(IPdvService pdvService) {
        this.pdvService = pdvService;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCircuit() {
        return circuit;
    }

    public void setCircuit(String circuit) {
        this.circuit = circuit;
    }

    public String getZozo() {
        return zozo;
    }

    public void setZozo(String zozo) {
        this.zozo = zozo;
    }

    public void change() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        zozo = sb.toString();
        System.out.println(zozo);
        PointDeVente pdv = new PointDeVente();
        pdv.setAdresse("AVE, NZELUDIA, 213");
        pdv.setCode(code);
        pdv.setLatitude(-4.42538118);
        pdv.setLongitude(15.40545177);
        pdv.setNom("GERTRIDE");
        pdv.setProprio("NGOYI GINA");
        pdv.setQuartier("MUKOKA");
        pdv.setRate(5);
        pdv.setTel("243897575092");
        try {
            pdvService.createOrUpdatePdv(pdv);
        } catch (ServiceException ex) {
            Logger.getLogger(PdvBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public ImportationResult importer() throws IOException, ServiceException {
        try {
            //  noteService.importNotes(file.getInputstream(),idC,idE, idAca,session.ordinal());
            System.out.println("Le circuit");
            //System.out.println(idCircuit);
           // importationResult = new ImportationResult();
              pdvService.importPdv(file.getInputstream());
            //System.out.println(importationResult);
            return null;
        } catch (ServiceException ex) {
            Logger.getLogger(PdvBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
