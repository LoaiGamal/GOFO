package GOFO;


import java.util.ArrayList;
import java.util.Scanner;
/**
 * this class to take information from any user (admin - player - play ground owner)
 * @author Amira Mosaad
 * @version 2
 * @since  1
 */

public class UserInformation {
    /**
     * this is to define first id by 0
     */
    private static int id = -1;
    /**
     * this is to define the first name
     */
    protected String firstName;
    /**
     * this is to define the last name attribute
     */
    protected String lastName;
    /**
     * this is to define the id attribute
     */
    protected int ID;
    /**
     * this is to define the email attribute
     */
    protected String email;
    /**
     * this is to define the password attribute
     */
    protected String password;
    /**
     * this is to define the phone number attribute
     */
    protected String phone;
    /**
     * this is to define the locatiom attribute
     */
    protected String location;
    /**
     * this is to define the role attribute
     */
    protected String role;

    /**
     * this is a constructor to make a counter to the ids of users
     */
    public  UserInformation(){
        id++;
        this.ID = id;
    }

    /**
     * this is the constructor to define the attributes of this class
     * @param firstName user first name
     * @param lastName user last name
     * @param email user mail
     * @param password user password
     * @param phone user phone
     * @param location user location
     * @param role user role(player OR play ground owner)
     */
    public UserInformation(String firstName, String lastName, String email, String password, String phone, String location, String role){
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.location = location;
        this.role = role;
        id++;
        this.ID = id;
    }

    /**
     * method to get first name from user
     * @return first nmae
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * method to set the first name
     * @param firstName user first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * method to get the last name
     * @return user last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * method to set last name
     * @param lastName user last name
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * method to get user id
     * @return user id
     */
    public int getID() {
        return ID;
    }

    /**
     * method to get user email
     * @return user email
     */
    public String getEmail() {
        return email;
    }

    /**
     * method to set user email
     * @param email user email
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *method to get password from user
     * @return user password
     */
    public String getPassword() {
        return password;
    }

    /**
     * method to set user password
     * @param password user password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * method to get user phone
     * @return user phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * method to set user phone
     * @param phone user phone number
     */
    public void setPhone(String phone) {
        phone = phone;
    }

    /**
     * method to get user location
     * @return user location
     */
    public String getLocation() {
        return location;
    }

    /**
     * method to ser user location
     * @param location user location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * method to get user role
     * @return user role
     */

    public String getRole() {
        return role;
    }

    /**
     * method to set user role
     * @param role user role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * method to print user information
     */
    public void showInfo(){
        System.out.print("\n \nName: " + firstName + " " + lastName + "      ");
        System.out.print("ID: " + ID + "       ");
        System.out.print("Email: " + email + "       ");
        System.out.println("Role: " + role);
    }
}