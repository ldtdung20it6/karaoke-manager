/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.ThongKe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author DungLe
 */
public class ThongKeDAO {
    public static List<ThongKe>findAll(){
        List<ThongKe> ThongKeList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            // chom all list thongke
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karaoke_management", "root", "");
            //truy van
            String sql = "select * from thongke";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {                
                ThongKe tk = new ThongKe(
                resultSet.getInt("xephang"),
                resultSet.getString("baihat"),
                resultSet.getString("casi"),
                resultSet.getString("luotxem"));
                ThongKeList.add(tk);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(KaraokeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KaraokeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KaraokeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // end
        return ThongKeList;
    }
    public static void insert(ThongKe tk){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // chom all list thong ke
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karaoke_management", "root", "");
            //truy van
            String sql = "insert into thongke(baihat , casi , luotxem) values(?,?,?)";
            statement = connection.prepareCall(sql);            
            statement.setString(1, tk.getBaiHat());
            statement.setString(2, tk.getCaSi());
            statement.setString(3, tk.getLuotXem());           
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // end
}
     public static void update(ThongKe tk){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // chom all list karaoke
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karaoke_management", "root", "");
            //truy van
            String sql = "update thongke set baihat=?,casi=?,luotxem=? where xephang = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, tk.getBaiHat());
            statement.setString(2, tk.getCaSi());
            statement.setString(3, tk.getLuotXem()); 
            statement.setInt(4, tk.getXepHang());
            
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // end
}
        public static void delete(String BaiHat){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // chom all list thong ke
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karaoke_management", "root", "");
            //truy van
            String sql = "delete from thongke where BaiHat = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, BaiHat);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // end
}
        
}
