package Ansin.web.service;

import java.io.IOException;

import Ansin.web.bean.HomeInitBean;

public interface HomeService {
	// 画面初期化情報を取得
	HomeInitBean getHomeInitResponse();
	
	// 広告写真を転換
	HomeInitBean confirmOutput(HomeInitBean homeInitBean) throws IOException;

}
