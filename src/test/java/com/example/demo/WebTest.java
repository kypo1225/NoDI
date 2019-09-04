package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//コントローラークラステストでlocalhost:8080にWebアクセスできるかどうかのテスト
//SpringBoot機能を使ったJUnit
@RunWith(SpringJUnit4ClassRunner.class)
	@SpringBootTest
	public class WebTest {
	//Webサーバ起動しなくても似たような振舞ってくれるクラス（モック）
		private MockMvc mockMvc;
		
		@Autowired //対象となるクラスを定義
		ShainController target;
		
		@Before //この対象を使い、アプリをデプロイせずに動きを再現してくれる
		public void setup() {
			mockMvc = MockMvcBuilders.standaloneSetup(target).build();
			
		}
		
		@Test //throws宣言しないとメソッド処理が赤線出る
		public void isStatusTest() throws Exception {
			//inputにアクセスしてstatus(ステータス)がOK似なるのかテスト
			mockMvc.perform(get("/xxxx")).andExpect(status().isOk());
			System.out.println();
		
		
	}

}