package hypochain.ruleset;

import hypochain.ruleBase;

public class NumberOfLines extends ruleBase {

    private String html;
    private boolean hypothesis = false;

    public NumberOfLines(String html) {
        super(html);
        this.html = html;
    }

    public void rule() {

        int brNum = 0;

        // Number of lines <br> tag
        String[] checklines = html.split("<");
        for (int j = 0; j < checklines.length; j++) {
            if (checklines[j].contains("br>")) {
                brNum++;
            }
        }

        if(brNum>10){ // br �±װ� ī���� �� ��� return true �Ѵ�! ������ ���� ����
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
