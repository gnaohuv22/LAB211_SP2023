/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

/**
 *
 * @author hoang
 */
public class Employee {
    //Work as Model
    private int id;
    private double salary;
    private String firstName, lastName, phone, email, address, DoB, sex, egency;
    
    public Employee() {}

    public Employee(int id, double salary, String firstName, String lastName, String phone, String email, String address, String DoB, String sex, String egency) {
        this.id = id;
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.DoB = DoB;
        this.sex = sex;
        this.egency = egency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(String DoB) {
        this.DoB = DoB;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEgency() {
        return egency;
    }

    public void setEgency(String egency) {
        this.egency = egency;
    }    
    
    @Override
    public String toString()
    {
        return String.format("%3s%10s%10s%15s%30s%20s%15s%10s%10s%10s", this.getId(), this.getFirstName(), this.getLastName(),
                                                                         this.getPhone(), this.getEmail(), this.getAddress(), 
                                                                         this.getDoB(), this.getSex(), this.getSalary(), this.getEgency());
    }
}
