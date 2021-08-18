package GOFO;
/**
 * this class to define the information of the play ground
 * @author Loai Gamal
 * @vesion 2-Final
 * @since  1-Draft
 */

public class PlayGround {
    /**
     * this is to define the ground name attribute
     */
    private String groundName;
    /**
     * this is to define the ground location attribute
     */
    private String groundLocation;
    /**
     * this is to define the ground owner id attribute
     */
    private int groundOwnerID;
    /**
     * this is to define the ground size attribute
     */
    private int groundSize;
    /**
     * this is to define the ground price per one hour attribute
     */
    private int pricePerHour;
    /**
     * this is to define cancellation time attribute
     */
    private int cancellationPeriod;
    /**
     * this is to define the available hours on the ground
     */
    private boolean availableHours[][][] = new boolean[12][30][24];
    /**
     * this is to define the activate license
     */
    private boolean activateLicense;

    private int from;

    private int to;

    /**
     * this constructor to define the activate license = false ,util the admin change it
     */
    public PlayGround(){
        this.activateLicense = false;
        from = to = 0;
    }

    /**
     * this is method to get the ground name from owner
     * @return ground name
     */
    public String getGroundName() {
        return groundName;
    }

    /**
     * this is method to set the ground name
     * @param groundName ground name
     */
    public void setGroundName(String groundName) {
        this.groundName = groundName;
    }

    /**
     * this is method to get the ground location from owner
     * @return ground location
     */
    public String getGroundLocation() {
        return groundLocation;
    }

    /**
     * this is method to set the ground location
     * @param groundLocation ground location
     */
    public void setGroundLocation(String groundLocation) {
        this.groundLocation = groundLocation;
    }

    /**
     * this is method to get ground owner id
     * @return ground owner id
     */
    public int getGroundOwnerID() {
        return groundOwnerID;
    }

    /**
     * this is method to set the ground owner email
     * @param groundOwnerMail ground owner email
     */
    public void setGroundOwnerID(int groundOwnerMail) {
        this.groundOwnerID = groundOwnerMail;
    }

    /**
     * this is method to get the ground size
     * @return ground size
     */
    public int getGroundSize() {
        return groundSize;
    }

    /**
     * this method to set ground size
     * @param groundSize  ground size
     */
    public void setGroundSize(int groundSize) {
        this.groundSize = groundSize;
    }

    /**
     * this is method to get the price from the owner
     * @return price of the ground per hour
     */
    public int getPricePerHour() {
        return pricePerHour;
    }

    /**
     * this is method to set the price of the hour in the ground
     * @param pricePerHour price of the ground per hour
     */
    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    /**
     * this is method to get the cancellation time
     * @return cancellation time
     */
    public int getCancellationPeriod() {
        return cancellationPeriod;
    }

    /**
     * this is method to set cancellation time
     * @param cancellationPeriod cancellation time
     */
    public void setCancellationPeriod(int cancellationPeriod) {
        this.cancellationPeriod = cancellationPeriod;
    }

    /**
     * this is method to add available hours in the ground by owner
     * @param from the start of the new period
     * @param to the end of the new period
     */
    public void addAvailableHours(int from, int to) {
        this.from = from;
        this.to = to;
        for(int i=0; i<12; i++){
            for(int j=0; j<30; j++){
                for(int k=from-1; k<to; k++){
                    availableHours[i][j][k] = true;
                }
            }
        }
    }

    /**
     * this is method to show the available hours in the ground
     * @param month month user want to see the available hour on it
     * @param day day user want to see the available hour on it
     */
    public void showAvailableHours(int month, int day){
        boolean check = false;
        for (int i=0; i<24 ;i++){
            if(availableHours[month-1][day-1][i] == true){
                check = true;
                System.out.println("from: " + (i+1) + "  " + "to: " + (i+2));
            }
        }
        if (check == false){
            System.out.println("There is no available hours in this day.");
        }else {
            System.out.println();
        }
    }

    /**
     * method to check if this date is available
     * @param month month that user want to check if there is available hour
     * @param day day that user want to check if there is available hour
     * @param hour day that user want to check if there is available hour
     * @return the data user was enter to the (availableHours)method to check
     */
    public boolean isAvailable(int month, int day, int hour){
        return availableHours[month][day][hour];
    }

    /**
     * this method to book an available hour and delete it from the available hours
     * @param month the month that user want to book the ground on it
     * @param day the day that user want to book the ground on it
     * @param hour the hour that user want to book the ground on it
     */
    public void bookAvailableHour(int month, int day, int hour){
        availableHours[month-1][day-1][hour-1] = false;
    }

    /**
     * this method is to cancel an booked hour and return it again to available hours
     * @param month the month that user want to book the ground on it
     * @param day the day that user want to book the ground on it
     * @param hour the hour that user want to book the ground on it
     */
    public void cancelBookedHour(int month, int day, int hour){
        availableHours[month-1][day-1][hour-1] = true;
    }

    /**
     * this method to check if the ground is activated or not
     * @return active status
     */
    public boolean isActivated() {
        return activateLicense;
    }

    /**
     * method set to give admin right to activate the ground
     * @param admin to take the approve or not from admin
     */
    public void setActivate(Administrator admin) {
        activateLicense = true;
    }

    /**
     * method set to give admin right to Deactivate the ground
     * @param admin to take the approve or not from admin
     */
    public void setDeactivate(Administrator admin){
        activateLicense = false;
    }

    /**
     * method to print the ground information
     */
    public void showGroundInfo(){
        System.out.print("Ground name: " + groundName + "      ");
        System.out.print("Ground Location: " + groundLocation + "       ");
        System.out.print("Ground size: " + groundSize + "       ");
        System.out.print("Price per hour: " + pricePerHour + "       ");
        System.out.println("Owner ID: " + groundOwnerID);
    }

    public void showBookedHours(){
        boolean check = false;
        for(int i=0; i<12; i++){
            for(int j=0; j<30; j++){
                for(int k=(from-1); k<to; k++){
                    if(availableHours[i][j][k] == false){
                        System.out.println("Month: " + (i+1) + " Day: " + (j+1) + " Hour: " + (k+1));
                        check = true;
                    }
                }
            }
        }
        if(check==false){
            System.out.println("There is no booked hours\n");
        }
    }
}
