package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Representant extends Employe {

	private final static double POURCENT = 0.2;
	private final static int BONUS = 2500;
	double chiffreAffaire;

	public Representant(String nom, String prenom, int age, String date, double chiffreAffaire) {
		super(nom, prenom, age, date, chiffreAffaire);
		this.chiffreAffaire = chiffreAffaire;
	}

	public Representant() {
		// TODO Auto-generated constructor stub
	}

	public double calculerSalaire() {

		return (POURCENT * chiffreAffaire) + BONUS;
	}

	public String getTitre() {
		return "Le repr�sentant ";
	}

	public void create_data(String nom, String prenom, int age, int date, double chiffreAffaire) {
		con.Connect();
		PreparedStatement ps = null;
		try {
			String query = "INSERT INTO `represention`(`nom` , `prenom`,`age`,`date`,`chiffreAffaire`) VALUES (?,?,?,?,?)";
			ps = con.getConn().prepareStatement(query);
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setInt(3, age);
			ps.setInt(4, date);
			ps.setDouble(5, chiffreAffaire);
			ps.executeUpdate();
			System.out.println(" \n employee Ajoute Avec Succes ");
		} catch (Exception e1) {
			System.out.print(e1);
		}

	}

	// select
	public void read_data() throws SQLException {
		// First f = new First();
		con.Connect();
		con.setStat(con.getConn().createStatement());
		con.setRs(con.getStat().executeQuery("SELECT * FROM `represention` "));
		while (con.getRs().next()) {
			double value = POURCENT * con.getRs().getDouble("chiffreAffaire") + BONUS;
			System.out.println(" -> ID:  " + "\t" + con.getRs().getInt("id") + "\n \t nom: " + con.getRs().getString("nom")
					+ " \n \t prenom " + con.getRs().getString("prenom") + " \n \t age " + con.getRs().getInt("age")
					+ " \n \t date " + con.getRs().getInt("date") + " \n \t chiffreAffaire " + value);
		}
	}

	public void update_data(int id,String nom, String prenom, int age, int date, double chiffreAffaire) {
		//First f = new First();
		con.Connect();
		
		PreparedStatement ps = null;
		
		try {
			
			String query = "UPDATE `represention` SET `nom`=?,`prenom`=?,`age`=?,`date`=?,`chiffreAffaire`=?  WHERE `id`=?";
			ps=con.getConn().prepareStatement(query);
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setInt(3, age);
			ps.setInt(4, date);
			ps.setDouble(4,chiffreAffaire);
			ps.executeUpdate();
			System.out.println(" \t modification avec succes");
		}catch (Exception e){
			
		}
	}
	
	public void RemoveEmployee(int id) throws SQLException {
		con.Connect();
		PreparedStatement ps = null;
		try {
			String query = "DELETE FROM `represention` WHERE id=?";
			ps = con.getConn().prepareStatement(query);
			ps.setInt(1,id);
			ps.executeUpdate();
			System.out.println("the data deleted sucssesfuly !!!!!!");
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
}

