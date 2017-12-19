package collections;

import java.util.List;

public class LoyPromoBeanTreeNode extends LoyPromoBean {
	
    private List<LoyPromoBean> criteriaList;
    private List<LoyPromoBean> actionList;


    public void setCriteriaList(List<LoyPromoBean> criteriaList) {
        this.criteriaList = criteriaList;
    }

    public List<LoyPromoBean> getCriteriaList() {
        return criteriaList;
    }

    public void setActionList(List<LoyPromoBean> actionList) {
        this.actionList = actionList;
    }

    public List<LoyPromoBean> getActionList() {
        return actionList;
    }
    
}
