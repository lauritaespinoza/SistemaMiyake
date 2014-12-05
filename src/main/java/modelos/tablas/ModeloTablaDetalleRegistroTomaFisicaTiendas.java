package modelos.tablas;

import util.almacen.DetalleRegistro;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaDetalleRegistroTomaFisicaTiendas extends AbstractTableModel {

    private DetalleRegistro detalleRegistro;
    private List<DetalleRegistro> listaDetalleResgistro;
    DetalleRegistro prodSDmt;

    public DetalleRegistro getDetalleRegistro() {
        return detalleRegistro;
    }

    public DetalleRegistro getProdSDmt() {
        return prodSDmt;
    }

    public void setProdSDmt(DetalleRegistro prodSDmt) {
        this.prodSDmt = prodSDmt;
    }

//    public void setValueAt(Integer aValue, int rowIndex, int columnIndex) {
//       
//        prodSDmt = this.listaDetalleResgistro.get(rowIndex);
//        
//            switch (columnIndex) {  
//                case 2:  
////                    if (aValue instanceof Integer) {  
//                        //  
//                       prodSDmt.setCantidad(aValue);
////                    }  
//                    break;  
//                case 3:  
////                    if (aValue instanceof Integer) {  
//                        //  
//                      prodSDmt.setBulto(aValue);
////                    }  
//                    break;  
//            }  
//            fireTableCellUpdated(rowIndex, columnIndex);  
//    }
    public void setDetalleRegistro(DetalleRegistro detalleRegistro) {
        this.detalleRegistro = detalleRegistro;
    }

    public List<DetalleRegistro> getListaDetalleResgistro() {
        return listaDetalleResgistro;
    }

    public void setListaDetalleResgistro(List<DetalleRegistro> listaDetalleResgistro) {
        this.listaDetalleResgistro = listaDetalleResgistro;
    }

//    @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        switch (columnIndex) {
//            case 2://penultima
//                return true;
//            case 3://ultima
//                return true;
//            default:
//                return false;
//        }
//    }
    @Override
    public int getRowCount() {
        int filas = 0;
        if (this.listaDetalleResgistro != null) {
            filas = this.listaDetalleResgistro.size();
        }
        return filas;
    }

    @Override
    public String getColumnName(int col) {
        String nombreColumna = null;
        switch (col) {
            case 0:
                nombreColumna = "Renglon";
                break;
            case 1:
                nombreColumna = "Codigo";
                break;
            case 2:
                nombreColumna = "Referencia";
                break;
            case 3:
                nombreColumna = "Descripcion";
                break;
            case 4:
                nombreColumna = "Cantidad";
                break;
            case 5:
                nombreColumna = "Nro Bulto";
                break;

        }
        return nombreColumna;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Object valor = "";
        try {
            prodSDmt = this.listaDetalleResgistro.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    valor = prodSDmt.getSd().getNroRenglon();
                    break;
                case 1:
                    valor = prodSDmt.getSd().getProducto().getIdProducto();

                    break;
                case 2:
                    valor = prodSDmt.getSd().getProducto().getReferenciaProducto();

                    break;
                case 3:
                    valor = prodSDmt.getSd().getProducto().getDescripcion();

                    break;
                case 4:
                    valor = prodSDmt.getCantidad();

                    break;
                case 5:
                    valor = prodSDmt.getSd().getNroBulto();

            }

        } catch (Exception e) {
            System.err.println("ERROR Asignando Valores en Tabla : " + e);
            Logger.getLogger(ModeloTablaDetalleRegistroTomaFisicaTiendas.class.getName()).log(Level.SEVERE, null, e);
        }

        if ("" == valor) {
            valor = 0;
        }

        return valor;
    }
}
