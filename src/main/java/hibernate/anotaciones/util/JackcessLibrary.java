/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.anotaciones.util;

/**
 *
 * @author Usuario
 */
import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author sarath_ivan
 */
public class JackcessLibrary {

    private static Database createDatabase(String databaseName) throws IOException {
        return DatabaseBuilder.create(Database.FileFormat.V2000, new File(databaseName));
    }

    private static TableBuilder createTable(String tableName) {
        return new TableBuilder(tableName);
    }

    public static void addColumn(Database database, TableBuilder tableName, String columnName, Types sqlType) throws SQLException, IOException {
        tableName.addColumn(new ColumnBuilder(columnName).setSQLType(Types.INTEGER).toColumn()).toTable(database);
    }

    public void startDatabaseProcess() throws IOException, SQLException {
        System.out.println("prueba 1");
        String databaseName = getClass().getResource("/pgk_prueba/p1.mdb").getPath(); // Creating an MS Access database
        Database database = createDatabase(databaseName);

        String tableName = "Employee"; // Creating table
        Table table = createTable(tableName)
                .addColumn(new ColumnBuilder("Emp_Id").setSQLType(Types.INTEGER).toColumn())
                .addColumn(new ColumnBuilder("Emp_Name").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("Emp_Employer").setSQLType(Types.VARCHAR).toColumn())
                .toTable(database);

        table.addRow(122875, "Sarath Kumar Sivan", "Infosys Limited.");//Inserting values into the table
    }

    public static void main(String[] args) throws IOException, SQLException {
        new JackcessLibrary().startDatabaseProcess();
    }
}
