package Views;

import Models.DataSet;

import javax.swing.*;

public class ViewData extends JFrame {
    private DataSet dataSet;

    public ViewData(DataSet dataSet) {
        super("Main Frame");
        this.dataSet = dataSet;
    }

}
