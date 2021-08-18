package GOFO;

import java.util.Scanner;
/**
 * this class to define the information of the ground owner
 * @author Loai Gamal
 * @vesion 2-Final
 * @since  1-Draft
 */

public class GroundOwner extends UserInformation {
    private int eWallet;
    public PlayGround ground = new PlayGround();

    /**
     * this is constructor to define the attributes in admin class
     * @param firstName ground owner first name
     * @param lastName ground owner  last name
     * @param email ground owner   mail
     * @param password ground owner  password
     * @param phone ground owner  phone
     * @param location ground owner  location
     * @param role attribute to take the role of the user
     */
    public GroundOwner(String firstName, String lastName, String email, String password, String phone, String location, String role){
        super(firstName, lastName, email, password, phone, location, role);
        eWallet=0;
    }

    /**
     * this method that get to the ground owner to registration his ground
     * @param ground this is object from class playground
     */
    public void groundRegistration(PlayGround ground){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter ground's name: ");
        String groundName = input.nextLine();
        ground.setGroundName(groundName);
        System.out.print("Please enter ground's location: ");
        String groundLocation = input.nextLine();
        ground.setGroundLocation(groundLocation);
        ground.setGroundOwnerID(getID());
        System.out.print("Please enter ground's size: ");
        int groundSize = input.nextInt();
        ground.setGroundSize(groundSize);
        System.out.print("Please enter price per hour: ");
        int pricePerHour = input.nextInt();
        ground.setPricePerHour(pricePerHour);
        System.out.print("Please enter cancellation period: ");
        int cancellationPeriod = input.nextInt();
        ground.setCancellationPeriod(cancellationPeriod);
        System.out.print("Please enter the period of available hours\nfrom: ");
        int from = input.nextInt();
        System.out.print("to: ");
        int to = input.nextInt();
        ground.addAvailableHours(from,to);
    }

    /**
     * this method that get the owner access to update the time in his ground
     * @param from the start of time
     * @param to the end of time
     */
    public void updateAvailableTime(int from, int to){
        ground.addAvailableHours(from,to);
    }

    public void showBookedHours(){
        ground.showBookedHours();
    }

    public void seteWallet(int cash){
        eWallet+=cash;
    }
    public void returnMoney(int cash){
        eWallet-=cash;
    }
    public int geteWallet(){
        return eWallet;
    }
}
