/**
 * this is the main for the project(GOFO)
 */
package GOFO;

import java.util.Scanner;
import java.util.Vector;

/**
 * this is main to test all cases in the system
 * @author Loai Gamal , Ahmed Kadry , Amira Mosaad, Mohamed Essam
 * @version 2 Final
 * @since 1 Draft
 */

public class Main {
    public static Player player;
    public static Player member;
    public static GroundOwner owner;
    public static PlayGround ground;
    public static Team team;
    public static Administrator admin = new Administrator("Admin","Admin","admin@gmail.com","admin","011111111111","Cairo","Administrator");
    public static Vector<Player> players = new Vector<Player>();
    public static Vector<GroundOwner> owners = new Vector<GroundOwner>();
    public static Vector<PlayGround> grounds = new Vector<PlayGround>();
    public static Vector<UserInformation> users = new Vector<UserInformation>();
    public static Vector<Team> teams = new Vector<Team>();

    /**
     * menu to give user interface to used the program
     */
    public static void mainMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println(" \n \t \t \t \t Welcome to football application \n ");
        System.out.println("1- Register\n");
        System.out.println("2- Login\n");
        System.out.println("3- Exit\n");
        System.out.print("Your choice: ");
        int choice = input.nextInt();
        if(choice == 1){
            registration();
        }else if(choice == 2){
            System.out.println("\n");
            login();
        }else if(choice == 3){
            System.exit(0);
        }else{
            System.out.println("You entered wrong choice ... please enter a number [1, 2 or 3]");
        }
    }

    /**
     * method to give the new user make registration in the system
     */
    public static void registration(){
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your first name: ");
        String firstName = input.nextLine();
        System.out.print("Please enter your last name: ");
        String lastName = input.nextLine();
        System.out.print("Please enter your email: ");
        String email = input.nextLine();
        while(true){
            if (isMailTrue(email)==true){
                break;
            }else{
                System.out.println("The email you entered is wrong.");
                System.out.print("Please enter your email again: ");
                email = input.nextLine();
            }
        }
        while(true){
            boolean check = false;
            for(int i=0;i<users.size();i++){
                if(email.equalsIgnoreCase(users.get(i).getEmail()))
                    check = true;
            }
            if (check == false){
                break;
            }else{
                System.out.println("The email you entered is already exist.");
                System.out.print("Please enter new email: ");
                email = input.nextLine();
            }
        }
        System.out.print("Please password from 8 characters or more: ");
        String password = input.nextLine();
        System.out.print("Confirm your password: ");
        String confirmPassword = input.nextLine();
        while(true){
            if (password.equals(confirmPassword) && password.length()>=8){
                break;
            }else if(password.length()<8){
                System.out.println("Password should consist of 8 characters or more.");
                System.out.print("Password: ");
                password = input.nextLine();
                System.out.print("Confirm password: ");
                confirmPassword = input.nextLine();
            }else{
                System.out.println("The confirm password not equal password Please try again.");
                System.out.print("Password: ");
                password = input.nextLine();
                System.out.print("Confirm password: ");
                confirmPassword = input.nextLine();
            }
        }
        System.out.print("Please enter your phone: ");
        String phone;
        int counter;
        while (true){
            counter = 0;
            phone = input.nextLine();
            for(int i=0;i<phone.length();i++){
                if ((int)phone.charAt(i)<48 || (int)phone.charAt(i)>57 || phone.length()!=11){
                    System.out.print("You entered your phone number in wrong way\n"+"Please enter it again: ");
                    counter++;
                    break;
                }
            }
            if(counter==0){
                break;
            }
        }

        System.out.print("Please enter your location: ");
        String location = input.nextLine();

        System.out.print("Please enter your role 'Player' or 'Playground owner': ");
        String role = input.nextLine();
        while (true){
            if (role.equalsIgnoreCase("player")){
                Scanner code = new Scanner(System.in);
                System.out.print("Enter the code of 6 chars that sent to your mail: ");
                String activeCode = code.nextLine();
                while(true){
                    if(activeCode.length()==6){
                        break;
                    }else{
                        System.out.println("You entered wrong code ... new code is sent to you");
                        System.out.print("Enter new code: ");
                        activeCode = code.nextLine();
                    }
                }
                Player newPlayer = new Player(firstName, lastName, email, password, phone, location, role);
                players.add(newPlayer);
                users.add(newPlayer);
                player = newPlayer;
                playerMenu(player);
            }else if (role.equalsIgnoreCase("playground owner")){
                Scanner code = new Scanner(System.in);
                System.out.print("Enter the code of 6 chars that sent to your mail: ");
                String activeCode = code.nextLine();
                while(true){
                    if(activeCode.length()!=6){
                        System.out.println("You entered wrong code ... new code is sent to you");
                        System.out.print("Enter new code: ");
                        activeCode = code.nextLine();
                    }else{
                        break;
                    }
                }
                GroundOwner newOwner = new GroundOwner(firstName, lastName, email, password, phone, location, role);
                owners.add(newOwner);
                users.add(newOwner);
                owner = newOwner;
                ownerMenu(owner);
            }else{
                System.out.println("You entered wrong choice.");
                System.out.println("Your available choices 'Player' or 'Playground owner' ");
                System.out.print("Please enter your choice again: ");
                role = input.nextLine();
            }
        }
    }

    public static boolean isMailTrue (String email){
        boolean isAt = false;
        boolean isDot = false;
        int len = email.length();
        if((email.charAt(len-1)=='m') && (email.charAt(len-2)=='o') && (email.charAt(len-3)=='c') && (email.charAt(len-4)=='.')){
            isDot = true;
        }else{
            return false;
        }
        for (int j=0; j<len; j++){
            if(email.charAt(j)==' '){
                return false;
            }
        }
        for (int i=0; i<len; i++){
            if(email.charAt(i)=='@'){
                isAt = true;
                break;
            }
        }
        if((isAt==true) && (isDot == true)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * method to make old user be able to make login in the system again
     */

    public static void login(){
        boolean check = false;
        Scanner input = new Scanner(System.in);
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        if (email.equals("admin@gmail.com") && password.equals("admin")) {
            adminMenu(admin);
        }else {
            while (true) {
                for (int i = 0; i < users.size(); i++) {
                    if (email.equals(users.get(i).getEmail()) && password.equals(users.get(i).getPassword()) && users.get(i).role.equalsIgnoreCase("Player")) {
                        player = (Player) users.get(i);
                        playerMenu(player);
                        check = true;
                        break;
                    } else if (email.equals(users.get(i).getEmail()) && password.equals(users.get(i).getPassword()) && users.get(i).role.equalsIgnoreCase("playground owner")) {
                        owner = (GroundOwner) users.get(i);
                        ownerMenu(owner);
                        check = true;
                        break;
                    }
                }
                if (check == true) {
                    break;
                } else {
                    System.out.println("You entered wrong email or password. Please try again.");
                    System.out.print("Email: ");
                    email = input.nextLine();
                    System.out.print("Password: ");
                    password = input.nextLine();
                }
            }
        }
    }

    /**
     * menu to the owner of play ground to make him control his play ground
     * @param owner
     */
    public static void ownerMenu(GroundOwner owner){
        Scanner input = new Scanner(System.in);
        while(true){
            owner.showInfo();
            System.out.println("\n");
            System.out.println("1- Add playground");
            System.out.println("2- Update available hours");
            System.out.println("3- View booked hours");
            System.out.println("4- View eWallet");
            System.out.println("5- Log out");
            System.out.println("6- Exit\n");
            System.out.print("Your choice: ");
            int choice = input.nextInt();
            if(choice == 1){
                owner.groundRegistration(owner.ground);
                grounds.add(owner.ground);
                System.out.println("\n");
            }else if(choice == 2){
                System.out.print("Please enter the period of available hours\nfrom: ");
                int from = input.nextInt();
                System.out.print("to: ");
                int to = input.nextInt();
                owner.updateAvailableTime(from, to);
                System.out.println("\n");
            }else if(choice == 3){
                owner.showBookedHours();
            } else if(choice == 4){
                System.out.println("Your Credit in eWallet: " + owner.geteWallet() +"\n");
            }else if(choice == 5){
                System.out.println("\n");
                mainMenu();
            }else if(choice == 6){
                System.exit(0);
            }else{
                System.out.println("You entered wrong choice please choose [1, 2, 3, 4 or 5]");
            }
        }
    }

    /**
     * menu for the admin to make it control the system
     * @param admin
     */
    public static void adminMenu(Administrator admin){
        Scanner input = new Scanner(System.in);
        while(true){
            admin.showInfo();
            System.out.println("\n");
            System.out.println("1- Show all playground");
            System.out.println("2- Show Activated playground");
            System.out.println("3- Show deactivated playground");
            System.out.println("4- Activate playground");
            System.out.println("5- Deactivate playground");
            System.out.println("6- Delete playground");
            System.out.println("7- Show complaints");
            System.out.println("8- Log out");
            System.out.println("9- Exit\n");
            System.out.print("Your choice: ");
            int choice = input.nextInt();
            if(choice == 1){
                showAllPlaygrounds(admin);
                System.out.println("\n");
            }else if(choice == 2){
                showActivatedPlaygrounds(admin);
                System.out.println("\n");
            }else if(choice == 3){
                showDeactivatedPlaygrounds(admin);
                System.out.println("\n");
            }else if(choice == 4){
                activatePlayground(admin);
                System.out.println("\n");
            }else if(choice == 5){
                deactivatePlayground(admin);
                System.out.println("\n");
            }else if(choice == 6){
                deletePlayground(admin);
                System.out.println("\n");
            }else if(choice == 7){
                admin.showComplaints();
                System.out.println("\n");
            }else if(choice == 8){
                System.out.println("\n");
                mainMenu();
            }else if(choice == 9){
                System.exit(0);
            }else{
                System.out.println("You entered wrong choice please choose [1, 2, 3, 4, 5 or 6]");
                System.out.println("\n");
            }
        }
    }

    /**
     * method to show all play ground
     */
    public static void showAllPlaygrounds(Administrator admin){
        if(grounds.isEmpty()){
            System.out.println("There is no grounds to show");
        }else {
            for(int i=0; i<grounds.size(); i++){
                grounds.get(i).showGroundInfo();
            }
        }
    }

    /**
     * method to show all activated play grounds
     */
    public static void showActivatedPlaygrounds(Administrator admin){
        boolean check = false;
        if(grounds.isEmpty()){
            System.out.println("There is no grounds to show");
        }else{
            for(int i=0; i<grounds.size(); i++){
                if(grounds.get(i).isActivated() == true) {
                    grounds.get(i).showGroundInfo();
                    check = true;
                }
            }
        }
        if(check == false){
            System.out.println("There is no activated playgrounds to show");
        }
    }
    /**
     * method to show all deactivated play grounds
     */
    public static void showDeactivatedPlaygrounds(Administrator admin){
        boolean check = false;
        if(grounds.isEmpty()){
            System.out.println("There is no grounds to show");
        }else{
            for(int i=0; i<grounds.size(); i++){
                if(grounds.get(i).isActivated() == false) {
                    grounds.get(i).showGroundInfo();
                    check = true;
                }
            }
        }
        if(check == false){
            System.out.println("There is no deactivated playgrounds to show");
        }
    }

    /**
     * method to active the play grounds
     * @param admin name of the play ground
     */
    public static void activatePlayground(Administrator admin){
        Scanner answer = new Scanner(System.in);
        System.out.print("Please enter the ground name you want to activate: ");
        String name = answer.nextLine();
        System.out.print("Please enter the ground owner ID you want to activate: ");
        int ownerID = answer.nextInt();
        boolean check = false;
        if(grounds.isEmpty()){
            System.out.println("There is no grounds to show");
        }else{
            for(int i=0; i<grounds.size(); i++){
                if(grounds.get(i).getGroundName().equalsIgnoreCase(name) && grounds.get(i).getGroundOwnerID() == ownerID && (grounds.get(i).isActivated() == false)){
                    grounds.get(i).setActivate(admin);
                    System.out.println("The playground is activated successfully");
                    check = true;
                    break;
                }else if (grounds.get(i).getGroundName().equalsIgnoreCase(name) && grounds.get(i).getGroundOwnerID() == ownerID && (grounds.get(i).isActivated() == true)){
                    System.out.println("This ground is already activated");
                    check = true;
                    break;
                }
            }
            if(check == false){
                System.out.println("There is no playground with this name and owner ID");
            }
        }
    }

    /**
     * method to deactivate the play grounds
     * @param admin name of the play ground
     */
    public static void deactivatePlayground(Administrator admin){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the ground name you want to deactivate: ");
        String name = scan.nextLine();
        System.out.print("Please enter the ground owner ID you want to activate: ");
        int ownerID = scan.nextInt();
        boolean check = false;
        if(grounds.isEmpty()){
            System.out.println("There is no grounds to show");
        }else{
            for(int i=0; i<grounds.size(); i++){
                if(grounds.get(i).getGroundName().equalsIgnoreCase(name) && grounds.get(i).getGroundOwnerID() == ownerID && (grounds.get(i).isActivated() == true)){
                    grounds.get(i).setDeactivate(admin);
                    check = true;
                    break;
                }else if (grounds.get(i).getGroundName().equalsIgnoreCase(name) && grounds.get(i).getGroundOwnerID() == ownerID && (grounds.get(i).isActivated() == false)){
                    System.out.println("This ground is already deactivated");
                    check = true;
                    break;
                }
            }
            if(check == false){
                System.out.println("There is no playground with this name and owner ID");
            }
        }
    }
    /**
     * method to delete the play grounds
     * @param admin name of the play ground
     */
    public static void deletePlayground(Administrator admin){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the ground name you want to delete: ");
        String name = scan.nextLine();
        System.out.print("Please enter owner ID: ");
        int ownerID = scan.nextInt();
        boolean check = false;
        if(grounds.isEmpty()){
            System.out.println("There is no grounds to show");
        }else{
            for(int i=0; i<grounds.size(); i++){
                if(grounds.get(i).getGroundName().equalsIgnoreCase(name) && grounds.get(i).getGroundOwnerID() ==ownerID) {
                    grounds.remove(i);
                    check = true;
                    break;
                }
            }
            if(check == false){
                System.out.println("There is no playground with this name and owner ID");
            }
        }
    }

    /**
     * menu for the player to make it control his choice in the system
     * @param player
     */
    public static void playerMenu(Player player){
        Scanner input = new Scanner(System.in);
        while(true){
            player.showInfo();
            System.out.println("\n");
            System.out.println("1- Show available hours of playgrounds near to you on on specific date");
            System.out.println("2- Show available hours of playgrounds in specific location on specific dates");
            System.out.println("3- Book an hour for a specific playground on specific date");
            System.out.println("4- Show booked hours");
            System.out.println("5- Cancel an booked hour");
            System.out.println("6- Add team");
            System.out.println("7- Add Member in team");
            System.out.println("8- Send invitation to team");
            System.out.println("9- Show invitation");
            System.out.println("10- Send complaint of specific playground to administrator");
            System.out.println("11- Log out");
            System.out.println("12- Exit \n");
            System.out.print("Your choice: ");
            int choice = input.nextInt();
            if(choice == 1){
                showPlaygroundsNearToPlayer(player);
                System.out.println("\n");
            }else if(choice == 2){
                showPlaygroundsInSpecificLocation(player);
            }else if(choice == 3){
                bookAvailableHour(player);
            }else if(choice == 4){
                player.showBookedHours();
            }else if(choice == 5){
                cancelBookedHour(player);
            }else if(choice == 6){
                addTeam(player);
            }else if(choice == 7){
                addMemberToTeam(player);
            }else if(choice == 8){
                sendInvitationToTeam(player);
            }else if(choice == 9){
                showInvitations(player);
            }else if(choice == 10){
                sendComplaint(player);
            }else if(choice == 11){
                System.out.println("\n");
                mainMenu();
            }else if(choice == 12){
                System.exit(0);
            }else{
                System.out.println("You entered wrong choice please choose [1, 2, 3, 4, 5, 6 or 7]");
            }
        }
    }

    /**
     * method for the player make him know all play grounds that is near to him
     * @param player
     */
    public static void showPlaygroundsNearToPlayer(Player player){
        boolean check = false;
        Scanner date = new Scanner(System.in);
        System.out.print("Enter month: ");
        int month = date.nextInt();
        System.out.print("Enter day: ");
        int day = date.nextInt();
        for(int i=0; i<grounds.size();i++){
            if (player.getLocation().equals(grounds.get(i).getGroundLocation()) && grounds.get(i).isActivated()){
                check=true;
                grounds.get(i).showGroundInfo();
                grounds.get(i).showAvailableHours(month, day);
            }
        }
        if(check == false){
            System.out.println("There is no playgrounds near to you \n");
        }
    }
    /**
     * method for the player make him know all play grounds that he was select them in specific location
     * @param player
     */
    public static void showPlaygroundsInSpecificLocation(Player player){
        boolean check = false;
        Scanner date = new Scanner(System.in);
        System.out.print("Enter location: ");
        String location = date.nextLine();
        System.out.print("Enter month: ");
        int month = date.nextInt();
        System.out.print("Enter day: ");
        int day = date.nextInt();
        for(int i=0; i<grounds.size();i++){
            if (grounds.get(i).getGroundLocation().equalsIgnoreCase(location) && grounds.get(i).isActivated()){
                check=true;
                grounds.get(i).showGroundInfo();
                grounds.get(i).showAvailableHours(month, day);
            }
        }
        if(check == false){
            System.out.println("There is no playgrounds in this location \n");
        }
    }

    /**
     * method for the player make him access to book an available hour
     * @param player
     */
    public static void bookAvailableHour(Player player){
        boolean check = false;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter ground name: ");
        String groundName = scan.nextLine();
        System.out.print("Enter ground owner ID: ");
        int ownerID = scan.nextInt();
        for(int i=0; i<grounds.size();i++){
            if(grounds.get(i).isActivated() && grounds.get(i).getGroundName().equalsIgnoreCase(groundName) && grounds.get(i).getGroundOwnerID() == ownerID){
                check = true;
                ground = grounds.get(i);
                break;
            }
        }
        if (check == false){
            System.out.println("You entered wrong ground name or owner ID. \n");
        }else{
            Scanner date = new Scanner(System.in);
            System.out.print("Enter month: ");
            int month = date.nextInt();
            System.out.print("Enter day: ");
            int day = date.nextInt();
            System.out.print("Enter hour: ");
            int hour = date.nextInt();
            if(ground.isAvailable(month,day,hour)){
                System.out.println("The hour cost " + ground.getPricePerHour() + " do you want to confirm your book");
                Scanner answer = new Scanner(System.in);
                System.out.print("Enter Yes or No: ");
                String choice = answer.nextLine();
                while(true){
                    if(choice.equalsIgnoreCase("yes")){
                        ground.bookAvailableHour(month, day, hour);
                        player.addBookedHour(groundName,ownerID,month,day,hour);
                        System.out.println("Go to any fawry machine with the code that sent to your mail and pay the cost of the hour you booked \n");
                        for(int i=0; i<owners.size(); i++){
                            if(owners.get(i).getID() == ground.getGroundOwnerID()){
                                owner= owners.get(i);
                                break;
                            }
                        }
                        owner.seteWallet(ground.getPricePerHour());
                        break;
                    }else if(choice.equalsIgnoreCase("no")){
                        System.out.println("The hour didn't booked.\n");
                        break;
                    }else{
                        System.out.println("You entered wrong choice");
                        System.out.print("Please enter only yes or no: ");
                        choice = answer.nextLine();
                    }
                }
            }else{
                System.out.println("This hour is already booked\n");
            }
        }
    }
    /**
     * method for the player make him access to cancel an booked hour
     * @param player
     */
    public static void cancelBookedHour(Player player){
        boolean check = false;
        if(player.bookedHours.isEmpty()){
            System.out.println("You didn't book any hour to cancel \n");
        }else{
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter hour information you want to cancel.");
            System.out.print("Ground Name: ");
            String groundName = scan.nextLine();
            System.out.print("Owner ID: ");
            int ownerID = scan.nextInt();
            System.out.print("Month: ");
            int month = scan.nextInt();
            System.out.print("Day: ");
            int day = scan.nextInt();
            System.out.print("Hour: ");
            int hour = scan.nextInt();
            if(player.isBooked(groundName,ownerID,month,day,hour)){
                for(int i=0; i<grounds.size(); i++){
                    if(grounds.get(i).getGroundName().equalsIgnoreCase(groundName) && grounds.get(i).getGroundOwnerID() == ownerID){
                        grounds.get(i).cancelBookedHour(month,day,hour);
                        player.cancelBookedHour(groundName,ownerID,month,day,hour);
                        for(int j=0; j<owners.size(); j++){
                            if(owners.get(j).getID() == ground.getGroundOwnerID()){
                                owner= owners.get(j);
                                break;
                            }
                        }
                        owner.returnMoney(ground.getPricePerHour());
                        System.out.println("The hour is cancelled successfully\n and go to fawry any machine with the code that sent to your mail to return your money\n");
                        check = true;
                        break;
                    }
                }
                if(check == false){
                    System.out.println("You entered wrong information ... please check hour information you want to cancel well and try again \n");
                }
            }
        }
    }

    /**
     * method for the player make him has access to make a new team
     * @param player
     */
    public static void addTeam(Player player){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your team name: ");
        String name = input.nextLine();
        player.addTeam(name);
        teams.add(player.team);
    }
    /**
     * method for the player make him has access to add an member to his team
     * @param player
     */
    public static void addMemberToTeam(Player player){
        if(teams.isEmpty()){
            System.out.println("You didn't create teams \n");
        }else{
            boolean check = false;
            Scanner input = new Scanner(System.in);
            for(int i=0; i<teams.size(); i++){
                if(teams.get(i).getTeamLeaderID() == player.getID()){
                    team = teams.get(i);
                    check = true;
                    break;
                }
            }
            if (check == false){
                System.out.println("You didn't create teams \n");
            }else{
                boolean found = false;
                System.out.print("Enter email of the member you want to add: ");
                String email = input.nextLine();
                for(int i=0; i<players.size(); i++){
                    if(players.get(i).getEmail().equalsIgnoreCase(email)){
                        member = players.get(i);
                        found = true;
                        break;
                    }
                }
                if(found == true){
                    team.addMember(member);
                    System.out.println("The member is added successfully\n");
                }else{
                    System.out.println("The Player you entered his email is does not exist on the application \n");
                }

            }
        }

    }

    /**
     * method for the player make him has access to send invitation to another players to join his team
     * @param player
     */
    public static void sendInvitationToTeam(Player player){
        if(teams.isEmpty()){
            System.out.println("There is no teams to invite\n");
        }else{
            boolean check = false;
            Scanner input = new Scanner(System.in);
            System.out.print("Enter team name: ");
            String teamName = input.nextLine();
            System.out.print("Enter team leader ID: ");
            int teamLeaderID = input.nextInt();
            for(int i=0; i<teams.size(); i++){
                if(teams.get(i).getTeamName().equalsIgnoreCase(teamName) && teams.get(i).getTeamLeaderID() == teamLeaderID){
                    team = teams.get(i);
                    check = true;
                    break;
                }
            }
            if (check == false){
                System.out.println("Team information you entered is doesn't exist\n");
            }else{
                String invitation = player.getEmail() + "\tInvites you to play a match with him";
                for (int i=0; i<team.members.size(); i++){
                    team.members.get(i).addInvite(invitation);
                }
            }
        }
    }

    public static void showInvitations(Player player){
        player.showInvitations();
    }

    /**
     * method for the player make him has access to send complaint about ground and ground owner
     * @param player
     */
    public static void sendComplaint(Player player){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter ground name: ");
        String groundName = scan.nextLine();
        System.out.print("Enter ground owner ID: ");
        int groundOwnerID = scan.nextInt();
        Scanner comp = new Scanner(System.in);
        System.out.print("Your complaint: ");
        String complaint = comp.nextLine();
        admin.addComplaint(groundName, groundOwnerID, complaint);
    }

    /**
     * to restart the main menu again for user to choice another operation
     * @param args
     */
    public static void main(String[] args) {
        while (true){
            mainMenu();
        }
    }
}
