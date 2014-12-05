/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.DAO;

import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Usuario
 */
public class DaoCriteria {

    private Session session;
    private Criteria criteria;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public DaoCriteria(Session session, Criteria criteria) {
        this.session = session;
        this.criteria = criteria;
    }
}
