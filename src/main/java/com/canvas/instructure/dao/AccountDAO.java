package com.canvas.instructure.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.canvas.instructure.entity.Account;

@Repository
public class AccountDAO {
    
    @Autowired
    SessionFactory factory;

    private static final Logger logger = LoggerFactory.getLogger(AccountDAO.class);

    @Transactional
    public void saveAccounts(List<Account> accounts){
        Session session = factory.openSession();
        try {
            String hql = "FROM Account acc WHERE acc.accountID = :columnValue";
            for(Account account: accounts){
                logger.debug("Inside saveAccounts - DAO - Fectching the saved Account object");
                Account acc = session.createQuery(hql, Account.class)
                        .setParameter("columnValue", account.getAccountID())
                        .uniqueResult();
                if(acc == null){
                    logger.debug("Creating a new Account object");
                    session.save(account);
                    logger.info("Account having account_id: "+account.getAccountID()+"has been saved");
                }else{
                    if(acc.updateAccount(account)){
                        logger.debug("Updating the Account object with new values");
                        session.update(acc);
                        logger.info("Account having account_id: "+account.getAccountID()+"has been updated");
                    }
                }
            }
		} catch (DataAccessException ex) {
            logger.error("Saving/Updating Account ", ex.getMessage());
		}
    }

}
