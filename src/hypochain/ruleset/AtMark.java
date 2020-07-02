package hypochain.ruleset;

import hypochain.ruleBase;

public class AtMark extends ruleBase {

    private String url;
    private boolean hypothesis = false;

    public boolean isHypothesis() {
        return hypothesis;
    }

    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }

    public AtMark(String url) {
        super(url);
        this.url = url;
    }

    public void rule(){
        char [] c ;
        c = url.toCharArray();

        for(int i=0; i<c.length; i++){
            if(c[i]=='@'){ // 존재만 하면 바로 피싱 사이트임 ( 예원 논문 출처)
                setHypothesis(true);
            }
        }

    }
}