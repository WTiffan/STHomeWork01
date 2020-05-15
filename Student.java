//学生类
package HomeWorkPackage;

//26
//import java.util.*;

import java.util.*;

@SuppressWarnings("unused")
public class Student {
	//成员变量
	private String name; //学生姓名
	private int stuId; //学号
	private String birDate; //生日
	private boolean gender; //性别

// 8	
//	public String getName() {
//		return name;
//	}
//	public int getStuId() {
//		return stuId;
//	}
//	public String getBirDate() {
//		return birDate;
//	}
//	public boolean getGender() {
//		return gender;
//	}
//	
//	public void setName(String name) {
//		this.name = name;
//	}
//	public void setStuId(int id) {
//		this.stuId = id;
//	}
//	public void setBirData(String birDate) {
//		this.birDate = birDate;
//	}
//	public void setGender(boolean gender) {
//		this.gender = gender;
//	} 
	
//修正：
	//功能：获取 or 返回学生姓名
	public String getName() {
		return name;
	}
	//功能：获取 or 返回学生学号
	public int getStuId() {
		return stuId;
	}
	//功能：获取 or 返回学生生日
	public String getBirDate() {
		return birDate;
	}
	//功能：获取 or 返回学生性别
	public boolean getGender() {
		return gender;
	}
	
	//输入：姓名(字符型)
	//功能：修改学生姓名 or 给学生姓名赋值
	//返回：无返回值
	public void setName(String name) {
		this.name = name;
	}
	//输入：学号(整型)
	//功能：修改学生学号 or 给学生学号赋值
	//返回：无返回值
	public void setStuId(int id) {
		this.stuId = id;
	}
	//输入：生日(字符型)
	//功能：修改学生生日 or 给学生生日变量赋值
	//返回：无返回值
	public void setBirData(String birDate) {
		this.birDate = birDate;
	}
	//输入：性别(布尔型)
	//功能：修改学生性别 or 给学生性别变量赋值
	//返回：无返回值
	public void setGender(boolean gender) {
		this.gender = gender;
	} 
	
}
