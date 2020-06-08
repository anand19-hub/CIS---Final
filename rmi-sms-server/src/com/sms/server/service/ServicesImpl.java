package com.sms.server.service;

import com.sms.api.entity.Admin;
import com.sms.api.entity.Student;
import com.sms.api.entity.Teacher;
import com.sms.server.utilities.DatabaseConnection;
import com.sms.api.services.Services;
import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*  GROUP 1 - UoB Feb 2020
 *  Rajeenthiran Thangenthiran  - 1940909 - Student
 *  Anand Sripathmathasan       - 1939890 - Teacher
 *  Miluckshan Jalangan         - 1940857 - Admin
 */
public class ServicesImpl extends UnicastRemoteObject implements Services {

    private String myUsername = "un123";
    private String myPassword = "pw123";
    private String sessionCookie = "" + Math.random();
    private String lastIPUsed = "Null IP";

    public ServicesImpl() throws RemoteException {
    }

    /*---------------------------------------------*/
    /*  Cookie methods implementation starts here  */
    /*---------------------------------------------*/
    
    @Override
    public String login(String username, String password) throws RemoteException {
        if (username.equals(myUsername) && password.equals(myPassword)) {
            try {
                lastIPUsed = RemoteServer.getClientHost();
            } catch (ServerNotActiveException e) {
                e.printStackTrace();
            }
            sessionCookie = "Cookie_" + Math.random();
            return sessionCookie;
        } else {
            return "Wrong credentials";
        }
    }

    @Override
    public String logout(String cookie) throws RemoteException {
        myUsername="";
        myPassword="";
        return null;
    }

    @Override
    public String rememberMe(String cookie) throws RemoteException {
        if (cookie.equals(sessionCookie)) {
            try {
                String thisIPUsed = RemoteServer.getClientHost();
                if (thisIPUsed.equals(lastIPUsed)) {
                    lastIPUsed = thisIPUsed;
                } else {
                    return "IP Mismatch";
                }
            } catch (ServerNotActiveException e) {
                e.printStackTrace();
            }
            return "Success";
        } else {
            return "Logged out";
        }
    }

    /*----------------------------------------------*/
    /*  Student methods implementation starts here  */
    /*----------------------------------------------*/
    
    @Override
    public Student insertStudent(Student student) throws RemoteException {
        PreparedStatement statement = null;
        String sql = "insert into student(id, first_name, last_name, reg_no, contact_no, address, email, date_of_birth, gender, course, batch, semester) values(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getRegNo());
            statement.setString(4, student.getContactNo());
            statement.setString(5, student.getAddress());
            statement.setString(6, student.getEmail());
            statement.setDate(7, Date.valueOf(student.getDateOfBirth().toString()));
            statement.setString(8, student.getGender());
            statement.setString(9, student.getCourse());
            statement.setString(10, student.getBatch());
            statement.setString(11, student.getSemester());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                student.setId(result.getLong(1));
            }
            result.close();
            return student;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void updateStudent(Student student) throws RemoteException {
        PreparedStatement statement = null;
        String sql = "update student set first_name = ?, last_name = ?, reg_no = ?, contact_no = ?, address = ?, email = ?, date_of_birth = ?, gender = ?, course = ?, batch = ?, semester = ? where id = ?";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getRegNo());
            statement.setString(4, student.getContactNo());
            statement.setString(5, student.getAddress());
            statement.setString(6, student.getEmail());
            statement.setDate(7, Date.valueOf(student.getDateOfBirth().toString()));
            statement.setString(8, student.getGender());
            statement.setString(9, student.getCourse());
            statement.setString(10, student.getBatch());
            statement.setString(11, student.getSemester());
            statement.setLong(12, student.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deleteStudent(Long id) throws RemoteException {
        PreparedStatement statement = null;
        String sql = "delete from student where id = ?";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public Student getStudentById(Long id) throws RemoteException {
        PreparedStatement statement = null;
        String sql = "select * from student where id = ?";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            Student student = null;
            if (result.next()) {
                student = new Student();
                student.setId(result.getLong("id"));
                student.setFirstName(result.getString("first_name"));
                student.setLastName(result.getString("last_name"));
                student.setRegNo(result.getString("reg_no"));
                student.setContactNo(result.getString("contact_no"));
                student.setAddress(result.getString("address"));
                student.setEmail(result.getString("email"));
                student.setDateOfBirth(LocalDate.parse(result.getDate("date_of_birth").toString()));
                student.setGender(result.getString("gender"));
                student.setCourse(result.getString("course"));
                student.setBatch(result.getString("batch"));
                student.setSemester(result.getString("semester"));
            }
            result.close();
            return student;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Student> getAllStudent() throws RemoteException {
        Statement statement = null;
        String sql = "select * from student";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);
            List<Student> list = new ArrayList<Student>();
            while (result.next()) {
                Student student = new Student();
                student.setId(result.getLong("id"));
                student.setFirstName(result.getString("first_name"));
                student.setLastName(result.getString("last_name"));
                student.setRegNo(result.getString("reg_no"));
                student.setContactNo(result.getString("contact_no"));
                student.setAddress(result.getString("address"));
                student.setEmail(result.getString("email"));
                student.setDateOfBirth(LocalDate.parse(result.getDate("date_of_birth").toString()));
                student.setGender(result.getString("gender"));
                student.setCourse(result.getString("course"));
                student.setBatch(result.getString("batch"));
                student.setSemester(result.getString("semester"));
                list.add(student);
            }
            result.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /*----------------------------------------------*/
    /*  Teacher methods implementation starts here  */
    /*----------------------------------------------*/
    
    @Override
    public Teacher insertTeacher(Teacher teacher) throws RemoteException {
        PreparedStatement statement = null;
        String sql = "insert into teacher(id, first_name, last_name, reg_no, contact_no, address, email, date_of_birth, gender, qualification) values(null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, teacher.getFirstName());
            statement.setString(2, teacher.getLastName());
            statement.setString(3, teacher.getRegNo());
            statement.setString(4, teacher.getContactNo());
            statement.setString(5, teacher.getAddress());
            statement.setString(6, teacher.getEmail());
            statement.setDate(7, Date.valueOf(teacher.getDateOfBirth().toString()));
            statement.setString(8, teacher.getGender());
            statement.setString(9, teacher.getQualification());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                teacher.setId(result.getLong(1));
            }
            result.close();
            return teacher;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void updateTeacher(Teacher teacher) throws RemoteException {
        PreparedStatement statement = null;
        String sql = "update teacher set first_name = ?, last_name = ?, reg_no = ?, contact_no = ?, address = ?, email = ?, date_of_birth = ?, gender = ?, qualification = ? where id = ?";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);
            statement.setString(1, teacher.getFirstName());
            statement.setString(2, teacher.getLastName());
            statement.setString(3, teacher.getRegNo());
            statement.setString(4, teacher.getContactNo());
            statement.setString(5, teacher.getAddress());
            statement.setString(6, teacher.getEmail());
            statement.setDate(7, Date.valueOf(teacher.getDateOfBirth().toString()));
            statement.setString(8, teacher.getGender());
            statement.setString(9, teacher.getQualification());
            statement.setLong(10, teacher.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deleteTeacher(Long id) throws RemoteException {
        PreparedStatement statement = null;
        String sql = "delete from teacher where id = ?";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public Teacher getTeacherById(Long id) throws RemoteException {
        PreparedStatement statement = null;
        String sql = "select * from teacher where id = ?";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            Teacher teacher = null;
            if (result.next()) {
                teacher = new Teacher();
                teacher.setId(result.getLong("id"));
                teacher.setFirstName(result.getString("first_name"));
                teacher.setLastName(result.getString("last_name"));
                teacher.setRegNo(result.getString("reg_no"));
                teacher.setContactNo(result.getString("contact_no"));
                teacher.setAddress(result.getString("address"));
                teacher.setEmail(result.getString("email"));
                teacher.setDateOfBirth(LocalDate.parse(result.getDate("date_of_birth").toString()));
                teacher.setGender(result.getString("gender"));
                teacher.setQualification(result.getString("qualification"));
            }
            result.close();
            return teacher;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Teacher> getAllTeacher() throws RemoteException {
        Statement statement = null;
        String sql = "select * from teacher";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);
            List<Teacher> list = new ArrayList<Teacher>();
            while (result.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(result.getLong("id"));
                teacher.setFirstName(result.getString("first_name"));
                teacher.setLastName(result.getString("last_name"));
                teacher.setRegNo(result.getString("reg_no"));
                teacher.setContactNo(result.getString("contact_no"));
                teacher.setAddress(result.getString("address"));
                teacher.setEmail(result.getString("email"));
                teacher.setDateOfBirth(LocalDate.parse(result.getDate("date_of_birth").toString()));
                teacher.setGender(result.getString("gender"));
                teacher.setQualification(result.getString("qualification"));
                list.add(teacher);
            }
            result.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /*--------------------------------------------*/
    /*  Admin methods implementation starts here  */
    /*--------------------------------------------*/
    
    @Override
    public Admin insertAdmin(Admin admin) throws RemoteException {
        PreparedStatement statement = null;
        String sql = "insert into admin (id, first_name, last_name, reg_no, contact_no, address, email, date_of_birth, gender, job_role) values(null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, admin.getFirstName());
            statement.setString(2, admin.getLastName());
            statement.setString(3, admin.getRegNo());
            statement.setString(4, admin.getContactNo());
            statement.setString(5, admin.getAddress());
            statement.setString(6, admin.getEmail());
            statement.setDate(7, Date.valueOf(admin.getDateOfBirth().toString()));
            statement.setString(8, admin.getGender());
            statement.setString(9, admin.getJobRole());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                admin.setId(result.getLong(1));
            }
            result.close();
            return admin;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void updateAdmin(Admin admin) throws RemoteException {
        PreparedStatement statement = null;
        String sql = "update admin set first_name = ?, last_name = ?, reg_no = ?, contact_no = ?, address = ?, email = ?, date_of_birth = ?, gender = ?, job_role = ? where id = ?";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);
            statement.setString(1, admin.getFirstName());
            statement.setString(2, admin.getLastName());
            statement.setString(3, admin.getRegNo());
            statement.setString(4, admin.getContactNo());
            statement.setString(5, admin.getAddress());
            statement.setString(6, admin.getEmail());
            statement.setDate(7, Date.valueOf(admin.getDateOfBirth().toString()));
            statement.setString(8, admin.getGender());
            statement.setString(9, admin.getJobRole());
            statement.setLong(10, admin.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deleteAdmin(Long id) throws RemoteException {
        PreparedStatement statement = null;
        String sql = "delete from admin where id = ?";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public Admin getAdminById(Long id) throws RemoteException {
        PreparedStatement statement = null;
        String sql = "select * from admin where id = ?";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();

            Admin admin = null;
            if (result.next()) {
                admin = new Admin();
                admin.setId(result.getLong("id"));
                admin.setFirstName(result.getString("first_name"));
                admin.setLastName(result.getString("last_name"));
                admin.setRegNo(result.getString("reg_no"));
                admin.setContactNo(result.getString("contact_no"));
                admin.setAddress(result.getString("address"));
                admin.setEmail(result.getString("email"));
                admin.setDateOfBirth(LocalDate.parse(result.getDate("date_of_birth").toString()));
                admin.setGender(result.getString("gender"));
                admin.setJobRole(result.getString("job_role"));
            }
            result.close();
            return admin;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Admin> getAllAdmin() throws RemoteException {
        Statement statement = null;
        String sql = "select * from admin";
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);
            List<Admin> list = new ArrayList<Admin>();
            while (result.next()) {
                Admin admin = new Admin();
                admin.setId(result.getLong("id"));
                admin.setFirstName(result.getString("first_name"));
                admin.setLastName(result.getString("last_name"));
                admin.setRegNo(result.getString("reg_no"));
                admin.setContactNo(result.getString("contact_no"));
                admin.setAddress(result.getString("address"));
                admin.setEmail(result.getString("email"));
                admin.setDateOfBirth(LocalDate.parse(result.getDate("date_of_birth").toString()));
                admin.setGender(result.getString("gender"));
                admin.setJobRole(result.getString("job_role"));
                list.add(admin);
            }
            result.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
