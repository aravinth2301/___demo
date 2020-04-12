package au.company.product.lib.common.quartz;

public abstract class AppJob implements Runnable{


	private String jobId;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
}
