package Ansin.web.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import Ansin.web.entity.TestGoods2Entity;
import Ansin.web.vueForm.G01VueForm;


@Mapper
public interface TestGoods2Mapper {
	/**
	 * 
	 * @param g01VueForm
	 * @return
	 */
	 List<TestGoods2Entity> getAllGoods2();
}
