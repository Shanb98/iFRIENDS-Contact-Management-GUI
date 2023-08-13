import java.time.LocalDate;
import java.util.*;
public class Customer {
    private String returnedID;
    private String name;
    private String phone;
    private String company;
    private String salary;
    private String bday;
    public Customer(String returnedID, String name ,String phone,String company,String salary, String bday){
        this.returnedID=returnedID;
        this.name=name;
        this.phone=phone;
        this.company=company;
        this.salary=salary;
        this.bday=bday;
    }
    public String  getReturnedID(){
        return returnedID;
    }
    public String getName(){
        return name;
    }
    public String getPhone(){
        return phone;
    }
    public String getCompany(){
        return company;
    }
    public String getSalary(){
        return salary;
    }
    public String getBday(){
        return bday;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public void setCompany(String company){
        this.company=company;
    }
    public void setSalary(String salary){
        this.salary=salary;
    }
    public void setBday(String bday){
        this.bday=bday;
    }
    public void setReturnedID(String returnedID){this.returnedID=returnedID;}

    public boolean equals(Customer customer){
        return this.returnedID.equalsIgnoreCase(customer.returnedID);
    }
}
