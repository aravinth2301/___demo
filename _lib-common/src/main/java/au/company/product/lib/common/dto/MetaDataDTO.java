package au.company.product.lib.common.dto;

import java.util.List;

public class MetaDataDTO {

	private String version;
	
	private List<String> versionHistory;
	
	public List<String> getVersionHistory() {
		return versionHistory;
	}

	public void setVersionHistory(List<String> versionHistory) {
		this.versionHistory = versionHistory;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	
}
