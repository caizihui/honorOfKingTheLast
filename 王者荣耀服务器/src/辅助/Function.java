package 辅助;

import java.util.LinkedList;

import 角色.Role;

/**
 * 函数类
 * @author 蔡子辉
 *
 */
public class Function {
	//私有方法区：
	/**
	 * 随机产生一个角色的行为指令
	 * @return String
	 */
	public static String getAction() {
		 int number = (int)(Math.random()*100);
		 
		 if(number <= 80) {
			 return "走";
		 }
		 
		 else if(number <= 90) {
			 return "复杂";
		 }
		 
		 else {
			 return "简单";
		 }
	 }
	 
	/**
	 * 随机产生一个方向
	 * @return String
	 */
	public static String getDirection() {
		 int number = (int)(Math.random()*4);
			
			if(number == 0) {
				return "上";
			}
			
			else if(number == 1) {
				return "下";
			}
			
			else if(number == 2) {
				return "左";
			}
			
			else {
				return "右";
			}
	 }
	
	
	//公有方法区：
	/**
	 * 判断一个描述是否是角色
	 * @param description 描述
	 * @return boolean
	 */
	public static boolean isRole(String description) {
		 if(isFirstRole(description) || isSecondRole(description)) {
			 return true;
		 }
		 
		 return false;
	 }
	
	/**
	 * 判断一个描述是否是一队角色
	 * @param description 角色描述
	 * @return boolean
	 */
	public static boolean isFirstRole(String description) {
		if(description.equals(PictureName.ROLE_A) ||
		   description.equals(PictureName.ROLE_a) ||
		   description.equals(RoleName.ROLE_A) ||
		   description.equals(RoleName.ROLE_a) ) {
			 return true;
		 }
		
		 return false;
	 }
	
	/**
	 * 判断一个描述是否是二队角色
	 * @param description 描述
	 * @return boolean
	 */
	public static boolean isSecondRole(String description) {
		 if(description.equals(PictureName.ROLE_N) ||
			description.equals(PictureName.ROLE_n) ||
			description.equals(RoleName.ROLE_N) ||
			description.equals(RoleName.ROLE_n) ) {
			 
			 return true;
		 }
		 
		 return false;
	 }
	
	/**
	 * 判断一个描述是否是李白
	 * @param description 指定的描述
	 * @return boolean
	 */
	public static boolean isLiPo(String description) {
		 if(description.equals(PictureName.ROLE_A) ||
			description.equals(PictureName.ROLE_N)) {
			 
			 return true;
		 }
		 
		 if(description.equals(PictureName.ROLE_A_CHOOSE) ||
			description.equals(PictureName.ROLE_N_CHOOSE)) {
					 
			 return true;
		}
		 
		 if(description.equals(RoleName.ROLE_A) ||
			description.equals(RoleName.ROLE_N)) {
					 
			return true;
		}
				 
		return false;
	 }
	
	/**
	 * 在指定集合里找到符合描述的角色
	 * @param tempPoint 指定点
	 * @param firstRole 集合一
	 * @param secondRole 集合二
	 * @return Role 获得的角色
	 */
	public static Role searchRole(Point tempPoint,LinkedList<Role>firstRole,LinkedList<Role>secondRole) {
		 int i;
		 
		 for(i=0 ; i<firstRole.size() ; i++) {
			 if(firstRole.get(i).rolePosition.isSameWith(tempPoint)) {
				 return firstRole.get(i);
			 }
		 }
		 
		 for(i=0 ; i<secondRole.size() ; i++) {
			 if(secondRole.get(i).rolePosition.isSameWith(tempPoint)) {
				 return secondRole.get(i);
			 }
		 }
		 
		 return null;
	 }
	 
	/**
	 * 判断两个描述对应的角色是否是队友
	 * @param description1 角色描述1
	 * @param description2 角色描述2
	 * @return boolean
	 */
	public static boolean isFriend(String description1,String description2) {
		 int tag1,tag2;
		 
		 if(isFirstRole(description1)) {
			 tag1 = 1;
		 }
		 
		 else {
			 tag1 = -1;
		 }
		 
		 if(isFirstRole(description2)) {
			 tag2 = 1;
		 }
		 
		 else {
			 tag2 = -1;
		 }
		 
		 if(tag1*tag2 > 0) {
			 return true;
		 }
		 
		 else {
			 return false;
		 }
	 }
	 
	/**
	 * 在指定角色集合中移除指定角色
	 * @param R 需移除的角色
	 * @param firstRole 角色集合一
	 * @param secondRole 角色集合二
	 */
	public static void remove(Role R,LinkedList<Role>firstRole,LinkedList<Role>secondRole) {
		 if(firstRole.contains(R)) {
			 firstRole.remove(R);
		 }
		 
		 else if(secondRole.contains(R)) {
			 secondRole.remove(R);
		 }
	 }

	/**
	 * 将角色描述和角色名称进行互译
	 * @param oldString 获取的字符串
	 * @return String 新字符串
	 */
	public static String translate(String oldString) {
		 switch(oldString) {
		 //照片名转真名：
		 case PictureName.ROLE_A:
			 return RoleName.ROLE_A;
		 case PictureName.ROLE_a:
			 return RoleName.ROLE_a;
			 
		 case PictureName.ROLE_N:
			 return RoleName.ROLE_N;
		 case PictureName.ROLE_n:
			 return RoleName.ROLE_n;
			 
		//真名转照片名：
		 case RoleName.ROLE_A:
			 return PictureName.ROLE_A;
		 case RoleName.ROLE_a:
			 return PictureName.ROLE_a;
			 
		 case RoleName.ROLE_N:
			 return PictureName.ROLE_N;
		 case RoleName.ROLE_n:
			 return PictureName.ROLE_n;
		 }
		 
		 return null;
	 }

	/**
	 * 获取针对当前屏幕的宽度
	 * @param oldSize 针对1920来说的宽
	 * @return 针对当前屏幕宽的宽
	 */
	public static int realWidthOf(int oldSize) {
		return (int)(oldSize*Size.WIDTH_SCALING);
	}
	
	public static int realHeightOf(int oldSize) {
		return (int)(oldSize*Size.HEIGHT_SCALING);
	}
	
}
