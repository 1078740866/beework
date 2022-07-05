package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.BriefingInfoTblBean;
import Ansin.web.entity.BriefingInfoTblEntity;
import Ansin.web.mapper.BriefingApplTblMapper;
import Ansin.web.mapper.BriefingTblMapper;
import Ansin.web.service.A020203Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.A020203VueForm;

@Service
public class IA020203ServiceImpl implements A020203Service {

    @Autowired
    private BriefingTblMapper briefingTblMapper;
    @Autowired
    private BriefingApplTblMapper briefingApplTblMapper;

    /**
     * 説明会情報表示
     * 
     * @return List<BriefingApplTblEntity>
     */
    @Override
    public List<BriefingInfoTblBean> getBriefingInfoEntities(A020203VueForm a020203VueForm) {
    	List<BriefingInfoTblEntity> briefingInfoTblEntity = briefingTblMapper.getBrie(a020203VueForm);
    	List<BriefingInfoTblBean> briefingInfoTblBean = new ArrayList<BriefingInfoTblBean>();
    	for (BriefingInfoTblEntity BriefingInfo : briefingInfoTblEntity) {
    		BriefingInfoTblBean Bean = new BriefingInfoTblBean();
    		BeanUtils.copyProperties(BriefingInfo, Bean);
    		Bean.setBriefingId(EditUtil.intUtil(BriefingInfo.getBriefingId()));
    		Bean.setCompanyId(EditUtil.intUtil(BriefingInfo.getCompanyId()));
    		Bean.setBriefingDate(EditUtil.dateUtil(BriefingInfo.getBriefingDate()));
    		Bean.setDateFrom(EditUtil.timeUtil(BriefingInfo.getDateFrom()));
    		Bean.setDateTo(EditUtil.timeUtil(BriefingInfo.getDateTo()));
    		Bean.setProCntPlan(EditUtil.intUtil(BriefingInfo.getProCntPlan()));
    		briefingInfoTblBean.add(Bean);
		}
    	
        return briefingInfoTblBean;
    }

    /**
     * 説明会情報を削除
     * 
     * @return int
     */
    @Override
    public int delBriefingInfoEntities(List<Integer> BriefingIds, Integer applicantId, Integer userCd) {

        return briefingApplTblMapper.deleteBrie(BriefingIds, applicantId, userCd);

    }

}
