package com.example.demo;

//コントローラークラス

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //Bean化のアノテーション
public class ShainController {
	
	//ShainServiceをDI化してる
	private ShainService shainService;

	//ShainServiceのDI
	public ShainController(ShainService shainService) {
		this.shainService = shainService;
	}
	
	@ModelAttribute
	//ShainFormクラスを初期化して使う（RequestMappingが呼ばれる前に使う)
	public ShainForm setUpForm() {
		return new ShainForm();
	}

	@RequestMapping("/index")//URL
	public String index() {
		return "index.html";
	}
	
	@RequestMapping("/output")
	//numberとして、Stringとして扱う@RequestParam("number")で要素を受け取る
//	public String result(@RequestParam("number") String number, Model model) {
	
	//ShainFormでチェックを行ったものを引数で呼んでいる
	public String result(@Validated ShainForm shainForm, BindingResult bindingResult, Model model) {
		//入力チェックでbindingResultが未入力ならエラーだったらindex.htmlに戻ってエラーメッセージを出させる
		if(bindingResult.hasErrors()) {
			return "index.html";
	}
		//nameに定義してるから表示はコントローラー松尾が表示される
		//ShainFormのgetNumberを呼ぶ
		String number = shainForm.getNumber();
		//String name = "コントローラー松尾";
		String name = shainService.findByNo(number);
		model.addAttribute("number", number);
		model.addAttribute("name", name);
		//上の値をoutput.htmlに返す
		return "output.html";
	}
}
