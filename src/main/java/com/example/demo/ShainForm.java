package com.example.demo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ShainForm {
	//空じゃないかチェック
	@NotEmpty(message = "社員ナンバーを入れてくださいね")
	@Pattern(regexp = "\\d{3}", message = "半角数字、3桁でよろ")
	//index.htmlのnumberを定義
	private String number;

	//getter,setterは必須
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	

}
	
