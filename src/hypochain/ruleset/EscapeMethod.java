package hypochain.ruleset;

import hypochain.ruleBase;

public class EscapeMethod extends ruleBase {

    private String html;
    private boolean hypothesis = false;

    public EscapeMethod(String html) {
        super(html);
        this.html = html;
    }

    public void rule(){

        if(html.contains("escape()")){
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