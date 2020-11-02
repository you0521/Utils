package com.example.administrator.jetsenstudy.u.utils;

//import org.jivesoftware.smackx.muc.MultiUserChat;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.jetsenstudy.u.comm.WsApplication;

public class PubUtil {
    public static int firstFlag = 0;// 第一次加载fragment标记

    public static final String USER_DATA = "com.jetsen.education.ott.userdata";

    public static String notifyip = "192.168.9.120";
    //	public static String serverip = "198.9.3.125";
    public static String serverip = "192.168.9.120";
    //public static String serverport = "8080";
    public static String serverport = "7701";
    public static String roomname = "room1";
    //保定
//     public static String wsIp1 = "http://192.168.0.200:3000";
    //公司
//    public static String wsIp1 = "http://192.168.100.100:3000";
    public static String wsIp1 = "http://" + SpManager.getInstance().get("PC_IP") + ":3000";
//    public static String wsIp1 = "http://192.168.1.104:3000";
//    public static String wsIp1 = "http://192.168.0.110:3000";
    // 楼上环境
//    public static String wsIp1 = "http://198.9.6.248:3000";
//    public static String wsIp1 = "http://198.9.6.121:3000";
//    public static String wsIp1 = "http://198.9.6.252:3000";

    // 前端
//    public static String wsIp1 = "http://198.9.6.185";

    public static final String SERVERIP = "serverip";
    public static final String SERVERPORT = "serverport";
    public static final String NOTIFYIP = "notifyip";
    public static final String ROOMNAME = "roomname";
    public static final String LOGINUSERNAME = "loginusername";
    public static final String LOGINPASSWORD = "loginpassword";

    public static String username = "teacher";
    public static final String USERNAME = "username";
    public static final String PERSONID = "personid";
    public static String pUSERID = "";
    /**
     *  0:未选择图片 1：正在选择图片
     */
//	public static String selectPic = "0";

    /**
     * 记录当前课时
     */
    public static String currentClass = "";

    /**
     * 教师推送试题---kpointId
     */
    public static String kpointId = "";
    /**
     * 教师推送试题---lessonDetailId
     */
    public static String lessonDetailId = "";

    /**
     * 登录时加入的房间
     */
    //public static MultiUserChat multiUserChat;
    /**
     * 标记state 0未标 1听懂 2基本听懂 3未听懂
     */
    public static String state = "0";
    /**
     * 是否是第一次点亮知识点 0：第一次 1：不是第一次
     */
    public static String flagKnowledgePointId = "0";
    /**
     * 之前的KnowledgePointId
     */
    public static String oldKnowledgePointId = "";
    /**
     * 新的KnowledgePointId
     */
    public static String newKnowledgePointId = "";
    /**
     * 标记时提交的KnowledgePointId
     */
    public static String submitKnowledgePointId = "";
    /**
     * brightId
     */
    public static String brightid = "";
    /**
     * 签到标志 0:未签到 1：签到
     */
    public static String signflag = "0";
    /**
     * 保存选课后老师推送的path
     */
    public static String classpath = "";

    public static String personid;
    /**
     * 登录成功后返回的---用户id
     */
    public static String userid;
    /**
     * 保存测验正确率---正确
     */
    public static String TestRight = "";
    /**
     * 保存测验正确率---错误
     */
    public static String TestError = "";
    /**
     * 老师是否点过知识点 0：未点过   1：点过   2:学生没有签到，老师连续点亮知识点，自动弹出签到框
     */
    public static String isClickKnowledgePoint = "0";
    /**
     * 0:在前台运行       1：在后台运行
     */
    public static String isRunBack = "0";
    /**
     * 标记是否有已经有点亮的知识点 0：没有 1：有
     */
    public static String brightIdorNot = "0";
    /**
     * 试题选项
     */
    public static String quesValue[];
    /**
     * 试题选项id
     */
    public static String quesId[];
    /**
     * 试题选项Type
     */
    public static String quesType[];
    /**
     * 总题数
     */
    public static int sumQues = 0;

    /**
     * 保存学生作答选项值
     */
    public static String questionValue[];
    /**
     * 记录完成试题数
     */
    public static int doneQues = 0;
    /**
     * QuestionActivity运行状态 0：未运行 1：运行
     */
    public static String isRunQuesActivty = "0";
    /**
     * QuestionActivity运行状态 0：未运行 1：运行
     */
    public static String isRunAnswerActivty = "0";
    /**
     * 标记知识树是否加载完成 0：完成 1：未完成
     */
    public static String isFinishLoad = "1";


    public static Toast toast;

    public static String personiconUrl;

    public static String pushId = "";
    // 标记参与率统计接口
    public static String tagRightUrl = "/JStudy/client/CourseClient_labelTake";
    /**
     * 保存标记参与率---参与
     */
    public static String TagRight = "";
    /**
     * 保存标记参与率---没有参与
     */
    public static String TagError = "";

    public static String knowledgeRightUrl = "/JStudy/client/CourseClient_kpointGrasp";

    public static String openuser = "";

    public static String openpsw = "";

    public static void showInfo(Context context, String info) {
        if (toast == null) {
            toast = Toast.makeText(context, info, Toast.LENGTH_SHORT);
        } else {
            toast.setText(info);
        }
        toast.show();
    }
}
