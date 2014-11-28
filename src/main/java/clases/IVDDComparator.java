/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import modelos.InventarioDiarioDetalle;
import java.util.Comparator;

/**
 *
 * @author Usuario
 */
public class IVDDComparator implements Comparator<InventarioDiarioDetalle> {

    @Override
    public int compare(InventarioDiarioDetalle m1, InventarioDiarioDetalle m2) {
        //possibly check for nulls to avoid NullPointerException
        return m1.getFecha().compareTo(m2.getFecha());
    }
}
