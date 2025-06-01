package com.app.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.app.bean.Book;

public class BookDao {

    public static Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Found");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vikrant", "root", "root");
            System.out.println("Connection Established");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static int saveBook(Book b) throws SQLException {
        int status = 0;
        String sql = "INSERT INTO booktb(title, author, publisher, quantity, issued) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, b.getTitle());
            stmt.setString(2, b.getAuthor());
            stmt.setString(3, b.getPublisher());
            stmt.setInt(4, b.getQuantity());
            stmt.setInt(5, b.getIssued());

            status = stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static List<Book> getAllBooks() throws SQLException {
        List<Book> list = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM booktb");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Book b = new Book();
            b.setId(rs.getInt(1));
            b.setTitle(rs.getString(2));
            b.setAuthor(rs.getString(3));
            b.setPublisher(rs.getString(4));
            b.setQuantity(rs.getInt(5));
            b.setIssued(rs.getInt(6));
            list.add(b);
        }
        return list;
    }

    public static int updateBook(Book b) throws SQLException {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "UPDATE booktb SET title=?, author=?, publisher=?, quantity=?, issued=? WHERE id=?"
            );
            stmt.setString(1, b.getTitle());
            stmt.setString(2, b.getAuthor());
            stmt.setString(3, b.getPublisher());
            stmt.setInt(4, b.getQuantity());
            stmt.setInt(5, b.getIssued());
            stmt.setInt(6, b.getId());

            status = stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static Book getBookById(int id) throws SQLException {
        Book b = null;
        Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM booktb WHERE id = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            b = new Book();
            b.setId(rs.getInt(1));
            b.setTitle(rs.getString(2));
            b.setAuthor(rs.getString(3));
            b.setPublisher(rs.getString(4));
            b.setQuantity(rs.getInt(5));
            b.setIssued(rs.getInt(6));
        }

        return b;
    }

    public static int deleteBook(int id) throws SQLException {
        int status = 0;
        try (Connection con = getConnection()) {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM booktb WHERE id = ?");
            stmt.setInt(1, id);
            status = stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
}
