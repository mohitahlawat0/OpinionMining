/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondInterface;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nick Hacker
 */
public class TheModel2 extends AbstractTableModel{
    private String[] columns;
    private Object[][] rows;
    public TheModel2(){}
    public TheModel2(Object[][] data,String [] columnname){
        this.columns=columnname;
        this.rows=data;
    }
    @Override
    public int getRowCount() {
        return this.rows.length;
    }
    @Override
    public Class getColumnClass(int col){
        if(col==3)
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
