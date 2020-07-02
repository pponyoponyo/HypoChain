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

    // 여기는 단축 url 관련 클래스임
    public void rule(){
        if(url.contains("bit.ly")){
           setHypothesis(true);
        }
    }
}
