//ROHA ARSLAN   FA21-BSE-116
//AIMAH SIDDIQUE  FA21-BSE-092

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
//

import java.lang.reflect.Array;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;

//
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.skin.LabeledSkinBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.mail.*;
import javax.mail.internet.*;

public class HelloApplication extends Application {
    //**********************************************************************************
//*****************************USERNAME AND PASSWORD*****************************************
    final String user="user";
    final String passs="pass";


    TextField signup_user=new TextField();
    TextField signup_Sports =new TextField();

    PasswordField signup_users=new PasswordField();
    Label label_user=new Label("Username");
    Label label_Password=new Label("Password");

     String checkuser,checkpass;
    @Override
    public void start(Stage stage) throws IOException {



        File namesFile=new File("names.txt");
        File fnameFile=new File("fname.txt");
        File schoolFile=new File("school.txt");
        File genderFile=new File("gender.txt");
        File feeFile=new File("fee.txt");
        File gradeFile=new File("grade.txt");
        File credFile=new File("cred.txt");



        Stage StudentsLogsStage=new Stage();
        Stage updateRecordsStage=new Stage();
        Stage deleteRecordsStage=new Stage();
        Stage updateGetChange=new Stage();
        Stage stage_SignUp=new Stage();

        Stage forget_Stage=new Stage();

        //Stage feeRecStage=new Stage();


        //FORM # 1
        Stage menu = new Stage();
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(25, 25, 25, 25));
        gp.setAlignment(Pos.CENTER);
        stage.setTitle("LOGIN FORM");


        // gp.setStyle("-fx-background-color:red");
        Label l = new Label("ADMIN AUTHENTICATION");
        l.setFont(Font.font("times new roman", FontWeight.EXTRA_BOLD, 22));
        Label username = new Label("Username");
        TextField userName = new TextField();

        Label password = new Label("Password");
        PasswordField pass = new PasswordField();
        Label text = new Label("");
        Button enter = new Button("Login");
        Button signup=new Button("Sign Up");
        Label prompt=new Label("Enter valid credential");

        EventHandler Enter = new EventHandler() {
            @Override
            public void handle(Event event) {
                checkuser = userName.getText();
                checkpass = pass.getText();

                //
                Scanner readCred= null;
                try {
                    readCred = new Scanner(credFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                int count=0;
                while(readCred.hasNextLine()){
                    String temp=readCred.nextLine();
                   // System.out.println(readCred.next());
                    //System.out.println(readCred.next()+""+checkpass);
                    System.out.println("check"+checkpass);
                    System.out.println("temp"+temp);
                    if(temp.equals(checkpass))
                    {

                        stage.close();
                   menu.show();

                    }










                //





//                if (checkuser.equals(user) && checkpass.equals(passs)) {
//                    stage.close();
//                    menu.show();
                //}
                else {
                    text.setText("Authentication failed. Try again.");

                }



//
//                checkuser = "";
//                checkpass = "";

            }
        }};


        enter.setOnAction(Enter);

        gp.add(l, 1, 0);

        Button fgbtn=new Button("Forget Password");
        l.setAlignment(Pos.CENTER);
        gp.setVgap(6);
        gp.setHgap(5);
        gp.addRow(3, username, userName);
        gp.addRow(5, password, pass);
        gp.add(text, 1, 6);
        gp.add(enter, 1, 7);
        gp.add(signup, 1, 8);
        gp.add(fgbtn,1,9);


        enter.setAlignment(Pos.BOTTOM_RIGHT);
        signup.setAlignment(Pos.BOTTOM_LEFT);
        //FORM #1 ending

        //MAIN MENU
        GridPane gp2 = new GridPane();
        gp2.setPadding(new Insets(10, 10, 10, 10));
        gp2.setAlignment(Pos.CENTER);
        gp2.setVgap(10);
        gp2.setPrefSize(500,400);
        Label screenTitle = new Label("NUMAN - ZAIN ACADEMY");
        screenTitle.setStyle("-fx-text-fill:white;font-weight: bold;-fx-border-width: 3px;-fx-border-color: white;");

        gp2.setStyle("-fx-background-image: url('img_1.png')");


        screenTitle.setFont(Font.font("times new roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
        gp2.add(screenTitle, 3, 0);
        screenTitle.setAlignment(Pos.TOP_CENTER);
        Button view = new Button("VIEW LOGS");
        view.setAlignment(Pos.CENTER);
        view.setStyle("-fx-background-color:white;-fx-text-fill:#117E79;font-weight: bold;-fx-border-color: white;");
        Button register = new Button("REGISTER STUDENT");
        register.setAlignment(Pos.CENTER);
        register.setStyle("-fx-background-color:white;-fx-text-fill:#117E79;font-weight: bold;-fx-border-color: white;");
        Button update = new Button("UPDATE RECORDS");
        update.setStyle("-fx-background-color:white;-fx-text-fill:#117E79;font-weight: bold;-fx-border-color: white;");
        update.setAlignment(Pos.CENTER);
       /* Button feeRecB=new Button("Fee Record");
        feeRecB.setAlignment(Pos.CENTER);*/
        Button Close=new Button("Close Application");
        Close.setStyle("-fx-background-color:white;-fx-text-fill:#117E79;font-weight: bold;-fx-border-color: white;");
        gp2.add(register, 3, 2);
        gp2.add(view, 3, 3);
        gp2.add(update, 3, 4);
       // gp2.add(feeRecB,3,5);
        gp2.add(Close,3,5);
        EventHandler closeProgram=new EventHandler() {
            @Override
            public void handle(Event event) {
                menu.close();
            }
        };
        Close.setOnAction(closeProgram);
        //END OF MAIN MENU



        //REGISTRATION FORM
        Stage registerStage = new Stage();
        EventHandler RegistrationForm = new EventHandler() {
            @Override
            public void handle(Event event) {
                menu.close();
                registerStage.show();
            }
        };

        register.setOnAction(RegistrationForm);


        GridPane gpRegister = new GridPane();

        gpRegister.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE,CornerRadii.EMPTY,Insets.EMPTY)));

        gpRegister.setAlignment(Pos.BASELINE_CENTER);
        gpRegister.setVgap(13);
        Label registrationForm = new Label("REGISTRATION FORM");
        registrationForm.setFont(Font.font("Times new roman", FontWeight.EXTRA_BOLD, 22));
        Label name = new Label("Name");
        TextField nameTF = new TextField();
        Label fname = new Label("Father Name");
        TextField fnameTF = new TextField();
        Label gender = new Label("Gender");
        RadioButton male = new RadioButton("M");
        RadioButton female = new RadioButton("F");
        ToggleGroup g = new ToggleGroup();
        male.setToggleGroup(g);
        female.setToggleGroup(g);
        Label cllass = new Label("Class");
        ChoiceBox<Integer> grade = new ChoiceBox<>();
        grade.getItems().add(1);
        grade.getItems().add(2);
        grade.getItems().add(3);
        grade.getItems().add(4);
        grade.getItems().add(5);
        grade.getItems().add(6);
        grade.getItems().add(7);
        grade.getItems().add(8);
        grade.getItems().add(9);
        grade.getItems().add(10);
        grade.getItems().add(11);
        grade.getItems().add(12);
        Label school = new Label("School");
        TextField schoolTF = new TextField();
        Label feestatus = new Label("Fee Status");
        RadioButton zakat = new RadioButton("Zakat");
        RadioButton fullfee = new RadioButton("Full ");
        ToggleGroup fee = new ToggleGroup();
        zakat.setToggleGroup(fee);
        fullfee.setToggleGroup(fee);
        Label warning=new Label("MAKE SURE ALL THE QUERIES ARE FILLED");
        Button back = new Button("Main Menu");
        Button SubmitB = new Button("Submit");
        Button tryagain=new Button("Try Again");
        Button back2=new Button("Main Menu");


        EventHandler goback = new EventHandler() {
            @Override
            public void handle(Event event) {
                registerStage.close();
                deleteRecordsStage.close();
                StudentsLogsStage.close();
                updateRecordsStage.close();
                menu.show();

            }
        };
        EventHandler goback2=new EventHandler() {
            @Override
            public void handle(Event event) {
                registerStage.close();
                menu.show();
            }
        };
        back.setOnAction(goback);
        back2.setOnAction(goback2);

        gpRegister.add(registrationForm, 0, 1);
        gpRegister.addRow(2, name, nameTF);
        gpRegister.addRow(3, fname, fnameTF);
        gpRegister.addRow(4, cllass, grade);
        gpRegister.addRow(5, school, schoolTF);
        gpRegister.addRow(6, gender, male, female);
        gpRegister.addRow(7, feestatus, fullfee, zakat);
        gpRegister.addRow(8,warning);
        warning.setTextFill(Paint.valueOf("RED"));
        gpRegister.addRow(9, SubmitB);
        gpRegister.addRow(10,back2);

        EventHandler submit = new EventHandler() {
            @Override
            public void handle(Event event) {
                String name = nameTF.getText();
                String fname = fnameTF.getText();
                String school = schoolTF.getText();

                ArrayList<String> Name=new ArrayList<>();
                ArrayList<String> Fname=new ArrayList<>();
                ArrayList<String> School=new ArrayList<>();
                ArrayList<Toggle> Gender=new ArrayList<>();
                ArrayList<Toggle> Fee=new ArrayList<>();
                ArrayList<Integer> Grade=new ArrayList<>();

                //


                Name.add(name);
                Fname.add(fname);
                Grade.add(grade.getValue());
                Gender.add( g.getSelectedToggle());
                School.add(school);
                Fee.add(fee.getSelectedToggle());



                String[] nameArray=Name.toArray(new String[0]);
                FileWriter namefw= null;
                try {
                    namefw = new FileWriter(namesFile,true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert namefw != null;
                BufferedWriter namebw=new BufferedWriter(namefw);


                for(int x=0;x<nameArray.length;x++){
                    try {
                        if(namebw.toString().length()!=0){
                        namebw.write(nameArray[x]);}
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        namebw.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        namebw.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
//
                //


                String[] fnameArray=Fname.toArray(new String[0]);
                FileWriter fnamefw= null;
                try {
                    fnamefw = new FileWriter(fnameFile,true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert fnamefw != null;
                BufferedWriter fnamebw=new BufferedWriter(fnamefw);

                for(int x=0;x<fnameArray.length;x++){
                    try {
                        if(fnamebw.toString().length()!=0){
                        fnamebw.write(fnameArray[x]);}
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        fnamebw.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        fnamebw.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


                String[] SchoolArray=School.toArray(new String[0]);
                FileWriter schoolfw= null;
                try {
                    schoolfw = new FileWriter(schoolFile,true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert schoolfw != null;

                BufferedWriter schoolbw=new BufferedWriter(schoolfw);

                for(int x=0;x<SchoolArray.length;x++){
                    try {

                        if(schoolbw.toString().length()!=0){
                        schoolbw.write(SchoolArray[x]);}
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                   try {
                        schoolbw.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        schoolbw.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                Toggle[] genderArray=Gender.toArray(new Toggle[0]);
                FileWriter genderfw= null;
                try {
                    genderfw = new FileWriter(genderFile,true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert genderfw != null;
                BufferedWriter genderbw=new BufferedWriter(genderfw);

                for(int x=0;x<genderArray.length;x++){
                    try {
                        if(genderbw.toString().length()!=0){
                        genderbw.write(genderArray[x].toString());}
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        genderbw.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        genderbw.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                Toggle[] feeArray=Fee.toArray(new Toggle[0]);
                FileWriter feefw= null;
                try {
                    feefw = new FileWriter(feeFile,true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert feefw != null;
                BufferedWriter feebw=new BufferedWriter(feefw);

                for(int x=0;x<feeArray.length;x++){
                    try {
                        if(feebw.toString().length()!=0){
                        feebw.write(feeArray[x].toString());}
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        feebw.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        feebw.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                Integer[] gradeArray=Grade.toArray(new Integer[0]);
                FileWriter gradefw= null;
                try {
                    gradefw = new FileWriter(gradeFile,true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert gradefw != null;
                BufferedWriter gradebw=new BufferedWriter(gradefw);

                for(int x=0;x<gradeArray.length;x++){
                    try {
                        gradebw.write(gradeArray[x].toString());
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        gradebw.newLine();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        gradebw.flush();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                nameTF.clear();
                fnameTF.clear();
                schoolTF.clear();
                g.getSelectedToggle().setSelected(false);
                grade.getSelectionModel().clearSelection();
                fee.getSelectedToggle().setSelected(false);

                registerStage.close();
                menu.show();

            }
        };
        SubmitB.setOnAction(submit);

        //END OF REGISTRATION FORM




        // VIEW LOGS
        EventHandler showStudentRecord = new EventHandler() {
            @Override
            public void handle(Event event) {
                menu.close();
                GridPane studentlogsGP=new GridPane();
                studentlogsGP.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE,CornerRadii.EMPTY,Insets.EMPTY)));
                Scene studentlogScene=new Scene(studentlogsGP,650,500);
                StudentsLogsStage.setScene(studentlogScene);



                StudentsLogsStage.show();
                Label index=new Label("Index No.");
                index.setFont(Font.font("Arial Black",FontWeight.BOLD,17));
                Label nameL=new Label("First Name");
                nameL.setFont(Font.font("Arial Black",FontWeight.BOLD,17));
                Label fnameL=new Label("Last Name");
                fnameL.setFont(Font.font("Arial Black",FontWeight.BOLD,17));
                Label classL=new Label("Class");
                classL.setFont(Font.font("Arial Black",FontWeight.BOLD,17));
                Label SchoolL=new Label("School");
                SchoolL.setFont(Font.font("Arial Black",FontWeight.BOLD,17));
                Label genderL=new Label("Gender");
                genderL.setFont(Font.font("Arial Black",FontWeight.BOLD,17));
                studentlogsGP.addRow(0,index,nameL,fnameL,classL,SchoolL,genderL);
                studentlogsGP.setGridLinesVisible(true);
                studentlogsGP.setPadding(Insets.EMPTY);
                studentlogsGP.setAlignment(Pos.TOP_CENTER);

                Scanner readNames= null;
                try {
                    readNames = new Scanner(namesFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                int count=0;
                while(readNames.hasNextLine()){

                    Label textArea=new Label(readNames.nextLine());
                    if(textArea.toString().length()!=0){
                    studentlogsGP.addColumn(1,textArea);
                    count++;}

                }

               for(int x=1; x<=count;x++){
                   String ind= String.valueOf(x);
                   Label indexes=new Label(ind);
                   studentlogsGP.addColumn(0,indexes);
               }


                Scanner readFnames= null;
                try {
                    readFnames = new Scanner(fnameFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                while(readFnames.hasNextLine()){


                    Label textArea=new Label(readFnames.nextLine());
                    if(textArea.toString().length()!=0){
                    studentlogsGP.addColumn(2,textArea);}

                }

                Scanner readGrade= null;
                try {
                    readGrade = new Scanner(gradeFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                while(readGrade.hasNextLine()){

                    Label textArea=new Label(readGrade.nextLine());
                    if(textArea.toString().length()!=0){
                    studentlogsGP.addColumn(3,textArea);}

                }

                Scanner readSchool= null;
                try {
                    readSchool = new Scanner(schoolFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                while(readSchool.hasNextLine()){

                    Label textArea=new Label(readSchool.nextLine());
                    if(textArea.toString().length()!=0){
                    studentlogsGP.addColumn(4,textArea);}

                }

                Scanner readGender= null;
                try {
                    readGender = new Scanner(genderFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

               while (readGender.hasNextLine()){

                   String r;
                   r=readGender.nextLine();
                   if(r.length()>46){
                       String in = String.valueOf(r.charAt(46));
                       Label textArea=new Label(in);
                       studentlogsGP.addColumn(5,textArea);
                        }

               }


                studentlogsGP.addColumn(0,back);
            }
        };
        view.setOnAction(showStudentRecord);
        //End of View Logs



        //UPDATE RECORDS

        Button delete=new Button("Delete");
        Button updateButton=new Button("Update");
        Button finalDel=new Button("Delete");
        Button changerec=new Button("Enter");
        Button tryagain2=new Button("Try again");
        Button Ok=new Button("OK");
        TextField indexTF=new TextField();
        TextField gradeNew=new TextField();
        TextField schoolNew=new TextField();

        EventHandler updateStudentRecord=new EventHandler() {
            @Override
            public void handle(Event event) {

                menu.close();
              GridPane updateStudentRecordGP=new GridPane();
              updateStudentRecordGP.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE,CornerRadii.EMPTY,Insets.EMPTY)));
              updateStudentRecordGP.setVgap(13);
              updateStudentRecordGP.setHgap(13);
              Scene updateRecord=new Scene(updateStudentRecordGP,500,500);
              updateRecordsStage.setScene(updateRecord);
              updateStudentRecordGP.setAlignment(Pos.CENTER);
              Label Delete=new Label("Click if you want to delete a record.");
              Label Update=new Label("Click if you want to update a record.");
              updateStudentRecordGP.addRow(0,Delete,delete);
              updateStudentRecordGP.addRow(1,Update,updateButton);
              updateStudentRecordGP.addRow(2,back);
              updateRecordsStage.show();
            }
        };

        EventHandler deleteRecordsView=new EventHandler() {
            @Override
            public void handle(Event event) {

                updateRecordsStage.close();
                Label indexDel=new Label("Enter the index you want to delete.");
                GridPane studentlogsGP=new GridPane();
                studentlogsGP.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE,CornerRadii.EMPTY,Insets.EMPTY)));
                Scene studentlogScene=new Scene(studentlogsGP,700,500);
                StudentsLogsStage.setScene(studentlogScene);

                StudentsLogsStage.show();
                studentlogsGP.setHgap(20);
                studentlogsGP.setVgap(10);
                Label index=new Label("Index No.");
                index.setFont(Font.font("Arial Black",FontWeight.BOLD,17));
                Label nameL=new Label("First Name");
                nameL.setFont(Font.font("Arial Black",FontWeight.BOLD,17));
                Label fnameL=new Label("Last Name");
                fnameL.setFont(Font.font("Arial Black",FontWeight.BOLD,17));
                Label classL=new Label("Class");
                classL.setFont(Font.font("Arial Black",FontWeight.BOLD,17));
                Label SchoolL=new Label("School");
                SchoolL.setFont(Font.font("Arial Black",FontWeight.BOLD,17));
                Label genderL=new Label("Gender");
                genderL.setFont(Font.font("Arial Black",FontWeight.BOLD,17));
                studentlogsGP.addRow(0,index,nameL,fnameL,classL,SchoolL,genderL);
                //studentlogsGP.setBackground();
                studentlogsGP.setGridLinesVisible(true);
                studentlogsGP.setAlignment(Pos.TOP_CENTER);
                Scanner readNames= null;
                try {
                    readNames = new Scanner(namesFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                int count=0;
                while(readNames.hasNextLine()){

                    Label textArea=new Label(readNames.nextLine());
                    if(textArea!=null){
                        studentlogsGP.addColumn(1,textArea);
                        count++;}

                }

                for(int x=1; x<=count;x++){
                    String ind= String.valueOf(x);
                    Label indexes=new Label(ind);
                    studentlogsGP.addColumn(0,indexes);
                }


                Scanner readFnames= null;
                try {
                    readFnames = new Scanner(fnameFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                while(readFnames.hasNextLine()){


                    Label textArea=new Label(readFnames.nextLine());
                    if(textArea!=null){
                        studentlogsGP.addColumn(2,textArea);}

                }

                Scanner readGrade= null;
                try {
                    readGrade = new Scanner(gradeFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                while(readGrade.hasNextLine()){

                    Label textArea=new Label(readGrade.nextLine());
                    if(textArea!=null){
                        studentlogsGP.addColumn(3,textArea);}

                }

                Scanner readSchool= null;
                try {
                    readSchool = new Scanner(schoolFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                while(readSchool.hasNextLine()){

                    Label textArea=new Label(readSchool.nextLine());
                    if(textArea!=null){
                        studentlogsGP.addColumn(4,textArea);}

                }

                Scanner readGender= null;
                try {
                    readGender = new Scanner(genderFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                while (readGender.hasNextLine()){

                    String r=null;
                    r=readGender.nextLine();
                    if(r.length()>46){
                        String in = String.valueOf(r.charAt(46));
                        Label textArea=new Label(in);
                        studentlogsGP.addColumn(5,textArea);
                    }

                }
                studentlogsGP.addColumn(0,indexDel,indexTF,finalDel,back);

            }
        };

        EventHandler deleteRecord=new EventHandler() {
            @Override
            public void handle(Event event) {

                GridPane deleteRecordsGP=new GridPane();
                deleteRecordsGP.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE,CornerRadii.EMPTY,Insets.EMPTY)));
                Scene deleteRecordsScn=new Scene(deleteRecordsGP,250,250);
                deleteRecordsGP.setAlignment(Pos.CENTER);
                deleteRecordsStage.setScene(deleteRecordsScn);
                int u= Integer.parseInt(indexTF.getText());
                int x=u-1;

                Scanner scanNames= null;
                try {
                    scanNames = new Scanner(namesFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ArrayList<String> nameAL=new ArrayList<>();
                while(scanNames.hasNextLine()){
                    nameAL.add(scanNames.nextLine());
                }

                Scanner scanFnames= null;
                try {
                    scanFnames = new Scanner(fnameFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ArrayList<String> FnameAL=new ArrayList<>();
                while(scanFnames.hasNextLine()){
                    FnameAL.add(scanFnames.nextLine());
                }

                Scanner scanGrade= null;
                try {
                    scanGrade = new Scanner(gradeFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ArrayList<String> gradeAL=new ArrayList<>();
                while(scanGrade.hasNextLine()){
                    gradeAL.add(scanGrade.nextLine());
                }

                Scanner scanSchool= null;
                try {
                    scanSchool = new Scanner(schoolFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ArrayList<String> schoolAL=new ArrayList<>();
                while(scanSchool.hasNextLine()){
                    schoolAL.add(scanSchool.nextLine());
                }

                Scanner scanGender= null;
                try {
                    scanGender = new Scanner(genderFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ArrayList<String> genderAL=new ArrayList<>();
                while(scanGender.hasNextLine()){
                    genderAL.add(scanGender.nextLine());
                }

                try{
              if (nameAL.get(x) != null) {
        nameAL.remove(x);
        String[] nameStr = nameAL.toArray(new String[0]);
        FileWriter fw = null;
        try {
            fw = new FileWriter(namesFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        for (int m = 0; m < nameStr.length; m++) {
            try {
                bw.write(nameStr[m]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
         }
         }
             if (FnameAL.get(x) != null) {
                 FnameAL.remove(x);
                 String[] FnameStr = FnameAL.toArray(new String[0]);
                 FileWriter fw = null;
                 try {
                     fw = new FileWriter(fnameFile);
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
                 BufferedWriter bw = new BufferedWriter(fw);
                 for (int m = 0; m < FnameStr.length; m++) {
                     try {
                         bw.write(FnameStr[m]);
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                     try {
                         bw.newLine();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }

                     try {
                         bw.flush();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
             }

             if (gradeAL.get(x) != null) {
                 gradeAL.remove(x);
                 String[] gradeStr = gradeAL.toArray(new String[0]);
                 FileWriter fw = null;
                 try {
                     fw = new FileWriter(gradeFile);
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
                 BufferedWriter bw = new BufferedWriter(fw);
                 for (int m = 0; m < gradeStr.length; m++) {
                     try {
                         bw.write(gradeStr[m]);
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                     try {
                         bw.newLine();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }

                     try {
                         bw.flush();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
             }

             if (schoolAL.get(x) != null) {
                 schoolAL.remove(x);
                 String[] schoolStr = schoolAL.toArray(new String[0]);
                 FileWriter fw = null;
                 try {
                     fw = new FileWriter(schoolFile);
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
                 BufferedWriter bw = new BufferedWriter(fw);
                 for (int m = 0; m < schoolStr.length; m++) {
                     try {
                         bw.write(schoolStr[m]);
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                     try {
                         bw.newLine();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }

                     try {
                         bw.flush();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
             }

             if (genderAL.get(x) != null) {
                 genderAL.remove(x);
                 String[] genderStr = genderAL.toArray(new String[0]);
                 FileWriter fw = null;
                 try {
                     fw = new FileWriter(genderFile);
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
                 BufferedWriter bw = new BufferedWriter(fw);
                 for (int m = 0; m < genderStr.length; m++) {
                     try {
                         bw.write(genderStr[m]);
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                     try {
                         bw.newLine();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }

                     try {
                         bw.flush();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
             }
             indexTF.clear();
             StudentsLogsStage.close();
             menu.show();
         }


         catch (IndexOutOfBoundsException e){

            Label err=new Label("!: Record not found");
            err.setFont(Font.font("Times new roman",FontWeight.BOLD,FontPosture.REGULAR,17));

            deleteRecordsGP.setVgap(13);
            deleteRecordsGP.addColumn(0,err,back,tryagain);
            deleteRecordsStage.show();

         }
            }
        };

        EventHandler updateRecordsView=new EventHandler() {
            @Override
            public void handle(Event event) {

                updateGetChange.close();
                updateRecordsStage.close();
                Label indexDel=new Label("Enter the index you want to update");
                GridPane studentlogsGP=new GridPane();
                studentlogsGP.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE,CornerRadii.EMPTY,Insets.EMPTY)));
                Scene studentlogScene=new Scene(studentlogsGP,700,500);
                StudentsLogsStage.setScene(studentlogScene);

                StudentsLogsStage.show();
                studentlogsGP.setHgap(20);
                studentlogsGP.setVgap(10);
                Label index=new Label("Index No.");
                index.setFont(Font.font("Arial Black",FontWeight.BOLD,17));
                Label nameL=new Label("First Name");
                nameL.setFont(Font.font("Arial Black",FontWeight.BOLD,17));
                Label fnameL=new Label("Last Name");
                fnameL.setFont(Font.font("Arial Black",FontWeight.BOLD,17));
                Label classL=new Label("Class");
                classL.setFont(Font.font("Arial Black",FontWeight.BOLD,17));
                Label SchoolL=new Label("School");
                SchoolL.setFont(Font.font("Arial Black",FontWeight.BOLD,17));
                Label genderL=new Label("Gender");
                genderL.setFont(Font.font("Arial Black",FontWeight.BOLD,17));
                studentlogsGP.addRow(0,index,nameL,fnameL,classL,SchoolL,genderL);
                //studentlogsGP.setBackground();
                studentlogsGP.setGridLinesVisible(true);
                studentlogsGP.setAlignment(Pos.TOP_CENTER);
                Scanner readNames= null;
                try {
                    readNames = new Scanner(namesFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                int count=0;
                while(readNames.hasNextLine()){

                    Label textArea=new Label(readNames.nextLine());
                    if(textArea!=null){
                        studentlogsGP.addColumn(1,textArea);
                        count++;}

                }

                for(int x=1; x<=count;x++){
                    String ind= String.valueOf(x);
                    Label indexes=new Label(ind);
                    studentlogsGP.addColumn(0,indexes);
                }


                Scanner readFnames= null;
                try {
                    readFnames = new Scanner(fnameFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                while(readFnames.hasNextLine()){


                    Label textArea=new Label(readFnames.nextLine());
                    if(textArea!=null){
                        studentlogsGP.addColumn(2,textArea);}

                }

                Scanner readGrade= null;
                try {
                    readGrade = new Scanner(gradeFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                while(readGrade.hasNextLine()){

                    Label textArea=new Label(readGrade.nextLine());
                    if(textArea!=null){
                        studentlogsGP.addColumn(3,textArea);}

                }

                Scanner readSchool= null;
                try {
                    readSchool = new Scanner(schoolFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                while(readSchool.hasNextLine()){

                    Label textArea=new Label(readSchool.nextLine());
                    if(textArea!=null){
                        studentlogsGP.addColumn(4,textArea);}

                }

                Scanner readGender= null;
                try {
                    readGender = new Scanner(genderFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                while (readGender.hasNextLine()){

                    String r=null;
                    r=readGender.nextLine();
                    if(r.length()>46){
                        String in = String.valueOf(r.charAt(46));
                        Label textArea=new Label(in);
                        studentlogsGP.addColumn(5,textArea);
                    }

                }
                studentlogsGP.addColumn(0,indexDel,indexTF,changerec,back);

            }
        };

        EventHandler updateRecord=new EventHandler() {
            @Override
            public void handle(Event event) {

                StudentsLogsStage.close();
                GridPane updateRecGP=new GridPane();
                updateRecGP.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE,CornerRadii.EMPTY,Insets.EMPTY)));
                Scene update=new Scene(updateRecGP,500,500);
                updateGetChange.setScene(update);
                updateGetChange.show();

                int u= Integer.parseInt(indexTF.getText());
                int x=u-1;


                Scanner scanNames= null;
                try {
                    scanNames = new Scanner(namesFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ArrayList<String> nameAL=new ArrayList<>();
                while(scanNames.hasNextLine()){
                    nameAL.add(scanNames.nextLine());
                }

                Scanner scanFnames= null;
                try {
                    scanFnames = new Scanner(fnameFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ArrayList<String> FnameAL=new ArrayList<>();
                while(scanFnames.hasNextLine()){
                    FnameAL.add(scanFnames.nextLine());
                }

                Scanner scanGrade= null;
                try {
                    scanGrade = new Scanner(gradeFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ArrayList<String> gradeAL=new ArrayList<>();
                while(scanGrade.hasNextLine()){
                    gradeAL.add(scanGrade.nextLine());
                }

                Scanner scanSchool= null;
                try {
                    scanSchool = new Scanner(schoolFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ArrayList<String> schoolAL=new ArrayList<>();
                while(scanSchool.hasNextLine()){
                    schoolAL.add(scanSchool.nextLine());
                }

                Scanner scanGender= null;
                try {
                    scanGender = new Scanner(genderFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ArrayList<String> genderAL=new ArrayList<>();
                while(scanGender.hasNextLine()){
                    genderAL.add(scanGender.nextLine());
                }

                try{
                Label name=new Label("Name");
                Label Fname=new Label("Father Name");
                Label gender=new Label("Gender");
                Label grade=new Label("Grade");
                Label school=new Label("School");

                Label getName=new Label(nameAL.get(x));
                getName.setFont(Font.font("times new roman",FontWeight.BOLD,12));
                Label getFname=new Label(FnameAL.get(x));
                getFname.setFont(Font.font("times new roman",FontWeight.BOLD,12));
                    String r=genderAL.get(x);
                    String in = String.valueOf(r.charAt(46));
                    Label getGender=new Label(in);
                    getGender.setFont(Font.font("times new roman",FontWeight.BOLD,12));


                    updateRecGP.setAlignment(Pos.CENTER);
                    updateRecGP.setHgap(13);
                    updateRecGP.setVgap(13);

                updateRecGP.addRow(0,name,getName);
                updateRecGP.addRow(1,Fname,getFname);
                updateRecGP.addRow(2,gender,getGender);
                updateRecGP.addRow(3,grade,gradeNew);
                updateRecGP.addRow(4,school,schoolNew);
                updateRecGP.addRow(5,Ok);

                }

                catch (IndexOutOfBoundsException e){
                    Label error=new Label("Record Does Not Exist");
                    updateRecGP.setAlignment(Pos.CENTER);
                    updateRecGP.setVgap(13);
                    updateRecGP.addColumn(0,error,tryagain2,back);
                    indexTF.clear();
                    updateGetChange.show();
                }
            }
        };

        EventHandler ok= new EventHandler() {
            @Override
            public void handle(Event event) {
                int u= Integer.parseInt(indexTF.getText());
                int x=u-1;

                Scanner scanGrade= null;
                try {
                    scanGrade = new Scanner(gradeFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ArrayList<String> gradeAL=new ArrayList<>();
                while(scanGrade.hasNextLine()){
                    gradeAL.add(scanGrade.nextLine());
                }

                Scanner scanSchool= null;
                try {
                    scanSchool = new Scanner(schoolFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ArrayList<String> schoolAL=new ArrayList<>();
                while(scanSchool.hasNextLine()){
                    schoolAL.add(scanSchool.nextLine());
                }

                if (gradeNew.getText().length() != 0) {
                    gradeAL.set(x, gradeNew.getText());}
                    String[] gradeStr = gradeAL.toArray(new String[0]);
                    FileWriter fw = null;
                    try {
                        fw = new FileWriter(gradeFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    BufferedWriter bw = new BufferedWriter(fw);
                    for (int m = 0; m < gradeStr.length; m++) {
                        try {
                            bw.write(gradeStr[m]);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            bw.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        try {
                            bw.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }


                 if(schoolNew.getText().length()!=0) {
                     schoolAL.set(x,schoolNew.getText());}
                    String[] schoolStr = schoolAL.toArray(new String[0]);
                    FileWriter fww = null;
                    try {
                        fww = new FileWriter(schoolFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    BufferedWriter bww = new BufferedWriter(fww);
                    for (int m = 0; m < schoolStr.length; m++) {
                        try {
                            bww.write(schoolStr[m]);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            bww.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        try {
                            bww.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    indexTF.clear();

                    updateGetChange.close();
                menu.show();

            }
        };


        Ok.setOnAction(ok);
        update.setOnAction(updateStudentRecord);
        delete.setOnAction(deleteRecordsView);
        finalDel.setOnAction(deleteRecord);
        tryagain.setOnAction(deleteRecordsView);
        tryagain2.setOnAction(updateRecordsView);
        updateButton.setOnAction(updateRecordsView);
        changerec.setOnAction(updateRecord);

        //END OF UPDATE RECORDS

     /*   //FeeRecord

        File feeRec=new File("feeRec.txt");

        Button viewFR=new Button("View");
        Button updateFR=new Button("Update");

        EventHandler feeRecChoice=new EventHandler() {
            @Override
            public void handle(Event event) {
                menu.close();
                GridPane feeRecChoiceGP=new GridPane();
                Scene FRCS=new Scene(feeRecChoiceGP,500,500);
                feeRecStage.setScene(FRCS);
                feeRecStage.show();
                feeRecChoiceGP.setAlignment(Pos.CENTER);
                feeRecChoiceGP.setVgap(13);
                feeRecChoiceGP.setHgap(13);

                Label view=new Label("View Fees Record");
                view.setFont(Font.font("cal",FontWeight.MEDIUM,13));
                Label update=new Label("Update Fees Record");
                update.setFont(Font.font("cal",FontWeight.MEDIUM,13));
                Label feeRecord=new Label("FEES RECORDS");
                feeRecord.setFont(Font.font("times new roman",FontWeight.BOLD,FontPosture.REGULAR,22));
                feeRecChoiceGP.addRow(0,feeRecord);
                feeRecChoiceGP.addRow(1,view,viewFR);
                feeRecChoiceGP.addRow(2,update,updateFR);
                feeRecChoiceGP.addRow(3,back);


            }
        };
        ArrayList<CheckBox> feeStatus=new ArrayList<>();

        EventHandler updatefeerec=new EventHandler() {
            @Override
            public void handle(Event event) {

                GridPane updatefeerecGP=new GridPane();
                Scene updatefeescn=new Scene(updatefeerecGP,700,500);
                feeRecStage.setScene(updatefeescn);
                feeRecStage.show();
                Label studentName=new Label("Name");
                Label indL=new Label("Index No.");
                Label Jan=new Label("Jan");
                updatefeerecGP.setHgap(13);
                updatefeerecGP.setVgap(13);
                updatefeerecGP.addColumn(1,studentName);
                updatefeerecGP.addColumn(0,indL);
                updatefeerecGP.addColumn(2,Jan);
                updatefeerecGP.setGridLinesVisible(false);

                CheckBox fee=new CheckBox();
                Scanner readNames= null;
                try {
                    readNames = new Scanner(namesFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                int count=0;
                while(readNames.hasNextLine()){

                    Label textArea=new Label(readNames.nextLine());
                    if(textArea.toString().length()!=0){
                        updatefeerecGP.addColumn(1,textArea);
                        count++;}

                }
                for(int index=1 ; index<=count ; index++){
                    String ind= String.valueOf(index);
                    Label indexes=new Label(ind);
                    updatefeerecGP.addColumn(0,indexes);
                }


               *//* for(int x =0 ; feeStatus.size()<=count ; x++  ) {

                   feeStatus.add(fee);
               }*//*


                for(int x=1; x<feeStatus.size();x++){

                    CheckBox cc= new CheckBox();
                    updatefeerecGP.addColumn(2,cc);

                }
                







            }
        };
*/


      /*  feeRecB.setOnAction(feeRecChoice);
        updateFR.setOnAction(updatefeerec);
*/













        Scene registartionForm = new Scene(gpRegister, 500, 600);
        registerStage.setScene(registartionForm);

        Scene Smenu = new Scene(gp2, 500, 500);
        gp2.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        menu.setScene(Smenu);

        Scene login = new Scene(gp, 500, 500);
        gp.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        stage.setScene(login);
        stage.show();

////
        GridPane signups=new GridPane();
        Scene scene_SignUp=new Scene(signups,500,500);

        stage_SignUp.setScene(scene_SignUp);




        Label labelSports=new Label("Which one is your favorite sports");

        signups.add(label_user,1,5);
        signups.add(label_Password,1,6);
        signups.add(labelSports,1,7);

        //textfield 1 and 2
        signups.add(signup_user,2,5);
        signups.add(signup_users,2,6);
        signups.add(signup_Sports,2,7);

        Button SignUpSubmitBtn=new Button("Submit");
        signups.add(SignUpSubmitBtn,1,9);
        Label SUHeading=new Label("Sign Up");

        SUHeading.setFont(Font.font("times new roman", FontWeight.EXTRA_BOLD, 22));

        signups.add(SUHeading,1,0);






        signups.setAlignment(Pos.CENTER);
        Button backToLog=new Button("Back");
        signups.add(backToLog,1,8);

        SignUpSubmitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                ArrayList<String> CredArr=new ArrayList<>();
                String SUname=signup_user.getText();
                String SUpass=signup_users.getText();
                String Sports=signup_Sports.getText();

                CredArr.add(SUname);
                CredArr.add(SUpass);
                CredArr.add(Sports);

                String[] credArray=CredArr.toArray(new String[0]);
                FileWriter credfw= null;
                try {
                    credfw = new FileWriter(credFile,true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert credfw != null;
                BufferedWriter credbw=new BufferedWriter(credfw);

                for(int x=0;x<credArray.length;x++){
                    try {
                        if(credbw.toString().length()!=0){
                            credbw.write(credArray[x]);}
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        credbw.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        credbw.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }





            }
        });

        backToLog.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage_SignUp.close();
                forget_Stage.close();
                stage.show();


            }
        });




        //signup button functionality
signup.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent actionEvent) {
        stage_SignUp.show();
        stage.close();
    }
});
//forget btn
        GridPane forgets=new GridPane();
        Scene scene_forget=new Scene(forgets,500,500);

        forget_Stage.setScene(scene_forget);

        forgets.setAlignment(Pos.CENTER);
        forgets.add(labelSports,1,2);
        TextField fgtxt=new TextField();
        forgets.add(fgtxt,1,3);


        Button fgSubmit=new Button("Submit");
        forgets.add(fgSubmit,1,4);
        forgets.add(backToLog,1,5);

        forgets.add(new Label("Username"),1,0);
        forgets.add(new TextField(),1,1);

        Label labelAuth=new Label("");
        forgets.add(labelAuth,1,7);


        fgSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String ChkSports=fgtxt.getText();
                //
                Scanner readCred= null;
                try {
                    readCred = new Scanner(credFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                int count=0;
                while(readCred.hasNextLine()) {
                    String temp = readCred.nextLine();
                    System.out.println(temp+ChkSports);


                    if (temp.equals(ChkSports)) {


                        forget_Stage.close();

                        stage.close();
                        menu.show();

                    }
                    else {
                        labelAuth.setText("Incorrect Input");
                        labelAuth.setStyle("-fx-text-fill:red");
                    }

                }
            }
        });

fgbtn.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent actionEvent) {
        stage.close();
        forget_Stage.show();






    }
});





    }

    public static void main(String[] args) {

        launch();

    }
}