package cn.edu.qtech.common;

public enum SectionCategroy {
	
	RECOMMAND(1,"推荐"),
	ACTIVITY(2,"活动中心"),
	NORMAL(3,"普通帖子");
	
	public int value;
	public String msg;
	
	SectionCategroy(int value,String msg){
		this.value = value;
		this.msg = msg;
	}

}
