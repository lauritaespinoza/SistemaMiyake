package hibernate.anotaciones.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.annotations.Param;

public abstract class ObjectModelDAO {

//    private static Session sesion;//es posible hacer una lista?
   // private static List<Session> sesiones = new ArrayList<>();
//    private static Transaction tx;
//    private static Thread hilo;
//    public static String estado() {
//        return "tx: " + tx + "\nsesion: " + sesion;
//    }

//    public static List<Session> getSesiones() {
//       // return sesiones;
//    }

    //normalmente regresa un Integer, si es compuesta regresa el embedded
    public static Object saveObject(Object objModel) {

        Object id = -1;
        Session newSession = null;
        try {
            newSession = HibernateUtil.getSessionFactory().openSession();
            newSession.beginTransaction();

            id = newSession.save(objModel);

            newSession.getTransaction().commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex, newSession, newSession.getTransaction());
        } finally {
            terminate(newSession);
        }

        return id;
    }

    public static void updateObject(Object objModel) {
        Session newSession = null;
        try {
            newSession = HibernateUtil.getSessionFactory().openSession();
            newSession.beginTransaction();

            newSession.update(objModel);

            newSession.getTransaction().commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex, newSession, newSession.getTransaction());
        } finally {
            terminate(newSession);
        }
    }

    public static void deleteObject(Object objModel) {
        Session newSession = null;
        try {
            newSession = HibernateUtil.getSessionFactory().openSession();
            newSession.beginTransaction();

            newSession.delete(objModel);

            newSession.getTransaction().commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex, newSession, newSession.getTransaction());
        } finally {
            terminate(newSession);
        }
    }

    public static <T> T getObject(Serializable idObject, Class<T> type) {
        //hacer que se insancie el objeto de la clase de argumento ** 

        T objModel = null;
        Session newSession = null;
        try {
            newSession = HibernateUtil.getSessionFactory().openSession();
            newSession.beginTransaction();

            objModel = (T) newSession.get(type, idObject);

            newSession.getTransaction().commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex, newSession, newSession.getTransaction());
        } finally {
            terminate(newSession);
        }

        return objModel;
    }

    /**
     * El codigo {@code ObjectModelDAO} class represents character strings. All
     * string literals in Java programs, such as {@code "abc"}, are implemented
     * as instances of this class.
     * <p>
     * Strings are constant; their values cannot be changed after they are
     * created. String buffers support mutable strings. Because String objects
     * are immutable they can be shared. For example:
     * <blockquote><pre>
     *     String str = "abc";
     * </pre></blockquote><p>
     *
     * @param tarjet
     * @return Lista con los campos de consulta
     * @throws HibernateException
     * @see DirectorioPK
     */
    public static List<List> getResultQuery(Object tarjet) {
        if (tarjet == null) {
            return null;
        }

        List<List> listaObjectos = null;
        DaoQuery DaoQ = null;
        DaoCriteria DaoC = null;
        Session oldSession = null;

        try {
            if (tarjet instanceof String) {
                DaoQ = createQueryDAO((String) tarjet);
                listaObjectos = DaoQ == null ? null : DaoQ.getQuery().list();//ejemplo : "from Contacto"
                oldSession = DaoQ.getSession();
            }
            if (tarjet instanceof DaoQuery) {
                DaoQ = (DaoQuery) tarjet;
                listaObjectos = DaoQ.getQuery().list();
                oldSession = DaoQ.getSession();
            }
            if (tarjet instanceof DaoCriteria) {
                DaoC = (DaoCriteria) tarjet;
                listaObjectos = DaoC.getCriteria().list();
                oldSession = DaoC.getSession();
            }

            oldSession.getTransaction().commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex, oldSession, oldSession.getTransaction());
        } finally {
            terminate(oldSession);
        }

        return listaObjectos;
    }

    public static List<List> getResultQueryString(String SQL) {
        if (SQL == null) {
            return null;
        }

        List<List> listaObjectos = null;
        Session newSession = null;
        try {
            newSession = HibernateUtil.getSessionFactory().openSession();
            newSession.beginTransaction();

            listaObjectos = newSession.createSQLQuery(SQL).list();
            newSession.getTransaction().commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex, newSession, newSession.getTransaction());
        } finally {
            terminate(newSession);
        }

        return listaObjectos;
    }

    public static void executeQuery(String SQL) {
        Session newSession = null;
        try {
            newSession = HibernateUtil.getSessionFactory().openSession();
            newSession.beginTransaction();

            newSession.createQuery(SQL);
            newSession.getTransaction().commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex, newSession, newSession.getTransaction());
        } finally {
            terminate(newSession);
        }
    }

//    private static boolean needToCreate() {
//        return sesion == null || !sesion.isOpen();
//    }
//    private static void iniciaOperacion() {
//        try {
//            //System.out.println("\t\t\t\t save5 " + sesion);
//            // JOptionPane.showMessageDialog(null, HibernateUtil.getSessionFactory().getCurrentSession());
//            //if (HibernateUtil.getSessionFactory().getCurrentSession() == null || !HibernateUtil.getSessionFactory().getCurrentSession().isOpen()) {
//
//            if (needToCreate()) {
//                sesion = HibernateUtil.getSessionFactory().openSession();
//                tx = sesion.beginTransaction();
//            }
////            sesion = HibernateUtil.getSessionFactory().getCurrentSession();
//            // }
//            //System.out.println("\t\t\t\t save6 " + sesion);
//            //sesion = HibernateUtil.getSessionFactory().getCurrentSession();
//            //System.out.println("\t\t\t\t save7 " + sesion);
//
//            //System.out.println("\t\t\t\t save8 " + sesion);
//        } catch (HibernateException ex) {
//            manejaExcepcion(ex);
//        }
//    }
    public static DaoQuery createQueryDAO(String hql) {
        Session newSession = null;
        DaoQuery daoQ = null;
        try {
            newSession = HibernateUtil.getSessionFactory().openSession();
            newSession.beginTransaction();
//            if (!sesiones.add(newSession)) {
//                JOptionPane.showMessageDialog(null, "no se pudo agregar la session");
//            }

            daoQ = new DaoQuery(newSession, newSession.createQuery(hql));
        } catch (HibernateException ex) {
            manejaExcepcion(ex, newSession, newSession.getTransaction());
        }
        return daoQ;
    }

    public static DaoCriteria createCriteriaDAO(Class type) {
        Session newSession = null;
        DaoCriteria daoC = null;
        try {
            newSession = HibernateUtil.getSessionFactory().openSession();
            newSession.beginTransaction();

            daoC = new DaoCriteria(newSession, newSession.createCriteria(type));
        } catch (HibernateException ex) {
            manejaExcepcion(ex, newSession, newSession.getTransaction());
        }
        return daoC;
    }

    private static void manejaExcepcion(Exception he, Session sess, Transaction trans) throws HibernateException {

//        JOptionPane.showMessageDialog(null, "Estado: " + estado());
        if (trans != null && trans.isParticipating()) {
            trans.rollback();
            JOptionPane.showMessageDialog(null, "rollback " + he);
        }

        if (sess != null) {
            sess.close();
        }

        JOptionPane.showMessageDialog(null, he);
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos \n\t", he);
    }

    private static void terminate(Session session) {
        try {
            if (session != null || session.isOpen()) {
                session.close();
//                if (!sesiones.remove(session)) {
//                    JOptionPane.showMessageDialog(null, "no se pudo remover la session");
//                }
            }
        } catch (Exception e) {
            manejaExcepcion(e, session, session.getTransaction());
        }
    }

    public static Object getSesiones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
