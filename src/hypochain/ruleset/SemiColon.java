package hypochain.ruleset;

import hypochain.ruleBase;

public class SemiColon extends ruleBase {

    private String url;
    private boolean hypothesis = false;

    public boolean isHypothesis() {
        return hypothesis;
    }
    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }

    public SemiColon(String url) {
        super(url);
        this.url = url;
    }


    public void rule(){
        char [] c ;
        c = url.toCharArray(); // url을 char 문자로 변환

        for(int i=0; i<c.length; i++){
            if(c[i]==';'){
                setHypothesis(true);
            }
        }

    }
}
