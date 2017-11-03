package cn.htd.argus.emuns;

/**
 * Created by wangtp on 2017/9/27.
 */
public enum ResultCodeEnum {
    SUCCESS("1", "成功！"),
    FAIL("0", "失败！"),
    ERROR_SERVER_EXCEPTION("1001", "服务器错误！"),
    ERROR_IS_NOT_MENBER("2001", "会员不存在！"),
    LOGIN_TIMEOUT("9001", "登录超时！");

    private String code;
    private String Msg;

    private ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.Msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.Msg;
    }

    public void setMsg(String msg) {
        this.Msg = msg;
    }
}
