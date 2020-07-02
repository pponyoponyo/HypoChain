package hypochain.ruleset;

import hypochain.ruleBase;

public class WindowOpenMethod extends ruleBase {

    private String html;
    private boolean hypothesis = false;

    public WindowOpenMethod(String html) {
        super(html);
        this.html = html;
    }

    public void rule(){
        if(html.contains("window.open()")){
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