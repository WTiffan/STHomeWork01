package HomeWorkPackage;

import java.util.*;

public class StudentManager {
	//成员变量
	//插入
	//创建数组来存放学生信息；
	private static Student[] std = new Student[100]; 
	//存放数组元素个数
	private static int StuNum = 0;
	
//----------------------------------------插入------------------------------------------
	public void StuInsert() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("请输入需要插入信息的条数：(最多输入20条)");
		int num = sc1.nextInt();
		if(num > 20) {
			System.out.println("要输入的信息条数过大，请重新输入！");
			StuInsert();
		}
			
		Scanner sc2 = new Scanner(System.in);
		//存nextLine内容
		String str;
		//str去空格后形成的新字符串组合成的数组
		String[] tempImfor = new String[4];
		System.out.println("请输入插入的信息：(输入格式为：学生姓名 学号 出生年月 性别)");
		
		//判断StuNum是否==0；若！=0；则需要在已有数据的基础之上插入，否则会覆盖原有数据
		if(StuNum == 0) {
			for(int n = 0; n < num; n++) {
				//str存输入的一整行
				str = sc2.nextLine();
				//去掉空格
				tempImfor = str.split(" ");
				
				Student st = new Student();
				st.setName(tempImfor[0]);
				st.setStuId(Integer.parseInt(tempImfor[1]));
				st.setBirData(tempImfor[2]);
				if(tempImfor[3].equals("女"))
					st.setGender(false);
				else if(tempImfor[3].equals("男"))
					st.setGender(true);
				
				std[n] = st;
				StuNum++;
			}
		}
		else {
			for(int n = 0; n < num; n++) {
				//str存输入的一整行
				str = sc2.nextLine();
				//去掉空格
				tempImfor = str.split(" ");
				
				Student st = new Student();
				st.setName(tempImfor[0]);
				st.setStuId(Integer.parseInt(tempImfor[1]));
				st.setBirData(tempImfor[2]);
				if(tempImfor[3].equals("女"))
					st.setGender(false);
				else if(tempImfor[3].equals("男"))
					st.setGender(true);
				
				std[StuNum++] = st;
			}
		}
		
		returnMenu();
	}
//	**********************************插入end******************************
	
//----------------------------------------输出------------------------------------------
	public void StuOutput() {
		if(std[0] == null) //未插入数据，不可输出
			System.out.println("当前无数据可输出，您可尝试先插入信息后再输出！");
		else {
			//为学生排序[学号递增]
			for(int i = 0; i < StuNum; i++) {
				for(int j = i+1; j < StuNum; j++) {
					if(std[i].getStuId() > std[j].getStuId()) {
						Student tmp = std[i];
						std[i] = std[j];
						std[j] = tmp;
					}
				}
			}
			
			System.out.println("   序号        " + " 姓名    " + "            学号           " + 
									"           出生年月        " + "     性    别 ");
			for(int n = 0; n < StuNum; n++) {
				int i = n+1;
				if(std[n].getGender())
					System.out.println("  "+i+"  "+"  "+std[n].getName()+"  "+"  "+std[n].getStuId()
						+"  "+"  "+std[n].getBirDate()+"  "+"  男      ");
				else 
					System.out.println("  "+i+"  "+"  "+std[n].getName()+"  "+"  "+std[n].getStuId()
							+"  "+"  "+std[n].getBirDate()+"  "+"  女      ");
			}
		}
		
		returnMenu();
		
	}
//**********************************输出end****************************************

//-------------------------------------------查找-------------------------------------------
	public void sortName() {
		System.out.println("请输入需查询的学生姓名：");
		
		Scanner scName = new Scanner(System.in);
		String name = scName.next();
		
		//存下标
		int index = -1;
		
		if(std[0] == null) 
			System.out.println("当前无数据可查找，您可尝试先插入信息后再尝试查找操作！");
		else {
			//用来存姓名
			String[] stuName = new String[100];
			for(int n = 0; n < StuNum; n++) {
				stuName[n] = std[n].getName();
			}
			
			for(int n = 0; n < StuNum; n++) {
				if(stuName[n].equals(name)) {
					index = n;
					break;
				}
			}
			
			if(index == -1) { 
				System.out.println("系统未找到该学生信息，请核对您所要查询的学生姓名是否正确！");
				sortName();
			}
			else {
				System.out.println("姓名    " + "         学号           " 
						+ "         出生年月        " + "   性    别 ");
				if(std[index].getGender())
					System.out.println(std[index].getName()+"   "+std[index].getStuId()
							+"   "+std[index].getBirDate()+"   男      ");
				else
					System.out.println(std[index].getName()+"   "+std[index].getStuId()
							+"   "+std[index].getBirDate()+"   女      ");
			}
		}
		
		returnMenu();
	}
//**********************************查找end****************************************

//-------------------------------------------删除-------------------------------------------
	public void deleteStu() {
		System.out.println("请输入需删除的学生姓名：");
		
		Scanner scName = new Scanner(System.in);
		String name = scName.next();
		
		//存下标
		int index = -1;
		
		if(std[0] == null) 
			System.out.println("当前无数据可删除，您可尝试先插入信息后再尝试删除操作！");
		else {
			//用来存姓名
			String[] stuName = new String[100];
			for(int n = 0; n < StuNum; n++) {
				stuName[n] = std[n].getName();
			}
			
			for(int n = 0; n < StuNum; n++) {
				if(stuName[n].equals(name)) {
					index = n;
					break;
				}
			}
			
			if(index == -1) { 
				System.out.println("系统未找到该学生信息，请核对您所输入的学生姓名是否正确！");
				deleteStu();
			}
			else {
				//前移，进行删除操作
				for(int n = index; n < StuNum; n++) {
					std[n] = std[n+1];
				}
				StuNum--; //人数少了1个
				System.out.println("已为您成功删除该学生信息，可尝试输出操作以查看！");
			}
		}
		returnMenu();
	}
//**********************************查找end****************************************

//-------------------------------------------修改-------------------------------------------	
	public void changeStu() {
		System.out.println("请输入需修改的学生姓名：");
		
		Scanner scName = new Scanner(System.in);
		String name = scName.next();
		
		//存下标
		int index = -1;
		
		if(std[0] == null) 
			System.out.println("当前无数据可修改，您可尝试先插入信息后再尝试修改操作！");
		else {
			//用来存姓名
			String[] stuName = new String[100];
			for(int n = 0; n < StuNum; n++) {
				stuName[n] = std[n].getName();
			}
			
			for(int n = 0; n < StuNum; n++) {
				if(stuName[n].equals(name)) {
					index = n;
					break;
				}
			}
			
			if(index == -1) { 
				System.out.println("系统未找到该学生信息，请核对您所输入的学生姓名是否正确！");
				sortName();
			}
			else {
				System.out.println("姓名    " + "         学号           " 
						+ "         出生年月        " + "   性    别 ");
				
				if(std[index].getGender())
					System.out.println(std[index].getName()+"   "+std[index].getStuId()
							+"   "+std[index].getBirDate()+"   男      ");
				else
					System.out.println(std[index].getName()+"   "+std[index].getStuId()
							+"   "+std[index].getBirDate()+"   女      ");
				
				System.out.println("请输入您的修改信息 (格式：姓名 学号 出生年月 性别；若仅修改其中之一，则输入修改信息回车即可)");
				Scanner scChange = new Scanner(System.in);
				String changeImfor = scChange.nextLine();
				
				if(changeImfor.indexOf(" ") != -1) { //输入的修改信息中包含空格
					//计算其中有几个空格
					int emptyNum = 0;
					for(int i = 0; i < changeImfor.length(); i++) {
						char tmp = changeImfor.charAt(i); //返回对应下标上的字符；
						if(tmp == ' ') 
							emptyNum++;
					}
					
					//依空格个数来创建暂存修改信息的数组
					String[] changeTmp = new String[emptyNum+1];
					changeTmp = changeImfor.split(" ");
					
					//对每个数组元素判断其是姓名、学号、出生年月还是性别
					for(int i = 0; i < changeTmp.length; i++) {
						changeImple(index, changeTmp[i]);
					}	
				}
				else { //无空格
					changeImple(index, changeImfor);
				}
			}
			System.out.println("已为您修改完毕，请尝试输出或查询操作查看！");
		}
		returnMenu();
	}
//**********************************修改end****************************************	
	
//-------------------------------------------修改实现封装-------------------------------------------
	private void changeImple(int index, String str) {
		//是否包含中文字符
		int n = 0;
		boolean flag = false; //是不是姓名或性别
		for(int  j= 0; j < str.length(); j++) {
			n = (int)str.charAt(j);
			if(19968 <= n && n <= 40869) { //在中文字符编码范围内：有中文字符
				//是性别
				if(str.equals("男") || str.equals("女")) {
					if(str.equals("男")) 
						std[index].setGender(true);
					else
						std[index].setGender(false);
				}
				//是姓名
				else {
					std[index].setName(str);
				}
				flag = true; //改了！
				break;
			} 
		}
		//输入的是出生年月或者学号或者英文名
		if(!flag) {
			int judge = 0;
			judge = (int)str.charAt(0);
			//出生日期
			if(str.contains("."))
				std[index].setBirData(str);
			//学号:首字符为数字
			else if(48 <= judge && judge <= 57)
				std[index].setStuId(Integer.parseInt(str));
			//英文名
			else 
				std[index].setName(str);
		} 
	}
//-------------------------------------------控制流程-------------------------------------------
	public void returnMenu() {
		System.out.println("********************");
		System.out.printf("%-8s", "*");
		System.out.printf("%s", "1.插入");
		System.out.printf("%18s", "*");
		System.out.println();
		
		System.out.printf("%-8s", "*");
		System.out.printf("%s", "2.输出");
		System.out.printf("%18s", "*");
		System.out.println();
		
		System.out.printf("%-8s", "*");
		System.out.printf("%s", "3.查询");
		System.out.printf("%18s", "*");
		System.out.println();
		
		System.out.printf("%-8s", "*");
		System.out.printf("%s", "4.退出");
		System.out.printf("%18s", "*");
		System.out.println();
		
		System.out.printf("%-8s", "*");
		System.out.printf("%s", "5.删除");
		System.out.printf("%18s", "*");
		System.out.println();
		
		System.out.printf("%-8s", "*");
		System.out.printf("%s", "6.修改");
		System.out.printf("%18s", "*");
		System.out.println();
		System.out.println("********************");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请选择操作：");
		String num = sc.next();

		if(num.equals("1")) {
			StuInsert();
		}
		else if(num.equals("2")) {
			StuOutput();
		}
		else if(num.equals("3")) {
			sortName();
		}
		else if(num.equals("4")) {
			Scanner yn = new Scanner(System.in);
			System.out.println("您确定要退出嘛？y/n");
			if(yn.nextLine().contentEquals("y")) {
				System.out.println("已为您退出程序！");
				return;
			}
			else 
				returnMenu();
		}
		else if(num.equals("5")) {
			deleteStu();
		}
		else if(num.equals("6")) {
			changeStu();
		}
		else {
			System.out.println("输入错误，请重新选择！");
			returnMenu();
		}
	}
}
