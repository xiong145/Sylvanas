package test.Test;

import java.io.Serializable;
import java.util.Date;

/**
 * 对公账号充值表类.
 *
 * @author
 */
public class AuditInformationRecordVO implements Serializable {
    /**
     * 帐号
     */
    private String accnbr;
    /**
     * 记账子单元编号
     */
    private String dmanbr;
    /**
     * 记账子单元名称
     */
    private String dmanam;
    /**
     * 记账流水号
     */
    private String trxnbr;
    /**
     * 币种 人民币10
     */
    private String ccynbr;
    /**
     * 交易金额
     */
    private Double trxamt;
    /**
     * 交易方向 D-借方（支出）C-贷方（收入）
     */
    private String trxdir;
    /**
     * 交易时间
     */
    private Date trxtim;
    /**
     * 收方/付方账号 与交易方向对应
     * 交易方向为D时，这里为收方信息；交易方向为C时，这里为付方信息。
     */
    private String rpyacc;
    /**
     * 收方/付方名称
     */
    private String rpynam;
    /**
     * 交易摘要
     */
    private String trxtxt;
    /**
     * 原内部编号
     */
    private String narinn;
    /**
     * 匹配标志 空表示未设置关联付方账号匹配
     */
    private String mthflg;
    /**
     * 网点id
     */
    private Long siteId;
    /**
     * 大运流水号
     */
    private Long accountBroughtId;

    /**
     * 创建时间
     * @return
     */
    private Date createdTime;
    /**
     * 网点账号
     */
    private String siteAccount;

    private Integer bankType;

    public Integer getBankType() {
        return bankType;
    }

    public void setBankType(Integer bankType) {
        this.bankType = bankType;
    }

    public String getSiteAccount() {
        return siteAccount;
    }

    public void setSiteAccount(String siteAccount) {
        this.siteAccount = siteAccount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public Long getAccountBroughtId() {
        return accountBroughtId;
    }

    public void setAccountBroughtId(Long accountBroughtId) {
        this.accountBroughtId = accountBroughtId;
    }

    public String getAccnbr() {
        return accnbr;
    }

    public void setAccnbr(String accnbr) {
        this.accnbr = accnbr;
    }

    public String getDmanbr() {
        return dmanbr;
    }

    public void setDmanbr(String dmanbr) {
        this.dmanbr = dmanbr;
    }

    public String getDmanam() {
        return dmanam;
    }

    public void setDmanam(String dmanam) {
        this.dmanam = dmanam;
    }

    public String getTrxnbr() {
        return trxnbr;
    }

    public void setTrxnbr(String trxnbr) {
        this.trxnbr = trxnbr;
    }

    public String getCcynbr() {
        return ccynbr;
    }

    public void setCcynbr(String ccynbr) {
        this.ccynbr = ccynbr;
    }

    public Double getTrxamt() {
        return trxamt;
    }

    public void setTrxamt(Double trxamt) {
        this.trxamt = trxamt;
    }

    public String getTrxdir() {
        return trxdir;
    }

    public void setTrxdir(String trxdir) {
        this.trxdir = trxdir;
    }

    public Date getTrxtim() {
        return trxtim;
    }

    public void setTrxtim(Date trxtim) {
        this.trxtim = trxtim;
    }

    public String getRpyacc() {
        return rpyacc;
    }

    public void setRpyacc(String rpyacc) {
        this.rpyacc = rpyacc;
    }

    public String getRpynam() {
        return rpynam;
    }

    public void setRpynam(String rpynam) {
        this.rpynam = rpynam;
    }

    public String getTrxtxt() {
        return trxtxt;
    }

    public void setTrxtxt(String trxtxt) {
        this.trxtxt = trxtxt;
    }

    public String getNarinn() {
        return narinn;
    }

    public void setNarinn(String narinn) {
        this.narinn = narinn;
    }

    public String getMthflg() {
        return mthflg;
    }

    public void setMthflg(String mthflg) {
        this.mthflg = mthflg;
    }
}
