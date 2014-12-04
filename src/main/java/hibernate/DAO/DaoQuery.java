/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.DAO;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Usuario
 */
public class DaoQuery {

    private Session session;
    private Query query;

    public DaoQuery(Session session, Query query) {
        this.session = session;
        this.query = query;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

}
