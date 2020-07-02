package hypochain.ruleset;

import hypochain.ruleBase;

public class CharCodeAtMethod extends ruleBase {

    private String html;
    private boolean hypothesis = false;

    public CharCodeAtMethod(String html) {
        super(html);
        this.html = html;
    }

    public void rule(){

        if(html.contains("CharCodeAt()")){
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
