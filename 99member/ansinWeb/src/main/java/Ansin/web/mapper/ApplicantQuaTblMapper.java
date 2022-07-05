package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.ApplicantQuaTblEntity;
import Ansin.web.vueForm.C010102VueForm;

@Mapper
public interface ApplicantQuaTblMapper {
	        //C0101応募者の資格リスト
			List<ApplicantQuaTblEntity> getQua(@Param("applicantId") Integer applicantId);
			//C0101応募者の資格を新規
			int quaInsert(@Param("c010102VueForm") C010102VueForm c010102VueForm);
			//C0101応募者の資格を更新
			int quaUpdate(@Param("c010102VueForm") C010102VueForm c010102VueForm);
			//C0101応募者の資格を削除
			int quaDelete(@Param("applicantId") Integer applicantId,@Param("appQuaId") Integer appQuaId,@Param("userCd") Integer userCd);
}
