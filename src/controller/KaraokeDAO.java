/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Karaoke;
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
public class KaraokeDAO {

    public static List<Karaoke> findAll() {
        List<Karaoke> karaokeList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            // chom all list karaoke
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karaoke_management", "root", "");
            //truy van
            String sql = "select * from karaoke";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Karaoke oke = new Karaoke(resultSet.getInt("Stt"), resultSet.getString("songcode"),
                        resultSet.getString("namemusic"), resultSet.getString("singername"),
                        resultSet.getString("yearofcreation"), resultSet.getString("lyrics"));
                karaokeList.add(oke);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KaraokeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KaraokeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KaraokeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // end
        return karaokeList;
    }

    public static void insert(Karaoke oke) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // chom all list karaoke
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karaoke_management", "root", "");
            //truy van
            String sql = "insert into karaoke(songcode , namemusic , singername , yearofcreation , lyrics) values(?,?,?,?,?)";
            statement = connection.prepareCall(sql);
            statement.setString(1, oke.getSongCode());
            statement.setString(2, oke.getNameMusic());
            statement.setString(3, oke.getSingerName());
            statement.setString(4, oke.getYearOfCreation());
            statement.setString(5, oke.getLyrics());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KaraokeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KaraokeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KaraokeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // end
    }

    public static void update(Karaoke oke) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // chom all list karaoke
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karaoke_management", "root", "");
            //truy van
            String sql = "update karaoke set songcode=?,namemusic=?,singername=?,yearofcreation=?,lyrics=? where stt = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, oke.getSongCode());
            statement.setString(2, oke.getNameMusic());
            statement.setString(3, oke.getSingerName());
            statement.setString(4, oke.getYearOfCreation());
            statement.setString(5, oke.getLyrics());
            statement.setInt(6, oke.getStt());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KaraokeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KaraokeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KaraokeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // end
    }

    public static Connection ketnoicsdl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            System.out.println("Error");
        }
        String url = "jdbc:mysql://localhost/karaoke_management";

        try {
            Connection connection = (Connection) DriverManager.getConnection(url, "root", "");
            if (connection != null) {
                System.out.println("thanh cong");
            } else {
                System.out.println("khong thanh cong");
            }
            return connection;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return null;
    }

    public static void delete(String NameMusic) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // chom all list karaoke
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karaoke_management", "root", "");
            //truy van
            String sql = "delete from karaoke where Namemusic = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, NameMusic);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KaraokeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KaraokeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KaraokeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // end
    }

    public static List<Karaoke> find(String NameMusic) {
        List<Karaoke> karaokeList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // chom all list karaoke
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karaoke_management", "root", "");
            //truy van
            String sql = "select * from karaoke where NameMusic like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%" + NameMusic + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Karaoke oke = new Karaoke(resultSet.getInt("Stt"), resultSet.getString("songcode"),
                        resultSet.getString("namemusic"), resultSet.getString("singername"),
                        resultSet.getString("yearofcreation"), resultSet.getString("lyrics"));
                karaokeList.add(oke);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KaraokeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KaraokeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KaraokeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // end
        return karaokeList;
    }

}
