/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.sms.client;

import com.sms.api.entity.Admin;
import com.sms.api.entity.Student;
import com.sms.api.entity.Teacher;
import com.sms.api.services.Services;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Harry
 */
public class DashboardController implements Initializable {

    @FXML
    private Button btnOverview;
    @FXML
    private Button btnStudents;
    @FXML
    private Button btnStaffs;
    @FXML
    private Button btnAdmin;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnlStaffs;
    @FXML
    private Pane pnlStudents;
    @FXML
    private Pane pnlOverview;
    @FXML
    private Pane pnlAdmin;
    @FXML
    private VBox pnItems111;
    @FXML
    private VBox pnItems1;
    @FXML
    private VBox pnItems11;

    /*Admin*/
    @FXML
    private TextField txtAdmID;
    @FXML
    private TextField txtAdmFirstName;
    @FXML
    private TextField txtAdmLastName;
    @FXML
    private TextField txtAdmRegNo;
    @FXML
    private TextField txtAdmContactNo;
    @FXML
    private TextField txtAdmAddress;
    @FXML
    private TextField txtAdmEmail;
    @FXML
    private DatePicker dtpAdmBateOfBirth;
    @FXML
    private RadioButton rdbAdmMale;
    @FXML
    private RadioButton rdbAdmFemale;
    @FXML
    private TextField txtAdmJobRole;
    @FXML
    private Button btnAdmAdd;
    @FXML
    private Button btnAdmClear;
    @FXML
    private Button btnAdmUpdate;
    @FXML
    private Button btnAdmDelete;
    @FXML
    private Button btnAdmRefresh;
    @FXML
    private TableColumn<Admin, String> colAdmRegNo;
    @FXML
    private TableColumn<Admin, String> colAdmFirstName;
    @FXML
    private TableColumn<Admin, String> colAdmLastName;
    @FXML
    private TableColumn<Admin, String> colAdmContactNo;
    @FXML
    private TableColumn<Admin, String> colAdmAddress;
    @FXML
    private TableColumn<Admin, String> colAdmEmail;
    @FXML
    private TableColumn<Admin, LocalDate> colAdmDateOfBirth;
    @FXML
    private TableColumn<Admin, String> colAdmGender;
    @FXML
    private TableColumn<Admin, String> colAdmJobRole;
    /*Admin*/

 /*Student*/
    @FXML
    private TextField txtStdID;
    @FXML
    private TextField txtStdFirstName;
    @FXML
    private TextField txtStdLastName;
    @FXML
    private TextField txtStdRegNo;
    @FXML
    private TextField txtStdContactNo;
    @FXML
    private TextField txtStdAddress;
    @FXML
    private TextField txtStdEmail;
    @FXML
    private DatePicker dtpStdDateOfBirth;
    @FXML
    private RadioButton rdoStdMale;
    @FXML
    private RadioButton rdoStdFemale;
    @FXML
    private TextField txtStdCourse;
    @FXML
    private TextField txtStdBatch;
    @FXML
    private TextField txtStdSemester;
    @FXML
    private TableColumn<Student, String> colStdRegNo;
    @FXML
    private TableColumn<Student, String> colStdFirstName;
    @FXML
    private TableColumn<Student, String> colStdLastName;
    @FXML
    private TableColumn<Student, String> colStdContactNo;
    @FXML
    private TableColumn<Student, String> colStdAddress;
    @FXML
    private TableColumn<Student, String> colStdEmail;
    @FXML
    private TableColumn<Student, LocalDate> colStdDateOfBirth;
    @FXML
    private TableColumn<Student, String> colStdGender;
    @FXML
    private TableColumn<Student, String> colStdSemester;
    @FXML
    private TableColumn<Student, String> colStdCourse;
    @FXML
    private TableColumn<Student, String> colStdBatch;

    @FXML
    private Button btnStdAdd;
    @FXML
    private Button btnStdClear;
    @FXML
    private Button btnStdUpdate;
    @FXML
    private Button btnStdDelete;
    @FXML
    private Button btnStdRefresh;
    /*Student*/

 /*Teacher*/
    @FXML
    private TextField txtTchID;
    @FXML
    private TextField txtTchFirstName;
    @FXML
    private TextField txtTchLasName;
    @FXML
    private TextField txtTchRegNo;
    @FXML
    private TextField txtTchContactNo;
    @FXML
    private TextField txtTchAddress;
    @FXML
    private TextField txtTchEmail;
    @FXML
    private DatePicker dtpTchDateOfBirth;
    @FXML
    private RadioButton rdoTchMale;
    @FXML
    private RadioButton rdoTchFemale;
    @FXML
    private TextField txtTchQualification;
    @FXML
    private Button btnTchAdd;
    @FXML
    private Button btnTchClear;
    @FXML
    private Button btnTchUpdate;
    @FXML
    private Button btnTchDelete;
    @FXML
    private Button btnTchRefresh;
    @FXML
    private TableColumn<Teacher, String> colTchRegNo;
    @FXML
    private TableColumn<Teacher, String> colTchFirstName;
    @FXML
    private TableColumn<Teacher, String> colTchLastName;
    @FXML
    private TableColumn<Teacher, String> colTchContactNo;
    @FXML
    private TableColumn<Teacher, String> colTchAddress;
    @FXML
    private TableColumn<Teacher, String> colTchEmail;
    @FXML
    private TableColumn<Teacher, LocalDate> colTchDateOfBirth;
    @FXML
    private TableColumn<Teacher, String> colTchGender;
    @FXML
    private TableColumn<Teacher, String> colTchQualification;
    /*Teacher*/

    @FXML
    private TableView<Admin> TableViewAdm;
    @FXML
    private TableView<Student> TableViewStd;
    @FXML
    private TableView<Teacher> TableViewTch;

    private Main main;
    private Services services;

    @Override
    public void initialize(URL location, ResourceBundle resources) {       
        colStdRegNo.setCellValueFactory(new PropertyValueFactory<>("regNo"));
        colStdFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colStdLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colStdContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colStdAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colStdEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colStdDateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        colStdGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colStdCourse.setCellValueFactory(new PropertyValueFactory<>("course"));
        colStdBatch.setCellValueFactory(new PropertyValueFactory<>("batch"));
        colStdSemester.setCellValueFactory(new PropertyValueFactory<>("semester"));

        colAdmRegNo.setCellValueFactory(new PropertyValueFactory<>("regNo"));
        colAdmFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colAdmLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colAdmContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colAdmAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colAdmEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAdmDateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        colAdmGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colAdmJobRole.setCellValueFactory(new PropertyValueFactory<>("jobRole"));

        colTchRegNo.setCellValueFactory(new PropertyValueFactory<>("regNo"));
        colTchFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colTchLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colTchContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colTchAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colTchEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTchDateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        colTchGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colTchQualification.setCellValueFactory(new PropertyValueFactory<>("qualification"));

        TableViewAdm.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Admin>() {
            @Override
            public void changed(ObservableValue<? extends Admin> ov, Admin oldAdmin, Admin newAdmin) {
                if (newAdmin != null) {
                    txtAdmID.setText(Long.toString(newAdmin.getId()));
                    txtAdmFirstName.setText(newAdmin.getFirstName());
                    txtAdmLastName.setText(newAdmin.getLastName());
                    txtAdmRegNo.setText(newAdmin.getRegNo());
                    txtAdmContactNo.setText(newAdmin.getContactNo());
                    txtAdmAddress.setText(newAdmin.getAddress());
                    txtAdmEmail.setText(newAdmin.getEmail());
                    String g = newAdmin.getGender();
                    if (g.equals("Male")) {
                        rdbAdmMale.setSelected(true);
                    }
                    if (g.equals("Female")) {
                        rdbAdmFemale.setSelected(true);
                    }
                    dtpAdmBateOfBirth.setValue(newAdmin.getDateOfBirth());
                    txtAdmJobRole.setText(newAdmin.getJobRole());
                } else {
                    clearFieldsAdm();
                }
            }

        });

        TableViewStd.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> ov, Student oldStudent, Student newStudent) {
                if (newStudent != null) {
                    txtStdID.setText(Long.toString(newStudent.getId()));
                    txtStdFirstName.setText(newStudent.getFirstName());
                    txtStdLastName.setText(newStudent.getLastName());
                    txtStdRegNo.setText(newStudent.getRegNo());
                    txtStdContactNo.setText(newStudent.getContactNo());
                    txtStdAddress.setText(newStudent.getAddress());
                    txtStdEmail.setText(newStudent.getEmail());
                    String g = newStudent.getGender();
                    if (g.equals("Male")) {
                        rdoStdMale.setSelected(true);
                    }
                    if (g.equals("Female")) {
                        rdoStdFemale.setSelected(true);
                    }
                    dtpStdDateOfBirth.setValue(newStudent.getDateOfBirth());
                    txtStdCourse.setText(newStudent.getCourse());
                    txtStdBatch.setText(newStudent.getBatch());
                    txtStdSemester.setText(newStudent.getSemester());
                } else {
                    clearFieldsStd();
                }
            }
        });

        TableViewTch.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Teacher>() {
            @Override
            public void changed(ObservableValue<? extends Teacher> ov, Teacher oldTeacher, Teacher newTeacher) {
                if (newTeacher != null) {
                    txtTchID.setText(Long.toString(newTeacher.getId()));
                    txtTchFirstName.setText(newTeacher.getFirstName());
                    txtTchLasName.setText(newTeacher.getLastName());
                    txtTchRegNo.setText(newTeacher.getRegNo());
                    txtTchContactNo.setText(newTeacher.getContactNo());
                    txtTchAddress.setText(newTeacher.getAddress());
                    txtTchEmail.setText(newTeacher.getEmail());
                    String g = newTeacher.getGender();
                    if (g.equals("Male")) {
                        rdoTchMale.setSelected(true);
                    }
                    if (g.equals("Female")) {
                        rdoTchFemale.setSelected(true);
                    }
                    dtpTchDateOfBirth.setValue(newTeacher.getDateOfBirth());
                    txtTchQualification.setText(newTeacher.getQualification());
                } else {
                    clearFieldsTch();
                }
            }
        });

    }

    @FXML
    public void handleClicks(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == btnStudents) {
            System.out.println("studnets");
            pnlStudents.toFront();
        }
        if (actionEvent.getSource() == btnStaffs) {
            System.out.println("staff");
            pnlStaffs.toFront();
        }
        if (actionEvent.getSource() == btnOverview) {
            System.out.println("overview");
            pnlOverview.toFront();
        }
        if (actionEvent.getSource() == btnAdmin) {
            System.out.println("admin");
            pnlAdmin.toFront();
        }
        if (actionEvent.getSource() == btnSignout) {
            System.out.println("logout");
            try {
                Parent home_page_parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
                Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                services.logout("");
                app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

    }

    @FXML
    private void onAdmAdd(ActionEvent event) {
        if (isFieldValidAdm()) {
            try {
                Admin admin = new Admin();
                admin.setFirstName(txtAdmFirstName.getText());
                admin.setLastName(txtAdmLastName.getText());
                admin.setRegNo(txtAdmRegNo.getText());
                admin.setContactNo(txtAdmContactNo.getText());
                admin.setAddress(txtAdmAddress.getText());
                admin.setEmail(txtAdmEmail.getText());
                admin.setDateOfBirth(dtpAdmBateOfBirth.getValue());
                if (rdbAdmMale.isSelected()) {
                    rdbAdmFemale.setSelected(false);
                    admin.setGender("Male");
                }
                if (rdbAdmFemale.isSelected()) {
                    rdbAdmMale.setSelected(false);
                    admin.setGender("Female");
                }
                admin.setJobRole(txtAdmJobRole.getText());
                admin = services.insertAdmin(admin);
                TableViewAdm.getItems().add(admin);
                clearFieldsAdm();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }

        }

    }

    @FXML
    private void onAdmClear(ActionEvent event) {
        clearFieldsAdm();
    }

    @FXML
    private void onAdmUpdate(ActionEvent event) {
        int index = TableViewAdm.getSelectionModel().getSelectedIndex();
        if (index == -1) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("UPDATE ERROR");
            alert.setHeaderText("No person selected");
            alert.setContentText("PLease select a person in the table");
            alert.showAndWait();
            return;
        }
        if (isFieldValidAdm()) {
            try {
                Admin admin = new Admin();
                admin.setId(Long.valueOf(txtAdmID.getText()));
                admin.setFirstName(txtAdmFirstName.getText());
                admin.setLastName(txtAdmLastName.getText());
                admin.setRegNo(txtAdmRegNo.getText());
                admin.setContactNo(txtAdmContactNo.getText());
                admin.setAddress(txtAdmAddress.getText());
                admin.setEmail(txtAdmEmail.getText());
                admin.setDateOfBirth(dtpAdmBateOfBirth.getValue());
                if (rdbAdmMale.isSelected()) {
                    rdbAdmFemale.setSelected(false);
                    admin.setGender("Male");
                }
                if (rdbAdmFemale.isSelected()) {
                    rdbAdmMale.setSelected(false);
                    admin.setGender("Female");
                }
                admin.setJobRole(txtAdmJobRole.getText());
                services.updateAdmin(admin);
                TableViewAdm.getItems().set(index, admin);
                clearFieldsAdm();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    private void onAdmDelete(ActionEvent event) {
        try {
            Admin admin = TableViewAdm.getSelectionModel().getSelectedItem();
            if (admin == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.setTitle("DELETE ERROR");
                alert.setHeaderText("No person selected");
                alert.setContentText("PLease select a person in the table");
                alert.showAndWait();
                return;
            }
            services.deleteAdmin(admin.getId());
            TableViewAdm.getItems().remove(admin);
            clearFieldsAdm();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void onAdmRefresh(ActionEvent event) {
        try {
            TableViewAdm.getItems().setAll(services.getAllAdmin());
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        clearFieldsAdm();
    }

    @FXML
    private void onStdAdd(ActionEvent event) {
        if (isFieldValidStd()) {
            try {
                Student student = new Student();
                student.setFirstName(txtStdFirstName.getText());
                student.setLastName(txtStdLastName.getText());
                student.setRegNo(txtStdRegNo.getText());
                student.setContactNo(txtStdContactNo.getText());
                student.setAddress(txtStdAddress.getText());
                student.setEmail(txtStdEmail.getText());
                student.setDateOfBirth(dtpStdDateOfBirth.getValue());
                if (rdoStdMale.isSelected()) {
                    rdoStdFemale.setSelected(false);
                    student.setGender("Male");
                }
                if (rdoStdFemale.isSelected()) {
                    rdoStdMale.setSelected(false);
                    student.setGender("Female");
                }
                student.setCourse(txtStdCourse.getText());
                student.setBatch(txtStdBatch.getText());
                student.setSemester(txtStdSemester.getText());
                student = services.insertStudent(student);
                TableViewStd.getItems().add(student);
                clearFieldsStd();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }

        }
    }

    @FXML
    private void onStdClear(ActionEvent event) {
        clearFieldsStd();
    }

    @FXML
    private void onStdUpdate(ActionEvent event) {
        int index = TableViewStd.getSelectionModel().getSelectedIndex();
        if (index == -1) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("UPDATE ERROR");
            alert.setHeaderText("No person selected");
            alert.setContentText("PLease select a person in the table");
            alert.showAndWait();
            return;
        }
        if (isFieldValidStd()) {
            try {
                Student student = new Student();
                student.setId(Long.valueOf(txtStdID.getText()));
                student.setFirstName(txtStdFirstName.getText());
                student.setLastName(txtStdLastName.getText());
                student.setRegNo(txtStdRegNo.getText());
                student.setContactNo(txtStdContactNo.getText());
                student.setAddress(txtStdAddress.getText());
                student.setEmail(txtStdEmail.getText());
                student.setDateOfBirth(dtpStdDateOfBirth.getValue());
                if (rdoStdMale.isSelected()) {
                    rdoStdFemale.setSelected(false);
                    student.setGender("Male");
                }
                if (rdoStdFemale.isSelected()) {
                    rdoStdMale.setSelected(false);
                    student.setGender("Female");
                }
                student.setCourse(txtStdCourse.getText());
                student.setBatch(txtStdBatch.getText());
                student.setSemester(txtStdSemester.getText());
                services.updateStudent(student);
                TableViewStd.getItems().set(index, student);
                clearFieldsAdm();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    private void onStdDelete(ActionEvent event) {
        try {
            Student student = TableViewStd.getSelectionModel().getSelectedItem();
            if (student == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.setTitle("DELETE ERROR");
                alert.setHeaderText("No person selected");
                alert.setContentText("PLease select a person in the table");
                alert.showAndWait();
                return;
            }
            services.deleteStudent(student.getId());
            TableViewStd.getItems().remove(student);
            clearFieldsStd();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void onStdRefresh(ActionEvent event) {
        try {
            TableViewStd.getItems().setAll(services.getAllStudent());
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        clearFieldsStd();
    }

    @FXML
    private void onTchAdd(ActionEvent event) {
        if (isFieldValidTch()) {
            try {
                Teacher teacher = new Teacher();
                teacher.setFirstName(txtTchFirstName.getText());
                teacher.setLastName(txtTchLasName.getText());
                teacher.setRegNo(txtTchRegNo.getText());
                teacher.setContactNo(txtTchContactNo.getText());
                teacher.setAddress(txtTchAddress.getText());
                teacher.setEmail(txtTchEmail.getText());
                teacher.setDateOfBirth(dtpTchDateOfBirth.getValue());
                if (rdoTchMale.isSelected()) {
                    rdoTchFemale.setSelected(false);
                    teacher.setGender("Male");
                }
                if (rdoTchFemale.isSelected()) {
                    rdoTchMale.setSelected(false);
                    teacher.setGender("Female");
                }
                teacher.setQualification(txtTchQualification.getText());
                teacher = services.insertTeacher(teacher);
                TableViewTch.getItems().add(teacher);
                clearFieldsTch();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }

        }
    }

    @FXML
    private void onTchClear(ActionEvent event) {
        clearFieldsTch();
    }

    @FXML
    private void onTchUpdate(ActionEvent event) {
        int index = TableViewTch.getSelectionModel().getSelectedIndex();
        if (index == -1) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("UPDATE ERROR");
            alert.setHeaderText("No person selected");
            alert.setContentText("PLease select a person in the table");
            alert.showAndWait();
            return;
        }
        if (isFieldValidTch()) {
            try {
                Teacher teacher = new Teacher();
                teacher.setId(Long.valueOf(txtTchID.getText()));
                teacher.setFirstName(txtTchFirstName.getText());
                teacher.setLastName(txtTchLasName.getText());
                teacher.setRegNo(txtTchRegNo.getText());
                teacher.setContactNo(txtTchContactNo.getText());
                teacher.setAddress(txtTchAddress.getText());
                teacher.setEmail(txtTchEmail.getText());
                teacher.setDateOfBirth(dtpTchDateOfBirth.getValue());
                if (rdoTchMale.isSelected()) {
                    rdoTchFemale.setSelected(false);
                    teacher.setGender("Male");
                }
                if (rdoTchFemale.isSelected()) {
                    rdoTchMale.setSelected(false);
                    teacher.setGender("Female");
                }
                teacher.setQualification(txtTchQualification.getText());
                services.updateTeacher(teacher);
                TableViewTch.getItems().set(index, teacher);
                clearFieldsTch();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    private void onTchDelete(ActionEvent event) {
        try {
            Teacher teacher = TableViewTch.getSelectionModel().getSelectedItem();
            if (teacher == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.setTitle("DELETE ERROR");
                alert.setHeaderText("No person selected");
                alert.setContentText("PLease select a person in the table");
                alert.showAndWait();
                return;
            }
            services.deleteTeacher(teacher.getId());
            TableViewTch.getItems().remove(teacher);
            clearFieldsStd();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void onTchRefresh(ActionEvent event) {
        try {
            TableViewTch.getItems().setAll(services.getAllTeacher());
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        clearFieldsTch();
    }

    public void setMain(Main main) {
        this.main = main;
        this.services = main.getServices();
        try {
            TableViewAdm.getItems().setAll(services.getAllAdmin());
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        try {
            TableViewStd.getItems().setAll(services.getAllStudent());
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        
        try {
            TableViewTch.getItems().setAll(services.getAllTeacher());
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    private void clearFieldsAdm() {
        txtAdmFirstName.setText("");
        txtAdmLastName.setText("");
        txtAdmRegNo.setText("");
        txtAdmContactNo.setText("");
        txtAdmAddress.setText("");
        txtAdmEmail.setText("");
        dtpAdmBateOfBirth.setValue(null);
        rdbAdmMale.setSelected(false);
        rdbAdmFemale.setSelected(false);
        txtAdmJobRole.setText("");
        txtAdmID.setText("");
    }

    private void clearFieldsStd() {
        txtStdFirstName.setText("");
        txtStdLastName.setText("");
        txtStdRegNo.setText("");
        txtStdContactNo.setText("");
        txtStdAddress.setText("");
        txtStdEmail.setText("");
        dtpStdDateOfBirth.setValue(null);
        rdoStdMale.setSelected(false);
        rdoStdFemale.setSelected(false);
        txtStdCourse.setText("");
        txtStdBatch.setText("");
        txtStdSemester.setText("");
        txtStdID.setText("");
    }
    
     private void clearFieldsTch() {
        txtTchFirstName.setText("");
        txtTchLasName.setText("");
        txtTchRegNo.setText("");
        txtTchContactNo.setText("");
        txtTchAddress.setText("");
        txtTchEmail.setText("");
        dtpTchDateOfBirth.setValue(null);
        rdoTchMale.setSelected(false);
        rdoTchFemale.setSelected(false);
        txtTchQualification.setText("");
        txtStdID.setText("");
    }

    private boolean isFieldValidAdm() {
        String errorMessage = "";
        if (txtAdmFirstName.getText() == null || txtAdmFirstName.getText().isEmpty()) {
            errorMessage += "First name is required! \n";
        }
        if (txtAdmLastName.getText() == null || txtAdmLastName.getText().isEmpty()) {
            errorMessage += "Last name is required! \n";
        }
        if (txtAdmRegNo.getText() == null || txtAdmRegNo.getText().isEmpty()) {
            errorMessage += "Registration No is required! \n";
        }
        if (txtAdmContactNo.getText() == null || txtAdmContactNo.getText().isEmpty()) {
            errorMessage += "Contact No is required! \n";
        }
        if (txtAdmAddress.getText() == null || txtAdmAddress.getText().isEmpty()) {
            errorMessage += "Address is required! \n";
        }
        if (txtAdmEmail.getText() == null || txtAdmEmail.getText().isEmpty()) {
            errorMessage += "Email is required! \n";
        }
        if (dtpAdmBateOfBirth.getValue() == null) {
            errorMessage += "Birth date is required! \n";
        }
        if (rdbAdmMale.isSelected() && rdbAdmFemale.isSelected()) {
            errorMessage += "Select one gender! \n";
        }
        if (!rdbAdmMale.isSelected() && !rdbAdmFemale.isSelected()) {
            errorMessage += "Select one gender! \n";
        }
        if (txtAdmJobRole.getText() == null || txtAdmJobRole.getText().isEmpty()) {
            errorMessage += "Job role is required! \n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("INVALID FIELDS");
            alert.setHeaderText("Please complete all required fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }

    private boolean isFieldValidStd() {
        String errorMessage = "";
        if (txtStdFirstName.getText() == null || txtStdFirstName.getText().isEmpty()) {
            errorMessage += "First name is required! \n";
        }
        if (txtStdLastName.getText() == null || txtStdLastName.getText().isEmpty()) {
            errorMessage += "Last name is required! \n";
        }
        if (txtStdRegNo.getText() == null || txtStdRegNo.getText().isEmpty()) {
            errorMessage += "Registration No is required! \n";
        }
        if (txtStdContactNo.getText() == null || txtStdContactNo.getText().isEmpty()) {
            errorMessage += "Contact No is required! \n";
        }
        if (txtStdAddress.getText() == null || txtStdAddress.getText().isEmpty()) {
            errorMessage += "Address is required! \n";
        }
        if (txtStdEmail.getText() == null || txtStdEmail.getText().isEmpty()) {
            errorMessage += "Email is required! \n";
        }
        if (dtpStdDateOfBirth.getValue() == null) {
            errorMessage += "Birth date is required! \n";
        }
        if (rdoStdMale.isSelected() && rdoStdFemale.isSelected()) {
            errorMessage += "Select one gender! \n";
        }
        if (!rdoStdMale.isSelected() && !rdoStdFemale.isSelected()) {
            errorMessage += "Select one gender! \n";
        }
        if (txtStdCourse.getText() == null || txtStdCourse.getText().isEmpty()) {
            errorMessage += "Course is required! \n";
        }
        if (txtStdBatch.getText() == null || txtStdBatch.getText().isEmpty()) {
            errorMessage += "Batch is required! \n";
        }
        if (txtStdSemester.getText() == null || txtStdSemester.getText().isEmpty()) {
            errorMessage += "Semester is required! \n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("INVALID FIELDS");
            alert.setHeaderText("Please complete all required fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
    
    private boolean isFieldValidTch() {
        String errorMessage = "";
        if (txtTchFirstName.getText() == null || txtTchFirstName.getText().isEmpty()) {
            errorMessage += "First name is required! \n";
        }
        if (txtTchLasName.getText() == null || txtTchLasName.getText().isEmpty()) {
            errorMessage += "Last name is required! \n";
        }
        if (txtTchRegNo.getText() == null || txtTchRegNo.getText().isEmpty()) {
            errorMessage += "Registration No is required! \n";
        }
        if (txtTchContactNo.getText() == null || txtTchContactNo.getText().isEmpty()) {
            errorMessage += "Contact No is required! \n";
        }
        if (txtTchAddress.getText() == null || txtTchAddress.getText().isEmpty()) {
            errorMessage += "Address is required! \n";
        }
        if (txtTchEmail.getText() == null || txtTchEmail.getText().isEmpty()) {
            errorMessage += "Email is required! \n";
        }
        if (dtpTchDateOfBirth.getValue() == null) {
            errorMessage += "Birth date is required! \n";
        }
        if (rdoTchMale.isSelected() && rdoTchFemale.isSelected()) {
            errorMessage += "Select one gender! \n";
        }
        if (!rdoTchMale.isSelected() && !rdoTchFemale.isSelected()) {
            errorMessage += "Select one gender! \n";
        }
        if (txtTchQualification.getText() == null || txtTchQualification.getText().isEmpty()) {
            errorMessage += "Qualification is required! \n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("INVALID FIELDS");
            alert.setHeaderText("Please complete all required fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
    

}
