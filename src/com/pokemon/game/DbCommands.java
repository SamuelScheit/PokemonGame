package com.pokemon.game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbCommands {


    private void insert(int Pokemon_ID, String Pokemon_Name, int HP, int Attack_1, int Attack_2, int Sprite_ID) {
        Connection con = DbConnection.connect();
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO POKEMON(Pokemon_ID, Pokemon_Name, HP, Attack_1, Attack_2, Sprite_ID) VALUES(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(Pokemon_ID));
            ps.setString(2, Pokemon_Name);
            ps.setString(3, String.valueOf(HP));
            ps.setString(4, String.valueOf(Attack_1));
            ps.setString(5, String.valueOf(Attack_2));
            ps.setString(6, String.valueOf(Sprite_ID));
            ps.execute();
            System.out.println("Data has been inserted");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        finally {
            try{
                ps.close();
                con.close();
            }

            catch (SQLException e){
                System.out.println(e.toString());
            }
        }



    }

    private void readTable(){
        Connection con = DbConnection.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            String sql = "SELECT * FROM POKEMON";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String Pokemon_ID = rs.getString("Pokemon_ID");
                String Pokemon_Name = rs.getString("Pokemon_Name");
                String HP = rs.getString("HP");
                String Attack_1 = rs.getString("Attack_1");
                String Attack_2 = rs.getString("Attack_2");
                String Sprite_ID = rs.getString("Sprite_ID");


                System.out.println("All Pokemon have been exported");
                System.out.println("Pokemon_ID: " + Pokemon_ID);
                System.out.println("Pokemon_Name: " + Pokemon_Name);
                System.out.println("HP: " + HP);
                System.out.println("Attack_1: " + Attack_1);
                System.out.println("Attack_2: " +Attack_2);
                System.out.println("Sprite_ID: " + Sprite_ID);
            }
        }
        catch(SQLException e){
            System.out.println(e.toString());
        }
        finally {
            try{
                rs.close();
                ps.close();
                con.close();
            }

            catch (SQLException e){
                System.out.println(e.toString());
            }
        }

    }

    public void readRow(){
        Connection con = DbConnection.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            String sql = "Select Pokemon_Name from where Pokemon_ID = ?" ;
            ps = con.prepareStatement(sql);
            ps.setString(1, "1");
        }

        catch (SQLException e){
            System.out.println(e.toString());
        }
        finally {
            try {
                rs.close();
                ps.close();
                con.close();
            }
            catch (SQLException e){
                System.out.println(e.toString());
            }
        }
    }

    private void updateSavegame(){
        Connection con = DbConnection.connect();
        PreparedStatement ps = null;
        try{
            String sql = "UPDATE SPIELSTAENDE set Player_Pos_X = ? AND Player_Pos_Y = ? AND Map_Name = ? WHERE Game_ID = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "");
            ps.setString(2, "");
            ps.setString(3, "");
            ps.setString(4, "");
            ps.execute();
            System.out.println("Data has been updated");
        }
        catch (SQLException e){
            System.out.println(e.toString());
        }
        finally {
            try{
                ps.close();
                con.close();
            }

            catch (SQLException e){
                System.out.println(e.toString());
            }
        }
    }

    private void deleteRow() {
        Connection con =DbConnection.connect();
        PreparedStatement ps = null;
        try{
           String sql = "delet from POKEMON WHERE Pokemon_ID = ?";
           ps = con.prepareStatement(sql);
           ps.setString(1,"");
           ps.execute();
           System.out.println("Data has been deleted");
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            try{
                ps.close();
                con.close();
            }

            catch (SQLException e){
                System.out.println(e.toString());
            }
        }
    }

    private void getNumberOfPokemon(){
        Connection con = DbConnection.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "Select count(Pokemon_ID) from POKEMON";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            int size = rs.getInt(1);
            System.out.println("You have "+size+" Pokemon");
        }
        catch (SQLException e) {
            System.out.println(e.toString());
        }finally {
            try{
                rs.close();
                ps.close();
                con.close();
            }

            catch (SQLException e){
                System.out.println(e.toString());
            }
        }
    }
}
