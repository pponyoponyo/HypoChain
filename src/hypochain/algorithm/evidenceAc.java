package hypochain.algorithm;

import hypochain.ruleset.*;

public class evidenceAc {
	
	private ATag aTag;
	private AtMark atMark;
	private BackSlash backSlash; 
	private Bitly bitly;
	private CharCodeAtMethod charCodeAtMethod;
	private ContainDigits containDigits;
	private Dot dot;
	private EqualSign equalSign;
	private EscapeMethod escapeMethod;
	private EvalMethod evalMethod;
	private FromCharCodeMethod fromCharCodeMethod;
	private HiddenTag hiddenTag;
	private Hypen hypen;
	private IframeTag iframeTag;
	private LengthOfDoc lengthOfDoc;
	private LengthOfURL lengthOfURL;
	private NumberOfLines numberOfLines;
	private ParseIntMethod parseIntMethod;
	private SemiColon semiColon;
	private SuspiciousWords suspiciousWords;
	private Tld tld;
	private UnequalHtmlTag unequalHtmlTag;
	private WindowOpenMethod windowOpenMethod;
	
	private int JavaMethodNum=0; // JavaMethod ī���� ����
	private int SpecialCharacterNum=0; // URL �ּ� ���� Ư������ ī���� ���� 
	
	
	public evidenceAc(String url, String html){
		
		aTag = new ATag(html);
		atMark = new AtMark(url);
		backSlash = new BackSlash(url);
		bitly = new Bitly(url);
		charCodeAtMethod = new CharCodeAtMethod(html);
		containDigits = new ContainDigits(url);
		dot = new Dot(url);
		equalSign = new EqualSign(url);
		escapeMethod = new EscapeMethod(html);
		evalMethod = new EvalMethod(html);
		fromCharCodeMethod = new FromCharCodeMethod(html);
		hiddenTag = new HiddenTag(html);
		hypen = new Hypen(url);
		iframeTag = new IframeTag(html);
		lengthOfDoc = new LengthOfDoc(html);
		lengthOfURL = new LengthOfURL(url);
		numberOfLines = new NumberOfLines(html);
		parseIntMethod = new ParseIntMethod(html);
		semiColon = new SemiColon(url);
		suspiciousWords = new SuspiciousWords(html);
		tld = new Tld(url);
		unequalHtmlTag = new UnequalHtmlTag(html);
		windowOpenMethod = new WindowOpenMethod(html);
		
		aTag.rule();
		atMark.rule();
		backSlash.rule();		
		bitly.rule();
		charCodeAtMethod.rule();
		containDigits.rule();
		dot.rule();
		equalSign.rule();
		escapeMethod.rule();
		evalMethod.rule();
		fromCharCodeMethod.rule();
		hiddenTag.rule();
		hypen.rule();
		iframeTag.rule();
		lengthOfDoc.rule();
		lengthOfURL.rule();
		numberOfLines.rule();
		parseIntMethod.rule();
		semiColon.rule();
		suspiciousWords.rule();
		tld.rule();
		unequalHtmlTag.rule();
		windowOpenMethod.rule();
	}
	
	public boolean upperAuthority(){
        if(backSlash.isHypothesis() && lengthOfURL.isHypothesis()){
            if(dot.isHypothesis()){
                //���� ���� Ż�� ���ɼ�
                return true;
            }
        }
        return false;
    }

    public boolean ChinaTld(){
        if(tld.isCn_hypothesis()){
            // �߱��� ��ġ�� TLD
            return true;
        }
        return false;
    }

    public boolean RussiaTld(){
        if(tld.isRu_hypothesis()){
            // ���þƿ� ��ġ�� TLD
            return true;
        }
        return false;
    }

    public boolean javaExe(){
    	 //������ java script ���� ���ɼ�
        if(evalMethod.isHypothesis()) {
        	JavaMethodNum++;
        }
        if(windowOpenMethod.isHypothesis()) {
        	JavaMethodNum++;
        }
        if(charCodeAtMethod.isHypothesis()) {
        	JavaMethodNum++;
        }
        if(escapeMethod.isHypothesis()) {
        	JavaMethodNum++;
        }
        if(fromCharCodeMethod.isHypothesis()) {
        	JavaMethodNum++;
        }
        if(parseIntMethod.isHypothesis()) {
        	JavaMethodNum++;
        }
       
        if(JavaMethodNum>=1) {
        	return true;
        }
        return false;
    }
    
    
    public boolean fastPage(){
        if((numberOfLines.isHypothesis()||lengthOfDoc.isHypothesis())&&suspiciousWords.isHypothesis()){
            //������ ������� �ǽ� ������
            return true;
        }
        return false;
    }


    // ��ü�� ���� �߰�
    public boolean SmishingUrl(){
        if(bitly.isHypothesis()&&suspiciousWords.isHypothesis()){
            // ���� url + '�ù�' �ܾ�
            return true;
        }
        return false;
    }

    public boolean IPUrl(){
        if(dot.isHypothesis()&&containDigits.isHypothesis()){
            // IP�ּҰ� URL�� �����ϴ� ���
            return true;

        }
        return false;
    }

    public boolean linkPossibility(){
        if(aTag.isHypothesis()&&iframeTag.isHypothesis()){
            // iframe�ȿ� a�±׸� ���� ��ũ �����ϴ� ���
            return  true;
        }
        return false;
    }

    public boolean tagExist(){
        if(iframeTag.isHypothesis()&&hiddenTag.isHypothesis()&&unequalHtmlTag.isHypothesis()){
            // �ǽɽ����� �±׵��� ������ ���
            return true;
        }
        return false;
    }
    
    // 20.03.04 �߰� 
    
    public boolean SpecialCharacter() {
    	
    	if(atMark.isHypothesis()) {
    		SpecialCharacterNum++;
    	}
    	if(equalSign.isHypothesis()) {
    		
    		SpecialCharacterNum++;
    }
    	if(hypen.isHypothesis()) {
    		SpecialCharacterNum++;
    	}
    	if(semiColon.isHypothesis()) {
    		SpecialCharacterNum++;
    	}
    	
    	if(SpecialCharacterNum>=1) {
    		
    		return true;
    	}
    	
		return false;
 }

}