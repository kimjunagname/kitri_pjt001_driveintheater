package com.kitri.project.user.dto;

import java.sql.Timestamp;

public class UserDto {
//	private int member_no;
	private String user_id;
	private String user_pwd;
//	private int user_cartype;
	private String user_cartype;
	private String user_name;
	private Timestamp user_birth;
	private String user_email;
	private String user_phone;
	private String grade_name;


	private int aTICKET_PAYNO;
	private String aUSER_ID; 
	private int aUSER_NO;
	private String aMOVIE_PALYDATE;
	private String aMOVIE_TITLE;
	private String aBRANCH_NAME;
	private int aTICKET_PAYCASH;
	private int aTICKET_PAYMILEAGE;
	private int aTICKET_PAYTOTAL;
	
	public String getaUSER_ID() {
    return aUSER_ID;
  }

  public void setaUSER_ID(String aUSER_ID) {
    this.aUSER_ID = aUSER_ID;
  }

  public int getaUSER_NO() {
    return aUSER_NO;
  }

  public void setaUSER_NO(int aUSER_NO) {
    this.aUSER_NO = aUSER_NO;
  }

  public String getaMOVIE_PALYDATE() {
    return aMOVIE_PALYDATE;
  }

  public void setaMOVIE_PALYDATE(String aMOVIE_PALYDATE) {
    this.aMOVIE_PALYDATE = aMOVIE_PALYDATE;
  }

  public String getaMOVIE_TITLE() {
    return aMOVIE_TITLE;
  }

  public void setaMOVIE_TITLE(String aMOVIE_TITLE) {
    this.aMOVIE_TITLE = aMOVIE_TITLE;
  }

  public String getaBRANCH_NAME() {
    return aBRANCH_NAME;
  }

  public void setaBRANCH_NAME(String aBRANCH_NAME) {
    this.aBRANCH_NAME = aBRANCH_NAME;
  }

  public int getaTICKET_PAYCASH() {
    return aTICKET_PAYCASH;
  }

  public void setaTICKET_PAYCASH(int aTICKET_PAYCASH) {
    this.aTICKET_PAYCASH = aTICKET_PAYCASH;
  }

  public int getaTICKET_PAYMILEAGE() {
    return aTICKET_PAYMILEAGE;
  }

  public void setaTICKET_PAYMILEAGE(int aTICKET_PAYMILEAGE) {
    this.aTICKET_PAYMILEAGE = aTICKET_PAYMILEAGE;
  }

  public int getaTICKET_PAYTOTAL() {
    return aTICKET_PAYTOTAL;
  }

  public void setaTICKET_PAYTOTAL(int aTICKET_PAYTOTAL) {
    this.aTICKET_PAYTOTAL = aTICKET_PAYTOTAL;
  }

  public String getGrade_name() {
    return grade_name;
  }

  public void setGrade_name(String grade_name) {
    this.grade_name = grade_name;
  }

 
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_cartype() {
		return user_cartype;
	}

	 
	public void setUser_cartype(String user_cartype) {
		this.user_cartype = user_cartype;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Timestamp getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(Timestamp user_birth) {
		this.user_birth = user_birth;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

  public int getaTICKET_PAYNO() {
    return aTICKET_PAYNO;
  }

  public void setaTICKET_PAYNO(int aTICKET_PAYNO) {
    this.aTICKET_PAYNO = aTICKET_PAYNO;
  }

}
