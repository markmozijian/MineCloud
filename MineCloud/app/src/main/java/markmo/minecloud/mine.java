package markmo.minecloud;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by 123 on 2018/5/8.
 */
public class mine extends BmobObject {
    private String eri;
   public String getEri() {
        return eri;
    }

    private String erp;
    public String getErp() {
        return erp;
    }

public String dcq;
    public String getDcq() {
        return dcq;
    }

    public String gc;
    public String getGc() {
        return gc;
    }

    public String location;
    public String getLocation() {
        return location;
    }

    public BmobFile video;
    public BmobFile getVideo(){return video;}

    public String number;
    public String getNumber() {
        return number;
    }

    public mine(String eri,String erp,String dcq,String gc ) {

        this.eri = eri;
        this.erp = erp;
        this.dcq = dcq;
        this.gc = gc;
    }
}
