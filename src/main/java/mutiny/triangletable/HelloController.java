package mutiny.triangletable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// import javax.swing.*;
// import javax.swing.table.TableModel;
// import javax.swing.JTable;

public class HelloController {

    @FXML
    ListView<Triangle> trList;
    @FXML
    private Button btnLoad;
    @FXML
    private TableView<Triangle> table;
    @FXML
    private TextField fname;
 @FXML
    void loadFile(){
        String filename = fname.getText();
        try{
            List<String> lines = Files.readAllLines(Paths.get(filename));
            for (String s: lines ) {
                String[] words = s.split(" ");
                Triangle trgl = new Triangle(Integer.parseInt(words[0]), Integer.parseInt(words[1]), Integer.parseInt(words[2]));
                trgls.add(trgl);
            }

        }catch (IOException e)
        {}
    }
    ObservableList<Triangle> trgls = FXCollections.observableArrayList();
    public void initialize() throws IOException {
            initTable();
            countPerSq();
    }

    private void countPerSq() {

    }

    private void initTable() {
        table.setItems(trgls);
        table.getColumns().clear();
        table.setEditable(true);

        TableColumn<Triangle, Integer> columnSidea = new TableColumn<>("Сторона a");
        columnSidea.setCellValueFactory(new PropertyValueFactory<>("a"));
        columnSidea.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        TableColumn<Triangle, Integer> columnSideb = new TableColumn<>("Сторона b");
        columnSideb.setCellValueFactory(new PropertyValueFactory<>("b"));
        columnSideb.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        TableColumn<Triangle, Integer> columnSidec = new TableColumn<>("Сторона c");
        columnSidec.setCellValueFactory(new PropertyValueFactory<>("c"));
        columnSidec.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        table.getColumns().addAll(columnSidea, columnSideb, columnSidec);


     //   Object obj =  table.getColumns().get(1).getCellObservableValue(1).getValue();
    //    String s = obj.toString();
     //   System.out.println(s);

    }
}