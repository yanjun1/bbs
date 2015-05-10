package cn.edu.qtech.common;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class ImportActionForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private FormFile photo;
	public FormFile getPhoto() {
		return photo;
	}
	public void setPhoto(FormFile photo) {
		this.photo = photo;
	}

	
}