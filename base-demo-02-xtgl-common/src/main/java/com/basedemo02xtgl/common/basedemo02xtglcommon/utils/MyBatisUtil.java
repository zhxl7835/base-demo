package com.basedemo02xtgl.common.basedemo02xtglcommon.utils;


import com.basedemo02xtgl.common.basedemo02xtglcommon.vo.TbUser;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class MyBatisUtil {


    public static String getResultMap(Class<?> cls) throws Exception {
        String str = "";
        str = "<resultMap id=\"" + cls.getSimpleName() + "ResultMap\" type=\"" + cls.getName() + "\"> \r\n";
        // 每一行字符串
        String linestr = "";
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getType().getName().equals("java.lang.String")) {
                linestr = "\t<result column=\"" + getUpCaseReplace(field.getName()) + "\" property=\"" + field.getName()
                        + "\" jdbcType=\"VARCHAR\" />";
            } else {
                linestr = "\t<result column=\"" + getUpCaseReplace(field.getName()) + "\" property=\"" + field.getName()
                        + "\" jdbcType=\"INTEGER\" />";
            }
            linestr += "\r\n";
            str += linestr;
        }
        str += "</resultMap>";
        return str;
    }

    /**
     * 将驼峰命名替换成'_'
     *
     * @param str
     * @return
     */
    private static String getUpCaseReplace(String str) {
        List<String> listChar = getUpCaseList(str);
        for (int i = 0; i < listChar.size(); i++) {
            str = str.replace(listChar.get(i), "_" + listChar.get(i).toLowerCase());
        }
        return str;
    }

    /**
     * @param str
     * @Description: 输出字符串中的大写字母
     */
    private static List<String> getUpCaseList(String str) {
        List<String> listChar = new ArrayList<String>();
        // 转为char数组
        char[] ch = str.toCharArray();
        // 得到大写字母
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'A' && ch[i] <= 'Z') {
                listChar.add(String.valueOf(ch[i]));
            }
        }
        return listChar;
    }


    public static void main(String[] args) throws Exception {
        System.out.println(getResultMap(TbUser.class));
        // getColumnListNew(a.getClass());
    }
}
