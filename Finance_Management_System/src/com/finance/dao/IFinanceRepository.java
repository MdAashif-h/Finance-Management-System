package com.finance.dao;

import java.util.List;
import com.finance.entity.*;
import com.finance.exception.*;

public interface IFinanceRepository {
	boolean viewUsers(User user);
    boolean createUser(User user);
    boolean deleteUser(int userId) throws UserNotFoundException;
    boolean createExpense(Expense expense);
    boolean deleteExpense(int expenseId) throws ExpenseNotFoundException;
    boolean updateExpense(int userId, Expense expense) throws ExpenseNotFoundException;
    List<Expense> getAllExpenses(int userId) throws UserNotFoundException;
}
