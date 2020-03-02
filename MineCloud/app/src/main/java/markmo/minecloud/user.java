package markmo.minecloud;
import cn.bmob.v3.BmobObject;
/**
 * Created by 123 on 2018/5/6.
 */
public class user extends BmobObject {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    private String mobilePhoneNumber;
    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }
    public void setMobilePhoneNumber(String number) {
        this.mobilePhoneNumber = number;
    }


}
