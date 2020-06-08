package com.sms.api.entity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.LocalDate;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/* GROUP 1 - UoB Feb 2020
 * Rajeenthiran Thangenthiran  - 1940909
 */

public class Student implements Externalizable{

    private final LongProperty id = new SimpleLongProperty();
    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty lastName = new SimpleStringProperty();
    private final StringProperty regNo = new SimpleStringProperty();
    private final StringProperty contactNo = new SimpleStringProperty();
    private final StringProperty address = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> dateOfBirth = new SimpleObjectProperty<>();
    private final StringProperty gender = new SimpleStringProperty();
    private final StringProperty course = new SimpleStringProperty();
    private final StringProperty batch = new SimpleStringProperty();
    private final StringProperty semester = new SimpleStringProperty();

    public long getId() {
        return id.get();
    }

    public void setId(long value) {
        id.set(value);
    }

    public LongProperty idProperty() {
        return id;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String value) {
        firstName.set(value);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String value) {
        lastName.set(value);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getRegNo() {
        return regNo.get();
    }

    public void setRegNo(String value) {
        regNo.set(value);
    }

    public StringProperty regNoProperty() {
        return regNo;
    }

    public String getContactNo() {
        return contactNo.get();
    }

    public void setContactNo(String value) {
        contactNo.set(value);
    }

    public StringProperty contactNoProperty() {
        return contactNo;
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String value) {
        address.set(value);
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String value) {
        email.set(value);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth.get();
    }

    public void setDateOfBirth(LocalDate value) {
        dateOfBirth.set(value);
    }

    public ObjectProperty dateOfBirthProperty() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String value) {
        gender.set(value);
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public String getCourse() {
        return course.get();
    }

    public void setCourse(String value) {
        course.set(value);
    }

    public StringProperty courseProperty() {
        return course;
    }

    public String getBatch() {
        return batch.get();
    }

    public void setBatch(String value) {
        batch.set(value);
    }

    public StringProperty batchProperty() {
        return batch;
    }

    public String getSemester() {
        return semester.get();
    }

    public void setSemester(String value) {
        semester.set(value);
    }

    public StringProperty semesterProperty() {
        return semester;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeLong(getId());
        out.writeObject(getFirstName());
        out.writeObject(getLastName());
        out.writeObject(getRegNo());
        out.writeObject(getContactNo());
        out.writeObject(getAddress());
        out.writeObject(getEmail());
        out.writeObject(getDateOfBirth());
        out.writeObject(getGender());
        out.writeObject(getCourse());
        out.writeObject(getBatch());
        out.writeObject(getSemester());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setId(in.readLong());
        setFirstName((String) in.readObject());
        setLastName((String) in.readObject());
        setRegNo((String) in.readObject());
        setContactNo((String) in.readObject());
        setAddress((String) in.readObject());
        setEmail((String) in.readObject());
        setDateOfBirth((LocalDate) in.readObject());
        setGender((String) in.readObject());
        setCourse((String) in.readObject());
        setBatch((String) in.readObject());
        setSemester((String) in.readObject());
    }

}
