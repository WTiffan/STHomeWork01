//学生类
package HomeWorkPackage;

import java.util.*;

public class Student {
	//成员变量
	private String name; //学生姓名
	private int stuId; //学号
	private String birDate; //生日
	private boolean gender; //性别
	
	public String getName() {
		return name;
	}
	public int getStuId() {
		return stuId;
	}
	public String getBirDate() {
		return birDate;
	}
	public boolean getGender() {
		return gender;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setStuId(int id) {
		this.stuId = id;
	}
	public void setBirData(String birDate) {
		this.birDate = birDate;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	} 
	
}
