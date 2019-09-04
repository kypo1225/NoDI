package com.example.demo;

import org.springframework.stereotype.Repository;

@Repository
public class ShainRepositoryImpl implements ShainRepository {

	@Override
	//DBに接続したつもりコード
	public String selectByNo(String number) {
		String name;
		switch(number) {
		case "100":
		name = "佐藤";
		break;
		case "101":
		name = "松尾";
		break;
		default:
			name = "登録されていません";
		}
		return name;
	}

}
