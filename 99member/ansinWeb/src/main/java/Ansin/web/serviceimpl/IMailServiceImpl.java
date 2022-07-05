package Ansin.web.serviceimpl;

import java.security.GeneralSecurityException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sun.mail.util.MailSSLSocketFactory;

import Ansin.web.service.mailService;

@Service
public class IMailServiceImpl implements mailService{

	@Autowired
    private JavaMailSender mailSender;

	@Value("${spring.mail.username}")
    private String sender; //读取配置文件中的参数

	public  boolean sendPwReSetMail(String mail,String code) {

		MailSSLSocketFactory sf;
		try {
			sf = new MailSSLSocketFactory();
		} catch (GeneralSecurityException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		Properties properties = new Properties();
        properties.put("mail.transport.protocol","smtp");//协议
        properties.put("mail.smtp.host","smtp.an-sin.co.jp");
        properties.put("mail.smtp.port",587);//端口号
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.ssl.enable","false");//设置ssl安全连接
        properties.put("mail.debug","true");//显示debug信息
        try {
			sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			properties.put("mail.smtp.ssl.socketFactory", sf);
		} catch (GeneralSecurityException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		SimpleMailMessage message = new SimpleMailMessage();
		code = "パスワード再設定用の確認コードは「" + code + "」です。"
				 + "\r\n"
				 + "他人には教えないで下さい。30分間有効です。";
        message.setFrom(sender);
        message.setTo(mail);
        //主題
        message.setSubject("BEEWORKからのパスワード再設定用の確認コード");
        message.setText(code);
        mailSender.send(message);

		return false;
	}


}
