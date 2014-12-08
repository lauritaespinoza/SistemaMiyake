package modelos.tablas;

import util.almacen.DetalleRegistro;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaDetalleRegistroAsignacion extends AbstractTableModel {

    private DetalleRegistro detalleRegistro;
    private List<DetalleRegistro> listaDetalleResgistro;

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

        DetalleRegistro prod;
        Object valor = "";
        try {
            prod = this.listaDetalleResgistro.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    valor = prod.getRenglon();

                    break;
                case 1:
                    valor = prod.inv.getProducto().getIdProducto();

                    break;
                case 2:
                    valor = prod.inv.getProducto().getReferenciaProducto();

                    break;
                case 3:
                    valor = prod.inv.getProducto().getDescripcion();

                    break;
                case 4:
                    valor = prod.getCantidad();

                    break;
                case 5:
                    valor = prod.getBulto();

            }

        } catch (Exception e) {
            System.err.println("ERROR Asignando Valores en Tabla : " + e);
            Logger.getLogger(ModeloTablaDetalleRegistroAsignacion.class.getName()).log(Level.SEVERE, null, e);
        }

        if ("" == valor) {
            valor = 0;
        }

        return valor;
    }
}
