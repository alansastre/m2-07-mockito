package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.SmartPhoneDAO;
import com.example.demo.domain.SmartPhone;

/**
 * La capa servicio permite añadir lógica de negocio sobre las llamadas a la capa de datos
 */
public class SmartPhoneServiceImpl implements SmartPhoneService{

    SmartPhoneDAO smartphoneDAO; // dependencia
    // CalculatorService service; // dependencia
    
    public SmartPhoneServiceImpl(SmartPhoneDAO smartphoneDAO) {
		this.smartphoneDAO = smartphoneDAO;
	}

	@Override
    public Integer count() {
		this.smartphoneDAO.count();
        return this.smartphoneDAO.count();
    }

    @Override
    public List<SmartPhone> findAll() {
        return this.smartphoneDAO.findAll();
    }

    @Override
    public SmartPhone findOne(Long id) {
        return smartphoneDAO.findOne(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartphone) {
        return this.smartphoneDAO.save(smartphone);
    }

    @Override
    public boolean delete(Long id) {
    	return this.smartphoneDAO.delete(id);
    }

    @Override
    public void deleteAll() {
    	// logica extra
    	
    	// .. 
    	
    	this.smartphoneDAO.deleteAll();
    }

	@Override
	public List<SmartPhone> findByWifi(Boolean wifi) {
		return this.smartphoneDAO.findByWifi(wifi);
	}

}
