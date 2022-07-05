package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.A0802ListEntity;
import Ansin.web.entity.B0003UserEntity;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.vueForm.A0001VueForm;
import Ansin.web.vueForm.A0301VueForm;
import Ansin.web.vueForm.A070101VueForm;
import Ansin.web.vueForm.A0802VueForm;
import Ansin.web.vueForm.A0902VueForm;

@Mapper
public interface UserTblMapper {

	// ユーザー登録用(システム管理者)
	UserTblEntity loginA(@Param("a0001VueForm") A0001VueForm a0001VueForm);

	// ユーザー登録用(会社員)
	UserTblEntity loginB(@Param("a0001VueForm") A0001VueForm a0001VueForm);

	// ユーザー登録用（応募者）
	UserTblEntity loginC(@Param("a0001VueForm") A0001VueForm a0001VueForm);

	// ユーザー新規用
	int insertUserInfo(UserTblEntity userEntity);

	// ユーザー情報
	B0003UserEntity getUserInfo(@Param("companyId") Integer companyId, @Param("userCd") Integer userCd);

	// すべてユーザー取得
	List<UserTblEntity> getUserInfoAll();

	// ユーザーメールチェック用
	Integer userEmailCheck(@Param("userMail") String mail);

	// ユーザー情報
	UserTblEntity getUserInfoBymail(@Param("mail") String userCd);

	UserTblEntity getUserInfoByUserCd(@Param("userCd") Integer userCd);

	// すべて管理者ユーザー取得
	List<UserTblEntity> getUserList(@Param("a0301VueForm") A0301VueForm a0301VueForm);

	// ユーザー使用状態変更
	Integer changeUse(@Param("a0301VueForm") A0301VueForm a0301VueForm);

	// ユーザー削除状態変更
	Integer changeDel(@Param("a0301VueForm") A0301VueForm a0301VueForm);

	// A0802宛先リスト取得
	List<A0802ListEntity> getAddressList(@Param("a0802VueForm") A0802VueForm a0802VueForm);

	UserTblEntity getUserInfoA(@Param("userCd") Integer userCd);

	UserTblEntity getUserInfoB(@Param("userCd") Integer userCd);

	UserTblEntity getUserInfoC(@Param("userCd") Integer userCd);

	// ユーザーパスワード取得
	String getPassword(@Param("userCd") Integer userCd);

	// ユーザー情報更新
	Integer updateUserInfo(@Param("a0002VueForm") UserTblEntity userEntity);

	// ユーザーパスワード更新
	Integer updateUserPwd(@Param("a0902VueForm") A0902VueForm a0902VueForm, @Param("userCd") Integer userCd);

	// B0805未認証ユーザー取得
	List<UserTblEntity> getEmployeeAll(@Param("companyId") Integer companyId,
			@Param("a070101VueForm") A070101VueForm a070101VueForm);

	// すべて未認証ユーザー取得
	List<UserTblEntity> getCheckAll(@Param("a070101VueForm") A070101VueForm a070101VueForm);

	// A070101未認証ユーザーから単数承認または複数承認
	Integer updateUserStatusA(@Param("userCdList") List<Integer> userCdList, @Param("userCd") Integer userCd);

	// A070101未認証ユーザーから単数承認または複数承認
	Integer updateUserStatusB(@Param("userCdList") List<Integer> userCdList, @Param("userCd") Integer userCd);

	// A070101未認証ユーザーから単数承認または複数承認
	Integer updateUserStatusC(@Param("userCdList") List<Integer> userCdList, @Param("userCd") Integer userCd);

	// A070101未認証ユーザーから単数承認または複数拒否
	Integer rejectUserStatus(@Param("userCdList") List<Integer> userCdList, @Param("userCd") Integer userCd);

	// 姓、名取得
	UserTblEntity getName(@Param("userCd") Integer userCd);

	// ユーザーパスワード更新
	Integer updateUserPwdW(UserTblEntity userEntity);

	// ユーザー状態禁止（通報成功の場合）
	Integer userStatusChange(@Param("userCds") List<Integer> userCds, @Param("userCd") Integer userCd);
}
