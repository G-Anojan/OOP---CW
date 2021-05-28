import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SportsGui extends Application {
    //get list for tables from PremierLeagueManager class
    ObservableList<FootballClub> footlist = FXCollections.observableArrayList(PremierLeagueManager.footballClubList);
    ObservableList<Match> matchlist = FXCollections.observableArrayList(PremierLeagueManager.sportsList);
    PremierLeagueManager pre = new PremierLeagueManager();

    //button creations
    Button bt1,bt2,bt3,bt4,bt5,bt6;
//    public void run( int i){
//    if (i == 0) {
//            launch(String.valueOf(this));
//        }
//    }

    public void start(Stage primaryStage) throws Exception {
        // set text to buttons
        bt1 = new Button("Points Table");
        bt2 = new Button("Goals Table");
        bt3 = new Button("Wins Table");
        bt4 = new Button("Add Match");
        bt5 = new Button("Match Table");
        bt6 = new Button("Search Match");
        // label creations
        Label lab = new Label("Premier League");

        lab.setStyle("-fx-background-color: #BB29BB; " +
                " -fx-font-size: 25px;"+
                " -fx-padding: 12px 300px;");

        //VBox box = new VBox();
        FlowPane layout = new FlowPane();

        layout.setOrientation(Orientation.VERTICAL);
        Stage primary = new Stage();
        //primary.setResizable(false);

        bt1.setStyle("-fx-background-color: #EA99DF; " +
                " -fx-text-fill: black;" +
                " -fx-font-size: 15px;"+
                "-fx-align: center;"+
                " -fx-padding: 20px 40px;");
        bt1.setPadding(new Insets(30));
        bt2.setStyle("-fx-background-color: #EA99DF; " +
                " -fx-text-fill: black;" +
                " -fx-font-size: 15px;"+
                "-fx-align: center;"+
                " -fx-padding: 20px 40px;");
        bt2.setPadding(new Insets(30));
        bt3.setStyle("-fx-background-color: #EA99DF; " +
                " -fx-text-fill: black;" +
                " -fx-font-size: 15px;"+
                "-fx-align: center;"+
                " -fx-padding: 20px 40px;");
        bt4.setStyle("-fx-background-color: #EA99DF; " +
                " -fx-text-fill: black;" +
                " -fx-font-size: 15px;"+
                "-fx-align: center;"+
                "-fx-width: 200px;"+
                " -fx-padding: 20px 40px;");
        bt5.setStyle("-fx-background-color: #EA99DF; " +
                " -fx-text-fill: black;" +
                " -fx-font-size: 15px;"+
                "-fx-align: center;"+
                "-fx-width: 200px;"+
                " -fx-padding: 20px 40px;");
        bt6.setStyle("-fx-background-color: #EA99DF; " +
                " -fx-text-fill: black;" +
                " -fx-font-size: 15px;"+
                "-fx-align: center;"+
                " -fx-padding: 20px 40px;");




        //set event for Button 1
        bt1.setOnAction(event -> {
            pre.points_oder();
           tableCre();
        });
        //set event for Button 2
        bt2.setOnAction(event -> {
            //sort the array list by Scored Goals
            pre.goles_scored_oder();
            tableCre();
        });
        //set event for Button 3
        bt3.setOnAction(event -> {
            //sort the array list by Win amount
            pre.wins_oder();
            tableCre();


        });
        //set event for Button 4
        bt4.setOnAction(event -> {
            pre.random();
            tableCre();
        });
        //set event for Button 5
        bt5.setOnAction(event -> {
            Stage st = new Stage();
            st.setTitle("Played Matches.");
            st.setResizable(false);
            Label lab2 = new Label("Premier League Table");

            lab2.setStyle("-fx-background-color: #BB29BB; " +
                    " -fx-font-size: 25px;"+
                    " -fx-padding: 12px 75px;");
            FlowPane fl = new FlowPane();

            pre.loadMatchFile();
            //create a table
            TableView<Match> table = new TableView<>();

            //create column for table
            TableColumn<Match,String> col1 = new TableColumn<>("Date");
            TableColumn<Match,String> col2 = new TableColumn<>("Team 1");
            TableColumn<Match,Integer> col3 = new TableColumn<>("Team 1 Score");
            TableColumn<Match,String> col4 = new TableColumn<>("Team 2 ");
            TableColumn<Match,Integer> col5 = new TableColumn<>("Team 2 Score");

            //set value to column
            col1.setCellValueFactory(new PropertyValueFactory<>("date"));
            col2.setCellValueFactory(new PropertyValueFactory<>("firstTeam"));
            col3.setCellValueFactory(new PropertyValueFactory<>("firstTeamScor"));
            col4.setCellValueFactory(new PropertyValueFactory<>("secondTeam"));
            col5.setCellValueFactory(new PropertyValueFactory<>("secondTeamScor"));
            matchlist.addAll();

            table.setItems(matches());
            table.getColumns().addAll(col1,col2,col3,col4,col5);

            fl.getChildren().addAll(lab2,table);
            Scene s = new Scene(fl);

            st.setScene(s);
            st.showAndWait();

        });
        //set event for Button 6
            bt6.setOnAction(event -> {
                pre.loadMatchFile();
                Stage ps4 = new Stage();
                ps4.setTitle(" Search Match by Date");

                TextField tf = new TextField();
                Button btn7 =new Button();
                btn7.setText("Search_Match");
                Label label2 = new Label();
                Label label3 = new Label();
                Label label4 = new Label();
                Label label5 = new Label();

                btn7.setOnAction(event1 -> {
                    label2.setText("Match on this Dates -" + tf.getText() + "\n");


                    for (Match mat : PremierLeagueManager.sportsList) {
                        if (mat.getDate().equals(tf.getText())) {
                            label3.setText(mat.getFirstTeam() + "\tVs\t" +  mat.getSecondTeam() + "\n");
                            label4.setText(mat.getFirstTeam() + "Score :\t " +   mat.getFirstTeamScor() + "\n");
                            label5.setText(mat.getSecondTeam() + " Score :\t " +   mat.getSecondTeamScor() + "\n");
                            //label2.setText(mat.getFirstTeam() + "\tVs\t" +  mat.getSecondTeam() + "\n");
                            System.out.println(mat.getFirstTeam() + "\tVs\t" + mat.getSecondTeam());
                            System.out.println(mat.getFirstTeam() + "   Score : " + mat.getFirstTeamScor());
                            System.out.println(mat.getSecondTeam() + "  Score : " + mat.getSecondTeamScor());
                        }
                    }
                });

                VBox vbox1 = new VBox();
                vbox1.getChildren().add(tf);
                vbox1.getChildren().add(btn7);
                vbox1.getChildren().addAll(label2,label3,label4,label5);
                vbox1.setAlignment(Pos.CENTER);
                Scene scene = new Scene(vbox1,300,350);
                ps4.setScene(scene);
                ps4.show();
            });

        //set title for stage
        primary.setTitle("----- Premier League -----");

        //Add all Buttons in Vbox
        VBox vb = new VBox(bt1,bt2,bt3,bt4,bt5,bt6);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(20));

        layout.getChildren().addAll(lab,vb);
        Scene sc = new Scene(layout,600,600);

        primary.setScene(sc);
        primary.showAndWait();
    }

    // method for get array list from Premier League class
    public ObservableList<FootballClub> club(){
        ObservableList<FootballClub> goals = FXCollections.observableArrayList(PremierLeagueManager.footballClubList);
        return  goals;
    }
    // method for get array list from Premier League class
    public  ObservableList<Match> matches(){
        ObservableList<Match> score = FXCollections.observableArrayList(PremierLeagueManager.sportsList);
        return  score;
    }
    // method for table creation
    public void tableCre(){
        Stage st = new Stage();
        st.setTitle("Points Table");
        st.setResizable(false);
        // label creation and add style
        Label lab = new Label("Premier League Table");
        lab.setStyle("-fx-background-color: #BB29BB; " +
                " -fx-font-size: 25px;"+
                " -fx-padding: 12px 230px;");
        //create flowpane
        FlowPane fl = new FlowPane();

        //create a table
        TableView<FootballClub> table = new TableView<>();
        //create column for table
        TableColumn<FootballClub,String> col1 = new TableColumn<>("Club Name");
        TableColumn<FootballClub,Integer> col2 = new TableColumn<>("W");
        TableColumn<FootballClub,Integer> col3 = new TableColumn<>("L");
        TableColumn<FootballClub,Integer> col4 = new TableColumn<>("D");
        TableColumn<FootballClub,Integer> col5 = new TableColumn<>("RG");
        TableColumn<FootballClub,Integer> col6 = new TableColumn<>("SG");
        TableColumn<FootballClub,Integer> col7 = new TableColumn<>("P");
        TableColumn<FootballClub,Integer> col8 = new TableColumn<>("PM");
        TableColumn<FootballClub,Integer> col9 = new TableColumn<>("GF");

        //set value to column
        col1.setCellValueFactory(new PropertyValueFactory<>("sportsClubName"));
        col2.setCellValueFactory(new PropertyValueFactory<>("wins"));
        col3.setCellValueFactory(new PropertyValueFactory<>("defeats"));
        col4.setCellValueFactory(new PropertyValueFactory<>("draws"));
        col5.setCellValueFactory(new PropertyValueFactory<>("recevied_goles"));
        col6.setCellValueFactory(new PropertyValueFactory<>("scored_goles"));
        col7.setCellValueFactory(new PropertyValueFactory<>("no_of_points"));
        col8.setCellValueFactory(new PropertyValueFactory<>("played_matches"));
        col9.setCellValueFactory(new PropertyValueFactory<>("goles_difer"));

        footlist.addAll();

        table.setItems(club());
        table.getColumns().addAll(col1,col2,col3,col4,col5,col6,col7,col8,col9);
        //add table and label to flowpane
        fl.getChildren().addAll(lab,table);
        Scene s = new Scene(fl);

        st.setScene(s);
        st.showAndWait();
    }
}