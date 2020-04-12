package au.company.product.lib.common.dto;

import java.util.Date;

public class ResponseDTO {

    private Date date;

    private String text;
    
    private String error;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
    
}
