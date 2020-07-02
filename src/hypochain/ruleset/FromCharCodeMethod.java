package hypochain.ruleset;

import hypochain.ruleBase;

public class FromCharCodeMethod extends ruleBase {

    private String html;
    private boolean hypothesis = false;

    public FromCharCodeMethod(String html) {
        super(html);
        this.html = html;
    }

    public void rule(){

        if(html.contains("fromCharCode()")){
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
