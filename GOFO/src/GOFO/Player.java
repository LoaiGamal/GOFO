package GOFO;

import java.util.Vector;

/**
 * this class is to store booked hours and it's information
 * @author Ahmed Kadry
 * @vesion 2 FINAL
 * @since  1 DRAFT
 */
class   BookedHours{
    /**
     * to define the ground name attribute
     */
    public String groundName;
    /**
     * to define owner id attribute
     */
    public int ownerID;
    /**
     * to define month attribute
     */
    public int month;
    /**
     * to define day attribute
     */
    public int day;
    /**
     * to define hour attribute
     */
    public int hour;
}
/**
 * this class is to the player he want to book an ground
 * @author Ahmed Kadry
 * @vesion 2 FINAL
 * @since  1 DRAFT
 */
public class Player extends UserInformation {
    /**
     * this is vector to store all bookedHours
     */

    public Vector<BookedHours> bookedHours = new Vector<BookedHours>();
    /**
     * this vector to store all invitations
     */
    private Vector<String> invitations = new Vector <String>();
    public Team team = new Team();

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
    public Player(String firstName, String lastName, String email, String password, String phone, String location, String role){
        super(firstName, lastName, email, password, phone, location, role);
    }

    /**
     * this is method to add booked an hour
     * @param groundName ground name
     * @param ownerID ground owner id
     * @param month month that the ground add to booked hour on it
     * @param day day that the ground add to booked hour on it
     * @param hour  hour that the ground add to booked hour on it
     */
    public void addBookedHour(String groundName, int ownerID, int month, int day, int hour){
        BookedHours bookingHour = new BookedHours();
        bookingHour.groundName = groundName;
        bookingHour.ownerID = ownerID;
        bookingHour.month = month;
        bookingHour.day = day;
        bookingHour.hour = hour;
        bookedHours.add(bookingHour);
    }

    /**
     * this is method to show to the player the booked hours
     */
    public void showBookedHours(){
        if(bookedHours.isEmpty()){
            System.out.println("There is no booked hours.");
        }else{
            for(int i=0; i<bookedHours.size(); i++){
                System.out.println(i+1 + "-" + "      " + "Ground name: " + bookedHours.get(i).groundName + "      " + "Owner ID: " + bookedHours.get(i).ownerID + "      " + "Day: " + bookedHours.get(i).day + "    " + "hour: " + bookedHours.get(i).hour);
            }
        }
    }

    /**
     * this method is to know if the ground is booked or not
     * @param groundName ground name
     * @param ownerID ground ower id
     * @param month month that the user need to know if the ground booked or not
     * @param day day that the user need to know if the ground booked or not
     * @param hour hour that the user need to know if the ground booked or not
     * @return the answer about this question
     */
    public boolean isBooked(String groundName, int ownerID, int month, int day, int hour){
        for(int i=0; i<bookedHours.size();i++){
            if(bookedHours.get(i).groundName.equalsIgnoreCase(groundName) && bookedHours.get(i).ownerID == ownerID && bookedHours.get(i).month == month && bookedHours.get(i).day == day && bookedHours.get(i).hour == hour){
                return true;
            }
        }
        return false;
    }

    /**
     * this method is to cancel an booked hour and remove it from booked hours
     * @param groundName ground name
     * @param ownerID ground owner id
     * @param month month that the user want to cancel an booking
     * @param day day that the user want to cancel an booking
     * @param hour hour that the user want to cancel an booking
     */
    public void cancelBookedHour(String groundName, int ownerID, int month, int day, int hour){
        for(int i=0; i<bookedHours.size();i++){
            if(bookedHours.get(i).groundName.equalsIgnoreCase(groundName) && bookedHours.get(i).ownerID == ownerID && bookedHours.get(i).month == month && bookedHours.get(i).day == day && bookedHours.get(i).hour == hour){
                bookedHours.remove(i);
                break;
            }
        }
    }

    /**
     * this is method to add new team
     * @param name name of the new team
     */
    public void addTeam(String name){
        team.setTeamName(name);
        team.setTeamLeaderID(getID());
    }

    /**
     * method to send an invite
     * @param invitation invite that the user want to send by mail
     */
    public void addInvite(String invitation){
        invitations.add(invitation);
    }

    /**
     * method to know if i have an invitations
     */
    public void showInvitations(){
        if(invitations.isEmpty()){
            System.out.println("You have no invitations \n");
        }else{
            for(int i=0; i<invitations.size(); i++){
                System.out.println((i+1) + "-  " + invitations.get(i));
            }
        }
    }

}
