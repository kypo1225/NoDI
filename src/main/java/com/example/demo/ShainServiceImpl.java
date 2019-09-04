package com.example.demo;

import org.springframework.stereotype.Service;

@Service //Bean化のアノテーション
public class ShainServiceImpl implements ShainService {
	
	private final ShainRepository shainRepository;
	//ShainRepositoryのDI(コンストラクタに似てる)
	public ShainServiceImpl(ShainRepository shainRepository) {
		this.shainRepository = shainRepository;
	}

	@Override
	public String findByNo(String number) {
		//リポジトリから社員を選択
		String name = shainRepository.selectByNo(number);
		return name;
	}

}
