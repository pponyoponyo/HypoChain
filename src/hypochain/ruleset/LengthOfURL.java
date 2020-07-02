package hypochain.ruleset;

import hypochain.ruleBase;

public class LengthOfURL extends ruleBase {

    private String url;
    private boolean hypothesis = false;

    public LengthOfURL(String url) {
        super(url);
        this.url = url;
    }

    public void rule(){

        String checkDot = url;
        char [] c ; // null �� �ʱ�ȭ
        c = checkDot.toCharArray(); // ���ڿ��� char �迭�� ����

        //Length of URL (���̰��� ������)
        if(c.length>10){
            setHypothesis(true);
        }
    }

    public boolean isHypothesis() {
        return hypothesis;
    }
    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }
}
