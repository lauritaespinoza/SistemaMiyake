/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.anotaciones;

import hibernate.anotaciones.modelo.Contacto;
import hibernate.anotaciones.util.HibernateUtil;
import hibernate.anotaciones.util.ObjectModelDAO;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Alex
 */
public class Main {

    public static void main(String[] args) {

        ObjectModelDAO contactosDAO = new ObjectModelDAO();
        /* Contacto contacto3 = new Contacto("Contacto 10!", "contacto3@contacto.com4", "45612378 4");
         contactosDAO.saveObject(contacto3);
         System.out.println("CREADO !");
         /* Contacto contactoRecuperado = null;
         long idAEliminar = 0;

         //Creamos tes instancias de Contacto 
         Contacto contacto1 = new Contacto("Contacto 1", "contacto1@contacto.com", "12345678");
         Contacto contacto2 = new Contacto("Contacto 2", "contacto2@contacto.com", "87654321");
         Contacto contacto3 = new Contacto("Contacto 3", "contacto3@contacto.com", "45612378");

         //Guardamos las tres instancias, guardamos el id del contacto1 para usarlo posteriormente 
         idAEliminar = contactosDAO.saveObject(contacto1);
         contactosDAO.saveObject(contacto2);
         contactosDAO.saveObject(contacto3);

         //Modificamos el contacto 2 y lo actualizamos 
         contacto2.setNombre("Nuevo Contacto 2");
         contactosDAO.updateObject(contacto2);

         //Recuperamos el contacto1 de la base de datos 
         contactoRecuperado = contactosDAO.getObject(idAEliminar);
         System.out.println("Recuperamos a " + contactoRecuperado.getNombre());

         //Eliminamos al contactoRecuperado (que es el contacto3) 
         contactosDAO.deleteObject(contactoRecuperado);
         */
        //Obtenemos la lista de contactos que quedan en la base de datos y la mostramos 
        List<List> listaContactos = contactosDAO.getResultQuery("select new list(c.correo,c.nombre) from Contacto c");
        System.out.println("Hay " + listaContactos.size() + " contactos en la base de datos");
        String str;
        for (List c : listaContactos) {
            // System.out.println("-> " + c.toString());
            str="";
            for (Object ob : c) {
                str+=ob.toString()+"\t";
            }
            System.out.println("-> " +str);
        }

        //Prep work
        /**
         * SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
         * Session session = sessionFactory.openSession();
         *
         * //Get All Employees Transaction tx = session.beginTransaction();
         * Query query = session.createQuery("from Contacto"); List<Contacto>
         * empList = query.list(); for(Contacto emp : empList){
         * System.out.println(emp.toString()); }
         */
        System.out.println("Listo!!");

        HibernateUtil.getSessionFactory().close();
    }
}
