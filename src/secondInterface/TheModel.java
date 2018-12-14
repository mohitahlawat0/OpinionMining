
package secondInterface;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

public class TheModel extends AbstractTableModel{
    private String[] columns;
    private Object[][] rows;
    public TheModel(){}
    public TheModel(Object[][] data,String [] columnname){
        this.columns=columnname;
        this.rows=data;
    }
    @Override
    public int getRowCount() {
        return this.rows.length;
    }
    @Override
    public Class getColumnClass(int col){
        if(col==4)
            return Icon.class;
        else
            return getValueAt(0, col).getClass();
    }
    
    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.rows[rowIndex][columnIndex];
    }
    @Override
    public String getColumnName(int col){
        return this.columns[col];
    }
}
