package com.finance.dao;

import java.sql.*;
import java.util.*;
import com.finance.entity.*;
import com.finance.exception.*;
import com.finance.util.DBConnUtil;

public class FinanceRepositoryImplement implements IFinanceRepository {

    private Connection conn;
    public FinanceRepositoryImplement() {
        conn = DBConnUtil.getConnection();
    }

    public FinanceRepositoryImplement(Connection c) {
    	this.conn=c;
    }

    @Override
    public boolean createUser(User user) {
        String sql="INSERT INTO Users(username, password, email) VALUES(?, ?, ?)";
        try (PreparedStatement ps=conn.prepareStatement(sql)) {
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getEmail());
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(int userId) throws UserNotFoundException {
        String sql="DELETE FROM Users WHERE user_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            int affected=ps.executeUpdate();
            if (affected==0) throw new UserNotFoundException("User not found with ID "+userId);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean viewUsers(User user) {
        String sql = "SELECT user_id, username, email FROM users";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n===== Users =====");
            System.out.printf("%-10s %-20s %-30s%n", "User ID", "Name", "Email");

            boolean hasUsers = false; // flag to check if any user exists

            while (rs.next()) {
                hasUsers = true; // at least one user exists
                int id = rs.getInt("user_id");
                String name = rs.getString("username");
                String email = rs.getString("email");

                System.out.printf("%-10d %-20s %-30s%n", id, name, email);
            }

            if (!hasUsers) {
                System.out.println("No users found.");
            }

            return true; // query executed successfully

        } catch (SQLException e) {
            System.out.println("Error fetching users: " + e.getMessage());
            return false; // query failed
        }
    }
    @Override
    public boolean createExpense(Expense expense) {
        String sql="INSERT INTO Expenses(user_id, amount, category_id, date, description) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1,expense.getUserId());
            ps.setDouble(2,expense.getAmount());
            ps.setInt(3,expense.getCategoryId());
            ps.setDate(4,expense.getDate());
            ps.setString(5,expense.getDescription());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteExpense(int expenseId) throws ExpenseNotFoundException {
        String sql="DELETE FROM Expenses WHERE expense_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, expenseId);
            int affected = ps.executeUpdate();
            if (affected == 0) throw new ExpenseNotFoundException("Expense not found with ID " + expenseId);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateExpense(int userId, Expense expense) throws ExpenseNotFoundException {
        String sql="UPDATE Expenses SET amount=?, category_id=?, date=?, description=? WHERE expense_id=? AND user_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1,expense.getAmount());
            ps.setInt(2,expense.getCategoryId());
            ps.setDate(3,expense.getDate());
            ps.setString(4,expense.getDescription());
            ps.setInt(5,expense.getExpenseId());
            ps.setInt(6,userId);
            int affected=ps.executeUpdate();
            if (affected==0) throw new ExpenseNotFoundException("No expense found to update!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Expense> getAllExpenses(int userId) throws UserNotFoundException {
        List<Expense> list=new ArrayList<>();
        String sql="SELECT * FROM Expenses WHERE user_id=?";
        try (PreparedStatement ps=conn.prepareStatement(sql)) {
            ps.setInt(1,userId);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                list.add(new Expense(rs.getInt("expense_id"),rs.getInt("user_id"),rs.getDouble("amount"), rs.getInt("category_id"),rs.getDate("date"), rs.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
