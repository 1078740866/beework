package Ansin.web.entity;


import java.util.List;


public class B0301ListEntity {
	
		private List<B0301Entity> b0301Entity;
		
		private List<SkillJobtypeIndustryUnitEntity> skillJobtypeIndustryUnitEntity;
		
		private List<LanMstEntity> lanMstEntity;
		
		private int b0301Count;

		public List<B0301Entity> getB0301Entity() {
			return b0301Entity;
		}

		public void setB0301Entity(List<B0301Entity> b0301Entity) {
			this.b0301Entity = b0301Entity;
		}

		public int getB0301Count() {
			return b0301Count;
		}

		public void setB0301Count(int b0301Count) {
			this.b0301Count = b0301Count;
		}

		public List<SkillJobtypeIndustryUnitEntity> getSkillJobtypeIndustryUnitEntity() {
			return skillJobtypeIndustryUnitEntity;
		}

		public void setSkillJobtypeIndustryUnitEntity(List<SkillJobtypeIndustryUnitEntity> skillJobtypeIndustryUnitEntity) {
			this.skillJobtypeIndustryUnitEntity = skillJobtypeIndustryUnitEntity;
		}

		public List<LanMstEntity> getLanMstEntity() {
			return lanMstEntity;
		}

		public void setLanMstEntity(List<LanMstEntity> lanMstEntity) {
			this.lanMstEntity = lanMstEntity;
		}
		

}
