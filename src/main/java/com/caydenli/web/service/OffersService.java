package com.caydenli.web.service;

import com.caydenli.web.dao.OffersDAO;
import com.caydenli.web.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("offersService")
public class OffersService {

    private OffersDAO offersDao;

    @Autowired
    public void setOffersDao(OffersDAO offersDao) {
        this.offersDao = offersDao;
    }

    public List<Offer> getCurrent(){
        return offersDao.getOffers();
    }
}
