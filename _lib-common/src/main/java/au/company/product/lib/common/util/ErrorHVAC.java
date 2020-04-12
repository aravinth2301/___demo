package au.company.product.lib.common.util;

public enum ErrorHVAC {
    SCHEDULE_NOT_FOUND("61001","Schedule not found"),
    SCHEDULE_ROOMS_NOT_FOUND("61002","Rooms not found for Schedule"),
	SCHEDULE_DAYS_NOT_FOUND("61003","Days not found for Schedule");
    private final String description;
	private final String code;
    ErrorHVAC(String code,String description){
        this.description = description;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

	public String getCode() {
		return code;
	} 
}
