package Ansin.web.serviceimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.BriefingInfoTblBean;
import Ansin.web.mapper.AdAddressMstMapper;
import Ansin.web.mapper.BriefingTblMapper;
import Ansin.web.service.B0602Service;
import Ansin.web.vueForm.B0602VueForm;

@Service
public class IB0602ServiceImpl implements B0602Service{

	@Autowired
	private BriefingTblMapper briefingTblMapper;
	@Autowired
	private AdAddressMstMapper adAddressMstMapper;

	/**
	 *都道府県と所属市区町村を取得
	 */
	@Override
	public List<String> getPostaOne(String postal) {
		List<String> str = adAddressMstMapper.getOne(postal);
 		return str;
	}
	
	/**
	 *都道府県を取得
	 */
	@Override
	public String getPrefeNm(String postal) {
		String str = adAddressMstMapper.getPrefeNm(postal);
 		return str;
	}
	
	/**
	 * 説明会情報を追加する
	 * @param briefingEntity
	 * @return int
	 */
	@Override
	public int insert(B0602VueForm briefingEntity) {
		return briefingTblMapper.prefecturesCityInsert(briefingEntity);
	}

	/**
	 * 説明会情報を更新する
	 * @param briefingEntity
	 * @return int
	 */
	@Override
	public int update(B0602VueForm briefingEntity) {
		return briefingTblMapper.prefecturesCityUpdate(briefingEntity);
	}

	@Override
	public BriefingInfoTblBean confirmOutput(BriefingInfoTblBean briefingInfoTblBean) throws IOException {
		// TODO Auto-generated method stub
		BriefingInfoTblBean briefingInfoTblBeanOutput;
		
		briefingInfoTblBeanOutput = briefingInfoTblBean;

		// 写真を取得
		String adress = briefingInfoTblBeanOutput.getPhotoAddress1();//写真アドレス
		FileInputStream is = null;  
		File filePic = new File(adress);
		try {
			is = new FileInputStream(filePic);
		} catch (FileNotFoundException e) {
			 e.printStackTrace();
		}
		if (is != null){
			int i = is.available(); // ファイルサイズ
		    byte data[] = new byte[i];  
		    is.read(data); //データ読込 
		    is.close();  
		    briefingInfoTblBeanOutput.setPhotoAddress1Pic(data);
		}
		return briefingInfoTblBeanOutput;
	}

}
