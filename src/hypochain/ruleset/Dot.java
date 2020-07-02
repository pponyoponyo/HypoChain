package hypochain.ruleset;

import hypochain.ruleBase;

public class Dot extends ruleBase {

    private String url;
    private boolean hypothesis = false;

    public Dot(String url) {
        super(url);
        this.url = url;
    }

    public boolean isHypothesis() {
        return hypothesis;
    }
    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }


    public void rule(){
        char [] c ;
        c = url.toCharArray();
        int dotNum=0;


        for(int i=0; i<c.length-1; i++){
           /* if(c[i]=='.'&&c[i+1]=='.'){
                setHypothesis(true);
            } �̰͵� �ٵ� �´� �ƶ��̱�� ��. �Ʒ��� �� ��ó�� ���� �������� ���߱� ���� ������ ���*/
           if(c[i]=='.'){
               dotNum++;
           }
        }

        if(dotNum>2){
            setHypothesis(true); // ���� ���� ����
        }
    }
}