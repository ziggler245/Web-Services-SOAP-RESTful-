package models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ws.Fight;

/**
 *
 * @author Serhii Khaliavin
 */
public class TableModels extends AbstractTableModel{
     public static final int COLUMN_COUNT =5;
private ArrayList<Fight> list;
      public TableModels(ArrayList<Fight> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
         return list.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Fight fight = list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return fight.getPpv();
            case 1:
                return fight.getCountry();
            case 2:
                return fight.getDuration();
            case 3:
                return fight.getDate();
            case 4:
                return fight.getFreePlace();
           
        }
        return "";
        
    }
    
    
     @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "PPV";
            case 1:
                return "Country";
            case 2:
                return "Duration";
            case 3:
                return "Date";
            case 4:
                return "Free Places";
         
        }

        return "";
    }
    
}
