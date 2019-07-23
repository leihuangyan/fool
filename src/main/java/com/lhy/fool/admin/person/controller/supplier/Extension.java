package com.lhy.fool.admin.person.controller.supplier;

public class Extension {
    /**
     *账期
     */
    private String accountPeriod;

    /**
     *分机
     */
    private String extension;

    /**
     *备注
     */
    private String remark;

	public String getAccountPeriod() {
		return accountPeriod;
	}

	public void setAccountPeriod(String accountPeriod) {
		this.accountPeriod = accountPeriod;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Extension [accountPeriod=" + accountPeriod + ", extension="
				+ extension + ", remark=" + remark + "]";
	}


	
}
