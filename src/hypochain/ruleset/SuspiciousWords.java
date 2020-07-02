package hypochain.ruleset;

import hypochain.ruleBase;

public class SuspiciousWords extends ruleBase {
    //���Ⱑ '�ù�'�ܾ� ���� Ŭ������

    private String html;
    private boolean hypothesis = false;

    public SuspiciousWords(String html) {
        super(html);
        this.html = html;
    }

    public void rule(){

        if(html.contains("�ù�")||html.contains("����")||html.contains("���Ƚ±�")){
            setHypothesis(true);
        }

        //todo '���Ƚ±�'�����Ͽ� ����ī�� �Է� ��Ÿ���� �� ��Ģ �߰��ؼ� ��ü������ ����

    }

    public boolean isHypothesis() {
        return hypothesis;
    }
    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }
}
