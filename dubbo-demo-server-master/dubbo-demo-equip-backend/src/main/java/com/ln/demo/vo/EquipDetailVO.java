package com.ln.demo.vo;

/**
 * 角色详情vo类
 * 
 * @author Lining
 * @date 2018/2/6
 */
public final class EquipDetailVO {

    private Integer id;

    private Integer sbxh;
    private String sblb;
    private String sbmc;
    private String sbzt;
    private String xb;
    private String cz;
    private String cjxx;
    private String syrq;
    private String wxjl;
    private String bjghjl;

    private Boolean locked;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

    public Integer getSbxh() {
		return sbxh;
	}

	public void setSbxh(Integer sbxh) {
		this.sbxh = sbxh;
	}

	public String getSblb() {
		return sblb;
	}

	public void setSblb(String sblb) {
		this.sblb = sblb;
	}

	public String getSbmc() {
		return sbmc;
	}

	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}

	public String getSbzt() {
		return sbzt;
	}

	public void setSbzt(String sbzt) {
		this.sbzt = sbzt;
	}

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public String getCz() {
		return cz;
	}

	public void setCz(String cz) {
		this.cz = cz;
	}

	public String getCjxx() {
		return cjxx;
	}

	public void setCjxx(String cjxx) {
		this.cjxx = cjxx;
	}

	public String getSyrq() {
		return syrq;
	}

	public void setSyrq(String syrq) {
		this.syrq = syrq;
	}

	public String getWxjl() {
		return wxjl;
	}

	public void setWxjl(String wxjl) {
		this.wxjl = wxjl;
	}

	public String getBjghjl() {
		return bjghjl;
	}

	public void setBjghjl(String bjghjl) {
		this.bjghjl = bjghjl;
	}

	public Boolean getLocked() {
        return this.locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

}
