package hypochain.ruleset;

import hypochain.ruleBase;

public class LengthOfDoc extends ruleBase {

    private String html;
    private boolean hypothesis = false;

    public LengthOfDoc(String html) {
        super(html);
        this.html = html;
    }

    public void rule(){

        String checkDocument = html;
        char [] d ; // null �� �ʱ�ȭ
        d = checkDocument.toCharArray(); // htmldocument ���ڿ��� char �迭�� ����

        // Document length
        if(d.length>100){ // 100�� ���� ��
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
