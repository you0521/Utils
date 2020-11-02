package com.example.administrator.jetsenstudy.u.utils;

import android.hardware.Camera;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @className: CommonUtil
 * @classDescription: 通用工具类
 * @author: miao
 * @createTime: 2017年2月10日
 */
public class CommonUtil {

    /**
     * @author miao
     * @createTime 2017年2月10日
     * @lastModify 2017年2月10日
     * @param
     * @return
     */
    public static boolean isCameraCanUse() {
            boolean canUse = true;
            Camera mCamera = null;
            try {
                mCamera = Camera.open();
            } catch (Exception e) {
                canUse = false;
            }
            if (canUse) {
                if (mCamera != null)
                    mCamera.release();
                mCamera = null;
            }
            return canUse;
    }

    public static List removeDuplicate(List list) {
        List listTemp = new ArrayList();
        for(int i=0;i<list.size();i++){
            if(!listTemp.contains(list.get(i))){
                listTemp.add(list.get(i));
            }
        }
        return listTemp;
    }
}
