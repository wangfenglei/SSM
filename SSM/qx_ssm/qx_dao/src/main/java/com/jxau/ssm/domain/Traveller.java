package com.jxau.ssm.domain;
//旅客
public class Traveller {
    private String id;                    //id
    private String name;                  //姓名
    private String sex;                   //性别
    private String phoneNum;              //手机号码
    private Integer credentialsType;      //证件类型 证件类型 0身份证 1护照 2军官证
    private String credentialsTypeStr;    //证件类型 0身份证 1护照 2军官证
    private String credentialsNum;        //证件号码
    private Integer travellerType;        //旅客类型(人群) 0 成人 1 儿童
    private String travellerTypeStr;      //0 成人 1 儿童

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
        if (credentialsType != null){
            if (credentialsType == 0){
                setCredentialsTypeStr("身份证");
            }
            if (credentialsType == 1){
                setCredentialsTypeStr("护照");
            }
            if (credentialsType == 2){
                setCredentialsTypeStr("军官证");
            }
        }
    }

    public String getCredentialsTypeStr() {
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;

        if (travellerType != null) {
            if (travellerType == 0){
                setTravellerTypeStr("成人");
            }
            if (travellerType == 1){
                setTravellerTypeStr("儿童");
            }
        }
    }

    public String getTravellerTypeStr() {
        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }
}
