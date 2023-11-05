package com.example.login.Ranking;

import com.example.login.Lattice.HelloApplication;
import com.example.login.MAIN;
import com.example.login.panelController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class individualRankingController implements Initializable {

    @FXML
    private AnchorPane anchorpaneHeight;

    @FXML
    private VBox contestantInfo;
    @FXML
    private Button backBtn;

    @FXML
    void backButton(MouseEvent event) throws IOException {
        panelController.duplicate_back_btn(backBtn);

    }

    @FXML
    private Label Menu;

    @FXML
    private Label MenuBack;

    @FXML
    private AreaChart<String, String> area;

    @FXML
    private AnchorPane menubar;

    @FXML
    private PieChart pie;

    @FXML
    private ProgressBar prog;

    @FXML
    private Button buttonRanking;

    @FXML
    private Button activities;

    @FXML
    private Button OJbtn;
    @FXML
    Button dashboard;

    @FXML
    void dashboardBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) dashboard.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ranking");
        stage.setScene(scene);
        stage.centerOnScreen();
    }
    @FXML
    void latticeline(MouseEvent event) throws IOException {
        Stage stage = (Stage) OJbtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/login/Lattice/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1520,780);
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @FXML
    void ranking(MouseEvent event) throws IOException {
        Stage stage = (Stage) buttonRanking.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/Ranking/individualRanking.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ranking");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @FXML
    void activitiesBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) activities.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/Activities/panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ranking");
        stage.setScene(scene);
        stage.centerOnScreen();
    }
    @FXML
    private Button study;


    @FXML
    void studyBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) study.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/Study/study.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ranking");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @FXML
    Button logout;
    @FXML
    void logoutBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) logout.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/LogIn_SignUp_Pass/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ranking");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<IndividualInformation> person = new ArrayList<>(persons());
        anchorpaneHeight.setMaxHeight(65 * person.size());
        for(int i = 0; i < person.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/login/Ranking/sampleIndividualRanking.fxml"));
            try {
                AnchorPane box = fxmlLoader.load();
                sampleIndividualRankingController cic = fxmlLoader.getController();
                cic.setData(person.get(i));
                contestantInfo.getChildren().add(box);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
    private List<IndividualInformation> persons() {
        List<IndividualInformation> ls = new ArrayList<>();
        IndividualInformation contacts = new IndividualInformation();


        contacts.setName("Tariq Hasan Rizu");
        contacts.setDept("CSE");
        contacts.setLevel("04");
        contacts.setTotalSolve("46");
        contacts.setPenalty("2043");
        contacts.setRank("01");
        ls.add(contacts);

        contacts = new IndividualInformation();
        contacts.setName("Rayhan Ferdous Faisal");
        contacts.setDept("CSE");
        contacts.setLevel("04");
        contacts.setTotalSolve("46");
        contacts.setPenalty("3119");
        contacts.setRank("02");
        ls.add(contacts);

        contacts = new IndividualInformation();
        contacts.setName("Munjib Hasan");
        contacts.setDept("CSE");
        contacts.setLevel("03");
        contacts.setTotalSolve("42");
        contacts.setPenalty("2379");
        contacts.setRank("03");
        ls.add(contacts);

        contacts = new IndividualInformation();
        contacts.setName("Muhammad Samee Sevas");
        contacts.setDept("CSE");
        contacts.setLevel("04");
        contacts.setTotalSolve("40");
        contacts.setPenalty("2445");
        contacts.setRank("04");
        ls.add(contacts);

        contacts = new IndividualInformation();
        contacts.setName("Zarif Zeisan Mustafa");
        contacts.setDept("CSE");
        contacts.setLevel("03");
        contacts.setTotalSolve("40");
        contacts.setPenalty("2935");
        contacts.setRank("05");
        ls.add(contacts);

        contacts = new IndividualInformation();
        contacts.setName("Adib Hossain");
        contacts.setDept("CSE");
        contacts.setLevel("04");
        contacts.setTotalSolve("35");
        contacts.setPenalty("2301");
        contacts.setRank("06");
        ls.add(contacts);

        contacts = new IndividualInformation();
        contacts.setName("Istiaque Ahmed Arik");
        contacts.setDept("CSE");
        contacts.setLevel("02");
        contacts.setTotalSolve("35");
        contacts.setPenalty("2221");
        contacts.setRank("07");
        ls.add(contacts);

        contacts = new IndividualInformation();
        contacts.setName("Farhan Nasif Nizami");
        contacts.setDept("CSE");
        contacts.setLevel("04");
        contacts.setTotalSolve("34");
        contacts.setPenalty("2517");
        contacts.setRank("08");
        ls.add(contacts);

        contacts = new IndividualInformation();
        contacts.setName("Syeda Raisa Rahman");
        contacts.setDept("CSE");
        contacts.setLevel("03");
        contacts.setTotalSolve("32");
        contacts.setPenalty("1888");
        contacts.setRank("09");
        ls.add(contacts);

        contacts = new IndividualInformation();
        contacts.setName("Mohammad Sadiqul Alam");
        contacts.setDept("CSE");
        contacts.setLevel("03");
        contacts.setTotalSolve("32");
        contacts.setPenalty("2000");
        contacts.setRank("10");
        ls.add(contacts);

        contacts = new IndividualInformation();
        contacts.setName("Yusuf Reza Hasnat");
        contacts.setDept("CSE");
        contacts.setLevel("02");
        contacts.setTotalSolve("31");
        contacts.setPenalty("1881");
        contacts.setRank("11");
        ls.add(contacts);

        contacts = new IndividualInformation();
        contacts.setName("Syed Mafijul Islam");
        contacts.setDept("CSE");
        contacts.setLevel("02");
        contacts.setTotalSolve("31");
        contacts.setPenalty("2212");
        contacts.setRank("12");
        ls.add(contacts);

        contacts = new IndividualInformation();
        contacts.setName("Iftekharul Islam");
        contacts.setDept("CSE");
        contacts.setLevel("02");
        contacts.setTotalSolve("29");
        contacts.setPenalty("1888");
        contacts.setRank("13");
        ls.add(contacts);

        contacts = new IndividualInformation();
        contacts.setName("Maria Sultana");
        contacts.setDept("CSE");
        contacts.setLevel("03");
        contacts.setTotalSolve("28");
        contacts.setPenalty("2001");
        contacts.setRank("14");
        ls.add(contacts);

        contacts = new IndividualInformation();
        contacts.setName("Al Muhimen");
        contacts.setDept("CSE");
        contacts.setLevel("01");
        contacts.setTotalSolve("25");
        contacts.setPenalty("1552");
        contacts.setRank("15");
        ls.add(contacts);

        contacts = new IndividualInformation();
        contacts.setName("Md. Raisul Islam Rahad");
        contacts.setDept("CSE");
        contacts.setLevel("02");
        contacts.setTotalSolve("25");
        contacts.setPenalty("1502");
        contacts.setRank("16");
        ls.add(contacts);

        contacts = new IndividualInformation();
        contacts.setName("Mohiuddin Bilwal Ayon");
        contacts.setDept("CSE");
        contacts.setLevel("04");
        contacts.setTotalSolve("20");
        contacts.setPenalty("1237");
        contacts.setRank("17");
        ls.add(contacts);

        contacts = new IndividualInformation();
        contacts.setName("Md. Tanvin Sarkar Pallab");
        contacts.setDept("CSE");
        contacts.setLevel("02");
        contacts.setTotalSolve("19");
        contacts.setPenalty("1609");
        contacts.setRank("18");
        ls.add(contacts);

        contacts = new IndividualInformation();
        contacts.setName("Nabiha Parvez");
        contacts.setDept("CSE");
        contacts.setLevel("02");
        contacts.setTotalSolve("17");
        contacts.setPenalty("1047");
        contacts.setRank("19");
        ls.add(contacts);

        contacts = new IndividualInformation();
        contacts.setName("Sumaiya Kabir");
        contacts.setDept("CSE");
        contacts.setLevel("02");
        contacts.setTotalSolve("14");
        contacts.setPenalty("980");
        contacts.setRank("20");
        ls.add(contacts);

        return ls;
    }
}
