/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.tablas;

import java.util.HashMap;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Usuario
 */
public class TableModelReport implements JRDataSource {

    private int counter = -2;//deberia ser -1 **
    private HashMap<String, Integer> fieldsNumber = new HashMap<>();
    private TableModel tableModel;

    public int getCounter() {
        return counter;
    }

    public TableModelReport(TableModel model) {
        this.tableModel = model;
        if (this.tableModel != null) {
            for (int i = 0; i < tableModel.getColumnCount(); i++) {
                this.fieldsNumber.put(tableModel.getColumnName(i), Integer.valueOf(i));
            }
        }
    }

    @Override
    public boolean next() throws JRException {
        if (counter < tableModel.getRowCount() - 1) {
            counter++;
            return true;
        }
        return false;
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        String fieldName = jrField.getName();

        Integer columnIndex = this.fieldsNumber.get(fieldName);

        if (columnIndex != null) {
            return this.tableModel.getValueAt(counter, columnIndex.intValue());
        } else {
            throw new JRException("Unknown column name!!!* : " + fieldName);
        }
    }

    public void moveFirst() {
        this.counter = -1;
    }

}
