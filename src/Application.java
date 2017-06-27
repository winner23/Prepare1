import Controlers.InitController;
import Models.FileAccessModel;
import Models.DataSet;
import Views.ViewData;

import javax.swing.*;

/**
 * Created by winner on 16.06.2017.
 */
public class Application {
    public static void main(String ... args) {

        SwingUtilities.invokeLater(() -> {
            runApp();
        });

    }

    public  static void runApp() {
        String [] headers = {"id.s","name.s","lastName.s","age.i"};

        FileAccessModel fileAccessModel = new FileAccessModel("contacts.csv");

        DataSet dataSet = new DataSet(headers);

        ViewData viewData = new ViewData(dataSet);

        InitController initController = new InitController(fileAccessModel, viewData);

    }

}
