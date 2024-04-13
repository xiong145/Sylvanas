package test.server;

import org.apache.commons.codec.digest.DigestUtils;

public class md6 {
    public static void main(String[] args) {
        String a = DigestUtils.md5Hex("{\"amount\":0.03,\"blAudit\":0,\"calcTime\":1712051777271,\"chargeItemId\":382,\"createdBy\":550336,\"ewbNo\":\"300767371121\",\"operationTypeId\":201,\"routeIncomeSiteId\":1625,\"routePaySiteId\":57049,\"transType\":1}");
        System.out.println(a);
        String b = DigestUtils.md5Hex("{\"amount\":0.03,\"blAudit\":0,\"calcTime\":1712051777263,\"chargeItemId\":382,\"createdBy\":550336,\"ewbNo\":\"300767371121\",\"operationTypeId\":201,\"routeIncomeSiteId\":null,\"routePaySiteId\":57049,\"transType\":1}");
        System.out.println(b);
    }
}
