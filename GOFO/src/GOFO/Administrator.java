package GOFO;

import java.util.Vector;
/**
 * this class to represent the complaint   method of administrator in the program
 * @author Mohamed Essam
 * @vesion 2-final
 * @since  1-draft
 */


class Complaint{
    public String groundName;
    public int groundOwnerID;
    public String complaint;
    Complaint(){}
}
/**
 * this class to represent the order and methods of administrator in the program
 * @author Mohamed Essam
 * @vesion 2-final
 * @since  1-draft
 */


public class Administrator extends UserInformation {
    /**
     * this is vector to take all complaint and store it
     */
    private Vector<Complaint> complaints = new Vector<Complaint>();

    /**
     * this is constructor to define the attributes in admin class
     * @param firstName admin first name
     * @param lastName admin last name
     * @param email admin  mail
     * @param password admin password
     * @param phone admin phone
     * @param location admin location
     * @param role attribute to take the role by default is (admin)
     */

    public Administrator(String firstName, String lastName, String email, String password, String phone, String location, String role){
        super(firstName, lastName, email, password, phone, location, role);
    }

    /**
     * mthod to give user access to add complaint
     * @param groundName play ground name that the complaint on it
     * @param groundOwnerID play ground owner id that the complaint on it
     * @param complaint the filed that user can write the complaint
     */
    public void addComplaint(String groundName, int groundOwnerID, String complaint){
        Complaint comp = new Complaint();
        comp.groundName = groundName;
        comp.groundOwnerID = groundOwnerID;
        comp.complaint = complaint;
        complaints.add(comp);
    }

    /**
     * method to show all complaints the admin have
     */
    public void showComplaints(){
        if(complaints.isEmpty()){
            System.out.println("There is no complaints.");
        }else{
            for(int i=0; i<complaints.size(); i++){
                System.out.println(i+1 + "-" + "      " + "Ground Name: " + complaints.get(i).groundName + "      " + "Ground owner ID: " + complaints.get(i).groundOwnerID + "      " + "Complaint: " + complaints.get(i).complaint);
            }
        }
    }
}
