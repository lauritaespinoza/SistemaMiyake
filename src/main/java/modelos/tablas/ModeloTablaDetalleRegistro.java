package modelos.tablas;

import util.almacen.DetalleRegistro;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaDetalleRegistro extends AbstractTableModel {

    private DetalleRegistro detalleRegistro;
    private List<DetalleRegistro> listaDetalleResgistro;

    private DetalleRegistro prod;

    public DetalleRegistro getProd() {
        return prod;
    }

    public void setProd(DetalleRegistro prod) {
        this.prod = prod;
    }

    public DetalleRegistro getDetalleRegistro() {
        return detalleRegistro;
    }

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

        prod = this.listaDetalleResgistro.get(rowIndex);
        switch (columnIndex) {
            case 0:
                valor = prod.getRenglon();
                break;
            case 1:
                valor = prod.getEp().getIdProducto().getIdProducto();
                // valor = ep.getReferenciaProducto();
                break;
            case 2:
                valor = prod.getEp().getIdProducto().getReferenciaProducto();
                // valor = ep.getReferenciaProducto();
                break;
            case 3:
                valor = prod.getEp().getIdProducto().getDescripcion();
                // valor = ep.getDescripcionProducto();
                break;
            case 4:
                valor = prod.getCantidad();
                // valor = ep.getCantidadProducto();
                break;
            case 5:
                valor = prod.getBulto();
            // valor = ep.getNroBulto();
            }

        return valor;
    }

//       public void setValueAt(Integer aValue, int rowIndex, int columnIndex) {
//       
//        prod = this.listaDetalleResgistro.get(rowIndex);
//        
//            switch (columnIndex) {  
//                case 2:  
////                    if (aValue instanceof Integer) {  
////                        //  
//                       prod.setCantidad(aValue);
////                    }  
//                    break;  
//                case 3:  
////                    if (aValue instanceof Integer) {  
////                        //  
//                      prod.setBulto(aValue);
////                    }  
//                    break;  
//            }  
//            fireTableCellUpdated(rowIndex, columnIndex);  
//    }
}
