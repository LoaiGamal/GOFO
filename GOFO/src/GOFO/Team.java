package GOFO;

import java.util.Vector;
/**
 * this class is to make an team and take it's information
 * @author Ahmed Kadry
 * @vesion 2 FINAL
 * @since  1 DRAFT
 */
public class Team {
    /**
     * this is to define the new team name
     */
    private String  teamName;
    /**
     * this is to define the team leader id
     */
    private int teamLeaderID;
    /**
     * this is a vector to store the members of the team
     */
    public Vector<Player> members = new Vector<Player>();

    /**
     * method to get the new team name
     * @return team name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * method to set the new team name
     * @param teamName new team name
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * method to get the id of the team leader
     * @return team leader id
     */
    public int getTeamLeaderID() {
        return teamLeaderID;
    }

    /**
     * method to set the team leader id
     * @param teamLeaderID team leader id
     */
    public void setTeamLeaderID(int teamLeaderID) {
        this.teamLeaderID = teamLeaderID;
    }

    /**
     * method to add new member to the team
     * @param player to  add the new member in the team of the this player
     */
    public void addMember(Player player){
        members.add(player);
    }

    /**
     * method to show the members in the team
     */
    public void showTeamMembers(){
        if(members.isEmpty()){
            System.out.println("There is no members at your team.");
        }else{
            System.out.println("Team name: " + teamName + "\n" + "Members: " );
            for(int i=0; i<members.size(); i++){
                System.out.println(i + "-" + "      " + "Name: " + members.get(i).getFirstName() + " " + members.get(i).getLastName() + "    " + "Email: " + members.get(i).getEmail());
            }
        }
    }

}
