package au.company.product.lib.common.util;

public enum Error {

    USER_AUTH_NOT_FOUND("101","User requires at least one role"),
    ROLE_REQUIRE_FUNCTION("102","Role requires at least one function"),
    DATA_NOT_FOUND("001","Data not found"),
	USER_NOT_FOUND("002","User not found"),
	
	
	CURRENCY_NOT_FOUND("62001","Currency not found"),
	STOCK_NOT_FOUND("62002","Stock not found"),
	TXN_TYPE_NOT_FOUND("62003","Txn type not found"),
	STOCK_CURRENCY_REQUIRED("62004","At least one currency is required"),
	JSON_FILE_NOT_FOUND("62005","Json file not found"),
	STOCK_UOM_NOT_FOUND("62006","Stock UOM not found"),
	INVALID_JSON_CONTENT("62007","Invalid content in JSON file"),
	INVALID_DATA_VALUE("62008","Invalid DataStatus value"),
	INVALID_TXN_TYPE_MODE("62009","Invalid TxnTypeMode value"),
	INVESTMENT_NAME_IS_REQUIRED("62010","Investment name is required"),
	INVESTER_NOT_FOUND("62011","Invester not found")
	;
	
    private final String description;
	private final String code;

    Error(String code,String description){
        this.description = description;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

	public String getCode() {
		return code;
	}
    
    // TODO Handle Error codes 
}
