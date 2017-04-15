package models;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Serhii Khaliavin
 */
public class BoxModel<T> extends AbstractListModel<T> implements ComboBoxModel<T> {
    
    private ArrayList<T> list;
    private T selectedItem;

    public BoxModel(ArrayList<T> list) {
        this.list = list;
    }
  
 
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public T getElementAt(int i) {
        return list.get(i);
    }

    @Override
    public void setSelectedItem(Object o) {
        selectedItem = (T)o;
    }

    @Override
    public T getSelectedItem() {
        return selectedItem;
    }
  
}

