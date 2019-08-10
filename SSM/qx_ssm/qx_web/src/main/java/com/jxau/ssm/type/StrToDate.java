package com.jxau.ssm.type;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wfl
 * @date
 * @description
 *
 * 自定义类型转换器 String  -->  Date
 */
public class StrToDate implements Converter<String, Date> {

    @Override
    public Date convert(String source) {

        if (source == null){
            throw  new RuntimeException("请传入数据");
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            return df.parse(source);
        } catch (ParseException e) {

            SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM-/dd HH:mm");
            try {
                return df.parse(source);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            throw  new RuntimeException("数据转换失败");
        }
    }
}
