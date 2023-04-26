import java.util.List;

import org.snu.ids.kkma.ma.MExpression;
import org.snu.ids.kkma.ma.MorphemeAnalyzer;
import org.snu.ids.kkma.ma.Sentence;

public class Week8 {

	public static void main(String[] args) {
		
		try {
            MorphemeAnalyzer ma = new MorphemeAnalyzer();	// 분석기 객체 생성 (준비에 시간 걸림)
            ma.createLogger(null);                             					// 분석기 로거 준비          
    		System.out.println("준비 완료");
        	
            String str = "안녕하세요. 경북대학교 컴퓨터학부 OOO 입니다.";
        	List<MExpression> ret = ma.analyze(str);              // 3개 라인을 통해 후처리까지 진행  
            ret = ma.postProcess(ret);
            ret = ma.leaveJustBest(ret);
            List<Sentence> stl = ma.divideToSentences(ret);	// 문장 단위로 분리
            for( int i = 0; i < stl.size(); i++ ) {	// 각 문장에 대해 루프 돌기
                  Sentence st = stl.get(i);
                  System.out.println("=============================================  " + st.getSentence());
                  for( int j = 0; j < st.size(); j++ ) {	// 각 문장에 포함된 형태소 각각 출력                        	  
                        //System.out.println(st.get(j));
                        String tmp = st.get(j).toString(); 
                        int left_bracket = tmp.indexOf("[");
                        int right_bracket = tmp.indexOf("]",left_bracket+1);
                        //System.out.println(tmp + ", " + left_bracket + "," + right_bracket);
                        String within_bracket = tmp.substring(left_bracket+1, right_bracket);
                        //System.out.println(within_bracket);
                        String[] tokens = within_bracket.split("\\+");
                        //for(int k=0;k<tokens.length;k++) System.out.println(tokens[k]);
                        for(int k=0;k<tokens.length;k++) {
                        	String[] elements = tokens[k].split("/");
                        	//for(int l=0;l<elements.length;l++) System.out.println(elements[l]);
                        	if (elements[2].startsWith("NN")) System.out.println(elements[1] + "," + elements[2]);
                        }
                        //if (st.get(j).))
                  }
            }            
            ma.closeLogger();
            
      } catch (Exception e) {
            e.printStackTrace();
      }
	}

}
