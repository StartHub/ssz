package com.jusfoun.ssz.web.crowd.contants;

public class ZbContants {

    //类型；0：需求表附件，1：方案表附件
    public static final  Short ZB_ANNEX_TYPE_REQUIREMENT = 0;
    public static final  Short ZB_ANNEX_TYPE_PROGRAM = 1;

    public static final String ADDTIME = "addTime";
    public static final String CHECKTIME = "checkTime";
    public static final String TRUSTEETIME = "trusteeTime";
    public static final String PRESSTIME = "pressTime";
    public static final String WORKINGTIME = "workingTime";
    public static final String PAYTIME = "payTime";
    public static final String COMMENTTIME = "commentTime";
    public static final String APPLYTIME = "applyTime";
    public static final String SUBMITTIME = "submitTime";
    public static final String PLATEVALTIME = "platevalTime";
    public static final String REQUIREDACCEPTTIME = "requiredAcceptTime";
    //资格评选时间
    public static final String SELECTTIME = "selectTime";
    //服务商对需求方评价时间
    public static final String REQUIRECOMMENTTIME = "requireCommentTime";
    //待退款
    public static final String TOBEREFUNDEDTIME = "toBeRefundedTime";

    // 交易取消时间
    public static final String CANCELTIME = "cancelTime";

    /**
     * 需求周期状态
     0关闭
     1需求登记
     2需求分析
     3需求确认

     */
    public enum Zb_Require_Status {

        CLOSE(0),
        REGISTER(1),
        ANALYSIS(2),
        CONFIRM(3),
//        WAIT_FB(4),
//        SINGING(5),
//        SELECTING(6),
//        WAIT_TWO_TG(7),
//        WORKINGING(8),
//        WAIT_PLAT_YS(9),
//        WAIT_buyer_YS(10),
//        WAIT_FK(11),
//        TWO_WORKING(12),
//        WAIT_PJ(13),
//        ZB_CANCEL(14),
//        ZB_SUCCESS(15),
//        WAIT_TK(16),
//        DELETE(17),
//        CANCEL(18),
//        FAIL_TO_SOLD(19),
//        BREA_FAILE(20),
//        DATE_EXPIRE(21),
        ;

        public Integer code;

        Zb_Require_Status(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }
    }

    /**
     * 供应商认证
     * 0.未认证 1.审核中 2.已认证 3.认证失败
     */
    public enum Provider_Auth_Status {

        AUTH_NO(0),
        AUTH_CHECKING(1),
        AUTH_SUCCESS(2),
        AUTH_FAIL(3)
        ;

        public Integer code;

        Provider_Auth_Status(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }
    }

    /**
     * 方案状态
     * 方案状态：默认0 平台审核通过1 平台审核不通过2 需方审核通过3 需方审核不通过4  需方审核驳回5
     */
    public enum Program_Status {

        DEFAULT(Short.valueOf("0")),
        PROGRAM_SUCCESS(Short.valueOf("3")),
        PROGRAM_FAIL(Short.valueOf("4")),
        PROGRAM_REJECT(Short.valueOf("5")),
        SYSTEM_SUCCESS(Short.valueOf("1")),
        SYSTEM_FAIL(Short.valueOf("2"));

        public short code;

        Program_Status(short code) {
            this.code = code;
        }

        public short getCode() {
            return code;
        }
    }

    /**
     * 评价状态
     * 0.待审核 1.审核通过，2.审核不通过
     */
    public enum Comment_Status {

        WAIT_CHECK(0),
        CHECK_SUCCESS(1),
        CHECK_FAIL(2);

        public Integer code;

        Comment_Status(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }
    }


    /**
     * 托管赏金流水状态
     * 0.初始 1.成功，2.失败
     */
    public enum Trustee_Record_Status {

        RECORD_INITIAL(Short.valueOf("0")),
        RECORD_SUCCESS(Short.valueOf("1")),
        RECORD_FAIL(Short.valueOf("2"));

        public short code;

        Trustee_Record_Status(short code) {
            this.code = code;
        }

        public short getCode() {
            return code;
        }
    }

    /**
     * 服务商认证类型
     * 1.个人，2.企业
     */
    public enum ProviderAuthType {

        PERSON(1),
        COMPANY(2)
        ;

        public Integer code;

        ProviderAuthType(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }
    }

    public enum ZbRequireMentApplyStatus {

        /**
         * 状态；0 ：已报名；1：已被选中(工作中) 2:未中标  3：评审中 4：验收中 5：待付款 6：待评价
         * 7：驳回失败(交易取消) 8：交易完成 9:违约失败(交易取消)
         **/

        APPLY_SUCCESS(0),
        WORKING(1),
        LOSE_BID(2),
        REVIEW(3),
        ACCEPTANCE(4),
        PAYMENT_ING(5),
        COMMENT_ING(6),
        DEAL_CANCE(7),
        DEAL_SUCCESS(8),
        DEAL_RENEGE_FAIL(9);

        public Integer code;

        ZbRequireMentApplyStatus(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }
    }

    /**
     * 平台付款类型
        1流标退款
        2违规到期未提交成果退款
        3需求驳回退款
        4付款给服务商
     */
    public enum PlatPayType {

        FAIL_TO_SOLD(1),
        DATE_EXPIRE(2),
        BREA_FAILE(3),
        PAY_TO_PROVIDER(4)
        ;

        public Integer code;

        PlatPayType(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }
    }

    /**
     * 信誉评价体系：
     *  评价分为5个等级：好评、较好、中评、较差和差评；
     *  每种评价对应1个分值,具体为:好评+2分,较好+1，中评0，较差-1，差评-2；
     *  每个用户基础分60分，通过身份认证加10分，手机认证加5分，邮箱认证加5分；由双方互评。
     */
    public enum UCreditValue {

        C_V_5(2),
        C_V_4(1),
        C_V_3(0),
        C_V_2(-1),
        C_V_1(-2),
        ;

        public Integer code;

        UCreditValue(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }
    }

}
