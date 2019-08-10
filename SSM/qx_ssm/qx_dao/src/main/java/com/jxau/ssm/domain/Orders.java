package com.jxau.ssm.domain;
import com.jxau.ssm.utils.DateUtils;
import java.util.Date;
import java.util.List;

/**
 *
 * 订单实体类
 */
//订单
public class Orders {
    private String id;
    private String orderNum;             //订单编号 不为空 唯一
    private Date orderTime;              //下单时间
    private String orderTimeStr;
    private int orderStatus;             //订单状态
    private String orderStatusStr;
    private int peopleCount;             //出行人数
    private Product product;
    private String productId;               //产品id 外键
    private List<Traveller> travellers;
    private Member member;
    private String memberId;               //会员(联系人）id 外键
    private Integer payType;             //支付方式(0 支付宝 1 微信 2其它)
    private String payTypeStr;
    private String orderDesc;            //订单描述(其它信息)


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getOrderStatusStr() {
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
        if(orderTime!=null){
            setOrderTimeStr(DateUtils.date2String(orderTime,"yyyy-MM-dd HH:mm"));
        }
    }

    public String getOrderTimeStr() {
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
            //订单状态(0 未支付 1 已支付)
            if(orderStatus==0){
                setOrderStatusStr("未支付");
            }else if(orderStatus==1){
                setOrderStatusStr("已支付");
            }

    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
        //支付方式(0 支付宝 1 微信 2其它)
        if(payType==0){
            setPayTypeStr("支付宝");
        }else if(payType==1){
            setPayTypeStr("微信");
        }else if(payType==2){
            setPayTypeStr("其它");
        }
    }

    public String getPayTypeStr() {

        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }


    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +'\'' +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", orderStatus=" + orderStatus +'\'' +
                ", orderStatusStr='" + orderStatusStr + '\'' +
                ", peopleCount=" + peopleCount +'\'' +
                ", product=" + product +'\'' +
                ", travellers=" + travellers +'\'' +
                ", member=" + member +'\'' +
                ", payType=" + payType +'\'' +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                '}';
    }
}
