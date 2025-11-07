package com.finance.main;

import java.sql.Date;
import java.util.*;
import com.finance.dao.*;
import com.finance.entity.*;
import com.finance.exception.*;

public class FinanceApp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        IFinanceRepository repo=new FinanceRepositoryImplement();

        while (true) {
            System.out.println("\n===== Finance Management System =====");
            System.out.println("1. Add User");
            System.out.println("2. Add Expense");
            System.out.println("3. Delete User");
            System.out.println("4. Delete Expense");
            System.out.println("5. Update Expense");
            System.out.println("6. View All Expenses");
            System.out.println("7. View All User");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int ch=sc.nextInt();

            try {
                switch (ch) {
                    case 1:
                        System.out.print("Enter username: ");
                        String uname=sc.next();
                        System.out.print("Enter password: ");
                        String pwd=sc.next();
                        System.out.print("Enter email: ");
                        String email=sc.next();
                        repo.createUser(new User(0,uname,pwd,email));
                        System.out.println("User added successfully!");
                        break;

                    case 2:
                        System.out.print("Enter user ID: ");
                        int uid=sc.nextInt();
                        System.out.print("Enter amount: ");
                        double amt=sc.nextDouble();
                        System.out.print("Enter category ID: ");
                        int cid=sc.nextInt();
                        System.out.print("Enter description: ");
                        String des=sc.next();
                        repo.createExpense(new Expense(0,uid,amt,cid,new Date(System.currentTimeMillis()),des));
                        System.out.println("Expense added successfully!");
                        break;

                    case 3:
                        System.out.print("Enter user ID to delete: ");
                        repo.deleteUser(sc.nextInt());
                        System.out.println("User deleted successfully!");
                        break;

                    case 4:
                        System.out.print("Enter expense ID to delete: ");
                        repo.deleteExpense(sc.nextInt());
                        System.out.println("Expense deleted successfully!");
                        break;

                    case 5:
                        System.out.print("Enter user ID: ");
                        int u=sc.nextInt();
                        System.out.print("Enter expense ID: ");
                        int eid=sc.nextInt();
                        System.out.print("Enter new amount: ");
                        double a=sc.nextDouble();
                        System.out.print("Enter new category ID: ");
                        int cat=sc.nextInt();
                        System.out.print("Enter new description: ");
                        String d=sc.next();
                        repo.updateExpense(u,new Expense(eid,u,a,cat,new Date(System.currentTimeMillis()),d));
                        System.out.println("Expense updated!");
                        break;

                    case 6:
                        System.out.print("Enter user ID: ");
                        int user=sc.nextInt();
                        List<Expense> exp=repo.getAllExpenses(user);
                        exp.forEach(System.out::println);
                        break;
                    case 7:
                        System.out.println("\nView All Users");
                        boolean success = repo.viewUsers(null); 
                        if (!success) {
                            System.out.println("Failed to fetch users from the database.");
                        }
                        break;
                     case 0:
                        System.out.println("Exiting...");
                        sc.close();
                        System.exit(0);
                }
            } 
            catch (Exception e) {
                System.out.println("Error: "+e.getMessage());
            }
        }
    }
}
