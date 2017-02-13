package com.bracongo.pointdevente.service.impl;

import com.bracongo.pointdevente.dao.IPdvDao;
import com.bracongo.pointdevente.entities.PointDeVente;
import com.bracongo.pointdevente.service.IPdvService;
import com.bracongo.pointdevente.service.ServiceException;
import com.bracongo.pointdevente.service.util.ImportationError;
import com.bracongo.pointdevente.service.util.ImportationResult;
import com.royken.generic.dao.DataAccessException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Stateless
public class PdvServiceImpl implements IPdvService {

    @Inject
    private IPdvDao pdvDao;

    @Override
    public void createOrUpdatePdv(PointDeVente pointDeVente) throws ServiceException {
        try {
            if (pointDeVente.getId() == null) {
                System.out.println("JE CREEEEEEEE");
                pdvDao.create(pointDeVente);
            } else {
                pdvDao.update(pointDeVente);
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(PdvServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public PointDeVente findById(Long id) throws ServiceException {
        try {
            return pdvDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(PdvServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<PointDeVente> findAllPdv() throws ServiceException {
        try {
            return pdvDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(PdvServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<PointDeVente> findByCriteria() throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ImportationResult importPdv(InputStream stream) throws ServiceException {
        ImportationResult result = new ImportationResult();
        List<ImportationError> erreurs = new ArrayList<>();
        int count = 0;
        try {
            Workbook workbook = WorkbookFactory.create(stream);
            final Sheet sheet = workbook.getSheetAt(0);
            int index = 0;
            Row row = sheet.getRow(index++);
            //String compte;
            String nom;
            double longitude;
            double latitude;
            String adresse;
            String quartier;
            String proprio;
            int rank;
            String tel;
            while (row != null) {
                PointDeVente pdv = new PointDeVente();
                if (row.getCell(0) != null) {
                    row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                    proprio = row.getCell(0).getStringCellValue();
                    pdv.setProprio(proprio);
                }
                if (row.getCell(1) != null) {
                    row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                    nom = row.getCell(1).getStringCellValue();
                    pdv.setNom(nom);
                }
                if (row.getCell(2) != null) {
                    row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                    adresse = row.getCell(2).getStringCellValue();
                    pdv.setAdresse(adresse);
                }
                if (row.getCell(3) != null) {
                    row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                    quartier = row.getCell(3).getStringCellValue();
                    pdv.setQuartier(quartier);
                }
                if (row.getCell(4) != null) {
                    row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                    tel = row.getCell(4).getStringCellValue();
                    pdv.setTel(tel);
                }
                if (row.getCell(5) != null) {
                    if (row.getCell(5).getCellType() == Cell.CELL_TYPE_NUMERIC) {
                        latitude = row.getCell(5).getNumericCellValue();
                        pdv.setLatitude(latitude);
                    }
                }
                if (row.getCell(6) != null) {
                    if (row.getCell(6).getCellType() == Cell.CELL_TYPE_NUMERIC) {
                        longitude = row.getCell(6).getNumericCellValue();
                        pdv.setLongitude(longitude);
                    }
                }
                if (row.getCell(7) != null) {
                    if (row.getCell(7).getCellType() == Cell.CELL_TYPE_NUMERIC) {
                        rank = (int) row.getCell(7).getNumericCellValue();
                        pdv.setRate(rank);
                    }
                }
                System.out.println(pdv);
                pdvDao.create(pdv);
                row = sheet.getRow(index++);
            }

        } catch (IOException | InvalidFormatException | EncryptedDocumentException | DataAccessException ex) {
            Logger.getLogger(PdvServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
