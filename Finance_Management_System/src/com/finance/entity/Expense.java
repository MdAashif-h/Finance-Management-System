package com.finance.entity;

import java.sql.Date;

public class Expense {
	 private int expenseId;
	    private int userId;
	    private double amount;
	    private int categoryId;
	    private Date date;
	    private String description;
	    
	    
		public Expense() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Expense(int expenseId, int userId, double amount, int categoryId, Date date, String description) {
			super();
			this.expenseId = expenseId;
			this.userId = userId;
			this.amount = amount;
			this.categoryId = categoryId;
			this.date = date;
			this.description = description;
		}


		public int getExpenseId() {
			return expenseId;
		}


		public void setExpenseId(int expenseId) {
			this.expenseId = expenseId;
		}


		public int getUserId() {
			return userId;
		}


		public void setUserId(int userId) {
			this.userId = userId;
		}


		public double getAmount() {
			return amount;
		}


		public void setAmount(double amount) {
			this.amount = amount;
		}


		public int getCategoryId() {
			return categoryId;
		}


		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}


		public Date getDate() {
			return date;
		}


		public void setDate(Date date) {
			this.date = date;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		@Override
		public String toString() {
			return "Expense [expenseId=" + expenseId + ", userId=" + userId + ", amount=" + amount + ", categoryId="
					+ categoryId + ", date=" + date + ", description=" + description + "]";
		}
	    
	    
	    
}
