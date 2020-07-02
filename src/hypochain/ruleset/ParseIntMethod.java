package hypochain.ruleset;

import hypochain.ruleBase;

public class ParseIntMethod extends ruleBase {

    private String html;
    private boolean hypothesis = false;

    public ParseIntMethod(String html) {
        super(html);
        this.html = html;
    }

    public void rule(){

        if(html.contains("parseInt()")){
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
