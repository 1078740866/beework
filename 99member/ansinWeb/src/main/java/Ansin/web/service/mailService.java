package Ansin.web.service;

public interface mailService {

			//C0401初期都道県選択リストを取得
	boolean sendPwReSetMail(String mail,String code);

}
