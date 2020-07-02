package hypochain.ruleset;

import hypochain.ruleBase;

public class EqualSign extends ruleBase {

    private String url;
    private boolean hypothesis = false;

    public boolean isHypothesis() {
        return hypothesis;
    }
    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }

    public EqualSign(String url) {
        super(url);
        this.url = url;
    }


    public void rule() {
        char[] c;
        c = url.toCharArray(); // url�� char ���ڷ� ��ȯ

        for (int i = 0; i < c.length; i++) {
            if (c[i] == '=') {
                setHypothesis(true);
            }
        }
    }
}
