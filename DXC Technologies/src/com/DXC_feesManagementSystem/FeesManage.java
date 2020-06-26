package com.DXC_feesManagementSystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class UserClass<T> {
	T obj;

	void create(T obj) {
		this.obj = obj;
	}

	T getInstance() { //
		return obj;
	}
}

public class FeesManage {

	InputStreamReader isr = null;
	BufferedReader buff = null;
	Accountant acc = null;
	Admin admin = null;

	boolean collegeopen = true;
	String feesChoice;

	public static void main(String[] args) throws Exception {

		FeesManage mObject = new FeesManage();

		mObject.isr = new InputStreamReader(System.in);
		mObject.buff = new BufferedReader(mObject.isr);

		System.out.println("Welcome to the fees Management System");
		System.out.println("Enter Your Choice:");
		System.out.println("1.Accountant\n2. Admin Login");

		String mchoice = mObject.buff.readLine();
		if (mchoice.equalsIgnoreCase("2")) {
			System.out.println("Enter Your Name:");
			String Uname = mObject.buff.readLine();
			System.out.println("Enter Your Password:");
			String Upass = mObject.buff.readLine();
			if (Uname.equals("Admin") && Upass.equals("Admin1234")) {
				UserClass<Admin> obj = new UserClass<Admin>();
				obj.create(new Admin());
				mObject.admin = obj.getInstance();
				System.out.println("1.Add Accountant\n2.View Accountant\n3.LogOut");
				String mychoice = mObject.buff.readLine();
				do {

					switch (Integer.parseInt(mychoice)) {
					case 1:
						mObject.admin.addAccount(mObject.buff);
						break;
					case 2:
						mObject.admin.viewAccount(mObject.buff);
						break;
					case 3:
						mObject.admin.logOut(mObject.buff);
						break;
					default:
						System.out.println("You choose a Invalid Option");
						break;
					}
					System.out.println("Do you want to Continue\n yes\n no");
					String choice = mObject.buff.readLine();
					if (choice.equalsIgnoreCase("no"))
						mObject.collegeopen = false;
				} while (mObject.collegeopen);
			}
		} else if (mchoice.equalsIgnoreCase("1")) {
			UserClass<Accountant> obj = new UserClass<Accountant>();
			obj.create(new Accountant());
			mObject.acc = obj.getInstance();
			System.out.println("Choose Your Choice:");
			System.out.println("1.Add Student\n2.View student\n3.Edit Student\n4.Due Fees\n5.LogOut");
			String mychoice = mObject.buff.readLine();
			do {

				switch (Integer.parseInt(mychoice)) {
				case 1:
					mObject.acc.addStudent(mObject.buff);
					break;
				case 2:
					mObject.acc.viewStudent(mObject.buff);
					break;
				case 3:
					mObject.acc.editStudent(mObject.buff);
					break;
				case 4:
					mObject.acc.dueFees(mObject.buff);
					break;
				case 5:
					mObject.acc.logOut(mObject.buff);
					break;
				default:
					System.out.println("You choose the wrong option");
					break;

				}
				System.out.println("Do you want to Continue\n yes\n no");
				String choice = mObject.buff.readLine();
				if (choice.equalsIgnoreCase("no"))
					mObject.collegeopen = false;
			} while (mObject.collegeopen);
		}
	}
}