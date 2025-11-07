package com.finance.test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

import com.finance.dao.*;
import com.finance.entity.*;
import com.finance.exception.*;
import com.finance.util.DBConnUtil;
import java.sql.Connection;
import java.sql.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class FinanceAppTest {

    static IFinanceRepository repo;
    static Connection testConnection;

    @BeforeClass
    public static void setup() throws Exception {
        System.out.println("\n[Setup] Initializing database connection and repository...");
        testConnection = DBConnUtil.getConnection();
        repo = new FinanceRepositoryImplement(testConnection); 
        System.out.println("[Setup Completed] Repository ready for testing.");
    }

    @Test
    public void test1_CreateUser() throws Exception {
        System.out.println("\n[Test 1] Starting testCreateUser");
        User u = new User(0, "testUser", "pass123", "test@mail.com");
        boolean result = repo.createUser(u);
        assertTrue("User creation failed!", result);
        System.out.println("[Test 1 Passed] testCreateUser completed successfully.");
    }

    @Test
    public void test2_CreateExpense() throws Exception {
        System.out.println("\n[Test 2] Starting testCreateExpense");
        Expense e = new Expense(0, 1, 500, 1, new Date(System.currentTimeMillis()), "Lunch");
        boolean result = repo.createExpense(e);
        assertTrue("Expense creation failed!", result);
        System.out.println("[Test 2 Passed] testCreateExpense completed successfully.");
    }

    @Test(expected = ExpenseNotFoundException.class)
    public void test3_ExpenseNotFoundException() throws Exception {
        System.out.println("\n[Test 3] Starting testExpenseNotFoundException");
        repo.deleteExpense(9999);
        System.out.println("[Test 3 Passed] testExpenseNotFoundException completed successfully.");
    }

    @Test(expected = UserNotFoundException.class)
    public void test4_UserNotFoundException() throws Exception {
        System.out.println("\n[Test 4] Starting testUserNotFoundException");
        repo.deleteUser(9999);
        System.out.println("[Test 4 Passed] testUserNotFoundException completed successfully.");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        System.out.println("\n[TearDown] Closing database connection...");
        if (testConnection != null && !testConnection.isClosed()) {
            testConnection.close();
        }
        System.out.println("[TearDown Completed] All resources released.");
    }
}
