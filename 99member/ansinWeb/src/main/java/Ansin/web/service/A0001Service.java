package Ansin.web.service;

import Ansin.web.entity.UserTblEntity;
import Ansin.web.vueForm.A0001VueForm;

public interface A0001Service {

	// 登録チェック用
	UserTblEntity loginCheck(A0001VueForm a0001VueForm);
}
