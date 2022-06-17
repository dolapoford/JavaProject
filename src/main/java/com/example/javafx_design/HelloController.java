package com.example.javafx_design;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }






    @FXML
    private AnchorPane mainPane;

    @FXML
    private MenuItem close;

    @FXML
    private Label messageLabel;
    @FXML
    private Label messageSave;

    @FXML
    private MenuItem openItem;

    @FXML
    private MenuItem printMenu;

    @FXML
    private Menu printMenuTwo;

    @FXML
    private Menu saveMenuTwo;

    @FXML
    private MenuItem savemenu;

    @FXML
    private TextArea texteditor;


    FileChooser fileChooser= new FileChooser();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileChooser.setInitialDirectory(new File("C:\\Users\\USER\\Desktop\\poem.txt"));
    }

//    public  void initialize(URL location, ResourceBundle resource){
//
//    fileChooser.setInitialDirectory(new File("C:\\Users\\USER\\Desktop"));
//    }

//    @FXML
//    void onBtnOne(MouseEvent event) {
////        try{
////            File file =fileChooser.showOpenDialog(new Stage());
////        }catch (Exception ex){
////
////        }
//
//
//
//
//
////        if (selectedFile != null) {
////
////            texteditor.setText("File selected: " + selectedFile.getName());
////        }
////        else {
////            texteditor.setText("File selection cancelled.");
////        }
//
//    }

    @FXML
    void closeMenu(ActionEvent event) {

    }

    @FXML
    void onPrintMenuTwo(ActionEvent event) {

    }


    private void saveFileRoutine(File file)
            throws IOException{
        // Creates a new file and writes the txtArea contents into it
        String txt = texteditor.getText();
//        file.createNewFile();
//        file=new File("C:\\Users\\USER\\Desktop\\poem.txt");
        FileWriter writer = new FileWriter(file);
        writer.write(txt);
        writer.close();
    }

    @FXML
    void onSaveMenuTwo(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save file");
//        String fileName  = messageSave.getText();
        fileChooser.setInitialFileName("poem.txt");
//        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(" *.txt", "text file"),
//                new FileChooser.ExtensionFilter("pdf","*.pdf"));


        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"));

        File savedFile = fileChooser.showSaveDialog(null);

        if (savedFile != null) {

            try {

                saveFileRoutine(savedFile);

            }
            catch(IOException e) {

                e.printStackTrace();
                messageSave.setText("An ERROR occurred while saving the file!");
                return;
            }

            messageSave.setText("File saved: " + savedFile.toString());
        }
        else {
            messageSave.setText("File save cancelled.");
        }


    }

    private void openFileRoutine(File file)
            throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String text;
        String content="";
        while ((text= reader.readLine()) !=null){
//            System.out.println(text);
            content+=text;
        }
//            System.out.println( reader.readLine());
        reader.close();
        texteditor.setText(content);
    }


    @FXML
    void openItem(ActionEvent event) throws IOException {

        FileChooser fileChooser = new FileChooser();

        File selectedFile = fileChooser.showOpenDialog(null);
    if (selectedFile !=null){
        try {

            openFileRoutine(selectedFile);

        }
        catch(IOException e) {

            e.printStackTrace();
            messageSave.setText("An ERROR occurred while saving the file!");
            return;
        }

        messageSave.setText("File saved: " + selectedFile.toString());
    }
    else {
        messageSave.setText("File save cancelled.");
    }

//
//


//        FileChooser fileChooser = new FileChooser();
//        //only allow text files to be selected using chooser
//        fileChooser.getExtensionFilters().add(
//                new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt")
//        );
//        //set initial directory somewhere user will recognise
//        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
//        //let user select file
//        File fileToLoad = fileChooser.showOpenDialog(null);
//        //if file has been chosen, load it using asynchronous method (define later)
//        if(fileToLoad != null){
//            openFileRoutine(fileToLoad);
//        }

    }

    @FXML
    void printMenu(ActionEvent event) {

    }

    @FXML
    void saveMenu(ActionEvent event) {

        Window stage =mainPane.getScene().getWindow();
        fileChooser.setTitle("Save Dialog");
        fileChooser.setInitialFileName("mySave");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(" *.txt", "text file"),
                new FileChooser.ExtensionFilter("pdf","*.pdf"));

        try{
            File file= fileChooser.showSaveDialog(stage);
            fileChooser.setInitialDirectory(file.getParentFile());

            //ToDo save file
        }
        catch (Exception ex){

        }



    }


}