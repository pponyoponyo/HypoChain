package hypochain.ruleset;

import hypochain.ruleBase;

public class EvalMethod extends ruleBase {

    private String html;
    private boolean hypothesis = false;

    public EvalMethod(String html) {
        super(html);
        this.html = html;
    }

    public void rule(){

        if(html.contains("eval()")){
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
