package hypochain.ruleset;

import hypochain.ruleBase;

public class Bitly  extends ruleBase {

    private String url;
    private boolean hypothesis = false;

    public boolean isHypothesis() {
        return hypothesis;
    }
    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }

    public Bitly(String url) {
    	super(url);
        this.url = url;
    }

    // ����� ���� url ���� Ŭ������
    public void rule(){
        if(url.contains("bit.ly")){
           setHypothesis(true);
        }
    }
}
