package com.sms.api.services;

import com.sms.api.entity.Admin;
import com.sms.api.entity.Student;
import com.sms.api.entity.Teacher;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/*  GROUP 1 - UoB Feb 2020
 *  Rajeenthiran Thangenthiran  - 1940909 - Student
 *  Anand Sripathmathasan       - 1939890 - Teacher
 *  Miluckshan Jalangan         - 1940857 - Admin
 */

public interface Services extends Remote {
    
    /*------------------------------*/
    /*  Cookie methods starts here  */
    /*------------------------------*/
    
    /* To login to the system */
    public String login(String username, String password) throws RemoteException; 
    
    /* To logout of the system */
    public String logout(String cookie) throws RemoteException; 
    
    /* To remember the current user of the user*/
    public String rememberMe(String cookie) throws RemoteException; 
    
    /*-------------------------------*/
    /*  Student methods starts here  */
    /*-------------------------------*/
    
    /* To insert a student */
    public Student insertStudent(Student student) throws RemoteException;

    /* To update a student */
    public void updateStudent(Student student) throws RemoteException;

    /* To delete a student */
    public void deleteStudent(Long id) throws RemoteException;

    /* To get a student by id */
    public Student getStudentById(Long id) throws RemoteException;

    /* To get all students */
    public List<Student> getAllStudent() throws RemoteException;
    
    /*-------------------------------*/
    /*  Teacher methods starts here  */
    /*-------------------------------*/
    
    /* To insert a teacher */
    public Teacher insertTeacher(Teacher teacher) throws RemoteException;

    /* To update a teacher */
    public void updateTeacher(Teacher teacher) throws RemoteException;

    /* To delete a teacher */
    public void deleteTeacher(Long id) throws RemoteException;

    /* To get a teacher by id */
    public Teacher getTeacherById(Long id) throws RemoteException;

    /* To get all teachers */
    public List<Teacher> getAllTeacher() throws RemoteException;
    
    /*-----------------------------*/
    /*  Admin methods starts here  */
    /*-----------------------------*/
    
    /* To insert a admin */
    public Admin insertAdmin(Admin admin) throws RemoteException;

    /* To update a admin */
    public void updateAdmin(Admin admin) throws RemoteException;

    /* To delete a admin */
    public void deleteAdmin(Long id) throws RemoteException;

    /* To get a student by id */
    public Admin getAdminById(Long id) throws RemoteException;

    /* To get all admins */
    public List<Admin> getAllAdmin() throws RemoteException;
    
}
