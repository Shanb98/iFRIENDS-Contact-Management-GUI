import java.time.LocalDate;
import java.util.*;
public class CustomerController{
    public static boolean addCustomer(Customer customer){
        CustomerList customerList=DBConnection.getInstance().getCustomerList();
        customerList.add(customer);
        return true;
    }
    public static String lastId(){
        CustomerList customerList=DBConnection.getInstance().getCustomerList();
        String[] idArray=new String[customerList.size()];
        for (int i = 0; i < customerList.size(); i++){
            idArray[i]=customerList.get(i).getReturnedID();
        }
        Arrays.sort(idArray);
        return idArray.length== 0 ? null : idArray[idArray.length-1];
    }
    public static Customer searchCustomer(String name){
        CustomerList customerList = DBConnection.getInstance().getCustomerList();
        for (int i = 0; i < customerList.size(); i++) {
            Customer customer = customerList.get(i);
            if (name.equalsIgnoreCase(customer.getName())||name.equalsIgnoreCase(customer.getPhone())) {
                return customer;
            }
        }
        return null;
    }
    public static boolean updateCustomer(Customer customer) {
        CustomerList customerList = DBConnection.getInstance().getCustomerList();
        for (int i = 0; i < customerList.size(); i++) {
            Customer existingCustomer = customerList.get(i);
            if (existingCustomer.getReturnedID().equalsIgnoreCase(customer.getReturnedID())) {
                customerList.remove(i);
                customerList.add(i, customer);
                return true;
            }
        }
        return false;
    }
    public static boolean deleteCustomer(Customer customer) {
        CustomerList customerList = DBConnection.getInstance().getCustomerList();
        for (int i = 0; i < customerList.size(); i++) {
            Customer existingCustomer = customerList.get(i);
            if (existingCustomer.getName().equalsIgnoreCase(customer.getName())) {
                customerList.remove(i);
                return true;
            }
        }
        return false;
    }
    public static boolean subi(String phone) {
        String[] d = {"70", "71", "72", "74", "75", "76", "77", "78", "11", "36", "31", "33", "38", "34", "81", "54", "51", "52", "66", "91", "41", "47", "21", "23", "24", "63", "65", "67", "26", "25", "27", "32", "37", "55", "57", "45", "35", "769"};
        String sub = phone.substring(1, 3);
        for (int i = 0; i < d.length; i++) {
            if (sub.equals(d[i])) {
                return false;
            }
        }
        return true;
    }
    public static boolean subii2(String salary){
        int length = salary.length();
        for(int i=0;i<length;i++){
            int x=(int)salary.charAt(i);
            if(x < 48 || x > 57){
                return true;
            }
        }return false;
    }
    public static boolean Enter_bday(String bday){
        boolean isValid = false;
        LocalDate localDate = LocalDate.now();
        String date = localDate.toString();

        String byear = bday.substring(0, 4);
        int birth_year= StrToInt(byear);
        String cyear = date.substring(0, 4);
        int current_year= StrToInt(cyear);

        String bmonth = bday.substring(5,7);
        int birth_month= StrToInt(bmonth);
        String cmonth = date.substring(5,7);
        int current_month= StrToInt(cmonth);

        String bdate = bday.substring(8,10);
        int birth_date = StrToInt(bdate);
        String cdate = date.substring(5,7);
        int current_date= StrToInt(cdate);

        if (bday.length() != 10 || bday.charAt(4) != '-' || bday.charAt(7) != '-') {return isValid=true;}
        else if(birth_year>current_year && birth_year<1800){return isValid=true;}
        else if(birth_month>current_month && birth_month>13){return isValid=true;}
        else if((birth_year%4)==0 && birth_month==2 && birth_date>30){return isValid=true;}
        else if((birth_year%4)!=0 && birth_month==2 && birth_date>29){return isValid=true;}
        else if((birth_month==1||birth_month==3||birth_month==5||birth_month==7||birth_month==8||birth_month==10||birth_month==12)&& birth_date>32){return isValid=true;}
        else if((birth_month==4||birth_month==6||birth_month==9||birth_month==11)&& birth_date>31){return isValid=true;}
        return isValid ;
    }
    public static int StrToInt(String sub){
        int total =0;
        for(int i=0;i<sub.length();i++) {
            int x = (int) sub.charAt(i);
            switch (x) {
                case 48:
                    total = (total * 10) + 0;
                    break;
                case 49:
                    total = (total * 10) + 1;
                    break;
                case 50:
                    total = (total * 10) + 2;
                    break;
                case 51:
                    total = (total * 10) + 3;
                    break;
                case 52:
                    total = (total * 10) + 4;
                    break;
                case 53:
                    total = (total * 10) + 5;
                    break;
                case 54:
                    total = (total * 10) + 6;
                    break;
                case 55:
                    total = (total * 10) + 7;
                    break;
                case 56:
                    total = (total * 10) + 8;
                    break;
                case 57:
                    total = (total * 10) + 9;
                    break;
            }
        }
        return total;
    }
    public static Customer[] getAllCustomer(){
        CustomerList customerList=DBConnection.getInstance().getCustomerList();
        return customerList.toArray();
    }
    public static Customer[] getAllCustomerSortBySalary(){
        CustomerList customerList=DBConnection.getInstance().getCustomerList();
        Customer[] customerArray=customerList.toArray();
        for (int i = 1; i < customerArray.length; i++){
            for(int j=0; j<customerArray.length-i; j++){
                if(Float.parseFloat(customerArray[j].getSalary()) > Float.parseFloat(customerArray[j + 1].getSalary())){
                    Customer tempCustomer=customerArray[j];
                    customerArray[j]=customerArray[j+1];
                    customerArray[j+1]=tempCustomer;
                }
            }
        }
        return customerArray;
    }
    public static Customer[] getAllCustomerSortByName() {
        CustomerList customerList = DBConnection.getInstance().getCustomerList();
        Customer[] customerArray = customerList.toArray();
        for (int i = 1; i < customerArray.length; i++) {
            for (int j = 0; j < customerArray.length - i; j++) {
                if (customerArray[j].getName().compareTo(customerArray[j + 1].getName()) > 0) {
                    Customer tempCustomer = customerArray[j];
                    customerArray[j] = customerArray[j + 1];
                    customerArray[j + 1] = tempCustomer;
                }
            }
        }
        return customerArray;
    }
    public static Customer[] getAllCustomerSortByBday() {
        CustomerList customerList = DBConnection.getInstance().getCustomerList();
        Customer[] customerArray = customerList.toArray();
        for (int i = 1; i < customerArray.length; i++) {
            for (int j = 0; j < customerArray.length - i; j++) {
                if (customerArray[j].getBday().compareTo(customerArray[j + 1].getBday()) > 0) {
                    Customer tempCustomer = customerArray[j];
                    customerArray[j] = customerArray[j + 1];
                    customerArray[j + 1] = tempCustomer;
                }
            }
        }
        return customerArray;
    }


}
